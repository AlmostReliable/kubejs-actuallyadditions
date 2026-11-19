package com.almostreliable.kubeaa.component;

import com.almostreliable.kubeaa.ModInitializer;
import com.almostreliable.kubeaa.binding.CrushingResultBinding;
import com.almostreliable.kubeaa.mixin.CrushingRecipeSerializerAccessor;

import com.mojang.serialization.Codec;
import de.ellpeck.actuallyadditions.mod.crafting.CrushingRecipe.CrushingResult;
import dev.latvian.mods.kubejs.plugin.builtin.wrapper.ItemWrapper;
import dev.latvian.mods.kubejs.recipe.RecipeScriptContext;
import dev.latvian.mods.kubejs.recipe.component.RecipeComponent;
import dev.latvian.mods.kubejs.recipe.component.RecipeComponentType;
import dev.latvian.mods.kubejs.recipe.filter.RecipeMatchContext;
import dev.latvian.mods.kubejs.recipe.match.ItemMatch;
import dev.latvian.mods.kubejs.recipe.match.Replaceable;
import dev.latvian.mods.kubejs.recipe.match.ReplacementMatchInfo;
import dev.latvian.mods.rhino.type.TypeInfo;

import net.minecraft.world.item.ItemStack;

public record CrusherResultComponent(RecipeComponentType<?> type) implements RecipeComponent<CrushingResult> {

    public static final RecipeComponentType<CrushingResult> TYPE = RecipeComponentType.unit(
        ModInitializer.getRL("crushing_result"),
        CrusherResultComponent::new
    );

    @Override
    public Codec<CrushingResult> codec() {
        return CrushingRecipeSerializerAccessor.getCodec();
    }

    @Override
    public TypeInfo typeInfo() {
        return TypeInfo.of(CrushingResult.class).or(ItemWrapper.TYPE_INFO);
    }

    @Override
    public CrushingResult wrap(RecipeScriptContext cx, Object from) {
        if (from instanceof CrushingResult r) {
            return r;
        }

        ItemStack stack = ItemWrapper.wrap(cx.cx(), from);

        return stack.isEmpty() ? CrushingResult.EMPTY : CrushingResultBinding.of(stack);
    }

    @Override
    public boolean matches(RecipeMatchContext cx, CrushingResult value, ReplacementMatchInfo match) {
        return match.match() instanceof ItemMatch m && !value.stack().isEmpty() && m.matches(cx, value.stack(), match.exact());
    }

    @Override
    public CrushingResult replace(RecipeScriptContext cx, CrushingResult original, ReplacementMatchInfo match, Object with) {
        if (!matches(cx, original, match)) return original;

        var replacement = ((Replaceable) (Object) original.stack()).replaceThisWith(cx, with);
        var stack = ItemWrapper.wrap(cx.cx(), replacement);
        return CrushingResultBinding.of(stack, original.chance());
    }

    @Override
    public boolean allowEmpty() {
        // actually additions writes an empty second result for single output recipes
        return true;
    }

    @Override
    public boolean isEmpty(CrushingResult value) {
        return value == CrushingResult.EMPTY || value.stack().isEmpty();
    }
}
