package com.thep2wking.oedldoedl.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.thep2wking.oedldoedl.core.config.gui.OedldoedlConfig;
import com.thep2wking.oedldoedl.core.util.proxy.CommonProxy;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLLoadCompleteEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ReferenceCore.MODID, name = ReferenceCore.NAME, version = ReferenceCore.VERSION, dependencies = ReferenceCore.DEPENDENCIES, guiFactory = ReferenceCore.GUI_FACTORY)

public class OedldoedlCore
{
	public static final Logger logger = LogManager.getLogger(ReferenceCore.NAME);
	
	@SidedProxy(clientSide = ReferenceCore.CLIENT_PROXY_CLASS, serverSide = ReferenceCore.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;

	public static OedldoedlConfig config;
	
    @Instance
    public static OedldoedlCore instance;
	
	@EventHandler
	public static void preInt(FMLPreInitializationEvent event)
	{
		proxy.preInit(event);
		logger.info("Starting FML Pre-Initialization");
		config = new OedldoedlConfig(event);
		MinecraftForge.EVENT_BUS.register(config);
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event)
	{
		proxy.Init(event);
		logger.info("Starting FML Initialization");
	}
   
	@EventHandler
	public static void postinit(FMLPostInitializationEvent event)
	{
		proxy.postInit(event);
		logger.info("Starting FML Post-Initialization");
	}	
	
	@EventHandler
	public void loadComplete(FMLLoadCompleteEvent event) 
	{
		logger.info(ReferenceCore.NAME+" "+ReferenceCore.VERSION+" loaded!");
		logger.info("Oedldoedl Resources Part installed: "+Loader.isModLoaded("oedldoedlresources"));
		logger.info("Oedldoedl Gear Part installed: "+Loader.isModLoaded("oedldoedlgear"));
	}  
}