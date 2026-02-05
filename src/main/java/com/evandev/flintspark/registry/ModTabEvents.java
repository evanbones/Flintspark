package com.evandev.flintspark.registry;

import com.evandev.flintspark.Flintspark;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

@EventBusSubscriber(modid = Flintspark.MODID, bus = EventBusSubscriber.Bus.MOD)
public class ModTabEvents {

    public static final ResourceKey<CreativeModeTab> COBBLEMON_AGRICULTURE_KEY = ResourceKey.create(
            Registries.CREATIVE_MODE_TAB,
            ResourceLocation.fromNamespaceAndPath("cobblemon", "agriculture")
    );

    @SubscribeEvent
    public static void onBuildCreativeTabs(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == COBBLEMON_AGRICULTURE_KEY) {
            event.accept(ModItems.APRICORN.get());
            event.accept(ModItems.APRICORN_SAPLING.get());
            event.accept(ModItems.APRICORN_FRUIT_LEAVES.get());
        }
    }
}