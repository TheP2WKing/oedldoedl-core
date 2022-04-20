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
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.thep2wking.oedldoedlcore.config.CoreConfig;
import net.thep2wking.oedldoedlcore.init.ModConditions;
import net.thep2wking.oedldoedlcore.init.ModItems;
import net.thep2wking.oedldoedlcore.init.ModSounds;

@Mod(OedldoedlCore.MODID)
public class OedldoedlCore {
	public static final String MODID = "oedldoedlcore";
	public static final String NAME = "Oedldoedl Core";
	public static final String VERSION = "1.16.5-3.9.0";

	public static OedldoedlCore INSTANCE;

	public static final Logger LOGGER = LogManager.getLogger();

	public OedldoedlCore() {
		CoreConfig.init();

		LOGGER.info("Registerd Config for " + MODID + "!");

		IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

		eventBus.register(new ModConditions());

		ModItems.register(eventBus);
		ModSounds.register(eventBus);

		eventBus.addListener(this::onCommonSetup);
		eventBus.addListener(this::onClientSetup);
		eventBus.addListener(this::onEnqueueSetup);
		eventBus.addListener(this::onloadComplete);

		MinecraftForge.EVENT_BUS.register(this);
	}

	private void onCommonSetup(final FMLCommonSetupEvent event) {
		LOGGER.info("Registerd Common Setup for " + MODID + "!");
	}

	private void onClientSetup(final FMLClientSetupEvent event) {
		LOGGER.info("Registerd Client Setup for " + MODID + "!");
	}

	private void onEnqueueSetup(final InterModEnqueueEvent event) {
		LOGGER.info("Registerd IMC Setup for " + MODID + "!");
	}

	private void onloadComplete(final FMLLoadCompleteEvent event) {
		if (ModList.get().isLoaded("jei")) {
			LOGGER.info("Loaded JEI Compat for " + MODID + "!");
		}
		if (ModList.get().isLoaded("configured")) {
			LOGGER.info("Loaded Configured Compat for " + MODID + "!");
		}

		LOGGER.info("Oedldoedl Resources is installed: " + ModList.get().isLoaded("oedldoedlresources"));
		LOGGER.info("Oedldoedl Gear is installed: " + ModList.get().isLoaded("oedldoedlgear"));
		LOGGER.info("Oedldoedl Curiosity is installed: " + ModList.get().isLoaded("oedldoedlcuriosity"));
		LOGGER.info("Oedldoedl Construct is installed: " + ModList.get().isLoaded("oedldoedlconstruct"));
		LOGGER.info("Oedldoedl Music is installed: " + ModList.get().isLoaded("oedldoedlmusic"));
		LOGGER.info("Oedldoedl Integration is installed: " + ModList.get().isLoaded("oedldoedlintegration"));

		LOGGER.info(NAME + " " + VERSION + " successfully loaded!");
	}
}