package net.thep2wking.oedldoedlcore.init;

import net.minecraft.item.Item;
import net.thep2wking.oedldoedlcore.OedldoedlCore;
import net.thep2wking.oedldoedlcore.api.item.ModItemBase;
import net.thep2wking.oedldoedlcore.content.item.SubModIconItem;
import net.thep2wking.oedldoedlcore.util.ModRarities;
import net.thep2wking.oedldoedlcore.util.ModReferences;

public class ModItems {
	public static final Item CORE_ICON = new ModItemBase(OedldoedlCore.MODID, "core_icon", ModTabs.TAB,
			ModRarities.YELLOW, false, 0, 4).setBeaconPayment();
	public static final Item RESOURCES_ICON = new SubModIconItem(OedldoedlCore.MODID, "resources_icon",
			ModTabs.TAB, ModRarities.YELLOW, false, ModReferences.MODID_RESOURCES, 0, 4);
	public static final Item GEAR_ICON = new SubModIconItem(OedldoedlCore.MODID, "gear_icon", ModTabs.TAB,
			ModRarities.YELLOW, false, ModReferences.MODID_GEAR, 0, 4);
	public static final Item CURIOSITY_ICON = new SubModIconItem(OedldoedlCore.MODID, "curiosity_icon",
			ModTabs.TAB, ModRarities.YELLOW, false, ModReferences.MODID_CURIOSITY, 0, 4);
	public static final Item CONSTRUCT_ICON = new SubModIconItem(OedldoedlCore.MODID, "construct_icon",
			ModTabs.TAB, ModRarities.YELLOW, false, ModReferences.MODID_CONSTRUCT, 0, 4);
	public static final Item MUSIC_ICON = new SubModIconItem(OedldoedlCore.MODID, "music_icon", ModTabs.TAB,
			ModRarities.YELLOW, false, ModReferences.MODID_MUSIC, 0, 4);
	public static final Item INTEGRATION_ICON = new SubModIconItem(OedldoedlCore.MODID, "integration_icon",
			ModTabs.TAB, ModRarities.YELLOW, false, ModReferences.MODID_INTEGRATION, 0, 4);
}