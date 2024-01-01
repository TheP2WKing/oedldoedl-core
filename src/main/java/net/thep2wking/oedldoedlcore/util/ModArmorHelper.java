package net.thep2wking.oedldoedlcore.util;

import java.util.UUID;

import com.google.common.collect.LinkedHashMultimap;
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

	public static Multimap<String, AttributeModifier> addKnockbackResistanceModifier(ItemArmor armor, EntityEquipmentSlot slot, UUID helmetUUID, UUID chestplateUUID, UUID leggingsUUID, UUID bootsUUID, double ammount) {
		Multimap<String, AttributeModifier> attributes = LinkedHashMultimap.create();
		if (slot == armor.getEquipmentSlot()) {
			attributes.putAll(armor.getAttributeModifiers(armor.getEquipmentSlot(), new ItemStack(armor)));
			if (slot == EntityEquipmentSlot.HEAD) {
				attributes.put(SharedMonsterAttributes.KNOCKBACK_RESISTANCE.getName(), new AttributeModifier(helmetUUID, ModReferences.ATTRIBUTE_KNOCKBACK_RESISTANCE, ammount, AttributeModifierOperation.ADD));
			}
			if (slot == EntityEquipmentSlot.CHEST) {
				attributes.put(SharedMonsterAttributes.KNOCKBACK_RESISTANCE.getName(), new AttributeModifier(chestplateUUID, ModReferences.ATTRIBUTE_KNOCKBACK_RESISTANCE, ammount, AttributeModifierOperation.ADD));
			}
			if (slot == EntityEquipmentSlot.LEGS) {
				attributes.put(SharedMonsterAttributes.KNOCKBACK_RESISTANCE.getName(), new AttributeModifier(leggingsUUID, ModReferences.ATTRIBUTE_KNOCKBACK_RESISTANCE, ammount, AttributeModifierOperation.ADD));
			}
			if (slot == EntityEquipmentSlot.FEET) {
				attributes.put(SharedMonsterAttributes.KNOCKBACK_RESISTANCE.getName(), new AttributeModifier(bootsUUID, ModReferences.ATTRIBUTE_KNOCKBACK_RESISTANCE, ammount, AttributeModifierOperation.ADD));
			}
			return attributes;
		}
		return attributes;
	}

	public static Multimap<String, AttributeModifier> putDefaultModifier(ItemArmor armor, EntityEquipmentSlot slot, UUID helmetUUID, UUID chestplateUUID, UUID leggingsUUID, UUID bootsUUID, double ammount) {
		Multimap<String, AttributeModifier> attributes = LinkedHashMultimap.create();
		if (slot == armor.getEquipmentSlot()) {
			attributes.putAll(armor.getAttributeModifiers(armor.getEquipmentSlot(), new ItemStack(armor)));
			return attributes;
		}
		return attributes;
	}

	public static Multimap<String, AttributeModifier> addSlotModifier(ItemArmor armor, EntityEquipmentSlot slot, IAttribute attribute, String name, double value, int operation, UUID UUID) {
		Multimap<String, AttributeModifier> attributes = LinkedHashMultimap.create();
		if (slot == armor.getEquipmentSlot()) {
			if (slot == EntityEquipmentSlot.HEAD) {
				attributes.put(attribute.getName(), new AttributeModifier(UUID, name, value, operation));
			}
			return attributes;
		}
		return attributes;
	}
}