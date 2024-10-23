package com.almostreliable.kubeaa.schema;

import de.ellpeck.actuallyadditions.data.MiningLensGenerator;
import de.ellpeck.actuallyadditions.mod.crafting.MiningLensRecipe;
import dev.latvian.mods.kubejs.recipe.RecipeKey;
import dev.latvian.mods.kubejs.recipe.component.ComponentRole;
import dev.latvian.mods.kubejs.recipe.component.IngredientComponent;
import dev.latvian.mods.kubejs.recipe.component.ItemStackComponent;
import dev.latvian.mods.kubejs.recipe.component.NumberComponent;
import dev.latvian.mods.kubejs.recipe.schema.RecipeSchema;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

/**
 * See {@link MiningLensRecipe.Serializer} and {@link MiningLensGenerator}.
 */
public interface MiningLensRecipeSchema {

    RecipeKey<ItemStack> RESULT = ItemStackComponent.STRICT_ITEM_STACK
        .key("result", ComponentRole.OUTPUT)
        .noFunctions();
    RecipeKey<Ingredient> INGREDIENT = IngredientComponent.NON_EMPTY_INGREDIENT
        .key("ingredient", ComponentRole.INPUT)
        .noFunctions();
    RecipeKey<Integer> WEIGHT = NumberComponent.INT
        .key("weight", ComponentRole.OTHER)
        .optional(10)
        .alwaysWrite();

    RecipeSchema SCHEMA = new RecipeSchema(RESULT, INGREDIENT, WEIGHT);
}
