package com.almostreliable.kubeaa.binding;

import de.ellpeck.actuallyadditions.mod.crafting.CoffeeIngredientRecipe;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;

public final class EffectInstanceBinding {

    private EffectInstanceBinding() {}

    public static CoffeeIngredientRecipe.EffectInstance ofId(ResourceLocation effect) {
        return ofId(effect, 10);
    }

    public static CoffeeIngredientRecipe.EffectInstance ofId(ResourceLocation effect, int duration) {
        return ofId(effect, duration, 0);
    }

    public static CoffeeIngredientRecipe.EffectInstance ofId(ResourceLocation effect, int duration, int amplifier) {
        return new CoffeeIngredientRecipe.EffectInstance(effect, duration, amplifier);
    }

    public static CoffeeIngredientRecipe.EffectInstance ofEffect(Holder<MobEffect> effect) {
        return of(new MobEffectInstance(effect, 10, 0));
    }

    public static CoffeeIngredientRecipe.EffectInstance ofEffect(Holder<MobEffect> effect, int duration) {
        return of(new MobEffectInstance(effect, duration, 0));
    }

    public static CoffeeIngredientRecipe.EffectInstance ofEffect(
        Holder<MobEffect> effect, int duration, int amplifier
    ) {
        return of(new MobEffectInstance(effect, duration, amplifier));
    }

    private static CoffeeIngredientRecipe.EffectInstance of(MobEffectInstance effect) {
        return new CoffeeIngredientRecipe.EffectInstance(effect);
    }
}
