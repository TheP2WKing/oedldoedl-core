package net.thep2wking.oedldoedlcore.util;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

/**
 * @author TheP2WKing
 */
public class ModNBTUtil {
	// generic nbt item
	public static ItemStack addNBTItem(Item item, String key, String value) {
		ItemStack itemStack = new ItemStack(item);
		NBTTagCompound nbttagcompound = itemStack.hasTagCompound() ? itemStack.getTagCompound() : new NBTTagCompound();
		nbttagcompound.setString(key, value);
		itemStack.setTagCompound(nbttagcompound);
		return itemStack;
	}

	public static ItemStack addNBTItem(Item item, String key, int value) {
		ItemStack itemStack = new ItemStack(item);
		NBTTagCompound nbttagcompound = itemStack.hasTagCompound() ? itemStack.getTagCompound() : new NBTTagCompound();
		nbttagcompound.setInteger(key, value);
		itemStack.setTagCompound(nbttagcompound);
		return itemStack;
	}

	// spawn egg
	public static ItemStack addSpawnEgg(String entityId) {
		ItemStack spawnEgg = new ItemStack(Items.SPAWN_EGG);
		NBTTagCompound entitytag = spawnEgg.hasTagCompound() ? spawnEgg.getTagCompound() : new NBTTagCompound();
		NBTTagCompound nbttagcompound = new NBTTagCompound();
		nbttagcompound.setString("id", entityId.toString());
		entitytag.setTag("EntityTag", nbttagcompound);
		spawnEgg.setTagCompound(entitytag);
		return spawnEgg;
	}

	public static ItemStack addSpawnEgg(String entityId, String key, String value) {
		ItemStack spawnEgg = new ItemStack(Items.SPAWN_EGG);
		NBTTagCompound entitytag = spawnEgg.hasTagCompound() ? spawnEgg.getTagCompound() : new NBTTagCompound();
		NBTTagCompound nbttagcompound = new NBTTagCompound();
		nbttagcompound.setString("id", entityId.toString());
		entitytag.setTag("EntityTag", nbttagcompound);
		nbttagcompound.setString(key, value);
		spawnEgg.setTagCompound(entitytag);
		return spawnEgg;
	}

	public static ItemStack addSpawnEgg(String entityId, String key, boolean value) {
		ItemStack spawnEgg = new ItemStack(Items.SPAWN_EGG);
		NBTTagCompound entitytag = spawnEgg.hasTagCompound() ? spawnEgg.getTagCompound() : new NBTTagCompound();
		NBTTagCompound nbttagcompound = new NBTTagCompound();
		nbttagcompound.setString("id", entityId.toString());
		entitytag.setTag("EntityTag", nbttagcompound);
		nbttagcompound.setBoolean(key, value);
		spawnEgg.setTagCompound(entitytag);
		return spawnEgg;
	}

	public static ItemStack addSpawnEgg(String entityId, String key, int value) {
		ItemStack spawnEgg = new ItemStack(Items.SPAWN_EGG);
		NBTTagCompound entitytag = spawnEgg.hasTagCompound() ? spawnEgg.getTagCompound() : new NBTTagCompound();
		NBTTagCompound nbttagcompound = new NBTTagCompound();
		nbttagcompound.setString("id", entityId.toString());
		entitytag.setTag("EntityTag", nbttagcompound);
		nbttagcompound.setInteger(key, value);
		spawnEgg.setTagCompound(entitytag);
		return spawnEgg;
	}

	public static ItemStack addSpawnEgg(String entityId, String key, float value) {
		ItemStack spawnEgg = new ItemStack(Items.SPAWN_EGG);
		NBTTagCompound entitytag = spawnEgg.hasTagCompound() ? spawnEgg.getTagCompound() : new NBTTagCompound();
		NBTTagCompound nbttagcompound = new NBTTagCompound();
		nbttagcompound.setString("id", entityId.toString());
		entitytag.setTag("EntityTag", nbttagcompound);
		nbttagcompound.setFloat(key, value);
		spawnEgg.setTagCompound(entitytag);
		return spawnEgg;
	}

	public static ItemStack addSpawnEgg(String entityId, String key, double value) {
		ItemStack spawnEgg = new ItemStack(Items.SPAWN_EGG);
		NBTTagCompound entitytag = spawnEgg.hasTagCompound() ? spawnEgg.getTagCompound() : new NBTTagCompound();
		NBTTagCompound nbttagcompound = new NBTTagCompound();
		nbttagcompound.setString("id", entityId.toString());
		entitytag.setTag("EntityTag", nbttagcompound);
		nbttagcompound.setDouble(key, value);
		spawnEgg.setTagCompound(entitytag);
		return spawnEgg;
	}

	// potions
	public static ItemStack addPotion(String potionId) {
		ItemStack potion = new ItemStack(Items.POTIONITEM);
		NBTTagCompound nbttagcompound = potion.hasTagCompound() ? potion.getTagCompound() : new NBTTagCompound();
		nbttagcompound.setString("Potion", potionId.toString());
		potion.setTagCompound(nbttagcompound);
		return potion;
	}

	public static ItemStack addSplashPotion(String potionId) {
		ItemStack potion = new ItemStack(Items.SPLASH_POTION);
		NBTTagCompound nbttagcompound = potion.hasTagCompound() ? potion.getTagCompound() : new NBTTagCompound();
		nbttagcompound.setString("Potion", potionId.toString());
		potion.setTagCompound(nbttagcompound);
		return potion;
	}

	public static ItemStack addLingeringPotion(String potionId) {
		ItemStack potion = new ItemStack(Items.LINGERING_POTION);
		NBTTagCompound nbttagcompound = potion.hasTagCompound() ? potion.getTagCompound() : new NBTTagCompound();
		nbttagcompound.setString("Potion", potionId.toString());
		potion.setTagCompound(nbttagcompound);
		return potion;
	}

	// tipped arrows
	public static ItemStack addTippedArrow(String potionId) {
		ItemStack arrow = new ItemStack(Items.TIPPED_ARROW);
		NBTTagCompound nbttagcompound = arrow.hasTagCompound() ? arrow.getTagCompound() : new NBTTagCompound();
		nbttagcompound.setString("Potion", potionId.toString());
		arrow.setTagCompound(nbttagcompound);
		return arrow;
	}
}