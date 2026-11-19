package com.almostreliable.kubeaa.recipe;

import com.almostreliable.kubeaa.ModInitializer;
import com.almostreliable.kubeaa.schema.EmpowererRecipeSchema;

import de.ellpeck.actuallyadditions.mod.crafting.EmpowererRecipe;
import dev.latvian.mods.kubejs.recipe.schema.KubeRecipeFactory;

public class EmpowererKubeRecipe extends ValidatedKubeRecipe {

    @SuppressWarnings("NonFinalStaticVariableUsedInClassInitialization")
    public static final KubeRecipeFactory FACTORY = new KubeRecipeFactory(
        ModInitializer.getRL(EmpowererRecipe.NAME),
        EmpowererKubeRecipe.class,
        EmpowererKubeRecipe::new
    );

    @Override
    void validateValues() {
        validateMinimum(EmpowererRecipeSchema.TIME, 1, "empowerer recipe time must be greater than 0");
    }
}
