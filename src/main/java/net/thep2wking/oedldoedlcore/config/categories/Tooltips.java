package net.thep2wking.oedldoedlcore.config.categories;

import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.config.Config;

public class Tooltips {
	@Config.Name("Enable Annotation Tooltips")
	public boolean ANNOTATION_TOOLTIPS = true;

	@Config.Name("Annotation Tooltip Formatting")
	public TextFormatting ANNOTATION_FORMATTING = TextFormatting.WHITE;

	@Config.Name("Enable Information Tooltips")
	public boolean INFORMATION_TOOLTIPS = true;

	@Config.Name("Enable Information Tooltips Key")
	public boolean INFORMATION_TOOLTIPS_KEY = true;

	@Config.Name("Information Tooltip Formatting")
	public TextFormatting INFORMATION_FORMATTING = TextFormatting.WHITE;

	@Config.Name("Information Annotation Tooltip Formatting")
	public TextFormatting INFORMATION_ANNOTATION_FORMATTING = TextFormatting.GOLD;

	@Config.Name("Enable Effects Tooltips")
	public boolean EFFECTS_TOOLTIPS = true;

	@Config.Name("Enable Effects Tooltips Key")
	public boolean EFFECTS_TOOLTIPS_KEY = true;

	@Config.Name("Effects Tooltip Formatting")
	public TextFormatting EFFECTS_FORMATTING = TextFormatting.AQUA;

	@Config.Name("Effects Positive Formatting")
	public TextFormatting EFFECTS_POSITIVE_FORMATTING = TextFormatting.GREEN;

	@Config.Name("Effects Negative Formatting")
	public TextFormatting EFFECTS_NEGATIVE_FORMATTING = TextFormatting.RED;

	@Config.Name("Effects Annotation Tooltip Formatting")
	public TextFormatting EFFECTS_ANNOTATION_FORMATTING = TextFormatting.GOLD;

	@Config.Name("Enable Origin Tooltips")
	public boolean ORIGIN_TOOLTIPS = true;

	@Config.Name("Enable Origin Tooltips Key")
	public boolean ORIGIN_TOOLTIPS_KEY = true;
}
