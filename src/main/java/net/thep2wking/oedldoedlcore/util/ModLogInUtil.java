package net.thep2wking.oedldoedlcore.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.util.text.event.ClickEvent.Action;
import net.minecraft.util.text.event.HoverEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.thep2wking.oedldoedlcore.OedldoedlCore;
import net.thep2wking.oedldoedlcore.config.CoreConfig;

/**
 * @author TheP2WKing
 */
public class ModLogInUtil {
	// join message component
	public static ITextComponent joinMessageTextComponent(String name, String curseForgeId, String version,
			boolean hasCustomMessage) {
		String url = new TextComponentTranslation("join." + OedldoedlCore.MODID + ".url").getUnformattedComponentText();
		String urlString = url + curseForgeId.replace(ModReferences.BASE_MODID, ModReferences.BASE_MODID + "-");
		String versionInfo = CoreConfig.LOGGING.JOIN_MESSAGES_VERSION_INFO ? " v" + version : "";
		ITextComponent joinMessage = new TextComponentString(TextFormatting.DARK_GREEN + "[")
				.appendSibling(new TextComponentString(TextFormatting.GREEN + name + versionInfo))
				.appendSibling(new TextComponentString(TextFormatting.DARK_GREEN + "]"))
				.appendSibling(new TextComponentString(" "))
				.appendSibling(hasCustomMessage
						? new TextComponentTranslation("join." + curseForgeId.replace("-", "") + ".message")
						: defaultMessage());

		ClickEvent clickEvent = new ClickEvent(Action.OPEN_URL, urlString);
		joinMessage.getStyle().setClickEvent(clickEvent);
		HoverEvent hoverEvent = new HoverEvent(HoverEvent.Action.SHOW_TEXT,
				new TextComponentTranslation("join." + OedldoedlCore.MODID + ".visit")
						.appendSibling(new TextComponentString(" " + name + " ").appendSibling(
								new TextComponentTranslation("join." + OedldoedlCore.MODID + ".curseforge")))
						.setStyle(new Style().setColor(TextFormatting.GOLD)));
		joinMessage.getStyle().setHoverEvent(hoverEvent);
		return joinMessage;
	}

	// default message
	private static ITextComponent defaultMessage() {
		return new TextComponentTranslation("join." + OedldoedlCore.MODID + ".default");
	}

	// add join message
	public static void addJoinMessage(PlayerLoggedInEvent event, String name, String curseForgeId, String version) {
		if (event.player instanceof EntityPlayer && !event.player.world.isRemote
				&& CoreConfig.LOGGING.JOIN_MESSAGES) {
			event.player.sendMessage(joinMessageTextComponent(name, curseForgeId, version, false));
		}
	}

	public static void addJoinMessage(PlayerLoggedInEvent event, String name, String curseForgeId, String version,
			boolean hasCustomMessage) {
		if (event.player instanceof EntityPlayer && !event.player.world.isRemote
				&& CoreConfig.LOGGING.JOIN_MESSAGES) {
			event.player.sendMessage(joinMessageTextComponent(name, curseForgeId, version, hasCustomMessage));
		}
	}
}