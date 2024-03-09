package net.thep2wking.oedldoedlcore.util;

import net.minecraft.entity.EntityList;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thep2wking.oedldoedlcore.config.CoreConfig;

public class ModEntityUtil {
	// spawn eggs in creative tab
	@SideOnly(Side.CLIENT)
	public static void displaySpawnEggs(NonNullList<ItemStack> itemList, String modid) {
		if (CoreConfig.PROPERTIES.CREATIVE.ADD_SPAWN_EGGS_TO_CREATIVE_TABS) {
			for (ResourceLocation entityRL : EntityList.ENTITY_EGGS.keySet()) {
				String entityDomain = entityRL.getResourceDomain();
				String entityPath = entityRL.getResourcePath();
				String entityName = entityDomain + ":" + entityPath;
				if (entityDomain.equals(modid)) {
					ItemStack itemstack = ModNBTUtil.addSpawnEgg(entityName);
					itemList.add(itemstack);
				}
			}
		}
	}

	// register a spawn egg for an entity that does not have one
	public static EntityList.EntityEggInfo addSpawnEgg(String modid, String name, int primaryColor,
			int secondaryColor) {
		ResourceLocation resourcelocation = new ResourceLocation(modid, name);
		EntityList.EntityEggInfo egg = new EntityList.EntityEggInfo(resourcelocation, primaryColor, secondaryColor);
		EntityEntry entry = ForgeRegistries.ENTITIES.getValue(resourcelocation);
		if (entry != null)
			entry.setEgg(egg);
		return (EntityList.EntityEggInfo) EntityList.ENTITY_EGGS.put(resourcelocation, egg);
	}
}