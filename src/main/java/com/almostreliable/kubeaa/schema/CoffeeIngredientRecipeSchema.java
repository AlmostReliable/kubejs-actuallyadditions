package com.almostreliable.kubeaa.schema;

import com.almostreliable.kubeaa.component.EffectInstanceComponent;
import de.ellpeck.actuallyadditions.data.CoffeeIngredientGenerator;
import de.ellpeck.actuallyadditions.mod.crafting.CoffeeIngredientRecipe;
import dev.latvian.mods.kubejs.recipe.RecipeKey;
import dev.latvian.mods.kubejs.recipe.component.ComponentRole;
import dev.latvian.mods.kubejs.recipe.component.IngredientComponent;
import dev.latvian.mods.kubejs.recipe.component.NumberComponent;
import dev.latvian.mods.kubejs.recipe.component.StringComponent;
import dev.latvian.mods.kubejs.recipe.schema.RecipeSchema;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.List;

/**
 * See {@link CoffeeIngredientRecipe.Serializer} and {@link CoffeeIngredientGenerator}.
 */
public interface CoffeeIngredientRecipeSchema {

    RecipeKey<List<CoffeeIngredientRecipe.EffectInstance>> EFFECTS = EffectInstanceComponent.EFFECT_INSTANCE
        .asList()
        .key("effects", ComponentRole.OTHER)
        .noFunctions();
    RecipeKey<Ingredient> INGREDIENT = IngredientComponent.NON_EMPTY_INGREDIENT
        .key("ingredient", ComponentRole.INPUT)
        .noFunctions();
    RecipeKey<Integer> MAX_AMPLIFIER = NumberComponent.INT
        .key("maxAmplifier", ComponentRole.OTHER)
        .optional(1)
        .alwaysWrite();
    RecipeKey<String> EXTRA_TEXT = StringComponent.ANY
        .key("extraText", ComponentRole.OTHER)
        .optional("")
        .allowEmpty();

    RecipeSchema SCHEMA = new RecipeSchema(EFFECTS, INGREDIENT, MAX_AMPLIFIER, EXTRA_TEXT);
}
