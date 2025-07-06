package net.umf.woodmek.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.umf.woodmek.BlockMod;
import net.umf.woodmek.item.custom.ChiselItem;
import net.umf.woodmek.item.custom.FlareGunItem;
import net.umf.woodmek.item.custom.HammerItem;

import java.util.List;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(BlockMod.MOD_ID);


    public static final DeferredItem<Item> WOODSHEET = ITEMS.register("woodsheet",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> HARDWOOD = ITEMS.register("hardwood",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> HARDWOOD_ALLOY = ITEMS.register("hardwood_alloy",
            () -> new Item(new Item.Properties()){
                @Override
                public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.woodmek.hardwood_alloy.tooltip"));

                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });

    public static final DeferredItem<Item> WOOD_DUST = ITEMS.register("wood_dust",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> CHISEL = ITEMS.register("chisel",
            () -> new ChiselItem(new Item.Properties().durability(500)));

    public static final DeferredItem<Item> FLAREGUN = ITEMS.register("flaregun",
            () -> new FlareGunItem(new Item.Properties().durability(100)));


    // Hardwood tool set
    public static final DeferredItem<SwordItem> HARDWOOD_SWORD = ITEMS.register("hardwood_sword",
            () -> new SwordItem(ModToolTiers.HARDWOOD, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.HARDWOOD, 5, 3))));

    public static final DeferredItem<PickaxeItem> HARDWOOD_PICKAXE = ITEMS.register("hardwood_pickaxe",
            () -> new PickaxeItem(ModToolTiers.HARDWOOD, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.HARDWOOD, 3, 3))));

    public static final DeferredItem<AxeItem> HARDWOOD_AXE = ITEMS.register("hardwood_axe",
            () -> new AxeItem(ModToolTiers.HARDWOOD, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.HARDWOOD, 6, 3))));


    public static final DeferredItem<ShovelItem> HARDWOOD_SHOVEL = ITEMS.register("hardwood_shovel",
            () -> new ShovelItem(ModToolTiers.HARDWOOD, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.HARDWOOD, 3, 3))));


    public static final DeferredItem<HoeItem> HARDWOOD_HOE = ITEMS.register("hardwood_hoe",
            () -> new HoeItem(ModToolTiers.HARDWOOD, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.HARDWOOD, 3, 3))));

    // Azalea tool set
    public static final DeferredItem<SwordItem> AZALEA_SWORD = ITEMS.register("azalea_sword",
            () -> new SwordItem(ModToolTiers.AZALEA, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.AZALEA, 6, 3))));

    public static final DeferredItem<PickaxeItem> AZALEA_PICKAXE = ITEMS.register("azalea_pickaxe",
            () -> new PickaxeItem(ModToolTiers.AZALEA, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.AZALEA, 4, 3))));

    public static final DeferredItem<AxeItem> AZALEA_AXE = ITEMS.register("azalea_axe",
            () -> new AxeItem(ModToolTiers.AZALEA, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.AZALEA, 7, 3))));

    public static final DeferredItem<ShovelItem> AZALEA_SHOVEL = ITEMS.register("azalea_shovel",
            () -> new ShovelItem(ModToolTiers.AZALEA, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.AZALEA, 4, 3))));

    public static final DeferredItem<HoeItem> AZALEA_HOE = ITEMS.register("azalea_hoe",
            () -> new HoeItem(ModToolTiers.AZALEA, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.AZALEA, 3, 3))));


    public static final DeferredItem<HammerItem> HARDWOOD_HAMMER = ITEMS.register("hardwood_hammer",
            () -> new HammerItem(ModToolTiers.HARDWOOD, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.HARDWOOD, 3, 3))));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
