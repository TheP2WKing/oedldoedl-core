package net.thep2wking.oedldoedlcore;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.thep2wking.oedldoedlcore.config.CoreConfig;
import net.thep2wking.oedldoedlcore.init.ModItems;

@Mod(OedldoedlCore.MODID)
public class OedldoedlCore
{
	public static final String MODID = "oedldoedlcore";
	public static final String NAME = "Oedldoedl Core";
	public static final String VERSION = "1.16.5-3.5.0";
	
	public static OedldoedlCore INSTANCE;
	
    public static final Logger LOGGER = LogManager.getLogger();

    public OedldoedlCore() 
    {
    	LOGGER.info("Hello, World!");
    	
    	CoreConfig.init();
    	
    	if (CoreConfig.general_logging.get()) {LOGGER.info("Registerd Config for" + MODID + "!");}
    	
    	IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

    	ModItems.register(eventBus);
    	
    	eventBus.addListener(this::onCommonSetup);
    	eventBus.addListener(this::onClientSetup);
    	eventBus.addListener(this::onloadComplete);
        
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void onCommonSetup(final FMLCommonSetupEvent event)
    {
    	if (CoreConfig.general_logging.get()) {LOGGER.info("Registerd Common Setup for" + MODID + "!");}
    }

	private void onClientSetup(final FMLClientSetupEvent event) 
    {
    	if (CoreConfig.general_logging.get()) {LOGGER.info("Registerd Client Setup for" + MODID + "!");}
    }
	
	private void onloadComplete(final FMLLoadCompleteEvent event) 
	{
    	if (CoreConfig.integrations_logging.get() && ModList.get().isLoaded("jei")) {LOGGER.info("Loaded JEI Compat for" + MODID + "!");}
    	if (CoreConfig.integrations_logging.get() && ModList.get().isLoaded("configured")) {LOGGER.info("Loaded Configured Compat for" + MODID + "!");}
    	
    	if (CoreConfig.submods_logging.get())
    	{
			LOGGER.info("Oedldoedl Resources is installed: " + ModList.get().isLoaded("oedldoedlresources"));
			LOGGER.info("Oedldoedl Gear is installed: " + ModList.get().isLoaded("oedldoedlgear"));
			LOGGER.info("Oedldoedl Construct is installed: " + ModList.get().isLoaded("oedldoedlconstruct"));
			LOGGER.info("Oedldoedl Music is installed: " + ModList.get().isLoaded("oedldoedlmusic"));
			LOGGER.info("Oedldoedl Integration is installed: " + ModList.get().isLoaded("oedldoedlintegration"));
    	}
    	
    	if (CoreConfig.general_logging.get()) {LOGGER.info(NAME + " " + VERSION + " successfully loaded!");}
	}		
}