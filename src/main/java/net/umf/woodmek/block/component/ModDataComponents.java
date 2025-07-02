package net.umf.woodmek.block.component;


import com.mojang.serialization.Codec;
import net.minecraft.core.component.DataComponentType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.umf.woodmek.BlockMod;

import java.util.function.UnaryOperator;

public class ModDataComponents {
    public static final DeferredRegister<DataComponentType<?>> DATA_COMPONENT_TYPES =
            DeferredRegister.createDataComponents(BlockMod.MOD_ID);

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Boolean>> USED = register("used",
            builder -> builder.persistent(Codec.BOOL));

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Long>> USED_TIMESTAMP = register("used_timestamp",
            builder -> builder.persistent(Codec.LONG));


    private static <T>DeferredHolder<DataComponentType<?>, DataComponentType<T>> register(String name,
                                                                                          UnaryOperator<DataComponentType.Builder<T>> builderOperator) {
        return DATA_COMPONENT_TYPES.register(name, () -> builderOperator.apply(DataComponentType.builder()).build());
    }

    public static void register(IEventBus eventBus) {
        DATA_COMPONENT_TYPES.register(eventBus);
    }
}