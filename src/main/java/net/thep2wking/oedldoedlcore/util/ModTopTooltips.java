package net.thep2wking.oedldoedlcore.util;

import mcjty.theoneprobe.api.IProbeHitData;
import mcjty.theoneprobe.api.IProbeInfo;
import mcjty.theoneprobe.api.ProbeMode;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlcore.config.CoreConfig;

/**
 * @author TheP2WKing
 */
public class ModTopTooltips {
	// keys
	public static final String TOP_INFO = "{*top.oedldoedlcore.info*}";
	public static final String TOP_EFFECTS = "{*top.oedldoedlcore.effect*}";

	// key
	public static void addKey(ProbeMode mode, IProbeInfo probeInfo, EntityPlayer player, World world,
			IBlockState blockState, IProbeHitData data, String key) {
		probeInfo.horizontal(probeInfo.defaultLayoutStyle()).text(TextFormatting.GRAY + "{*" + key + "*}");
	}

	// effects
	public static void addEffectHeader(ProbeMode mode, IProbeInfo probeInfo, EntityPlayer player, World world,
			IBlockState blockState, IProbeHitData data, String operation) {
		probeInfo.horizontal(probeInfo.defaultLayoutStyle())
				.text(CoreConfig.TOOLTIPS.COLORS.EFFECTS_ANNOTATION_FORMATTING.getColor() + "{*" + operation + "*}");
	}

	public static void addPotionEffect(ProbeMode mode, IProbeInfo probeInfo, EntityPlayer player, World world,
			IBlockState blockState, IProbeHitData data, String effectName, boolean isDebuff, int amplifier,
			int tickDuration) {
		TextComponentTranslation translatedEffect = new TextComponentTranslation(effectName);
		translatedEffect.getStyle().setColor(CoreConfig.TOOLTIPS.COLORS.EFFECTS_FORMATTING.getColor()).setItalic(true);
		TextComponentString amplifierText = new TextComponentString(" " + getEffectColor(isDebuff)
				+ TextFormatting.ITALIC + "(" + amplifier + ") (" + tickDuration / 20 + " sec)");
		amplifierText.getStyle().setItalic(true);
		TextComponentString dashText = new TextComponentString("- ");
		dashText.getStyle().setColor(TextFormatting.WHITE).setItalic(true);
		dashText.appendSibling(translatedEffect).appendSibling(amplifierText);
		probeInfo.horizontal(probeInfo.defaultLayoutStyle()).text(dashText.getFormattedText());
	}

	public static TextFormatting getEffectColor(boolean isDebuff) {
		if (isDebuff) {
			return CoreConfig.TOOLTIPS.COLORS.EFFECTS_NEGATIVE_FORMATTING.getColor();
		}
		return CoreConfig.TOOLTIPS.COLORS.EFFECTS_POSITIVE_FORMATTING.getColor();
	}
}