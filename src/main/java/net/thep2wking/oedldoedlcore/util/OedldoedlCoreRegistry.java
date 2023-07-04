package net.thep2wking.oedldoedlcore.util;

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
import net.thep2wking.oedldoedlcore.util.handler.IHasModel;

@Mod.EventBusSubscriber
public class OedldoedlCoreRegistry {
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event) {
		OedldoedlCore.LOGGER.info("Registered blocks");
	}

	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event) {
		OedldoedlCore.LOGGER.info("Registered items");
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