package com.thep2wking.oedldoedl.core.util.tooltips;

import java.util.List;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TooltipShiftInfo
{
	public static final TooltipShiftInfo INSTANCE = new TooltipShiftInfo();

	private TooltipShiftInfo() 
	{
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SideOnly(Side.CLIENT)
	public static void addTooltipText(List<String> tooltip, String[] shiftText) 
	{
		if (GuiScreen.func_146272_n() || GuiTooltipDisplay.display_gui)
			for (String string : shiftText == null ? new String[0] : shiftText)
				tooltip.add(string);
		else if (shiftText != null)
			tooltip.add(TextFormatting.GRAY+""+I18n.func_135052_a("core.oedldoedl.key.press.info")+
						TextFormatting.DARK_RED+" "+TextFormatting.ITALIC+I18n.func_135052_a("core.oedldoedl.key.shift")+
						TextFormatting.GRAY+" "+I18n.func_135052_a("core.oedldoedl.key.shift.info"));
	}
}