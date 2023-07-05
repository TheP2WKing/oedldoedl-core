package net.thep2wking.oedldoedlcore.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.Item;
import net.thep2wking.oedldoedlcore.OedldoedlCore;
import net.thep2wking.oedldoedlcore.api.ModItemBase;
import net.thep2wking.oedldoedlcore.content.SubModIconItem;
import net.thep2wking.oedldoedlcore.util.ModRarities;
import net.thep2wking.oedldoedlcore.util.ModReferences;

public class OedldoedlCoreItems {
	public static final List<Item> ITEMS = new ArrayList<Item>();

	public static final Item CORE_ICON = new ModItemBase(OedldoedlCore.MODID, "core_icon", OedldoedlCore.TAB, ModRarities.YELLOW, false,
			0, 4);
	public static final Item RESOURCES_ICON = new SubModIconItem(OedldoedlCore.MODID, "resources_icon", OedldoedlCore.TAB,
			ModRarities.YELLOW, false, ModReferences.MODID_CORE, 0, 4);
	public static final Item GEAR_ICON = new SubModIconItem(OedldoedlCore.MODID, "gear_icon", OedldoedlCore.TAB, ModRarities.YELLOW,
			false, ModReferences.MODID_GEAR, 0, 4);
	public static final Item CURIOSITY_ICON = new SubModIconItem(OedldoedlCore.MODID, "curiosity_icon", OedldoedlCore.TAB,
			ModRarities.YELLOW, false, ModReferences.MODID_CURIOSITY, 0, 4);
	public static final Item CONSTRUCT_ICON = new SubModIconItem(OedldoedlCore.MODID, "construct_icon", OedldoedlCore.TAB,
			ModRarities.YELLOW, false, ModReferences.MODID_CONSTRUCT, 0, 4);
	public static final Item MUSIC_ICON = new SubModIconItem(OedldoedlCore.MODID, "music_icon", OedldoedlCore.TAB, ModRarities.YELLOW,
			false, ModReferences.MODID_MUSIC, 0, 4);
	public static final Item INTEGRATION_ICON = new SubModIconItem(OedldoedlCore.MODID, "integration_icon", OedldoedlCore.TAB,
			ModRarities.YELLOW, false, ModReferences.MODID_INTEGRATION, 0, 4);
}