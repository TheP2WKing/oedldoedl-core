package net.thep2wking.oedldoedlcore.config;

import java.io.File;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;
import net.thep2wking.oedldoedlcore.OedldoedlCore;

@Mod.EventBusSubscriber
public class CoreConfig 
{
	private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec CONFIG;
	
	static
	{
		CoreConfigTooltips.init(BUILDER);
		CoreConfigLogging.init(BUILDER);
		CoreConfigProperties.init(BUILDER);
		CONFIG = BUILDER.build();
	}
	
	public static void loadConfig(ForgeConfigSpec config, String path)
	{
    	if (CoreConfigLogging.general.get())
    	{
    		OedldoedlCore.LOGGER.info("Loading Config File: " + path);
    	}
		final CommentedFileConfig file = CommentedFileConfig.builder(new File(path)).sync().autosave().writingMode(WritingMode.REPLACE).build();
    	if (CoreConfigLogging.general.get())
    	{
    		OedldoedlCore.LOGGER.info("Build Config File: " + path);
    	}
		file.load();
    	if (CoreConfigLogging.general.get())
    	{
    		OedldoedlCore.LOGGER.info("Loaded Config File: " + path);
    	}
		config.setConfig(file);
	}
}