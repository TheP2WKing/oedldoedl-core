package net.thep2wking.oedldoedlcore.util;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @author TheP2WKing
 */
public class ModRenderHelper {
	// render throwable like snowball
	@SuppressWarnings("all")
	@SideOnly(Side.CLIENT)
	public static void addThrowableRender(Class<? extends Entity> entityClass, Item item) {
		RenderingRegistry.registerEntityRenderingHandler(entityClass, new RenderSnowball(
				Minecraft.getMinecraft().getRenderManager(), item, Minecraft.getMinecraft().getRenderItem()));
	}

	// render throwable like snowball
	@SuppressWarnings("all")
	@SideOnly(Side.CLIENT)
	public static void addThrowableRender(Class<? extends Entity> entityClass, Block block) {
		RenderingRegistry.registerEntityRenderingHandler(entityClass, new RenderSnowball(
				Minecraft.getMinecraft().getRenderManager(), Item.getItemFromBlock(block),
				Minecraft.getMinecraft().getRenderItem()));
	}

	// render entity
	@SuppressWarnings("all")
	@SideOnly(Side.CLIENT)
	public static void addEntityRender(Class<? extends Entity> entityClass, IRenderFactory<? super Entity> renderFactory) {
		RenderingRegistry.registerEntityRenderingHandler(entityClass, renderFactory);
	}
}
