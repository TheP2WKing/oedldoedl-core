package com.thep2wking.oedldoedl.core.util.tooltips;

import java.util.List;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TooltipControlEffectInfo 
{
	public static final TooltipControlEffectInfo INSTANCE = new TooltipControlEffectInfo();

	private TooltipControlEffectInfo() 
	{
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SideOnly(Side.CLIENT)
	public static void addTooltipText(List<String> tooltip, String[] controlText) 
	{
		if (GuiScreen.func_146271_m() || GuiTooltipDisplay.display_gui)
			for (String string : controlText == null ? new String[0] : controlText)
				tooltip.add(string);
		else if (controlText != null)
			tooltip.add(TextFormatting.GRAY+""+I18n.func_135052_a("core.oedldoedl.key.press.info")+
						TextFormatting.DARK_AQUA+" "+TextFormatting.ITALIC+I18n.func_135052_a("core.oedldoedl.key.control")+
						TextFormatting.GRAY+" "+I18n.func_135052_a("core.oedldoedl.key.control.effects"));
	}
}