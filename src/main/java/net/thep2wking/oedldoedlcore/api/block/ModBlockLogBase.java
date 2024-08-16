package net.thep2wking.oedldoedlcore.api.block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlcore.util.ModRegistryHelper;
import net.thep2wking.oedldoedlcore.util.ModToolTypes;

/**
 * @author TheP2WKing
 */
public class ModBlockLogBase extends ModBlockRotatedPillarBase {
	public static final PropertyEnum<ModBlockLogBase.EnumAxis> LOG_AXIS = PropertyEnum.<ModBlockLogBase.EnumAxis>create(
			"axis", ModBlockLogBase.EnumAxis.class);

	/**
	 * @author TheP2WKing
	 * @param modid        String
	 * @param name         String
	 * @param tab          {@link CreativeTabs}
	 * @param material     {@link Material}
	 * @param sound        {@link SoundType}
	 * @param mapColor     {@link MapColor}
	 * @param harvestLevel int
	 * @param toolType     {@link ModToolTypes}
	 * @param hardness     float
	 * @param resistance   float
	 * @param lightLevel   int
	 */
	public ModBlockLogBase(String modid, String name, CreativeTabs tab, Material material, SoundType sound,
			MapColor mapColor, int harvestLevel, ModToolTypes toolType, float hardness, float resistance,
			int lightLevel) {
		super(modid, name, tab, material, sound, mapColor, harvestLevel, toolType, hardness, resistance, lightLevel);
		this.setDefaultState(this.blockState.getBaseState().withProperty(LOG_AXIS, ModBlockLogBase.EnumAxis.Y));
		ModRegistryHelper.registerFlameableBlock(this, 5, 5);
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { LOG_AXIS });
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(LOG_AXIS).ordinal();
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(LOG_AXIS, EnumAxis.values()[meta]);
	}

	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		if (worldIn.isAreaLoaded(pos.add(-5, -5, -5), pos.add(5, 5, 5))) {
			for (BlockPos blockpos : BlockPos.getAllInBox(pos.add(-4, -4, -4), pos.add(4, 4, 4))) {
				IBlockState iblockstate = worldIn.getBlockState(blockpos);
				if (iblockstate.getBlock().isLeaves(iblockstate, worldIn, blockpos)) {
					iblockstate.getBlock().beginLeavesDecay(iblockstate, worldIn, blockpos);
				}
			}
		}
	}

	@Override
	public boolean isFlammable(IBlockAccess world, BlockPos pos, EnumFacing face) {
		return true;
	}

	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY,
			float hitZ, int meta, EntityLivingBase placer) {
		return this.getStateFromMeta(meta).withProperty(LOG_AXIS,
				ModBlockLogBase.EnumAxis.fromFacingAxis(facing.getAxis()));
	}

	@Override
	public IBlockState withRotation(IBlockState state, Rotation rot) {
		switch (rot) {
			case COUNTERCLOCKWISE_90:
			case CLOCKWISE_90:
				switch ((ModBlockLogBase.EnumAxis) state.getValue(LOG_AXIS)) {
					case X:
						return state.withProperty(LOG_AXIS, ModBlockLogBase.EnumAxis.Z);
					case Z:
						return state.withProperty(LOG_AXIS, ModBlockLogBase.EnumAxis.X);
					default:
						return state;
				}
			default:
				return state;
		}
	}

	@Override
	public boolean canSustainLeaves(IBlockState state, net.minecraft.world.IBlockAccess world, BlockPos pos) {
		return true;
	}

	@Override
	public boolean isWood(net.minecraft.world.IBlockAccess world, BlockPos pos) {
		return true;
	}

	public static enum EnumAxis implements IStringSerializable {
		X("x"),
		Y("y"),
		Z("z"),
		NONE("none");

		private final String name;

		private EnumAxis(String name) {
			this.name = name;
		}

		public String toString() {
			return this.name;
		}

		public static ModBlockLogBase.EnumAxis fromFacingAxis(EnumFacing.Axis axis) {
			switch (axis) {
				case X:
					return X;
				case Y:
					return Y;
				case Z:
					return Z;
				default:
					return NONE;
			}
		}

		public String getName() {
			return this.name;
		}
	}
}