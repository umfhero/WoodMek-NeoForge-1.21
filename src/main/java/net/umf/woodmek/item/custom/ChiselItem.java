package net.umf.woodmek.item.custom;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.umf.woodmek.block.ModBlocks;

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

    public ChiselItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();

        if(CHISEL_MAP.containsKey(clickedBlock)) {
            if(!level.isClientSide()) {
                level.setBlockAndUpdate(context.getClickedPos(), CHISEL_MAP.get(clickedBlock).defaultBlockState());
                level.playSound(null, context.getClickedPos(), SoundEvents.DYE_USE, SoundSource.BLOCKS);
            }
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        if(Screen.hasShiftDown()) {
            tooltipComponents.add(Component.translatable("tooltip.woodmek.shiftchisel.tooltip"));
        } else {
            tooltipComponents.add(Component.translatable("tooltip.woodmek.chisel.tooltip"));
        }
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
