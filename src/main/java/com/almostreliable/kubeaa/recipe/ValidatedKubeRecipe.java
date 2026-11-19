package com.almostreliable.kubeaa.recipe;

import dev.latvian.mods.kubejs.error.InvalidRecipeComponentValueException;
import dev.latvian.mods.kubejs.recipe.KubeRecipe;
import dev.latvian.mods.kubejs.recipe.RecipeKey;
import dev.latvian.mods.kubejs.recipe.component.RecipeValidationContext;
import dev.latvian.mods.kubejs.script.ConsoleJS;

abstract class ValidatedKubeRecipe extends KubeRecipe {

    @Override
    public void validate(RecipeValidationContext cx) {
        validateValues();
    }

    @Override
    public <T> KubeRecipe setValue(RecipeKey<T> key, T value) {
        super.setValue(key, value);

        try {
            validateValues();
        } catch (InvalidRecipeComponentValueException e) {
            var message = "Removed recipe " + this + " because of an invalid '" + key.name + "' value: " + e.getMessage();
            ConsoleJS.SERVER.error(message).withSourceLine(sourceLine);
            remove();
        }

        return this;
    }

    abstract void validateValues();

    void validateMinimum(RecipeKey<Integer> key, int minimum, String message) {
        Integer value = getValue(key);
        if (value == null || value >= minimum) return;

        throw new InvalidRecipeComponentValueException(message, key.component, value).source(sourceLine);
    }
}
