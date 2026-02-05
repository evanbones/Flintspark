package com.evandev.flintspark.datagen.provider;

import com.evandev.flintspark.Flintspark;
import com.evandev.flintspark.registry.ModBlocks;
import com.evandev.flintspark.registry.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Flintspark.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.APRICORN.get());

        withExistingParent(ModBlocks.APRICORN_SAPLING.getId().getPath(), "item/generated")
                .texture("layer0", Flintspark.location("block/apricorn_sapling"));
    }
}