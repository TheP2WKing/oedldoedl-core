package com.thep2wking.oedldoedl.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.thep2wking.oedldoedl.core.config.CoreConfig;
import com.thep2wking.oedldoedl.core.util.handler.OreDictionaryHandler;
import com.thep2wking.oedldoedl.core.util.handler.RegistryHandler;
import com.thep2wking.oedldoedl.core.util.proxy.CommonProxy;
import com.thep2wking.oedldoedl.core.util.tabs.TabOedldoedlCore;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLLoadCompleteEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ReferenceCore.MODID, name = ReferenceCore.NAME, version = ReferenceCore.VERSION, dependencies = ReferenceCore.DEPENDENCIES)

public class OedldoedlCore
{
	public static final Logger logger = LogManager.getLogger(ReferenceCore.NAME);
	
	@SidedProxy(clientSide = ReferenceCore.CLIENT_PROXY_CLASS, serverSide = ReferenceCore.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
    @Instance
    public static OedldoedlCore instance;
    
    public static final CreativeTabs TAB = new TabOedldoedlCore("tab_oedldoedl_core");
	
	@EventHandler
	public static void preInt(FMLPreInitializationEvent event)
	{
		proxy.preInit(event);
		if (CoreConfig.GENEREL.logging)
		{
			logger.info("Starting FML Pre-Initialization");	
		}
		RegistryHandler.preInitRegistries(event);
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event)
	{
		proxy.Init(event);
		if (CoreConfig.GENEREL.logging)
		{
			logger.info("Starting FML Initialization");
		}
		OreDictionaryHandler.registerOreDictionary();
	}
   
	@EventHandler
	public static void postinit(FMLPostInitializationEvent event)
	{
		proxy.postInit(event);
		if (CoreConfig.GENEREL.logging)
		{
			logger.info("Starting FML Post-Initialization");
		}
	}	
	
	@EventHandler
	public void loadComplete(FMLLoadCompleteEvent event) 
	{
		if (CoreConfig.GENEREL.logging)
		{
			logger.info(ReferenceCore.NAME+" "+ReferenceCore.VERSION+" loaded!");
			logger.info("Oedldoedl Resources installed: "+Loader.isModLoaded("oedldoedlresources"));
			logger.info("Oedldoedl Gear installed: "+Loader.isModLoaded("oedldoedlgear"));
			logger.info("Oedldoedl Construct installed: "+Loader.isModLoaded("oedldoedlconstruct"));
			logger.info("Oedldoedl Music installed: "+Loader.isModLoaded("oedldoedlmusic"));
			logger.info("Oedldoedl Integration installed: "+Loader.isModLoaded("oedldoedlintegration"));
		}
	}  
}