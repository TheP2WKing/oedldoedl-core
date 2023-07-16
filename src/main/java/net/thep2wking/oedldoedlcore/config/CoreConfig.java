package net.thep2wking.oedldoedlcore.config;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.thep2wking.oedldoedlcore.OedldoedlCore;
import net.thep2wking.oedldoedlcore.config.categories.Content;
import net.thep2wking.oedldoedlcore.config.categories.Integration;
import net.thep2wking.oedldoedlcore.config.categories.Logging;
import net.thep2wking.oedldoedlcore.config.categories.Properties;
import net.thep2wking.oedldoedlcore.config.categories.Recipes;
import net.thep2wking.oedldoedlcore.config.categories.Tooltips;
import net.thep2wking.oedldoedlcore.util.ModReferences;

@Config(modid = OedldoedlCore.MODID, name = ModReferences.BASE_MODID + "/"
        + OedldoedlCore.MODID, category = OedldoedlCore.MODID)
public class CoreConfig {
    @Config.Name("content")
    public static final Content CONTENT = new Content();

    @Config.Name("integration")
    public static final Integration INTEGRATION = new Integration();

    @Config.Name("logging")
    public static final Logging LOGGING = new Logging();

    @Config.Name("properties")
    public static final Properties PROPERTIES = new Properties();

    @Config.Name("recipes")
    public static final Recipes RECIPES = new Recipes();

    @Config.Name("tooltips")
    public static final Tooltips TOOLTIPS = new Tooltips();

    @Mod.EventBusSubscriber
    public static class ConfigHolder {
        @SubscribeEvent
        public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
            if (event.getModID().equals(OedldoedlCore.MODID)) {
                ConfigManager.sync(OedldoedlCore.MODID, Config.Type.INSTANCE);
            }
        }
    }
}