package net.thep2wking.oedldoedlcore.config.conditions;

import com.google.gson.JsonObject;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;
import net.thep2wking.oedldoedlcore.OedldoedlCore;
import net.thep2wking.oedldoedlcore.config.CoreConfig;

public class EnableConversionRecipes implements ICondition {
	private static final ResourceLocation ID = new ResourceLocation(OedldoedlCore.MODID, "enable_conversion_recipes");

	@Override
	public ResourceLocation getID() {
		return ID;
	}

	@Override
	public boolean test() {
		return CoreConfig.enable_conversion_recipes.get();
	}

	public static class Serializer implements IConditionSerializer<EnableConversionRecipes> {
		public static final EnableConversionRecipes.Serializer INSTANCE = new EnableConversionRecipes.Serializer();

		public void write(JsonObject json, EnableConversionRecipes value) {

		}

		public EnableConversionRecipes read(JsonObject json) {
			return new EnableConversionRecipes();
		}

		public ResourceLocation getID() {
			return EnableConversionRecipes.ID;
		}
	}
}