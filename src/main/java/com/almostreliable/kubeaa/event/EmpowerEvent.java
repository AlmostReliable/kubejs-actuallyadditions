package com.almostreliable.kubeaa.event;

import de.ellpeck.actuallyadditions.mod.crafting.EmpowererRecipe;
import dev.latvian.mods.kubejs.event.KubeEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.block.state.BlockState;

public class EmpowerEvent implements KubeEvent {

    private final ServerLevel level;
    private final BlockPos pos;
    private final BlockState state;
    private final RecipeHolder<EmpowererRecipe> recipe;

    public EmpowerEvent(ServerLevel level, BlockPos pos, BlockState state, RecipeHolder<EmpowererRecipe> recipe) {
        this.level = level;
        this.pos = pos;
        this.state = state;
        this.recipe = recipe;
    }

    public ServerLevel getLevel() {
        return level;
    }

    public BlockPos getPos() {
        return pos;
    }

    public BlockState getState() {
        return state;
    }

    public ResourceLocation getRecipeId() {
        return recipe.id();
    }

    public EmpowererRecipe getRecipe() {
        return recipe.value();
    }
}
