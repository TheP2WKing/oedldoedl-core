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
	 * @param textureName   int
	 */
	public static HorseArmorType addHorseArmorMaterial(String modid, String name, String textureName, int armor) {
		return EnumHelper.addHorseArmor(modid + ":horsearmor_" + name,
				modid + ":" + "textures/models/horsearmor/" + textureName + ".png", armor);
	}
}