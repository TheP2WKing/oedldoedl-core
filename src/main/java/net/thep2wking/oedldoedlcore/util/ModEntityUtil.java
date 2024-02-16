package net.thep2wking.oedldoedlcore.util;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModEntityUtil {
	// spawn eggs in creative tab
	@SideOnly(Side.CLIENT)
	public static void displaySpawnEggs(NonNullList<ItemStack> itemList, String modid) {
		for (ResourceLocation entityRL : EntityList.getEntityNameList()) {
			String entityDomain = entityRL.getResourceDomain();
            String entityPath = entityRL.getResourcePath();
            String entityName = entityDomain + ":" + entityPath;
			Entity entity = EntityList.createEntityByIDFromName(entityRL, Minecraft.getMinecraft().world);
            if (entity != null && entity instanceof EntityLivingBase && entityDomain.equals(modid)) {
				ItemStack itemstack = ModNBTUtil.addSpawnEgg(entityName);
				itemList.add(itemstack);
			}
		}
	}
}
