package net.thep2wking.oedldoedlcore.integration.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import net.minecraft.client.resources.I18n;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;
import net.thep2wking.oedldoedlcore.OedldoedlCore;
import net.thep2wking.oedldoedlcore.util.ModLogger;

@mezz.jei.api.JEIPlugin
public class JEIPlugin implements IModPlugin {
	@SuppressWarnings("deprecation")
	@Override
	public void register(IModRegistry registry) {
		if (Loader.isModLoaded("jei")) {
			ModLogger.registeredIntegration("JEI", OedldoedlCore.MODID);
		}

		registry.addIngredientInfo(new ItemStack(Items.FIREWORKS), ItemStack.class,
				I18n.format("item.oedldoedlcore.firework_rocket.jei"));
		registry.addIngredientInfo(new ItemStack(Items.FIREWORKS), ItemStack.class,
				I18n.format("item.oedldoedlcore.firework_rocket.jei2"));
		registry.addIngredientInfo(new ItemStack(Items.FIREWORK_CHARGE), ItemStack.class,
				I18n.format("item.oedldoedlcore.firework_star.jei"));
		registry.addIngredientInfo(new ItemStack(Items.FIREWORK_CHARGE), ItemStack.class,
				I18n.format("item.oedldoedlcore.firework_star.jei2"));
	}
}