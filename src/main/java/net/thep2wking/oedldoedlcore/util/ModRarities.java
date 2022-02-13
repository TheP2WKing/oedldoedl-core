package net.thep2wking.oedldoedlcore.util;

import net.minecraft.item.Rarity;
import net.minecraft.util.text.TextFormatting;

public class ModRarities 
{
	//color
	public static final Rarity AQUA = Rarity.RARE;
	public static final Rarity BLACK = Rarity.create("black", TextFormatting.BLACK);
	public static final Rarity BLUE = Rarity.create("blue", TextFormatting.BLUE);
	public static final Rarity DARK_AQUA = Rarity.create("dark_aqua", TextFormatting.DARK_AQUA);
	public static final Rarity DARK_BLUE = Rarity.create("dark_blue", TextFormatting.DARK_BLUE);
	public static final Rarity DARK_GRAY = Rarity.create("dark_gray", TextFormatting.DARK_GRAY);
	public static final Rarity DARK_GREEN = Rarity.create("dark_green", TextFormatting.DARK_GREEN);
	public static final Rarity DARK_PURPLE = Rarity.create("dark_purple", TextFormatting.DARK_PURPLE);
	public static final Rarity DARK_RED = Rarity.create("dark_red", TextFormatting.DARK_RED);
	public static final Rarity GOLD = Rarity.create("gold", TextFormatting.GOLD);
	public static final Rarity GRAY = Rarity.create("gray", TextFormatting.GRAY);
	public static final Rarity GREEN = Rarity.create("green", TextFormatting.GREEN);
	public static final Rarity LIGHT_PURPLE = Rarity.EPIC;
	public static final Rarity RED = Rarity.create("red", TextFormatting.RED);
	public static final Rarity WHITE = Rarity.COMMON;
	public static final Rarity YELLOW = Rarity.UNCOMMON;
	
	//font
	public static final Rarity BOLD = Rarity.create("bold", TextFormatting.BOLD);
	public static final Rarity ITALIC = Rarity.create("italic", TextFormatting.ITALIC);
	public static final Rarity OBFUSCATED = Rarity.create("obfuscated", TextFormatting.OBFUSCATED);
	public static final Rarity STRIKETHROUGH = Rarity.create("strikethrough", TextFormatting.STRIKETHROUGH);
	public static final Rarity UNDERLINE = Rarity.create("underline", TextFormatting.UNDERLINE);
	
	//reset
	public static final Rarity RESET = Rarity.create("reset", TextFormatting.RESET);
}