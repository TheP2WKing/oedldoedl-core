package net.thep2wking.oedldoedlcore.api;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

public class ModBlockBase extends Block {
	public SoundType sound = SoundType.STONE;
	public int harvestLevel = -1;
	public float hardness;
	public float resistance;
	public ToolType toolType;
	public int lightLevel;

	/**
	 * @author TheP2WKing
	 * @param sound        {@link SoundType}
	 * @param harvestLevel int
	 * @param hardness     float
	 * @param resistance   float
	 * @param toolType     {@link ToolType}
	 * @param lightLevel   int
	 * @param properties   {@link Properties}
	 */
	public ModBlockBase(SoundType sound, int harvestLevel, float hardness, float resistance, ToolType toolType,
			int lightLevel, Properties properties) {
		super(properties.harvestTool(toolType).setRequiresTool().hardnessAndResistance(hardness, resistance));
		this.sound = sound;
		this.harvestLevel = harvestLevel;
		this.hardness = hardness;
		this.resistance = resistance;
		this.toolType = toolType;
		this.lightLevel = lightLevel;
	}

	@Override
	public SoundType getSoundType(BlockState state) {
		return sound;
	}

	@Override
	public int getHarvestLevel(BlockState state) {
		return harvestLevel;
	}

	@Override
	public int getLightValue(BlockState state, IBlockReader world, BlockPos pos) {
		return lightLevel;
	}
}