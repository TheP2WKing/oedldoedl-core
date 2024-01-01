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

	// invert potion effect
	public static void invertEffect(EntityLivingBase entity, Potion effectIn, Potion effectOut, int duration,
			int amplifier) {
		if (entity.isPotionActive(effectIn)) {
			entity.removePotionEffect(effectIn);
			entity.addPotionEffect(new PotionEffect(effectOut, duration, amplifier, false, false));
		}
	}

	public static void invertEffect(EntityLivingBase entity, Potion effectIn, Potion effectOut, int duration,
			int amplifier, boolean ambient, boolean particles) {
		if (entity.isPotionActive(effectIn)) {
			entity.removePotionEffect(effectIn);
			entity.addPotionEffect(new PotionEffect(effectOut, duration, amplifier, ambient, particles));
		}
	}
}