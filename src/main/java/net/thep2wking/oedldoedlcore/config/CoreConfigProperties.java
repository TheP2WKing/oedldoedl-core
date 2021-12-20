package net.thep2wking.oedldoedlcore.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class CoreConfigProperties 
{
	public static ForgeConfigSpec.BooleanValue rarities;
	public static ForgeConfigSpec.BooleanValue effects;
	  
	public static void init(ForgeConfigSpec.Builder builder)
	{
		builder.comment("Properties ");
		
		rarities = builder
		.comment("Items have custom rarities.")
		.define("properties.rarities", true);
		
		effects = builder
		.comment("Items have enchanted effects.")
		.define("properties.effects", true);
	}
}