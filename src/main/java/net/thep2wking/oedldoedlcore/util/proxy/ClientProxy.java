package net.thep2wking.oedldoedlcore.util.proxy;

import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.discovery.ASMDataTable;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.thep2wking.oedldoedlcore.OedldoedlCore;
import net.thep2wking.oedldoedlcore.util.ModLogger;
import net.thep2wking.oedldoedlcore.util.ModMobSpawnerRenderer;
import net.thep2wking.oedldoedlcore.util.integration.ModJERPluginLoader;

public class ClientProxy extends CommonProxy {
	private ASMDataTable asmDataTable;

	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
		asmDataTable = event.getAsmData();

		if (Loader.isModLoaded("codechickenlib")) {
			ModMobSpawnerRenderer.registerMobSpawnerRenderer();
			ModLogger.registeredIntegration("CodeChicken Lib", OedldoedlCore.MODID);
		}
	}
	
	public void init(FMLInitializationEvent event) {
		super.init(event);

		if (Loader.isModLoaded("jeresources")) {
			ModJERPluginLoader.loadJERPlugins(asmDataTable);
		}
	}

	public void postInit(FMLPostInitializationEvent event) {
		super.postInit(event);
	}
}