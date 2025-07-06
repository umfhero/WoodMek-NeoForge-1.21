package net.umf.woodmek.event;

import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.animal.Sheep;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.umf.woodmek.BlockMod;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.umf.woodmek.item.ModItems;
import net.umf.woodmek.item.custom.HammerItem;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@EventBusSubscriber(modid = BlockMod.MOD_ID, bus = EventBusSubscriber.Bus.GAME)

public class ModEvents {

    private static final Set<BlockPos> HARVESTED_BLOCKS = new HashSet<>();

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

    @SubscribeEvent
    public static void livingDamage(LivingDamageEvent.Pre event) {
        if (event.getEntity() instanceof Pig pig && event.getSource().getDirectEntity() instanceof Player player) {
            if (player.getMainHandItem().getItem() == ModItems.HARDWOOD_SWORD.get()) {
                player.sendSystemMessage(Component.literal(player.getName().getString() + " hit a pig"));
                pig.addEffect(new MobEffectInstance(MobEffects.GLOWING, 200, 20));
                player.getMainHandItem().shrink(1);
            }
        } else if (event.getEntity() instanceof Sheep sheep && event.getSource().getDirectEntity() instanceof Player player) {
            if (player.getMainHandItem().getItem() == ModItems.HARDWOOD_SWORD.get()) {
                player.sendSystemMessage(Component.literal(player.getName().getString() + " hit a sheep"));
                sheep.addEffect(new MobEffectInstance(MobEffects.GLOWING, 200, 20));
                player.getMainHandItem().grow(3);
            }
        }
    }


}
