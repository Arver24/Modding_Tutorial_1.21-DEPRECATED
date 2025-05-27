package com.arver.mod_tutorial.item;

import com.arver.mod_tutorial.TutorialMod;
import com.arver.mod_tutorial.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.DeadBushBlock;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTab {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MOD_TAB_REG= DeferredRegister.create(Registries.CREATIVE_MODE_TAB,
            TutorialMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> PALADINITE_ITEMS_TAB=CREATIVE_MOD_TAB_REG.register("paladinite_items_tab",
            ()->CreativeModeTab.builder().icon(()->new ItemStack(ModItems.PALADINITE_DUST.get())).title(Component.translatable(
                    "creativetab.tutorialmod.paladinite_items")).displayItems((itemDisplayParameters,output)->{
                        output.accept(ModItems.PALADINITE_DUST.get());
                        output.accept(ModItems.PALADINITE_SHARD.get());
            }).build());
    public static final RegistryObject<CreativeModeTab> PALADINITE_BLOCKS_TAB=CREATIVE_MOD_TAB_REG.register("paladinite_blocks_tab",
            ()-> CreativeModeTab.builder().icon(()->new ItemStack(ModBlocks.PALADINITE_BLOCK.get())).withTabsBefore(PALADINITE_ITEMS_TAB.getId()).title(Component.translatable(
                    "creativetab.tutorialmod.paladinite_blocks")).displayItems((itemDisplayParameters,output)->{
                        output.accept(ModBlocks.PALADINITE_BLOCK.get());
                        output.accept(ModBlocks.PALADINITE_DUST_BLOCK.get());
                        output.accept(ModBlocks.PALADINITE_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_PALADINITE_ORE.get());
            }).build());





    public static void register(IEventBus eventBus){
        CREATIVE_MOD_TAB_REG.register(eventBus);
    }

}
