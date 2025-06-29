package net.umf.woodmek.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.umf.woodmek.BlockMod;
import net.umf.woodmek.block.ModBlocks;
import net.umf.woodmek.item.ModItems;
import net.umf.woodmek.util.ModTags;

import java.util.List;

public class transformer extends Block {


    public transformer(Properties properties) {
        super(properties);
    }


    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {



        level.playSound(player, pos, SoundEvents.BEACON_ACTIVATE, SoundSource.BLOCKS, 1f, 1f);
        return InteractionResult.SUCCESS;
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        if(entity instanceof ItemEntity itemEntity) {
            if(isValidItem(itemEntity.getItem())) {
                itemEntity.setItem(new ItemStack(ModItems.HARDWOOD.get(), itemEntity.getItem().getCount()));
            }
            if(itemEntity.getItem().getItem() == ModItems.WOOD_DUST.get()) {
                itemEntity.setItem(new ItemStack(ModItems.HARDWOOD_ALLOY.get(), itemEntity.getItem().getCount()));
            }
            if(isValidItemConcrete(itemEntity.getItem())) {
                itemEntity.setItem(new ItemStack(ModBlocks.HAZARD_BLOCK.get(), itemEntity.getItem().getCount()));
            }
            if(itemEntity.getItem().getItem() == ModItems.HARDWOOD.get()) {
                itemEntity.setItem(new ItemStack(ModBlocks.HARDWOOD_BLOCK.get(), itemEntity.getItem().getCount()));
            }
        }

        super.stepOn(level, pos, state, entity);
    }

    private boolean isValidItemConcrete(ItemStack item) {
        return item.is(ModTags.Items.TRANSFORMABLE_CONCRETE);
    }


    private boolean isValidItem(ItemStack item) {
        return item.is(ModTags.Items.TRANSFORMABLE_ITEMS);
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.woodmek.transformer_block.tooltip"));

        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
