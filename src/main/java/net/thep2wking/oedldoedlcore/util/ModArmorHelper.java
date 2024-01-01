package net.thep2wking.oedldoedlcore.util;

import java.util.UUID;

import com.google.common.collect.Multimap;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.Constants.AttributeModifierOperation;

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

	public static Multimap<String, AttributeModifier> addKnockbackResistanceModifier(
			Multimap<String, AttributeModifier> attributeMap, ItemArmor armor, EntityEquipmentSlot slot,
			UUID helmetUUID, UUID chestplateUUID, UUID leggingsUUID, UUID bootsUUID, double ammount) {
		if (slot == armor.getEquipmentSlot()) {
			addHelmetModifier(attributeMap, armor, slot, SharedMonsterAttributes.KNOCKBACK_RESISTANCE,
					ModReferences.ATTRIBUTE_KNOCKBACK_RESISTANCE, ammount, AttributeModifierOperation.ADD, helmetUUID);
			addChestplateModifier(attributeMap, armor, slot, SharedMonsterAttributes.KNOCKBACK_RESISTANCE,
					ModReferences.ATTRIBUTE_KNOCKBACK_RESISTANCE, ammount, AttributeModifierOperation.ADD,
					chestplateUUID);
			addLeggingsModifier(attributeMap, armor, slot, SharedMonsterAttributes.KNOCKBACK_RESISTANCE,
					ModReferences.ATTRIBUTE_KNOCKBACK_RESISTANCE, ammount, AttributeModifierOperation.ADD,
					leggingsUUID);
			addBootsModifier(attributeMap, armor, slot, SharedMonsterAttributes.KNOCKBACK_RESISTANCE,
					ModReferences.ATTRIBUTE_KNOCKBACK_RESISTANCE, ammount, AttributeModifierOperation.ADD, bootsUUID);
			return attributeMap;
		}
		return attributeMap;
	}

	public static Multimap<String, AttributeModifier> addHelmetModifier(
			Multimap<String, AttributeModifier> attributeMap, ItemArmor armor, EntityEquipmentSlot slot,
			IAttribute attribute, String name, double value, int operation, UUID UUID) {
		if (slot == armor.getEquipmentSlot()) {
			if (slot == EntityEquipmentSlot.HEAD) {
				attributeMap.put(attribute.getName(), new AttributeModifier(UUID, name, value, operation));
			}
			return attributeMap;
		}
		return attributeMap;
	}

	public static Multimap<String, AttributeModifier> addChestplateModifier(
			Multimap<String, AttributeModifier> attributeMap, ItemArmor armor, EntityEquipmentSlot slot,
			IAttribute attribute, String name, double value, int operation, UUID UUID) {
		if (slot == armor.getEquipmentSlot()) {
			if (slot == EntityEquipmentSlot.CHEST) {
				attributeMap.put(attribute.getName(), new AttributeModifier(UUID, name, value, operation));
			}
			return attributeMap;
		}
		return attributeMap;
	}

	public static Multimap<String, AttributeModifier> addLeggingsModifier(
			Multimap<String, AttributeModifier> attributeMap, ItemArmor armor, EntityEquipmentSlot slot,
			IAttribute attribute, String name, double value, int operation, UUID UUID) {
		if (slot == armor.getEquipmentSlot()) {
			if (slot == EntityEquipmentSlot.LEGS) {
				attributeMap.put(attribute.getName(), new AttributeModifier(UUID, name, value, operation));
			}
			return attributeMap;
		}
		return attributeMap;
	}

	public static Multimap<String, AttributeModifier> addBootsModifier(
			Multimap<String, AttributeModifier> attributeMap, ItemArmor armor, EntityEquipmentSlot slot,
			IAttribute attribute, String name, double value, int operation, UUID UUID) {
		if (slot == armor.getEquipmentSlot()) {
			if (slot == EntityEquipmentSlot.FEET) {
				attributeMap.put(attribute.getName(), new AttributeModifier(UUID, name, value, operation));
			}
			return attributeMap;
		}
		return attributeMap;
	}
}