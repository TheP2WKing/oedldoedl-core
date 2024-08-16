package net.thep2wking.oedldoedlcore.util.world;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Biomes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.thep2wking.oedldoedlcore.api.block.ModBlockPlantBase;

/**
 * @author TheP2WKing
 */
public class ModPlantGenHelper {
	public static void addFlowerGen(DecorateBiomeEvent.Decorate event, Block plantBlock, double chance, int dimension) {
		if (event.getType() != DecorateBiomeEvent.Decorate.EventType.FLOWERS)
			return;
		World world = event.getWorld();
		BlockPos start = event.getChunkPos().getBlock(8, 0, 8);
		Random random = event.getRand();
		if (world.provider.getDimension() == dimension) {
			int tries = random.nextInt(2);
			Biome biome = world.getBiome(start);
			if (biome == Biomes.MUTATED_FOREST) {
				tries *= 4;
			}
			for (int i = 0; i < tries; i++) {
				int x = start.getX() + random.nextInt(6) - random.nextInt(6);
				int z = start.getZ() + random.nextInt(6) - random.nextInt(6);
				BlockPos pos = world.getTopSolidOrLiquidBlock(new BlockPos(x, 0, z));
				if ((world.getBlockState(pos).getBlock().isReplaceable(world, pos))
						&& ((ModBlockPlantBase) plantBlock).canBlockStay(world, pos,
								plantBlock.getDefaultState())) {
					if (random.nextDouble() > chance)
						continue;
					world.setBlockState(pos, plantBlock.getDefaultState());
				}
			}
		}
	}

	public static void addFLowerGenOverworld(DecorateBiomeEvent.Decorate event, Block flowerBlock, double chance) {
		addFlowerGen(event, flowerBlock, chance, DimensionType.OVERWORLD.getId());
	}

	public static void addFLowerGenOverworld(DecorateBiomeEvent.Decorate event, Block flowerBlock, double chance,
			boolean condition) {
		if (condition) {
			addFlowerGen(event, flowerBlock, chance, DimensionType.OVERWORLD.getId());
		}
	}

	public static void addFLowerGenNether(DecorateBiomeEvent.Decorate event, Block flowerBlock, double chance) {
		addFlowerGen(event, flowerBlock, chance, DimensionType.NETHER.getId());
	}

	public static void addFLowerGenNether(DecorateBiomeEvent.Decorate event, Block flowerBlock, double chance,
			boolean condition) {
		if (condition) {
			addFlowerGen(event, flowerBlock, chance, DimensionType.NETHER.getId());
		}
	}

	public static void addFLowerGenEnd(DecorateBiomeEvent.Decorate event, Block flowerBlock, double chance) {
		addFlowerGen(event, flowerBlock, chance, DimensionType.THE_END.getId());
	}

	public static void addFLowerGenEnd(DecorateBiomeEvent.Decorate event, Block flowerBlock, double chance,
			boolean condition) {
		if (condition) {
			addFlowerGen(event, flowerBlock, chance, DimensionType.THE_END.getId());
		}
	}

	public static void registerFlowerGen(Object generator) {
		MinecraftForge.TERRAIN_GEN_BUS.register(generator);
	}
}