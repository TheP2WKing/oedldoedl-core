package net.thep2wking.oedldoedlcore.config.categories;

import net.minecraftforge.common.config.Config;

public class Recipes {
	@Config.Name("Enable Reverse Recipes")
	public boolean REVERSE_RECIPES = true;

	@Config.Name("Enable Additional Recipes")
	public boolean ADDITIONAL_RECIPES = true;

	@Config.Name("Enable Default Recipes")
	public boolean DEFAULT_RECIPES = true;

	@Config.Name("Enable Default Oredict")
	public boolean DEFAULT_OREDICT = true;

	@Config.Name("Enable Brewing Recipes")
	public boolean BREWING_RECIPES = true;
}