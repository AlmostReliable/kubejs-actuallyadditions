package com.almostreliable.kubeaa.schema;

import com.almostreliable.kubeaa.recipe.LiquidFuelKubeRecipe;
import de.ellpeck.actuallyadditions.data.FuelRecipeGenerator;
import de.ellpeck.actuallyadditions.mod.crafting.LiquidFuelRecipe;
import dev.latvian.mods.kubejs.recipe.RecipeKey;
import dev.latvian.mods.kubejs.recipe.component.ComponentRole;
import dev.latvian.mods.kubejs.recipe.component.FluidStackComponent;
import dev.latvian.mods.kubejs.recipe.component.NumberComponent;
import dev.latvian.mods.kubejs.recipe.schema.RecipeSchema;
import net.neoforged.neoforge.fluids.FluidStack;

import java.util.List;

/**
 * See {@link LiquidFuelRecipe.Serializer} and {@link FuelRecipeGenerator}.
 */
public interface LiquidFuelRecipeSchema {

    RecipeKey<FluidStack> FUEL = FluidStackComponent.FLUID_STACK
        .key("fuel", ComponentRole.INPUT)
        .noFunctions();
    RecipeKey<Integer> TOTAL_ENERGY = NumberComponent.INT
        .key("total_energy", ComponentRole.INPUT)
        .functionNames(List.of("energy"))
        .optional(1_000)
        .alwaysWrite();
    RecipeKey<Integer> BURN_TIME = NumberComponent.INT
        .key("burn_time", ComponentRole.OTHER)
        .functionNames(List.of("time"))
        .optional(100)
        .alwaysWrite();

    RecipeSchema SCHEMA = new RecipeSchema(FUEL, TOTAL_ENERGY, BURN_TIME).factory(LiquidFuelKubeRecipe.FACTORY);
}
