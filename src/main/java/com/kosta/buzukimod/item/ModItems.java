package com.kosta.buzukimod.item;

import com.kosta.buzukimod.item.custom.MpouzoukiItem;
import com.kosta.buzukimod.item.custom.PaneriItem;
import com.kosta.buzukimod.mpouzoukiMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS=
            DeferredRegister.create(ForgeRegistries.ITEMS, mpouzoukiMod.MOD_ID);

    public static final RegistryObject<Item> KANTINI = ITEMS.register("kantini",() -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> MESIANI = ITEMS.register("mesiani" , ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MPASA = ITEMS.register("mpasa" , ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MPOUZOUKI = ITEMS.register("mpouzouki", () -> new MpouzoukiItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> PANERI = ITEMS.register("paneri", () -> new PaneriItem(new Item.Properties().durability(500)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
