package net.thep2wking.oedldoedlcore.util.world;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.common.collect.Lists;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

/**
 * @author TheP2WKing
 */
public class ModBiomeUtil {
	public static Biome addBasicBiome(Biome biome, String modid, String name, int weight, BiomeType biomeType,
			Type... types) {
		biome.setRegistryName(modid, name);
		ForgeRegistries.BIOMES.register(biome);
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addBiome(biomeType, new BiomeEntry(biome, weight));
		BiomeManager.addSpawnBiome(biome);
		return biome;
	}

	public static List<Biome> getBiomesFromRegistry() {
		List<Biome> biomes = Lists.newArrayList();
		Iterator<Biome> biomeList = Biome.REGISTRY.iterator();
		while (biomeList.hasNext()) {
			biomes.add(biomeList.next());
		}
		return biomes;
	}

	public static Biome[] getEntitySpawningBiomes(EnumCreatureType creatureType,
			Class<? extends EntityLivingBase> entity) {
		List<Biome> biomes = new ArrayList<Biome>();
		List<Biome> biomeList = getBiomesFromRegistry();
		for (Biome currentBiome : biomeList) {
			List<SpawnListEntry> spawnList = currentBiome.getSpawnableList(creatureType);
			for (SpawnListEntry spawnEntry : spawnList) {
				if (spawnEntry.entityClass == entity) {
					biomes.add(currentBiome);
				}
			}
		}
		return biomes.toArray(new Biome[biomes.size()]);
	}

	public static Biome[] getBiomesWithEntityType(Class<? extends Entity> entity, EnumCreatureType creatureType) {
		List<Biome> biomes = new ArrayList<>();
		for (Biome biome : Biome.REGISTRY) {
			List<SpawnListEntry> spawnList = biome.getSpawnableList(creatureType);
			for (SpawnListEntry entry : spawnList)
				if (entry.entityClass == entity) {
					biomes.add(biome);
					break;
				}
		}
		return biomes.toArray(new Biome[0]);
	}

	public static Biome[] getBiomesWithMonsters(Class<? extends Entity> monster) {
		return getBiomesWithEntityType(monster, EnumCreatureType.MONSTER);
	}

	public static Biome[] getBiomesWithCreatures(Class<? extends Entity> creature) {
		return getBiomesWithEntityType(creature, EnumCreatureType.CREATURE);
	}

	public static Biome[] getBiomesWithWaterCreatures(Class<? extends Entity> waterCreature) {
		return getBiomesWithEntityType(waterCreature, EnumCreatureType.WATER_CREATURE);
	}

	public static Biome[] getBiomesWithAmbientCreatures(Class<? extends Entity> ambientCreature) {
		return getBiomesWithEntityType(ambientCreature, EnumCreatureType.AMBIENT);
	}
}