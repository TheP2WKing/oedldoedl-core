package net.thep2wking.oedldoedlcore;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLLoadCompleteEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thep2wking.oedldoedlcore.config.CoreConfig;
import net.thep2wking.oedldoedlcore.init.ModItems;
import net.thep2wking.oedldoedlcore.registry.ModRecipes;
import net.thep2wking.oedldoedlcore.util.ModLogger;
import net.thep2wking.oedldoedlcore.util.ModReferences;
import net.thep2wking.oedldoedlcore.util.proxy.CommonProxy;

@Mod(modid = OedldoedlCore.MODID, name = OedldoedlCore.NAME, version = OedldoedlCore.VERSION, dependencies = OedldoedlCore.DEPENDENCIES)
public class OedldoedlCore {
    public static final String MODID = "oedldoedlcore";
    public static final String PREFIX = MODID + ":";
    public static final String MC_VERSION = "1.12.2";
    public static final String NAME = "Oedldoedl Core";
    public static final String VERSION = MC_VERSION + "-" + "4.0.0";
    public static final String DEPENDENCIES = "required-after:forge@[14.23.5.2847,);after:jei@[4.16.1.300,);after:theoneprobe@[1.4.28,);after:baubles;after:tconstruct;after:matteroverdrive";
    public static final String CLIENT_PROXY_CLASS = "net.thep2wking.oedldoedlcore.util.proxy.ClientProxy";
    public static final String SERVER_PROXY_CLASS = "net.thep2wking.oedldoedlcore.util.proxy.ServerProxy";

    @Instance
    public static OedldoedlCore INSTANCE;

    @SidedProxy(clientSide = CLIENT_PROXY_CLASS, serverSide = SERVER_PROXY_CLASS)
    public static CommonProxy PROXY;

    static {
        FluidRegistry.enableUniversalBucket();
    }

    public static final CreativeTabs CREATIVE = new CreativeTabs("creative.name") {
        @Override
        @SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem() {
            return new ItemStack(Blocks.COMMAND_BLOCK, 1, 0);
        }

        @Override
        @SideOnly(Side.CLIENT)
        public ResourceLocation getBackgroundImage() {
            return ModReferences.CREATIVE_TAB_LIGHT;
        }

        @Override
        public void displayAllRelevantItems(NonNullList<ItemStack> list) {
            if (CoreConfig.CONTENT.UNIBTAINABLE_CREATIVE_TAB) {
                list.add(new ItemStack(Blocks.MOB_SPAWNER, 1, 0));
                list.add(new ItemStack(Blocks.FARMLAND, 1, 0));
                list.add(new ItemStack(Blocks.BROWN_MUSHROOM_BLOCK, 1, 0));
                list.add(new ItemStack(Blocks.RED_MUSHROOM_BLOCK, 1, 0));
                list.add(new ItemStack(Blocks.DRAGON_EGG, 1, 0));
                list.add(new ItemStack(Blocks.BARRIER, 1, 0));
                list.add(new ItemStack(Blocks.GRASS_PATH, 1, 0));
                list.add(new ItemStack(Blocks.COMMAND_BLOCK, 1, 0));
                list.add(new ItemStack(Blocks.REPEATING_COMMAND_BLOCK, 1, 0));
                list.add(new ItemStack(Blocks.CHAIN_COMMAND_BLOCK, 1, 0));
                list.add(new ItemStack(Blocks.STRUCTURE_VOID, 1, 0));
                list.add(new ItemStack(Blocks.STRUCTURE_BLOCK, 1, 0));
                list.add(new ItemStack(Items.FILLED_MAP, 1, 0));
                list.add(new ItemStack(Items.WRITTEN_BOOK, 1, 0));
                list.add(new ItemStack(Items.FIREWORKS, 1, 0));
                list.add(new ItemStack(Items.COMMAND_BLOCK_MINECART, 1, 0));
                list.add(new ItemStack(Items.KNOWLEDGE_BOOK, 1, 0));
                super.displayAllRelevantItems(list);
            }
        }
    };

    public static final CreativeTabs TAB = new CreativeTabs(OedldoedlCore.MODID + ".name") {
        @Override
        @SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem() {
            return new ItemStack(ModItems.CORE_ICON, 1, 0);
        }

        @Override
        @SideOnly(Side.CLIENT)
        public ResourceLocation getBackgroundImage() {
            return ModReferences.CREATIVE_TAB_DARK;
        }
    };

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ModLogger.preInitLogger(MODID);
        PROXY.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        ModLogger.initLogger(MODID);
        ModRecipes.registerOreDict();
        ModRecipes.registerRecipes();
        PROXY.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        ModLogger.postInitLogger(MODID);
        PROXY.postInit(event);
    }

    @Mod.EventHandler
    public void loadComplete(FMLLoadCompleteEvent event) {
        ModLogger.loadCompleteLogger(MODID, VERSION);
    }

    @Mod.EventBusSubscriber
    public static class ModJoinMessage {
        @SubscribeEvent
        public static void addJoinMessage(PlayerLoggedInEvent event) {
            if (CoreConfig.LOGGING.JOIN_MESSAGES) {
                event.player.sendMessage(ModReferences.defaultJoinMessage(NAME, MODID, VERSION));
            }
        }
    }
}