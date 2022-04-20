package net.thep2wking.oedldoedlcore.init;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.thep2wking.oedldoedlcore.OedldoedlCore;

public class ModSounds {
	// deferred register
	public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS,
			OedldoedlCore.MODID);

	// sounds
	public static final RegistryObject<SoundEvent> SMASH_WOOD = registerSoundEvent("smash_wood");
	public static final RegistryObject<SoundEvent> SMASH_METAL = registerSoundEvent("smash_metal");
	public static final RegistryObject<SoundEvent> SMASH_GEM = registerSoundEvent("smash_gem");

	private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
		return SOUNDS.register(name, () -> new SoundEvent(new ResourceLocation(OedldoedlCore.MODID, name)));
	}

	public static void register(IEventBus eventBus) {
		SOUNDS.register(eventBus);

		OedldoedlCore.LOGGER.info("Registerd Sounds for " + OedldoedlCore.MODID + "!");
	}
}