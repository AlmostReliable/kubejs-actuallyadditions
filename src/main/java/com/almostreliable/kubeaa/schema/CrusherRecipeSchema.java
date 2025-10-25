package com.almostreliable.kubeaa.schema;

import com.almostreliable.kubeaa.component.CrusherResultComponent;
import com.almostreliable.kubeaa.recipe.CrusherKubeRecipe;
import de.ellpeck.actuallyadditions.data.CrushingRecipeGenerator;
import de.ellpeck.actuallyadditions.mod.crafting.CrushingRecipe;
import dev.latvian.mods.kubejs.recipe.RecipeKey;
import dev.latvian.mods.kubejs.recipe.component.ComponentRole;
import dev.latvian.mods.kubejs.recipe.component.IngredientComponent;
import dev.latvian.mods.kubejs.recipe.schema.RecipeSchema;
import dev.latvian.mods.kubejs.util.IntBounds;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.List;

/**
 * See {@link CrushingRecipe.Serializer} and {@link CrushingRecipeGenerator}.
 */
public interface CrusherRecipeSchema {

    RecipeKey<List<CrushingRecipe.CrushingResult>> RESULT = CrusherResultComponent.TYPE
        .instance()
        .asList()
        .withBounds(IntBounds.of(1, 2))
        .key("result", ComponentRole.OUTPUT)
        .noFunctions();
    RecipeKey<Ingredient> INGREDIENT = IngredientComponent.INGREDIENT
        .key("ingredient", ComponentRole.INPUT)
        .noFunctions();

    RecipeSchema SCHEMA = new RecipeSchema(RESULT, INGREDIENT).factory(CrusherKubeRecipe.FACTORY);
}
