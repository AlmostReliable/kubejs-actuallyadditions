package com.almostreliable.kubeaa.schema;

import de.ellpeck.actuallyadditions.data.LaserRecipeGenerator;
import de.ellpeck.actuallyadditions.mod.crafting.LaserRecipe;
import dev.latvian.mods.kubejs.recipe.RecipeKey;
import dev.latvian.mods.kubejs.recipe.component.ComponentRole;
import dev.latvian.mods.kubejs.recipe.component.IngredientComponent;
import dev.latvian.mods.kubejs.recipe.component.ItemStackComponent;
import dev.latvian.mods.kubejs.recipe.component.NumberComponent;
import dev.latvian.mods.kubejs.recipe.schema.RecipeSchema;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

/**
 * See {@link LaserRecipe.Serializer} and {@link LaserRecipeGenerator}.
 */
public interface LaserRecipeSchema {

    RecipeKey<ItemStack> RESULT = ItemStackComponent.STRICT_ITEM_STACK
        .key("result", ComponentRole.OUTPUT)
        .noFunctions();
    RecipeKey<Ingredient> INGREDIENT = IngredientComponent.NON_EMPTY_INGREDIENT
        .key("ingredient", ComponentRole.INPUT)
        .noFunctions();
    RecipeKey<Integer> ENERGY = NumberComponent.INT
        .key("energy", ComponentRole.OTHER)
        .optional(1_000)
        .alwaysWrite();

    RecipeSchema SCHEMA = new RecipeSchema(RESULT, INGREDIENT, ENERGY);
}
