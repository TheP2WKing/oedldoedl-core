package net.thep2wking.oedldoedlcore.api;

import java.util.function.Supplier;

import net.minecraft.block.BlockState;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class ModFlowingFluidBlockBase extends FlowingFluidBlock {
	public int lightLevel;

	/**
	 * @author TheP2WKing
	 * @param supplier   {@link Supplier}
	 * @param lightLevel int
	 * @param properties {@link Properties}
	 */
	public ModFlowingFluidBlockBase(Supplier<? extends FlowingFluid> supplier, int lightLevel, Properties properties) {
		super(supplier, properties.hardnessAndResistance(100f).doesNotBlockMovement().noDrops());
		this.lightLevel = lightLevel;
	}

	@Override
	public int getLightValue(BlockState state, IBlockReader world, BlockPos pos) {
		return lightLevel;
	}
}