package com.thep2wking.oedldoedl.core.util.tooltips;

import java.util.List;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TooltipAltOriginInfo
{
	public static final TooltipAltOriginInfo INSTANCE = new TooltipAltOriginInfo();

	private TooltipAltOriginInfo() 
	{
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SideOnly(Side.CLIENT)
	public static void addTooltipText(List<String> tooltip, String[] altText) 
	{
		if (GuiScreen.isAltKeyDown() || GuiTooltipDisplay.display_gui)
			for (String string : altText == null ? new String[0] : altText)
				tooltip.add(string);
		else if (altText != null)
			tooltip.add(TextFormatting.GRAY+""+I18n.format("core.oedldoedl.key.press.info")+
						TextFormatting.GREEN+" "+TextFormatting.ITALIC+I18n.format("core.oedldoedl.key.alt")+
						TextFormatting.GRAY+" "+I18n.format("core.oedldoedl.key.alt.origin"));
	}
}