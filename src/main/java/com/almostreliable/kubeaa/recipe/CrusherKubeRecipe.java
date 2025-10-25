package com.almostreliable.kubeaa.recipe;

import com.almostreliable.kubeaa.ModInitializer;
import de.ellpeck.actuallyadditions.mod.crafting.CrushingRecipe;
import dev.latvian.mods.kubejs.recipe.KubeRecipe;
import dev.latvian.mods.kubejs.recipe.schema.KubeRecipeFactory;

public class CrusherKubeRecipe extends KubeRecipe {
    public static final KubeRecipeFactory FACTORY = new KubeRecipeFactory(
        ModInitializer.getRL(CrushingRecipe.NAME),
        CrusherKubeRecipe.class,
        CrusherKubeRecipe::new
    );
}
