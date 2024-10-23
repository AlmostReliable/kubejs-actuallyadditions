package com.almostreliable.kubeaa.recipe;

import com.almostreliable.kubeaa.ModInitializer;
import com.almostreliable.kubeaa.schema.LiquidFuelRecipeSchema;
import de.ellpeck.actuallyadditions.mod.crafting.LiquidFuelRecipe;
import dev.latvian.mods.kubejs.recipe.KubeRecipe;
import dev.latvian.mods.kubejs.recipe.schema.KubeRecipeFactory;
import net.neoforged.neoforge.fluids.FluidStack;

public class LiquidFuelKubeRecipe extends KubeRecipe {

    public static final KubeRecipeFactory FACTORY = new KubeRecipeFactory(
        ModInitializer.getRL(LiquidFuelRecipe.NAME),
        LiquidFuelKubeRecipe.class,
        LiquidFuelKubeRecipe::new
    );

    @Override
    public void afterLoaded() {
        super.afterLoaded();

        FluidStack fuel = getValue(LiquidFuelRecipeSchema.FUEL);
        if (fuel != null && fuel.getAmount() > 2_000) {
            throw new IllegalArgumentException("liquid fuel recipe must be at most 2 buckets");
        }
    }
}
