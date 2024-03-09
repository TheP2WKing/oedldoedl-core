package net.thep2wking.oedldoedlcore.util;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.ForgeModContainer;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fluids.UniversalBucket;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thep2wking.oedldoedlcore.OedldoedlCore;
import net.thep2wking.oedldoedlcore.config.CoreConfig;

/**
 * @author TheP2WKing
 */
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
	@SideOnly(Side.CLIENT)
	public static void addRenderForFluid(String modid, String name, Block block) {
		Item fluidItem = Item.getItemFromBlock(block);
		final ModelResourceLocation modelLocation = new ModelResourceLocation(modid + ":" + name, "fluid");

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

	// fluid bucket itemstack
	public static ItemStack addFluidBucket(Fluid bucketFluid) {
		return FluidUtil.getFilledBucket(new FluidStack(bucketFluid, Fluid.BUCKET_VOLUME));
	}

	// fluid buckets in creative tab
	@SuppressWarnings("all")
	@SideOnly(Side.CLIENT)
	public static void displayForgeBuckets(NonNullList<ItemStack> itemList, String modid) {
		if (CoreConfig.PROPERTIES.CREATIVE.ADD_FORGE_BUCKETS_TO_CREATIVE_TABS) {
			for (Fluid bucketFluid : FluidRegistry.getBucketFluids()) {
				if (bucketFluid.getBlock() != null
						&& bucketFluid.getBlock().getRegistryName().getResourceDomain().equals(modid)) {
					ItemStack itemstack = UniversalBucket.getFilledBucket(
							ForgeModContainer.getInstance().universalBucket,
							bucketFluid);
					itemList.add(itemstack);
				}
			}
		}
	}
}