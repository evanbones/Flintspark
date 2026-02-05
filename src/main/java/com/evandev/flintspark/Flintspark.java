package com.evandev.flintspark;

import com.evandev.flintspark.common.event.CreativeModeTabHandler;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Flintspark.MODID)
public class Flintspark {

    public static final String MODID = "flintspark";
    public static final Logger LOGGER = LogManager.getLogger("Flintspark");

    public Flintspark(IEventBus bus, ModContainer container) {
        bus.register(new CreativeModeTabHandler());
    }

    public static ResourceLocation location(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }
}
