package net.thep2wking.oedldoedlcore.util;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionType;
import net.minecraft.potion.PotionUtils;
import net.minecraftforge.common.brewing.BrewingRecipe;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandlerItem;

public class ModForgeBucketBrewingRecipe extends BrewingRecipe {
	public final FluidStack fluidStack;

	public ModForgeBucketBrewingRecipe(ItemStack input, ItemStack ingredient, ItemStack output, FluidStack fluidStack) {
		super(input, ingredient, output);
		this.fluidStack = fluidStack;
	}

	@Override
	public boolean isInput(ItemStack input) {
		IFluidHandlerItem fluidHandler = input.getCapability(CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY,
				null);
		if (fluidHandler != null) {
			FluidStack fluidInBucket = fluidHandler.drain(fluidStack, false);
			return fluidInBucket != null && fluidInBucket.isFluidStackIdentical(fluidStack);
		}
		return false;
	}

	private static void addBrewingRecipe(PotionType outputPotionType, PotionType inputPotionType, Fluid inputFluid, Item brewingItem, Item outputItem) {
		ItemStack input = new ItemStack(brewingItem);
		PotionUtils.addPotionToItemStack(input, inputPotionType);
		ItemStack ingredient = FluidUtil.getFilledBucket(new FluidStack(inputFluid, Fluid.BUCKET_VOLUME));
		ItemStack output = new ItemStack(outputItem);
		PotionUtils.addPotionToItemStack(output, outputPotionType);
		FluidStack fluidStack = new FluidStack(inputFluid, Fluid.BUCKET_VOLUME);
		BrewingRecipeRegistry.addRecipe(new ModForgeBucketBrewingRecipe(input, ingredient, output, fluidStack));
	}

	private static void addConversionBrewingRecipe(PotionType inputPotionType, Item inputItem, Item ingredientItem, Item outputItem) {
		ItemStack input = new ItemStack(inputItem);
		PotionUtils.addPotionToItemStack(input, inputPotionType);
		ItemStack ingredient = new ItemStack(ingredientItem);
		ItemStack output = new ItemStack(outputItem);
		PotionUtils.addPotionToItemStack(output, inputPotionType);
		BrewingRecipeRegistry.addRecipe(input, ingredient, output);
	}
	
	public static void addCustomBrewingRecipe(PotionType outputPotionType, PotionType inputPotionType, Fluid inputFluid) {
		addBrewingRecipe(outputPotionType, inputPotionType, inputFluid, Items.POTIONITEM, Items.POTIONITEM);
		addConversionBrewingRecipe(outputPotionType, Items.POTIONITEM, Items.GUNPOWDER, Items.SPLASH_POTION);
		addBrewingRecipe(outputPotionType, inputPotionType, inputFluid, Items.SPLASH_POTION, Items.SPLASH_POTION);
		addConversionBrewingRecipe(outputPotionType, Items.SPLASH_POTION, Items.DRAGON_BREATH, Items.LINGERING_POTION);
		addBrewingRecipe(outputPotionType, inputPotionType, inputFluid, Items.LINGERING_POTION, Items.LINGERING_POTION);
	}
}