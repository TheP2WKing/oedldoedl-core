package net.thep2wking.oedldoedlcore.config;

import org.apache.commons.lang3.tuple.Pair;

import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.common.ForgeConfigSpec.DoubleValue;
import net.minecraftforge.common.ForgeConfigSpec.EnumValue;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;

public class CoreConfig {
	// recipes
	public static BooleanValue enable_mod_recipes;

	public static BooleanValue enable_conversion_recipes;
	public static BooleanValue enable_additional_recipes;

	// join message
	public static BooleanValue join_messages;

	// tooltips
	public static BooleanValue information_tooltip;
	public static BooleanValue information_tooltip_key;
	public static EnumValue<TextFormatting> information_formatting;
	public static EnumValue<TextFormatting> information_annotation_formatting;
	public static BooleanValue annotation_tooltip;

	public static BooleanValue effects_tooltip;
	public static BooleanValue effects_tooltip_key;
	public static EnumValue<TextFormatting> effects_formatting;
	public static EnumValue<TextFormatting> effects_positive_formatting;
	public static EnumValue<TextFormatting> effects_negative_formatting;
	public static EnumValue<TextFormatting> effects_annotation_formatting;

	public static BooleanValue origin_tooltip;
	public static BooleanValue origin_tooltip_key;
	public static EnumValue<TextFormatting> origin_formatting;
	public static EnumValue<TextFormatting> origin_annotation_formatting;

	// properties
	public static BooleanValue item_rarities;
	public static BooleanValue enchantment_effects;
	public static BooleanValue fire_immunity;
	public static BooleanValue blocks_drop_experience;

	public static DoubleValue shears_durability_multiplier;
	public static DoubleValue paxel_durability_multiplier;
	public static DoubleValue shield_durability_multiplier;

	// debug wrench
	public static BooleanValue debug_wrench_useable_in_survival;

	// creative tab
	public static BooleanValue unobtainable_items_creative_tab;

	// integration
	public static BooleanValue jei_descriptions;

	public static void init() {
		Pair<ConfigLoderCommon, ForgeConfigSpec> core_common_config = new ForgeConfigSpec.Builder()
				.configure(ConfigLoderCommon::new);
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, core_common_config.getRight());

		Pair<ConfigLoderClient, ForgeConfigSpec> core_client_config = new ForgeConfigSpec.Builder()
				.configure(ConfigLoderClient::new);
		ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, core_client_config.getRight());
	}

	public static class ConfigLoderCommon {
		public ConfigLoderCommon(ForgeConfigSpec.Builder builder) {
			builder.push("Recipes");
			enable_conversion_recipes = builder.comment(
					"Toggle recipes to convert between storage blocks / block color variants etc. [Default: true]")
					.define("enable_conversion_recipes", true);
			enable_additional_recipes = builder
					.comment("Toggle additional recipes for uncraftable items. [Default: true]")
					.define("enable_additional_recipes", true);
			builder.pop();

			builder.push("Content");
			debug_wrench_useable_in_survival = builder
					.comment("Toggle if the wrench is usable in survival mode. [Default: true]")
					.define("debug_wrench_useable_in_survival", true);
			unobtainable_items_creative_tab = builder.comment(
					"Toggle if unobtainable vanilla items like command blocks and spawner should be added to a dedicated creative tab. This is especially useful when JEI is installed for easy viewing or quick cheating of items. [Default: true]")
					.define("unobtainable_items_in_creative_tab", true);
			builder.pop();

			builder.push("Properties");
			item_rarities = builder.comment(
					"Toggle whether items added by oedldoedl mods should have custom colored rarities (if present). [Default: true]")
					.define("item_rarities", true);
			enchantment_effects = builder.comment(
					"Toggle whether items added by oedldoedl mods should have an enchantment effect (if present). [Default: true]")
					.define("enchantment_effects", true);
			fire_immunity = builder.comment(
					"Toggle whether items added by oedldoedl mods should have immunity to fire effect (if present). [Default: true]")
					.define("fire_immunity", true);
			blocks_drop_experience = builder
					.comment("Toggle whether blocks added by oedldoedl mods should drop experience. [Default: true]")
					.define("blocks_drop_experience", true);

			builder.push("Durability");
			shears_durability_multiplier = builder.comment("Set shears durability multiplier. [Default: 0.94957983]")
					.defineInRange("shears_durability_multiplier", 0.94957983, 0, 10.0);
			paxel_durability_multiplier = builder.comment("Set paxel durability multiplier. [Default: 3.0]")
					.defineInRange("paxel_durability_multiplier", 3.0, 0, 10.0);
			shield_durability_multiplier = builder.comment("Set shield durability multiplier. [Default: 3.0]")
					.defineInRange("shield_durability_multiplier", 3.0, 0, 10.0);
			builder.pop();
			builder.pop();

			enable_mod_recipes = builder.comment(
					"Toggle all recipes from this mod. All recipes for items / blocks / liquids will be disabled. "
							+ "This option is intended for use in a modpack with custom recipes so you do not have to remove them with Crafttweaker. "
							+ "This can break certain recipes or other mechanics. [Default: true]")
					.define("enable_mod_recipes", true);
		}
	}

	public static class ConfigLoderClient {
		public ConfigLoderClient(ForgeConfigSpec.Builder builder) {
			builder.push("Tooltips");
			builder.push("Information");
			information_tooltip = builder.comment("Toggle information tooltips. [Default: false]")
					.define("enable_tooltip", false);
			information_tooltip_key = builder
					.comment("Toggle whether to display the keyboard key for information tooltips. [Default: false]")
					.define("enable_hold_key", true);
			information_formatting = builder.comment("Set color for information tooltip. [Default: WHITE]")
					.defineEnum("text_formatting", TextFormatting.WHITE);
			information_annotation_formatting = builder
					.comment("Set color for information annotations. [Default: GOLD]")
					.defineEnum("tooltip_annotation_formatting", TextFormatting.GOLD);
			annotation_tooltip = builder.comment("Toggle information tooltips. [Default: true]")
					.define("enable_annotation", true);
			builder.pop();

			builder.push("Effects");
			effects_tooltip = builder.comment("Toggle effects tooltips. [Default: true]").define("enable_tooltip",
					true);
			effects_tooltip_key = builder
					.comment("Toggle whether to display the keyboard key for effects tooltips. [Default: false]")
					.define("enable_hold_key", true);
			effects_formatting = builder.comment("Set color for generel effect tooltip. [Default: AQUA]")
					.defineEnum("text_formatting", TextFormatting.AQUA);
			effects_positive_formatting = builder.comment("Set color for positive effect tooltip. [Default: GREEN]")
					.defineEnum("positive_effect_formatting", TextFormatting.GREEN);
			effects_negative_formatting = builder.comment("Set color for negativ effect tooltip. [Default: RED]")
					.defineEnum("negative_effect_formatting", TextFormatting.RED);
			effects_annotation_formatting = builder.comment("Set color for effect annotations. [Default: GOLD]")
					.defineEnum("tooltip_annotation_formatting", TextFormatting.GOLD);
			builder.pop();

			builder.push("Origin");
			origin_tooltip = builder.comment("Toggle origin tooltips. [Default: true]").define("enable_tooltip", true);
			origin_tooltip_key = builder
					.comment("Toggle whether to display the keyboard key for origin tooltips. [Default: false]")
					.define("enable_hold_key", true);
			origin_formatting = builder.comment("Set color for origin tooltip. [Default: WHITE]")
					.defineEnum("text_formatting", TextFormatting.WHITE);
			origin_annotation_formatting = builder.comment("Set color for origin annotations. [Default: GOLD]")
					.defineEnum("tooltip_annotation_formatting", TextFormatting.GOLD);
			builder.pop();
			builder.pop();

			builder.push("Integration");
			jei_descriptions = builder
					.comment("Toggle JEI descriptions of vanilla items (added by this mod). [Default: true]")
					.define("jei_descriptions", true);
			builder.pop();

			join_messages = builder.comment("Toggle oedldoedl series join messages. [Default: true]")
					.define("join_messages", true);
		}
	}
}