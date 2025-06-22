package net.umf.blockmod.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.umf.blockmod.BlockMod;
import net.umf.blockmod.item.custom.ChiselItem;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(BlockMod.MOD_ID);


    public static final DeferredItem<Item> WOODSHEET = ITEMS.register("woodsheet",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> HARDWOOD = ITEMS.register("hardwood",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> HARDWOOD_ALLOY = ITEMS.register("hardwood_alloy",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> WOOD_DUST = ITEMS.register("wood_dust",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> CHISEL = ITEMS.register("chisel",
            () -> new ChiselItem(new Item.Properties()));









    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
