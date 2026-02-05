package com.evandev.flintspark.datagen.provider;

import com.evandev.flintspark.Flintspark;
import com.evandev.flintspark.registry.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Flintspark.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        this.tag(BlockTags.LEAVES)
                .add(ModBlocks.APRICORN_FRUIT_LEAVES.get());

        this.tag(BlockTags.SAPLINGS)
                .add(ModBlocks.APRICORN_SAPLING.get());

        this.tag(BlockTags.MINEABLE_WITH_HOE)
                .add(ModBlocks.APRICORN_FRUIT_LEAVES.get());
    }
}