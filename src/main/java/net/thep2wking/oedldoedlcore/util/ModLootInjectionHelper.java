package net.thep2wking.oedldoedlcore.util;

import java.lang.reflect.Field;
import java.util.List;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.LootTable;
import net.minecraft.world.storage.loot.LootTableManager;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

/**
 * @author TheP2WKing
 */
@SuppressWarnings("deprecation")
public class ModLootInjectionHelper {
	public static void injectLoot(LootTableLoadEvent event, ResourceLocation lootTable, ResourceLocation injectTable) {
		if (event.getName().equals(lootTable)) {
			LootTable table = event.getTable();
			LootTableManager manager = event.getLootTableManager();
			ResourceLocation customLootTable = injectTable;
			LootTable customTable = manager.getLootTableFromLocation(customLootTable);
			try {
				Field poolsField = ReflectionHelper.findField(LootTable.class, "pools", "field_186466_c");
				poolsField.setAccessible(true);
				@SuppressWarnings("unchecked")
				List<LootPool> pools = (List<LootPool>) poolsField.get(customTable);
				for (LootPool pool : pools) {
					if (!doesPoolExist(table, pool)) {
						@SuppressWarnings("unchecked")
						List<LootPool> targetPools = (List<LootPool>) poolsField.get(table);
						targetPools.add(pool);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private static boolean doesPoolExist(LootTable table, LootPool pool) {
		try {
			Field poolsField = ReflectionHelper.findField(LootTable.class, "pools", "field_186466_c");
			poolsField.setAccessible(true);
			@SuppressWarnings("unchecked")
			List<LootPool> existingPools = (List<LootPool>) poolsField.get(table);
			for (LootPool existingPool : existingPools) {
				if (existingPool.getName().equals(pool.getName())) {
					return true;
				}
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return false;
	}
}