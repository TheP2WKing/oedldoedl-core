package net.thep2wking.oedldoedlcore.util.proxy;

import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.thep2wking.oedldoedlcore.OedldoedlCore;
import net.thep2wking.oedldoedlcore.integration.top.TOPCompatibility;
import net.thep2wking.oedldoedlcore.util.ModLogger;

public class CommonProxy {
	public void preInit(FMLPreInitializationEvent event) {
		if (Loader.isModLoaded("theoneprobe")) {
			ModLogger.registeredIntegration("TheOneProbe", OedldoedlCore.MODID);
			TOPCompatibility.register();
		}
	}

	public void init(FMLInitializationEvent event) {
	}

	public void postInit(FMLPostInitializationEvent event) {
	}
}