package net.thep2wking.oedldoedlcore.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class CoreConfigLogging 
{
	public static ForgeConfigSpec.BooleanValue general;
	public static ForgeConfigSpec.BooleanValue submods;
	  
	public static void init(ForgeConfigSpec.Builder builder)
	{
		builder.comment("Logging");
		
		general = builder
		.comment("Logs general stuff while modloading.")
		.define("logging.general", true);
		
		submods = builder
		.comment("Logs if submods are installed.")
		.define("logging.submods", true);
	}
}