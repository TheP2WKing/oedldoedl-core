package net.thep2wking.oedldoedlcore.util;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.thep2wking.oedldoedlcore.OedldoedlCore;

public class ModFluidUtil {
	// fluid base resource locations
	public static final ResourceLocation LIQUID_STILL_BASE = new ResourceLocation(OedldoedlCore.MODID,
			"blocks/liquid_still");
	public static final ResourceLocation LIQUID_FLOW_BASE = new ResourceLocation(OedldoedlCore.MODID,
			"blocks/liquid_flow");

	public static final ResourceLocation MOLTEN_STILL_BASE = new ResourceLocation(OedldoedlCore.MODID,
			"blocks/molten_still");
	public static final ResourceLocation MOLTEN_FLOW_BASE = new ResourceLocation(OedldoedlCore.MODID,
			"blocks/molten_flow");

	// fluid render
	public static void addRenderForFluid(String fluidName, Block block) {
		Item fluidItem = Item.getItemFromBlock(block);
		final ModelResourceLocation modelLocation = new ModelResourceLocation(fluidName, "fluid");

		ModelLoader.setCustomMeshDefinition(fluidItem, new ItemMeshDefinition() {
			public ModelResourceLocation getModelLocation(ItemStack stack) {
				return modelLocation;
			}
		});

		ModelLoader.setCustomStateMapper(block, new StateMapperBase() {
			protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
				return modelLocation;
			}
		});
	}
}
