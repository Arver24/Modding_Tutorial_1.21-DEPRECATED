package com.arver.mod_tutorial.item;

import com.arver.mod_tutorial.TutorialMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS=
            DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID); // creating a register for all items in the mod

    public static final RegistryObject<Item> PALADINITE_SHARD=ITEMS.register("paladinite_shard",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PALADINITE_DUST =ITEMS.register("paladinite_dust",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
