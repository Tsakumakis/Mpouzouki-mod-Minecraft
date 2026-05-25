package com.kosta.buzukimod.sounds;

import com.kosta.buzukimod.mpouzoukiMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
        public static final DeferredRegister<SoundEvent> SOUNDS =
              DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, mpouzoukiMod.MOD_ID);
        public static final RegistryObject<SoundEvent> SONG_1 = SOUNDS.register("song_1",
                () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(mpouzoukiMod.MOD_ID, "song_1")));
        public static void register(IEventBus eventBus){
            SOUNDS.register(eventBus);
        }

}
