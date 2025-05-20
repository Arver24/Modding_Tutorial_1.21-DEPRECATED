package com.arver.mod_tutorial.block;


import com.arver.mod_tutorial.TutorialMod;
import com.arver.mod_tutorial.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MOD_ID); //creating a register for all blocks in the mod

    public static final RegistryObject<Block> PALADINITE_BLOCK=registerBlock("paladinite_block", ()->new Block(
            BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK)));


    //method to add the block to blocks registry
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    // method to add the block item to the items registry
    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name,()->new BlockItem(block.get(),new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
