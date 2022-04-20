package net.thep2wking.oedldoedlcore.api;

import java.util.Random;

import net.minecraft.block.BlockState;
import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.common.ToolType;
import net.thep2wking.oedldoedlcore.config.CoreConfig;

public class ModOreBlockBase extends OreBlock {
	public SoundType sound = SoundType.STONE;
	public int harvestLevel = -1;
	public float hardness;
	public float resistance;
	public ToolType toolType;
	public int lightLevel;
	public int minXp;
	public int maxXp;

	/**
	 * @param sound        {@link SoundType}
	 * @param harvestLevel int
	 * @param hardness     float
	 * @param resistance   float
	 * @param toolType     {@link ToolType}
	 * @param lightLevel   int
	 * @param minXp        int
	 * @param maxXp        int
	 * @param properties   {@link Properties}
	 */
	public ModOreBlockBase(SoundType sound, int harvestLevel, float hardness, float resistance, ToolType toolType,
			int lightLevel, int minXp, int maxXp, Properties properties) {
		super(properties.harvestTool(toolType).setRequiresTool().hardnessAndResistance(hardness, resistance));
		this.sound = sound;
		this.harvestLevel = harvestLevel;
		this.hardness = hardness;
		this.resistance = resistance;
		this.toolType = toolType;
		this.lightLevel = lightLevel;
		this.minXp = minXp;
		this.maxXp = maxXp;
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

	@Override
	public int getExperience(Random rand) {
		if (CoreConfig.blocks_drop_experience.get()) {
			return MathHelper.nextInt(rand, minXp, maxXp);
		}
		return 0;
	}

	@Override
	public int getExpDrop(BlockState state, IWorldReader world, BlockPos pos, int fortune, int silktouch) {
		return silktouch == 0 ? this.getExperience(RANDOM) : 0;
	}
}