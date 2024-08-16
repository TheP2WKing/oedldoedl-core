package net.thep2wking.oedldoedlcore.integration.jei;

import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.recipe.VanillaRecipeCategoryUid;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.thep2wking.oedldoedlcore.OedldoedlCore;
import net.thep2wking.oedldoedlcore.api.integration.ModJEIPluginBase;
import net.thep2wking.oedldoedlcore.api.item.ModItemIconBase;
import net.thep2wking.oedldoedlcore.config.CoreConfig;
import net.thep2wking.oedldoedlcore.init.ModItems;

@JEIPlugin
public class OedldoedlCoreJEIPlugin extends ModJEIPluginBase {
	@Override
	public String getModId() {
		return OedldoedlCore.MODID;
	}

	@Override
	public void register(IModRegistry registry) {
		super.register(registry);

		if (CoreConfig.INTEGRATION.JEI.ADDITIONAL_RECIPE_DESCRIPTIONS) {
			addItemInfo(registry, Items.FIREWORKS, "firework_rocket", 2);
			addItemInfo(registry, Items.FIREWORK_CHARGE, "firework_star", 2);
		}

		if (!CoreConfig.INTEGRATION.JEI.HIDE_PLAYER_HEAD) {
			hideItem(registry, new ItemStack(Items.SKULL, 1, 3));
		}

		if (CoreConfig.INTEGRATION.JEI.ANVIL_RECIPE_CATALYSTS) {
			addRecipeCatalyst(registry, new ItemStack(Blocks.ANVIL, 1, 1), VanillaRecipeCategoryUid.ANVIL);
			addRecipeCatalyst(registry, new ItemStack(Blocks.ANVIL, 1, 2), VanillaRecipeCategoryUid.ANVIL);
		}

		if (CoreConfig.INTEGRATION.JEI.HIDE_BAUBLES_MINERS_RING && Loader.isModLoaded("baubles")) {
			hideItem(registry, new ItemStack(Item.getByNameOrId("baubles:ring")));
		}

		if (CoreConfig.INTEGRATION.JEI.HIDE_AE2_FACADES && Loader.isModLoaded("appliedenergistics2")) {
			hideItem(registry, new ItemStack(Item.getByNameOrId("appliedenergistics2:facade")));
		}

		if (CoreConfig.INTEGRATION.JEI.HIDE_BUILDCRAFT_FACADES && Loader.isModLoaded("buildcraftsilicon")) {
			hideItem(registry, new ItemStack(Item.getByNameOrId("buildcraftsilicon:plug_facade")));
		}

		if (!CoreConfig.CONTENT.DEBUG_STICK_USEABLE_IN_SURVIVAL) {
			hideItem(registry, new ItemStack(ModItems.DEBUG_STICK));
		}

		if (CoreConfig.INTEGRATION.JEI.HIDE_OEDLDOEDL_LOGO_ICONS) {
			for (Item item : ForgeRegistries.ITEMS) {
				if (item instanceof ModItemIconBase) {
					hideItem(registry, new ItemStack(item));
				}
			}
		}
	}
}