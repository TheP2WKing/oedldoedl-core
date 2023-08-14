package net.thep2wking.oedldoedlcore.config.categories;

import net.minecraftforge.common.config.Config;

public class Logging {
	@Config.Name("Enable Console Logging")
	public boolean CONSOLE_LOGGING = true;

	@Config.Name("Enable Join Messages")
	public boolean JOIN_MESSAGES = true;

	@Config.Name("Join Message Text")
	public String JOIN_MESSAGE_TEXT = "Thanks for Installing!";
}