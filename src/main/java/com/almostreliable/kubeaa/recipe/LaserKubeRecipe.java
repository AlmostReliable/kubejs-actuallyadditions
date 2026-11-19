package com.almostreliable.kubeaa.recipe;

import com.almostreliable.kubeaa.ModInitializer;
import com.almostreliable.kubeaa.schema.LaserRecipeSchema;

import de.ellpeck.actuallyadditions.mod.crafting.LaserRecipe;
import dev.latvian.mods.kubejs.recipe.schema.KubeRecipeFactory;
import dev.latvian.mods.kubejs.script.ConsoleJS;

import net.minecraft.world.item.ItemStack;

public class LaserKubeRecipe extends ValidatedKubeRecipe {

    @SuppressWarnings("NonFinalStaticVariableUsedInClassInitialization")
    public static final KubeRecipeFactory FACTORY = new KubeRecipeFactory(
        ModInitializer.getRL(LaserRecipe.NAME),
        LaserKubeRecipe.class,
        LaserKubeRecipe::new
    );

    @Override
    void validateValues() {
        validateMinimum(LaserRecipeSchema.ENERGY, 1, "laser recipe energy must be greater than 0");

        ItemStack result = getValue(LaserRecipeSchema.RESULT);
        if (result == null) return;

        var count = result.getCount();
        if (count <= 1) return;

        var message = "laser recipe result count is always 1, ignoring count " + count;
        ConsoleJS.SERVER.warn(message).withSourceLine(sourceLine);
    }
}
