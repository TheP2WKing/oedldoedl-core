package net.thep2wking.oedldoedlcore.util;

import mcjty.theoneprobe.api.IProbeHitData;
import mcjty.theoneprobe.api.IProbeInfo;
import mcjty.theoneprobe.api.ProbeMode;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlcore.config.CoreConfig;

public class ModTopTooltips {
	// keys
	public static final String TOP_INFO = "{*top.oedldoedlcore.info*}";
	public static final String TOP_EFFECTS = "{*top.oedldoedlcore.effect*}";

	// effects
	public static void addEffectHeader(ProbeMode mode, IProbeInfo probeInfo, EntityPlayer player, World world,
			IBlockState blockState, IProbeHitData data, String operation) {
		probeInfo.horizontal(probeInfo.defaultLayoutStyle())
				.text(CoreConfig.TOOLTIPS.COLORS.EFFECTS_ANNOTATION_FORMATTING + "{*" + operation + "*}");
	}

	public static void addPotionEffect(ProbeMode mode, IProbeInfo probeInfo, EntityPlayer player, World world,
			IBlockState blockState, IProbeHitData data, String effectName, boolean isDebuff, int amplifier,
			int tickDuration) {
		probeInfo.horizontal(probeInfo.defaultLayoutStyle())
				.text("- " + CoreConfig.TOOLTIPS.COLORS.EFFECTS_FORMATTING.getColor() + TextFormatting.ITALIC
						+ I18n.format(effectName) + CoreConfig.TOOLTIPS.COLORS.EFFECTS_FORMATTING.getColor()
						+ TextFormatting.ITALIC
						+ " " + getEffectColor(isDebuff) + TextFormatting.ITALIC + "(" + amplifier + ") ("
						+ tickDuration / 20
						+ " sec)" + TextFormatting.ITALIC);
	}

	public static TextFormatting getEffectColor(boolean isDebuff) {
		if (isDebuff) {
			return CoreConfig.TOOLTIPS.COLORS.EFFECTS_NEGATIVE_FORMATTING.getColor();
		}
		return CoreConfig.TOOLTIPS.COLORS.EFFECTS_POSITIVE_FORMATTING.getColor();
	}
}