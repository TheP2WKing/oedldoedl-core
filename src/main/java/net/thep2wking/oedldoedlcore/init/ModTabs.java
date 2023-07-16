package net.thep2wking.oedldoedlcore.init;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thep2wking.oedldoedlcore.OedldoedlCore;
import net.thep2wking.oedldoedlcore.config.CoreConfig;
import net.thep2wking.oedldoedlcore.util.ModReferences;

public class ModTabs {
	// creative tab for items that are only displayed in jei
	public static final CreativeTabs CREATIVE = new CreativeTabs("creative.name") {
		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return new ItemStack(Blocks.COMMAND_BLOCK, 1, 0);
		}

		@Override
		@SideOnly(Side.CLIENT)
		public ResourceLocation getBackgroundImage() {
			return ModReferences.CREATIVE_TAB_LIGHT;
		}

		@Override
		public void displayAllRelevantItems(NonNullList<ItemStack> list) {
			if (CoreConfig.CONTENT.UNIBTAINABLE_CREATIVE_TAB) {
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
				super.displayAllRelevantItems(list);
			}
		}
	};

	public static final CreativeTabs TAB = new CreativeTabs(OedldoedlCore.MODID + ".name") {
		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return new ItemStack(ModItems.CORE_ICON, 1, 0);
		}

		@Override
		@SideOnly(Side.CLIENT)
		public ResourceLocation getBackgroundImage() {
			return ModReferences.CREATIVE_TAB_DARK;
		}
	};
}