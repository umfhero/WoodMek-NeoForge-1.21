package net.umf.woodmek.sound;

import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.util.DeferredSoundType;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.umf.woodmek.BlockMod;

import java.util.function.Supplier;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, BlockMod.MOD_ID);


    public static final Supplier<SoundEvent> FLARE_GUN_SHOT = registerSoundEvent("flare_gun_shot");
    public static final Supplier<SoundEvent> HARDWOOD_SWORD = registerSoundEvent("hardwood_sword");

    public static final Supplier<SoundEvent> TRANSFORMER_BREAK = registerSoundEvent("transformer_break");
    public static final Supplier<SoundEvent> TRANSFORMER_STEP = registerSoundEvent("transformer_step");
    public static final Supplier<SoundEvent> TRANSFORMER_PLACE = registerSoundEvent("transformer_place");
    public static final Supplier<SoundEvent> TRANSFORMER_HIT = registerSoundEvent("transformer_hit");
    public static final Supplier<SoundEvent> TRANSFORMER_FALL = registerSoundEvent("transformer_fall");


    public static final DeferredSoundType TRANSFORMER_SOUNDS = new DeferredSoundType(1f, 1f,
            ModSounds.TRANSFORMER_BREAK, ModSounds.TRANSFORMER_STEP, ModSounds.TRANSFORMER_PLACE,
            ModSounds.TRANSFORMER_HIT, ModSounds.TRANSFORMER_FALL);

    private static Supplier<SoundEvent> registerSoundEvent(String name) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(BlockMod.MOD_ID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }





    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
