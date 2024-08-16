package net.thep2wking.oedldoedlcore.util.world;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.BlockVine;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.thep2wking.oedldoedlcore.api.block.ModBlockLeavesBase;

/**
 * @author TheP2WKing
 */
public class ModWorldGenBasicTreeBase extends WorldGenAbstractTree {
	public final Block logBlock;
	public final Block leavesBlock;
	public final int minTreeHeight;
	public final boolean vinesGrow;

	/**
	 * @author TheP2WKing
	 * @param notify      boolean
	 * @param minHeight   int
	 * @param logBlock    {@link Block}
	 * @param leavesBlock {@link Block}
	 * @param growVines   boolean
	 */
	public ModWorldGenBasicTreeBase(boolean notify, int minHeight, Block logBlock, Block leavesBlock,
			boolean growVines) {
		super(notify);
		this.logBlock = logBlock;
		this.leavesBlock = leavesBlock;
		this.minTreeHeight = minHeight;
		this.vinesGrow = growVines;
	}

	/**
	 * @author TheP2WKing
	 * @param minHeight   int
	 * @param logBlock    {@link Block}
	 * @param leavesBlock {@link Block}
	 */
	public ModWorldGenBasicTreeBase(int minHeight, Block logBlock, Block leavesBlock) {
		this(true, minHeight, logBlock, leavesBlock, false);
	}

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		int i = rand.nextInt(3) + this.minTreeHeight;
		boolean flag = true;
		if (position.getY() >= 1 && position.getY() + i + 1 <= worldIn.getHeight()) {
			for (int j = position.getY(); j <= position.getY() + 1 + i; ++j) {
				int k = 1;
				if (j == position.getY()) {
					k = 0;
				}
				if (j >= position.getY() + 1 + i - 2) {
					k = 2;
				}
				BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
				for (int l = position.getX() - k; l <= position.getX() + k && flag; ++l) {
					for (int i1 = position.getZ() - k; i1 <= position.getZ() + k && flag; ++i1) {
						if (j >= 0 && j < worldIn.getHeight()) {
							if (!this.isReplaceable(worldIn, blockpos$mutableblockpos.setPos(l, j, i1))) {
								flag = false;
							}
						} else {
							flag = false;
						}
					}
				}
			}
			if (!flag) {
				return false;
			} else {
				IBlockState state = worldIn.getBlockState(position.down());
				if (state.getBlock().canSustainPlant(state, worldIn, position.down(), EnumFacing.UP,
						(BlockSapling) Blocks.SAPLING) && position.getY() < worldIn.getHeight() - i - 1) {
					state.getBlock().onPlantGrow(state, worldIn, position.down(), position);
					for (int i3 = position.getY() - 3 + i; i3 <= position.getY() + i; ++i3) {
						int i4 = i3 - (position.getY() + i);
						int j1 = 1 - i4 / 2;
						for (int k1 = position.getX() - j1; k1 <= position.getX() + j1; ++k1) {
							int l1 = k1 - position.getX();
							for (int i2 = position.getZ() - j1; i2 <= position.getZ() + j1; ++i2) {
								int j2 = i2 - position.getZ();
								if (Math.abs(l1) != j1 || Math.abs(j2) != j1 || rand.nextInt(2) != 0 && i4 != 0) {
									BlockPos blockpos = new BlockPos(k1, i3, i2);
									state = worldIn.getBlockState(blockpos);
									if (state.getBlock().isAir(state, worldIn, blockpos)
											|| state.getBlock().isLeaves(state, worldIn, blockpos)
											|| state.getMaterial() == Material.VINE) {
										this.setBlockAndNotifyAdequately(worldIn, blockpos,
												this.leavesBlock.getDefaultState().withProperty(
														ModBlockLeavesBase.CHECK_DECAY, Boolean.valueOf(false)));
									}
								}
							}
						}
					}

					for (int j3 = 0; j3 < i; ++j3) {
						BlockPos upN = position.up(j3);
						state = worldIn.getBlockState(upN);
						if (state.getBlock().isAir(state, worldIn, upN)
								|| state.getBlock().isLeaves(state, worldIn, upN)
								|| state.getMaterial() == Material.VINE) {
							this.setBlockAndNotifyAdequately(worldIn, position.up(j3), this.logBlock.getDefaultState());
							if (this.vinesGrow && j3 > 0) {
								if (rand.nextInt(3) > 0 && worldIn.isAirBlock(position.add(-1, j3, 0))) {
									this.addVine(worldIn, position.add(-1, j3, 0), BlockVine.EAST);
								}
								if (rand.nextInt(3) > 0 && worldIn.isAirBlock(position.add(1, j3, 0))) {
									this.addVine(worldIn, position.add(1, j3, 0), BlockVine.WEST);
								}
								if (rand.nextInt(3) > 0 && worldIn.isAirBlock(position.add(0, j3, -1))) {
									this.addVine(worldIn, position.add(0, j3, -1), BlockVine.SOUTH);
								}
								if (rand.nextInt(3) > 0 && worldIn.isAirBlock(position.add(0, j3, 1))) {
									this.addVine(worldIn, position.add(0, j3, 1), BlockVine.NORTH);
								}
							}
						}
					}

					if (this.vinesGrow) {
						for (int k3 = position.getY() - 3 + i; k3 <= position.getY() + i; ++k3) {
							int j4 = k3 - (position.getY() + i);
							int k4 = 2 - j4 / 2;
							BlockPos.MutableBlockPos blockpos$mutableblockpos1 = new BlockPos.MutableBlockPos();
							for (int l4 = position.getX() - k4; l4 <= position.getX() + k4; ++l4) {
								for (int i5 = position.getZ() - k4; i5 <= position.getZ() + k4; ++i5) {
									blockpos$mutableblockpos1.setPos(l4, k3, i5);
									state = worldIn.getBlockState(blockpos$mutableblockpos1);
									if (state.getBlock().isLeaves(state, worldIn, blockpos$mutableblockpos1)) {
										BlockPos blockpos2 = blockpos$mutableblockpos1.west();
										BlockPos blockpos3 = blockpos$mutableblockpos1.east();
										BlockPos blockpos4 = blockpos$mutableblockpos1.north();
										BlockPos blockpos1 = blockpos$mutableblockpos1.south();
										if (rand.nextInt(4) == 0 && worldIn.isAirBlock(blockpos2)) {
											this.addHangingVine(worldIn, blockpos2, BlockVine.EAST);
										}
										if (rand.nextInt(4) == 0 && worldIn.isAirBlock(blockpos3)) {
											this.addHangingVine(worldIn, blockpos3, BlockVine.WEST);
										}
										if (rand.nextInt(4) == 0 && worldIn.isAirBlock(blockpos4)) {
											this.addHangingVine(worldIn, blockpos4, BlockVine.SOUTH);
										}
										if (rand.nextInt(4) == 0 && worldIn.isAirBlock(blockpos1)) {
											this.addHangingVine(worldIn, blockpos1, BlockVine.NORTH);
										}
									}
								}
							}
						}
					}
					return true;
				} else {
					return false;
				}
			}
		} else {
			return false;
		}
	}

	private void addVine(World worldIn, BlockPos pos, PropertyBool prop) {
		this.setBlockAndNotifyAdequately(worldIn, pos,
				Blocks.VINE.getDefaultState().withProperty(prop, Boolean.valueOf(true)));
	}

	private void addHangingVine(World worldIn, BlockPos pos, PropertyBool prop) {
		this.addVine(worldIn, pos, prop);
		int i = 4;
		for (BlockPos blockpos = pos.down(); worldIn.isAirBlock(blockpos) && i > 0; --i) {
			this.addVine(worldIn, blockpos, prop);
			blockpos = blockpos.down();
		}
	}
}