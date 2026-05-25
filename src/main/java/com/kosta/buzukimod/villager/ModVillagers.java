package com.kosta.buzukimod.villager;

import com.google.common.collect.ImmutableSet;
import com.kosta.buzukimod.mpouzoukiMod;
import com.kosta.buzukimod.ModBlocks.ModBlocks;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, mpouzoukiMod.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, mpouzoukiMod.MOD_ID);

    public static final RegistryObject<PoiType> MITROPANOS_POI = POI_TYPES.register("mitropanos_poi",
            () -> new PoiType(
                    ImmutableSet.copyOf(ModBlocks.PISTA_BLOCK.get().getStateDefinition().getPossibleStates()),
                    1, 1));

    public static final RegistryObject<VillagerProfession> MITROPANOS = VILLAGER_PROFESSIONS.register("mitropanos",
            () -> new VillagerProfession(
                    "mitropanos",
                    holder -> holder.is(MITROPANOS_POI.getKey()),
                    holder -> holder.is(MITROPANOS_POI.getKey()),
                    ImmutableSet.of(),
                    ImmutableSet.of(),
                    SoundEvents.VILLAGER_WORK_FARMER));



    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
    public static void registerPOIs(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
        });
    }
}