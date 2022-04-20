package net.thep2wking.oedldoedlcore.init;

import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.thep2wking.oedldoedlcore.OedldoedlCore;
import net.thep2wking.oedldoedlcore.config.conditions.EnableAdditionalRecipes;
import net.thep2wking.oedldoedlcore.config.conditions.EnableConversionRecipes;
import net.thep2wking.oedldoedlcore.config.conditions.EnableModRecipes;

public class ModConditions {
	@SubscribeEvent
	public void onRegisterSerializers(RegistryEvent.Register<IRecipeSerializer<?>> event) {
		CraftingHelper.register(EnableConversionRecipes.Serializer.INSTANCE);
		CraftingHelper.register(EnableAdditionalRecipes.Serializer.INSTANCE);
		CraftingHelper.register(EnableModRecipes.Serializer.INSTANCE);

		OedldoedlCore.LOGGER.info("Registerd Serializers for " + OedldoedlCore.MODID + "!");
	}
}