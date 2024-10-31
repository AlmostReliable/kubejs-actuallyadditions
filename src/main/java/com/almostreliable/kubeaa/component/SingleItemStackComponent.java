package com.almostreliable.kubeaa.component;

import com.mojang.serialization.Codec;
import dev.latvian.mods.kubejs.recipe.component.ItemStackComponent;
import net.minecraft.world.item.ItemStack;

public final class SingleItemStackComponent extends ItemStackComponent {

    public static final SingleItemStackComponent STRICT_SINGLE_ITEM = new SingleItemStackComponent();

    private SingleItemStackComponent() {
        super("strict_single_item", ItemStack.STRICT_SINGLE_ITEM_CODEC);
    }

    @Override
    public Codec<ItemStack> codec() {
        return ItemStack.STRICT_SINGLE_ITEM_CODEC;
    }
}
