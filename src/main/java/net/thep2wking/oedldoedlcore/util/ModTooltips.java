package net.thep2wking.oedldoedlcore.util;

import java.util.List;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
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
	public static final String EFFECT_BAUBLE = "effect." + OedldoedlCore.MODID + ".bauble.tip";
	public static final String EFFECT_HELMET = "effect." + OedldoedlCore.MODID + ".helmet.tip";
	public static final String EFFECT_CHESTPLATE = "effect." + OedldoedlCore.MODID + ".chestplate.tip";
	public static final String EFFECT_LEGGINGS = "effect." + OedldoedlCore.MODID + ".leggings.tip";
	public static final String EFFECT_BOOTS = "effect." + OedldoedlCore.MODID + ".boots.tip";
	public static final String EFFECT_FULL_ARMOR = "effect." + OedldoedlCore.MODID + ".full.tip";

	// key
	public static void addKey(List<String> tooltip, String key) {
		TextComponentTranslation translation = new TextComponentTranslation(key);
		translation.getStyle().setColor(TextFormatting.GRAY);
		tooltip.add(translation.getFormattedText());
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
		TextComponentTranslation translation = new TextComponentTranslation(name + ".annotation" + count);
		translation.getStyle().setColor(CoreConfig.TOOLTIPS.COLORS.INFORMATION_ANNOTATION_FORMATTING.getColor());
		tooltip.add(translation.getFormattedText());
	}

	public static void addInformation(List<String> tooltip, String name, int count) {
		TextComponentTranslation translation = new TextComponentTranslation(name + ".tip" + count);
		translation.getStyle().setColor(CoreConfig.TOOLTIPS.COLORS.INFORMATION_FORMATTING.getColor());
		tooltip.add(translation.getFormattedText());
	}

	// effects
	public static boolean showEffectTip() {
		return GuiScreen.isCtrlKeyDown() && CoreConfig.TOOLTIPS.EFFECTS_TOOLTIPS;
	}

	public static boolean showEffectTipKey() {
		return CoreConfig.TOOLTIPS.EFFECTS_TOOLTIPS && CoreConfig.TOOLTIPS.EFFECTS_TOOLTIPS_KEY;
	}

	public static void addEffectHeader(List<String> tooltip, String operation) {
		TextComponentTranslation translation = new TextComponentTranslation(operation);
		translation.getStyle().setColor(CoreConfig.TOOLTIPS.COLORS.EFFECTS_ANNOTATION_FORMATTING.getColor());
		tooltip.add(translation.getFormattedText());
	}

	public static void addPotionEffect(List<String> tooltip, String effectName, boolean isDebuff, int amplifier,
			int tickDuration) {
		TextComponentTranslation effectTranslation = new TextComponentTranslation(effectName);
		effectTranslation.getStyle().setColor(CoreConfig.TOOLTIPS.COLORS.EFFECTS_FORMATTING.getColor()).setItalic(true);
		TextComponentString amplifierText = new TextComponentString(" " + getEffectColor(isDebuff)
				+ TextFormatting.ITALIC + "(" + amplifier + ") (" + tickDuration / 20 + " sec)");
		amplifierText.getStyle().setItalic(true);
		TextComponentString dashText = new TextComponentString("- ");
		dashText.getStyle().setColor(TextFormatting.WHITE).setItalic(true);
		dashText.appendSibling(effectTranslation).appendSibling(amplifierText);
		tooltip.add(dashText.getFormattedText());
	}

	public static void addCustomEffectInformation(List<String> tooltip, String name, int index) {
		TextComponentTranslation translation = new TextComponentTranslation(name + ".effects" + index);
		translation.getStyle().setColor(CoreConfig.TOOLTIPS.COLORS.EFFECTS_FORMATTING.getColor()).setItalic(true);
		TextComponentString dashText = new TextComponentString("- ");
		dashText.getStyle().setColor(TextFormatting.WHITE).setItalic(true);
		dashText.appendSibling(translation);
		tooltip.add(dashText.getFormattedText());
	}

	public static TextFormatting getEffectColor(boolean isDebuff) {
		if (isDebuff) {
			return CoreConfig.TOOLTIPS.COLORS.EFFECTS_NEGATIVE_FORMATTING.getColor();
		}
		return CoreConfig.TOOLTIPS.COLORS.EFFECTS_POSITIVE_FORMATTING.getColor();
	}
	
	// chat components
	public static TextComponentTranslation addAnnotationPrefixComponenent(String key, int index) {
		return new TextComponentTranslation(key + ".annotation" + index);
	}

	public static TextComponentString addAnnotationPrefixComponenent(String text) {
		return new TextComponentString(text);
	}

	public static TextComponentTranslation addAnnotationComponenent(String key, int index) {
		return new TextComponentTranslation(key + ".annotation" + index);
	}

	public static TextComponentString addAnnotationComponenent(TextFormatting formatting, String text) {
		return new TextComponentString(formatting + text);
	}

	public static void sendTwoPartAnnotationChatComponent(EntityPlayer player, String key, int index,
			TextFormatting formatting, String text) {
		TextComponentTranslation prefixComponent = new TextComponentTranslation(key + ".annotation" + index);
		prefixComponent.getStyle().setColor(CoreConfig.TOOLTIPS.COLORS.INFORMATION_ANNOTATION_FORMATTING.getColor());
		TextComponentString spaceComponent = new TextComponentString(" ");
		TextComponentString annotationComponent = new TextComponentString(text);
		annotationComponent.getStyle().setColor(formatting);
		player.sendMessage(prefixComponent.appendSibling(spaceComponent).appendSibling(annotationComponent));
	}

	public static void sendTwoPartAnnotationChatComponent(EntityPlayer player, String key, int index1, int index2,
			TextFormatting formatting) {
		TextComponentTranslation prefixComponent = new TextComponentTranslation(key + ".annotation" + index1);
		prefixComponent.getStyle().setColor(CoreConfig.TOOLTIPS.COLORS.INFORMATION_ANNOTATION_FORMATTING.getColor());
		TextComponentString spaceComponent = new TextComponentString(" ");
		TextComponentTranslation annotationComponent = new TextComponentTranslation(key + ".annotation" + index2);
		annotationComponent.getStyle().setColor(formatting);
		player.sendMessage(prefixComponent.appendSibling(spaceComponent).appendSibling(annotationComponent));
	}

	public static void sendItemInfoChatComponent(EntityPlayer player, ItemStack stack, int index, TextFormatting formatting) {
		TextComponentTranslation itemStackComponent = new TextComponentTranslation(stack.getUnlocalizedName() + ".name");
		TextComponentString formattedStackComponent = new TextComponentString("[" + itemStackComponent.getUnformattedText() + "]");
		formattedStackComponent.getStyle().setColor(CoreConfig.TOOLTIPS.COLORS.INFORMATION_ANNOTATION_FORMATTING.getColor());
		TextComponentString spaceComponent = new TextComponentString(" ");
		TextComponentTranslation informationComponent = new TextComponentTranslation(stack.getUnlocalizedName() + ".annotation" + index);
		informationComponent.getStyle().setColor(formatting);
		player.sendMessage(formattedStackComponent.appendSibling(spaceComponent).appendSibling(informationComponent));
	}
	
	public static void sendItemInfoChatComponent(EntityPlayer player, ItemStack stack, String text, TextFormatting formatting) {
		TextComponentTranslation itemStackComponent = new TextComponentTranslation(stack.getUnlocalizedName() + ".name");
		TextComponentString formattedStackComponent = new TextComponentString("[" + itemStackComponent.getUnformattedText() + "] ");
		formattedStackComponent.getStyle().setColor(CoreConfig.TOOLTIPS.COLORS.INFORMATION_ANNOTATION_FORMATTING.getColor());
		TextComponentString informationComponent = new TextComponentString(text);
		informationComponent.getStyle().setColor(formatting);
		player.sendMessage(formattedStackComponent.appendSibling(informationComponent));
	}

	public static void sendSimpleChatComponent(EntityPlayer player, String text, TextFormatting formatting) {
		TextComponentString simpleComponent = new TextComponentString(text);
		simpleComponent.getStyle().setColor(formatting);
		player.sendMessage(simpleComponent);
	}
}