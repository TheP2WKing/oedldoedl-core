package net.thep2wking.oedldoedlcore.util;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;

/**
 * @author TheP2WKing
 */
public class ModRegistryHelper {
    // registering
    public static void registerBlock(RegistryEvent.Register<Block> event, Block block) {
        event.getRegistry().register(block);
    }

    public static void registerItem(RegistryEvent.Register<Item> event, Item item) {
        event.getRegistry().register(item);
        registerItemRender(item);
    }

    public static void registerItemBlock(RegistryEvent.Register<Item> event, Item itemBlock) {
        event.getRegistry().register(itemBlock);
        registerItemRender(itemBlock);
    }

    public static void registerFluid(Fluid fluid) {
        FluidRegistry.registerFluid(fluid);
        FluidRegistry.addBucketForFluid(fluid);
    }

    public static void registerSoundEvent(RegistryEvent.Register<SoundEvent> event, SoundEvent soundEvent) {
        event.getRegistry().register(soundEvent);
    }

    public static void registerEntity(String modid, String name, Object instance, int id,
            Class<? extends Entity> entity, int trackingRange, int updateFrequency, boolean velocityUpdates) {
        EntityRegistry.registerModEntity(new ResourceLocation(modid, name), entity, modid + "." + name, id, instance,
                trackingRange, updateFrequency, velocityUpdates);
    }

    public static void registerEntityWithSpawnEgg(String modid, String name, Object instance, int id,
            Class<? extends Entity> entity, int trackingRange, int updateFrequency, boolean velocityUpdates,
            int colorPrimary, int colorSecondary) {
        EntityRegistry.registerModEntity(new ResourceLocation(modid, name), entity, modid + "." + name, id, instance,
                trackingRange, updateFrequency, velocityUpdates, colorPrimary, colorSecondary);
    }

    // rendering
    public static void registerItemRender(Item item) {
        ModelLoader.setCustomModelResourceLocation(item, 0,
                new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }
}