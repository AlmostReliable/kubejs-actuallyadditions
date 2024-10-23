package com.almostreliable.kubeaa.recipe;

import com.almostreliable.kubeaa.ModInitializer;
import com.almostreliable.kubeaa.schema.EmpowererRecipeSchema;
import de.ellpeck.actuallyadditions.mod.crafting.EmpowererRecipe;
import dev.latvian.mods.kubejs.recipe.KubeRecipe;
import dev.latvian.mods.kubejs.recipe.schema.KubeRecipeFactory;

public class EmpowererKubeRecipe extends KubeRecipe {

    public static final KubeRecipeFactory FACTORY = new KubeRecipeFactory(
        ModInitializer.getRL(EmpowererRecipe.NAME),
        EmpowererKubeRecipe.class,
        EmpowererKubeRecipe::new
    );

    @Override
    public void afterLoaded() {
        super.afterLoaded();

        var modifiers = getValue(EmpowererRecipeSchema.MODIFIERS);
        if (modifiers != null && modifiers.size() != 4) {
            throw new IllegalArgumentException("empowerer recipe must have exactly 4 modifiers");
        }
    }
}
