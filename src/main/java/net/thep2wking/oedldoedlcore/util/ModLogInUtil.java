package net.thep2wking.oedldoedlcore.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.util.text.event.ClickEvent.Action;
import net.minecraft.util.text.event.HoverEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.thep2wking.oedldoedlcore.config.CoreConfig;

public class ModLogInUtil {
	// join message component
	public static ITextComponent joinMessageTextComponent(String name, String modid, String version) {
		String urlString = "https://www.curseforge.com/minecraft/mc-mods/"
				+ modid.replace(ModReferences.BASE_MODID, ModReferences.BASE_MODID + "-");
		ITextComponent joinMessage = new TextComponentString(TextFormatting.DARK_GREEN + "[")
				.appendSibling(new TextComponentString(TextFormatting.GREEN + name + " v" + version))
				.appendSibling(new TextComponentString(TextFormatting.DARK_GREEN + "]"))
				.appendSibling(new TextComponentString(" installed successfully!"));

		ClickEvent clickEvent = new ClickEvent(Action.OPEN_URL, urlString);
		joinMessage.getStyle().setClickEvent(clickEvent);
		HoverEvent hoverEvent = new HoverEvent(HoverEvent.Action.SHOW_TEXT,
				new TextComponentString("Click to visit the " + name + " CurseForge page..."));
		joinMessage.getStyle().setHoverEvent(hoverEvent);

		return joinMessage;
	}

	// add join message
	public static void addJoinMessage(PlayerLoggedInEvent event, String name, String modid, String version) {
		if (event.player instanceof EntityPlayer && !event.player.world.isRemote
				&& CoreConfig.LOGGING.JOIN_MESSAGES) {
			event.player.sendMessage(joinMessageTextComponent(name, modid, version));
		}
	}
}