package net.thep2wking.oedldoedlcore.api.tool;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.block.BlockDispenser;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemShield;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thep2wking.oedldoedlcore.config.CoreConfig;
import net.thep2wking.oedldoedlcore.util.ModTooltips;

public class ModItemShieldBase extends ItemShield {
	public final String modid;
	public final String name;
	public final CreativeTabs tab;
	public final ToolMaterial material;
	public final EnumRarity rarity;
	public final boolean hasEffect;
	public final int tooltipLines;
	public final int annotationLines;

	public ModItemShieldBase(String modid, String name, CreativeTabs tab, ToolMaterial material, EnumRarity rarity,
			boolean hasEffect, int tooltipLines, int annotationLines) {
		this.modid = modid;
		this.name = name;
		this.tab = tab;
		this.material = material;
		this.rarity = rarity;
		this.hasEffect = hasEffect;
		this.tooltipLines = tooltipLines;
		this.annotationLines = annotationLines;
		setUnlocalizedName(this.modid + "." + this.name);
		setRegistryName(this.modid + ":" + this.name);
		setCreativeTab(this.tab);
		setMaxStackSize(1);
		setMaxDamage(
				(int) (this.material.getMaxUses() * CoreConfig.PROPERTIES.DURABILITIES.SHIELD_DURABILITY_MULTIPLIER));
		BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(this, ItemArmor.DISPENSER_BEHAVIOR);
		this.addPropertyOverride(new ResourceLocation("blocking"), new IItemPropertyGetter() {
			@Override
			@SideOnly(Side.CLIENT)
			public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {
				return entityIn != null && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F
						: 0.0F;
			}
		});
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
		return true;
	}

	@Override
	public boolean isShield(ItemStack stack, @Nullable EntityLivingBase entity) {
		return true;
	}

	@Override
	public boolean isRepairable() {
		return true;
	}

	@Override
	@SuppressWarnings("deprecation")
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return repair.getItem() == this.material.getRepairItem() ? true : super.getIsRepairable(toRepair, repair);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack stack) {
		if (!stack.isItemEnchanted() && CoreConfig.PROPERTIES.COLORFUL_RARITIES) {
			return this.rarity;
		} else if (stack.isItemEnchanted()) {
			switch (this.rarity) {
				case COMMON:
				case UNCOMMON:
					return EnumRarity.RARE;
				case RARE:
					return EnumRarity.EPIC;
				case EPIC:
				default:
					return this.rarity;
			}
		}
		return EnumRarity.COMMON;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack stack) {
		if (CoreConfig.PROPERTIES.ENCHANTMENT_EFFECTS) {
			return this.hasEffect || stack.isItemEnchanted();
		}
		return stack.isItemEnchanted();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		if (ModTooltips.showAnnotationTip()) {
			for (int i = 1; i <= annotationLines; ++i) {
				ModTooltips.addAnnotation(tooltip, this.getUnlocalizedName(), i);
			}
		}
		if (ModTooltips.showInfoTip()) {
			for (int i = 1; i <= tooltipLines; ++i) {
				ModTooltips.addInformation(tooltip, this.getUnlocalizedName(), i);
			}
		} else if (ModTooltips.showInfoTipKey() && !(tooltipLines == 0)) {
			ModTooltips.addKey(tooltip, ModTooltips.KEY_INFO);
		}
	}
}