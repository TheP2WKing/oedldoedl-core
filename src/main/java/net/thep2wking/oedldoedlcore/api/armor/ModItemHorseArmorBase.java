package net.thep2wking.oedldoedlcore.api.armor;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.HorseArmorType;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.thep2wking.oedldoedlcore.api.item.ModItemBase;

/**
 * @author TheP2WKing
 */
public class ModItemHorseArmorBase extends ModItemBase {
	public final HorseArmorType material;

	/**
	 * @author TheP2WKing
	 * @param modid           String
	 * @param name            String
	 * @param tab             {@link CreativeTabs}
	 * @param material        {@link HorseArmorType }
	 * @param rarity          {@link EnumRarity}
	 * @param hasEffect       boolean
	 * @param tooltipLines    int
	 * @param annotationLines int
	 */
	public ModItemHorseArmorBase(String modid, String name, CreativeTabs tab, HorseArmorType material,
			EnumRarity rarity, boolean hasEffect, int tooltipLines, int annotationLines) {
		super(modid, name, tab, rarity, hasEffect, tooltipLines, annotationLines);
		this.material = material;
		setMaxStackSize(1);
	}

	@Override
	public HorseArmorType getHorseArmorType(ItemStack stack) {
		return material;
	}

	@Override
	public String getHorseArmorTexture(EntityLiving wearer, ItemStack stack) {
		return material.getTextureName();
	}
}