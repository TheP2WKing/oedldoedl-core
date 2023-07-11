package net.thep2wking.oedldoedlcore.registry;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.thep2wking.oedldoedlcore.OedldoedlCore;
import net.thep2wking.oedldoedlcore.init.ModItems;
import net.thep2wking.oedldoedlcore.util.ModLogger;
import net.thep2wking.oedldoedlcore.util.ModRegistryHelper;

@Mod.EventBusSubscriber
public class ModRegistry {
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event) {
		ModLogger.registeredBlocksLogger(OedldoedlCore.MODID);
	}

	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event) {
		ModLogger.registeredItemsLogger(OedldoedlCore.MODID);

		ModRegistryHelper.registerItem(event, ModItems.CORE_ICON);
		ModRegistryHelper.registerItem(event, ModItems.RESOURCES_ICON);
		ModRegistryHelper.registerItem(event, ModItems.GEAR_ICON);
		ModRegistryHelper.registerItem(event, ModItems.CURIOSITY_ICON);
		ModRegistryHelper.registerItem(event, ModItems.CONSTRUCT_ICON);
		ModRegistryHelper.registerItem(event, ModItems.MUSIC_ICON);
		ModRegistryHelper.registerItem(event, ModItems.INTEGRATION_ICON);
	}
}