package net.umf.woodmek.item.custom;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.umf.woodmek.block.component.ModDataComponents;
import net.umf.woodmek.sound.ModSounds;

import java.util.List;

public class FlareGunItem extends Item {
    private static boolean eventRegistered = false;

    public FlareGunItem(Properties properties) {
        super(properties);

        if (!eventRegistered) {
            NeoForge.EVENT_BUS.addListener(FlareGunItem::onPlayerTick);
            eventRegistered = true;
        }
    }


    public static void onPlayerTick(PlayerTickEvent.Post event) {

        for (int i = 0; i < event.getEntity().getInventory().getContainerSize(); i++) {
            ItemStack stack = event.getEntity().getInventory().getItem(i);

            if (stack.getItem() instanceof FlareGunItem) {
                Long timestamp = stack.get(ModDataComponents.USED_TIMESTAMP);
                Boolean isUsed = stack.get(ModDataComponents.USED);

                if (isUsed != null && isUsed && timestamp != null) {
                    long currentTime = System.currentTimeMillis();
                    long elapsed = currentTime - timestamp;


                    if (elapsed >= 5000) {

                        stack.set(ModDataComponents.USED, false);
                        stack.remove(ModDataComponents.USED_TIMESTAMP);
                    }
                }
            }
        }
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);


        Long timestamp = itemStack.get(ModDataComponents.USED_TIMESTAMP);
        Boolean isUsed = itemStack.get(ModDataComponents.USED);

        if (isUsed != null && isUsed && timestamp != null) {

            level.playSound(null, player.getX(), player.getY(), player.getZ(),
                    ModSounds.FLARE_GUN_LOCK.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
            return InteractionResultHolder.fail(itemStack);
        }


        if (!level.isClientSide()) {

            net.umf.woodmek.entity.custom.FlareEntity flare = new net.umf.woodmek.entity.custom.FlareEntity(level, player.getX(), player.getEyeY() - 0.1, player.getZ());
            flare.setOwner(player);


            flare.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);


            level.addFreshEntity(flare);


            level.playSound(null, player.getX(), player.getY(), player.getZ(),
                    ModSounds.FLARE_GUN_SHOT.get(), SoundSource.PLAYERS, 1.0F, 1.0F);


            itemStack.set(ModDataComponents.USED, true);
            itemStack.set(ModDataComponents.USED_TIMESTAMP, System.currentTimeMillis());
        }

        return InteractionResultHolder.sidedSuccess(itemStack, level.isClientSide());
    }

    @Override
    public boolean isBarVisible(ItemStack stack) {

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


        return 13 - (int) ((remaining / 5000.0) * 13);
    }

    @Override
    public int getBarColor(ItemStack stack) {

        return 0xFF0000;
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {

        Long timestamp = stack.get(ModDataComponents.USED_TIMESTAMP);
        Boolean isUsed = stack.get(ModDataComponents.USED);

        if (isUsed != null && isUsed && timestamp != null) {
            long currentTime = System.currentTimeMillis();
            long elapsed = currentTime - timestamp;
            long remaining = Math.max(0, 5000 - elapsed);
            double remainingSeconds = remaining / 1000.0;

            tooltipComponents.add(Component.literal("§cCooldown: " + String.format("%.1f", remainingSeconds) + "s"));
        }

        if(Screen.hasShiftDown()) {
            tooltipComponents.add(Component.translatable("tooltip.woodmek.shiftflaregun.tooltip"));
        } else {
            tooltipComponents.add(Component.translatable("tooltip.woodmek.flaregun.tooltip"));
        }
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
