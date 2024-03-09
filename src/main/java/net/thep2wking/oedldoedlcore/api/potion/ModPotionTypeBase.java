package net.thep2wking.oedldoedlcore.api.potion;

import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionType;
import net.thep2wking.oedldoedlcore.util.ModPotionTypes;

public class ModPotionTypeBase {
	// add potion type
	public static PotionType addPotionType(Potion potion, int duration, int amplifier, ModPotionTypes type) {
		return new PotionType(potion.getName(),
				new PotionEffect[] { new PotionEffect(potion, duration, amplifier - 1) })
				.setRegistryName(potion.getRegistryName().toString().replace(":", ":" + type.getPotionType()
						+ (type.getPotionType() == ModPotionTypes.NORMAL.getPotionType() ? "" : "_")));
	}
}