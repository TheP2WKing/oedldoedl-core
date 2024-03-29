package net.thep2wking.oedldoedlcore.registry;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.ItemStack;
import net.thep2wking.oedldoedlcore.OedldoedlCore;
import net.thep2wking.oedldoedlcore.config.CoreConfig;
import net.thep2wking.oedldoedlcore.init.ModItems;
import net.thep2wking.oedldoedlcore.init.ModPotions;
import net.thep2wking.oedldoedlcore.util.ModLogger;
import net.thep2wking.oedldoedlcore.util.ModRecipeHelper;

public class ModRecipes {
	public static void registerOreDict() {
		if (CoreConfig.RECIPES.DEFAULT_OREDICT) {
			ModLogger.registeredOreDictLogger(OedldoedlCore.MODID);

			ModRecipeHelper.addOreDict("iconOedldoedl", ModItems.CORE_ICON, 0);
			ModRecipeHelper.addOreDict("iconOedldoedl", ModItems.RESOURCES_ICON, 0);
			ModRecipeHelper.addOreDict("iconOedldoedl", ModItems.GEAR_ICON, 0);
			ModRecipeHelper.addOreDict("iconOedldoedl", ModItems.CURIOSITY_ICON, 0);
			ModRecipeHelper.addOreDict("iconOedldoedl", ModItems.CONSTRUCT_ICON, 0);
			ModRecipeHelper.addOreDict("iconOedldoedl", ModItems.EXPLOSIVES_ICON, 0);
			ModRecipeHelper.addOreDict("iconOedldoedl", ModItems.TECHNOLOGY_ICON, 0);
			ModRecipeHelper.addOreDict("iconOedldoedl", ModItems.MUSIC_ICON, 0);
			ModRecipeHelper.addOreDict("iconOedldoedl", ModItems.INTEGRATION_ICON, 0);

			ModRecipeHelper.addOreDict("stickDebug", ModItems.DEBUG_STICK, 0);

			ModRecipeHelper.addOreDict("stone", Blocks.STONE, 1);
			ModRecipeHelper.addOreDict("stone", Blocks.STONE, 2);
			ModRecipeHelper.addOreDict("stone", Blocks.STONE, 3);
			ModRecipeHelper.addOreDict("stone", Blocks.STONE, 4);
			ModRecipeHelper.addOreDict("stone", Blocks.STONE, 5);
			ModRecipeHelper.addOreDict("stone", Blocks.STONE, 6);

			ModRecipeHelper.addOreDict("dirt", Blocks.DIRT, 1);
			ModRecipeHelper.addOreDict("dirt", Blocks.DIRT, 2);
			ModRecipeHelper.addOreDict("dirt", Blocks.MYCELIUM, 0);

			ModRecipeHelper.addOreDict("bedrock", Blocks.BEDROCK, 0);

			ModRecipeHelper.addOreDict("commandBlock", Blocks.COMMAND_BLOCK, 0);
			ModRecipeHelper.addOreDict("commandBlock", Blocks.REPEATING_COMMAND_BLOCK, 0);
			ModRecipeHelper.addOreDict("commandBlock", Blocks.CHAIN_COMMAND_BLOCK, 0);

			ModRecipeHelper.addOreDict("sponge", Blocks.SPONGE, 0);
			ModRecipeHelper.addOreDict("sponge", Blocks.SPONGE, 1);

			ModRecipeHelper.addOreDict("bricks", Blocks.BRICK_BLOCK, 0);

			ModRecipeHelper.addOreDict("bricksNether", Blocks.NETHER_BRICK, 0);
			ModRecipeHelper.addOreDict("bricksNether", Blocks.RED_NETHER_BRICK, 0);

			ModRecipeHelper.addOreDict("endstone", Blocks.END_BRICKS, 0);

			ModRecipeHelper.addOreDict("soulsand", Blocks.SOUL_SAND, 0);

			ModRecipeHelper.addOreDict("cobblestone", Blocks.MOSSY_COBBLESTONE, 0);

			ModRecipeHelper.addOreDict("stoneBrick", Blocks.STONEBRICK, 0);
			ModRecipeHelper.addOreDict("stoneBrick", Blocks.STONEBRICK, 1);
			ModRecipeHelper.addOreDict("stoneBrick", Blocks.STONEBRICK, 2);
			ModRecipeHelper.addOreDict("stoneBrick", Blocks.STONEBRICK, 3);

			ModRecipeHelper.addOreDict("ice", Blocks.ICE, 0);
			ModRecipeHelper.addOreDict("ice", Blocks.PACKED_ICE, 0);
			ModRecipeHelper.addOreDict("blockIce", Blocks.ICE, 0);
			ModRecipeHelper.addOreDict("blockIce", Blocks.PACKED_ICE, 0);

			ModRecipeHelper.addOreDict("bed", Items.BED, 0);
			ModRecipeHelper.addOreDict("bed", Items.BED, 1);
			ModRecipeHelper.addOreDict("bed", Items.BED, 2);
			ModRecipeHelper.addOreDict("bed", Items.BED, 3);
			ModRecipeHelper.addOreDict("bed", Items.BED, 4);
			ModRecipeHelper.addOreDict("bed", Items.BED, 5);
			ModRecipeHelper.addOreDict("bed", Items.BED, 6);
			ModRecipeHelper.addOreDict("bed", Items.BED, 7);
			ModRecipeHelper.addOreDict("bed", Items.BED, 8);
			ModRecipeHelper.addOreDict("bed", Items.BED, 9);
			ModRecipeHelper.addOreDict("bed", Items.BED, 10);
			ModRecipeHelper.addOreDict("bed", Items.BED, 11);
			ModRecipeHelper.addOreDict("bed", Items.BED, 12);
			ModRecipeHelper.addOreDict("bed", Items.BED, 13);
			ModRecipeHelper.addOreDict("bed", Items.BED, 14);
			ModRecipeHelper.addOreDict("bed", Items.BED, 15);

			ModRecipeHelper.addOreDict("concrete", Blocks.CONCRETE, 0);
			ModRecipeHelper.addOreDict("concrete", Blocks.CONCRETE, 1);
			ModRecipeHelper.addOreDict("concrete", Blocks.CONCRETE, 2);
			ModRecipeHelper.addOreDict("concrete", Blocks.CONCRETE, 3);
			ModRecipeHelper.addOreDict("concrete", Blocks.CONCRETE, 4);
			ModRecipeHelper.addOreDict("concrete", Blocks.CONCRETE, 5);
			ModRecipeHelper.addOreDict("concrete", Blocks.CONCRETE, 6);
			ModRecipeHelper.addOreDict("concrete", Blocks.CONCRETE, 7);
			ModRecipeHelper.addOreDict("concrete", Blocks.CONCRETE, 8);
			ModRecipeHelper.addOreDict("concrete", Blocks.CONCRETE, 9);
			ModRecipeHelper.addOreDict("concrete", Blocks.CONCRETE, 10);
			ModRecipeHelper.addOreDict("concrete", Blocks.CONCRETE, 11);
			ModRecipeHelper.addOreDict("concrete", Blocks.CONCRETE, 12);
			ModRecipeHelper.addOreDict("concrete", Blocks.CONCRETE, 13);
			ModRecipeHelper.addOreDict("concrete", Blocks.CONCRETE, 14);
			ModRecipeHelper.addOreDict("concrete", Blocks.CONCRETE, 15);

			ModRecipeHelper.addOreDict("terracotta", Blocks.HARDENED_CLAY, 0);
			ModRecipeHelper.addOreDict("terracotta", Blocks.STAINED_HARDENED_CLAY, 0);
			ModRecipeHelper.addOreDict("terracotta", Blocks.STAINED_HARDENED_CLAY, 1);
			ModRecipeHelper.addOreDict("terracotta", Blocks.STAINED_HARDENED_CLAY, 2);
			ModRecipeHelper.addOreDict("terracotta", Blocks.STAINED_HARDENED_CLAY, 3);
			ModRecipeHelper.addOreDict("terracotta", Blocks.STAINED_HARDENED_CLAY, 4);
			ModRecipeHelper.addOreDict("terracotta", Blocks.STAINED_HARDENED_CLAY, 5);
			ModRecipeHelper.addOreDict("terracotta", Blocks.STAINED_HARDENED_CLAY, 6);
			ModRecipeHelper.addOreDict("terracotta", Blocks.STAINED_HARDENED_CLAY, 7);
			ModRecipeHelper.addOreDict("terracotta", Blocks.STAINED_HARDENED_CLAY, 8);
			ModRecipeHelper.addOreDict("terracotta", Blocks.STAINED_HARDENED_CLAY, 9);
			ModRecipeHelper.addOreDict("terracotta", Blocks.STAINED_HARDENED_CLAY, 10);
			ModRecipeHelper.addOreDict("terracotta", Blocks.STAINED_HARDENED_CLAY, 11);
			ModRecipeHelper.addOreDict("terracotta", Blocks.STAINED_HARDENED_CLAY, 12);
			ModRecipeHelper.addOreDict("terracotta", Blocks.STAINED_HARDENED_CLAY, 13);
			ModRecipeHelper.addOreDict("terracotta", Blocks.STAINED_HARDENED_CLAY, 14);
			ModRecipeHelper.addOreDict("terracotta", Blocks.STAINED_HARDENED_CLAY, 15);

			ModRecipeHelper.addOreDict("bookshelf", Blocks.BOOKSHELF, 0);

			ModRecipeHelper.addOreDict("flower", Blocks.YELLOW_FLOWER, 0);
			ModRecipeHelper.addOreDict("flower", Blocks.RED_FLOWER, 0);
			ModRecipeHelper.addOreDict("flower", Blocks.RED_FLOWER, 1);
			ModRecipeHelper.addOreDict("flower", Blocks.RED_FLOWER, 2);
			ModRecipeHelper.addOreDict("flower", Blocks.RED_FLOWER, 3);
			ModRecipeHelper.addOreDict("flower", Blocks.RED_FLOWER, 4);
			ModRecipeHelper.addOreDict("flower", Blocks.RED_FLOWER, 5);
			ModRecipeHelper.addOreDict("flower", Blocks.RED_FLOWER, 6);
			ModRecipeHelper.addOreDict("flower", Blocks.RED_FLOWER, 7);
			ModRecipeHelper.addOreDict("flower", Blocks.RED_FLOWER, 8);
			ModRecipeHelper.addOreDict("flower", Blocks.DOUBLE_PLANT, 0);
			ModRecipeHelper.addOreDict("flower", Blocks.DOUBLE_PLANT, 1);
			ModRecipeHelper.addOreDict("flower", Blocks.DOUBLE_PLANT, 4);
			ModRecipeHelper.addOreDict("flower", Blocks.DOUBLE_PLANT, 5);

			ModRecipeHelper.addOreDict("tnt", Blocks.TNT, 0);

			ModRecipeHelper.addOreDict("cropApple", Items.APPLE, 0);

			ModRecipeHelper.addOreDict("cropBeetroot", Items.BEETROOT, 0);

			ModRecipeHelper.addOreDict("gemCoal", Items.COAL, 0);

			ModRecipeHelper.addOreDict("gemCharcoal", Items.COAL, 1);

			ModRecipeHelper.addOreDict("gemFlint", Items.FLINT, 0);

			ModRecipeHelper.addOreDict("dustBlaze", Items.BLAZE_POWDER, 0);

			ModRecipeHelper.addOreDict("clayball", Items.CLAY_BALL, 0);

			ModRecipeHelper.addOreDict("snowball", Items.SNOWBALL, 0);

			ModRecipeHelper.addOreDict("dustGunpowder", Items.GUNPOWDER, 0);

			ModRecipeHelper.addOreDict("listAllseed", Items.WHEAT_SEEDS, 0);
			ModRecipeHelper.addOreDict("listAllseed", Items.PUMPKIN_SEEDS, 0);
			ModRecipeHelper.addOreDict("listAllseed", Items.MELON_SEEDS, 0);
			ModRecipeHelper.addOreDict("listAllseed", Items.BEETROOT_SEEDS, 0);

			ModRecipeHelper.addOreDict("book", Items.BOOK, 0);
			ModRecipeHelper.addOreDict("book", Items.ENCHANTED_BOOK, 0);

			ModRecipeHelper.addOreDict("bookEnchanted", Items.ENCHANTED_BOOK, 0);

			ModRecipeHelper.addOreDict("listAllsugar", Items.SUGAR, 0);

			ModRecipeHelper.addOreDict("ghastTear", Items.GHAST_TEAR, 0);

			ModRecipeHelper.addOreDict("bonemeal", Items.DYE, 15);
			ModRecipeHelper.addOreDict("fertilizer", Items.DYE, 15);

			ModRecipeHelper.addOreDict("spiderEye", Items.SPIDER_EYE, 0);
			ModRecipeHelper.addOreDict("spiderEyeFermented", Items.FERMENTED_SPIDER_EYE, 0);

			ModRecipeHelper.addOreDict("listAllmilk", Items.MILK_BUCKET, 0);
			ModRecipeHelper.addOreDict("listAllwater", Items.WATER_BUCKET, 0);
			ModRecipeHelper.addOreDict("listAlllava", Items.LAVA_BUCKET, 0);

			ModRecipeHelper.addOreDict("toolShears", Items.SHEARS, 0);

			ModRecipeHelper.addOreDict("blockQuartz", Blocks.QUARTZ_BLOCK, 1);
			ModRecipeHelper.addOreDict("blockQuartz", Blocks.QUARTZ_BLOCK, 2);

			ModRecipeHelper.addOreDict("blockPurpur", Blocks.PURPUR_PILLAR, 0);
			ModRecipeHelper.addOreDict("blockPurpur", Blocks.PURPUR_BLOCK, 0);

			ModRecipeHelper.addOreDict("blockNetherWart", Blocks.NETHER_WART_BLOCK, 0);

			ModRecipeHelper.addOreDict("piston", Blocks.PISTON, 0);
			ModRecipeHelper.addOreDict("piston", Blocks.STICKY_PISTON, 0);

			ModRecipeHelper.addOreDict("furnace", Blocks.FURNACE, 0);

			ModRecipeHelper.addOreDict("chest", Blocks.WHITE_SHULKER_BOX, 0);
			ModRecipeHelper.addOreDict("chest", Blocks.ORANGE_SHULKER_BOX, 0);
			ModRecipeHelper.addOreDict("chest", Blocks.MAGENTA_SHULKER_BOX, 0);
			ModRecipeHelper.addOreDict("chest", Blocks.LIGHT_BLUE_SHULKER_BOX, 0);
			ModRecipeHelper.addOreDict("chest", Blocks.YELLOW_SHULKER_BOX, 0);
			ModRecipeHelper.addOreDict("chest", Blocks.LIME_SHULKER_BOX, 0);
			ModRecipeHelper.addOreDict("chest", Blocks.PINK_SHULKER_BOX, 0);
			ModRecipeHelper.addOreDict("chest", Blocks.GRAY_SHULKER_BOX, 0);
			ModRecipeHelper.addOreDict("chest", Blocks.SILVER_SHULKER_BOX, 0);
			ModRecipeHelper.addOreDict("chest", Blocks.CYAN_SHULKER_BOX, 0);
			ModRecipeHelper.addOreDict("chest", Blocks.PURPLE_SHULKER_BOX, 0);
			ModRecipeHelper.addOreDict("chest", Blocks.BLUE_SHULKER_BOX, 0);
			ModRecipeHelper.addOreDict("chest", Blocks.BROWN_SHULKER_BOX, 0);
			ModRecipeHelper.addOreDict("chest", Blocks.GREEN_SHULKER_BOX, 0);
			ModRecipeHelper.addOreDict("chest", Blocks.RED_SHULKER_BOX, 0);
			ModRecipeHelper.addOreDict("chest", Blocks.BLACK_SHULKER_BOX, 0);

			ModRecipeHelper.addOreDict("chestShulker", Blocks.WHITE_SHULKER_BOX, 0);
			ModRecipeHelper.addOreDict("chestShulker", Blocks.ORANGE_SHULKER_BOX, 0);
			ModRecipeHelper.addOreDict("chestShulker", Blocks.MAGENTA_SHULKER_BOX, 0);
			ModRecipeHelper.addOreDict("chestShulker", Blocks.LIGHT_BLUE_SHULKER_BOX, 0);
			ModRecipeHelper.addOreDict("chestShulker", Blocks.YELLOW_SHULKER_BOX, 0);
			ModRecipeHelper.addOreDict("chestShulker", Blocks.LIME_SHULKER_BOX, 0);
			ModRecipeHelper.addOreDict("chestShulker", Blocks.PINK_SHULKER_BOX, 0);
			ModRecipeHelper.addOreDict("chestShulker", Blocks.GRAY_SHULKER_BOX, 0);
			ModRecipeHelper.addOreDict("chestShulker", Blocks.SILVER_SHULKER_BOX, 0);
			ModRecipeHelper.addOreDict("chestShulker", Blocks.CYAN_SHULKER_BOX, 0);
			ModRecipeHelper.addOreDict("chestShulker", Blocks.PURPLE_SHULKER_BOX, 0);
			ModRecipeHelper.addOreDict("chestShulker", Blocks.BLUE_SHULKER_BOX, 0);
			ModRecipeHelper.addOreDict("chestShulker", Blocks.BROWN_SHULKER_BOX, 0);
			ModRecipeHelper.addOreDict("chestShulker", Blocks.GREEN_SHULKER_BOX, 0);
			ModRecipeHelper.addOreDict("chestShulker", Blocks.RED_SHULKER_BOX, 0);
			ModRecipeHelper.addOreDict("chestShulker", Blocks.BLACK_SHULKER_BOX, 0);

			ModRecipeHelper.addOreDict("spawnEgg", Items.SPAWN_EGG, 0);

			ModRecipeHelper.addOreDict("potion", Items.POTIONITEM, 0);

			ModRecipeHelper.addOreDict("arrow", Items.ARROW, 0);
			ModRecipeHelper.addOreDict("arrow", Items.TIPPED_ARROW, 0);
			ModRecipeHelper.addOreDict("arrow", Items.SPECTRAL_ARROW, 0);

			ModRecipeHelper.addOreDict("arrowTipped", Items.TIPPED_ARROW, 0);

			ModRecipeHelper.addOreDict("blockClay", Blocks.CLAY, 0);

			ModRecipeHelper.addOreDict("blockSnow", Blocks.SNOW, 0);

			ModRecipeHelper.addOreDict("toolHoe", Items.WOODEN_HOE, 0);
			ModRecipeHelper.addOreDict("toolHoe", Items.STONE_HOE, 0);
			ModRecipeHelper.addOreDict("toolHoe", Items.IRON_HOE, 0);
			ModRecipeHelper.addOreDict("toolHoe", Items.GOLDEN_HOE, 0);
			ModRecipeHelper.addOreDict("toolHoe", Items.DIAMOND_HOE, 0);

			ModRecipeHelper.addOreDict("skull", Items.SKULL, 0);
			ModRecipeHelper.addOreDict("skull", Items.SKULL, 1);
			ModRecipeHelper.addOreDict("skull", Items.SKULL, 2);
			ModRecipeHelper.addOreDict("skull", Items.SKULL, 3);
			ModRecipeHelper.addOreDict("skull", Items.SKULL, 4);
			ModRecipeHelper.addOreDict("skull", Items.SKULL, 5);

			ModRecipeHelper.addOreDict("head", Items.SKULL, 0);
			ModRecipeHelper.addOreDict("head", Items.SKULL, 1);
			ModRecipeHelper.addOreDict("head", Items.SKULL, 2);
			ModRecipeHelper.addOreDict("head", Items.SKULL, 3);
			ModRecipeHelper.addOreDict("head", Items.SKULL, 4);
			ModRecipeHelper.addOreDict("head", Items.SKULL, 5);

			ModRecipeHelper.addOreDict("grassPlant", Blocks.TALLGRASS, 1);
			ModRecipeHelper.addOreDict("grassPlant", Blocks.TALLGRASS, 2);
			ModRecipeHelper.addOreDict("grassPlant", Blocks.DOUBLE_PLANT, 2);
			ModRecipeHelper.addOreDict("grassPlant", Blocks.DOUBLE_PLANT, 3);

			ModRecipeHelper.addOreDict("blockPumpkin", Blocks.PUMPKIN, 0);
			ModRecipeHelper.addOreDict("cropPumpkin", Blocks.PUMPKIN, 0);

			ModRecipeHelper.addOreDict("blockMelon", Blocks.MELON_BLOCK, 0);
			ModRecipeHelper.addOreDict("cropMelon", Blocks.MELON_BLOCK, 0);

			ModRecipeHelper.addOreDict("sliceMelon", Items.MELON, 0);
			ModRecipeHelper.addOreDict("melonSlice", Items.MELON, 0);

			ModRecipeHelper.addOreDict("cropCactus", Blocks.CACTUS, 0);

			ModRecipeHelper.addOreDict("cropChorusFruit", Items.CHORUS_FRUIT, 0);

			ModRecipeHelper.addOreDict("anvil", Blocks.ANVIL, 0);
			ModRecipeHelper.addOreDict("anvil", Blocks.ANVIL, 1);
			ModRecipeHelper.addOreDict("anvil", Blocks.ANVIL, 2);

			ModRecipeHelper.addOreDict("doorIron", Items.IRON_DOOR, 0);

			ModRecipeHelper.addOreDict("eggDragon", Blocks.DRAGON_EGG, 0);
			ModRecipeHelper.addOreDict("dragonEgg", Blocks.DRAGON_EGG, 0);

			ModRecipeHelper.addOreDict("rodBlaze", Items.BLAZE_ROD, 0);
			ModRecipeHelper.addOreDict("stickBlaze", Items.BLAZE_ROD, 0);

			ModRecipeHelper.addOreDict("magmaCream", Items.MAGMA_CREAM, 0);

			ModRecipeHelper.addOreDict("shulkerShell", Items.SHULKER_SHELL, 0);

			ModRecipeHelper.addOreDict("spawner", Blocks.MOB_SPAWNER, 0);

			ModRecipeHelper.addOreDict("flesh", Items.ROTTEN_FLESH, 0);
			ModRecipeHelper.addOreDict("fleshRotten", Items.ROTTEN_FLESH, 0);
			ModRecipeHelper.addOreDict("rottenFlesh", Items.ROTTEN_FLESH, 0);

			ModRecipeHelper.addOreDict("buttonWood", Blocks.WOODEN_BUTTON, 0);
			ModRecipeHelper.addOreDict("buttonStone", Blocks.STONE_BUTTON, 0);

			ModRecipeHelper.addOreDict("pressurePlateWood", Blocks.WOODEN_PRESSURE_PLATE, 0);
			ModRecipeHelper.addOreDict("pressurePlateStone", Blocks.STONE_PRESSURE_PLATE, 0);
			ModRecipeHelper.addOreDict("pressurePlateIron", Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE, 0);
			ModRecipeHelper.addOreDict("pressurePlateGold", Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE, 0);

			ModRecipeHelper.addOreDict("cobweb", Blocks.WEB, 0);

			ModRecipeHelper.addOreDict("blockMagma", Blocks.MAGMA, 0);

			ModRecipeHelper.addOreDict("torchRedstone", Blocks.REDSTONE_TORCH, 0);

			ModRecipeHelper.addOreDict("fireworkRocket", Items.FIREWORKS, 0);
			ModRecipeHelper.addOreDict("fireworkCharge", Items.FIREWORK_CHARGE, 0);
		}
	}

	public static void registerRecipes() {
		ModLogger.registeredRecipesLogger(OedldoedlCore.MODID);

		if (CoreConfig.RECIPES.ADDITIONAL_RECIPES) {
			ModRecipeHelper.addOreDictSmeltingRecipe(new ItemStack(Blocks.DEADBUSH, 1, 0), "treeSapling", 0.1f);

			ModRecipeHelper.add4xCompressRecipe(OedldoedlCore.MODID, "additional/brown_mushroom_block",
					new ItemStack(Blocks.BROWN_MUSHROOM_BLOCK, 1, 0), new ItemStack(Blocks.BROWN_MUSHROOM, 1, 0));

			ModRecipeHelper.add4xCompressRecipe(OedldoedlCore.MODID, "additional/red_mushroom_block",
					new ItemStack(Blocks.RED_MUSHROOM_BLOCK, 1, 0), new ItemStack(Blocks.RED_MUSHROOM, 1, 0));

			ModRecipeHelper.add9xCompressRecipe(OedldoedlCore.MODID, "additional/packed_ice",
					new ItemStack(Blocks.PACKED_ICE, 1, 0), new ItemStack(Blocks.ICE, 1, 0));

			ModRecipeHelper.addShapedRecipe(OedldoedlCore.MODID, "additional/chest", new ItemStack(Blocks.CHEST, 4, 0),
					"AAA",
					"A A", "AAA", 'A', "plankWood");

			ModRecipeHelper.addShapedRecipe(OedldoedlCore.MODID, "additional/stick", new ItemStack(Items.STICK, 16, 0),
					"A", "A",
					'A', "logWood");

			ModRecipeHelper.addShapedRecipe(OedldoedlCore.MODID, "additional/hopper",
					new ItemStack(Blocks.HOPPER, 1, 0), "ABA",
					"ABA", " A ", 'A', "ingotIron", 'B', "logWood");

			ModRecipeHelper.addShapedRecipe(OedldoedlCore.MODID, "additional/cobweb", new ItemStack(Blocks.WEB, 1, 0),
					"A A",
					" A ", "A A", 'A', "string");

			ModRecipeHelper.addShapedRecipe(OedldoedlCore.MODID, "additional/name_tag",
					new ItemStack(Items.NAME_TAG, 1, 0), "  A",
					" B ", "B  ", 'A', "string", 'B', "ingotIron");

			ModRecipeHelper.addShapedRecipe(OedldoedlCore.MODID, "additional/sponge",
					new ItemStack(Blocks.SPONGE, 1, 0), " A ",
					"ABA", " A ", 'A', "slimeball", 'B', "wool");

			ModRecipeHelper.addShapedRecipe(OedldoedlCore.MODID, "additional/command_block_minecart",
					new ItemStack(Items.COMMAND_BLOCK_MINECART, 1, 0), "A", "B", 'A',
					new ItemStack(Blocks.COMMAND_BLOCK, 1, 0), 'B', new ItemStack(Items.MINECART, 1, 0));

			ModRecipeHelper.addShapedRecipe(OedldoedlCore.MODID, "additional/enchanted_golden_apple",
					new ItemStack(Items.GOLDEN_APPLE, 1, 1), "AAA", "ABA", "AAA", 'A', "blockGold", 'B',
					new ItemStack(Items.APPLE, 1, 0));

			ModRecipeHelper.addShapedRecipe(OedldoedlCore.MODID, "additional/saddle", new ItemStack(Items.SADDLE, 1, 0),
					"AAA",
					"ABA", " C ", 'A', "leather", 'B', "string", 'C', "ingotIron");

			ModRecipeHelper.addShapedRecipe(OedldoedlCore.MODID, "additional/paper",
					new ItemStack(Items.PAPER, 3, 0), "AA", "A ", 'A', "sugarcane");

			ModRecipeHelper.addShapedRecipe(OedldoedlCore.MODID, "additional/flint",
					new ItemStack(Items.FLINT, 1, 0), "AA", "A ", 'A', "gravel");
		}

		if (CoreConfig.RECIPES.REVERSE_RECIPES) {
			ModRecipeHelper.addShapedRecipe(OedldoedlCore.MODID, "reverse/bed", new ItemStack(Items.BED, 1, 0), "A",
					'A', "bed");
			ModRecipeHelper.addShapedRecipe(OedldoedlCore.MODID, "reverse/book", new ItemStack(Items.BOOK, 1, 0), "A",
					'A', "book");
			ModRecipeHelper.addShapedRecipe(OedldoedlCore.MODID, "reverse/arrow", new ItemStack(Items.ARROW, 1, 0), "A",
					'A', "arrow");
			ModRecipeHelper.addShapedRecipe(OedldoedlCore.MODID, "reverse/glass_block",
					new ItemStack(Blocks.GLASS, 1, 0),
					"A", 'A', "blockGlass");
			ModRecipeHelper.addShapedRecipe(OedldoedlCore.MODID, "reverse/glass_pane",
					new ItemStack(Blocks.GLASS_PANE, 1, 0), "A", 'A', "paneGlass");
			ModRecipeHelper.addShapedRecipe(OedldoedlCore.MODID, "reverse/shulker_box",
					new ItemStack(Blocks.PURPLE_SHULKER_BOX, 1, 0), "A", 'A', "chestShulker");
			ModRecipeHelper.addShapedRecipe(OedldoedlCore.MODID, "reverse/terracotta",
					new ItemStack(Blocks.HARDENED_CLAY, 1, 0), "A", 'A', "terracotta");

			ModRecipeHelper.addShapedRecipe(OedldoedlCore.MODID, "reverse/bookshelf",
					new ItemStack(Items.BOOK, 3, 0), "A", 'A', "bookshelf");
			ModRecipeHelper.addShapedRecipe(OedldoedlCore.MODID, "reverse/bricks", new ItemStack(Items.BRICK, 1, 0),
					"A", 'A', "bricks");
			ModRecipeHelper.addShapedRecipe(OedldoedlCore.MODID, "reverse/brown_mushroom_block",
					new ItemStack(Blocks.BROWN_MUSHROOM, 4, 0),
					"A", 'A', new ItemStack(Blocks.BROWN_MUSHROOM_BLOCK, 1, 0));
			ModRecipeHelper.addShapedRecipe(OedldoedlCore.MODID, "reverse/red_mushroom_block",
					new ItemStack(Blocks.RED_MUSHROOM, 4, 0),
					"A", 'A', new ItemStack(Blocks.RED_MUSHROOM_BLOCK, 1, 0));
			ModRecipeHelper.addShapedRecipe(OedldoedlCore.MODID, "reverse/clay", new ItemStack(Items.CLAY_BALL, 4, 0),
					"A", 'A', "blockClay");
			ModRecipeHelper.addShapedRecipe(OedldoedlCore.MODID, "reverse/glowstone",
					new ItemStack(Items.GLOWSTONE_DUST, 4, 0),
					"A", 'A', "glowstone");
			ModRecipeHelper.addShapedRecipe(OedldoedlCore.MODID, "reverse/ice", new ItemStack(Blocks.ICE, 9, 0),
					"A", 'A', new ItemStack(Blocks.PACKED_ICE, 1, 0));
			ModRecipeHelper.addShapedRecipe(OedldoedlCore.MODID, "reverse/magma_block",
					new ItemStack(Items.MAGMA_CREAM, 4, 0), "A", 'A', "blockMagma");
			ModRecipeHelper.addShapedRecipe(OedldoedlCore.MODID, "reverse/melon_block",
					new ItemStack(Items.MELON, 9, 0), "A", 'A', "blockMelon");
			ModRecipeHelper.addShapedRecipe(OedldoedlCore.MODID, "reverse/nether_brick",
					new ItemStack(Items.NETHERBRICK, 4, 0),
					"A", 'A', new ItemStack(Blocks.NETHER_BRICK, 1, 0));
			ModRecipeHelper.addShapedRecipe(OedldoedlCore.MODID, "reverse/red_nether_brick",
					new ItemStack(Items.NETHERBRICK, 2, 0),
					"A", 'A', new ItemStack(Blocks.RED_NETHER_BRICK, 1, 0));
			ModRecipeHelper.addShapedRecipe(OedldoedlCore.MODID, "reverse/purpur_block",
					new ItemStack(Items.CHORUS_FRUIT_POPPED, 4, 0),
					"A", 'A', "blockPurpur");
			ModRecipeHelper.addShapedRecipe(OedldoedlCore.MODID, "reverse/nether_wart_block",
					new ItemStack(Items.NETHER_WART, 9, 0),
					"A", 'A', new ItemStack(Blocks.NETHER_WART_BLOCK, 1, 0));
			ModRecipeHelper.addShapedRecipe(OedldoedlCore.MODID, "reverse/quartz_block",
					new ItemStack(Items.QUARTZ, 4, 0),
					"A", 'A', "blockQuartz");
			ModRecipeHelper.addShapedRecipe(OedldoedlCore.MODID, "reverse/leather",
					new ItemStack(Items.RABBIT_HIDE, 4, 0),
					"A", 'A', "leather");
			ModRecipeHelper.addShapedRecipe(OedldoedlCore.MODID, "reverse/sandstone",
					new ItemStack(Blocks.SAND, 4, 0),
					"A", 'A', "sandstone");
			ModRecipeHelper.addShapedRecipe(OedldoedlCore.MODID, "reverse/prismarine",
					new ItemStack(Items.PRISMARINE_SHARD, 4, 0),
					"A", 'A', "blockPrismarine");
			ModRecipeHelper.addShapedRecipe(OedldoedlCore.MODID, "reverse/prismarine_bricks",
					new ItemStack(Items.PRISMARINE_SHARD, 9, 0),
					"A", 'A', "blockPrismarineBrick");
			ModRecipeHelper.addShapedRecipe(OedldoedlCore.MODID, "reverse/dark_prismarine",
					new ItemStack(Items.PRISMARINE_SHARD, 8, 0),
					"A", 'A', "blockPrismarineDark");
			ModRecipeHelper.addShapedRecipe(OedldoedlCore.MODID, "reverse/snow_layer",
					new ItemStack(Items.SNOWBALL, 2, 0),
					"A", 'A', new ItemStack(Blocks.SNOW_LAYER, 1, 0));
			ModRecipeHelper.addShapedRecipe(OedldoedlCore.MODID, "reverse/snow",
					new ItemStack(Items.SNOWBALL, 4, 0),
					"A", 'A', "blockSnow");
			ModRecipeHelper.addShapedRecipe(OedldoedlCore.MODID, "reverse/wool",
					new ItemStack(Items.STRING, 4, 0),
					"A", 'A', "wool");
			ModRecipeHelper.addShapedRecipe(OedldoedlCore.MODID, "reverse/web",
					new ItemStack(Items.STRING, 5, 0), "A", 'A', "cobweb");
		}

		if (CoreConfig.RECIPES.ADDITIONAL_RECIPES) {
			ModRecipeHelper.addShapedRecipe(OedldoedlCore.MODID, "debug_stick",
					new ItemStack(ModItems.DEBUG_STICK, 1, 0), "  A", " B ", "A  ", 'A', "dustRedstone", 'B',
					"stickWood");
		}

		if (CoreConfig.RECIPES.BREWING_RECIPES) {
			ModRecipeHelper.addBrewingRecipe(ModPotions.SLOW_FALLING_NORMAL, PotionTypes.AWKWARD,
					new ItemStack(Items.FEATHER, 1, 0));
			ModRecipeHelper.addBrewingRecipe(ModPotions.SLOW_FALLING_LONG, ModPotions.SLOW_FALLING_NORMAL,
					new ItemStack(Items.REDSTONE, 1, 0));

			ModRecipeHelper.addBrewingRecipe(ModPotions.DOLPHIN_GRACE_NORMAL, PotionTypes.AWKWARD,
					new ItemStack(Items.PRISMARINE_CRYSTALS, 1, 0));
			ModRecipeHelper.addBrewingRecipe(ModPotions.DOLPHIN_GRACE_LONG, ModPotions.DOLPHIN_GRACE_NORMAL,
					new ItemStack(Items.REDSTONE, 1, 0));
			ModRecipeHelper.addBrewingRecipe(ModPotions.DOLPHIN_GRACE_STRONG, ModPotions.DOLPHIN_GRACE_NORMAL,
					new ItemStack(Items.GLOWSTONE_DUST, 1, 0));
		}
	}
}