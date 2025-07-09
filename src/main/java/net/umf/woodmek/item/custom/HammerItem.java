package net.umf.woodmek.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.core.Direction;

import java.util.ArrayList;
import java.util.List;

public class HammerItem extends DiggerItem {
    public HammerItem(Tier tier, Properties properties) {
        // Use an empty tag so the hammer can work on any block type
        super(tier, TagKey.create(net.minecraft.core.registries.Registries.BLOCK,
            net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("woodmek", "empty")), properties);
    }

    // Override to allow the hammer to work on any block
    @Override
    public boolean isCorrectToolForDrops(net.minecraft.world.item.ItemStack stack, BlockState state) {
        return true; // Allow hammer to work on any block
    }

    // Override mining speed to use the tier's speed properly
    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        return this.getTier().getSpeed(); // Use the tier's mining speed directly
    }

    // Override durability to be 576 instead of tier's default
    @Override
    public int getMaxDamage(ItemStack stack) {
        return 576;
    }

    // Override durability damage to only take 9 points per block instead of 10
    @Override
    public boolean hurtEnemy(ItemStack stack, net.minecraft.world.entity.LivingEntity target, net.minecraft.world.entity.LivingEntity attacker) {
        stack.hurtAndBreak(9, attacker, net.minecraft.world.entity.EquipmentSlot.MAINHAND);
        return true;
    }

    @Override
    public boolean mineBlock(ItemStack stack, net.minecraft.world.level.Level level, BlockState state, BlockPos pos, net.minecraft.world.entity.LivingEntity miningEntity) {
        return true;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents,
                                TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.woodmek.hardwood_hammer.tooltip2"));
        tooltipComponents.add(Component.translatable("tooltip.woodmek.hardwood_hammer.tooltip"));
        tooltipComponents.add(Component.translatable("tooltip.woodmek.hardwood_hammer.tooltip3"));
        tooltipComponents.add(Component.translatable("tooltip.woodmek.hardwood_hammer.tooltip4"));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }

    public static List<BlockPos> getBlocksToBeDestroyed(int range, BlockPos initialBlockPos, ServerPlayer player) {
        List<BlockPos> positions = new ArrayList<>();

        BlockHitResult traceResult = player.level().clip(new ClipContext(player.getEyePosition(1f),
                (player.getEyePosition(1f).add(player.getViewVector(1f).scale(6f))),
                ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, player));
        if(traceResult.getType() == HitResult.Type.MISS) {
            return positions;
        }

        // Get the block type that was initially broken
        BlockState targetBlockState = player.level().getBlockState(initialBlockPos);
        Block targetBlock = targetBlockState.getBlock();

        if(traceResult.getDirection() == Direction.DOWN || traceResult.getDirection() == Direction.UP) {
            for(int x = -range; x <= range; x++) {
                for(int z = -range; z <= range; z++) {
                    BlockPos pos = new BlockPos(initialBlockPos.getX() + x, initialBlockPos.getY(), initialBlockPos.getZ() + z);
                    BlockState blockState = player.level().getBlockState(pos);
                    // Only add if it's the same block type
                    if(blockState.getBlock() == targetBlock) {
                        positions.add(pos);
                    }
                }
            }
        }

        if(traceResult.getDirection() == Direction.NORTH || traceResult.getDirection() == Direction.SOUTH) {
            for(int x = -range; x <= range; x++) {
                for(int y = -range; y <= range; y++) {
                    BlockPos pos = new BlockPos(initialBlockPos.getX() + x, initialBlockPos.getY() + y, initialBlockPos.getZ());
                    BlockState blockState = player.level().getBlockState(pos);
                    // Only add if it's the same block type
                    if(blockState.getBlock() == targetBlock) {
                        positions.add(pos);
                    }
                }
            }
        }

        if(traceResult.getDirection() == Direction.EAST || traceResult.getDirection() == Direction.WEST) {
            for(int x = -range; x <= range; x++) {
                for(int y = -range; y <= range; y++) {
                    BlockPos pos = new BlockPos(initialBlockPos.getX(), initialBlockPos.getY() + y, initialBlockPos.getZ() + x);
                    BlockState blockState = player.level().getBlockState(pos);
                    // Only add if it's the same block type
                    if(blockState.getBlock() == targetBlock) {
                        positions.add(pos);
                    }
                }
            }
        }

        return positions;
    }
}
