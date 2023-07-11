package net.thep2wking.oedldoedlcore.config.categories;

import net.minecraftforge.common.config.Config;

public class Properties {
	@Config.Name("Colorful Rarities")
	public boolean COLORFUL_RARITIES = true;

	@Config.Name("Enchantment Effects")
	public boolean ENCHANTMENT_EFFECTS = true;

	@Config.Name("Blocks Drop Experience")
	public boolean BLOCKS_DROP_EXPERIENCE = true;

	@Config.Name("durabilities")
	public final Durabilities DURABILITIES = new Durabilities();

	public static class Durabilities {
		@Config.Name("Shears Durability Multiplier")
		@Config.RangeDouble(min = 0.0, max = 10.0)
		public double SHEARS_DURABILITY_MULTIPLIER = 0.94957983;

		@Config.Name("Paxel Durability Multiplier")
		@Config.RangeDouble(min = 0.0, max = 10.0)
		public double PAXEL_DURABILITY_MULTIPLIER = 3.0;

		@Config.Name("Shield Durability Multiplier")
		@Config.RangeDouble(min = 0.0, max = 10.0)
		public double SHIELD_DURABILITY_MULTIPLIER = 3.0;
	}
}