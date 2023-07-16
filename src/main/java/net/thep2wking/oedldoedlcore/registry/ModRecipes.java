package net.thep2wking.oedldoedlcore.registry;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.thep2wking.oedldoedlcore.OedldoedlCore;
import net.thep2wking.oedldoedlcore.config.CoreConfig;
import net.thep2wking.oedldoedlcore.init.ModItems;
import net.thep2wking.oedldoedlcore.util.ModLogger;
import net.thep2wking.oedldoedlcore.util.ModRecipeHelper;

public class ModRecipes {
	public static void registerOreDict() {
		if (CoreConfig.RECIPES.ADDITIONAL_OREDICT) {
			ModLogger.registeredOreDictLogger(OedldoedlCore.MODID);

			ModRecipeHelper.addOreDict("iconOedldoedl", ModItems.CORE_ICON, 0);
			ModRecipeHelper.addOreDict("iconOedldoedl", ModItems.RESOURCES_ICON, 0);
			ModRecipeHelper.addOreDict("iconOedldoedl", ModItems.GEAR_ICON, 0);
			ModRecipeHelper.addOreDict("iconOedldoedl", ModItems.CURIOSITY_ICON, 0);
			ModRecipeHelper.addOreDict("iconOedldoedl", ModItems.CONSTRUCT_ICON, 0);
			ModRecipeHelper.addOreDict("iconOedldoedl", ModItems.MUSIC_ICON, 0);
			ModRecipeHelper.addOreDict("iconOedldoedl", ModItems.INTEGRATION_ICON, 0);

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

			ModRecipeHelper.addOreDict("terracotta", Blocks.HARDENED_CLAY, 0);
			ModRecipeHelper.addOreDict("terracotta", Blocks.HARDENED_CLAY, 1);
			ModRecipeHelper.addOreDict("terracotta", Blocks.HARDENED_CLAY, 2);
			ModRecipeHelper.addOreDict("terracotta", Blocks.HARDENED_CLAY, 3);
			ModRecipeHelper.addOreDict("terracotta", Blocks.HARDENED_CLAY, 4);
			ModRecipeHelper.addOreDict("terracotta", Blocks.HARDENED_CLAY, 5);
			ModRecipeHelper.addOreDict("terracotta", Blocks.HARDENED_CLAY, 6);
			ModRecipeHelper.addOreDict("terracotta", Blocks.HARDENED_CLAY, 7);
			ModRecipeHelper.addOreDict("terracotta", Blocks.HARDENED_CLAY, 8);
			ModRecipeHelper.addOreDict("terracotta", Blocks.HARDENED_CLAY, 9);
			ModRecipeHelper.addOreDict("terracotta", Blocks.HARDENED_CLAY, 10);
			ModRecipeHelper.addOreDict("terracotta", Blocks.HARDENED_CLAY, 11);
			ModRecipeHelper.addOreDict("terracotta", Blocks.HARDENED_CLAY, 12);
			ModRecipeHelper.addOreDict("terracotta", Blocks.HARDENED_CLAY, 13);
			ModRecipeHelper.addOreDict("terracotta", Blocks.HARDENED_CLAY, 14);
			ModRecipeHelper.addOreDict("terracotta", Blocks.HARDENED_CLAY, 15);

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

			ModRecipeHelper.addOreDict("gemCoal", Items.COAL, 0);
			ModRecipeHelper.addOreDict("gemCoal", Items.COAL, 1);

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

			ModRecipeHelper.addOreDict("blockQuartz", Blocks.QUARTZ_BLOCK, 1);
			ModRecipeHelper.addOreDict("blockQuartz", Blocks.QUARTZ_BLOCK, 2);

			ModRecipeHelper.addOreDict("blockPurpur", Blocks.PURPUR_PILLAR, 0);
			ModRecipeHelper.addOreDict("blockPurpur", Blocks.PURPUR_BLOCK, 0);

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

			ModRecipeHelper.addOreDict("spawnegg", Items.SPAWN_EGG, 0);

			ModRecipeHelper.addOreDict("potion", Items.POTIONITEM, 0);

			ModRecipeHelper.addOreDict("arrow", Items.ARROW, 0);
			ModRecipeHelper.addOreDict("arrow", Items.TIPPED_ARROW, 0);
			ModRecipeHelper.addOreDict("arrow", Items.SPECTRAL_ARROW, 0);
		}
	}

	public static void registerRecipes() {
		ModLogger.registeredRecipesLogger(OedldoedlCore.MODID);

		if (CoreConfig.RECIPES.ADDITIONAL_RECIPES) {
		}

		if (CoreConfig.RECIPES.CONVERSION_RECIPES) {
		}
	}
}