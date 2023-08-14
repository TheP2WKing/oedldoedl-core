package net.thep2wking.oedldoedlcore.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * @author TheP2WKing
 */
public class ModArmorHelper {
	public static boolean hasFullArmorSet(EntityPlayer player, Item helmet, Item chestplate, Item leggings,
			Item boots) {
		ItemStack head = player.getItemStackFromSlot(EntityEquipmentSlot.HEAD);
		ItemStack legs = player.getItemStackFromSlot(EntityEquipmentSlot.LEGS);
		ItemStack chest = player.getItemStackFromSlot(EntityEquipmentSlot.CHEST);
		ItemStack feet = player.getItemStackFromSlot(EntityEquipmentSlot.FEET);

		return (!head.isEmpty()) && (head.getItem() == helmet) && (!chest.isEmpty()) && (chest.getItem() == chestplate)
				&& (!legs.isEmpty()) && (legs.getItem() == leggings) && (!feet.isEmpty()) && (feet.getItem() == boots);
	}

	public static boolean hasHelmet(EntityPlayer player, Item helmet) {
		ItemStack slot = player.getItemStackFromSlot(EntityEquipmentSlot.HEAD);

		return (!slot.isEmpty()) && (slot.getItem() == helmet);
	}

	public static boolean hasChestplate(EntityPlayer player, Item chestplate) {
		ItemStack slot = player.getItemStackFromSlot(EntityEquipmentSlot.CHEST);

		return (!slot.isEmpty()) && (slot.getItem() == chestplate);
	}

	public static boolean hasLeggings(EntityPlayer player, Item leggings) {
		ItemStack slot = player.getItemStackFromSlot(EntityEquipmentSlot.LEGS);

		return (!slot.isEmpty()) && (slot.getItem() == leggings);
	}

	public static boolean hasBoots(EntityPlayer player, Item boots) {
		ItemStack slot = player.getItemStackFromSlot(EntityEquipmentSlot.FEET);

		return (!slot.isEmpty()) && (slot.getItem() == boots);
	}
}