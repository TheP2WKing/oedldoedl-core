package com.thep2wking.oedldoedl.core.util.proxy;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CommonProxy 
{
	public void registerItemRenderer(Item item, int meta, String id) 
	{
		
	}
	
    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) 
    {

    }
    
	public void registerModels() 
	{
		
	}

	public void preInit(FMLPreInitializationEvent event) 
	{
		
	}

	public void Init(FMLInitializationEvent event) 
	{

	}

	public void postInit(FMLPostInitializationEvent event) 
	{

	}
}