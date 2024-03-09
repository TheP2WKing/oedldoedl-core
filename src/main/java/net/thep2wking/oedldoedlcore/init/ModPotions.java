package net.thep2wking.oedldoedlcore.init;

import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionType;
import net.thep2wking.oedldoedlcore.OedldoedlCore;
import net.thep2wking.oedldoedlcore.api.potion.ModPotionTypeBase;
import net.thep2wking.oedldoedlcore.content.PotionDolphinGrace;
import net.thep2wking.oedldoedlcore.content.PotionFlight;
import net.thep2wking.oedldoedlcore.content.PotionSlowFalling;
import net.thep2wking.oedldoedlcore.util.ModPotionTypes;

public class ModPotions {
	public static final Potion SLOW_FALLING = new PotionSlowFalling(OedldoedlCore.MODID, "slow_falling", false, 0xffefd1 , 0, 0);
	public static final Potion DOLPHIN_GRACE = new PotionDolphinGrace(OedldoedlCore.MODID, "dolphin_grace", false, 0x88a3be , 1, 0);
	public static final Potion FLIGHT = new PotionFlight(OedldoedlCore.MODID, "flight", false, 0xffffff , 2, 0);

	public static final PotionType SLOW_FALLING_NORMAL = ModPotionTypeBase.addPotionType(SLOW_FALLING, 1800, 1, ModPotionTypes.NORMAL);
	public static final PotionType SLOW_FALLING_LONG = ModPotionTypeBase.addPotionType(SLOW_FALLING, 4800, 1, ModPotionTypes.LONG);

	public static final PotionType DOLPHIN_GRACE_NORMAL = ModPotionTypeBase.addPotionType(DOLPHIN_GRACE, 900, 1, ModPotionTypes.NORMAL);
	public static final PotionType DOLPHIN_GRACE_LONG = ModPotionTypeBase.addPotionType(DOLPHIN_GRACE, 1800, 1, ModPotionTypes.LONG);
	public static final PotionType DOLPHIN_GRACE_STRONG = ModPotionTypeBase.addPotionType(DOLPHIN_GRACE, 450, 2, ModPotionTypes.STRONG);

	public static final PotionType FLIGHT_NORMAL = ModPotionTypeBase.addPotionType(FLIGHT, 1800, 1, ModPotionTypes.NORMAL);
	public static final PotionType FLIGHT_LONG = ModPotionTypeBase.addPotionType(FLIGHT, 3600, 1, ModPotionTypes.LONG);

}