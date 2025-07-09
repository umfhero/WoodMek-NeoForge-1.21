package net.umf.woodmek.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.resources.ResourceLocation;
import net.umf.woodmek.BlockMod;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class ShieldEffect extends MobEffect {
    private static final ResourceLocation SHIELD_SPEED_ID = ResourceLocation.fromNamespaceAndPath(BlockMod.MOD_ID, "shield_speed");
    private static final AttributeModifier SHIELD_SPEED_MODIFIER = new AttributeModifier(
            SHIELD_SPEED_ID,
            100.0,
            AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);

    protected ShieldEffect(MobEffectCategory category, int color) {
        super(category, color);
    }


    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        var movementSpeedAttribute = livingEntity.getAttribute(Attributes.MOVEMENT_SPEED);
        if (movementSpeedAttribute != null) {
            if (livingEntity.isBlocking()) {
                if (!movementSpeedAttribute.hasModifier(SHIELD_SPEED_ID)) {
                    movementSpeedAttribute.addTransientModifier(SHIELD_SPEED_MODIFIER);
                }
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
