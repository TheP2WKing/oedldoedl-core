package com.thep2wking.oedldoedl.core.util.tooltips;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiTooltipDisplay extends GuiScreen
{
	public static boolean display_gui = false;
	public static final int GUI_MODE = 1;

	@Override
	public boolean func_73868_f() 
	{
		return false;
	}

	@Mod.EventBusSubscriber(Side.CLIENT)
	public static class OpenGuiEvent 
	{
		@SubscribeEvent
		public static void openGui(ClientChatReceivedEvent event) 
		{
			if (GuiTooltipDisplay.display_gui) 
			Minecraft.func_71410_x().func_147108_a(new GuiTooltipDisplay());
		}
	}
}