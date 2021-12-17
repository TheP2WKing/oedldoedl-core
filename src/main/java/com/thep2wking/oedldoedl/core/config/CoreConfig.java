package com.thep2wking.oedldoedl.core.config;

import com.thep2wking.oedldoedl.core.ReferenceCore;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = ReferenceCore.MODID, name = "oedldoedlcore", category = ReferenceCore.MODID)
public class CoreConfig 
{
	@Config.Name("Generel")
	@Config.Comment("Configure Oedldoedl Core [Generel]")
	public static final Generel GENEREL = new Generel();
	
	public static class Generel
	{
		@Config.Name("Tooltips")
		@Config.Comment("Configure tooltips")
		public Tooltips tooltips = new Tooltips();
		
		@Config.Name("Logging")
		@Config.Comment("Enable or Disable Logging.")
		public boolean logging = true;
	}
	
	public static class Tooltips
	{
		@Config.Name("Developer References")
		@Config.Comment("Enable or Disable Developer References (Tooltips esspeically made for Oedldoedl Projects).")
		public boolean itemInformation = false;
		
		@Config.Name("Potion Information")
		@Config.Comment("Enable or Disable Potion Information (displays what effects an item gives you).")
		public boolean potionInformation = true;
		
		@Config.Name("Origin Information")
		@Config.Comment("Enable or Disable Origin Information (where / what the item / block is inspired).")
		public boolean originInformation = true;
	}
	
    @Mod.EventBusSubscriber
    public static class ConfigHolder 
    {
        @SubscribeEvent
        public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) 
        {
            if (event.getModID().equals(ReferenceCore.MODID)) 
            {
                ConfigManager.sync(ReferenceCore.MODID, Config.Type.INSTANCE);
            }
        }
    }
}