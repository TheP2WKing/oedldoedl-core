package net.thep2wking.oedldoedlcore.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.Tags.IOptionalNamedTag;
import net.thep2wking.oedldoedlcore.OedldoedlCore;

public class ModTags {
	public static class BLocks {
		@SuppressWarnings("unused")
		private static Tags.IOptionalNamedTag<Block> createTag(String name) {
			return BlockTags.createOptional(new ResourceLocation(OedldoedlCore.MODID, name));
		}

		private static Tags.IOptionalNamedTag<Block> createForgeTag(String name) {
			return BlockTags.createOptional(new ResourceLocation("forge", name));
		}

		// blocks
		public static final Tags.IOptionalNamedTag<Block> FORGE_DIRT = createForgeTag("dirt");
		public static final Tags.IOptionalNamedTag<Block> FORGE_BRICKS = createForgeTag("bricks");
		public static final Tags.IOptionalNamedTag<Block> FORGE_NETHER_BRICKS = createForgeTag("nether_bricks");
		public static final Tags.IOptionalNamedTag<Block> FORGE_PURPUR_BLOCKS = createForgeTag("purpur_blocks");
		public static final Tags.IOptionalNamedTag<Block> FORGE_ICE = createForgeTag("ice");
		public static final Tags.IOptionalNamedTag<Block> FORGE_SOUL_SAND = createForgeTag("soul_sand");
		public static final Tags.IOptionalNamedTag<Block> FORGE_BASALT = createForgeTag("basalt");
		public static final Tags.IOptionalNamedTag<Block> FORGE_GLOWSTONE = createForgeTag("glowstone");
		public static final Tags.IOptionalNamedTag<Block> FORGE_TERRACOTTA = createForgeTag("terracotta");
		public static final Tags.IOptionalNamedTag<Block> FORGE_CONCRETE = createForgeTag("concrete");
		public static final Tags.IOptionalNamedTag<Block> FORGE_ORES_NETHERITE = createForgeTag("ores/netherite");
		public static final Tags.IOptionalNamedTag<Block> FORGE_CHESTS_SHULKER = createForgeTag("chests/shulker");
		public static final Tags.IOptionalNamedTag<Block> FORGE_CRAFTING_TABLES = createForgeTag("crafting_tables");
		public static final Tags.IOptionalNamedTag<Block> FORGE_WORKBENCH = createForgeTag("workbench");
		public static final Tags.IOptionalNamedTag<Block> FORGE_FURNACE = createForgeTag("furnace");
		public static final Tags.IOptionalNamedTag<Block> FORGE_SAPLING = createForgeTag("sapling");
		public static final Tags.IOptionalNamedTag<Block> FORGE_WOOL = createForgeTag("wool");
	}

	public static class Items {
		private static IOptionalNamedTag<Item> createTag(String name) {
			return ItemTags.createOptional(new ResourceLocation(OedldoedlCore.MODID, name));
		}

		// icons
		public static final Tags.IOptionalNamedTag<Item> OEDLDOEDL_ICONS = createTag("icon");

		private static IOptionalNamedTag<Item> createForgeTag(String name) {
			return ItemTags.createOptional(new ResourceLocation("forge", name));
		}

		// blockitems
		public static final Tags.IOptionalNamedTag<Item> FORGE_DIRT = createForgeTag("dirt");
		public static final Tags.IOptionalNamedTag<Item> FORGE_BRICKS = createForgeTag("bricks");
		public static final Tags.IOptionalNamedTag<Item> FORGE_NETHER_BRICKS = createForgeTag("nether_bricks");
		public static final Tags.IOptionalNamedTag<Item> FORGE_PURPUR_BLOCKS = createForgeTag("purpur_blocks");
		public static final Tags.IOptionalNamedTag<Item> FORGE_ICE = createForgeTag("ice");
		public static final Tags.IOptionalNamedTag<Item> FORGE_SOUL_SAND = createForgeTag("soul_sand");
		public static final Tags.IOptionalNamedTag<Item> FORGE_BASALT = createForgeTag("basalt");
		public static final Tags.IOptionalNamedTag<Item> FORGE_GLOWSTONE = createForgeTag("glowstone");
		public static final Tags.IOptionalNamedTag<Item> FORGE_TERRACOTTA = createForgeTag("terracotta");
		public static final Tags.IOptionalNamedTag<Item> FORGE_CONCRETE = createForgeTag("concrete");
		public static final Tags.IOptionalNamedTag<Item> FORGE_ORES_NETHERITE = createForgeTag("ores/netherite");
		public static final Tags.IOptionalNamedTag<Item> FORGE_CHESTS_SHULKER = createForgeTag("chests/shulker");
		public static final Tags.IOptionalNamedTag<Item> FORGE_CRAFTING_TABLES = createForgeTag("crafting_tables");
		public static final Tags.IOptionalNamedTag<Item> FORGE_WORKBENCH = createForgeTag("workbench");
		public static final Tags.IOptionalNamedTag<Item> FORGE_WOOL = createForgeTag("wool");

		// items
		public static final Tags.IOptionalNamedTag<Item> FORGE_GEMS_COAL = createForgeTag("gems/coal");
		public static final Tags.IOptionalNamedTag<Item> FORGE_GEMS_CHARCOAL = createForgeTag("gems/charcoal");
		public static final Tags.IOptionalNamedTag<Item> FORGE_DUSTS_GUNPOWDER = createForgeTag("dusts/gunpowder");
		public static final Tags.IOptionalNamedTag<Item> FORGE_DUSTS_BLAZE = createForgeTag("dusts/blaze");
		public static final Tags.IOptionalNamedTag<Item> FORGE_SAPLING = createForgeTag("sapling");
		public static final Tags.IOptionalNamedTag<Item> FORGE_GEMS_FLINT = createForgeTag("gems/flint");
		public static final Tags.IOptionalNamedTag<Item> FORGE_CLAYBALLS = createForgeTag("clayballs");
		public static final Tags.IOptionalNamedTag<Item> FORGE_CROPS_PUMPKIN = createForgeTag("crops/pumpkin");
		public static final Tags.IOptionalNamedTag<Item> FORGE_CROPS_SUGARCANE = createForgeTag("crops/sugarcane");
		public static final Tags.IOptionalNamedTag<Item> FORGE_CROPS_KELP = createForgeTag("crops/kelp");
		public static final Tags.IOptionalNamedTag<Item> FORGE_CROPS_BAMBOO = createForgeTag("crops/bamboo");
		public static final Tags.IOptionalNamedTag<Item> FORGE_CROPS_CACTUS = createForgeTag("crops/cactus");
		public static final Tags.IOptionalNamedTag<Item> FORGE_CROPS_APPLE = createForgeTag("crops/apple");
		public static final Tags.IOptionalNamedTag<Item> FORGE_CROPS_MELON = createForgeTag("crops/melon");
		public static final Tags.IOptionalNamedTag<Item> FORGE_CROPS_CHORUS_FRUIT = createForgeTag(
				"crops/chorus_fruit");
		public static final Tags.IOptionalNamedTag<Item> FORGE_CROPS_SWEET_BERRIES = createForgeTag(
				"crops/sweet_berries");
		public static final Tags.IOptionalNamedTag<Item> FORGE_SNOWBALLS = createForgeTag("snowballs");
		public static final Tags.IOptionalNamedTag<Item> FORGE_SUGAR = createForgeTag("sugar");
		public static final Tags.IOptionalNamedTag<Item> FORGE_BOOKS = createForgeTag("books");
		public static final Tags.IOptionalNamedTag<Item> FORGE_TOOLS_WRENCH = createForgeTag("tools/wrench");
		public static final Tags.IOptionalNamedTag<Item> FORGE_TOOLS = createForgeTag("tools");
	}
}