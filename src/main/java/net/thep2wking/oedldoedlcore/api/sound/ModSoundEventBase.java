package net.thep2wking.oedldoedlcore.api.sound;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

/**
 * @author TheP2WKing
 */
public class ModSoundEventBase extends SoundEvent {
	public final String modid;
	public final String name;

	/**
	 * @author TheP2WKing
	 * @param modid String
	 * @param name  String
	 */
	public ModSoundEventBase(String modid, String name) {
		super(new ResourceLocation(modid, name));
		this.modid = modid;
		this.name = name;
		setRegistryName(this.modid + ":" + this.name);
	}
}