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
import dev.latvian.mods.kubejs.util.IntBounds;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.List;

/**
 * See {@link CoffeeIngredientRecipe.Serializer} and {@link CoffeeIngredientGenerator}.
 */
public interface CoffeeIngredientRecipeSchema {

    RecipeKey<Ingredient> INGREDIENT = IngredientComponent.INGREDIENT
        .key("ingredient", ComponentRole.INPUT)
        .noFunctions();
    RecipeKey<List<CoffeeIngredientRecipe.EffectInstance>> EFFECTS = EffectInstanceComponent.TYPE
        .instance()
        .asList()
        .withBounds(IntBounds.OPTIONAL)
        .key("effects", ComponentRole.OTHER)
        .optional(List.of())
        .noFunctions();
    RecipeKey<Integer> MAX_AMPLIFIER = NumberComponent.INT
        .key("max_amplifier", ComponentRole.OTHER)
        .functionNames(List.of("maxAmplifier"))
        .optional(1)
        .alwaysWrite();
    RecipeKey<String> EXTRA_TEXT = StringComponent.OPTIONAL_STRING
        .key("extra_text", ComponentRole.OTHER)
        .functionNames(List.of("extraText"))
        .optional("");

    RecipeSchema SCHEMA = new RecipeSchema(INGREDIENT, EFFECTS, MAX_AMPLIFIER, EXTRA_TEXT);
}
