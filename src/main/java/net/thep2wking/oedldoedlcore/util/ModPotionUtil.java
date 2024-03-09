package net.thep2wking.oedldoedlcore.util;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionType;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thep2wking.oedldoedlcore.config.CoreConfig;

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

	// potions in creative tab
	@SideOnly(Side.CLIENT)
	public static void displayPotions(NonNullList<ItemStack> itemList, String modid) {
		if (CoreConfig.PROPERTIES.CREATIVE.ADD_POTIONS_TO_CREATIVE_TABS) {
			for (PotionType potion : PotionType.REGISTRY) {
				ResourceLocation potionRL = potion.getRegistryName();
				if (potionRL != null && potionRL.getResourceDomain().equals(modid)) {
					ItemStack potionItem = new ItemStack(Items.POTIONITEM, 1, 0);
					itemList.add(PotionUtils.addPotionToItemStack(potionItem, potion));
				}
			}
			for (PotionType potion : PotionType.REGISTRY) {
				ResourceLocation potionRL = potion.getRegistryName();
				if (potionRL != null && potionRL.getResourceDomain().equals(modid)) {
					ItemStack potionItem = new ItemStack(Items.SPLASH_POTION, 1, 0);
					itemList.add(PotionUtils.addPotionToItemStack(potionItem, potion));
				}
			}
			for (PotionType potion : PotionType.REGISTRY) {
				ResourceLocation potionRL = potion.getRegistryName();
				if (potionRL != null && potionRL.getResourceDomain().equals(modid)) {
					ItemStack potionItem = new ItemStack(Items.LINGERING_POTION, 1, 0);
					itemList.add(PotionUtils.addPotionToItemStack(potionItem, potion));
				}
			}
			for (PotionType potion : PotionType.REGISTRY) {
				ResourceLocation potionRL = potion.getRegistryName();
				if (potionRL != null && potionRL.getResourceDomain().equals(modid)) {
					ItemStack potionItem = new ItemStack(Items.TIPPED_ARROW, 1, 0);
					itemList.add(PotionUtils.addPotionToItemStack(potionItem, potion));
				}
			}
		}
	}
}