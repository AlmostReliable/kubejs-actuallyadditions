package com.almostreliable.kubeaa.recipe;

import com.almostreliable.kubeaa.ModInitializer;
import com.almostreliable.kubeaa.schema.EmpowererRecipeSchema;

import de.ellpeck.actuallyadditions.mod.crafting.EmpowererRecipe;
import dev.latvian.mods.kubejs.error.InvalidRecipeComponentValueException;
import dev.latvian.mods.kubejs.recipe.schema.KubeRecipeFactory;

import net.minecraft.world.item.crafting.Ingredient;

import java.util.List;

public class EmpowererKubeRecipe extends ValidatedKubeRecipe {

    @SuppressWarnings("NonFinalStaticVariableUsedInClassInitialization")
    public static final KubeRecipeFactory FACTORY = new KubeRecipeFactory(
        ModInitializer.getRL(EmpowererRecipe.NAME),
        EmpowererKubeRecipe.class,
        EmpowererKubeRecipe::new
    );

    @Override
    void validateValues() {
        List<Ingredient> modifiers = getValue(EmpowererRecipeSchema.MODIFIERS);
        if (modifiers != null && modifiers.size() != 4) {
            throw new InvalidRecipeComponentValueException(
                "empowerer recipe must have exactly 4 modifiers",
                EmpowererRecipeSchema.MODIFIERS.component,
                modifiers
            ).source(sourceLine);
        }

        validateMinimum(EmpowererRecipeSchema.TIME, 1, "empowerer recipe time must be greater than 0");
    }
}
