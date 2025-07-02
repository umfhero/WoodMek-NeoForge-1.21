package net.umf.woodmek.item.custom;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.umf.woodmek.block.ModBlocks;
import net.umf.woodmek.block.component.ModDataComponents;

import java.util.List;
import java.util.Map;

public class ChiselItem extends Item {
    private static final Map<Block, Block> CHISEL_MAP =
            Map.ofEntries(
                    Map.entry(Blocks.STONE, Blocks.STONE_BRICKS),
                    Map.entry(Blocks.END_STONE, Blocks.END_STONE_BRICKS),
                    Map.entry(Blocks.DEEPSLATE, Blocks.DEEPSLATE_BRICKS),
                    Map.entry(Blocks.RAW_GOLD_BLOCK, Blocks.GOLD_BLOCK),
                    Map.entry(Blocks.RAW_IRON_BLOCK, Blocks.IRON_BLOCK),
                    Map.entry(Blocks.YELLOW_CONCRETE, ModBlocks.HAZARD_BLOCK.get()),
                    Map.entry(ModBlocks.HAZARD_BLOCK.get(), ModBlocks.HAZARD_BLOCK2.get()),
                    Map.entry(ModBlocks.HAZARD_BLOCK2.get(), ModBlocks.HAZARD_BLOCK.get()),
                    Map.entry(ModBlocks.HALF_HAZARD_BLOCK.get(), ModBlocks.HALF_HAZARD_BLOCK2.get()),
                    Map.entry(ModBlocks.HALF_HAZARD_BLOCK2.get(), ModBlocks.HALF_HAZARD_BLOCK.get()),
                    Map.entry(ModBlocks.HARDWOOD_BRICK_NOHOLE.get(), ModBlocks.HARDWOOD_BRICK_HOLE.get()),
                    Map.entry(ModBlocks.HARDWOOD_BRICK_HOLE.get(), ModBlocks.HARDWOOD_BRICK_NOHOLE.get())
            );

    private static boolean eventRegistered = false;

    public ChiselItem(Properties properties) {
        super(properties);
        // Register the event handler if not already registered
        if (!eventRegistered) {
            NeoForge.EVENT_BUS.addListener(ChiselItem::onPlayerTick);
            eventRegistered = true;
        }
    }

    // Static method to handle player tick events
    public static void onPlayerTick(PlayerTickEvent.Post event) {
        // Check all items in player's inventory
        for (int i = 0; i < event.getEntity().getInventory().getContainerSize(); i++) {
            ItemStack stack = event.getEntity().getInventory().getItem(i);

            if (stack.getItem() instanceof ChiselItem) {
                Long timestamp = stack.get(ModDataComponents.USED_TIMESTAMP);
                Boolean isUsed = stack.get(ModDataComponents.USED);

                if (isUsed != null && isUsed && timestamp != null) {
                    long currentTime = System.currentTimeMillis();
                    long elapsed = currentTime - timestamp;

                    // Check if 5 seconds (5000ms) have passed
                    if (elapsed >= 5000) {
                        // Reset the chisel to unused state
                        stack.set(ModDataComponents.USED, false);
                        stack.remove(ModDataComponents.USED_TIMESTAMP);
                    }
                }
            }
        }
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();

        if(CHISEL_MAP.containsKey(clickedBlock)) {
            if(!level.isClientSide()) {
                level.setBlockAndUpdate(context.getClickedPos(), CHISEL_MAP.get(clickedBlock).defaultBlockState());

                level.playSound(null, context.getClickedPos(), SoundEvents.DYE_USE, SoundSource.BLOCKS);

                // Set the chisel as used and record timestamp
                ItemStack itemStack = context.getItemInHand();
                itemStack.set(ModDataComponents.USED, true);
                itemStack.set(ModDataComponents.USED_TIMESTAMP, System.currentTimeMillis());
            }
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        // Add countdown indicator if chisel is used
        Long timestamp = stack.get(ModDataComponents.USED_TIMESTAMP);
        Boolean isUsed = stack.get(ModDataComponents.USED);

        if (isUsed != null && isUsed && timestamp != null) {
            long currentTime = System.currentTimeMillis();
            long elapsed = currentTime - timestamp;
            long remaining = Math.max(0, 5000 - elapsed);
            double remainingSeconds = remaining / 1000.0;

            tooltipComponents.add(Component.literal("§6Cooldown: " + String.format("%.1f", remainingSeconds) + "s"));
        }

        if(Screen.hasShiftDown()) {
            tooltipComponents.add(Component.translatable("tooltip.woodmek.shiftchisel.tooltip"));
        } else {
            tooltipComponents.add(Component.translatable("tooltip.woodmek.chisel.tooltip"));
        }
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }

    @Override
    public boolean isBarVisible(ItemStack stack) {
        // Show durability bar when chisel is used (has timestamp)
        Long timestamp = stack.get(ModDataComponents.USED_TIMESTAMP);
        return timestamp != null;
    }

    @Override
    public int getBarWidth(ItemStack stack) {
        Long timestamp = stack.get(ModDataComponents.USED_TIMESTAMP);
        if (timestamp == null) {
            return 0;
        }

        long currentTime = System.currentTimeMillis();
        long elapsed = currentTime - timestamp;
        long remaining = Math.max(0, 5000 - elapsed);

        // Convert remaining time to bar width (0-13 pixels)
        return (int) ((remaining / 5000.0) * 13);
    }

    @Override
    public int getBarColor(ItemStack stack) {
        Long timestamp = stack.get(ModDataComponents.USED_TIMESTAMP);
        if (timestamp == null) {
            return 0xFFFFFF; // White fallback
        }

        long currentTime = System.currentTimeMillis();
        long elapsed = currentTime - timestamp;
        long remaining = Math.max(0, 5000 - elapsed);

        // Color gradient from red to green based on remaining time
        double progress = remaining / 5000.0;
        if (progress > 0.6) {
            return 0x00FF00; // Green when plenty of time left
        } else if (progress > 0.3) {
            return 0xFFFF00; // Yellow when halfway
        } else {
            return 0xFF0000; // Red when almost done
        }
    }
}
