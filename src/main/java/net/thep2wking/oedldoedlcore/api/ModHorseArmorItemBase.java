package net.thep2wking.oedldoedlcore.api;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.HorseArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.thep2wking.oedldoedlcore.config.CoreConfig;
import net.thep2wking.oedldoedlcore.util.ModRarities;
import net.thep2wking.oedldoedlcore.util.ModTooltips;

public class ModHorseArmorItemBase extends HorseArmorItem {
	public Rarity rarity = ModRarities.WHITE;
	public String modId;
	public String textureName;
	public boolean hasEffect;
	public boolean fireImmunity;
	public int tooltipLines;
	public int annotationLines;

	/**
	 * @author TheP2WKing
	 * @param modId           String
	 * @param textureName     String
	 * @param armorValue      int
	 * @param rarity          {@link Rarity}
	 * @param hasEffect       boolean
	 * @param fireImmunity    boolean
	 * @param tooltipLines    int
	 * @param annotationLines int
	 * @param properties      {@link Properties}
	 */
	public ModHorseArmorItemBase(String modId, String textureName, int armorValue, Rarity rarity, boolean hasEffect,
			boolean fireImmunity, int tooltipLines, int annotationLines, Properties properties) {
		super(armorValue, textureName, properties.maxStackSize(1));
		this.modId = modId;
		this.textureName = textureName;
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
	@OnlyIn(Dist.CLIENT)
	public ResourceLocation getArmorTexture() {
		return new ResourceLocation(modId, "textures/models/horsearmor/" + textureName + ".png");
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