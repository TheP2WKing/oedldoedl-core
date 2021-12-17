package com.thep2wking.oedldoedl.core.init;

import java.util.ArrayList;
import java.util.List;

import com.thep2wking.oedldoedl.core.items.ItemIconConstruct;
import com.thep2wking.oedldoedl.core.items.ItemIconCore;
import com.thep2wking.oedldoedl.core.items.ItemIconGear;
import com.thep2wking.oedldoedl.core.items.ItemIconIntegration;
import com.thep2wking.oedldoedl.core.items.ItemIconMusic;
import com.thep2wking.oedldoedl.core.items.ItemIconResources;

import net.minecraft.item.Item;

public class ItemInit 
{
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	public static final ItemIconCore ITEM_ICON_CORE = new ItemIconCore("icon_core");
	public static final ItemIconResources ITEM_ICON_RESOURCES = new ItemIconResources("icon_resources");
	public static final ItemIconGear ITEM_ICON_GEAR = new ItemIconGear("icon_gear");
	public static final ItemIconConstruct ITEM_ICON_CONSTRUCT = new ItemIconConstruct("icon_construct");
	public static final ItemIconMusic ITEM_ICON_MUSIC = new ItemIconMusic("icon_music");
	public static final ItemIconIntegration ITEM_ICON_INTEGRATION = new ItemIconIntegration("icon_integration");
}