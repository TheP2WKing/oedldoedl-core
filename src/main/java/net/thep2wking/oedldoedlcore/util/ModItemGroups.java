package net.thep2wking.oedldoedlcore.util;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.thep2wking.oedldoedlcore.init.ModItems;

public class ModItemGroups 
{
	public static final ItemGroup TAB_CORE = new ItemGroup("oedldoedlcore.tab") 
	{	
		@Override
		public ItemStack createIcon()
		{
			return new ItemStack(ModItems.ITEM_CORE_ICON.get());
		}
	};
}	