package net.umf.woodmek.potion;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.umf.woodmek.BlockMod;
import net.umf.woodmek.effect.ModEffects;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS =
            DeferredRegister.create(BuiltInRegistries.POTION, BlockMod.MOD_ID);

    public static final Holder<Potion> SHIELD_POTION = POTIONS.register("wm_shield_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.SHIELD_EFFECT, 1200, 0)));

    public static final Holder<Potion> SPIDER_POTION = POTIONS.register("wm_spider_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.SPIDER_EFFECT, 1200, 0)));

    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}
