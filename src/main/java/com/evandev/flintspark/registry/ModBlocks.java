package com.evandev.flintspark.registry;

import com.cobblemon.mod.common.CobblemonBlocks;
import com.evandev.flintspark.Flintspark;
import com.evandev.flintspark.content.block.ApricornFruitBlock;
import com.evandev.flintspark.content.block.ApricornFruitLeavesBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Optional;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Flintspark.MODID);

    public static final DeferredBlock<ApricornFruitBlock> APRICORN_FRUIT = BLOCKS.register("apricorn_fruit",
            () -> new ApricornFruitBlock(BlockBehaviour.Properties.of()
                    .noCollission()
                    .randomTicks()
                    .instabreak()
                    .pushReaction(PushReaction.DESTROY)
                    .sound(SoundType.CROP)));

    public static final DeferredBlock<ApricornFruitLeavesBlock> APRICORN_FRUIT_LEAVES = BLOCKS.register("apricorn_fruit_leaves",
            () -> new ApricornFruitLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));

    public static final ResourceKey<ConfiguredFeature<?, ?>> APRICORN_TREE_KEY = ResourceKey.create(
            Registries.CONFIGURED_FEATURE,
            Flintspark.location("apricorn")
    );

    public static final DeferredBlock<SaplingBlock> APRICORN_SAPLING = BLOCKS.register("apricorn_sapling",
            () -> new SaplingBlock(
                    new TreeGrower(
                            "apricorn",
                            Optional.empty(),
                            Optional.of(APRICORN_TREE_KEY),
                            Optional.empty()
                    ),
                    BlockBehaviour.Properties.ofFullCopy(CobblemonBlocks.RED_APRICORN_SAPLING))
    );

}