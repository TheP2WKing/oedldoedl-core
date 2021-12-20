package net.thep2wking.oedldoedlcore.content.items;

import java.util.List;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.ModList;
import net.thep2wking.oedldoedlcore.config.CoreConfigProperties;
import net.thep2wking.oedldoedlcore.config.CoreConfigTooltips;
import net.thep2wking.oedldoedlcore.util.ModItemGroups;

public class ConstructIconItem extends Item
{
    public ConstructIconItem(Properties properties) 
    {
		super(properties
		.group(ModItemGroups.TAB_CORE)
		.maxStackSize(1));
    }
    
    @Override
    public Rarity getRarity(ItemStack stack) 
    {
    	if (CoreConfigProperties.rarities.get())
    	{
        	return Rarity.UNCOMMON;
    	}
    	return Rarity.COMMON;
    }

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) 
    {
		if (Screen.hasShiftDown() && ModList.get().isLoaded("oedldoedlconstruct") && CoreConfigTooltips.information.get())
		{
			tooltip.add(new TranslationTextComponent("item.oedldoedlcore.construct_icon.tip").mergeStyle(CoreConfigTooltips.information_annotation_formatting.get()));
			tooltip.add(new TranslationTextComponent("item.oedldoedlcore.construct_icon.tip2").mergeStyle(CoreConfigTooltips.information_annotation_formatting.get()));
			tooltip.add(new TranslationTextComponent("item.oedldoedlcore.construct_icon.tip3").mergeStyle(CoreConfigTooltips.information_annotation_formatting.get()));
			tooltip.add(new TranslationTextComponent("item.oedldoedlcore.construct_icon.tip4").mergeStyle(CoreConfigTooltips.information_annotation_formatting.get()));
		}  
		else if (Screen.hasShiftDown() && CoreConfigTooltips.information.get())
		{
			tooltip.add(new TranslationTextComponent("item.oedldoedlcore.construct_icon.tip5").mergeStyle(CoreConfigTooltips.information_annotation_formatting.get()));
			tooltip.add(new TranslationTextComponent("item.oedldoedlcore.construct_icon.tip6").mergeStyle(CoreConfigTooltips.information_annotation_formatting.get()));
		}
		else if (CoreConfigTooltips.information.get())
		{
			tooltip.add(new TranslationTextComponent("core.oedldoedl.info.key").mergeStyle(TextFormatting.GRAY));
		}
    }
}