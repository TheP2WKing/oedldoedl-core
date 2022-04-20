package net.thep2wking.oedldoedlcore.api;

import java.util.List;

import net.minecraft.block.DispenserBlock;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.thep2wking.oedldoedlcore.config.CoreConfig;
import net.thep2wking.oedldoedlcore.util.ModRarities;
import net.thep2wking.oedldoedlcore.util.ModTooltips;

public class ModArmorItemBase extends ArmorItem {
	public Rarity rarity = ModRarities.WHITE;
	public boolean hasEffect;
	public boolean fireImmunity;
	public int tooltipLines;
	public int annotationLines;

	/**
	 * @author TheP2WKing
	 * @param material        {@link IArmorMaterial}
	 * @param slot            {@link EquipmentSlotType}
	 * @param rarity          {@link Rarity}
	 * @param hasEffect       boolean
	 * @param fireImmunity    boolean
	 * @param tooltipLines    int
	 * @param annotationLines int
	 * @param properties      {@link Properties}
	 */
	public ModArmorItemBase(IArmorMaterial material, EquipmentSlotType slot, Rarity rarity, boolean hasEffect,
			boolean fireImmunity, int tooltipLines, int annotationLines, Properties properties) {
		super(material, slot, properties.maxStackSize(1));
		DispenserBlock.registerDispenseBehavior(this, ArmorItem.DISPENSER_BEHAVIOR);
		this.rarity = rarity;
		this.hasEffect = hasEffect;
		this.fireImmunity = fireImmunity;
		this.tooltipLines = tooltipLines;
		this.annotationLines = annotationLines;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public Rarity getRarity(ItemStack stack) {
		if (!stack.isEnchanted() && CoreConfig.item_rarities.get()) {
			return this.rarity;
		} else if (stack.isEnchanted()) {
			switch (this.rarity) {
			case COMMON:
			case UNCOMMON:
				return Rarity.RARE;
			case RARE:
				return Rarity.EPIC;
			case EPIC:
			default:
				return rarity;
			}
		}
		return ModRarities.WHITE;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean hasEffect(ItemStack stack) {
		if (CoreConfig.enchantment_effects.get()) {
			return hasEffect || stack.isEnchanted();
		}
		return stack.isEnchanted();
	}

	@Override
	public boolean isImmuneToFire() {
		if (CoreConfig.fire_immunity.get()) {
			return fireImmunity;
		}
		return false;
	}

	@Override
	public boolean isEnchantable(ItemStack stack) {
		return true;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		if (ModTooltips.showAnnotationTip()) {
			for (int i = 1; i <= annotationLines; ++i) {
				ModTooltips.addAnnotation(tooltip, this.getTranslationKey(), i);
			}
		}
		if (ModTooltips.showInfoTip()) {
			for (int i = 1; i <= tooltipLines; ++i) {
				ModTooltips.addInformation(tooltip, this.getTranslationKey(), i);
			}
		} else if (ModTooltips.showInfoTipKey() && !(tooltipLines == 0)) {
			ModTooltips.addKey(tooltip, ModTooltips.KEY_INFO);
		}
	}
}