package com.evandev.flintspark.content.block;

import com.evandev.flintspark.registry.ModBlocks;
import com.evandev.flintspark.registry.ModItems;
import com.farcr.nomansland.common.block.fruit_trees.FruitBlock;
import com.farcr.nomansland.common.block.fruit_trees.FruitType;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class ApricornFruitBlock extends FruitBlock {

    private static final VoxelShape[] SHAPES = new VoxelShape[]{
            Block.box(6, 11, 7, 10, 15, 11),
            Block.box(6, 11, 7, 10, 15, 11),
            Block.box(5.5, 10, 6.5, 10.5, 15, 11.5),
            Block.box(5.5, 10, 6.5, 10.5, 15, 11.5),
            Block.box(5.5, 10, 6.5, 10.5, 15, 11.5)
    };

    public ApricornFruitBlock(Properties properties) {
        super(properties, FruitType.APPLE_OAK);
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return level.getBlockState(pos.above(2)).is(ModBlocks.APRICORN_FRUIT_LEAVES.get());
    }

    @Override
    protected @NotNull VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Vec3 vec3 = state.getOffset(level, pos);
        VoxelShape voxelshape = SHAPES[state.getValue(AGE)];
        return voxelshape.move(vec3.x, vec3.y, vec3.z);
    }

    @Override
    protected @NotNull InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (state.getValue(AGE) != getMaxAge()) return InteractionResult.PASS;

        if (!(player.isCreative() && player.getInventory().hasAnyMatching(stack -> stack.getItem() == ModItems.APRICORN.get()))) {
            ItemStack fruitStack = new ItemStack(ModItems.APRICORN.get());
            if (!player.addItem(fruitStack)) {
                player.drop(fruitStack, false);
            } else {
                level.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.ITEM_PICKUP, SoundSource.PLAYERS, 0.2F, (level.random.nextFloat() - level.random.nextFloat()) * 1.4F + 2.0F);
            }
        } else {
            level.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.ITEM_PICKUP, SoundSource.PLAYERS, 0.2F, (level.random.nextFloat() - level.random.nextFloat()) * 1.4F + 2.0F);
        }

        level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
        return InteractionResult.sidedSuccess(level.isClientSide);
    }

    @Override
    public @NotNull ItemStack getCloneItemStack(BlockState state, HitResult target, LevelReader level, BlockPos pos, Player player) {
        return ModItems.APRICORN.get().getDefaultInstance();
    }
}