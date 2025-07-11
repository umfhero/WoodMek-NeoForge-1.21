package net.umf.woodmek.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.umf.woodmek.BlockMod;

import javax.annotation.ParametersAreNonnullByDefault;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.effect.MobEffects;

//Thor hammer (i guess im going superhero themed now)

@ParametersAreNonnullByDefault
public class ShieldEffect extends MobEffect {
    private static final ResourceLocation SHIELD_SPEED_ID =
            ResourceLocation.fromNamespaceAndPath(BlockMod.MOD_ID, "shield_speed");
    private static final AttributeModifier SHIELD_SPEED_MODIFIER = new AttributeModifier(
            SHIELD_SPEED_ID,
            10.0,
            AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);

    public ShieldEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        var movementSpeedAttribute = livingEntity.getAttribute(Attributes.MOVEMENT_SPEED);
        if (movementSpeedAttribute != null) {
            ItemStack heldItem = livingEntity.getMainHandItem();
            if (heldItem.is(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(BlockMod.MOD_ID,
                    "hardwood_hammer")))) {
                if (!movementSpeedAttribute.hasModifier(SHIELD_SPEED_ID)) {
                    movementSpeedAttribute.addTransientModifier(SHIELD_SPEED_MODIFIER);
                }

                // fire resistance and invic to dmg
                livingEntity.addEffect(new net.minecraft.world.effect.MobEffectInstance(MobEffects.FIRE_RESISTANCE, 20, 0, false, false));
                livingEntity.addEffect(new net.minecraft.world.effect.MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20, 4, false, false));
                livingEntity.addEffect(new net.minecraft.world.effect.MobEffectInstance(MobEffects.GLOWING, 20, 4, false, false));
                livingEntity.addEffect(new net.minecraft.world.effect.MobEffectInstance(MobEffects.REGENERATION, 20, 4, false, false));

                // HP up
                if (livingEntity.getHealth() < livingEntity.getMaxHealth()) {
                    livingEntity.setHealth(Math.min(livingEntity.getMaxHealth(), livingEntity.getHealth() + 0.5F));
                }

                // mobs hit w lightning
                livingEntity.getCommandSenderWorld().getEntities(livingEntity, livingEntity.getBoundingBox().inflate(1.0),
                        entity -> entity instanceof net.minecraft.world.entity.Mob).forEach(entity -> {
                    Level level = livingEntity.getCommandSenderWorld();
                    Entity lightningBolt = net.minecraft.world.entity.EntityType.LIGHTNING_BOLT.create(level);
                    if (lightningBolt != null) {
                        lightningBolt.moveTo(entity.getX(), entity.getY(), entity.getZ());
                        level.addFreshEntity(lightningBolt);
                    }
                });
            } else {
                if (movementSpeedAttribute.hasModifier(SHIELD_SPEED_ID)) {
                    movementSpeedAttribute.removeModifier(SHIELD_SPEED_ID);
                }
            }
        }
        return true;
    }

    @Override
    public void removeAttributeModifiers(net.minecraft.world.entity.ai.attributes.AttributeMap attributeMap) {
        super.removeAttributeModifiers(attributeMap);
        var movementSpeedInstance = attributeMap.getInstance(Attributes.MOVEMENT_SPEED);
        if (movementSpeedInstance != null) {
            movementSpeedInstance.removeModifier(SHIELD_SPEED_ID);
        }
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}
