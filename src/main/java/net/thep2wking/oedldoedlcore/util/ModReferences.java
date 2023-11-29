package net.thep2wking.oedldoedlcore.util;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.thep2wking.oedldoedlcore.OedldoedlCore;
import net.thep2wking.oedldoedlcore.config.CoreConfig;

/**
 * @author TheP2WKing
 */
public class ModReferences {
	// mod names
	public static final String BASE_MODID = "oedldoedl";
	public static final String BASE_NAME = "Oedldoedl";
	public static final String MINECRAFT_MODID = "minecraft";
	public static final String MINECRAFT_NAME = "Minecraft";

	public static final String MODID_CORE = BASE_MODID + "core";
	public static final String MODID_RESOURCES = BASE_MODID + "resources";
	public static final String MODID_GEAR = BASE_MODID + "gear";
	public static final String MODID_CURIOSITY = BASE_MODID + "curiosity";
	public static final String MODID_CONSTRUCT = BASE_MODID + "construct";
	public static final String MODID_EXPLOSIVES = BASE_MODID + "explosives";
	public static final String MODID_TECHNOLOGY = BASE_MODID + "technology";
	public static final String MODID_MUSIC = BASE_MODID + "music";
	public static final String MODID_INTEGRATION = BASE_MODID + "integration";

	public static final String NAME_CORE = BASE_NAME + " " + "Core";
	public static final String NAME_RESOURCES = BASE_NAME + " " + "Resources";
	public static final String NAME_GEAR = BASE_NAME + " " + "Gear";
	public static final String NAME_CURIOSITY = BASE_NAME + " " + "Curiosity";
	public static final String NAME_CONSTRUCT = BASE_NAME + " " + "Construct";
	public static final String NAME_EXPLOSIVES = BASE_NAME + " " + "Explosives";
	public static final String NAME_TECHNOLOGY = BASE_NAME + " " + "Technology";
	public static final String NAME_MUSIC = BASE_NAME + " " + "Music";
	public static final String NAME_INTEGRATION = BASE_NAME + " " + "Integration";

	// creative tab resource locations
	public static final ResourceLocation CREATIVE_TAB_LIGHT = new ResourceLocation("minecraft",
			"textures/gui/container/creative_inventory/tab_items.png");
	public static final ResourceLocation CREATIVE_TAB_LIGHT_SEARCH = new ResourceLocation("minecraft",
			"textures/gui/container/creative_inventory/tab_item_search.png");

	public static final ResourceLocation CREATIVE_TAB_DARK = new ResourceLocation(OedldoedlCore.MODID,
			"textures/gui/container/tab_oedldoedl_base.png");
	public static final ResourceLocation CREATIVE_TAB_DARK_SEARACH = new ResourceLocation(OedldoedlCore.MODID,
			"textures/gui/container/tab_oedldoedl_search.png");

	// attribute names
	public static final String ATTRIBUTE_ARMOR = "Oedldoedl Armor Attribute";
	public static final String ATTRIBUTE_ARMOR_TOUGHNESS = "Oedldoedl Armor Toughness Attribute";
	public static final String ATTRIBUTE_ATTACK_DAMAGE = "Oedldoedl Attack Damage Attribute";
	public static final String ATTRIBUTE_ATTACK_KNOCKBACK = "Oedldoedl Attack Knockback Attribute";
	public static final String ATTRIBUTE_ATTACK_SPEED = "Oedldoedl Attack Speed Attribute";
	public static final String ATTRIBUTE_FLYING_SPEED = "Oedldoedl Flying Speed Attribute";
	public static final String ATTRIBUTE_FOLLOW_RANGE = "Oedldoedl Follow Range Attribute";
	public static final String ATTRIBUTE_HORSE_JUMP_STRENGTH = "Oedldoedl Horse Jump Strength Attribute";
	public static final String ATTRIBUTE_KNOCKBACK_RESISTANCE = "Oedldoedl Knockback Resistance Attribute";
	public static final String ATTRIBUTE_LUCK = "Oedldoedl Luck Attribute";
	public static final String ATTRIBUTE_MAX_HEALTH = "Oedldoedl Max Health Attribute";
	public static final String ATTRIBUTE_MOVEMENT_SPEED = "Oedldoedl Movement Speed Attribute";
	public static final String ATTRIBUTE_ZOMBIE_SPAWN_REINFORCEMENTS = "Oedldoedl Zombie Spawn Reinforcements Attribute";
	public static final String ATTRIBUTE_SWIN_SPEED = "Oedldoedl Swim Speed Attribute";
	public static final String ATTRIBUTE_NAMETAG_DISTANCE = "Oedldoedl Nametag Distance Attribute";
	public static final String ATTRIBUTE_ENTITY_GRAVITY = "Oedldoedl Entity Gravity Attribute";
	public static final String ATTRIBUTE_REACH_DISTANCE = "Oedldoedl Reach Distance Attribute";

	// join message
	public static ITextComponent defaultJoinMessage(String name, String modid, String version) {
		return new TextComponentString("[")
				.appendSibling(new TextComponentString(
						TextFormatting.GREEN + name + " v" + version))
				.appendSibling(new TextComponentString("] "))
				.appendSibling(new TextComponentString(CoreConfig.LOGGING.JOIN_MESSAGE_TEXT));
	}
}