package com.almostreliable.kubeaa.schema;

import com.almostreliable.kubeaa.recipe.PressKubeRecipe;
import de.ellpeck.actuallyadditions.data.MiscMachineRecipeGenerator;
import de.ellpeck.actuallyadditions.mod.crafting.PressingRecipe;
import dev.latvian.mods.kubejs.recipe.RecipeKey;
import dev.latvian.mods.kubejs.recipe.component.ComponentRole;
import dev.latvian.mods.kubejs.recipe.component.FluidStackComponent;
import dev.latvian.mods.kubejs.recipe.component.IngredientComponent;
import dev.latvian.mods.kubejs.recipe.schema.RecipeSchema;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.fluids.FluidStack;

/**
 * See {@link PressingRecipe.Serializer} and {@link MiscMachineRecipeGenerator}.
 */
public interface PressRecipeSchema {

    RecipeKey<FluidStack> FLUID = FluidStackComponent.FLUID_STACK
        .key("fluid", ComponentRole.OUTPUT)
        .noFunctions();
    RecipeKey<Ingredient> INGREDIENT = IngredientComponent.NON_EMPTY_INGREDIENT
        .key("ingredient", ComponentRole.INPUT)
        .noFunctions();

    RecipeSchema SCHEMA = new RecipeSchema(FLUID, INGREDIENT).factory(PressKubeRecipe.FACTORY);
}
