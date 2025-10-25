package com.almostreliable.kubeaa.component;

import com.almostreliable.kubeaa.ModInitializer;
import dev.latvian.mods.kubejs.recipe.component.ItemStackComponent;
import dev.latvian.mods.kubejs.recipe.component.RecipeComponentType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

public final class SingleItemStackComponent {
    public static final RecipeComponentType<ItemStack> TYPE = RecipeComponentType.unit(
        ModInitializer.getRL("single_item"),
        type -> new ItemStackComponent(type, ItemStack.STRICT_SINGLE_ITEM_CODEC, false, Ingredient.EMPTY)
    );
}
