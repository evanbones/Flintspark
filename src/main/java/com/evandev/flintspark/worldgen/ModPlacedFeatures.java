package com.evandev.flintspark.worldgen;

import com.evandev.flintspark.Flintspark;
import com.evandev.flintspark.registry.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> APRICORN_TREE_PLACED_KEY = ResourceKey.create(
            Registries.PLACED_FEATURE,
            Flintspark.location("apricorn")
    );

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configuredFeatureRegistry = context.lookup(Registries.CONFIGURED_FEATURE);
        var configuredFeature = configuredFeatureRegistry.getOrThrow(ModBlocks.APRICORN_TREE_KEY);

        PlacementUtils.register(context, APRICORN_TREE_PLACED_KEY, configuredFeature,
                List.of(PlacementUtils.filteredByBlockSurvival(ModBlocks.APRICORN_SAPLING.get()))
        );
    }
}