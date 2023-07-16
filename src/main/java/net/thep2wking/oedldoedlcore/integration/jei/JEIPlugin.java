package net.thep2wking.oedldoedlcore.integration.jei;

import baubles.common.items.ItemRing;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.recipe.VanillaRecipeCategoryUid;
import net.minecraft.client.resources.I18n;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;
import net.thep2wking.oedldoedlcore.OedldoedlCore;
import net.thep2wking.oedldoedlcore.config.CoreConfig;
import net.thep2wking.oedldoedlcore.util.ModLogger;

@mezz.jei.api.JEIPlugin
public class JEIPlugin implements IModPlugin {
	@SuppressWarnings("deprecation")
	@Override
	public void register(IModRegistry registry) {
		if (Loader.isModLoaded("jei")) {
			ModLogger.registeredIntegration("JEI", OedldoedlCore.MODID);
		}

		if (CoreConfig.INTEGRATION.JEI.ADDITIONAL_RECIPE_DESCRIPTIONS) {
			registry.addIngredientInfo(new ItemStack(Items.FIREWORKS), ItemStack.class,
					I18n.format("item.oedldoedlcore.firework_rocket.jei"));
			registry.addIngredientInfo(new ItemStack(Items.FIREWORKS), ItemStack.class,
					I18n.format("item.oedldoedlcore.firework_rocket.jei2"));
			registry.addIngredientInfo(new ItemStack(Items.FIREWORK_CHARGE), ItemStack.class,
					I18n.format("item.oedldoedlcore.firework_star.jei"));
			registry.addIngredientInfo(new ItemStack(Items.FIREWORK_CHARGE), ItemStack.class,
					I18n.format("item.oedldoedlcore.firework_star.jei2"));
		}

		if (!CoreConfig.INTEGRATION.JEI.HIDE_PLAYER_HEAD) {
			registry.getJeiHelpers().getIngredientBlacklist()
					.removeIngredientFromBlacklist(new ItemStack(Items.SKULL, 1, 3));
		}

		if (CoreConfig.INTEGRATION.JEI.ANVIL_RECIPE_CATALYSTS) {
			registry.addRecipeCatalyst(new ItemStack(Blocks.ANVIL, 1, 1), VanillaRecipeCategoryUid.ANVIL);
			registry.addRecipeCatalyst(new ItemStack(Blocks.ANVIL, 1, 2), VanillaRecipeCategoryUid.ANVIL);
		}

		if (CoreConfig.INTEGRATION.JEI.HIDE_BAUBLES_MINERS_RING && Loader.isModLoaded("baubles")) {
			registry.getJeiHelpers().getIngredientBlacklist()
					.addIngredientToBlacklist(new ItemStack(ItemRing.RING, 1, 0));
		}

		if (CoreConfig.INTEGRATION.JEI.HIDE_AE2_FACADES && Loader.isModLoaded("appliedenergistics2")) {
			registry.getJeiHelpers().getIngredientBlacklist()
					.addIngredientToBlacklist(new ItemStack(Item.getByNameOrId("appliedenergistics2:facade"), 1, 0));
		}

		if (CoreConfig.INTEGRATION.JEI.HIDE_BUILDCRAFT_FACADES && Loader.isModLoaded("buildcraftsilicon")) {
			registry.getJeiHelpers().getIngredientBlacklist()
					.addIngredientToBlacklist(new ItemStack(Item.getByNameOrId("buildcraftsilicon:plug_facade"), 1, 0));
		}
	}
}