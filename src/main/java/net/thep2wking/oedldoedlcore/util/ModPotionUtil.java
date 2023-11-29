package net.thep2wking.oedldoedlcore.util;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

/**
 * @author TheP2WKing
 */
public class ModPotionUtil {
	// add potion effect
	public static void addEffect(EntityLivingBase entity, Potion effect, int duration, int amplifier) {
		entity.addPotionEffect(new PotionEffect(effect, duration, amplifier, false, false));
	}

	public static void addEffect(EntityLivingBase entity, Potion effect, int duration, int amplifier, boolean ambient,
			boolean particles) {
		entity.addPotionEffect(new PotionEffect(effect, duration, amplifier, ambient, particles));
	}

	// remove potion effect
	public static void removeEffect(EntityLivingBase entity, Potion effect) {
		entity.removePotionEffect(effect);
	}
}