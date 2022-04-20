package net.thep2wking.oedldoedlcore.content.item.icon;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.ModList;
import net.thep2wking.oedldoedlcore.api.ModItemBase;
import net.thep2wking.oedldoedlcore.util.ModTooltips;

public class SubModIconItem extends ModItemBase {
	public String modName;

	/**
	 * @author TheP2WKing
	 * @param rarity          {@link Rarity}
	 * @param hasEffect       boolean
	 * @param fireImmunity    boolean
	 * @param modName         String
	 * @param tooltipLines    int
	 * @param annotationLines int
	 * @param properties      {@link Properties}
	 */
	public SubModIconItem(Rarity rarity, boolean hasEffect, boolean fireImmunity, String modName, int tooltipLines,
			int annotationLines, Properties properties) {
		super(rarity, hasEffect, fireImmunity, tooltipLines, annotationLines, properties.maxStackSize(1));
		this.modName = modName;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		if (ModTooltips.showAnnotationTip() && ModList.get().isLoaded(modName)) {
			ModTooltips.addAnnotation(tooltip, this.getTranslationKey(), 1);
			ModTooltips.addAnnotation(tooltip, this.getTranslationKey(), 2);
			ModTooltips.addAnnotation(tooltip, this.getTranslationKey(), 3);
			ModTooltips.addAnnotation(tooltip, this.getTranslationKey(), 4);
		} else if (ModTooltips.showAnnotationTip()) {
			ModTooltips.addAnnotation(tooltip, this.getTranslationKey(), 5);
			ModTooltips.addAnnotation(tooltip, this.getTranslationKey(), 6);
		}
		if (ModTooltips.showInfoTip()) {
			for (int i = 1; i <= tooltipLines; ++i) {
				ModTooltips.addInformation(tooltip, this.getTranslationKey(), i);
			}
		} else if (ModTooltips.showInfoTipKey() && !(tooltipLines == 0)) {
			ModTooltips.addKey(tooltip, ModTooltips.KEY_INFO);
		}
	}
}