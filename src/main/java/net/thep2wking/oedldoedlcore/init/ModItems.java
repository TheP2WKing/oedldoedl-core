package net.thep2wking.oedldoedlcore.init;

import java.util.HashSet;

import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.thep2wking.oedldoedlcore.OedldoedlCore;
import net.thep2wking.oedldoedlcore.config.CoreConfig;
import net.thep2wking.oedldoedlcore.content.item.icon.CoreModIconItem;
import net.thep2wking.oedldoedlcore.content.item.icon.SubModIconItem;
import net.thep2wking.oedldoedlcore.content.item.misc.DebugWrenchItem;
import net.thep2wking.oedldoedlcore.util.ModItemGroups;
import net.thep2wking.oedldoedlcore.util.ModItemTier;
import net.thep2wking.oedldoedlcore.util.ModRarities;
import net.thep2wking.oedldoedlcore.util.TipLines;

public class ModItems 
{
	//deferred register
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, OedldoedlCore.MODID);
	
	//icons
	public static final RegistryObject<Item> CORE_ICON = ITEMS.register("core_icon", 
			() -> new CoreModIconItem(ModRarities.YELLOW, false, true, TipLines.DISABLED, false, new Item.Properties().group(ModItemGroups.TAB_CORE)));
	public static final RegistryObject<Item> RESOURCES_ICON = ITEMS.register("resources_icon", 
			() -> new SubModIconItem(ModRarities.YELLOW, false, true, "oedldoedlresources", TipLines.DISABLED, false, new Item.Properties().group(ModItemGroups.TAB_CORE)));
	public static final RegistryObject<Item> GEAR_ICON = ITEMS.register("gear_icon", 
			() -> new SubModIconItem(ModRarities.YELLOW, false, true, "oedldoedlgear", TipLines.DISABLED, false, new Item.Properties().group(ModItemGroups.TAB_CORE)));
	public static final RegistryObject<Item> CONSTRUCT_ICON = ITEMS.register("construct_icon", 
			() -> new SubModIconItem(ModRarities.YELLOW, false, true, "oedldoedlconstruct", TipLines.DISABLED, false, new Item.Properties().group(ModItemGroups.TAB_CORE)));
	public static final RegistryObject<Item> MUSIC_CON = ITEMS.register("music_icon",  
			() -> new SubModIconItem(ModRarities.YELLOW, false, true, "oedldoedlmusic", TipLines.DISABLED, false, new Item.Properties().group(ModItemGroups.TAB_CORE)));
	public static final RegistryObject<Item> INTEGRATION_ICON = ITEMS.register("integration_icon", 
			() -> new SubModIconItem(ModRarities.YELLOW, false, true, "oedldoedlintegration", TipLines.DISABLED, false, new Item.Properties().group(ModItemGroups.TAB_CORE)));
	
	//misc
	public static final RegistryObject<Item> DEBUG_WRENCH = ITEMS.register("debug_wrench", 
			() -> new DebugWrenchItem(ModItemTier.DEBUG_WRENCH, 1f, -2f, new HashSet<>(), ModRarities.LIGHT_PURPLE, false, true, TipLines.TWO, false, new Item.Properties().group(ModItemGroups.TAB_CORE)));
	
	public static void register(IEventBus enevtBus)
	{
		ITEMS.register(enevtBus);
		
		if (CoreConfig.general_logging.get()) {OedldoedlCore.LOGGER.info("Registerd Items for " + OedldoedlCore.MODID + "!");}
	}
}