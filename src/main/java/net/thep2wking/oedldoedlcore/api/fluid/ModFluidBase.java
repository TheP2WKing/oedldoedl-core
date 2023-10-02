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
	public final boolean isGaseous;
	public final EnumRarity rarity;

	/**
	 * @author TheP2WKing
	 * @param modid       String
	 * @param name        String
	 * @param still       {@link ResourceLocation}
	 * @param flow        {@link ResourceLocation}
	 * @param color       int
	 * @param temperature int
	 * @param density     int
	 * @param viscosity   int
	 * @param luminosity  int
	 * @param isGaseous   boolean
	 * @param rarity      {@link EnumRarity}
	 */
	public ModFluidBase(String modid, String name, ResourceLocation still, ResourceLocation flow, int color,
			int temperature, int density, int viscosity, int luminosity, boolean isGaseous, EnumRarity rarity) {
		super(name, still, flow, color);
		this.modid = modid;
		this.temperature = temperature;
		this.density = density;
		this.viscosity = viscosity;
		this.luminosity = luminosity;
		this.isGaseous = isGaseous;
		this.rarity = rarity;
		setUnlocalizedName(this.modid + "." + name);
		setColor(this.color);
		setTemperature(this.temperature);
		setDensity(this.density);
		setViscosity(this.viscosity);
		setLuminosity(this.luminosity);
		if (((color >> 24) & 0xFF) == 0) {
			color |= 0xFF << 24;
		}
		this.color = color;
	}

	@Override
	public boolean isGaseous(FluidStack stack) {
		return isGaseous;
	}

	@Override
	public EnumRarity getRarity() {
		return rarity;
	}

	@Override
	public int getColor() {
		return color;
	}
}