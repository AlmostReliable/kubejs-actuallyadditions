package com.almostreliable.kubeaa.component;

import com.almostreliable.kubeaa.binding.CrushingResultBinding;
import com.almostreliable.kubeaa.mixin.CrushingRecipeSerializerAccessor;
import com.mojang.serialization.Codec;
import de.ellpeck.actuallyadditions.mod.crafting.CrushingRecipe;
import dev.latvian.mods.kubejs.item.ItemStackJS;
import dev.latvian.mods.kubejs.recipe.KubeRecipe;
import dev.latvian.mods.kubejs.recipe.component.RecipeComponent;
import dev.latvian.mods.kubejs.script.KubeJSContext;
import dev.latvian.mods.kubejs.util.RegistryAccessContainer;
import dev.latvian.mods.rhino.Context;
import dev.latvian.mods.rhino.type.TypeInfo;
import net.minecraft.world.item.ItemStack;

public record CrusherResultComponent() implements RecipeComponent<CrushingRecipe.CrushingResult> {

    public static final RecipeComponent<CrushingRecipe.CrushingResult> CRUSHING_RESULT = new CrusherResultComponent();

    @Override
    public Codec<CrushingRecipe.CrushingResult> codec() {
        return CrushingRecipeSerializerAccessor.getCodec();
    }

    @Override
    public TypeInfo typeInfo() {
        return TypeInfo.of(CrushingRecipe.CrushingResult.class).or(ItemStackJS.TYPE_INFO);
    }

    @Override
    public CrushingRecipe.CrushingResult wrap(Context cx, KubeRecipe recipe, Object from) {
        if (from instanceof CrushingRecipe.CrushingResult r) {
            return r;
        }

        RegistryAccessContainer registryAccess = ((KubeJSContext) cx).getRegistries();
        ItemStack stack = ItemStackJS.wrap(registryAccess, from);
        if (stack.isEmpty()) {
            throw new IllegalArgumentException("empty crushing result: " + from);
        }

        return CrushingResultBinding.of(stack);
    }
}
