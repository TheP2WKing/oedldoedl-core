package net.thep2wking.oedldoedlcore.config.categories;

import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.config.Config;

public class Tooltips {
	public enum TextColor {
		BLACK(TextFormatting.BLACK),
		DARK_BLUE(TextFormatting.DARK_BLUE),
		DARK_GREEN(TextFormatting.DARK_GREEN),
		DARK_AQUA(TextFormatting.DARK_AQUA),
		DARK_RED(TextFormatting.DARK_RED),
		DARK_PURPLE(TextFormatting.DARK_PURPLE),
		GOLD(TextFormatting.GOLD),
		GRAY(TextFormatting.GRAY),
		DARK_GRAY(TextFormatting.DARK_GRAY),
		BLUE(TextFormatting.BLUE),
		GREEN(TextFormatting.GREEN),
		AQUA(TextFormatting.AQUA),
		RED(TextFormatting.RED),
		LIGHT_PURPLE(TextFormatting.LIGHT_PURPLE),
		YELLOW(TextFormatting.YELLOW),
		WHITE(TextFormatting.WHITE),
		;

		public final TextFormatting color;

		private TextColor(TextFormatting color) {
			this.color = color;
		}

		public TextFormatting getColor() {
			return this.color;
		}
	}

	@Config.Name("colors")
	public final Colors COLORS = new Colors();

	public static class Colors {
		@Config.Name("Information Tooltip Formatting")
		public TextColor INFORMATION_FORMATTING = TextColor.WHITE;

		@Config.Name("Information Annotation Tooltip Formatting")
		public TextColor INFORMATION_ANNOTATION_FORMATTING = TextColor.GOLD;

		@Config.Name("Effect Tooltip Formatting")
		public TextColor EFFECTS_FORMATTING = TextColor.AQUA;

		@Config.Name("Effect Positive Formatting")
		public TextColor EFFECTS_POSITIVE_FORMATTING = TextColor.GREEN;

		@Config.Name("Effect Negative Formatting")
		public TextColor EFFECTS_NEGATIVE_FORMATTING = TextColor.RED;

		@Config.Name("Effect Annotation Tooltip Formatting")
		public TextColor EFFECTS_ANNOTATION_FORMATTING = TextColor.GOLD;
	}

	@Config.Name("Enable Annotation Tooltips")
	public boolean ANNOTATION_TOOLTIPS = true;

	@Config.Name("Enable Information Tooltips")
	public boolean INFORMATION_TOOLTIPS = true;

	@Config.Name("Enable Information Tooltips Key")
	public boolean INFORMATION_TOOLTIPS_KEY = true;

	@Config.Name("Enable Effect Tooltips")
	public boolean EFFECTS_TOOLTIPS = true;

	@Config.Name("Enable Effect Tooltips Key")
	public boolean EFFECTS_TOOLTIPS_KEY = true;
}
