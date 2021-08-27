package com.thep2wking.oedldoedl.core.config.gui;

import java.util.ArrayList;
import java.util.List;

import com.thep2wking.oedldoedl.core.OedldoedlCore;
import com.thep2wking.oedldoedl.core.ReferenceCore;
import com.thep2wking.oedldoedl.core.config.constants.CoreConst;
import com.thep2wking.oedldoedl.core.config.constants.GearConst;
import com.thep2wking.oedldoedl.core.config.constants.ResourcesConst;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.common.config.ConfigCategory;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.IConfigElement;
import net.minecraftforge.fml.common.Loader;

public class OedldoedlConfigGui extends GuiConfig 
{
    public OedldoedlConfigGui(GuiScreen parent) 
    {
        super(parent, getConfigElements(), ReferenceCore.MODID, false, true, I18n.func_135052_a("core.config.oedldoedl.main.title"));
    }

    private static List<IConfigElement> getConfigElements() 
    {
        List<IConfigElement> configElements = new ArrayList<IConfigElement>();

        OedldoedlConfig config = OedldoedlCore.config;
        if (config != null) 
        {
        	//category core
            ConfigCategory categoryOedldoedlCore = config.getConfig().getCategory(CoreConst.CATEGORY);
            configElements.add(new ConfigElement(categoryOedldoedlCore));
            
            //category resources
      		if (Loader.isModLoaded("oedldoedlresources")) 
      		{
      			ConfigCategory categoryOedldoedlResources = config.getConfig().getCategory(ResourcesConst.CATEGORY);
      			configElements.add(new ConfigElement(categoryOedldoedlResources));
      		}
      		
            //category gear
      		if (Loader.isModLoaded("oedldoedlgear")) 
      		{
      			ConfigCategory categoryOedldoedlGear = config.getConfig().getCategory(GearConst.CATEGORY);
      			configElements.add(new ConfigElement(categoryOedldoedlGear));
      		}
        }
        return configElements;
    }
}