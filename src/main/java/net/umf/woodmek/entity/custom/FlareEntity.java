package net.umf.woodmek.entity.custom;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.umf.woodmek.item.ModItems;

public class FlareEntity extends ThrowableItemProjectile {
    private static final EntityDataAccessor<Integer> LIFE_TIME = SynchedEntityData.defineId(FlareEntity.class, EntityDataSerializers.INT);
    private int maxLifeTime = 200; // 10 seconds at 20 ticks per second

    public FlareEntity(EntityType<? extends FlareEntity> entityType, Level level) {
        super(entityType, level);
    }

    public FlareEntity(Level level, double x, double y, double z) {
        super(net.umf.woodmek.entity.ModEntities.FLARE.get(), x, y, z, level);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.FLAREGUN.get();
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(LIFE_TIME, 0);
    }

    @Override
    public void tick() {
        super.tick();

        // Increment lifetime
        int currentLifeTime = this.entityData.get(LIFE_TIME);
        this.entityData.set(LIFE_TIME, currentLifeTime + 1);

        // Create particles
        if (this.level().isClientSide) {
            // Red flame particles
            this.level().addParticle(ParticleTypes.FLAME,
                this.getX(), this.getY(), this.getZ(),
                0.0D, 0.0D, 0.0D);

            // Smoke particles
            this.level().addParticle(ParticleTypes.SMOKE,
                this.getX(), this.getY(), this.getZ(),
                (this.random.nextDouble() - 0.5D) * 0.1D,
                0.1D,
                (this.random.nextDouble() - 0.5D) * 0.1D);
        }

        // Remove after max lifetime
        if (currentLifeTime > maxLifeTime) {
            this.discard();
        }
    }

    @Override
    protected void onHit(HitResult hitResult) {
        super.onHit(hitResult);

        if (!this.level().isClientSide) {
            // Create explosion-like particle effect on impact
            this.level().broadcastEntityEvent(this, (byte) 3);
            this.discard();
        }
    }

    @Override
    public void handleEntityEvent(byte id) {
        if (id == 3) {
            // Create burst of particles on impact
            for (int i = 0; i < 8; ++i) {
                this.level().addParticle(ParticleTypes.FLAME,
                    this.getX(), this.getY(), this.getZ(),
                    (this.random.nextDouble() - 0.5D) * 0.2D,
                    this.random.nextDouble() * 0.2D,
                    (this.random.nextDouble() - 0.5D) * 0.2D);
            }
        } else {
            super.handleEntityEvent(id);
        }
    }

    @Override
    public boolean isPickable() {
        return false;
    }
}
