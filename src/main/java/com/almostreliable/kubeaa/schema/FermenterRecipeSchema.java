package com.almostreliable.kubeaa.schema;

import com.almostreliable.kubeaa.recipe.FermenterKubeRecipe;
import de.ellpeck.actuallyadditions.data.MiscMachineRecipeGenerator;
import de.ellpeck.actuallyadditions.mod.crafting.FermentingRecipe;
import dev.latvian.mods.kubejs.recipe.RecipeKey;
import dev.latvian.mods.kubejs.recipe.component.ComponentRole;
import dev.latvian.mods.kubejs.recipe.component.FluidStackComponent;
import dev.latvian.mods.kubejs.recipe.component.NumberComponent;
import dev.latvian.mods.kubejs.recipe.schema.RecipeSchema;
import net.neoforged.neoforge.fluids.FluidStack;

/**
 * See {@link FermentingRecipe.Serializer} and {@link MiscMachineRecipeGenerator}.
 */
public interface FermenterRecipeSchema {

    RecipeKey<FluidStack> RESULT = FluidStackComponent.FLUID_STACK
        .key("result", ComponentRole.OUTPUT)
        .noFunctions();
    RecipeKey<FluidStack> INGREDIENT = FluidStackComponent.FLUID_STACK
        .key("ingredient", ComponentRole.OUTPUT)
        .noFunctions();
    RecipeKey<Integer> TIME = NumberComponent.INT
        .key("time", ComponentRole.OTHER)
        .optional(100)
        .alwaysWrite();

    RecipeSchema SCHEMA = new RecipeSchema(RESULT, INGREDIENT, TIME).factory(FermenterKubeRecipe.FACTORY);
}
