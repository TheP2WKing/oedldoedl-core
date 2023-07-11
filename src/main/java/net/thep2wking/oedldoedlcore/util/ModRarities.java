package net.thep2wking.oedldoedlcore.util;

import net.minecraft.item.EnumRarity;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.util.EnumHelper;

/**
 * @author TheP2WKing
 */
@SuppressWarnings("deprecation")
public class ModRarities {
    // colors
    public static EnumRarity AQUA = EnumRarity.RARE;
    public static EnumRarity BLACK = EnumHelper.addRarity("BLACK", TextFormatting.BLACK, "Black");
    public static EnumRarity BLUE = EnumHelper.addRarity("BLUE", TextFormatting.BLUE, "Blue");
    public static EnumRarity DARK_AQUA = EnumHelper.addRarity("DARK_AQUA", TextFormatting.DARK_AQUA, "Dark Aqua");
    public static EnumRarity DARK_BLUE = EnumHelper.addRarity("DARK_BLUE", TextFormatting.DARK_BLUE, "Dark Blue");
    public static EnumRarity DARK_GRAY = EnumHelper.addRarity("DARK_GRAY", TextFormatting.DARK_GRAY, "Dark Gray");
    public static EnumRarity DARK_GREEN = EnumHelper.addRarity("DARK_GREEN", TextFormatting.DARK_GREEN, "Dark Green");
    public static EnumRarity DARK_PURPLE = EnumHelper.addRarity("DARK_PURPLE", TextFormatting.DARK_PURPLE,
            "Dark Purple");
    public static EnumRarity DARK_RED = EnumHelper.addRarity("DARK_RED", TextFormatting.DARK_RED, "Dark Red");
    public static EnumRarity GOLD = EnumHelper.addRarity("GOLD", TextFormatting.GOLD, "Gold");
    public static EnumRarity GRAY = EnumHelper.addRarity("GRAY", TextFormatting.GRAY, "Gray");
    public static EnumRarity GREEN = EnumHelper.addRarity("GREEN", TextFormatting.GREEN, "Green");
    public static EnumRarity LIGHT_PURPLE = EnumRarity.EPIC;
    public static EnumRarity RED = EnumHelper.addRarity("RED", TextFormatting.RED, "Red");
    public static EnumRarity WHITE = EnumRarity.COMMON;
    public static EnumRarity YELLOW = EnumRarity.UNCOMMON;

    // formatting
    public static EnumRarity BOLD = EnumHelper.addRarity("BOLD", TextFormatting.BOLD, "Bold");
    public static EnumRarity ITALIC = EnumHelper.addRarity("ITALIC", TextFormatting.ITALIC, "Italic");
    public static EnumRarity OBFUSCATED = EnumHelper.addRarity("OBFUSCATED", TextFormatting.OBFUSCATED, "Obfuscated");
    public static EnumRarity STRIKETHROUGH = EnumHelper.addRarity("STRIKETHROUGH", TextFormatting.STRIKETHROUGH,
            "Strikethrough");
    public static EnumRarity UNDERLINE = EnumHelper.addRarity("UNDERLINE", TextFormatting.UNDERLINE, "Underline");
}