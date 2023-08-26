package net.thep2wking.oedldoedlcore.api.integration.baubles;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @author TheP2WKing
 */
@SideOnly(Side.CLIENT)
public class ModModelBaubleBase extends ModelBiped {
	/**
	 * @author TheP2WKing
	 * @param modelSize     float
	 * @param modelOffset   float
	 * @param textureWidth  int
	 * @param textureHeight int
	 */
	public ModModelBaubleBase(float modelSize, float modelOffset, int textureWidth, int textureHeight) {
		super(modelSize, modelOffset, textureWidth, textureHeight);
	}

	/**
	 * @author TheP2WKing
	 * @param modelSize   float
	 * @param modelOffset float
	 */
	public ModModelBaubleBase(float modelSize, float modelOffset) {
		super(modelSize, modelOffset, 128, 128);
	}

	/**
	 * @author TheP2WKing
	 * @param modelSize   float
	 * @param modelOffset float
	 */
	public ModModelBaubleBase(float modelSize) {
		super(modelSize, 0, 128, 128);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
	}

	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
