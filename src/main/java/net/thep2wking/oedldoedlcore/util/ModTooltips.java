package net.thep2wking.oedldoedlcore.util;

import java.util.List;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.text.TextFormatting;
import net.thep2wking.oedldoedlcore.OedldoedlCore;
import net.thep2wking.oedldoedlcore.config.CoreConfig;

/**
 * @author TheP2WKing
 */
public class ModTooltips {
	// keys
	public static final String KEY_INFO = "key." + OedldoedlCore.MODID + ".info";
	public static final String KEY_EFFECTS = "key." + OedldoedlCore.MODID + ".effect";

	// tooltips
	public static final String EFFECT_EFFECTS = "effect." + OedldoedlCore.MODID + ".tip";
	public static final String EFFECT_GIVEN = "effect." + OedldoedlCore.MODID + ".given.tip";
	public static final String EFFECT_ENEMY = "effect." + OedldoedlCore.MODID + ".enemy.tip";
	public static final String EFFECT_INVENTORY = "effect." + OedldoedlCore.MODID + ".inventory.tip";
	public static final String EFFECT_MAIN_HAND = "effect." + OedldoedlCore.MODID + ".mainhand.tip";
	public static final String EFFECT_OFF_HAND = "effect." + OedldoedlCore.MODID + ".offhand.tip";
	public static final String EFFECT_WALKING_ON = "effect." + OedldoedlCore.MODID + ".walking.tip";
	public static final String EFFECT_FLUID = "effect." + OedldoedlCore.MODID + ".fluid.tip";
	public static final String EFFECT_CURIOS = "effect." + OedldoedlCore.MODID + ".bauble.tip";
	public static final String EFFECT_HELMET = "effect." + OedldoedlCore.MODID + ".helmet.tip";
	public static final String EFFECT_CHESTPLATE = "effect." + OedldoedlCore.MODID + ".chestplate.tip";
	public static final String EFFECT_LEGGINGS = "effect." + OedldoedlCore.MODID + ".leggings.tip";
	public static final String EFFECT_BOOTS = "effect." + OedldoedlCore.MODID + ".boots.tip";
	public static final String EFFECT_FULL_ARMOR = "effect." + OedldoedlCore.MODID + ".full.tip";

	// key
	public static void addKey(List<String> tooltip, String key) {
		tooltip.add(TextFormatting.GRAY + I18n.format(key));
	}

	// information
	public static boolean showInfoTip() {
		return GuiScreen.isShiftKeyDown() && CoreConfig.TOOLTIPS.INFORMATION_TOOLTIPS;
	}

	public static boolean showInfoTipKey() {
		return CoreConfig.TOOLTIPS.INFORMATION_TOOLTIPS
				&& CoreConfig.TOOLTIPS.INFORMATION_TOOLTIPS_KEY;
	}

	public static boolean showAnnotationTip() {
		return CoreConfig.TOOLTIPS.ANNOTATION_TOOLTIPS;
	}

	public static void addAnnotation(List<String> tooltip, String name, int count) {
		tooltip.add(CoreConfig.TOOLTIPS.COLORS.INFORMATION_ANNOTATION_FORMATTING.getColor()
				+ I18n.format(name + ".annotation" + count));
	}

	public static void addInformation(List<String> tooltip, String name, int count) {
		tooltip.add(CoreConfig.TOOLTIPS.COLORS.INFORMATION_FORMATTING.getColor()
				+ I18n.format(name + ".tip" + count));
	}

	// effects
	public static boolean showEffectTip() {
		return GuiScreen.isCtrlKeyDown() && CoreConfig.TOOLTIPS.EFFECTS_TOOLTIPS;
	}

	public static boolean showEffectTipKey() {
		return CoreConfig.TOOLTIPS.EFFECTS_TOOLTIPS && CoreConfig.TOOLTIPS.EFFECTS_TOOLTIPS_KEY;
	}

	public static void addEffectHeader(List<String> tooltip, String operation) {
		tooltip.add(
				CoreConfig.TOOLTIPS.COLORS.EFFECTS_ANNOTATION_FORMATTING.getColor() + I18n.format(operation));
	}

	public static void addPotionEffect(List<String> tooltip, String effectName, boolean isDebuff, int amplifier,
			int tickDuration) {
		tooltip.add(TextFormatting.WHITE + "- " + CoreConfig.TOOLTIPS.COLORS.EFFECTS_FORMATTING.getColor() + TextFormatting.ITALIC
				+ I18n.format(effectName) + CoreConfig.TOOLTIPS.COLORS.EFFECTS_FORMATTING.getColor()
				+ TextFormatting.ITALIC
				+ " " + getEffectColor(isDebuff) + TextFormatting.ITALIC + "(" + amplifier + ") (" + tickDuration / 20
				+ " sec)" + TextFormatting.ITALIC);
	}

	public static void addCustomEffectInformation(List<String> tooltip, String name, int index) {
		tooltip.add(TextFormatting.WHITE + "- " + CoreConfig.TOOLTIPS.COLORS.EFFECTS_FORMATTING.getColor() + TextFormatting.ITALIC
				+ I18n.format(name + ".effects" + index)
				+ CoreConfig.TOOLTIPS.COLORS.EFFECTS_FORMATTING.getColor()
				+ TextFormatting.ITALIC);
	}

	public static TextFormatting getEffectColor(boolean isDebuff) {
		if (isDebuff) {
			return CoreConfig.TOOLTIPS.COLORS.EFFECTS_NEGATIVE_FORMATTING.getColor();
		}
		return CoreConfig.TOOLTIPS.COLORS.EFFECTS_POSITIVE_FORMATTING.getColor();
	}
}