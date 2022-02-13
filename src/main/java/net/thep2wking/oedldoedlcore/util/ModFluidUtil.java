package net.thep2wking.oedldoedlcore.util;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.fluids.FluidAttributes;
import net.thep2wking.oedldoedlcore.OedldoedlCore;

public class ModFluidUtil 
{
	//fluid textures
    public static final ResourceLocation LIQUID_STILL = new ResourceLocation("block/water_still");
    public static final ResourceLocation LIQUID_FLOW = new ResourceLocation("block/water_flow");
    
    public static final ResourceLocation MOLTEN_STILL = new ResourceLocation(OedldoedlCore.MODID, "block/molten_still");
    public static final ResourceLocation MOLTEN_FLOW = new ResourceLocation(OedldoedlCore.MODID, "block/molten_flow");
    
    //fluid builder
    public static FluidAttributes.Builder liquidFluidBuilder(int color) 
    {
        return FluidAttributes.builder(LIQUID_STILL, LIQUID_FLOW)
                .density(1000).viscosity(1000).luminosity(0).temperature(300).color(color)
                .sound(SoundEvents.ITEM_BUCKET_FILL, SoundEvents.ITEM_BUCKET_EMPTY);
    }

    public static FluidAttributes.Builder moltenFluidBuilder(int color) 
    {
        return FluidAttributes.builder(MOLTEN_STILL, MOLTEN_FLOW)
                .density(2000).viscosity(10000).luminosity(15).temperature(1000).color(color)
                .sound(SoundEvents.ITEM_BUCKET_FILL_LAVA, SoundEvents.ITEM_BUCKET_EMPTY_LAVA);
    }
}