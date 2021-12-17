package com.thep2wking.oedldoedl.core.items;

import java.util.List;

import com.thep2wking.oedldoedl.core.OedldoedlCore;
import com.thep2wking.oedldoedl.core.ReferenceCore;
import com.thep2wking.oedldoedl.core.config.CoreConfig;
import com.thep2wking.oedldoedl.core.init.ItemInit;
import com.thep2wking.oedldoedl.core.init.RarityInit;
import com.thep2wking.oedldoedl.core.util.interfaces.IHasModel;
import com.thep2wking.oedldoedl.core.util.tooltips.TooltipShiftInfo;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemIconConstruct extends Item implements IHasModel
{
	public ItemIconConstruct(String name)
	{
		setUnlocalizedName(ReferenceCore.MODID+":"+name);
		setRegistryName(ReferenceCore.MODID+":"+name);
		setCreativeTab(OedldoedlCore.TAB);
		setMaxStackSize(1);
		ItemInit.ITEMS.add(this);
	}

	@Override
	@SideOnly (Side.CLIENT)
	public void registerModels()
	{
		OedldoedlCore.proxy.registerItemRenderer(this, 0, "inventory");
	}

    @Override
    @SideOnly (Side.CLIENT)
    public EnumRarity getRarity(ItemStack stack)
    {
    	return RarityInit.YELLOW;
    }

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag advanced)
	{
  		if (CoreConfig.GENEREL.tooltips.itemInformation && Loader.isModLoaded("oedldoedlconstruct"))
  		{
  			TooltipShiftInfo.addTooltipText(tooltip, new String[]
  			{
  				TextFormatting.DARK_GREEN+I18n.format("core.oedldoedl.mod.tip")+" "+TextFormatting.YELLOW+I18n.format("construct.oedldoedl.name.tip"),
  				TextFormatting.DARK_GREEN+I18n.format("core.oedldoedl.installed.tip")+" "+TextFormatting.GREEN+I18n.format("core.oedldoedl.true.tip"),
  				TextFormatting.DARK_GREEN+I18n.format("core.oedldoedl.version.tip")+" "+TextFormatting.YELLOW+I18n.format("construct.oedldoedl.version.tip"),
  				TextFormatting.GRAY+""+TextFormatting.ITALIC+I18n.format("core.oedldoedl.by.tip"),
  			});
  		}
  		else if (CoreConfig.GENEREL.tooltips.itemInformation)
  		{
  			TooltipShiftInfo.addTooltipText(tooltip, new String[]
  			{
  				TextFormatting.DARK_GREEN+I18n.format("core.oedldoedl.mod.tip")+" "+TextFormatting.YELLOW+I18n.format("core.oedldoedl.construct.name.tip"),
  				TextFormatting.DARK_GREEN+I18n.format("core.oedldoedl.installed.tip")+" "+TextFormatting.RED+I18n.format("core.oedldoedl.false.tip"),
  			});
  		}
	}
}