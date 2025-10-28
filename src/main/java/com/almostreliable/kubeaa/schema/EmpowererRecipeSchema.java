package com.almostreliable.kubeaa.schema;

import de.ellpeck.actuallyadditions.data.EmpoweringRecipeGenerator;
import de.ellpeck.actuallyadditions.mod.crafting.EmpowererRecipe;
import dev.latvian.mods.kubejs.recipe.RecipeKey;
import dev.latvian.mods.kubejs.recipe.component.ComponentRole;
import dev.latvian.mods.kubejs.recipe.component.IngredientComponent;
import dev.latvian.mods.kubejs.recipe.component.ItemStackComponent;
import dev.latvian.mods.kubejs.recipe.component.NumberComponent;
import dev.latvian.mods.kubejs.recipe.schema.RecipeSchema;
import dev.latvian.mods.kubejs.util.IntBounds;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.List;

/**
 * See {@link EmpowererRecipe.Serializer} and {@link EmpoweringRecipeGenerator}.
 */
public interface EmpowererRecipeSchema {

    RecipeKey<ItemStack> RESULT = ItemStackComponent.ITEM_STACK
        .key("result", ComponentRole.OUTPUT)
        .noFunctions();
    RecipeKey<Ingredient> BASE = IngredientComponent.INGREDIENT
        .key("base", ComponentRole.INPUT)
        .noFunctions();
    RecipeKey<List<Ingredient>> MODIFIERS = IngredientComponent.INGREDIENT
        .instance()
        .asList()
        .withBounds(IntBounds.of(4, 4))
        .key("modifiers", ComponentRole.INPUT)
        .noFunctions();
    RecipeKey<Integer> ENERGY = NumberComponent.INT
        .key("energy", ComponentRole.OTHER)
        .optional(1_000)
        .alwaysWrite();
    RecipeKey<Integer> COLOR = NumberComponent.INT
        .key("color", ComponentRole.OTHER)
        .optional(0xFFFF_FFFF)
        .alwaysWrite();
    RecipeKey<Integer> TIME = NumberComponent.INT
        .key("time", ComponentRole.OTHER)
        .optional(100)
        .alwaysWrite();

    RecipeSchema SCHEMA = new RecipeSchema(RESULT, BASE, MODIFIERS, ENERGY, COLOR, TIME);
}
