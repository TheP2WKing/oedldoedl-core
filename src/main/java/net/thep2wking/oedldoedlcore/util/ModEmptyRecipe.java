package net.thep2wking.oedldoedlcore.util;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class ModEmptyRecipe implements IRecipe {
	public final IRecipe recipeToModify;

	public ModEmptyRecipe(IRecipe recipeToModify) {
		this.recipeToModify = recipeToModify;
	}

	@Override
	public boolean matches(InventoryCrafting inv, World worldIn) {
		return recipeToModify.matches(inv, worldIn);
	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting inv) {
		return ItemStack.EMPTY;
	}

	@Override
	public boolean canFit(int width, int height) {
		return recipeToModify.canFit(width, height);
	}

	@Override
	public ItemStack getRecipeOutput() {
		return ItemStack.EMPTY;
	}

	@Override
	public IRecipe setRegistryName(ResourceLocation name) {
		return recipeToModify.setRegistryName(name);
	}

	@Override
	public ResourceLocation getRegistryName() {
		return recipeToModify.getRegistryName();
	}

	@Override
	public Class<IRecipe> getRegistryType() {
		return recipeToModify.getRegistryType();
	}
}