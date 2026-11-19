package com.almostreliable.kubeaa.mixin;

import com.almostreliable.kubeaa.KubePlugin;
import com.almostreliable.kubeaa.event.EmpowerEvent;
import com.almostreliable.kubeaa.extension.TileEntityEmpowererExtension;

import com.llamalad7.mixinextras.sugar.Local;
import de.ellpeck.actuallyadditions.mod.crafting.EmpowererRecipe;
import de.ellpeck.actuallyadditions.mod.tile.TileEntityEmpowerer;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import org.jetbrains.annotations.Nullable;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.UUID;

@Mixin(TileEntityEmpowerer.class)
public abstract class TileEntityEmpowererMixin implements TileEntityEmpowererExtension {

    @Unique
    @Nullable
    private UUID kjsaa$playerId;

    @Inject(
        method = "serverTick",
        at = @At(
            value = "INVOKE",
            target = "Lde/ellpeck/actuallyadditions/mod/util/ItemStackHandlerAA;setStackInSlot(ILnet/minecraft/world/item/ItemStack;)V",
            shift = At.Shift.AFTER
        )
    )
    private static <T extends BlockEntity> void onResultSet(
        Level level,
        BlockPos pos,
        BlockState state,
        T t,
        CallbackInfo ci,
        @Local(name = "holder") RecipeHolder<EmpowererRecipe> holder
    ) {
        if (level instanceof ServerLevel serverLevel && t instanceof TileEntityEmpowerer blockEntity) {
            var empowerer = (TileEntityEmpowererMixin) (Object) blockEntity;
            var event = new EmpowerEvent(serverLevel, pos, state, holder, empowerer.kjsaa$playerId);
            KubePlugin.Events.EMPOWER.post(event);
            empowerer.kjsaa$playerId = null;
        }
    }

    @Override
    @Unique
    public void kjsaa$setPlayer(@Nullable UUID playerId) {
        kjsaa$playerId = playerId;
    }
}
