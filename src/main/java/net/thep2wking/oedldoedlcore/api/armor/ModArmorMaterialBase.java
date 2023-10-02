package net.thep2wking.oedldoedlcore.api.armor;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.util.EnumHelper;

/**
 * @author TheP2WKing
 */
public class ModArmorMaterialBase {
	/**
	 * @author TheP2WKing
	 * @param modid          String
	 * @param name           String
	 * @param durability     int
	 * @param armor          int[]
	 * @param toughness      float
	 * @param enchantability int
	 * @param equipSound     {@link SoundEvent}
	 * @param repairItem     {@link Item}
	 * @param meta           int
	 */
	@SuppressWarnings("null")
	public static ArmorMaterial addArmorMaterial(String modid, String name, int durability, int[] armor,
			float toughness, int enchantability, SoundEvent equipSound, Item repairItem, int meta) {
		return EnumHelper.addArmorMaterial(modid + ":armor_material_" + name, modid + ":" + name, durability, armor,
				enchantability, equipSound, toughness).setRepairItem(new ItemStack(repairItem, 1, meta));
	}

	/**
	 * @author TheP2WKing
	 * @param modid          String
	 * @param name           String
	 * @param durability     int
	 * @param armor          int[]
	 * @param toughness      float
	 * @param enchantability int
	 * @param equipSound     {@link SoundEvent}
	 * @param repairBlock    {@link Block}
	 * @param meta           int
	 */
	@SuppressWarnings("null")
	public static ArmorMaterial addArmorMaterial(String modid, String name, int durability, int[] armor,
			float toughness, int enchantability, SoundEvent equipSound, Block repairBlock, int meta) {
		return EnumHelper.addArmorMaterial(modid + ":armor_material_" + name, modid + ":" + name, durability, armor,
				enchantability, equipSound, toughness).setRepairItem(new ItemStack(repairBlock, 1, meta));
	}

	/**
	 * @author TheP2WKing
	 * @param modid          String
	 * @param name           String
	 * @param durability     int
	 * @param armor          int[]
	 * @param toughness      float
	 * @param enchantability int
	 * @param equipSound     {@link SoundEvent}
	 * @param repairStack    {@link ItemStack}
	 * @param meta           int
	 */
	@SuppressWarnings("null")
	public static ArmorMaterial addArmorMaterial(String modid, String name, int durability, int[] armor,
			float toughness, int enchantability, SoundEvent equipSound, ItemStack repairStack) {
		return EnumHelper.addArmorMaterial(modid + ":armor_material_" + name, modid + ":" + name, durability, armor,
				enchantability, equipSound, toughness).setRepairItem(repairStack);
	}
}