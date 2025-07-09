package net.umf.woodmek.effect;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.umf.woodmek.BlockMod;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(BuiltInRegistries.MOB_EFFECT,
            BlockMod.MOD_ID);

    public static final Holder<MobEffect> SPIDER_EFFECT = MOB_EFFECTS.register("spider",
            () -> new SpiderEffect(MobEffectCategory.NEUTRAL, 0x1a001f)
                    .addAttributeModifier(Attributes.MOVEMENT_SPEED,
                            ResourceLocation.fromNamespaceAndPath(BlockMod.MOD_ID, "spider"), -0.25F,
                            AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

    public static final Holder<MobEffect> SHIELD_EFFECT = MOB_EFFECTS.register("shield",
            () -> new ShieldEffect(MobEffectCategory.NEUTRAL, 0x1a001f));




    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
