package com.almostreliable.kubeaa.mixin;

import com.mojang.serialization.Codec;
import de.ellpeck.actuallyadditions.mod.crafting.CrushingRecipe;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.throwables.MixinError;

@Mixin(CrushingRecipe.Serializer.class)
public interface CrushingRecipeSerializerAccessor {

    @Accessor(value = "RESULT_CODEC", remap = false)
    static Codec<CrushingRecipe.CrushingResult> getCodec() {
        throw new MixinError();
    }
}
