package com.kosta.buzukimod.item.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import  com.kosta.buzukimod.item.custom.MpouzoukiScreen;


public class MpouzoukiItem extends Item {
    public MpouzoukiItem(Properties properties){
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand){
        ItemStack itemstack = player.getItemInHand(hand);

        if (level.isClientSide()){
            openMpouzoukiMenu();
            return InteractionResultHolder.success(itemstack);
        }
    return InteractionResultHolder.pass(itemstack);
               // return super
    }
    private void openMpouzoukiMenu(){
        net.minecraft.client.Minecraft.getInstance().setScreen(new MpouzoukiScreen());
    }
}
