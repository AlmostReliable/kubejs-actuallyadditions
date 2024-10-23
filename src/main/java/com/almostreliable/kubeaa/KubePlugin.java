package com.almostreliable.kubeaa;

import com.almostreliable.kubeaa.binding.CrushingResultBinding;
import com.almostreliable.kubeaa.binding.EffectInstanceBinding;
import com.almostreliable.kubeaa.component.CrusherResultComponent;
import com.almostreliable.kubeaa.component.EffectInstanceComponent;
import com.almostreliable.kubeaa.event.EmpowerEvent;
import com.almostreliable.kubeaa.recipe.*;
import com.almostreliable.kubeaa.schema.*;
import de.ellpeck.actuallyadditions.api.ActuallyAdditionsAPI;
import de.ellpeck.actuallyadditions.mod.crafting.*;
import dev.latvian.mods.kubejs.event.EventGroup;
import dev.latvian.mods.kubejs.event.EventGroupRegistry;
import dev.latvian.mods.kubejs.event.EventHandler;
import dev.latvian.mods.kubejs.plugin.KubeJSPlugin;
import dev.latvian.mods.kubejs.recipe.schema.*;
import dev.latvian.mods.kubejs.script.BindingRegistry;
import net.minecraft.world.effect.MobEffects;

import java.util.Map;

public class KubePlugin implements KubeJSPlugin {

    @Override
    public void registerEvents(EventGroupRegistry registry) {
        registry.register(Events.GROUP);
    }

    @Override
    public void registerBindings(BindingRegistry registry) {
        if (registry.type().isServer()) {
            registry.add("CrushingResult", CrushingResultBinding.class);
            registry.add("EffectInstance", EffectInstanceBinding.class);
            registry.add("MobEffect", MobEffects.class);
        }
    }

    @Override
    public void registerRecipeComponents(RecipeComponentFactoryRegistry registry) {
        registry.register(CrusherResultComponent.CRUSHING_RESULT);
        registry.register(EffectInstanceComponent.EFFECT_INSTANCE);
    }

    @Override
    public void registerRecipeFactories(RecipeFactoryRegistry registry) {
        registry.register(CrusherKubeRecipe.FACTORY);
        registry.register(EmpowererKubeRecipe.FACTORY);
        registry.register(FermenterKubeRecipe.FACTORY);
        registry.register(LiquidFuelKubeRecipe.FACTORY);
        registry.register(PressKubeRecipe.FACTORY);
    }

    @Override
    public void registerRecipeSchemas(RecipeSchemaRegistry registry) {
        Map<String, RecipeSchema> machineRecipeSchemas = Map.of(
            CrushingRecipe.NAME, CrusherRecipeSchema.SCHEMA,
            EmpowererRecipe.NAME, EmpowererRecipeSchema.SCHEMA,
            FermentingRecipe.NAME, FermenterRecipeSchema.SCHEMA,
            LaserRecipe.NAME, LaserRecipeSchema.SCHEMA,
            PressingRecipe.NAME, PressRecipeSchema.SCHEMA
        );

        Map<String, RecipeSchema> miscRecipeSchemas = Map.of(
            CoffeeIngredientRecipe.NAME, CoffeeIngredientRecipeSchema.SCHEMA,
            ColorChangeRecipe.NAME, ColorChangeRecipeSchema.SCHEMA,
            LiquidFuelRecipe.NAME, LiquidFuelRecipeSchema.SCHEMA,
            MiningLensRecipe.NAME, MiningLensRecipeSchema.SCHEMA,
            SolidFuelRecipe.NAME, SolidFuelRecipeSchema.SCHEMA
        );

        RecipeNamespace namespace = registry.namespace(ActuallyAdditionsAPI.MOD_ID);
        for (var schemaEntry : machineRecipeSchemas.entrySet()) {
            namespace.register(schemaEntry.getKey(), schemaEntry.getValue());
        }
        for (var schemaEntry : miscRecipeSchemas.entrySet()) {
            namespace.register(schemaEntry.getKey(), schemaEntry.getValue());
        }
    }

    public interface Events {
        EventGroup GROUP = EventGroup.of("ActuallyAdditionsEvents");
        EventHandler EMPOWER = GROUP.server("empower", () -> EmpowerEvent.class);
    }
}
