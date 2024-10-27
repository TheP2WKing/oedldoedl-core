package net.thep2wking.oedldoedlcore.util.integration;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.discovery.ASMDataTable;
import net.thep2wking.oedldoedlcore.api.integration.JERPlugin;
import net.thep2wking.oedldoedlcore.api.integration.ModJERPluginBase;
import net.thep2wking.oedldoedlcore.config.CoreConfig;
import net.thep2wking.oedldoedlcore.util.ModLogger;

/**
 * @author TheP2WKing
 */
public class ModJERPluginLoader {
	public static List<IJERPlugin> getModPlugins(ASMDataTable asmDataTable) {
		return getInstances(asmDataTable, JERPlugin.class, IJERPlugin.class);
	}

	private static <T> List<T> getInstances(ASMDataTable asmDataTable, Class<?> annotationClass,
			Class<T> instanceClass) {
		String annotationClassName = annotationClass.getCanonicalName();
		Set<ASMDataTable.ASMData> asmDatas = asmDataTable.getAll(annotationClassName);
		List<T> instances = new ArrayList<>();
		for (ASMDataTable.ASMData asmData : asmDatas) {
			try {
				Class<?> asmClass = Class.forName(asmData.getClassName());
				Class<? extends T> asmInstanceClass = asmClass.asSubclass(instanceClass);
				T instance = asmInstanceClass.getDeclaredConstructor().newInstance();
				instances.add(instance);
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | LinkageError
					| NoSuchMethodException | InvocationTargetException e) {
				System.err.println("Failed to load: " + asmData.getClassName());
				e.printStackTrace();
			}
		}
		return instances;
	}

	public static void loadJERPlugins(ASMDataTable asmData) {
		List<IJERPlugin> plugins = getModPlugins(asmData);
		List<String> registeredPlugins = new ArrayList<>();
		for (IJERPlugin plugin : plugins) {
			if (plugin != null && CoreConfig.INTEGRATION.JER.JER_PLUGIN_LOADER) {
				registerPlugin(plugin);
				registeredPlugins.add(plugin.getModId());
			}
		}
		if (registeredPlugins.isEmpty()) {
			ModLogger.LOGGER.info("Loaded 0 JER Plugin(s): No JER Plugins found!");
		} else {
			ModLogger.LOGGER.info(
					"Loaded " + registeredPlugins.size() + " JER Plugin(s): " + String.join(", ", registeredPlugins));
		}
	}

	private static void registerPlugin(IJERPlugin plugin) {
		if (plugin != null && Loader.isModLoaded("jeresources")) {
			((ModJERPluginBase) plugin).init(true);
		}
	}
}