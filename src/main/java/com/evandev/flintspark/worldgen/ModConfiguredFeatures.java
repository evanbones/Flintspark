package com.evandev.flintspark.worldgen;

import com.cobblemon.mod.common.CobblemonBlocks;
import com.evandev.flintspark.registry.ModBlocks;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> APRICORN_TREE_KEY = ModBlocks.APRICORN_TREE_KEY;

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        context.register(APRICORN_TREE_KEY, new ConfiguredFeature<>(Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(CobblemonBlocks.APRICORN_WOOD),
                        new StraightTrunkPlacer(4, 2, 0),
                        BlockStateProvider.simple(ModBlocks.APRICORN_FRUIT_LEAVES.get()),
                        new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                        new TwoLayersFeatureSize(1, 0, 1)
                ).ignoreVines().build())
        );
    }
}
