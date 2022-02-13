package net.thep2wking.oedldoedlcore.util;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.thep2wking.oedldoedlcore.OedldoedlCore;
import net.thep2wking.oedldoedlcore.config.CoreConfig;
import net.thep2wking.oedldoedlcore.init.ModItems;

public class ModItemGroups
{
	public static final ItemGroup TAB_CREATIVE = new ItemGroup("creative.tab") 
	{	
		@Override
		@OnlyIn(Dist.CLIENT)
		public ItemStack createIcon()
		{
			return new ItemStack(Items.COMMAND_BLOCK.getItem());
		}
		
		@Override
		public void fill(NonNullList<ItemStack> items) 
		{
			if (CoreConfig.unobtainable_items_creative_tab.get())
			{
				items.add(new ItemStack(Items.COMMAND_BLOCK.getItem()));
				items.add(new ItemStack(Items.CHAIN_COMMAND_BLOCK.getItem()));
				items.add(new ItemStack(Items.REPEATING_COMMAND_BLOCK.getItem()));
				items.add(new ItemStack(Items.STRUCTURE_BLOCK.getItem()));
				items.add(new ItemStack(Items.JIGSAW.getItem()));
				items.add(new ItemStack(Items.SPAWNER.getItem()));
				items.add(new ItemStack(Items.BARRIER.getItem()));
				items.add(new ItemStack(Items.STRUCTURE_VOID.getItem()));
				items.add(new ItemStack(Items.DRAGON_EGG.getItem()));
				items.add(new ItemStack(Items.COMMAND_BLOCK_MINECART.getItem()));
				items.add(new ItemStack(Items.KNOWLEDGE_BOOK.getItem()));
				items.add(new ItemStack(Items.WRITTEN_BOOK.getItem()));
				items.add(new ItemStack(Items.FILLED_MAP.getItem()));
				items.add(new ItemStack(Items.DEBUG_STICK.getItem()));
				items.add(new ItemStack(Items.SUSPICIOUS_STEW.getItem()));
				super.fill(items);
			}
		}
	};
	
	public static final ItemGroup TAB_CORE = new ItemGroup("oedldoedlcore.tab") 
	{	
		@Override
		@OnlyIn(Dist.CLIENT)
		public ItemStack createIcon()
		{
			return new ItemStack(ModItems.CORE_ICON.get());
		}
		
		@Override
		@OnlyIn(Dist.CLIENT)
		public ResourceLocation getBackgroundImage() 
		{
			return new ResourceLocation(OedldoedlCore.MODID, "textures/gui/container/tab_oedldoedl_base.png");
		};
	};
}	