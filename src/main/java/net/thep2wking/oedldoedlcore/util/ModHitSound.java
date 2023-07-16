package net.thep2wking.oedldoedlcore.util;

import net.minecraft.util.SoundEvent;
import net.thep2wking.oedldoedlcore.init.ModSounds;

/**
 * @author TheP2WKing
 */
public enum ModHitSound {
	WOOD("smash_wood", ModSounds.SMASH_WOOD),
	METAL("smash_metal", ModSounds.SMASH_METAL),
	GEM("smash_gem", ModSounds.SMASH_GEM),
	;

	private String hitSoundName;
	private SoundEvent hitSound;

	ModHitSound(String hitSoundName, SoundEvent hitSound) {
		this.hitSoundName = hitSoundName;
		this.hitSound = hitSound;
	}

	// get sound name
	public String getHitSoundName() {
		return hitSoundName;
	}

	// get soundevent
	public SoundEvent getHitSound() {
		return hitSound;
	}
}