package com.almostreliable.kubeaa.recipe;

import com.almostreliable.kubeaa.ModInitializer;
import de.ellpeck.actuallyadditions.mod.crafting.EmpowererRecipe;
import dev.latvian.mods.kubejs.recipe.KubeRecipe;
import dev.latvian.mods.kubejs.recipe.schema.KubeRecipeFactory;

public class EmpowererKubeRecipe extends KubeRecipe {
    public static final KubeRecipeFactory FACTORY = new KubeRecipeFactory(
        ModInitializer.getRL(EmpowererRecipe.NAME),
        EmpowererKubeRecipe.class,
        EmpowererKubeRecipe::new
    );
}
