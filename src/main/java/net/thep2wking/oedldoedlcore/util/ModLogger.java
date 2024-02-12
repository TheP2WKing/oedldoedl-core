package net.thep2wking.oedldoedlcore.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.thep2wking.oedldoedlcore.config.CoreConfig;

/**
 * @author TheP2WKing
 */
public class ModLogger {
	// logger for all oedldoedl mods
	public static final Logger LOGGER = LogManager.getLogger(ModReferences.BASE_NAME);

	public static void info(Object message) {
		ModLogger.LOGGER.info(message);
	}

	// init events
	public static void preInitLogger(String mod) {
		if (CoreConfig.LOGGING.CONSOLE_LOGGING) {
			ModLogger.LOGGER.info("Starting FML Pre-Initialization for " + mod);
		}
	}

	public static void initLogger(String mod) {
		if (CoreConfig.LOGGING.CONSOLE_LOGGING) {
			ModLogger.LOGGER.info("Starting FML Initialization for " + mod);
		}
	}

	public static void postInitLogger(String mod) {
		if (CoreConfig.LOGGING.CONSOLE_LOGGING) {
			ModLogger.LOGGER.info("Starting FML Post-Initialization for " + mod);
		}
	}

	public static void loadCompleteLogger(String mod, String version) {
		if (CoreConfig.LOGGING.CONSOLE_LOGGING) {
			ModLogger.LOGGER.info(mod + " v" + version + " " + "loaded!");
		}
	}

	// content registering
	public static void registeredBlocksLogger(String mod) {
		if (CoreConfig.LOGGING.CONSOLE_LOGGING) {
			ModLogger.LOGGER.info("Registered blocks for " + mod);
		}
	}

	public static void registeredItemsLogger(String mod) {
		if (CoreConfig.LOGGING.CONSOLE_LOGGING) {
			ModLogger.LOGGER.info("Registered items for " + mod);
		}
	}

	public static void registeredFluidsLogger(String mod) {
		if (CoreConfig.LOGGING.CONSOLE_LOGGING) {
			ModLogger.LOGGER.info("Registered fluids for " + mod);
		}
	}

	public static void registeredSoundEventsLogger(String mod) {
		if (CoreConfig.LOGGING.CONSOLE_LOGGING) {
			ModLogger.LOGGER.info("Registered sounds for " + mod);
		}
	}

	public static void registeredEntitiesLogger(String mod) {
		if (CoreConfig.LOGGING.CONSOLE_LOGGING) {
			ModLogger.LOGGER.info("Registered entities for " + mod);
		}
	}

	public static void registeredConditionsLogger(String mod) {
		if (CoreConfig.LOGGING.CONSOLE_LOGGING) {
			ModLogger.LOGGER.info("Registered conditions for " + mod);
		}
	}

	public static void registeredOreDictLogger(String mod) {
		if (CoreConfig.LOGGING.CONSOLE_LOGGING) {
			ModLogger.LOGGER.info("Registered oredict for " + mod);
		}
	}

	public static void registeredRecipesLogger(String mod) {
		if (CoreConfig.LOGGING.CONSOLE_LOGGING) {
			ModLogger.LOGGER.info("Registered recipes for " + mod);
		}
	}

	public static void registeredWorldGenLogger(String mod) {
		if (CoreConfig.LOGGING.CONSOLE_LOGGING) {
			ModLogger.LOGGER.info("Registered worldgen for " + mod);
		}
	}

	public static void registeredRendererLogger(String mod) {
		if (CoreConfig.LOGGING.CONSOLE_LOGGING) {
			ModLogger.LOGGER.info("Registered renderer for " + mod);
		}
	}

	public static void registeredModelsLogger(String mod) {
		if (CoreConfig.LOGGING.CONSOLE_LOGGING) {
			ModLogger.LOGGER.info("Registered models for " + mod);
		}
	}

	// integration
	public static void registeredIntegration(String integration, String mod) {
		if (CoreConfig.LOGGING.CONSOLE_LOGGING) {
			ModLogger.LOGGER.info(integration + " integration loaded for " + mod);
		}
	}
}