package net.thep2wking.oedldoedlcore.config.categories;

import net.minecraftforge.common.config.Config;

public class Content {
	@Config.Name("Unobtainable Creative Tab")
	public boolean UNOBTAINABLE_CREATIVE_TAB = true;

	@Config.Name("Debug Stick Useable In Survival")
	public boolean DEBUG_STICK_USEABLE_IN_SURVIVAL = false;

	@Config.Name("Missing Spawn Eggs")
	public boolean MISSING_SPAWN_EGGS = true;

	@Config.Name("Slow Falling Motion Multiplier")
	@Config.RangeDouble(min = 0, max = 1)
	public double SLOW_FALLING_MOTION_MULTIPLIER = 0.5;

	@Config.Name("Dolphin Grace Motion Multiplier Per Level")
	@Config.RangeDouble(min = 0, max = 1)
	public double DOLPHIN_GRACE_MOTION_MULTIPLIER_PER_LEVEL = 0.15;

	@Config.Name("spawner")
	public final Spawner SPAWNER = new Spawner();

	public static class Spawner {
		public enum SpawnerEntitySource {
			ENTITY_EGGS("entity_eggs"),
			ENTITY_LIVING("entity_living"),
			ENTITY_REGISTRY("entity_registry");

			public final String source;

			private SpawnerEntitySource(String source) {
				this.source = source;
			}

			public String getSource() {
				return this.source;
			}
		}

		public enum SpawnerEntitySize {
			CALCULATED("calculated"),
			FIXED("fixed"),
			;

			public final String size;

			private SpawnerEntitySize(String size) {
				this.size = size;
			}

			public String getSize() {
				return this.size;
			}
		}

		@Config.Name("Enable Mob Spawner Renderer")
		public boolean ENTITY_RENDERER = false;

		@Config.Name("Display Entity Name")
		public boolean DISPLAY_NAME = true;

		@Config.Name("Entity Source")
		public SpawnerEntitySource ENTITY_SOURCE = SpawnerEntitySource.ENTITY_EGGS;

		@Config.Name("Entity Size")
		public SpawnerEntitySize ENTITY_SIZE = SpawnerEntitySize.CALCULATED;

		@Config.Name("Blacklisted Mods Or Entities")
		public String[] BLACKLIST = new String[]{"minecraft:ender_dragon","thaumcraft", "iceandfire", "cfm"};
	}
}