package com.evandev.flintspark.datagen.provider;

import com.evandev.flintspark.Flintspark;
import com.evandev.flintspark.registry.ModBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Flintspark.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlockWithItem(ModBlocks.APRICORN_FRUIT_LEAVES.get(),
                models().withExistingParent("apricorn_fruit_leaves", "minecraft:block/leaves")
                        .texture("all", "cobblemon:block/wood/apricorn_leaves")
                        .renderType("cutout_mipped"));

        simpleBlock(ModBlocks.APRICORN_SAPLING.get(),
                models().cross("apricorn_sapling", Flintspark.location("block/apricorn_sapling")).renderType("cutout"));
    }
}