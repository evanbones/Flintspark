package com.evandev.flintspark.registry;

import com.evandev.flintspark.Flintspark;
import com.evandev.flintspark.content.item.GenericApricornItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Flintspark.MODID);

    public static final DeferredItem<Item> APRICORN = ITEMS.register("apricorn",
            () -> new GenericApricornItem(new Item.Properties()));

    public static final DeferredItem<BlockItem> APRICORN_FRUIT_LEAVES = ITEMS.register("apricorn_fruit_leaves",
            () -> new BlockItem(ModBlocks.APRICORN_FRUIT_LEAVES.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> APRICORN_SAPLING = ITEMS.register("apricorn_sapling",
            () -> new BlockItem(ModBlocks.APRICORN_SAPLING.get(), new Item.Properties()));
}