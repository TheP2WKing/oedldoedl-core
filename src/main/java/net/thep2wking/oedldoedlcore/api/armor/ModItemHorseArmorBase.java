package net.thep2wking.oedldoedlcore.api.armor;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.thep2wking.oedldoedlcore.api.item.ModItemBase;

/**
 * @author TheP2WKing
 */
public class ModItemHorseArmorBase extends ModItemBase {
    public final String texture;
    public final int armor;

	public ModItemHorseArmorBase(String modid, String name, CreativeTabs tab, String texture, int armor, EnumRarity rarity, boolean hasEffect, int tooltipLines, int annotationLines) {
		super(modid, name, tab, rarity, hasEffect, tooltipLines, annotationLines);
		this.texture = texture;
		this.armor = armor;
	}
}