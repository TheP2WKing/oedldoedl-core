package net.thep2wking.oedldoedlcore.config;

import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.ForgeConfigSpec;

public class CoreConfigTooltips 
{
	public static ForgeConfigSpec.BooleanValue information;
	public static ForgeConfigSpec.EnumValue<TextFormatting> information_formatting;
	public static ForgeConfigSpec.EnumValue<TextFormatting> information_annotation_formatting;
	
	public static ForgeConfigSpec.BooleanValue effects;
	public static ForgeConfigSpec.EnumValue<TextFormatting> effects_formatting;
	public static ForgeConfigSpec.EnumValue<TextFormatting> effects_annotation_formatting;
	
	public static ForgeConfigSpec.BooleanValue origin;
	public static ForgeConfigSpec.EnumValue<TextFormatting> origin_formatting;
	public static ForgeConfigSpec.EnumValue<TextFormatting> origin_annotation_formatting;
	  
	public static void init(ForgeConfigSpec.Builder builder)
	{
		builder.comment("Tooltips");
		
		information = builder
		.comment("Show Developer Referenced for Oedldoedl Projects in tooltips.")
		.define("tooltips.information", false);
		
		information_formatting = builder
		.comment("Set info tooltip formatting.")
		.defineEnum("tooltips.information_formatting", TextFormatting.WHITE);
		
		information_annotation_formatting = builder
		.comment("Set info annotation tooltip formatting.")
		.defineEnum("tooltips.information_annotation_formatting", TextFormatting.DARK_GREEN);
		
		effects = builder
		.comment("Show effects in tooltips.")
		.define("tooltips.effects", true);
		
		effects_formatting = builder
		.comment("Set effects tooltip formatting.")
		.defineEnum("tooltips.effects_formatting", TextFormatting.WHITE);
		
		effects_annotation_formatting = builder
		.comment("Set effects annotation tooltip formatting.")
		.defineEnum("tooltips.effects_annotation_formatting", TextFormatting.DARK_GREEN);
		
		origin = builder
		.comment("Show origin in tooltips.")
		.define("tooltips.origin", true);
		
		origin_formatting = builder
		.comment("Set origin tooltip formatting.")
		.defineEnum("tooltips.origin_formatting", TextFormatting.WHITE);
		
		origin_annotation_formatting = builder
		.comment("Set origin annotation tooltip formatting.")
		.defineEnum("tooltips.origin_annotation_formatting", TextFormatting.DARK_GREEN);
	}
}