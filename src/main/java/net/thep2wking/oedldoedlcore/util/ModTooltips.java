package net.thep2wking.oedldoedlcore.util;

import java.util.List;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.text.TextFormatting;
import net.thep2wking.oedldoedlcore.config.OedldoedlCoreConfig;

/**
 * @author TheP2WKing
 */
public class ModTooltips {
	// keyes
	public static final String KEY_INFO = "core.oedldoedl.info.key";
	public static final String KEY_EFFECTS = "core.oedldoedl.effects.key";
	public static final String KEY_ORIGIN = "core.oedldoedl.origin.key";

	// tooltips
	public static final String EFFECTS_EFFECTS = "core.oedldoedl.effects.tip";
	public static final String EFFECTS_GIVEN = "core.oedldoedl.given.effects.tip";
	public static final String EFFECTS_ENEMY = "core.oedldoedl.enemy.effects.tip";
	public static final String EFFECTS_INVENTORY = "core.oedldoedl.inventory.effects.tip";
	public static final String EFFECTS_HAND = "core.oedldoedl.hand.effects.tip";
	public static final String EFFECTS_WALKING_ON = "core.oedldoedl.walking.effects.tip";
	public static final String EFFECTS_FLUID = "core.oedldoedl.fluid.effects.tip";
	public static final String EFFECTS_CURIOS = "core.oedldoedl.curios.effects.tip";
	public static final String EFFECTS_HELMET = "core.oedldoedl.helmet.effects.tip";
	public static final String EFFECTS_CHESTPLATE = "core.oedldoedl.chestplate.effects.tip";
	public static final String EFFECTS_LEGGINGS = "core.oedldoedl.leggings.effects.tip";
	public static final String EFFECTS_BOOTS = "core.oedldoedl.boots.effects.tip";
	public static final String EFFECTS_FULL_ARMOR = "core.oedldoedl.full.effects.tip";

	// key
	public static void addKey(List<String> tooltip, String key) {
		tooltip.add(TextFormatting.GRAY + I18n.format(key));
	}

	// information
	public static boolean showInfoTip() {
		return GuiScreen.isShiftKeyDown() && OedldoedlCoreConfig.TOOLTIPS.INFORMATION_TOOLTIPS;
	}

	public static boolean showInfoTipKey() {
		return OedldoedlCoreConfig.TOOLTIPS.INFORMATION_TOOLTIPS && OedldoedlCoreConfig.TOOLTIPS.INFORMATION_TOOLTIPS_KEY;
	}

	public static boolean showAnnotationTip() {
		return OedldoedlCoreConfig.TOOLTIPS.ANNOTATION_TOOLTIPS;
	}

	public static void addAnnotation(List<String> tooltip, String name, int count) {
		tooltip.add(OedldoedlCoreConfig.TOOLTIPS.INFORMATION_ANNOTATION_FORMATTING + I18n.format(name + ".annotation" + count));
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

	public static void addPotionEffect(List<String> tooltip, String effectName, boolean isDebuff, int amplifier, int tickDuration) {
		tooltip.add("- " + OedldoedlCoreConfig.TOOLTIPS.EFFECTS_FORMATTING + TextFormatting.ITALIC + I18n.format(effectName) + OedldoedlCoreConfig.TOOLTIPS.EFFECTS_FORMATTING + TextFormatting.ITALIC + " " + getEffectColor(isDebuff) + TextFormatting.ITALIC + "(" + amplifier + ") (" + tickDuration / 20 + " sec)" + TextFormatting.ITALIC);
	}

	public static void addCustomEffectInformation(List<String> tooltip, String name, int index) {tooltip.add("- " + OedldoedlCoreConfig.TOOLTIPS.EFFECTS_FORMATTING + TextFormatting.ITALIC + I18n.format(name + ".effects" + index) +  OedldoedlCoreConfig.TOOLTIPS.EFFECTS_FORMATTING + TextFormatting.ITALIC);
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