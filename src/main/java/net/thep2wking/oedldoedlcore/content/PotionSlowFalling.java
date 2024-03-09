package net.thep2wking.oedldoedlcore.content;

import net.minecraft.entity.EntityLivingBase;
import net.thep2wking.oedldoedlcore.api.potion.ModPotionBase;
import net.thep2wking.oedldoedlcore.config.CoreConfig;

public class PotionSlowFalling extends ModPotionBase {
	public PotionSlowFalling(String modid, String name, boolean isBad, int color, int posX, int posY) {
		super(modid, name, isBad, color, posX, posY);
	}

	@Override
	public void performEffect(EntityLivingBase entityLivingBaseIn, int amplifier) {
		entityLivingBaseIn.fallDistance = 0.0F;
		if (entityLivingBaseIn.motionY < 0) {
			entityLivingBaseIn.motionY *= CoreConfig.CONTENT.SLOW_FALLING_MOTION_MULTIPLIER;
		}
	}
}