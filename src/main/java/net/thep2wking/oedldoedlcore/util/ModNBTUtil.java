package net.thep2wking.oedldoedlcore.util;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class ModNBTUtil {
	@SuppressWarnings("null")
	public static ItemStack addNBTItem(Item item, String key, String value) {
		ItemStack itemStack = new ItemStack(item);
		NBTTagCompound nbttagcompound = itemStack.hasTagCompound() ? itemStack.getTagCompound() : new NBTTagCompound();
		nbttagcompound.setString(key, value);
		itemStack.setTagCompound(nbttagcompound);
		return itemStack;
	}

	@SuppressWarnings("null")
	public static ItemStack addNBTItem(Item item, String key, int value) {
		ItemStack itemStack = new ItemStack(item);
		NBTTagCompound nbttagcompound = itemStack.hasTagCompound() ? itemStack.getTagCompound() : new NBTTagCompound();
		nbttagcompound.setInteger(key, value);
		itemStack.setTagCompound(nbttagcompound);
		return itemStack;
	}

	@SuppressWarnings("null")
	public static ItemStack addSpawnEgg(String entityId) {
		ItemStack spawnEgg = new ItemStack(Items.SPAWN_EGG);
		NBTTagCompound nbttagcompound = spawnEgg.hasTagCompound() ? spawnEgg.getTagCompound() : new NBTTagCompound();
		NBTTagCompound nbttagcompound1 = new NBTTagCompound();
		nbttagcompound1.setString("id", entityId.toString());
		nbttagcompound.setTag("EntityTag", nbttagcompound1);
		spawnEgg.setTagCompound(nbttagcompound);
		return spawnEgg;
	}

	@SuppressWarnings("null")
	public static ItemStack addPotion(String potionId) {
		ItemStack potion = new ItemStack(Items.POTIONITEM);
		NBTTagCompound nbttagcompound = potion.hasTagCompound() ? potion.getTagCompound() : new NBTTagCompound();
		nbttagcompound.setString("Potion", potionId.toString());
		potion.setTagCompound(nbttagcompound);
		return potion;
	}

	@SuppressWarnings("null")
	public static ItemStack addSplashPotion(String potionId) {
		ItemStack potion = new ItemStack(Items.SPLASH_POTION);
		NBTTagCompound nbttagcompound = potion.hasTagCompound() ? potion.getTagCompound() : new NBTTagCompound();
		nbttagcompound.setString("Potion", potionId.toString());
		potion.setTagCompound(nbttagcompound);
		return potion;
	}

	@SuppressWarnings("null")
	public static ItemStack addLingeringPotion(String potionId) {
		ItemStack potion = new ItemStack(Items.LINGERING_POTION);
		NBTTagCompound nbttagcompound = potion.hasTagCompound() ? potion.getTagCompound() : new NBTTagCompound();
		nbttagcompound.setString("Potion", potionId.toString());
		potion.setTagCompound(nbttagcompound);
		return potion;
	}

	@SuppressWarnings("null")
	public static ItemStack addTippedArrow(String potionId) {
		ItemStack arrow = new ItemStack(Items.TIPPED_ARROW);
		NBTTagCompound nbttagcompound = arrow.hasTagCompound() ? arrow.getTagCompound() : new NBTTagCompound();
		nbttagcompound.setString("Potion", potionId.toString());
		arrow.setTagCompound(nbttagcompound);
		return arrow;
	}
}