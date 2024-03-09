package net.thep2wking.oedldoedlcore.registry;

import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionType;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.thep2wking.oedldoedlcore.OedldoedlCore;
import net.thep2wking.oedldoedlcore.init.ModItems;
import net.thep2wking.oedldoedlcore.init.ModPotions;
import net.thep2wking.oedldoedlcore.init.ModSounds;
import net.thep2wking.oedldoedlcore.util.ModEntityUtil;
import net.thep2wking.oedldoedlcore.util.ModLogger;
import net.thep2wking.oedldoedlcore.util.ModRegistryHelper;

@Mod.EventBusSubscriber
public class ModRegistry {
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event) {
		ModRegistryHelper.registerModels(event, OedldoedlCore.MODID);
	}

	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event) {
		ModLogger.registeredItemsLogger(OedldoedlCore.MODID);

		ModRegistryHelper.registerItem(event, ModItems.CORE_ICON);
		ModRegistryHelper.registerItem(event, ModItems.RESOURCES_ICON);
		ModRegistryHelper.registerItem(event, ModItems.GEAR_ICON);
		ModRegistryHelper.registerItem(event, ModItems.CURIOSITY_ICON);
		ModRegistryHelper.registerItem(event, ModItems.CONSTRUCT_ICON);
		ModRegistryHelper.registerItem(event, ModItems.EXPLOSIVES_ICON);
		ModRegistryHelper.registerItem(event, ModItems.TECHNOLOGY_ICON);
		ModRegistryHelper.registerItem(event, ModItems.MUSIC_ICON);
		ModRegistryHelper.registerItem(event, ModItems.INTEGRATION_ICON);
		
		ModRegistryHelper.registerItem(event, ModItems.DEBUG_STICK);
	}

	@SubscribeEvent
	public static void onSoundEventRegister(RegistryEvent.Register<SoundEvent> event) {
		ModLogger.registeredSoundEventsLogger(OedldoedlCore.MODID);

		ModRegistryHelper.registerSoundEvent(event, ModSounds.SMASH_WOOD);
		ModRegistryHelper.registerSoundEvent(event, ModSounds.SMASH_METAL);
		ModRegistryHelper.registerSoundEvent(event, ModSounds.SMASH_GEM);
	}

	@SubscribeEvent
	public static void onPotionRegister(RegistryEvent.Register<Potion> event) {
		ModLogger.registeredPotionsLogger(OedldoedlCore.MODID);

		event.getRegistry().register(ModPotions.SLOW_FALLING);
		event.getRegistry().register(ModPotions.DOLPHIN_GRACE);
		event.getRegistry().register(ModPotions.FLIGHT);
	}

	@SubscribeEvent
	public static void onPotionTypeRegister(RegistryEvent.Register<PotionType> event) {
		ModLogger.registeredPotionTypesLogger(OedldoedlCore.MODID);

		event.getRegistry().register(ModPotions.SLOW_FALLING_NORMAL);
		event.getRegistry().register(ModPotions.SLOW_FALLING_LONG);

		event.getRegistry().register(ModPotions.DOLPHIN_GRACE_NORMAL);
		event.getRegistry().register(ModPotions.DOLPHIN_GRACE_LONG);
		event.getRegistry().register(ModPotions.DOLPHIN_GRACE_STRONG);

		event.getRegistry().register(ModPotions.FLIGHT_NORMAL);
		event.getRegistry().register(ModPotions.FLIGHT_LONG);
	}

	public static void registerSpawnEggs() {
		ModEntityUtil.addSpawnEgg("minecraft", "ender_dragon", 0x1c1c1c, 0xe079fa);
        ModEntityUtil.addSpawnEgg("minecraft", "giant", 0x00afaf, 0x799c65);
        ModEntityUtil.addSpawnEgg("minecraft", "illusion_illager", 0x959b9b, 0x0e406c);
        ModEntityUtil.addSpawnEgg("minecraft", "snowman", 0xd9f2f2, 0x81a4a4);
        ModEntityUtil.addSpawnEgg("minecraft", "villager_golem", 0xdbcdc2, 0x74a332);
        ModEntityUtil.addSpawnEgg("minecraft", "wither", 0x141414, 0x4d72a0);
	}
}