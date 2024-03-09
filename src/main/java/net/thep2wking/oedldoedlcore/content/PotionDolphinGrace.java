package net.thep2wking.oedldoedlcore.content;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.player.EntityPlayer;
import net.thep2wking.oedldoedlcore.api.potion.ModPotionBase;
import net.thep2wking.oedldoedlcore.config.CoreConfig;

public class PotionDolphinGrace extends ModPotionBase {
	public PotionDolphinGrace(String modid, String name, boolean isBad, int color, int posX, int posY) {
		super(modid, name, isBad, color, posX, posY);
	}

	@Override
	public void performEffect(EntityLivingBase entityLivingBaseIn, int amplifier) {
		double motionMultiplier = 1 + Math.pow(amplifier, 0.25) * CoreConfig.CONTENT.DOLPHIN_GRACE_MOTION_MULTIPLIER_PER_LEVEL;
		if (entityLivingBaseIn.isInWater() && entityLivingBaseIn instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entityLivingBaseIn;
			if (!(player.capabilities.isFlying)) {
				if (player.isSneaking() && player.motionY <= -0.01) {
					player.move(MoverType.PLAYER, player.motionX, player.motionY, player.motionZ);
					player.motionX *= motionMultiplier;
					player.motionY *= motionMultiplier;
					player.motionZ *= motionMultiplier;
				} else if (player.motionY >= 0.01) {
					player.move(MoverType.PLAYER, player.motionX, player.motionY, player.motionZ);
					player.motionX *= motionMultiplier;
					player.motionY *= motionMultiplier;
					player.motionZ *= motionMultiplier;
				} else {
					player.move(MoverType.PLAYER, player.motionX, player.motionY, player.motionZ);
					player.motionX *= motionMultiplier;
					player.motionY *= motionMultiplier / 2;
					player.motionZ *= motionMultiplier;
				}
			}
		} else if (entityLivingBaseIn.isInWater() && !(entityLivingBaseIn instanceof EntityPlayer)) {
			if (entityLivingBaseIn.isSneaking() && entityLivingBaseIn.motionY <= -0.01) {
				entityLivingBaseIn.move(MoverType.SELF, entityLivingBaseIn.motionX, entityLivingBaseIn.motionY,
						entityLivingBaseIn.motionZ);
				entityLivingBaseIn.motionX *= motionMultiplier;
				entityLivingBaseIn.motionY *= motionMultiplier;
				entityLivingBaseIn.motionZ *= motionMultiplier;
			} else if (entityLivingBaseIn.motionY >= 0.01) {
				entityLivingBaseIn.move(MoverType.SELF, entityLivingBaseIn.motionX, entityLivingBaseIn.motionY,
						entityLivingBaseIn.motionZ);
				entityLivingBaseIn.motionX *= motionMultiplier;
				entityLivingBaseIn.motionY *= motionMultiplier;
				entityLivingBaseIn.motionZ *= motionMultiplier;
			} else {
				entityLivingBaseIn.move(MoverType.SELF, entityLivingBaseIn.motionX, entityLivingBaseIn.motionY,
						entityLivingBaseIn.motionZ);
				entityLivingBaseIn.motionX *= motionMultiplier;
				entityLivingBaseIn.motionY *= motionMultiplier;
				entityLivingBaseIn.motionZ *= motionMultiplier;
			}
		}
	}
}