package com.evandev.flintspark.content.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class GenericApricornItem extends Item {
    public GenericApricornItem(Properties properties) {
        super(properties.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationModifier(0.3F)
                .build()));
    }
}