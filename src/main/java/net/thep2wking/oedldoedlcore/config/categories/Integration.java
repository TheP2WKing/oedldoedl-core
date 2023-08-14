package net.thep2wking.oedldoedlcore.config.categories;

import net.minecraftforge.common.config.Config;

public class Integration {
	@Config.Name("jei")
	public final JEI JEI = new JEI();

	public static class JEI {
		@Config.Name("Additional Recipe Descriptions")
		public boolean ADDITIONAL_RECIPE_DESCRIPTIONS = true;

		@Config.Name("Anvil Recipe Catalysts")
		public boolean ANVIL_RECIPE_CATALYSTS = true;

		@Config.Name("Hide Player Head")
		public boolean HIDE_PLAYER_HEAD = true;

		@Config.Name("Hide Baubles Miners Ring")
		public boolean HIDE_BAUBLES_MINERS_RING = true;

		@Config.Name("Hide AE2 Facades")
		public boolean HIDE_AE2_FACADES = true;

		@Config.Name("Hide BuildCraft Facades")
		public boolean HIDE_BUILDCRAFT_FACADES = true;
	}

	@Config.Name("theoneprobe")
	public final TheOneProbe THEONEPROBE = new TheOneProbe();

	public static class TheOneProbe {
		@Config.Name("Enable TOP Integration")
		public boolean TOP_INTEGRATION = true;
	}
}