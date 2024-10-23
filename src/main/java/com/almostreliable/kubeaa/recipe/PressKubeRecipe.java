package com.almostreliable.kubeaa.recipe;

import com.almostreliable.kubeaa.ModInitializer;
import com.almostreliable.kubeaa.schema.PressRecipeSchema;
import de.ellpeck.actuallyadditions.mod.crafting.PressingRecipe;
import dev.latvian.mods.kubejs.recipe.KubeRecipe;
import dev.latvian.mods.kubejs.recipe.schema.KubeRecipeFactory;
import net.neoforged.neoforge.fluids.FluidStack;

public class PressKubeRecipe extends KubeRecipe {

    public static final KubeRecipeFactory FACTORY = new KubeRecipeFactory(
        ModInitializer.getRL(PressingRecipe.NAME),
        PressKubeRecipe.class,
        PressKubeRecipe::new
    );

    @Override
    public void afterLoaded() {
        super.afterLoaded();

        FluidStack fluid = getValue(PressRecipeSchema.FLUID);
        if (fluid != null && fluid.getAmount() > 2_000) {
            throw new IllegalArgumentException("press recipe result must be at most 2 buckets");
        }
    }
}
