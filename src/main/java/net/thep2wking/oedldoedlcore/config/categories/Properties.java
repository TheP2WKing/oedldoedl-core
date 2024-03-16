package net.thep2wking.oedldoedlcore.config.categories;

import net.minecraftforge.common.config.Config;

public class Properties {
	@Config.Name("Colorful Rarities")
	public boolean COLORFUL_RARITIES = true;

	@Config.Name("Enchantment Effects")
	public boolean ENCHANTMENT_EFFECTS = true;

	@Config.Name("RGB Durability Bars")
	public boolean RGB_DURABILITY_BARS = true;

	@Config.Name("Shield Attack Damage")
	public boolean SHIELD_ATTACK_DAMAGE = true;

	@Config.Name("Ores Drop Experience")
	public boolean ORES_DROP_EXPERIENCE = true;

	@Config.Name("Blocks Emit Light")
	public boolean BLOCKS_EMIT_LIGHT = true;

	@Config.Name("Paxel Durability Multiplier")
	@Config.RangeDouble(min = 0.0, max = 10.0)
	public double PAXEL_DURABILITY_MULTIPLIER = 3.0;

	@Config.Name("beacons")
	public final Beacons BEACONS = new Beacons();

	public static class Beacons {
		@Config.Name("Beacon Payments")
		public boolean BEACON_PAYMENTS = true;

		@Config.Name("Beacon Bases")
		public boolean BEACON_BASES = true;
	}

	@Config.Name("creative")
	public final Creative CREATIVE = new Creative();

	public static class Creative {
		@Config.Name("Add Forge Buckets To Creative Tabs")
		public boolean ADD_FORGE_BUCKETS_TO_CREATIVE_TABS = true;

		@Config.Name("Add Spawn Eggs To Creative Tabs")
		public boolean ADD_SPAWN_EGGS_TO_CREATIVE_TABS = false;

		@Config.Name("Add Potions To Creative Tabs")
		public boolean ADD_POTIONS_TO_CREATIVE_TABS = true;
	}
}