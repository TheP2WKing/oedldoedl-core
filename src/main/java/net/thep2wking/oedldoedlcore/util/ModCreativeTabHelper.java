package net.thep2wking.oedldoedlcore.util;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thep2wking.oedldoedlcore.api.tab.ModCreativeTabBase;
import net.thep2wking.oedldoedlcore.config.CoreConfig;

/**
 * @author TheP2WKing
 */
public class ModCreativeTabHelper {
	// creative tab with items that are not obtainable in the normal creative tab
	public static CreativeTabs addUnobtainableCreativeTab() {
		return new ModCreativeTabBase("creative", ModReferences.CREATIVE_TAB_LIGHT, false, false) {
			@Override
			public ItemStack getTabIconItem() {
				return new ItemStack(Blocks.COMMAND_BLOCK);
			}

			@Override
			@SideOnly(Side.CLIENT)
			public void displayAllRelevantItems(NonNullList<ItemStack> list) {
				if (CoreConfig.CONTENT.UNIBTAINABLE_CREATIVE_TAB) {
					super.displayAllRelevantItems(list);
					list.add(new ItemStack(Blocks.MOB_SPAWNER, 1, 0));
					list.add(new ItemStack(Blocks.FARMLAND, 1, 0));
					list.add(new ItemStack(Blocks.BROWN_MUSHROOM_BLOCK, 1, 0));
					list.add(new ItemStack(Blocks.RED_MUSHROOM_BLOCK, 1, 0));
					list.add(new ItemStack(Blocks.DRAGON_EGG, 1, 0));
					list.add(new ItemStack(Blocks.BARRIER, 1, 0));
					list.add(new ItemStack(Blocks.GRASS_PATH, 1, 0));
					list.add(new ItemStack(Blocks.COMMAND_BLOCK, 1, 0));
					list.add(new ItemStack(Blocks.REPEATING_COMMAND_BLOCK, 1, 0));
					list.add(new ItemStack(Blocks.CHAIN_COMMAND_BLOCK, 1, 0));
					list.add(new ItemStack(Blocks.STRUCTURE_VOID, 1, 0));
					list.add(new ItemStack(Blocks.STRUCTURE_BLOCK, 1, 0));
					list.add(new ItemStack(Items.FILLED_MAP, 1, 0));
					list.add(new ItemStack(Items.WRITTEN_BOOK, 1, 0));
					list.add(new ItemStack(Items.FIREWORKS, 1, 0));
					list.add(new ItemStack(Items.COMMAND_BLOCK_MINECART, 1, 0));
					list.add(new ItemStack(Items.KNOWLEDGE_BOOK, 1, 0));
					list.add(new ItemStack(Items.SPAWN_EGG, 1, 0));
					list.add(ModNBTUtil.addSpawnEgg("minecraft:giant"));
					list.add(ModNBTUtil.addSpawnEgg("minecraft:illusion_illager"));
					list.add(ModNBTUtil.addSpawnEgg("minecraft:snowman"));
					list.add(ModNBTUtil.addSpawnEgg("minecraft:villager_golem"));
					list.add(ModNBTUtil.addSpawnEgg("minecraft:wither"));
				}
			}
		};
	}
}