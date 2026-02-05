package com.evandev.flintspark.content.block;

import com.evandev.flintspark.registry.ModBlocks;
import com.farcr.nomansland.common.block.fruit_trees.FruitLeavesBlock;
import com.farcr.nomansland.common.block.fruit_trees.FruitType;
import com.mojang.serialization.MapCodec;
import org.jetbrains.annotations.NotNull;

public class ApricornFruitLeavesBlock extends FruitLeavesBlock {

    public static final MapCodec<ApricornFruitLeavesBlock> CODEC = simpleCodec(ApricornFruitLeavesBlock::new);

    public ApricornFruitLeavesBlock(Properties properties) {
        super(properties, FruitType.APPLE_OAK);

        this.fruit = ModBlocks.APRICORN_FRUIT.getDelegate();
        this.growthSpeed = 3;
    }

    @Override
    public @NotNull MapCodec<ApricornFruitLeavesBlock> codec() {
        return CODEC;
    }
}