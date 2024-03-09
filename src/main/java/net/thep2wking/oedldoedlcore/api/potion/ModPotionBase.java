package net.thep2wking.oedldoedlcore.api.potion;

import net.minecraft.client.Minecraft;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;

public class ModPotionBase extends Potion {
	public final String modid;
	public final String name;
	public final int posX;
	public final int posY;

	public ModPotionBase(String modid, String name, boolean isBad, int color, int posX, int posY) {
		super(isBad, color);
		this.modid = modid;
		this.name = name;
		this.posX = posX;
		this.posY = posY;
		setPotionName(this.modid + "." + this.name);
		setRegistryName(this.modid + ":" + this.name);
		setIconIndex(posX, posY);
	}

	@Override
	public boolean isReady(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean hasStatusIcon() {
		Minecraft.getMinecraft().getTextureManager()
				.bindTexture(new ResourceLocation(modid, "textures/gui/inventory/potion_effects.png"));
		return true;
	}
}