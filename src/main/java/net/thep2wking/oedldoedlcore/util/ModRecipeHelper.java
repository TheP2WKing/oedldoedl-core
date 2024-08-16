package net.thep2wking.oedldoedlcore.util;

import javax.annotation.Nonnull;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.PotionHelper;
import net.minecraft.potion.PotionType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapelessOreRecipe;

/**
 * @author TheP2WKing
 */
public class ModRecipeHelper {
	// shaped and shapeless
	public static void addShapedRecipe(String modid, String name, ItemStack output, Object... inputs) {
		GameRegistry.addShapedRecipe(new ResourceLocation(modid, name), null, output, inputs);
	}

	public static void addShapelessRecipe(String modid, String name, ItemStack output, Ingredient... inputs) {
		GameRegistry.addShapelessRecipe(new ResourceLocation(modid, name), null, output, inputs);
	}

	public static void addShapelessRecipe(String modid, String name, ItemStack output, Object... inputs) {
		ShapelessOreRecipe oreRecipe = new ShapelessOreRecipe(new ResourceLocation(modid, name), output, inputs);
		oreRecipe.setRegistryName(new ResourceLocation(modid, name));
		ForgeRegistries.RECIPES.register(oreRecipe);
	}

	// compress and decompress
	public static void add9xCompressRecipe(String modid, String name, ItemStack output, Object input) {
		addShapedRecipe(modid, name, output, "AAA", "AAA", "AAA", 'A', input);
	}

	public static void add9xCompressRecipe(String modid, String name, Item output, Object input) {
		addShapedRecipe(modid, name, new ItemStack(output, 1, 0), "AAA", "AAA", "AAA", 'A', input);
	}

	public static void add9xCompressRecipe(String modid, String name, Block output, Object input) {
		addShapedRecipe(modid, name, new ItemStack(output, 1, 0), "AAA", "AAA", "AAA", 'A', input);
	}

	public static void add4xCompressRecipe(String modid, String name, ItemStack output, Object input) {
		addShapedRecipe(modid, name, output, "AA", "AA", 'A', input);
	}

	public static void add4xCompressRecipe(String modid, String name, Block output, Object input) {
		addShapedRecipe(modid, name, new ItemStack(output, 1, 0), "AA", "AA", 'A', input);
	}

	public static void addDecompressRecipe(String modid, String name, ItemStack output, Object input) {
		addShapelessRecipe(modid, name, output, input);
	}

	public static void add9xDecompressRecipe(String modid, String name, Item output, Object input) {
		addShapelessRecipe(modid, name, new ItemStack(output, 9, 0), input);
	}

	public static void add9xDecompressRecipe(String modid, String name, Block output, Object input) {
		addShapelessRecipe(modid, name, new ItemStack(output, 9, 0), input);
	}

	public static void add4xDecompressRecipe(String modid, String name, Item output, Object input) {
		addShapelessRecipe(modid, name, new ItemStack(output, 4, 0), input);
	}

	public static void add4xDecompressRecipe(String modid, String name, Block output, Object input) {
		addShapelessRecipe(modid, name, new ItemStack(output, 4, 0), input);
	}

	// remove crafting recipe
    public static void removeRecipe(String modid, String name) {
        ResourceLocation recipeResourceLocation = new ResourceLocation(modid, name);
        IRecipe recipeToModify = ForgeRegistries.RECIPES.getValue(recipeResourceLocation);
        if (recipeToModify != null) {
            IRecipe modifiedRecipe = new ModEmptyRecipe(recipeToModify);
            ForgeRegistries.RECIPES.register(modifiedRecipe);
        }
    }

	// smelting recipes
	public static void addSmeltingRecipe(ItemStack output, ItemStack input, float xp) {
		GameRegistry.addSmelting(output, input, xp);
	}

	public static void addOreDictSmeltingRecipe(ItemStack output, String inputOreDict, float xp) {
		for (@Nonnull
		ItemStack inputs : OreDictionary.getOres(inputOreDict)) {
			GameRegistry.addSmelting(inputs, output, xp);
		}
	}

	// brewing recipes
	public static void addBrewingRecipe(PotionType outputType, PotionType inputType, ItemStack inputStack) {
		PotionHelper.addMix(inputType, inputStack.getItem(), outputType);
	}

	public static void addForgBucketBrewingRecipe(PotionType outputType, PotionType inputType, Fluid inputFluid) {
		ModForgeBucketBrewingRecipe.addCustomBrewingRecipe(outputType, inputType, inputFluid);
	}

	// oredict
	public static void addOreDict(String name, Item input, int meta) {
		OreDictionary.registerOre(name, new ItemStack(input, 1, meta));
	}

	public static void addOreDict(String name, Block input, int meta) {
		OreDictionary.registerOre(name, new ItemStack(input, 1, meta));
	}

	public static void addOreDict(String name, ItemStack input) {
		OreDictionary.registerOre(name, input);
	}

	// armor
	public static void addHelmetRecipe(String modid, String name, ItemStack helmet, String material) {
		addShapedRecipe(modid, "armor/" + name + "_helmet", helmet, "AAA", "A A", 'A', material);
	}

	public static void addChestplateRecipe(String modid, String name, ItemStack chestplate, String material) {
		addShapedRecipe(modid, "armor/" + name + "_chestplate", chestplate, "A A", "AAA", "AAA", 'A', material);
	}

	public static void addLeggingsRecipe(String modid, String name, ItemStack leggings, String material) {
		addShapedRecipe(modid, "armor/" + name + "_leggings", leggings, "AAA", "A A", "A A", 'A', material);
	}

	public static void addBootsRecipe(String modid, String name, ItemStack boots, String material) {
		addShapedRecipe(modid, "armor/" + name + "_boots", boots, "A A", "A A", 'A', material);
	}

	public static void addHorseArmorRecipe(String modid, String name, ItemStack horseArmor, String material) {
		addShapedRecipe(modid, "armor/" + name + "_horse_armor", horseArmor, "A A", "BCB", "A A", 'A', material, 'B',
				"leather", 'C', "wool");
	}

	public static void addFullArmorRecipe(String modid, String name, ItemStack helmet,
			ItemStack chestplate, ItemStack leggings, ItemStack boots, String material) {
		addHelmetRecipe(modid, name, helmet, material);
		addChestplateRecipe(modid, name, chestplate, material);
		addLeggingsRecipe(modid, name, leggings, material);
		addBootsRecipe(modid, name, boots, material);
	}

	// tools
	public static void addSwordRecipe(String modid, String name, ItemStack sword, String stick,
			String material) {
		addShapedRecipe(modid, "tool/" + name + "_sword", sword, "A", "A", "B", 'A', material, 'B', stick);
	}

	public static void addShovelRecipe(String modid, String name, ItemStack shovel, String stick,
			String material) {
		addShapedRecipe(modid, "tool/" + name + "_shovel", shovel, "A", "B", "B", 'A', material, 'B', stick);
	}

	public static void addPickaxeRecipe(String modid, String name, ItemStack pickaxe, String stick,
			String material) {
		addShapedRecipe(modid, "tool/" + name + "_pickaxe", pickaxe, "AAA", " B ", " B ", 'A', material, 'B', stick);
	}

	public static void addAxeRecipe(String modid, String name, ItemStack axe, String stick, String material) {
		addShapedRecipe(modid, "tool/" + name + "_axe", axe, "AA", "AB", " B", 'A', material, 'B', stick);
	}

	public static void addHoeRecipe(String modid, String name, ItemStack hoe, String stick, String material) {
		addShapedRecipe(modid, "tool/" + name + "_hoe", hoe, "AA", " B", " B", 'A', material, 'B', stick);
	}

	public static void addPaxelRecipe(String modid, String name, ItemStack paxel, String stick, ItemStack axe,
			ItemStack shovel, ItemStack pickaxe) {
		addShapedRecipe(modid, "tool/" + name + "_paxel", paxel, "ABC", " D ", " D ", 'A', axe, 'B', shovel, 'C',
				pickaxe, 'D',
				stick);
	}

	public static void addSmashbatRecipe(String modid, String name, ItemStack smashbat, String material) {
		addShapedRecipe(modid, "tool/" + name + "_smashbat", smashbat, "A", "A", "B", 'A', material, 'B', "leather");
	}

	public static void addShearsRecipe(String modid, String name, ItemStack shears, String material) {
		addShapedRecipe(modid, "tool/" + name + "_shears", shears, " A", "A ", 'A', material);
	}

	public static void addBowRecipe(String modid, String name, ItemStack bow, String stick, String material) {
		addShapedRecipe(modid, "tool/" + name + "_bow", bow, " AB", "C B", " AB", 'A', material, 'B', "string", 'C',
				stick);
	}

	public static void addShieldRecipe(String modid, String name, ItemStack shield, String material) {
		addShapedRecipe(modid, "tool/" + name + "_shield", shield, "AAA", "ABA", " A ", 'A', material, 'B',
				new ItemStack(Items.SHIELD, 1));
	}

	public static void addDefaultToolRecipe(String modid, String name, ItemStack sword, ItemStack shovel, ItemStack pickaxe, ItemStack axe, ItemStack hoe, String stick, String material) {
		addSwordRecipe(modid, name, sword, stick, material);
		addShovelRecipe(modid, name, shovel, stick, material);
		addPickaxeRecipe(modid, name, pickaxe, stick, material);
		addAxeRecipe(modid, name, axe, stick, material);
		addHoeRecipe(modid, name, hoe, stick, material);
	}

	public static void addFullToolRecipe(String modid, String name, ItemStack sword, ItemStack shovel,
			ItemStack pickaxe, ItemStack axe, ItemStack hoe, ItemStack paxel, ItemStack smashbat, ItemStack shears,
			ItemStack bow, ItemStack shield, String stick, String material) {
		addDefaultToolRecipe(modid, name, sword, shovel, pickaxe, axe, hoe, stick, material);
		addPaxelRecipe(modid, name, paxel, stick, axe, shovel, pickaxe);
		addSmashbatRecipe(modid, name, smashbat, material);
		addShearsRecipe(modid, name, shears, material);
		addBowRecipe(modid, name, bow, stick, material);
		addShieldRecipe(modid, name, shield, material);
	}
}