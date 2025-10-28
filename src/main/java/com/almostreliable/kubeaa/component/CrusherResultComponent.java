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
    public boolean isEmpty(CrushingResult value) {
        return value == CrushingResult.EMPTY || value.stack().isEmpty();
    }
}
