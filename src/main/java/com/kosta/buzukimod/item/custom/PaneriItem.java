package com.kosta.buzukimod.item.custom;


import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;


public class PaneriItem extends BowItem {
    public PaneriItem(Properties properties){
        super(properties);
    }
    @Override
    public InteractionResultHolder<ItemStack> use (Level level, Player player, InteractionHand hand){
        ItemStack itemstack = player.getItemInHand(hand);
        player.startUsingItem(hand);
        return InteractionResultHolder.consume(itemstack);
    }
    @Override
    public void releaseUsing(ItemStack stack, Level level, LivingEntity entity, int timeRemaining) {
        if (entity instanceof Player player) {
            int duration = this.getUseDuration(stack, entity) - timeRemaining;
            float power = getPowerForTime(duration);

            if (power >= 0.1F) {
                if (!level.isClientSide) {
                    int poppyCount = 5;

                    for (int i = 0; i < poppyCount; i++) {
                        net.minecraft.world.entity.projectile.Snowball flowerProjectile =
                                new net.minecraft.world.entity.projectile.Snowball(level, player);

                        flowerProjectile.setItem(new ItemStack(net.minecraft.world.level.block.Blocks.POPPY));

                        // Adding randomness to the angles to create a natural throw scatter
                        // level.random.nextFloat() - level.random.nextFloat() creates a value between -1.0 and 1.0
                        float pitchOffset = (level.random.nextFloat() - level.random.nextFloat()) * 10.0F;
                        float yawOffset = (level.random.nextFloat() - level.random.nextFloat()) * 10.0F;

                        // Shoot with the calculated random spread adjustments
                        flowerProjectile.shootFromRotation(player, player.getXRot() + pitchOffset, player.getYRot() + yawOffset, 0.0F, power * 2.0F, 1.0F);

                        level.addFreshEntity(flowerProjectile);
                    }
                    level.playSound(null, player.getX(), player.getY(), player.getZ(),
                            SoundEvents.SNOWBALL_THROW, SoundSource.PLAYERS, 1.0F, 0.5F);
                    player.awardStat(Stats.ITEM_USED.get(this));

                }
            }
        }
    }
    @Override
    public UseAnim getUseAnimation(ItemStack stack){
        return UseAnim.BOW;
    }
}
