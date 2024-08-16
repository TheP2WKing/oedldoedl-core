package net.thep2wking.oedldoedlcore.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import codechicken.lib.model.ModelRegistryHelper;
import codechicken.lib.render.item.IItemRenderer;
import codechicken.lib.texture.TextureUtils;
import codechicken.lib.util.ClientUtils;
import codechicken.lib.util.TransformUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.block.model.ItemOverrideList;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.model.IModelState;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thep2wking.oedldoedlcore.OedldoedlCore;
import net.thep2wking.oedldoedlcore.config.CoreConfig;
import net.thep2wking.oedldoedlcore.config.categories.Content.Spawner.SpawnerEntitySize;
import net.thep2wking.oedldoedlcore.content.itemblock.ItemBlockMobSpawner;
import net.thep2wking.oedldoedlcore.init.ModItems;

/**
 * @author TheP2WKing
 */
@SideOnly(Side.CLIENT)
public class ModMobSpawnerRenderer implements IItemRenderer {
	private static Set<Entity> brokenMobs = new HashSet<>();
	private static List<String> randomDisplayList = null;

	@Override
	public boolean isAmbientOcclusion() {
		return false;
	}

	@Override
	public boolean isGui3d() {
		return true;
	}

	@Override
	public IModelState getTransforms() {
		return TransformUtils.DEFAULT_BLOCK;
	}

	@Override
	public boolean isBuiltInRenderer() {
		return true;
	}

	@Override
	public TextureAtlasSprite getParticleTexture() {
		return TextureUtils.getBlockTexture("mob_spawner");
	}

	@Override
	public ItemCameraTransforms getItemCameraTransforms() {
		return ItemCameraTransforms.DEFAULT;
	}

	@Override
	public ItemOverrideList getOverrides() {
		return ItemOverrideList.NONE;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void renderItem(ItemStack item, ItemCameraTransforms.TransformType transformType) {
		Minecraft minecraft = Minecraft.getMinecraft();
		IBakedModel baseModel = minecraft.getRenderItem().getItemModelMesher().getModelManager()
				.getModel(new ModelResourceLocation("mob_spawner"));
		GlStateManager.pushMatrix();
		GlStateManager.translate(0.5, 0.5, 0.5);
		minecraft.getRenderItem().renderItem(item, baseModel);
		GlStateManager.popMatrix();

		if (CoreConfig.CONTENT.SPAWNER.ENTITY_RENDERER && Loader.isModLoaded("codechickenlib")) {
			ItemBlockMobSpawner itemBlockMobSpawner = (ItemBlockMobSpawner) ModItems.MOB_SPAWNER;
			Entity entity = null;
			try {
				entity = itemBlockMobSpawner.getRenderEntity(item);
				if (entity == null) {
					// entity = new EntityPig(ClientUtils.getWorld());
					return;
				}
			} catch (NullPointerException e) {
				return;
			}

			if (brokenMobs.contains(entity))
				return;

			try {
				GlStateManager.pushMatrix();

				float scale = 0;
				if (CoreConfig.CONTENT.SPAWNER.ENTITY_SIZE == SpawnerEntitySize.CALCULATED) {
					scale = 0.6F / Math.max(entity.width, entity.height);
				} else if (CoreConfig.CONTENT.SPAWNER.ENTITY_SIZE == SpawnerEntitySize.FIXED) {
					scale = 0.4375F;
					if (entity.width > 1.5) {
						scale = 0.15F;
					} else if (entity.width > 16) {
						scale = 0.05F;
					}
				}

				GlStateManager.translate(0.5, 0.175, 0.5);
				GlStateManager.scale(scale, scale, scale);

				GlStateManager.rotate((float) (ClientUtils.getRenderTime() * 10), 0, 1, 0);
				GlStateManager.rotate(-20, 1, 0, 0);

				RenderManager rendermanager = Minecraft.getMinecraft().getRenderManager();
				if (CoreConfig.CONTENT.SPAWNER.ENTITY_RENDERER) {
					rendermanager.renderEntity(entity, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F, false);
				}

				GlStateManager.enableRescaleNormal();
				GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
				GlStateManager.disableTexture2D();
				GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
				GlStateManager.disableLighting();

				GlStateManager.enableBlend();
				GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA,
						GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE,
						GlStateManager.DestFactor.ZERO);
				GlStateManager.popMatrix();
			} catch (Throwable e) {
				if (randomDisplayList != null) {
					randomDisplayList.remove(EntityList.getEntityString(entity));
				} else {
					brokenMobs.add(entity);
					e.printStackTrace();
				}
			}
		}
	}

	public static void registerMobSpawnerRenderer() {
		if (CoreConfig.CONTENT.SPAWNER.ENTITY_RENDERER) {
			ModelRegistryHelper.registerItemRenderer(ModItems.MOB_SPAWNER, new ModMobSpawnerRenderer());
			if (CoreConfig.LOGGING.CONSOLE_LOGGING) {
				ModLogger.LOGGER.info("Registered spawner renderer for " + OedldoedlCore.MODID);
			}
		}
	}
}