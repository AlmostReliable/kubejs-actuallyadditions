package com.almostreliable.kubeaa.schema;

import de.ellpeck.actuallyadditions.data.ColorChangeGenerator;
import de.ellpeck.actuallyadditions.mod.crafting.ColorChangeRecipe;
import dev.latvian.mods.kubejs.recipe.RecipeKey;
import dev.latvian.mods.kubejs.recipe.component.ComponentRole;
import dev.latvian.mods.kubejs.recipe.component.IngredientComponent;
import dev.latvian.mods.kubejs.recipe.component.ItemStackComponent;
import dev.latvian.mods.kubejs.recipe.schema.RecipeSchema;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

/**
 * See {@link ColorChangeRecipe.Serializer} and {@link ColorChangeGenerator}.
 */
public interface ColorChangeRecipeSchema {

    RecipeKey<ItemStack> RESULT = ItemStackComponent.STRICT_ITEM_STACK
        .key("result", ComponentRole.OUTPUT)
        .noFunctions();
    RecipeKey<Ingredient> INGREDIENT = IngredientComponent.NON_EMPTY_INGREDIENT
        .key("ingredient", ComponentRole.INPUT)
        .noFunctions();

    RecipeSchema SCHEMA = new RecipeSchema(RESULT, INGREDIENT);
}
