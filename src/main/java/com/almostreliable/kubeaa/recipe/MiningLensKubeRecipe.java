package com.almostreliable.kubeaa.recipe;

import com.almostreliable.kubeaa.ModInitializer;
import com.almostreliable.kubeaa.schema.MiningLensRecipeSchema;

import de.ellpeck.actuallyadditions.mod.crafting.MiningLensRecipe;
import dev.latvian.mods.kubejs.recipe.schema.KubeRecipeFactory;

public class MiningLensKubeRecipe extends ValidatedKubeRecipe {

    public static final KubeRecipeFactory FACTORY = new KubeRecipeFactory(
        ModInitializer.getRL(MiningLensRecipe.NAME),
        MiningLensKubeRecipe.class,
        MiningLensKubeRecipe::new
    );

    @Override
    void validateValues() {
        validateMinimum(MiningLensRecipeSchema.WEIGHT, 0, "mining lens recipe weight must not be negative");
    }
}
