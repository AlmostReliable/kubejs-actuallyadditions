package com.almostreliable.kubeaa.recipe;

import com.almostreliable.kubeaa.ModInitializer;
import com.almostreliable.kubeaa.schema.LiquidFuelRecipeSchema;

import de.ellpeck.actuallyadditions.mod.crafting.LiquidFuelRecipe;
import dev.latvian.mods.kubejs.error.InvalidRecipeComponentValueException;
import dev.latvian.mods.kubejs.recipe.schema.KubeRecipeFactory;

import net.neoforged.neoforge.fluids.FluidStack;

public class LiquidFuelKubeRecipe extends ValidatedKubeRecipe {

    @SuppressWarnings("NonFinalStaticVariableUsedInClassInitialization")
    public static final KubeRecipeFactory FACTORY = new KubeRecipeFactory(
        ModInitializer.getRL(LiquidFuelRecipe.NAME),
        LiquidFuelKubeRecipe.class,
        LiquidFuelKubeRecipe::new
    );

    @Override
    void validateValues() {
        FluidStack fuel = getValue(LiquidFuelRecipeSchema.FUEL);
        if (fuel != null && fuel.getAmount() > 2_000) {
            throw new InvalidRecipeComponentValueException(
                "liquid fuel recipe must be at most 2 buckets",
                LiquidFuelRecipeSchema.FUEL.component,
                fuel
            ).source(sourceLine);
        }

        validateMinimum(LiquidFuelRecipeSchema.BURN_TIME, 1, "liquid fuel recipe burn time must be greater than 0");
    }
}
