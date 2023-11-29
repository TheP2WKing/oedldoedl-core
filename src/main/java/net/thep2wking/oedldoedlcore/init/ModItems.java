package net.thep2wking.oedldoedlcore.init;

import net.minecraft.item.Item;
import net.thep2wking.oedldoedlcore.OedldoedlCore;
import net.thep2wking.oedldoedlcore.api.item.ModItemIconBase;
import net.thep2wking.oedldoedlcore.util.ModRarities;
import net.thep2wking.oedldoedlcore.util.ModReferences;

public class ModItems {
	public static final Item CORE_ICON = new ModItemIconBase(OedldoedlCore.MODID, "core_icon", OedldoedlCore.TAB,
			ModReferences.MODID_CORE, ModRarities.YELLOW, false, 0, 4);
	public static final Item RESOURCES_ICON = new ModItemIconBase(OedldoedlCore.MODID, "resources_icon",
			OedldoedlCore.TAB, ModReferences.MODID_RESOURCES, ModRarities.YELLOW, false, 0, 4);
	public static final Item GEAR_ICON = new ModItemIconBase(OedldoedlCore.MODID, "gear_icon", OedldoedlCore.TAB,
			ModReferences.MODID_GEAR, ModRarities.YELLOW, false, 0, 4);
	public static final Item CURIOSITY_ICON = new ModItemIconBase(OedldoedlCore.MODID, "curiosity_icon",
			OedldoedlCore.TAB, ModReferences.MODID_CURIOSITY, ModRarities.YELLOW, false, 0, 4);
	public static final Item CONSTRUCT_ICON = new ModItemIconBase(OedldoedlCore.MODID, "construct_icon",
			OedldoedlCore.TAB, ModReferences.MODID_CONSTRUCT, ModRarities.YELLOW, false, 0, 4);
	public static final Item EXPLOSIVES_ICON = new ModItemIconBase(OedldoedlCore.MODID, "explosives_icon",
			OedldoedlCore.TAB, ModReferences.MODID_EXPLOSIVES, ModRarities.YELLOW, false, 0, 4);
	public static final Item TECHNOLOGY_ICON = new ModItemIconBase(OedldoedlCore.MODID, "technology_icon",
			OedldoedlCore.TAB, ModReferences.MODID_TECHNOLOGY, ModRarities.YELLOW, false, 0, 4);
	public static final Item MUSIC_ICON = new ModItemIconBase(OedldoedlCore.MODID, "music_icon", OedldoedlCore.TAB,
			ModReferences.MODID_MUSIC, ModRarities.YELLOW, false, 0, 4);
	public static final Item INTEGRATION_ICON = new ModItemIconBase(OedldoedlCore.MODID, "integration_icon",
			OedldoedlCore.TAB, ModReferences.MODID_INTEGRATION, ModRarities.YELLOW, false, 0, 4);
}