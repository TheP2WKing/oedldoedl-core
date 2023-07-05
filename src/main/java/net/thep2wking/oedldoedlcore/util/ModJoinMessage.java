package net.thep2wking.oedldoedlcore.util;

import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.thep2wking.oedldoedlcore.OedldoedlCore;

@Mod.EventBusSubscriber
public class ModJoinMessage {
	@SubscribeEvent
	public static void addJoinMessage(PlayerLoggedInEvent event) {
		ITextComponent message = new TextComponentString("[")
				.appendSibling(new TextComponentString(
						TextFormatting.GREEN + OedldoedlCore.NAME + " v" + OedldoedlCore.VERSION))
				.appendSibling(new TextComponentString("] "))
				.appendSibling(new TextComponentTranslation("message." + OedldoedlCore.MODID + ".join"));
		event.player.sendMessage(message);
	}
}