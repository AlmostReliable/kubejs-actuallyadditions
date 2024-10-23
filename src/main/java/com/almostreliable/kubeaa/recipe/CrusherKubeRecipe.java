package com.almostreliable.kubeaa.recipe;

import com.almostreliable.kubeaa.ModInitializer;
import com.almostreliable.kubeaa.schema.CrusherRecipeSchema;
import de.ellpeck.actuallyadditions.mod.crafting.CrushingRecipe;
import dev.latvian.mods.kubejs.recipe.KubeRecipe;
import dev.latvian.mods.kubejs.recipe.schema.KubeRecipeFactory;

public class CrusherKubeRecipe extends KubeRecipe {

    public static final KubeRecipeFactory FACTORY = new KubeRecipeFactory(
        ModInitializer.getRL(CrushingRecipe.NAME),
        CrusherKubeRecipe.class,
        CrusherKubeRecipe::new
    );

    @Override
    public void afterLoaded() {
        super.afterLoaded();

        var result = getValue(CrusherRecipeSchema.RESULT);
        if (result != null && result.size() > 2) {
            throw new IllegalArgumentException("crusher recipe must have at most 2 results");
        }
    }
}
