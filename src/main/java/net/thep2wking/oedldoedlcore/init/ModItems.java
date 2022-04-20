package net.thep2wking.oedldoedlcore.init;

import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.thep2wking.oedldoedlcore.OedldoedlCore;
import net.thep2wking.oedldoedlcore.api.ModItemBase;
import net.thep2wking.oedldoedlcore.content.item.icon.SubModIconItem;
import net.thep2wking.oedldoedlcore.content.item.misc.DebugWrenchItem;
import net.thep2wking.oedldoedlcore.util.ModItemGroups;
import net.thep2wking.oedldoedlcore.util.ModRarities;

public class ModItems {
	// deferred register
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
			OedldoedlCore.MODID);

	// icons
	public static final RegistryObject<Item> CORE_ICON = ITEMS.register("core_icon",
			() -> new ModItemBase(ModRarities.YELLOW, false, true, 0, 4,
					new Item.Properties().group(ModItemGroups.TAB_CORE)));
	public static final RegistryObject<Item> RESOURCES_ICON = ITEMS.register("resources_icon",
			() -> new SubModIconItem(ModRarities.YELLOW, false, true, "oedldoedlresources", 0, 4,
					new Item.Properties().group(ModItemGroups.TAB_CORE)));
	public static final RegistryObject<Item> GEAR_ICON = ITEMS.register("gear_icon",
			() -> new SubModIconItem(ModRarities.YELLOW, false, true, "oedldoedlgear", 0, 4,
					new Item.Properties().group(ModItemGroups.TAB_CORE)));
	public static final RegistryObject<Item> CURIOSITY_ICON = ITEMS.register("curiosity_icon",
			() -> new SubModIconItem(ModRarities.YELLOW, false, true, "oedldoedlcuriosity", 0, 4,
					new Item.Properties().group(ModItemGroups.TAB_CORE)));
	public static final RegistryObject<Item> CONSTRUCT_ICON = ITEMS.register("construct_icon",
			() -> new SubModIconItem(ModRarities.YELLOW, false, true, "oedldoedlconstruct", 0, 4,
					new Item.Properties().group(ModItemGroups.TAB_CORE)));
	public static final RegistryObject<Item> MUSIC_CON = ITEMS.register("music_icon",
			() -> new SubModIconItem(ModRarities.YELLOW, false, true, "oedldoedlmusic", 0, 4,
					new Item.Properties().group(ModItemGroups.TAB_CORE)));
	public static final RegistryObject<Item> INTEGRATION_ICON = ITEMS.register("integration_icon",
			() -> new SubModIconItem(ModRarities.YELLOW, false, true, "oedldoedlintegration", 0, 4,
					new Item.Properties().group(ModItemGroups.TAB_CORE)));

	// misc
	public static final RegistryObject<Item> DEBUG_WRENCH = ITEMS.register("debug_wrench",
			() -> new DebugWrenchItem(ModRarities.LIGHT_PURPLE, false, true, 2, 0,
					new Item.Properties().group(ModItemGroups.TAB_CORE)));

	public static void register(IEventBus enevtBus) {
		ITEMS.register(enevtBus);

		OedldoedlCore.LOGGER.info("Registerd Items for " + OedldoedlCore.MODID + "!");
	}
}