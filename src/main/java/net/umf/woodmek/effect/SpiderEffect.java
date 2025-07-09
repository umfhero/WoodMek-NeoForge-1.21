package net.umf.woodmek.effect;


import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

// Climbing Effect by SameDifferent: https://github.com/samedifferent/TrickOrTreat/blob/master/LICENSE
// Distributed under MIT
public class SpiderEffect extends MobEffect {


    public SpiderEffect(MobEffectCategory p_19451_, int p_19452_) {
        super(p_19451_, p_19452_);
    }

    @Override
    public boolean applyEffectTick(LivingEntity p_19467_, int p_19468_) {
        return super.applyEffectTick(p_19467_, p_19468_);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int p_295329_, int p_295167_) {
        return super.shouldApplyEffectTickThisTick(p_295329_, p_295167_);
    }
}
