package com.almostreliable.kubeaa.component;

import com.almostreliable.kubeaa.binding.EffectInstanceBinding;
import com.mojang.serialization.Codec;
import de.ellpeck.actuallyadditions.mod.crafting.CoffeeIngredientRecipe;
import dev.latvian.mods.kubejs.recipe.KubeRecipe;
import dev.latvian.mods.kubejs.recipe.component.RecipeComponent;
import dev.latvian.mods.rhino.Context;
import dev.latvian.mods.rhino.type.TypeInfo;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;

public record EffectInstanceComponent() implements RecipeComponent<CoffeeIngredientRecipe.EffectInstance> {

    public static final RecipeComponent<CoffeeIngredientRecipe.EffectInstance> EFFECT_INSTANCE = new EffectInstanceComponent();

    @Override
    public Codec<CoffeeIngredientRecipe.EffectInstance> codec() {
        return CoffeeIngredientRecipe.EffectInstance.CODEC;
    }

    @Override
    public TypeInfo typeInfo() {
        return TypeInfo.of(CoffeeIngredientRecipe.EffectInstance.class)
            .or(TypeInfo.of(Holder.class).withParams(TypeInfo.of(MobEffect.class)))
            .or(TypeInfo.of(ResourceLocation.class));
    }

    @Override
    public CoffeeIngredientRecipe.EffectInstance wrap(Context cx, KubeRecipe recipe, Object from) {
        if (from instanceof CoffeeIngredientRecipe.EffectInstance e) {
            return e;
        }

        if (from instanceof Holder<?>) {
            try {
                @SuppressWarnings("unchecked")
                Holder<MobEffect> effect = (Holder<MobEffect>) cx.jsToJava(
                    from,
                    TypeInfo.of(Holder.class).withParams(TypeInfo.of(MobEffect.class))
                );
                return EffectInstanceBinding.ofEffect(effect);
            } catch (Exception e) {
                throw new IllegalArgumentException("invalid effect instance holder: " + from, e);
            }
        }

        ResourceLocation effect = switch (from) {
            case String s -> ResourceLocation.tryParse(s);
            case ResourceLocation l -> l;
            default -> throw new IllegalArgumentException("invalid effect instance: " + from);
        };

        if (effect == null) {
            throw new IllegalArgumentException("effect is not a valid ResourceLocation: " + from);
        }

        if (!BuiltInRegistries.MOB_EFFECT.containsKey(effect)) {
            throw new IllegalArgumentException("effect does not exist: " + from);
        }

        return EffectInstanceBinding.ofId(effect);
    }
}
