package com.thep2wking.oedldoedl.core.util.tabs;

import com.thep2wking.oedldoedl.core.init.ItemInit;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class TabOedldoedlCore extends CreativeTabs
{
	public TabOedldoedlCore(String label)
	{
		super("tab_oedldoedl_core");
		setBackgroundImageName("oedldoedl_base.png");
	}
	
	public ItemStack getTabIconItem()
	{
		return new ItemStack(ItemInit.ITEM_ICON_CORE);
	}
}