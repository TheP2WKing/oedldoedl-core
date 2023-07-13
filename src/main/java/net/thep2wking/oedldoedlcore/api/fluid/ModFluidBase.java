package net.thep2wking.oedldoedlcore.api.fluid;

import net.minecraft.item.EnumRarity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

/**
 * @author TheP2WKing
 */
public class ModFluidBase extends Fluid {
	public final String modid;
	public final int temperature;
	public final int density;
	public final int viscosity;
	public final int luminosity;
	public final boolean gaseous;
	public final EnumRarity rarity;

	public ModFluidBase(String modid, String name, ResourceLocation still, ResourceLocation flow, int color,
			int temperature, int density, int viscosity, int luminosity, boolean gaseous, EnumRarity rarity) {
		super(name, still, flow, color);
		this.modid = modid;
		this.temperature = temperature;
		this.density = density;
		this.viscosity = viscosity;
		this.luminosity = luminosity;
		this.gaseous = gaseous;
		this.rarity = rarity;
		setUnlocalizedName(this.modid + "." + name);
		setColor(this.color);
		setTemperature(this.temperature);
		setDensity(this.density);
		setViscosity(this.viscosity);
		setLuminosity(this.luminosity);
		setRarity(this.rarity);
	}

	@Override
	public boolean isGaseous(FluidStack stack) {
		return this.gaseous;
	}
}