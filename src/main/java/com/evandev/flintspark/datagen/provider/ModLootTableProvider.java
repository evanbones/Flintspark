package com.evandev.flintspark.datagen.provider;

import com.evandev.flintspark.registry.ModBlocks;
import com.evandev.flintspark.registry.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends LootTableProvider {
    public ModLootTableProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, Set.of(), List.of(
                new SubProviderEntry(ModBlockLoot::new, LootContextParamSets.BLOCK)
        ), registries);
    }

    public static class ModBlockLoot extends BlockLootSubProvider {
        protected ModBlockLoot(HolderLookup.Provider provider) {
            super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider);
        }

        @Override
        protected void generate() {
            this.add(ModBlocks.APRICORN_FRUIT.get(), block ->
                    createSilkTouchDispatchTable(block, LootItem.lootTableItem(ModItems.APRICORN.get())));

            this.dropSelf(ModBlocks.APRICORN_SAPLING.get());

            this.add(ModBlocks.APRICORN_FRUIT_LEAVES.get(), block ->
                    createLeavesDrops(block, ModBlocks.APRICORN_SAPLING.get(), 0.05f));
        }

        @Override
        protected @NotNull Iterable<Block> getKnownBlocks() {
            return ModBlocks.BLOCKS.getEntries().stream().map(e -> (Block) e.get()).toList();
        }
    }
}