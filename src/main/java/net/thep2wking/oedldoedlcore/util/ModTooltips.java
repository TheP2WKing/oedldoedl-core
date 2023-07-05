package net.thep2wking.oedldoedlcore.util;

import java.util.List;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.text.TextFormatting;
import net.thep2wking.oedldoedlcore.OedldoedlCore;
import net.thep2wking.oedldoedlcore.config.OedldoedlCoreConfig;

/**
 * @author TheP2WKing
 */
public class ModTooltips {
	// keyes
	public static final String KEY_INFO = "key" + OedldoedlCore.MODID + "info";
	public static final String KEY_EFFECTS = "key" + OedldoedlCore.MODID + "effects";
	public static final String KEY_ORIGIN = "key" + OedldoedlCore.MODID + "origin";

	// tooltips
	public static final String EFFECTS_EFFECTS = "effects" + OedldoedlCore.MODID + "tip";
	public static final String EFFECTS_GIVEN = "effects" + OedldoedlCore.MODID + "given.tip";
	public static final String EFFECTS_ENEMY = "effects" + OedldoedlCore.MODID + "enemy.tip";
	public static final String EFFECTS_INVENTORY = "effects" + OedldoedlCore.MODID + "inventory.tip";
	public static final String EFFECTS_HAND = "effects" + OedldoedlCore.MODID + "hand.tip";
	public static final String EFFECTS_WALKING_ON = "effects" + OedldoedlCore.MODID + "walking.tip";
	public static final String EFFECTS_FLUID = "effects" + OedldoedlCore.MODID + "fluid.tip";
	public static final String EFFECTS_CURIOS = "effects" + OedldoedlCore.MODID + "bauble.tip";
	public static final String EFFECTS_HELMET = "effects" + OedldoedlCore.MODID + "helmet.tip";
	public static final String EFFECTS_CHESTPLATE = "effects" + OedldoedlCore.MODID + "chestplate.tip";
	public static final String EFFECTS_LEGGINGS = "effects" + OedldoedlCore.MODID + "leggings.tip";
	public static final String EFFECTS_BOOTS = "effects" + OedldoedlCore.MODID + "boots.tip";
	public static final String EFFECTS_FULL_ARMOR = "effects" + OedldoedlCore.MODID + "full.tip";

	// key
	public static void addKey(List<String> tooltip, String key) {
		tooltip.add(TextFormatting.GRAY + I18n.format(key));
	}

	// information
	public static boolean showInfoTip() {
		return GuiScreen.isShiftKeyDown() && OedldoedlCoreConfig.TOOLTIPS.INFORMATION_TOOLTIPS;
	}

	public static boolean showInfoTipKey() {
		return OedldoedlCoreConfig.TOOLTIPS.INFORMATION_TOOLTIPS
				&& OedldoedlCoreConfig.TOOLTIPS.INFORMATION_TOOLTIPS_KEY;
	}

	public static boolean showAnnotationTip() {
		return OedldoedlCoreConfig.TOOLTIPS.ANNOTATION_TOOLTIPS;
	}

	public static void addAnnotation(List<String> tooltip, String name, int count) {
		tooltip.add(OedldoedlCoreConfig.TOOLTIPS.INFORMATION_ANNOTATION_FORMATTING
				+ I18n.format(name + ".annotation" + count));
	}

	public static void addInformation(List<String> tooltip, String name, int count) {
		tooltip.add(OedldoedlCoreConfig.TOOLTIPS.INFORMATION_FORMATTING + I18n.format(name + ".tip" + count));
	}

	// effects
	public static boolean showEffectTip() {
		return GuiScreen.isCtrlKeyDown() && OedldoedlCoreConfig.TOOLTIPS.EFFECTS_TOOLTIPS;
	}

	public static boolean showEffectTipKey() {
		return OedldoedlCoreConfig.TOOLTIPS.EFFECTS_TOOLTIPS && OedldoedlCoreConfig.TOOLTIPS.EFFECTS_TOOLTIPS_KEY;
	}

	public static void addEffectHeader(List<String> tooltip, String operation) {
		tooltip.add(OedldoedlCoreConfig.TOOLTIPS.EFFECTS_ANNOTATION_FORMATTING + I18n.format(operation));
	}

	public static void addPotionEffect(List<String> tooltip, String effectName, boolean isDebuff, int amplifier,
			int tickDuration) {
		tooltip.add("- " + OedldoedlCoreConfig.TOOLTIPS.EFFECTS_FORMATTING + TextFormatting.ITALIC
				+ I18n.format(effectName) + OedldoedlCoreConfig.TOOLTIPS.EFFECTS_FORMATTING + TextFormatting.ITALIC
				+ " " + getEffectColor(isDebuff) + TextFormatting.ITALIC + "(" + amplifier + ") (" + tickDuration / 20
				+ " sec)" + TextFormatting.ITALIC);
	}

	public static void addCustomEffectInformation(List<String> tooltip, String name, int index) {
		tooltip.add("- " + OedldoedlCoreConfig.TOOLTIPS.EFFECTS_FORMATTING + TextFormatting.ITALIC
				+ I18n.format(name + ".effects" + index) + OedldoedlCoreConfig.TOOLTIPS.EFFECTS_FORMATTING
				+ TextFormatting.ITALIC);
	}

	public static TextFormatting getEffectColor(boolean isDebuff) {
		if (isDebuff) {
			return OedldoedlCoreConfig.TOOLTIPS.EFFECTS_NEGATIVE_FORMATTING;
		}
		return OedldoedlCoreConfig.TOOLTIPS.EFFECTS_POSITIVE_FORMATTING;
	}

	// origin
	public static boolean showOriginTip() {
		return GuiScreen.isAltKeyDown() && OedldoedlCoreConfig.TOOLTIPS.ORIGIN_TOOLTIPS;
	}

	public static boolean showOriginTipKey() {
		return OedldoedlCoreConfig.TOOLTIPS.ORIGIN_TOOLTIPS && OedldoedlCoreConfig.TOOLTIPS.ORIGIN_TOOLTIPS_KEY;
	}
}