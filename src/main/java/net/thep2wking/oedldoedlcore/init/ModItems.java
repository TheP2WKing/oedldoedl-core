package net.thep2wking.oedldoedlcore.init;

import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.thep2wking.oedldoedlcore.OedldoedlCore;
import net.thep2wking.oedldoedlcore.config.CoreConfigLogging;
import net.thep2wking.oedldoedlcore.content.items.ConstructIconItem;
import net.thep2wking.oedldoedlcore.content.items.CoreIconItem;
import net.thep2wking.oedldoedlcore.content.items.GearIconItem;
import net.thep2wking.oedldoedlcore.content.items.IntegrationIconItem;
import net.thep2wking.oedldoedlcore.content.items.MusicIconItem;
import net.thep2wking.oedldoedlcore.content.items.ResourcesIconItem;

public class ModItems 
{
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, OedldoedlCore.MODID);
	
	public static final RegistryObject<Item> ITEM_CORE_ICON= ITEMS.register("core_icon", () -> new CoreIconItem(new Item.Properties()));
	public static final RegistryObject<Item> ITEM_RESOURCES_ICON = ITEMS.register("resources_icon", () -> new ResourcesIconItem(new Item.Properties()));
	public static final RegistryObject<Item> ITEM_GEAR_ICON = ITEMS.register("gear_icon", () -> new GearIconItem(new Item.Properties()));
	public static final RegistryObject<Item> ITEM_CONSTRUCT_ICON = ITEMS.register("construct_icon", () -> new ConstructIconItem(new Item.Properties()));
	public static final RegistryObject<Item> ITEM_MUSIC_ICON = ITEMS.register("music_icon", () -> new MusicIconItem(new Item.Properties()));
	public static final RegistryObject<Item> ITEM_INTEGRATION_ICON = ITEMS.register("integration_icon", () -> new IntegrationIconItem(new Item.Properties()));
	
	public static void register(IEventBus enevtBus)
	{
		ITEMS.register(enevtBus);
		
    	if (CoreConfigLogging.general.get())
    	{
    		OedldoedlCore.LOGGER.info("Items Registerd!");
    	}
	}
}