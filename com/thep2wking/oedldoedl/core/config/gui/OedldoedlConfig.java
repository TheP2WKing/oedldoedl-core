package com.thep2wking.oedldoedl.core.config.gui;

import java.io.File;

import com.thep2wking.oedldoedl.core.ReferenceCore;
import com.thep2wking.oedldoedl.core.config.constants.CoreConst;
import com.thep2wking.oedldoedl.core.config.constants.GearConst;
import com.thep2wking.oedldoedl.core.config.constants.ResourcesConst;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class OedldoedlConfig 
{
	public static Configuration config;
	
    public OedldoedlConfig(FMLPreInitializationEvent event)
    {
        final File configFile = new File(event.getModConfigurationDirectory(), ReferenceCore.CONFIG_NAME+".cfg");
        config = new Configuration(configFile, "v1.0.0");

        load();
        sync();
    }

	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event)
	{
		if (event.getModID().equals(ReferenceCore.MODID))
			OedldoedlConfig.sync();
	}

	public static void sync()
	{
		//category core
	    config.getCategory(CoreConst.CATEGORY).setComment(CoreConst.CATEGORY_COMMENT);
	    
	    CoreConst.ITEM_INFORMATION = config.get(CoreConst.CATEGORY, CoreConst.ITEM_INFORMATION_NAME, false, CoreConst.ITEM_INFORMATION_COMMENT).getBoolean();
	    CoreConst.POTION_INFORMATION = config.get(CoreConst.CATEGORY, CoreConst.POTION_INFORMATION_NAME, true, CoreConst.POTION_INFORMATION_COMMENT).getBoolean();
	    CoreConst.POTION_EFFECTS = config.get(CoreConst.CATEGORY, CoreConst.POTION_EFFECTS_NAME, true, CoreConst.POTION_EFFECTS_COMMENT).getBoolean();
	    CoreConst.CCL_TEXTURES = config.get(CoreConst.CATEGORY, CoreConst.CCL_TEXTURES_NAME, true, CoreConst.CCL_TEXTURES_COMMENT).getBoolean();
	    CoreConst.OREDICT_ENTRIES = config.get(CoreConst.CATEGORY, CoreConst.OREDICT_ENTRIES_NAME, true, CoreConst.OREDICT_ENTRIES_COMMENT).getBoolean();   
	    CoreConst.FURNACE_RECIPES = config.get(CoreConst.CATEGORY, CoreConst.FURNACE_RECIPES_NAME, true, CoreConst.FURNACE_RECIPES_COMMENT).getBoolean();
	    
  		if (Loader.isModLoaded("oedldoedlresources")) 
  		{   
  			CoreConst.OEDLDOEDL_ORE_GEN = config.get(CoreConst.CATEGORY, CoreConst.OEDLDOEDL_ORE_GEN_NAME, true, CoreConst.OEDLDOEDL_ORE_GEN_COMMENT).getBoolean();
  			CoreConst.SALT_ORE_GEN = config.get(CoreConst.CATEGORY, CoreConst.SALT_ORE_GEN_NAME, true, CoreConst.SALT_ORE_GEN_COMMENT).getBoolean();
  			CoreConst.GREMORIUM_GEM_ORE_GEN = config.get(CoreConst.CATEGORY, CoreConst.GREMORIUM_GEM_ORE_GEN_NAME, true, CoreConst.GREMORIUM_GEM_ORE_GEN_COMMENT).getBoolean();
  			CoreConst.HIMEJIMARIUM_GEM_ORE_GEN = config.get(CoreConst.CATEGORY, CoreConst.HIMEJIMARIUM_GEM_ORE_GEN_NAME, true, CoreConst.GHIMEJIMARIUM_GEM_ORE_GEN_COMMENT).getBoolean();
  			CoreConst.TOUJOURIUM_GEM_ORE_GEN = config.get(CoreConst.CATEGORY, CoreConst.TOUJOURIUM_GEM_ORE_GEN_NAME, true, CoreConst.TOUJOURIUM_GEM_ORE_GEN_COMMENT).getBoolean();
  			CoreConst.ARGENTORIUM_GEM_ORE_GEN = config.get(CoreConst.CATEGORY, CoreConst.ARGENTORIUM_GEM_ORE_GEN_NAME, true, CoreConst.ARGENTORIUM_GEM_ORE_GEN_COMMENT).getBoolean();
  			CoreConst.QUARTARIUM_GEM_ORE_GEN = config.get(CoreConst.CATEGORY, CoreConst.QUARTARIUM_GEM_ORE_GEN_NAME, true, CoreConst.QUARTARIUM_GEM_ORE_GEN_COMMENT).getBoolean();
  		}
  		
  		if (Loader.isModLoaded("oedldoedlgear")) 
  		{   
  			CoreConst.BAUBLE_SLOT_ANY = config.get(CoreConst.CATEGORY, CoreConst.BAUBLE_SLOT_ANY_NAME, false, CoreConst.BAUBLE_SLOT_ANY_COMMENT).getBoolean();
  			CoreConst.BAUBLE_EFFECTS = config.get(CoreConst.CATEGORY, CoreConst.BAUBLE_EFFECTS_NAME, true, CoreConst.BAUBLE_EFFECTS_COMMENT).getBoolean();
  			CoreConst.BAUBLE_FLIGHT = config.get(CoreConst.CATEGORY, CoreConst.BAUBLE_FLIGHT_NAME, true, CoreConst.BAUBLE_FLIGHT_COMMENT).getBoolean();
  			CoreConst.BAUBLE_RENDER = config.get(CoreConst.CATEGORY, CoreConst.BAUBLE_RENDER_NAME, true, CoreConst.BAUBLE_RENDER_COMMENT).getBoolean();
  		}
  		
		//category resources
  		if (Loader.isModLoaded("oedldoedlresources")) 
  		{
  			config.getCategory(ResourcesConst.CATEGORY).setComment(ResourcesConst.CATEGORY_COMMENT);
  			
  			//blocks
	    	ResourcesConst.STAR_BASE_BLOCK = config.get(ResourcesConst.CATEGORY, ResourcesConst.STAR_BASE_BLOCK_NAME, true, ResourcesConst.STAR_BASE_BLOCK_COMMENT).getBoolean();
	    	ResourcesConst.OEDLDOEDL_STAR_BLOCK = config.get(ResourcesConst.CATEGORY, ResourcesConst.OEDLDOEDL_STAR_BLOCK_NAME, true, ResourcesConst.OEDLDOEDL_STAR_BLOCK_COMMENT).getBoolean();
	    	ResourcesConst.INFINITY_STAR_BLOCK = config.get(ResourcesConst.CATEGORY, ResourcesConst.INFINITY_STAR_BLOCK_NAME, true, ResourcesConst.INFINITY_STAR_BLOCK_COMMENT).getBoolean();

	    	ResourcesConst.INGOT_BASE_BLOCK = config.get(ResourcesConst.CATEGORY, ResourcesConst.INGOT_BASE_BLOCK_NAME, true, ResourcesConst.INGOT_BASE_BLOCK_COMMENT).getBoolean();
	    	ResourcesConst.OEDLDOEDL_BLOCK = config.get(ResourcesConst.CATEGORY, ResourcesConst.OEDLDOEDL_BLOCK_NAME, true, ResourcesConst.OEDLDOEDL_BLOCK_COMMENT).getBoolean();
	    	ResourcesConst.BEDROCKIUM_BLOCK = config.get(ResourcesConst.CATEGORY, ResourcesConst.BEDROCKIUM_BLOCK_NAME, true, ResourcesConst.BEDROCKIUM_BLOCK_COMMENT).getBoolean();
	    	ResourcesConst.DRUNKIUM_BLOCK = config.get(ResourcesConst.CATEGORY, ResourcesConst.DRUNKIUM_BLOCK_NAME, true, ResourcesConst.DRUNKIUM_BLOCK_COMMENT).getBoolean();
	    	ResourcesConst.SADISTIUM_BLOCK = config.get(ResourcesConst.CATEGORY, ResourcesConst.DRUNKIUM_BLOCK_NAME, true, ResourcesConst.DRUNKIUM_BLOCK_COMMENT).getBoolean();
	    	ResourcesConst.USELESSIUM_BLOCK = config.get(ResourcesConst.CATEGORY, ResourcesConst.USELESSIUM_BLOCK_NAME, true, ResourcesConst.USELESSIUM_BLOCK_COMMENT).getBoolean();
	    	ResourcesConst.GREMORIUM_BLOCK = config.get(ResourcesConst.CATEGORY, ResourcesConst.GREMORIUM_BLOCK_NAME, true, ResourcesConst.GREMORIUM_BLOCK_COMMENT).getBoolean();
	    	ResourcesConst.HIMEJIMARIUM_BLOCK = config.get(ResourcesConst.CATEGORY, ResourcesConst.HIMEJIMARIUM_BLOCK_NAME, true, ResourcesConst.HIMEJIMARIUM_BLOCK_COMMENT).getBoolean();
	    	ResourcesConst.TOUJOURIUM_BLOCK = config.get(ResourcesConst.CATEGORY, ResourcesConst.TOUJOURIUM_BLOCK_NAME, true, ResourcesConst.TOUJOURIUM_BLOCK_COMMENT).getBoolean();    
	    	ResourcesConst.ARGENTORIUM_BLOCK = config.get(ResourcesConst.CATEGORY, ResourcesConst.ARGENTORIUM_BLOCK_NAME, true, ResourcesConst.ARGENTORIUM_BLOCK_COMMENT).getBoolean();
	    	ResourcesConst.QUARTARIUM_BLOCK = config.get(ResourcesConst.CATEGORY, ResourcesConst.QUARTARIUM_BLOCK_NAME, true, ResourcesConst.QUARTARIUM_BLOCK_COMMENT).getBoolean();
	    	
	    	ResourcesConst.GEM_BASE_BLOCK = config.get(ResourcesConst.CATEGORY, ResourcesConst.GEM_BASE_BLOCK_NAME, true, ResourcesConst.GEM_BASE_BLOCK_COMMENT).getBoolean();
	    
	    	ResourcesConst.OEDLDOEDL_ORE = config.get(ResourcesConst.CATEGORY, ResourcesConst.OEDLDOEDL_ORE_NAME, true, ResourcesConst.OEDLDOEDL_ORE_COMMENT).getBoolean();
	    	ResourcesConst.SALT_ORE = config.get(ResourcesConst.CATEGORY, ResourcesConst.SALT_ORE_NAME, true, ResourcesConst.SALT_ORE_COMMENT).getBoolean();	
	    	ResourcesConst.GREMORIUM_GEM_ORE = config.get(ResourcesConst.CATEGORY, ResourcesConst.GREMORIUM_GEM_ORE_NAME, true, ResourcesConst.GREMORIUM_GEM_ORE_COMMENT).getBoolean();	
	    	ResourcesConst.HIMEJIMARIUM_GEM_ORE = config.get(ResourcesConst.CATEGORY, ResourcesConst.HIMEJIMARIUM_GEM_ORE_NAME, true, ResourcesConst.HIMEJIMARIUM_GEM_ORE_COMMENT).getBoolean();	
	    	ResourcesConst.TOUJOURIUM_GEM_ORE = config.get(ResourcesConst.CATEGORY, ResourcesConst.TOUJOURIUM_GEM_ORE_NAME, true, ResourcesConst.TOUJOURIUM_GEM_ORE_COMMENT).getBoolean();	
	    	ResourcesConst.ARGENTORIUM_GEM_ORE = config.get(ResourcesConst.CATEGORY, ResourcesConst.ARGENTORIUM_GEM_ORE_NAME, true, ResourcesConst.ARGENTORIUM_GEM_ORE_COMMENT).getBoolean();	
	    	ResourcesConst.QUARTARIUM_GEM_ORE = config.get(ResourcesConst.CATEGORY, ResourcesConst.QUARTARIUM_GEM_ORE_NAME, true, ResourcesConst.QUARTARIUM_GEM_ORE_COMMENT).getBoolean();	
	    	
	    	//items
  			ResourcesConst.STAR_BASE = config.get(ResourcesConst.CATEGORY, ResourcesConst.STAR_BASE_NAME, true, ResourcesConst.STAR_BASE_COMMENT).getBoolean();
  			ResourcesConst.OEDLDOEDL_STAR = config.get(ResourcesConst.CATEGORY, ResourcesConst.OEDLDOEDL_STAR_NAME, true, ResourcesConst.OEDLDOEDL_STAR_COMMENT).getBoolean();
  			ResourcesConst.INFINITY_STAR = config.get(ResourcesConst.CATEGORY, ResourcesConst.INFINITY_STAR_NAME, true, ResourcesConst.INFINITY_STAR_COMMENT).getBoolean();

  			ResourcesConst.INGOT_BASE = config.get(ResourcesConst.CATEGORY, ResourcesConst.INGOT_BASE_NAME, true, ResourcesConst.INGOT_BASE_COMMENT).getBoolean();
  			ResourcesConst.OEDLDOEDL_INGOT = config.get(ResourcesConst.CATEGORY, ResourcesConst.OEDLDOEDL_INGOT_NAME, true, ResourcesConst.OEDLDOEDL_INGOT_COMMENT).getBoolean();
  			ResourcesConst.BEDROCKIUM_INGOT = config.get(ResourcesConst.CATEGORY, ResourcesConst.BEDROCKIUM_INGOT_NAME, true, ResourcesConst.BEDROCKIUM_INGOT_COMMENT).getBoolean();
  			ResourcesConst.DRUNKIUM_INGOT = config.get(ResourcesConst.CATEGORY, ResourcesConst.DRUNKIUM_INGOT_NAME, true, ResourcesConst.DRUNKIUM_INGOT_COMMENT).getBoolean();
  			ResourcesConst.SADISTIUM_INGOT = config.get(ResourcesConst.CATEGORY, ResourcesConst.DRUNKIUM_INGOT_NAME, true, ResourcesConst.DRUNKIUM_INGOT_COMMENT).getBoolean();
  			ResourcesConst.USELESSIUM_INGOT = config.get(ResourcesConst.CATEGORY, ResourcesConst.USELESSIUM_INGOT_NAME, true, ResourcesConst.USELESSIUM_INGOT_COMMENT).getBoolean();
  			ResourcesConst.GREMORIUM_INGOT = config.get(ResourcesConst.CATEGORY, ResourcesConst.GREMORIUM_INGOT_NAME, true, ResourcesConst.GREMORIUM_INGOT_COMMENT).getBoolean();
  			ResourcesConst.HIMEJIMARIUM_INGOT = config.get(ResourcesConst.CATEGORY, ResourcesConst.HIMEJIMARIUM_INGOT_NAME, true, ResourcesConst.HIMEJIMARIUM_INGOT_COMMENT).getBoolean();
  			ResourcesConst.TOUJOURIUM_INGOT = config.get(ResourcesConst.CATEGORY, ResourcesConst.TOUJOURIUM_INGOT_NAME, true, ResourcesConst.TOUJOURIUM_INGOT_COMMENT).getBoolean();    
  			ResourcesConst.ARGENTORIUM_INGOT = config.get(ResourcesConst.CATEGORY, ResourcesConst.ARGENTORIUM_INGOT_NAME, true, ResourcesConst.ARGENTORIUM_INGOT_COMMENT).getBoolean();
	    	ResourcesConst.QUARTARIUM_INGOT = config.get(ResourcesConst.CATEGORY, ResourcesConst.QUARTARIUM_INGOT_NAME, true, ResourcesConst.QUARTARIUM_INGOT_COMMENT).getBoolean();
	    	ResourcesConst.CHAOS_INGOT = config.get(ResourcesConst.CATEGORY, ResourcesConst.CHAOS_INGOT_NAME, true, ResourcesConst.CHAOS_INGOT_COMMENT).getBoolean();
	    	
  			ResourcesConst.GEM_BASE = config.get(ResourcesConst.CATEGORY, ResourcesConst.GEM_BASE_NAME, true, ResourcesConst.GEM_BASE_COMMENT).getBoolean();
  			ResourcesConst.OEDLDOEDL_GEM = config.get(ResourcesConst.CATEGORY, ResourcesConst.OEDLDOEDL_GEM_NAME, true, ResourcesConst.OEDLDOEDL_GEM_COMMENT).getBoolean();
  			ResourcesConst.TIMOFIUM_GEM = config.get(ResourcesConst.CATEGORY, ResourcesConst.TIMOFIUM_GEM_NAME, true, ResourcesConst.TIMOFIUM_GEM_COMMENT).getBoolean();
  			ResourcesConst.FLOFINIUM_GEM = config.get(ResourcesConst.CATEGORY, ResourcesConst.FLOFINIUM_GEM_NAME, true, ResourcesConst.FLOFINIUM_GEM_COMMENT).getBoolean();
  			ResourcesConst.LAARSIUM_GEM = config.get(ResourcesConst.CATEGORY, ResourcesConst.LAARSIUM_GEM_NAME, true, ResourcesConst.LAARSIUM_GEM_COMMENT).getBoolean();
  			ResourcesConst.KLAARSIUM_GEM = config.get(ResourcesConst.CATEGORY, ResourcesConst.KLAARSIUM_GEM_NAME, true, ResourcesConst.KLAARSIUM_GEM_COMMENT).getBoolean();
  			ResourcesConst.SHARANIUM_GEM = config.get(ResourcesConst.CATEGORY, ResourcesConst.SHARANIUM_GEM_NAME, true, ResourcesConst.SHARANIUM_GEM_COMMENT).getBoolean();
  			ResourcesConst.MAKERIUM_GEM = config.get(ResourcesConst.CATEGORY, ResourcesConst.MAKERIUM_GEM_NAME, true, ResourcesConst.MAKERIUM_GEM_COMMENT).getBoolean();
  			ResourcesConst.INDERIUM_GEM = config.get(ResourcesConst.CATEGORY, ResourcesConst.INDERIUM_GEM_NAME, true, ResourcesConst.INDERIUM_GEM_COMMENT).getBoolean();
  			ResourcesConst.PUMARIUM_GEM = config.get(ResourcesConst.CATEGORY, ResourcesConst.PUMARIUM_GEM_NAME, true, ResourcesConst.PUMARIUM_GEM_COMMENT).getBoolean();
  			ResourcesConst.CALLAXIUM_GEM = config.get(ResourcesConst.CATEGORY, ResourcesConst.CALLAXIUM_GEM_NAME, true, ResourcesConst.CALLAXIUM_GEM_COMMENT).getBoolean();
  			ResourcesConst.SKORPIUM_GEM = config.get(ResourcesConst.CATEGORY, ResourcesConst.SKORPIUM_GEM_NAME, true, ResourcesConst.SKORPIUM_GEM_COMMENT).getBoolean();
  			ResourcesConst.STUPIDIUM_GEM = config.get(ResourcesConst.CATEGORY, ResourcesConst.STUPIDIUM_GEM_NAME, true, ResourcesConst.STUPIDIUM_GEM_COMMENT).getBoolean();
  			
  			ResourcesConst.GREMORIUM_GEM = config.get(ResourcesConst.CATEGORY, ResourcesConst.GREMORIUM_GEM_NAME, true, ResourcesConst.GREMORIUM_GEM_COMMENT).getBoolean();
  			ResourcesConst.HIMEJIMARIUM_GEM = config.get(ResourcesConst.CATEGORY, ResourcesConst.HIMEJIMARIUM_GEM_NAME, true, ResourcesConst.HIMEJIMARIUM_GEM_COMMENT).getBoolean();
  			ResourcesConst.TOUJOURIUM_GEM = config.get(ResourcesConst.CATEGORY, ResourcesConst.TOUJOURIUM_GEM_NAME, true, ResourcesConst.TOUJOURIUM_GEM_COMMENT).getBoolean();
  			ResourcesConst.ARGENTORIUM_GEM = config.get(ResourcesConst.CATEGORY, ResourcesConst.ARGENTORIUM_GEM_NAME, true, ResourcesConst.ARGENTORIUM_GEM_COMMENT).getBoolean();
  			ResourcesConst.QUARTARIUM_GEM = config.get(ResourcesConst.CATEGORY, ResourcesConst.QUARTARIUM_GEM_NAME, true, ResourcesConst.QUARTARIUM_GEM_COMMENT).getBoolean();
	    
	    	ResourcesConst.SHARD_BASE = config.get(ResourcesConst.CATEGORY, ResourcesConst.SHARD_BASE_NAME, true, ResourcesConst.SHARD_BASE_COMMENT).getBoolean();
	    	ResourcesConst.OEDLDOEDL_SHARD = config.get(ResourcesConst.CATEGORY, ResourcesConst.OEDLDOEDL_SHARD_NAME, true, ResourcesConst.OEDLDOEDL_SHARD_COMMENT).getBoolean();
	    	ResourcesConst.INFINITY_SHARD = config.get(ResourcesConst.CATEGORY, ResourcesConst.INFINITY_SHARD_NAME, true, ResourcesConst.INFINITY_SHARD_COMMENT).getBoolean();
	    
	    	ResourcesConst.NUGGET_BASE = config.get(ResourcesConst.CATEGORY, ResourcesConst.NUGGET_BASE_NAME, true, ResourcesConst.NUGGET_BASE_COMMENT).getBoolean();
	    	ResourcesConst.OEDLDOEDL_NUGGET = config.get(ResourcesConst.CATEGORY, ResourcesConst.OEDLDOEDL_NUGGET_NAME, true, ResourcesConst.OEDLDOEDL_NUGGET_COMMENT).getBoolean();
	    	ResourcesConst.BEDROCKIUM_NUGGET = config.get(ResourcesConst.CATEGORY, ResourcesConst.BEDROCKIUM_NUGGET_NAME, true, ResourcesConst.BEDROCKIUM_NUGGET_COMMENT).getBoolean();
	    	ResourcesConst.DRUNKIUM_NUGGET = config.get(ResourcesConst.CATEGORY, ResourcesConst.DRUNKIUM_NUGGET_NAME, true, ResourcesConst.DRUNKIUM_NUGGET_COMMENT).getBoolean();
	    	ResourcesConst.SADISTIUM_NUGGET = config.get(ResourcesConst.CATEGORY, ResourcesConst.DRUNKIUM_NUGGET_NAME, true, ResourcesConst.DRUNKIUM_NUGGET_COMMENT).getBoolean();
	    	ResourcesConst.USELESSIUM_NUGGET = config.get(ResourcesConst.CATEGORY, ResourcesConst.USELESSIUM_NUGGET_NAME, true, ResourcesConst.USELESSIUM_NUGGET_COMMENT).getBoolean();
	    	ResourcesConst.GREMORIUM_NUGGET = config.get(ResourcesConst.CATEGORY, ResourcesConst.GREMORIUM_NUGGET_NAME, true, ResourcesConst.GREMORIUM_NUGGET_COMMENT).getBoolean();
	    	ResourcesConst.HIMEJIMARIUM_NUGGET = config.get(ResourcesConst.CATEGORY, ResourcesConst.HIMEJIMARIUM_NUGGET_NAME, true, ResourcesConst.HIMEJIMARIUM_NUGGET_COMMENT).getBoolean();
	    	ResourcesConst.TOUJOURIUM_NUGGET = config.get(ResourcesConst.CATEGORY, ResourcesConst.TOUJOURIUM_NUGGET_NAME, true, ResourcesConst.TOUJOURIUM_NUGGET_COMMENT).getBoolean();
	    	ResourcesConst.ARGENTORIUM_NUGGET = config.get(ResourcesConst.CATEGORY, ResourcesConst.ARGENTORIUM_NUGGET_NAME, true, ResourcesConst.ARGENTORIUM_NUGGET_COMMENT).getBoolean();
	    	ResourcesConst.QUARTARIUM_NUGGET = config.get(ResourcesConst.CATEGORY, ResourcesConst.QUARTARIUM_NUGGET_NAME, true, ResourcesConst.QUARTARIUM_NUGGET_COMMENT).getBoolean();
	    
	    	ResourcesConst.DUST_BASE = config.get(ResourcesConst.CATEGORY, ResourcesConst.DUST_BASE_NAME, true, ResourcesConst.DUST_BASE_COMMENT).getBoolean();
	    	ResourcesConst.OEDLDOEDL_DUST = config.get(ResourcesConst.CATEGORY, ResourcesConst.OEDLDOEDL_DUST_NAME, true, ResourcesConst.OEDLDOEDL_DUST_COMMENT).getBoolean();
	    	ResourcesConst.SALT_DUST = config.get(ResourcesConst.CATEGORY, ResourcesConst.SALT_DUST_NAME, true, ResourcesConst.SALT_DUST_COMMENT).getBoolean();
	    
	    	ResourcesConst.SINGULARITY_BASE = config.get(ResourcesConst.CATEGORY, ResourcesConst.SINGULARITY_BASE_NAME, true, ResourcesConst.SINGULARITY_BASE_COMMENT).getBoolean();
	    	ResourcesConst.OEDLDOEDL_SINGULARITY = config.get(ResourcesConst.CATEGORY, ResourcesConst.OEDLDOEDL_SINGULARITY_NAME, true, ResourcesConst.OEDLDOEDL_SINGULARITY_COMMENT).getBoolean();
	    	ResourcesConst.GREMORIUM_SINGULARITY = config.get(ResourcesConst.CATEGORY, ResourcesConst.GREMORIUM_SINGULARITY_NAME, true, ResourcesConst.GREMORIUM_SINGULARITY_COMMENT).getBoolean();
	    	ResourcesConst.HIMEJIMARIUM_SINGULARITY = config.get(ResourcesConst.CATEGORY, ResourcesConst.HIMEJIMARIUM_SINGULARITY_NAME, true, ResourcesConst.HIMEJIMARIUM_SINGULARITY_COMMENT).getBoolean();
	    	ResourcesConst.TOUJOURIUM_SINGULARITY = config.get(ResourcesConst.CATEGORY, ResourcesConst.TOUJOURIUM_SINGULARITY_NAME, true, ResourcesConst.TOUJOURIUM_SINGULARITY_COMMENT).getBoolean();
	    	ResourcesConst.ARGENTORIUM_SINGULARITY = config.get(ResourcesConst.CATEGORY, ResourcesConst.ARGENTORIUM_SINGULARITY_NAME, true, ResourcesConst.ARGENTORIUM_SINGULARITY_COMMENT).getBoolean();
	    	ResourcesConst.QUARTARIUM_SINGULARITY = config.get(ResourcesConst.CATEGORY, ResourcesConst.QUARTARIUM_SINGULARITY_NAME, true, ResourcesConst.QUARTARIUM_SINGULARITY_COMMENT).getBoolean();
  		}
  		
		//category gear
  		if (Loader.isModLoaded("oedldoedlgear")) 
  		{
  			config.getCategory(GearConst.CATEGORY).setComment(GearConst.CATEGORY_COMMENT);
  			
  			GearConst.OEDLDOEDL_HELMET = config.get(GearConst.CATEGORY, GearConst.OEDLDOEDL_HELMET_NAME, true, GearConst.OEDLDOEDL_HELMET_COMMENT).getBoolean();
  			GearConst.OEDLDOEDL_CHESTPLATE = config.get(GearConst.CATEGORY, GearConst.OEDLDOEDL_CHESTPLATE_NAME, true, GearConst.OEDLDOEDL_CHESTPLATE_COMMENT).getBoolean();
  			GearConst.OEDLDOEDL_LEGGINGS = config.get(GearConst.CATEGORY, GearConst.OEDLDOEDL_LEGGINGS_NAME, true, GearConst.OEDLDOEDL_LEGGINGS_COMMENT).getBoolean();
  			GearConst.OEDLDOEDL_BOOTS = config.get(GearConst.CATEGORY, GearConst.OEDLDOEDL_BOOTS_NAME, true, GearConst.OEDLDOEDL_BOOTS_COMMENT).getBoolean();
  			
  			GearConst.OEDLDOEDL_SWORD = config.get(GearConst.CATEGORY, GearConst.OEDLDOEDL_SWORD_NAME, true, GearConst.OEDLDOEDL_SWORD_COMMENT).getBoolean();
  			GearConst.OEDLDOEDL_SHOVEL = config.get(GearConst.CATEGORY, GearConst.OEDLDOEDL_SHOVEL_NAME, true, GearConst.OEDLDOEDL_SHOVEL_COMMENT).getBoolean();
  			GearConst.OEDLDOEDL_PICKAXE = config.get(GearConst.CATEGORY, GearConst.OEDLDOEDL_PICKAXE_NAME, true, GearConst.OEDLDOEDL_PICKAXE_COMMENT).getBoolean();
  			GearConst.OEDLDOEDL_AXE = config.get(GearConst.CATEGORY, GearConst.OEDLDOEDL_AXE_NAME, true, GearConst.OEDLDOEDL_AXE_COMMENT).getBoolean();
  			GearConst.OEDLDOEDL_HOE = config.get(GearConst.CATEGORY, GearConst.OEDLDOEDL_HOE_NAME, true, GearConst.OEDLDOEDL_HOE_COMMENT).getBoolean();
  			
  			GearConst.OEDLDOEDL_RING = config.get(GearConst.CATEGORY, GearConst.OEDLDOEDL_RING_NAME, true, GearConst.OEDLDOEDL_RING_COMMENT).getBoolean();
  			GearConst.GREMORIUM_AMULET = config.get(GearConst.CATEGORY, GearConst.GREMORIUM_AMULET_NAME, true, GearConst.GREMORIUM_AMULET_COMMENT).getBoolean();
  			GearConst.HIMEJIMARIUM_AMULET = config.get(GearConst.CATEGORY, GearConst.HIMEJIMARIUM_AMULET_NAME, true, GearConst.HIMEJIMARIUM_AMULET_COMMENT).getBoolean();
  			GearConst.TOUJOURIUM_AMULET = config.get(GearConst.CATEGORY, GearConst.TOUJOURIUM_AMULET_NAME, true, GearConst.TOUJOURIUM_AMULET_COMMENT).getBoolean();
  			GearConst.ARGENTORIUM_AMULET = config.get(GearConst.CATEGORY, GearConst.ARGENTORIUM_AMULET_NAME, true, GearConst.ARGENTORIUM_AMULET_COMMENT).getBoolean();
  			GearConst.QUARTARIUM_AMULET = config.get(GearConst.CATEGORY, GearConst.QUARTARIUM_AMULET_NAME, true, GearConst.QUARTARIUM_AMULET_COMMENT).getBoolean();
  			
  			GearConst.BUNNY_EARS = config.get(GearConst.CATEGORY, GearConst.BUNNY_EARS_NAME, true, GearConst.BUNNY_EARS_COMMENT).getBoolean();
  			GearConst.CAT_EARS = config.get(GearConst.CATEGORY, GearConst.CAT_EARS_NAME, true, GearConst.CAT_EARS_COMMENT).getBoolean();
  		}
  			
		if (config.hasChanged())
			save();
	}
	
	public static void save()
	{
		config.save();
	}

	public static void load()
	{
		config.load();
	}

	public static Configuration getConfig() 
	{
		return config;
	}
}