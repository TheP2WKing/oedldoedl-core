package net.thep2wking.oedldoedlcore.util;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;

/**
 * @author TheP2WKing
 */
public class ModNoModel extends ModelBiped {
	public static final ModelBiped NO_MODEL = new ModelBiped(0.0F);

	public ModNoModel() {
		super(0.0F, 0, 0, 0);
	}

	@Override
	public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch, float scale) {
	}
}