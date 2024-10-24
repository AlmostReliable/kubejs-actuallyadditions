package com.almostreliable.kubeaa.mixin;

import com.almostreliable.kubeaa.extension.TileEntityEmpowererExtension;
import com.llamalad7.mixinextras.sugar.Local;
import de.ellpeck.actuallyadditions.mod.blocks.BlockDisplayStand;
import de.ellpeck.actuallyadditions.mod.tile.TileEntityInventoryBase;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockDisplayStand.class)
public class BlockDisplayStandMixin {

    @Shadow
    @Final
    private boolean isEmpowerer;

    @Inject(method = "useItemOn", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/player/Player;isCreative()Z"))
    private void onItemInsert(
        ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand,
        BlockHitResult hitResult, CallbackInfoReturnable<ItemInteractionResult> cir,
        @Local TileEntityInventoryBase blockEntity
    ) {
        if (!isEmpowerer) return;
        ((TileEntityEmpowererExtension) blockEntity).kjsaa$setPlayer(player.getUUID());
    }
}
