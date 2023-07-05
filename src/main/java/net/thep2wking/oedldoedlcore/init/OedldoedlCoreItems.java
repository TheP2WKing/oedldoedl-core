package net.thep2wking.oedldoedlcore.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.Item;
import net.thep2wking.oedldoedlcore.api.ModItemBase;
import net.thep2wking.oedldoedlcore.content.SubModIconItem;
import net.thep2wking.oedldoedlcore.util.ModRarities;

public class OedldoedlCoreItems {
        public static final List<Item> ITEMS = new ArrayList<Item>();

        public static final Item CORE_ICON = new ModItemBase("core_icon", OedldoedlCoreTabs.OELDOEDLCORE_TAB,
                        ModRarities.YELLOW, false, 0, 4);
        public static final Item RESOURCES_ICON = new SubModIconItem("resources_icon",
                        OedldoedlCoreTabs.OELDOEDLCORE_TAB, ModRarities.YELLOW, false, "oedldoedlresources", 0, 4);
        public static final Item GEAR_ICON = new SubModIconItem("gear_icon",
                        OedldoedlCoreTabs.OELDOEDLCORE_TAB, ModRarities.YELLOW, false, "oedldoedlgear", 0, 4);
        public static final Item CURIOSITY_ICON = new SubModIconItem("curiosity_icon",
                        OedldoedlCoreTabs.OELDOEDLCORE_TAB, ModRarities.YELLOW, false, "oedldoedlcuriosity", 0, 4);
        public static final Item CONSTRUCT_ICON = new SubModIconItem("construct_icon",
                        OedldoedlCoreTabs.OELDOEDLCORE_TAB, ModRarities.YELLOW, false, "oedldoedlconstruct", 0, 4);
        public static final Item MUSIC_ICON = new SubModIconItem("music_icon",
                        OedldoedlCoreTabs.OELDOEDLCORE_TAB, ModRarities.YELLOW, false, "oedldoedlmusic", 0, 4);
        public static final Item INTEGRATION_ICON = new SubModIconItem("integration_icon",
                        OedldoedlCoreTabs.OELDOEDLCORE_TAB, ModRarities.YELLOW, false, "oedldoedlintegration", 0, 4);
}