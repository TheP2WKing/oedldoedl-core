package net.thep2wking.oedldoedlcore.api.armor;

import net.minecraft.entity.passive.HorseArmorType;
import net.minecraftforge.common.util.EnumHelper;

/**
 * @author TheP2WKing
 */
public class ModHorseArmorMaterialBase {
	/**
	 * @author TheP2WKing
	 * @param modid   String
	 * @param name    String
	 * @param texture String
	 * @param armor   int
	 */
	public static HorseArmorType addHorseArmorMaterial(String modid, String name, String texture, int armor) {
		return EnumHelper.addHorseArmor(modid + ":horsearmor_" + name,
				modid + ":" + "textures/models/horsearmor/" + texture + ".png", armor);
	}
}