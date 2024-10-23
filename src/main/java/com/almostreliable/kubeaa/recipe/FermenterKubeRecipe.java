package com.almostreliable.kubeaa.recipe;

import com.almostreliable.kubeaa.ModInitializer;
import com.almostreliable.kubeaa.schema.FermenterRecipeSchema;
import de.ellpeck.actuallyadditions.mod.crafting.FermentingRecipe;
import dev.latvian.mods.kubejs.recipe.KubeRecipe;
import dev.latvian.mods.kubejs.recipe.schema.KubeRecipeFactory;
import net.neoforged.neoforge.fluids.FluidStack;

public class FermenterKubeRecipe extends KubeRecipe {

    public static final KubeRecipeFactory FACTORY = new KubeRecipeFactory(
        ModInitializer.getRL(FermentingRecipe.NAME),
        FermenterKubeRecipe.class,
        FermenterKubeRecipe::new
    );

    @Override
    public void afterLoaded() {
        super.afterLoaded();

        FluidStack result = getValue(FermenterRecipeSchema.RESULT);
        if (result != null && result.getAmount() > 2_000) {
            throw new IllegalArgumentException("fermenter recipe result must be at most 2 buckets");
        }

        FluidStack ingredient = getValue(FermenterRecipeSchema.INGREDIENT);
        if (ingredient != null && ingredient.getAmount() > 2_000) {
            throw new IllegalArgumentException("fermenter recipe ingredient must be at most 2 buckets");
        }
    }
}
