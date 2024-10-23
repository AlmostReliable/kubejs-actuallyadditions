package com.almostreliable.kubeaa.binding;

import de.ellpeck.actuallyadditions.mod.crafting.CrushingRecipe;
import net.minecraft.world.item.ItemStack;

public final class CrushingResultBinding {

    private CrushingResultBinding() {}

    public static CrushingRecipe.CrushingResult of(ItemStack stack) {
        return new CrushingRecipe.CrushingResult(stack, 1f);
    }

    public static CrushingRecipe.CrushingResult of(ItemStack stack, float chance) {
        return new CrushingRecipe.CrushingResult(stack, chance);
    }
}
