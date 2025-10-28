package com.almostreliable.kubeaa.component;

import com.almostreliable.kubeaa.ModInitializer;
import com.almostreliable.kubeaa.binding.EffectInstanceBinding;
import com.mojang.serialization.Codec;
import de.ellpeck.actuallyadditions.mod.crafting.CoffeeIngredientRecipe.EffectInstance;
import dev.latvian.mods.kubejs.holder.HolderWrapper;
import dev.latvian.mods.kubejs.recipe.RecipeScriptContext;
import dev.latvian.mods.kubejs.recipe.component.RecipeComponent;
import dev.latvian.mods.kubejs.recipe.component.RecipeComponentType;
import dev.latvian.mods.kubejs.util.Cast;
import dev.latvian.mods.rhino.type.TypeInfo;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;

public record EffectInstanceComponent(RecipeComponentType<?> type) implements RecipeComponent<EffectInstance> {

    public static final RecipeComponentType<EffectInstance> TYPE = RecipeComponentType.unit(
        ModInitializer.getRL("coffee_ingredient"),
        EffectInstanceComponent::new
    );

    @Override
    public Codec<EffectInstance> codec() {
        return EffectInstance.CODEC;
    }

    @Override
    public TypeInfo typeInfo() {
        return TypeInfo.of(EffectInstance.class)
            .or(TypeInfo.of(Holder.class).withParams(TypeInfo.of(MobEffect.class)))
            .or(TypeInfo.of(ResourceLocation.class));
    }

    @Override
    public EffectInstance wrap(RecipeScriptContext cx, Object from) {
        if (from instanceof EffectInstance e) {
            return e;
        }

        if (from instanceof Holder<?>) {
            try {
                Holder<MobEffect> effect = Cast.to(HolderWrapper.wrap(
                    Cast.to(cx.cx()),
                    from,
                    TypeInfo.of(MobEffect.class)
                ));
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
