package net.thep2wking.oedldoedlcore.content;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.thep2wking.oedldoedlcore.api.ModItemBase;

public class DebugWrenchItem extends ModItemBase {
	public DebugWrenchItem(String modid, String name, CreativeTabs tab, EnumRarity rarity, boolean hasEffect,
			int tooltipLines, int annotationLines) {
		super(modid, name, tab, rarity, hasEffect, tooltipLines, annotationLines);
		this.setMaxDamage(0);
	}
}