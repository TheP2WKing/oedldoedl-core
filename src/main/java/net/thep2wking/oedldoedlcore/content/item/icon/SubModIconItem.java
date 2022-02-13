package net.thep2wking.oedldoedlcore.content.item.icon;

import java.util.List;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.item.Item.Properties;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.ModList;
import net.thep2wking.oedldoedlcore.base.ModItemBase;
import net.thep2wking.oedldoedlcore.config.CoreConfig;
import net.thep2wking.oedldoedlcore.util.TipLines;

public class SubModIconItem extends ModItemBase
{
	public String modName;
	
	/**
	 * @author TheP2WKing
	 * @param rarity			{@link Rarity}
	 * @param hasEffect			boolean
	 * @param fireImmunity		boolean
	 * @param modName			String
	 * @param lines 			{@link TipLines}
	 * @param hasAnnotation  	boolean
	 * @param properties		{@link Properties}
	 */
    public SubModIconItem(Rarity rarity, boolean hasEffect, boolean fireImmunity, String modName, TipLines lines, boolean hasAnnotation, Properties properties) 
    {
		super(rarity, hasEffect, fireImmunity, lines, hasAnnotation, properties);
		this.modName = modName;
    }

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) 
    {
		if (Screen.hasShiftDown() && ModList.get().isLoaded(modName) && CoreConfig.information_tooltip.get())
		{
			tooltip.add(new TranslationTextComponent(this.getTranslationKey()+".tip").mergeStyle(CoreConfig.information_annotation_formatting.get()));
			tooltip.add(new TranslationTextComponent(this.getTranslationKey()+".tip2").mergeStyle(CoreConfig.information_annotation_formatting.get()));
			tooltip.add(new TranslationTextComponent(this.getTranslationKey()+".tip3").mergeStyle(CoreConfig.information_annotation_formatting.get()));
			tooltip.add(new TranslationTextComponent(this.getTranslationKey()+".tip4").mergeStyle(CoreConfig.information_annotation_formatting.get()));
		}  
		else if (Screen.hasShiftDown() && CoreConfig.information_tooltip.get())
		{
			tooltip.add(new TranslationTextComponent(this.getTranslationKey()+".tip5").mergeStyle(CoreConfig.information_annotation_formatting.get()));
			tooltip.add(new TranslationTextComponent(this.getTranslationKey()+".tip6").mergeStyle(CoreConfig.information_annotation_formatting.get()));
		}
		else if (CoreConfig.information_tooltip.get() && CoreConfig.information_tooltip_key.get())
		{
			tooltip.add(new TranslationTextComponent("core.oedldoedl.info.key").mergeStyle(TextFormatting.GRAY));
		}
    }
}