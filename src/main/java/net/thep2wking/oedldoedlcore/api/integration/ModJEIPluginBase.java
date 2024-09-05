package net.thep2wking.oedldoedlcore.api.integration;

import java.util.Collection;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.recipe.IRecipeCategory;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.Loader;
import net.thep2wking.oedldoedlcore.util.ModLogger;

public abstract class ModJEIPluginBase implements IModPlugin {
	@Override
	public void register(IModRegistry registry) {
		if (Loader.isModLoaded("jei")) {
			ModLogger.registeredIntegration("JEI", getModId());
		}
	}

	@Override
	public void registerCategories(IRecipeCategoryRegistration registry) {
	}

	public abstract String getModId();

	public String translationSuffix(String name) {
		return "." + getModId() + "." + name + ".jei";
	}

	@SuppressWarnings("deprecation")
	public void addItemInfo(IModRegistry registry, Item item, String itemName) {
		TextComponentTranslation translation = new TextComponentTranslation("item" + translationSuffix(itemName) + 1);
		registry.addIngredientInfo(new ItemStack(item), ItemStack.class, translation.getFormattedText());
	}

	@SuppressWarnings("deprecation")
	public void addItemInfo(IModRegistry registry, Item item, String itemName, int entries) {
		for (int i = 1; i < (entries + 1); i++) {
			TextComponentTranslation translation = new TextComponentTranslation(
					"item" + translationSuffix(itemName) + i);
			registry.addIngredientInfo(new ItemStack(item), ItemStack.class, translation.getFormattedText());
		}
	}

	@SuppressWarnings("deprecation")
	public void addBlockInfo(IModRegistry registry, Block block, String blockName) {
		TextComponentTranslation translation = new TextComponentTranslation("tile" + translationSuffix(blockName) + 1);
		registry.addIngredientInfo(new ItemStack(block), ItemStack.class, translation.getFormattedText());
	}

	@SuppressWarnings("deprecation")
	public void addBlockInfo(IModRegistry registry, Block block, String blockName, int entries) {
		for (int i = 1; i < (entries + 1); i++) {
			TextComponentTranslation translation = new TextComponentTranslation(
					"tile" + translationSuffix(blockName) + i);
			registry.addIngredientInfo(new ItemStack(block), ItemStack.class, translation.getFormattedText());
		}
	}

	@SuppressWarnings("deprecation")
	public void addStackInfo(IModRegistry registry, ItemStack stack, String stackName) {
		String prefix = stack.getItem() instanceof ItemBlock ? "tile" : "item";
		TextComponentTranslation translation = new TextComponentTranslation(prefix + translationSuffix(stackName) + 1);
		registry.addIngredientInfo(stack, ItemStack.class, translation.getFormattedText());
	}

	@SuppressWarnings("deprecation")
	public void addStackInfo(IModRegistry registry, ItemStack stack, String stackName, int entries) {
		String prefix = stack.getItem() instanceof ItemBlock ? "tile" : "item";
		for (int i = 1; i < (entries + 1); i++) {
			TextComponentTranslation translation = new TextComponentTranslation(
					prefix + translationSuffix(stackName) + i);
			registry.addIngredientInfo(stack, ItemStack.class, translation.getFormattedText());
		}
	}

	@SuppressWarnings("deprecation")
	public void addFluidStackInfo(IModRegistry registry, FluidStack fluidStack, String fluidName) {
		TextComponentTranslation translation = new TextComponentTranslation("fluid" + translationSuffix(fluidName) + 1);
		registry.addIngredientInfo(fluidStack, FluidStack.class, translation.getFormattedText());
	}

	@SuppressWarnings("deprecation")
	public void addFluidStackInfo(IModRegistry registry, FluidStack fluidStack, String fluidName, int entries) {
		for (int i = 1; i < (entries + 1); i++) {
			TextComponentTranslation translation = new TextComponentTranslation(
					"fluid" + translationSuffix(fluidName) + i);
			registry.addIngredientInfo(fluidStack, FluidStack.class, translation.getFormattedText());
		}
	}

	public void hideItem(IModRegistry registry, ItemStack stack) {
		registry.getJeiHelpers().getIngredientBlacklist().addIngredientToBlacklist(stack);
	}

	public void unhideItem(IModRegistry registry, ItemStack stack) {
		registry.getJeiHelpers().getIngredientBlacklist().removeIngredientFromBlacklist(stack);
	}

	public void addRecipeCatalyst(IModRegistry registry, ItemStack stack, String recipeCategory) {
		registry.addRecipeCatalyst(stack, recipeCategory);
	}

	@SuppressWarnings("rawtypes")
	public void addRecipeCategory(IRecipeCategoryRegistration registry, IRecipeCategory recipeCategory) {
		registry.addRecipeCategories(recipeCategory);
	}

	public IGuiHelper getGuiHelper(IRecipeCategoryRegistration registry) {
		return registry.getJeiHelpers().getGuiHelper();
	}

	public void addRecipes(IModRegistry registry, Collection<?> list, String recipeCategory) {
		registry.addRecipes(list, recipeCategory);
	}
}