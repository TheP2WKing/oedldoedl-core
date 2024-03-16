package net.thep2wking.oedldoedlcore.content.potion;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.AbstractAttributeMap;
import net.minecraft.entity.player.EntityPlayer;
import net.thep2wking.oedldoedlcore.api.potion.ModPotionBase;

public class PotionFlight extends ModPotionBase {
	public PotionFlight(String modid, String name, boolean isBad, int color, int posX, int posY) {
		super(modid, name, isBad, color, posX, posY);
	}

	@Override
	public void performEffect(EntityLivingBase entityLivingBaseIn, int amplifier) {
		if (entityLivingBaseIn instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entityLivingBaseIn;
			player.capabilities.allowFlying = true;
		}
	}

	@Override
	public void removeAttributesModifiersFromEntity(EntityLivingBase entityLivingBaseIn,
			AbstractAttributeMap attributeMapIn, int amplifier) {
		if (entityLivingBaseIn instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entityLivingBaseIn;
			if (!player.capabilities.isCreativeMode && !player.isSpectator()) {
				player.capabilities.allowFlying = false;
				player.capabilities.isFlying = false;
				player.sendPlayerAbilities();
			}
		}
	}
}