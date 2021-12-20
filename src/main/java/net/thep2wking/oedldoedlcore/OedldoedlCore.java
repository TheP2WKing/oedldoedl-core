package net.thep2wking.oedldoedlcore;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.thep2wking.oedldoedlcore.config.CoreConfig;
import net.thep2wking.oedldoedlcore.config.CoreConfigLogging;
import net.thep2wking.oedldoedlcore.init.ModItems;

@Mod(OedldoedlCore.MODID)
public class OedldoedlCore
{
	public static final String MODID = "oedldoedlcore";
	public static final String NAME = "Oedldoedl Core";
	public static final String VERSION = "1.16.5-3.1.0";
	
	public static OedldoedlCore INSTANCE;
	
    public static final Logger LOGGER = LogManager.getLogger();

    public OedldoedlCore() 
    {
    	IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
    	
    	ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CoreConfig.CONFIG);
    	
    	ModItems.register(eventBus);
    	
    	eventBus.addListener(this::onCommonSetup);
    	eventBus.addListener(this::onClientSetup);
    	eventBus.addListener(this::onloadComplete);
        
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void onCommonSetup(final FMLCommonSetupEvent event)
    {
    	if (CoreConfigLogging.general.get())
    	{
    		LOGGER.info("Common Setup Registerd!");
    	}
    }

	private void onClientSetup(final FMLClientSetupEvent event) 
    {
    	if (CoreConfigLogging.general.get())
    	{
    		LOGGER.info("Client Setup Registerd!");
    	}
    }
	
	public void onloadComplete(final FMLLoadCompleteEvent event) 
	{
    	if (CoreConfigLogging.general.get())
    	{
			LOGGER.info(NAME + " " + VERSION + " successfully loaded!");
    	}
    	
    	if (CoreConfigLogging.submods.get())
    	{
			LOGGER.info("Oedldoedl Core is installed: " + ModList.get().isLoaded("oedldoedlcore"));
			LOGGER.info("Oedldoedl Resources is installed: " + ModList.get().isLoaded("oedldoedlresources"));
			LOGGER.info("Oedldoedl Gear is installed: " + ModList.get().isLoaded("oedldoedlgear"));
			LOGGER.info("Oedldoedl Construct is installed: " + ModList.get().isLoaded("oedldoedlconstruct"));
			LOGGER.info("Oedldoedl Music is installed: " + ModList.get().isLoaded("oedldoedlmusic"));
			LOGGER.info("Oedldoedl Integration is installed: " + ModList.get().isLoaded("oedldoedlintegration"));
    	}
	}
}