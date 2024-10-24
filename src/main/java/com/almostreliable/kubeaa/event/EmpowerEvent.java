package com.almostreliable.kubeaa.event;

import de.ellpeck.actuallyadditions.mod.crafting.EmpowererRecipe;
import dev.latvian.mods.kubejs.event.KubeEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class EmpowerEvent implements KubeEvent {

    private final ServerLevel level;
    private final BlockPos pos;
    private final BlockState state;
    private final RecipeHolder<EmpowererRecipe> recipe;
    @Nullable private final UUID playerId;

    public EmpowerEvent(
        ServerLevel level, BlockPos pos, BlockState state, RecipeHolder<EmpowererRecipe> recipe, @Nullable UUID playerId
    ) {
        this.level = level;
        this.pos = pos;
        this.state = state;
        this.recipe = recipe;
        this.playerId = playerId;
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

    @Nullable
    public ServerPlayer getPlayer() {
        Player player = playerId == null ? null : level.getPlayerByUUID(playerId);
        return player instanceof ServerPlayer serverPlayer ? serverPlayer : null;
    }
}
