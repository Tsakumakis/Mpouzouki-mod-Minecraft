package com.kosta.buzukimod.item.custom;

import com.kosta.buzukimod.sounds.ModSounds;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;


public class MpouzoukiScreen extends Screen {

    public MpouzoukiScreen() {
        super(Component.literal("Select a song"));

    }

    @Override
    protected void init() {
        super.init();

        //song 1
        this.addRenderableWidget(Button.builder(Component.literal("Play song1"), button -> {
            this.playSong();
            this.onClose();
        }).bounds(this.width / 2 - 100, this.height / 2 - 40, 200, 20).build());
        // stop button
        this.addRenderableWidget(Button.builder(Component.literal("Stop song"), button -> {
            this.stopSong();
            this.onClose();
        }).bounds(this.width / 2 - 40, this.height / 2 - -40, 80, 20).build());
    }
    private void playSong() {
        net.minecraft.client.Minecraft mc = net.minecraft.client.Minecraft.getInstance();
        Player player = mc.player;

        if (player != null){
            mc.getSoundManager().stop(ModSounds.SONG_1.get().getLocation(),null);
            player.playSound(ModSounds.SONG_1.get(), 1.0F,1.0F);
        }
    }
    private void stopSong(){
        net.minecraft.client.Minecraft mc = net.minecraft.client.Minecraft.getInstance();
        Player player = mc.player;
        if (player != null){
            mc.getSoundManager().stop(ModSounds.SONG_1.get().getLocation(),null);
            player.playSound(ModSounds.SONG_1.get(), 0F,0F);
        }
    }
     @Override
    public boolean isPauseScreen(){
        return false;
     }
    }

