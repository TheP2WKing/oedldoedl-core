package com.thep2wking.oedldoedl.core.util.handler;

import com.thep2wking.oedldoedl.core.init.ItemInit;
import com.thep2wking.oedldoedl.core.util.interfaces.IHasModel;

import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class RegistryHandler
{
	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event)
	{
  		event.getRegistry().register(ItemInit.ITEM_ICON_CORE);
  		event.getRegistry().register(ItemInit.ITEM_ICON_RESOURCES);
  		event.getRegistry().register(ItemInit.ITEM_ICON_GEAR);
  		event.getRegistry().register(ItemInit.ITEM_ICON_CONSTRUCT);
  		event.getRegistry().register(ItemInit.ITEM_ICON_MUSIC);
  		event.getRegistry().register(ItemInit.ITEM_ICON_INTEGRATION);
	}
	
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event)
	{	
		for(Item item : ItemInit.ITEMS)
		{
			if(item instanceof IHasModel)
			{
				((IHasModel)item).registerModels();
			}
		}
	}

	public static void preInitRegistries(FMLPreInitializationEvent event) 
	{

	}
	
	public static void InitRegistries(FMLInitializationEvent event) 
	{
		
	}
	
	public static void postInitRegistries(FMLPostInitializationEvent event) 
	{

	}
}