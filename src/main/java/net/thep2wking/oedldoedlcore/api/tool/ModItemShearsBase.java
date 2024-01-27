package net.thep2wking.oedldoedlcore.api.tool;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Items;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemShears;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thep2wking.oedldoedlcore.config.CoreConfig;
import net.thep2wking.oedldoedlcore.util.ModTooltips;

/**
 * @author TheP2WKing
 */
public class ModItemShearsBase extends ItemShears {
	public final String modid;
	public final String name;
	public final CreativeTabs tab;
	public final ToolMaterial material;
	public final EnumRarity rarity;
	public final boolean hasEffect;
	public final int tooltipLines;
	public final int annotationLines;

	/**
	 * @author TheP2WKing
	 * @param modid           String
	 * @param name            String
	 * @param tab             {@link CreativeTabs}
	 * @param material        {@link ToolMaterial}
	 * @param rarity          {@link EnumRarity}
	 * @param hasEffect       boolean
	 * @param tooltipLines    int
	 * @param annotationLines int
	 */
	public ModItemShearsBase(String modid, String name, CreativeTabs tab, ToolMaterial material, EnumRarity rarity,
			boolean hasEffect, int tooltipLines, int annotationLines) {
		super();
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
		setMaxDamage(this.material.getMaxUses() - 12);
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
		return enchantment.type.canEnchantItem(stack.getItem()) || enchantment.canApply(new ItemStack(Items.SHEARS));
	}

	private boolean hasRGBBar;
	private int colorRGB;

	public ItemShears setRGBBarColor(int color) {
		hasRGBBar = CoreConfig.PROPERTIES.RGB_DURABILITY_BARS;
		colorRGB = color;
		return this;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getRGBDurabilityForDisplay(ItemStack stack) {
		if (hasRGBBar) {
			return colorRGB;
		}
		return super.getRGBDurabilityForDisplay(stack);
	}

	@Override
	public boolean isRepairable() {
		return true;
	}

	public ItemStack getRepairStackFromMaterial() {
		return material.getRepairItemStack();
	}

	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		if (getRepairStackFromMaterial() != null) {
			if (getRepairStackFromMaterial() instanceof ItemStack) {
				return repair.isItemEqual((ItemStack) getRepairStackFromMaterial())
						|| super.getIsRepairable(toRepair, repair);
			}
		}
		return super.getIsRepairable(toRepair, repair);
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