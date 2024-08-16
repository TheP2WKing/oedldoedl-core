package net.thep2wking.oedldoedlcore.util.proxy;

import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.thep2wking.oedldoedlcore.OedldoedlCore;
import net.thep2wking.oedldoedlcore.util.ModLogger;
import net.thep2wking.oedldoedlcore.util.ModMobSpawnerRenderer;

public class ClientProxy extends CommonProxy {
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
		if (Loader.isModLoaded("codechickenlib")) {
			ModMobSpawnerRenderer.registerMobSpawnerRenderer();
			ModLogger.registeredIntegration("codechickenlib", OedldoedlCore.MODID);
		}
	}

	public void Init(FMLInitializationEvent event) {
		super.init(event);
	}

	public void postInit(FMLPostInitializationEvent event) {
		super.postInit(event);
	}
}