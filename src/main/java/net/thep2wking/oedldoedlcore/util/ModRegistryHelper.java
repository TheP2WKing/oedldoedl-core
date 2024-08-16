package net.thep2wking.oedldoedlcore.util;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @author TheP2WKing
 */
public class ModRegistryHelper {
    // register blocks
    public static void registerBlock(RegistryEvent.Register<Block> event, Block block) {
        event.getRegistry().register(block);
    }

    // register items
    public static void registerItem(RegistryEvent.Register<Item> event, Item item) {
        event.getRegistry().register(item);
    }

    public static void registerItemBlock(RegistryEvent.Register<Item> event, Item itemBlock) {
        event.getRegistry().register(itemBlock);
    }

    // register fluids
    public static void registerFluid(Fluid fluid) {
        FluidRegistry.registerFluid(fluid);
        FluidRegistry.addBucketForFluid(fluid);
    }

    // register sounds
    public static void registerSoundEvent(RegistryEvent.Register<SoundEvent> event, SoundEvent soundEvent) {
        event.getRegistry().register(soundEvent);
    }

    // register potions
    public static void registerPotion(RegistryEvent.Register<Potion> event, Potion potion) {
        event.getRegistry().register(potion);
    }

    // register potion types
    public static void registerPotionType(RegistryEvent.Register<PotionType> event, PotionType potion) {
        event.getRegistry().register(potion);
    }

    // register loot tables
    public static void registerLootTable(ResourceLocation lootTable) {
        LootTableList.register(lootTable);
    }

    // register entities
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

    // register entity spawning
    public static void registerEntitySpawn(Class<? extends EntityLiving> entity, EnumCreatureType creatureType,
            int weight, int min, int max, Biome... biomes) {
        EntityRegistry.addSpawn(entity, weight, min, max, creatureType, biomes);
    }

    public static void registerEntitySpawn(Class<? extends EntityLiving> entity, EnumCreatureType creatureType,
            int weight, int min, int max, boolean condition, Biome... biomes) {
        if (condition) {
            EntityRegistry.addSpawn(entity, weight, min, max, creatureType, biomes);
        }
    }

    // register flammable blocks
    public static void registerFlameableBlock(Block block, int encouragement, int flammability) {
        Blocks.FIRE.setFireInfo(block, encouragement, flammability);
    }

    // register models
    @SideOnly(Side.CLIENT)
    public static void registerModels(ModelRegistryEvent event, String modId) {
        ModLogger.registeredModelsLogger(modId);
        for (Item item : ForgeRegistries.ITEMS.getValuesCollection()) {
            if (item.getRegistryName().getResourceDomain().equals(modId)) {
                ModelLoader.setCustomModelResourceLocation(item, 0,
                        new ModelResourceLocation(item.getRegistryName(), "inventory"));
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public static void registerModels(ModelRegistryEvent event, String modId, String varint) {
        ModLogger.registeredModelsLogger(modId);
        for (Item item : ForgeRegistries.ITEMS.getValuesCollection()) {
            if (item.getRegistryName().getResourceDomain().equals(modId)) {
                ModelLoader.setCustomModelResourceLocation(item, 0,
                        new ModelResourceLocation(item.getRegistryName(), varint));
            }
        }
    }
}