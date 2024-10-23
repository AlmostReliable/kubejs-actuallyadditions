package com.almostreliable.kubeaa.schema;

import de.ellpeck.actuallyadditions.data.FuelRecipeGenerator;
import de.ellpeck.actuallyadditions.mod.crafting.SolidFuelRecipe;
import dev.latvian.mods.kubejs.recipe.RecipeKey;
import dev.latvian.mods.kubejs.recipe.component.ComponentRole;
import dev.latvian.mods.kubejs.recipe.component.IngredientComponent;
import dev.latvian.mods.kubejs.recipe.component.NumberComponent;
import dev.latvian.mods.kubejs.recipe.schema.RecipeSchema;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.List;

/**
 * See {@link SolidFuelRecipe.Serializer} and {@link FuelRecipeGenerator}.
 */
public interface SolidFuelRecipeSchema {

    RecipeKey<Ingredient> ITEM = IngredientComponent.NON_EMPTY_INGREDIENT
        .key("item", ComponentRole.INPUT)
        .noFunctions();
    RecipeKey<Integer> TOTAL_ENERGY = NumberComponent.INT
        .key("total_energy", ComponentRole.INPUT)
        .functionNames(List.of("energy"))
        .optional(1_000)
        .alwaysWrite();
    RecipeKey<Integer> BURN_TIME = NumberComponent.INT
        .key("burn_time", ComponentRole.OTHER)
        .functionNames(List.of("time"))
        .optional(100)
        .alwaysWrite();

    RecipeSchema SCHEMA = new RecipeSchema(ITEM, TOTAL_ENERGY, BURN_TIME);
}
