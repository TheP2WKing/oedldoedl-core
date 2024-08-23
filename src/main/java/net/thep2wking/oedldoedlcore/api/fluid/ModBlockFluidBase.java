package net.thep2wking.oedldoedlcore.api.fluid;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving.SpawnPlacementType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @author TheP2WKing
 */
public class ModBlockFluidBase extends BlockFluidClassic {
	public final String modid;
	public final String name;
	public final int fogColor;

	/**
	 * @author TheP2WKing
	 * @param modid    String
	 * @param name     String
	 * @param material {@link Material}
	 * @param mapColor {@link MapColor}
	 */
	public ModBlockFluidBase(String modid, String name, Fluid fluid, Material material, MapColor mapColor) {
		super(fluid, material, mapColor);
		this.modid = modid;
		this.name = name;
		this.fogColor = 0;
		this.setHardness(100.0F);
		this.setResistance(500.0F);
		setUnlocalizedName(this.modid + "." + this.name);
		setRegistryName(this.modid + ":" + this.name);
	}

	/**
	 * @author TheP2WKing
	 * @param modid    String
	 * @param name     String
	 * @param fogColor int
	 * @param material {@link Material}
	 * @param mapColor {@link MapColor}
	 */
	public ModBlockFluidBase(String modid, String name, Fluid fluid, int fogColor, Material material,
			MapColor mapColor) {
		super(fluid, material, mapColor);
		this.modid = modid;
		this.name = name;
		this.fogColor = fogColor;
		this.setHardness(100.0F);
		this.setResistance(500.0F);
		setUnlocalizedName(this.modid + "." + this.name);
		setRegistryName(this.modid + ":" + this.name);
	}

	@Override
	public boolean canCreatureSpawn(IBlockState state, IBlockAccess world, BlockPos pos, SpawnPlacementType type) {
		return false;
	}

	public Vec3d getVecColorFromInt(int hexColor) {
		int red = (hexColor >> 16) & 0xFF;
		int green = (hexColor >> 8) & 0xFF;
		int blue = hexColor & 0xFF;
		double redNormalized = red / 255.0;
		double greenNormalized = green / 255.0;
		double blueNormalized = blue / 255.0;
		return new Vec3d(redNormalized, greenNormalized, blueNormalized);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Vec3d getFogColor(World world, BlockPos pos, IBlockState state, Entity entity, Vec3d originalColor,
			float partialTicks) {
		if (this.fogColor != 0) {
			return getVecColorFromInt(this.fogColor);
		} else {
			return super.getFogColor(world, pos, state, entity, originalColor, partialTicks);
		}
	}
}