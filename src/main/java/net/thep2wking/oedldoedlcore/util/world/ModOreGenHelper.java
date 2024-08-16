package net.thep2wking.oedldoedlcore.util.world;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * @author TheP2WKing
 */
public class ModOreGenHelper {
	public static void addOreGen(World world, Random random, int chunkX, int chunkZ, Block oreBlock,
			int veinSize, int chance, Block blockToReplace, int minHeight, int maxHeight, int dimension) {
		ModOreGenMinableBase generator = new ModOreGenMinableBase(oreBlock, veinSize, chance, blockToReplace, dimension);
		if (world.provider.getDimension() == dimension) {
			runOreGenerator(generator, world, random, chunkX, chunkZ, generator.chance, minHeight, maxHeight);
		}
	}

	public static void addOreGen(World world, Random random, int chunkX, int chunkZ, Block oreBlock,
			int veinSize, int chance, Block blockToReplace, int minHeight, int maxHeight, int dimension,
			boolean condition) {
		if (condition) {
			ModOreGenMinableBase generator = new ModOreGenMinableBase(oreBlock, veinSize, chance, blockToReplace, dimension);
			if (world.provider.getDimension() == dimension) {
				runOreGenerator(generator, world, random, chunkX, chunkZ, generator.chance, minHeight, maxHeight);
			}
		}
	}

	// add ore generation for overworld
	public static void addOreGenOverworld(World world, Random random, int chunkX, int chunkZ, Block oreBlock,
			int veinSize, int chance, int minHeight, int maxHeight) {
		addOreGen(world, random, chunkX, chunkZ, oreBlock, veinSize, chance, Blocks.STONE, minHeight, maxHeight,
				DimensionType.OVERWORLD.getId());
	}

	// add ore generation for overworld with condition
	public static void addOreGenOverworld(World world, Random random, int chunkX, int chunkZ, Block oreBlock,
			int veinSize, int chance, int minHeight, int maxHeight, boolean condition) {
		if (condition) {
			addOreGen(world, random, chunkX, chunkZ, oreBlock, veinSize, chance, Blocks.STONE, minHeight, maxHeight,
					DimensionType.OVERWORLD.getId());
		}
	}

	// add ore generation for overworld
	public static void addOreGenNether(World world, Random random, int chunkX, int chunkZ, Block oreBlock, int veinSize,
			int chance, int minHeight, int maxHeight) {
		addOreGen(world, random, chunkX, chunkZ, oreBlock, veinSize, chance, Blocks.NETHERRACK, minHeight, maxHeight,
				DimensionType.NETHER.getId());
	}

	// add ore generation for overworld with condition
	public static void addOreGenNether(World world, Random random, int chunkX, int chunkZ, Block oreBlock, int veinSize,
			int chance, int minHeight, int maxHeight, boolean condition) {
		if (condition) {
			addOreGen(world, random, chunkX, chunkZ, oreBlock, veinSize, chance, Blocks.NETHERRACK, minHeight,
					maxHeight, DimensionType.NETHER.getId());
		}
	}

	// add ore generation for overworld
	public static void addOreGenEnd(World world, Random random, int chunkX, int chunkZ, Block oreBlock, int veinSize,
			int chance, int minHeight, int maxHeight) {
		addOreGen(world, random, chunkX, chunkZ, oreBlock, veinSize, chance, Blocks.END_STONE, minHeight, maxHeight,
				DimensionType.THE_END.getId());
	}

	// add ore generation for overworld with condition
	public static void addOreGenEnd(World world, Random random, int chunkX, int chunkZ, Block oreBlock, int veinSize,
			int chance, int minHeight, int maxHeight, boolean condition) {
		if (condition) {
			addOreGen(world, random, chunkX, chunkZ, oreBlock, veinSize, chance, Blocks.END_STONE, minHeight, maxHeight,
					DimensionType.THE_END.getId());
		}
	}

	private static void runOreGenerator(WorldGenerator gen, World world, Random rand, int chunkX, int chunkZ,
			int chance,
			int minHeight, int maxHeight) {
		if (minHeight > maxHeight || minHeight < 0 || maxHeight > 256)
			throw new IllegalArgumentException("Ore generated out of bounds");

		int heightDiff = maxHeight - minHeight + 1;
		for (int i = 0; i < chance; i++) {
			int x = chunkX * 16 + rand.nextInt(16);
			int y = minHeight + rand.nextInt(heightDiff);
			int z = chunkZ * 16 + rand.nextInt(16);

			gen.generate(world, rand, new BlockPos(x, y, z));
		}
	}

	// register ore generator
	public static void registerOreGen(IWorldGenerator generator, int weight) {
		GameRegistry.registerWorldGenerator(generator, weight);
	}

	// register ore generator with default weight
	public static void registerOreGen(IWorldGenerator generator) {
		GameRegistry.registerWorldGenerator(generator, 0);
	}
}