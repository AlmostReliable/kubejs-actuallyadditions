package com.almostreliable.kubeaa.recipe;

import com.almostreliable.kubeaa.ModInitializer;
import com.almostreliable.kubeaa.schema.CrusherRecipeSchema;

import de.ellpeck.actuallyadditions.mod.crafting.CrushingRecipe;
import dev.latvian.mods.kubejs.error.InvalidRecipeComponentValueException;
import dev.latvian.mods.kubejs.recipe.KubeRecipe;
import dev.latvian.mods.kubejs.recipe.component.RecipeValidationContext;
import dev.latvian.mods.kubejs.recipe.schema.KubeRecipeFactory;

import java.util.List;

public class CrusherKubeRecipe extends KubeRecipe {

    @SuppressWarnings("NonFinalStaticVariableUsedInClassInitialization")
    public static final KubeRecipeFactory FACTORY = new KubeRecipeFactory(
        ModInitializer.getRL(CrushingRecipe.NAME),
        CrusherKubeRecipe.class,
        CrusherKubeRecipe::new
    );

    @Override
    public void validate(RecipeValidationContext cx) {
        List<CrushingRecipe.CrushingResult> results = getValue(CrusherRecipeSchema.RESULT);
        if (results == null || results.isEmpty()) return;

        if (!results.getFirst().stack().isEmpty()) return;

        throw new InvalidRecipeComponentValueException(
            "crusher recipe first result must not be empty",
            CrusherRecipeSchema.RESULT.component,
            results
        ).source(cx.recipe().sourceLine);
    }
}
