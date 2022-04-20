package net.thep2wking.oedldoedlcore.util;

import java.util.List;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.thep2wking.oedldoedlcore.config.CoreConfig;

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
	public static final String EFFECTS_ENEMY= "core.oedldoedl.enemy.effects.tip";
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
	public static void addKey(List<ITextComponent> tooltip, String key) {
		tooltip.add(new TranslationTextComponent(key).mergeStyle(TextFormatting.GRAY));
	}

	// information
	public static boolean showInfoTip() {
		return Screen.hasShiftDown() && CoreConfig.information_tooltip.get();
	}

	public static boolean showInfoTipKey() {
		return CoreConfig.information_tooltip.get() && CoreConfig.information_tooltip_key.get();
	}

	public static boolean showAnnotationTip() {
		return CoreConfig.annotation_tooltip.get();
	}

	public static void addAnnotation(List<ITextComponent> tooltip, String name, int count) {
		tooltip.add(new TranslationTextComponent(name + ".annotation" + count)
				.mergeStyle(CoreConfig.information_annotation_formatting.get()));
	}

	public static void addInformation(List<ITextComponent> tooltip, String name, int count) {
		tooltip.add(new TranslationTextComponent(name + ".tip" + count)
				.mergeStyle(CoreConfig.information_formatting.get()));
	}

	// effects
	public static boolean showEffectTip() {
		return Screen.hasControlDown() && CoreConfig.effects_tooltip.get();
	}

	public static boolean showEffectTipKey() {
		return CoreConfig.effects_tooltip.get() && CoreConfig.effects_tooltip_key.get();
	}

	public static void addEffectHeader(List<ITextComponent> tooltip, String operation) {
		tooltip.add(new TranslationTextComponent(operation).mergeStyle(CoreConfig.effects_annotation_formatting.get()));
	}

	public static void addPotionEffect(List<ITextComponent> tooltip, String effectName, boolean isDebuff, int amplifier,
			int tickDuration) {
		tooltip.add((new StringTextComponent("- ").mergeStyle(CoreConfig.effects_formatting.get())
				.mergeStyle(TextFormatting.ITALIC)
				.appendSibling(new TranslationTextComponent(effectName).mergeStyle(CoreConfig.effects_formatting.get())
						.mergeStyle(TextFormatting.ITALIC)
						.appendSibling(new StringTextComponent(" " + getEffectColor(isDebuff) + TextFormatting.ITALIC
								+ "(" + amplifier + ") (" + tickDuration / 20 + " sec)"))
						.mergeStyle(TextFormatting.ITALIC))));
	}

	public static void addCustomEffectInformation(List<ITextComponent> tooltip, String name, int index) {
		tooltip.add((new StringTextComponent("- ").mergeStyle(CoreConfig.effects_formatting.get())
				.mergeStyle(TextFormatting.ITALIC).appendSibling(new TranslationTextComponent(name + ".effects" + index)
						.mergeStyle(CoreConfig.effects_formatting.get()).mergeStyle(TextFormatting.ITALIC))));
	}

	public static TextFormatting getEffectColor(boolean isDebuff) {
		if (isDebuff) {
			return CoreConfig.effects_negative_formatting.get();
		}
		return CoreConfig.effects_positive_formatting.get();
	}

	// origin
	public static boolean showOriginTip() {
		return Screen.hasAltDown() && CoreConfig.origin_tooltip.get();
	}

	public static boolean showOriginTipKey() {
		return CoreConfig.origin_tooltip.get() && CoreConfig.origin_tooltip_key.get();
	}
}