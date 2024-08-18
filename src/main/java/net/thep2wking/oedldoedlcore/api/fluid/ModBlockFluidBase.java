package net.thep2wking.oedldoedlcore.api.fluid;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLiving.SpawnPlacementType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

/**
 * @author TheP2WKing
 */
public class ModBlockFluidBase extends BlockFluidClassic {
	public final String modid;
	public final String name;

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
		setUnlocalizedName(this.modid + "." + this.name);
		setRegistryName(this.modid + ":" + this.name);
		setHardness(2000f);
	}

	@Override
	public boolean canCreatureSpawn(IBlockState state, IBlockAccess world, BlockPos pos, SpawnPlacementType type) {
		return false;
	}
}