package com.almostreliable.kubeaa;

import com.almostreliable.kubejs_actuallyadditions.ModConstants;
import com.mojang.logging.LogUtils;
import de.ellpeck.actuallyadditions.api.ActuallyAdditionsAPI;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

@Mod(ModConstants.MOD_ID)
public final class ModInitializer {

    private static final Logger LOGGER = LogUtils.getLogger();

    public ModInitializer() {
        LOGGER.info("Loading Actually Additions integration for KubeJS.");
    }

    public static ResourceLocation getRL(String path) {
        return ResourceLocation.fromNamespaceAndPath(ActuallyAdditionsAPI.MOD_ID, path);
    }
}
