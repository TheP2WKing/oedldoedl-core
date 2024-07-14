package net.thep2wking.oedldoedlcore.config.categories;

import net.minecraftforge.common.config.Config;

public class Content {
	@Config.Name("Unobtainable Creative Tab")
	public boolean UNIBTAINABLE_CREATIVE_TAB = true;

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
}
