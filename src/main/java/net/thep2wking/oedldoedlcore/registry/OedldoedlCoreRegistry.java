package net.thep2wking.oedldoedlcore.registry;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.thep2wking.oedldoedlcore.OedldoedlCore;
import net.thep2wking.oedldoedlcore.init.OedldoedlCoreBlocks;
import net.thep2wking.oedldoedlcore.init.OedldoedlCoreItems;
import net.thep2wking.oedldoedlcore.util.IHasModel;
import net.thep2wking.oedldoedlcore.util.ModRegistryHelper;

@Mod.EventBusSubscriber
public class OedldoedlCoreRegistry {
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event) {
		OedldoedlCore.LOGGER.info("Registered blocks");
	}

	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event) {
		OedldoedlCore.LOGGER.info("Registered items");

		ModRegistryHelper.registerItem(event, OedldoedlCoreItems.CORE_ICON);
		ModRegistryHelper.registerItem(event, OedldoedlCoreItems.RESOURCES_ICON);
		ModRegistryHelper.registerItem(event, OedldoedlCoreItems.GEAR_ICON);
		ModRegistryHelper.registerItem(event, OedldoedlCoreItems.CURIOSITY_ICON);
		ModRegistryHelper.registerItem(event, OedldoedlCoreItems.CONSTRUCT_ICON);
		ModRegistryHelper.registerItem(event, OedldoedlCoreItems.MUSIC_ICON);
		ModRegistryHelper.registerItem(event, OedldoedlCoreItems.INTEGRATION_ICON);
	}

	public static void preInitRegistries(FMLPreInitializationEvent event) {
	}

	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event) {
		for (Block block : OedldoedlCoreBlocks.BLOCKS) {
			if (block instanceof IHasModel) {
				((IHasModel) block).registerModels();
			}
		}

		for (Item item : OedldoedlCoreItems.ITEMS) {
			if (item instanceof IHasModel) {
				((IHasModel) item).registerModels();
			}
		}
	}
}