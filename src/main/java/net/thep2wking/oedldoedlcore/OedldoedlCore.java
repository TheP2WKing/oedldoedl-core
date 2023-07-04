package net.thep2wking.oedldoedlcore;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLLoadCompleteEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.thep2wking.oedldoedlcore.util.OedldoedlCoreRegistry;
import net.thep2wking.oedldoedlcore.util.proxy.CommonProxy;

@Mod(modid = OedldoedlCore.MODID, name = OedldoedlCore.NAME, version = OedldoedlCore.VERSION, dependencies = OedldoedlCore.DEPENDENCIES)
public class OedldoedlCore {
    public static final String MODID = "oedldoedlcore";
    public static final String PREFIX = MODID + ":";
    public static final String MC_VERSION = "1.12.2";
    public static final String NAME = "Oedldoedl Core";
    public static final String VERSION = MC_VERSION + "-" + "1.0.0";
    public static final String DEPENDENCIES = "required-after:forge@[14.23.5.2847,)";
    public static final String CLIENT_PROXY_CLASS = "net.thep2wking.oedldoedlcore.util.proxy.ClientProxy";
    public static final String SERVER_PROXY_CLASS = "net.thep2wking.oedldoedlcore.util.proxy.ServerProxy";
    public static final Logger LOGGER = LogManager.getLogger(NAME);

    @SidedProxy(clientSide = CLIENT_PROXY_CLASS, serverSide = SERVER_PROXY_CLASS)
    public static CommonProxy PROXY;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        LOGGER.info("Starting FML Pre-Initialization");
        PROXY.preInit(event);
        OedldoedlCoreRegistry.preInitRegistries(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        LOGGER.info("Starting FML Initialization");
        PROXY.Init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        LOGGER.info("Starting FML Post-Initialization");
        PROXY.postInit(event);
    }

    @Mod.EventHandler
    public void loadComplete(FMLLoadCompleteEvent event) {
        LOGGER.info(MODID + " " + VERSION + " " + "loaded!");
    }
}