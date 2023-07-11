package net.thep2wking.oedldoedlcore.util;

import javax.annotation.Nonnull;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class ModRecipeHelper {
	public static void addShapedRecipe(String modid, String name, @Nonnull ItemStack output, Object... inputs) {
		GameRegistry.addShapedRecipe(new ResourceLocation(modid, name), null, output, inputs);
	}

	public static void addShapelessRecipe(String modid, String name, @Nonnull ItemStack output, Ingredient... inputs) {
		GameRegistry.addShapelessRecipe(new ResourceLocation(modid, name), null, output);
	}

	public static void removeRecipe(String modid, String name) {
		GameRegistry.addShapedRecipe(new ResourceLocation(name), null,
				new ItemStack(Item.getByNameOrId("null")), "A", 'A', "null");
	}

	public static void addSmeltingRecipe(@Nonnull ItemStack output, @Nonnull ItemStack input, float xp) {
		GameRegistry.addSmelting(output, input, xp);
	}

	@SuppressWarnings("null")
	public static void addOreDictSmeltingRecipe(@Nonnull ItemStack output, @Nonnull String inputOreDict, float xp) {
		for (@Nonnull
		ItemStack inputs : OreDictionary.getOres(inputOreDict)) {
			GameRegistry.addSmelting(inputs, output, xp);
		}
	}

	public static void add9xCompressRecipe(String modid, String name, @Nonnull ItemStack output,
			@Nonnull ItemStack input) {
		GameRegistry.addShapedRecipe(new ResourceLocation(modid, name), null, output, "AAA", "AAA",
				"AAA", 'A', input);
	}

	public static void add4xCompressRecipe(String modid, String name, @Nonnull ItemStack output,
			@Nonnull ItemStack input) {
		GameRegistry.addShapedRecipe(new ResourceLocation(modid, name), null, output, "AA", "AA", 'A',
				input);
	}

	public static void add9xUncompressRecipe(String modid, String name, Item output, int meta,
			@Nonnull ItemStack input) {
		GameRegistry.addShapelessRecipe(new ResourceLocation(modid, name), null,
				new ItemStack(output, 9, meta), Ingredient.fromStacks(input));
	}

	public static void add9xUncompressRecipe(String modid, String name, Block output, int meta,
			@Nonnull ItemStack input) {
		GameRegistry.addShapelessRecipe(new ResourceLocation(modid, name), null,
				new ItemStack(output, 9, meta), Ingredient.fromStacks(input));
	}

	public static void add4xUncompressRecipe(String modid, String name, @Nonnull Item output, int meta,
			@Nonnull ItemStack input) {
		GameRegistry.addShapelessRecipe(new ResourceLocation(modid, name), null,
				new ItemStack(output, 4, meta), Ingredient.fromStacks(input));
	}

	public static void add4xUncompressRecipe(String modid, String name, @Nonnull Block output, int meta,
			@Nonnull ItemStack input) {
		GameRegistry.addShapelessRecipe(new ResourceLocation(modid, name), null,
				new ItemStack(output, 4, meta), Ingredient.fromStacks(input));
	}

	public static void addOreDict(String name, Item input, int meta) {
		OreDictionary.registerOre(name, new ItemStack(input, 1, meta));
	}

	public static void addOreDict(String name, Block input, int meta) {
		OreDictionary.registerOre(name, new ItemStack(input, 1, meta));
	}
}