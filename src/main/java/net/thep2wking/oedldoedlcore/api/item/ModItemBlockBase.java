package net.thep2wking.oedldoedlcore.api.item;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thep2wking.oedldoedlcore.config.CoreConfig;
import net.thep2wking.oedldoedlcore.util.ModTooltips;

/**
 * @author TheP2WKing
 */
public class ModItemBlockBase extends ItemBlock {
    public final EnumRarity rarity;
    public final boolean hasEffect;
    public final int tooltipLines;
    public final int annotationLines;

    /**
     * @author TheP2WKing
     * @param block           {@link Block}
     * @param rarity          {@link EnumRarity}
     * @param hasEffect       boolean
     * @param tooltipLines    int
     * @param annotationLines int
     */
    public ModItemBlockBase(Block block, EnumRarity rarity, boolean hasEffect, int tooltipLines,
            int annotationLines) {
        super(block);
        this.rarity = rarity;
        this.hasEffect = hasEffect;
        this.tooltipLines = tooltipLines;
        this.annotationLines = annotationLines;
        setUnlocalizedName(block.getUnlocalizedName());
        setRegistryName(block.getRegistryName());
    }

    private boolean isBeaconPayment;

    public Item setBeaconPayment() {
        isBeaconPayment = CoreConfig.PROPERTIES.BEACONS.BEACON_PAYMENTS;
        return this;
    }

    @Override
    public boolean isBeaconPayment(ItemStack stack) {
        return isBeaconPayment;
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