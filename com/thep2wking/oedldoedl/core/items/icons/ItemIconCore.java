package com.thep2wking.oedldoedl.core.items.icons;

import java.util.List;

import com.thep2wking.oedldoedl.core.OedldoedlCore;
import com.thep2wking.oedldoedl.core.ReferenceCore;
import com.thep2wking.oedldoedl.core.config.constants.CoreConst;
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
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemIconCore extends Item implements IHasModel
{
	public ItemIconCore(String name)
	{
		func_77655_b(ReferenceCore.MODID+":"+name);
		setRegistryName(ReferenceCore.MODID+":"+name);
		func_77637_a(OedldoedlCore.TAB);
		func_77625_d(1);
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
    public EnumRarity func_77613_e(ItemStack stack)
    {
    	return RarityInit.YELLOW;
    }

	@Override
	@SideOnly(Side.CLIENT)
	public void func_77624_a(ItemStack stack, World world, List<String> tooltip, ITooltipFlag advanced)
	{
  		if (CoreConst.ITEM_INFORMATION)
  		{
  			TooltipShiftInfo.addTooltipText(tooltip, new String[]
  			{
  				TextFormatting.DARK_GREEN+I18n.func_135052_a("core.oedldoedl.mod.tip")+" "+TextFormatting.YELLOW+I18n.func_135052_a(ReferenceCore.NAME),
  				TextFormatting.DARK_GREEN+I18n.func_135052_a("core.oedldoedl.installed.tip")+" "+TextFormatting.GREEN+I18n.func_135052_a("core.oedldoedl.true.tip"),
  				TextFormatting.DARK_GREEN+I18n.func_135052_a("core.oedldoedl.version.tip")+" "+TextFormatting.YELLOW+I18n.func_135052_a(ReferenceCore.VERSION),
  				TextFormatting.WHITE+""+TextFormatting.ITALIC+I18n.func_135052_a("core.oedldoedl.by.tip"),
  			});
  		}
	}
}