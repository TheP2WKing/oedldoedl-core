package net.thep2wking.oedldoedlcore.content;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thep2wking.oedldoedlcore.api.ModItemBase;
import net.thep2wking.oedldoedlcore.util.ModTooltips;

public class SubModIconItem extends ModItemBase {
	private final String modName;

	public SubModIconItem(String name, CreativeTabs tab, EnumRarity rarity, boolean hasEffect, String modName, int tooltipLines,
			int annotationLines) {
		super(name, tab, rarity, hasEffect, tooltipLines, annotationLines);
		this.modName = modName;
		this.setMaxStackSize(1);
	}

		@Override
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		if (ModTooltips.showAnnotationTip() && Loader.isModLoaded(modName)) {
			ModTooltips.addAnnotation(tooltip, this.getUnlocalizedName(), 1);
			ModTooltips.addAnnotation(tooltip, this.getUnlocalizedName(), 2);
			ModTooltips.addAnnotation(tooltip, this.getUnlocalizedName(), 3);
			ModTooltips.addAnnotation(tooltip, this.getUnlocalizedName(), 4);
		} else if (ModTooltips.showAnnotationTip()) {
			ModTooltips.addAnnotation(tooltip, this.getUnlocalizedName(), 5);
			ModTooltips.addAnnotation(tooltip, this.getUnlocalizedName(), 6);
		}
		if (ModTooltips.showInfoTip()) {
			for (int i = 1; i <= tooltipLines; ++i) {
				ModTooltips.addInformation(tooltip, this.getUnlocalizedName(), i);
			}
		} else if (ModTooltips.showInfoTipKey() && !(tooltipLines == 0)) {
			ModTooltips.addKey(tooltip, ModTooltips.KEY_INFO);
		}
	}
}
