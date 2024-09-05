package net.thep2wking.oedldoedlcore.util;

import net.minecraft.util.ResourceLocation;
import net.thep2wking.oedldoedlcore.OedldoedlCore;

/**
 * @author TheP2WKing
 */
public class ModReferences {
	// mod names
	public static final String BASE_MODID = "oedldoedl";
	public static final String BASE_NAME = "Oedldoedl";
	public static final String MINECRAFT_MODID = "minecraft";
	public static final String MINECRAFT_NAME = "Minecraft";
	public static final String FORGE_MODID = "forge";
	public static final String FORGE_NAME = "Minecraft Forge";

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

	// oedldoedl loading first to retain mod order
	public static final String OEDLDOEDL_MODS_FIRST = "after:" + MODID_RESOURCES + ";after:" + MODID_GEAR + ";after:"
			+ MODID_CURIOSITY + ";after:" + MODID_CONSTRUCT + ";after:" + MODID_EXPLOSIVES + ";after:"
			+ MODID_TECHNOLOGY + ";after:" + MODID_MUSIC + ";after:" + MODID_INTEGRATION + ";";

	// creative tab resource locations
	public static final ResourceLocation CREATIVE_TAB_LIGHT = new ResourceLocation(MINECRAFT_MODID,
			"textures/gui/container/creative_inventory/tab_items.png");
	public static final ResourceLocation CREATIVE_TAB_LIGHT_SEARCH = new ResourceLocation(MINECRAFT_MODID,
			"textures/gui/container/creative_inventory/tab_item_search.png");

	public static final ResourceLocation CREATIVE_TAB_DARK = new ResourceLocation(OedldoedlCore.MODID,
			"textures/gui/container/tab_oedldoedl_base.png");
	public static final ResourceLocation CREATIVE_TAB_DARK_SEARCH = new ResourceLocation(OedldoedlCore.MODID,
			"textures/gui/container/tab_oedldoedl_search.png");

	// attribute names
	public static final String ATTRIBUTE_ARMOR = BASE_NAME + " Armor Attribute";
	public static final String ATTRIBUTE_ARMOR_TOUGHNESS = BASE_NAME + " Armor Toughness Attribute";
	public static final String ATTRIBUTE_ATTACK_DAMAGE = BASE_NAME + " Attack Damage Attribute";
	public static final String ATTRIBUTE_ATTACK_KNOCKBACK = BASE_NAME + " Attack Knockback Attribute";
	public static final String ATTRIBUTE_ATTACK_SPEED = BASE_NAME + " Attack Speed Attribute";
	public static final String ATTRIBUTE_FLYING_SPEED = BASE_NAME + " Flying Speed Attribute";
	public static final String ATTRIBUTE_FOLLOW_RANGE = BASE_NAME + " Follow Range Attribute";
	public static final String ATTRIBUTE_HORSE_JUMP_STRENGTH = BASE_NAME + " Horse Jump Strength Attribute";
	public static final String ATTRIBUTE_KNOCKBACK_RESISTANCE = BASE_NAME + " Knockback Resistance Attribute";
	public static final String ATTRIBUTE_LUCK = BASE_NAME + " Luck Attribute";
	public static final String ATTRIBUTE_MAX_HEALTH = BASE_NAME + " Max Health Attribute";
	public static final String ATTRIBUTE_MOVEMENT_SPEED = BASE_NAME + " Movement Speed Attribute";
	public static final String ATTRIBUTE_ZOMBIE_SPAWN_REINFORCEMENTS = BASE_NAME
			+ " Zombie Spawn Reinforcements Attribute";
	public static final String ATTRIBUTE_SWIN_SPEED = BASE_NAME + " Swim Speed Attribute";
	public static final String ATTRIBUTE_NAMETAG_DISTANCE = BASE_NAME + " Nametag Distance Attribute";
	public static final String ATTRIBUTE_ENTITY_GRAVITY = " Entity Gravity Attribute";
	public static final String ATTRIBUTE_REACH_DISTANCE = BASE_NAME + " Reach Distance Attribute";
}