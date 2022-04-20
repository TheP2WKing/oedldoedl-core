package net.thep2wking.oedldoedlcore.config.conditions;

import com.google.gson.JsonObject;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;
import net.thep2wking.oedldoedlcore.OedldoedlCore;
import net.thep2wking.oedldoedlcore.config.CoreConfig;

public class EnableAdditionalRecipes implements ICondition {
	private static final ResourceLocation ID = new ResourceLocation(OedldoedlCore.MODID, "enable_additional_recipes");

	@Override
	public ResourceLocation getID() {
		return ID;
	}

	@Override
	public boolean test() {
		return CoreConfig.enable_additional_recipes.get();
	}

	public static class Serializer implements IConditionSerializer<EnableAdditionalRecipes> {
		public static final EnableAdditionalRecipes.Serializer INSTANCE = new EnableAdditionalRecipes.Serializer();

		public void write(JsonObject json, EnableAdditionalRecipes value) {

		}

		public EnableAdditionalRecipes read(JsonObject json) {
			return new EnableAdditionalRecipes();
		}

		public ResourceLocation getID() {
			return EnableAdditionalRecipes.ID;
		}
	}
}