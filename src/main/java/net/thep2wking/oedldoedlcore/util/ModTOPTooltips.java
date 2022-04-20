package net.thep2wking.oedldoedlcore.util;

import mcjty.theoneprobe.api.CompoundText;
import mcjty.theoneprobe.api.IProbeHitData;
import mcjty.theoneprobe.api.IProbeInfo;
import mcjty.theoneprobe.api.ProbeMode;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlcore.config.CoreConfig;

/**
 * @author TheP2WKing
 */
public class ModTOPTooltips {
	// top tooltips
	public static final String TOP_INFO = "{*core.oedldoedl.top.info.tip*}";
	public static final String TOP_EFFECTS = "{*core.oedldoedl.top.effects.tip*}";

	// effects
	public static void addEffectHeader(ProbeMode mode, IProbeInfo probeInfo, PlayerEntity player, World world,
			BlockState blockState, IProbeHitData data, String operation) {
		probeInfo.text(CompoundText.create()
				.label(CoreConfig.effects_annotation_formatting.get() + "{*" + operation + "*}"));
	}

	public static void addPotionEffect(ProbeMode mode, IProbeInfo probeInfo, PlayerEntity player, World world,
			BlockState blockState, IProbeHitData data, String effectName, boolean isDebuff, int amplifier,
			int tickDuration) {
		probeInfo.text(CompoundText.create().label((new StringTextComponent(
				CoreConfig.effects_formatting.get() + "- " + TextFormatting.ITALIC)
				.appendSibling(new TranslationTextComponent(effectName).mergeStyle(CoreConfig.effects_formatting.get())
						.mergeStyle(TextFormatting.ITALIC)
						.appendSibling(new StringTextComponent(" " + getEffectColor(isDebuff) + TextFormatting.ITALIC
								+ "(" + amplifier + ") (" + tickDuration / 20 + " sec)"))
						.mergeStyle(TextFormatting.ITALIC)))));
	}

	public static TextFormatting getEffectColor(boolean isDebuff) {
		if (isDebuff) {
			return CoreConfig.effects_negative_formatting.get();
		}
		return CoreConfig.effects_positive_formatting.get();
	}
}