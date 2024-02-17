package net.thep2wking.oedldoedlcore.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.common.collect.Lists;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;

/**
 * @author TheP2WKing
 */
public class ModBiomeUtils {
	public static List<Biome> getBiomesFromRegistry() {
		List<Biome> biomes = Lists.newArrayList();
		Iterator<Biome> biomeList = Biome.REGISTRY.iterator();
		while (biomeList.hasNext()) {
			biomes.add(biomeList.next());
		}
		return biomes;
	}

	public static Biome[] getEntitySpawningBiomes(EnumCreatureType creatureType, Class<? extends EntityLivingBase> entity) {
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
}