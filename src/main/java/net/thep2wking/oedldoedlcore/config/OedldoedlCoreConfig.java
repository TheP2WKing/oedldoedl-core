package net.thep2wking.oedldoedlcore.config;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.thep2wking.oedldoedlcore.OedldoedlCore;
import net.thep2wking.oedldoedlcore.config.categories.Logging;
import net.thep2wking.oedldoedlcore.config.categories.Tooltips;

@Config(modid = OedldoedlCore.MODID, name = OedldoedlCore.MODID, category = OedldoedlCore.MODID)
public class OedldoedlCoreConfig {
    @Config.Name("logging")
    public static final Logging LOGGING = new Logging();

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