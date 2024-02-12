package net.thep2wking.oedldoedlcore.api.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @author TheP2WKing
 */
@SideOnly(Side.CLIENT)
public class ModEntityRenderBase<T extends EntityLiving> extends RenderLiving<T> {
	public final String modid;
	public final String name;

	public ModEntityRenderBase(String modid, String name, RenderManager renderManager, ModelBase model, float shadowSize) {
		super(renderManager, model, shadowSize);
		this.modid = modid;
		this.name = name;
	}

	@Override
	public ResourceLocation getEntityTexture(T entity) {
		return new ResourceLocation(modid, "textures/entity/" + name + ".png");
	}
}