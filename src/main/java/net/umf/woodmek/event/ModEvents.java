package net.umf.woodmek.event;

import net.neoforged.fml.common.EventBusSubscriber;
import net.umf.woodmek.BlockMod;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.umf.woodmek.item.custom.HammerItem;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@EventBusSubscriber(modid = BlockMod.MOD_ID, bus = EventBusSubscriber.Bus.GAME)

public class ModEvents {

    private static final Set<BlockPos> HARVESTED_BLOCKS = new HashSet<>();

    // Done with the help of https://github.com/Tutorials-By-Kaupenjoe/NeoForge-Tutorial-1.21.X/blob/16-hammerTool/src/main/java/net/kaupenjoe/tutorialmod/event/ModEvents.java
    // Don't be a jerk License

    @SubscribeEvent
    public static void onHammerUsage(BlockEvent.BreakEvent event) {
        Player player = event.getPlayer();
        ItemStack mainHandItem = player.getMainHandItem();

        if(mainHandItem.getItem() instanceof HammerItem hammer && player instanceof ServerPlayer serverPlayer) {
            BlockPos initialBlockPos = event.getPos();
            if(HARVESTED_BLOCKS.contains(initialBlockPos)) {
                return;
            }

            // Get all blocks to be destroyed
            List<BlockPos> blocksToDestroy = HammerItem.getBlocksToBeDestroyed(1, initialBlockPos, serverPlayer);

            // Apply only 9 durability total for the entire mining operation (not per block)
            if(blocksToDestroy.size() > 0) {
                mainHandItem.hurtAndBreak(9, serverPlayer, net.minecraft.world.entity.EquipmentSlot.MAINHAND);
            }

            for(BlockPos pos : blocksToDestroy) {
                if(pos == initialBlockPos || !hammer.isCorrectToolForDrops(mainHandItem, event.getLevel().getBlockState(pos))) {
                    continue;
                }

                //anti loop mining
                HARVESTED_BLOCKS.add(pos);
                serverPlayer.gameMode.destroyBlock(pos);
                HARVESTED_BLOCKS.remove(pos);
            }
        }
    }

}
