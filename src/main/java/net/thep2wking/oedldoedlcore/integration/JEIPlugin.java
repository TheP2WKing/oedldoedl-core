package net.thep2wking.oedldoedlcore.integration;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TranslationTextComponent;
import net.thep2wking.oedldoedlcore.OedldoedlCore;
import net.thep2wking.oedldoedlcore.config.CoreConfig;

@JeiPlugin
public class JEIPlugin implements IModPlugin {
	@Override
	public ResourceLocation getPluginUid() {
		return new ResourceLocation(OedldoedlCore.MODID, "jei_plugin");
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		if (CoreConfig.jei_descriptions.get()) {
			registration.addIngredientInfo(new ItemStack(Items.FIREWORK_STAR.asItem()), VanillaTypes.ITEM,
					new TranslationTextComponent("item.oedldoedlcore.firework_star.jei"));
			registration.addIngredientInfo(new ItemStack(Items.FIREWORK_STAR.asItem()), VanillaTypes.ITEM,
					new TranslationTextComponent("item.oedldoedlcore.firework_star.jei2"));
			registration.addIngredientInfo(new ItemStack(Items.FIREWORK_ROCKET.asItem()), VanillaTypes.ITEM,
					new TranslationTextComponent("item.oedldoedlcore.firework_rocket.jei"));
			registration.addIngredientInfo(new ItemStack(Items.FIREWORK_ROCKET.asItem()), VanillaTypes.ITEM,
					new TranslationTextComponent("item.oedldoedlcore.firework_rocket.jei2"));
			registration.addIngredientInfo(new ItemStack(Blocks.COAL_ORE.asItem()), VanillaTypes.ITEM,
					new TranslationTextComponent("block.oedldoedlcore.coal_ore.jei"));
			registration.addIngredientInfo(new ItemStack(Blocks.IRON_ORE.asItem()), VanillaTypes.ITEM,
					new TranslationTextComponent("block.oedldoedlcore.iron_ore.jei"));
			registration.addIngredientInfo(new ItemStack(Blocks.GOLD_ORE.asItem()), VanillaTypes.ITEM,
					new TranslationTextComponent("block.oedldoedlcore.gold_ore.jei"));
			registration.addIngredientInfo(new ItemStack(Blocks.LAPIS_ORE.asItem()), VanillaTypes.ITEM,
					new TranslationTextComponent("block.oedldoedlcore.lapis_ore.jei"));
			registration.addIngredientInfo(new ItemStack(Blocks.REDSTONE_ORE.asItem()), VanillaTypes.ITEM,
					new TranslationTextComponent("block.oedldoedlcore.redstone_ore.jei"));
			registration.addIngredientInfo(new ItemStack(Blocks.DIAMOND_ORE.asItem()), VanillaTypes.ITEM,
					new TranslationTextComponent("block.oedldoedlcore.diamond_ore.jei"));
			registration.addIngredientInfo(new ItemStack(Blocks.EMERALD_ORE.asItem()), VanillaTypes.ITEM,
					new TranslationTextComponent("block.oedldoedlcore.emerald_ore.jei"));
			registration.addIngredientInfo(new ItemStack(Blocks.NETHER_QUARTZ_ORE.asItem()), VanillaTypes.ITEM,
					new TranslationTextComponent("block.oedldoedlcore.nether_quartz_ore.jei"));
			registration.addIngredientInfo(new ItemStack(Blocks.NETHER_GOLD_ORE.asItem()), VanillaTypes.ITEM,
					new TranslationTextComponent("block.oedldoedlcore.nether_gold_ore.jei"));
			registration.addIngredientInfo(new ItemStack(Blocks.ANCIENT_DEBRIS.asItem()), VanillaTypes.ITEM,
					new TranslationTextComponent("block.oedldoedlcore.ancient_debris.jei"));
		}
	}
}