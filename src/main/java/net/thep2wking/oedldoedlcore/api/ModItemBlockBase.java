package net.thep2wking.oedldoedlcore.api;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thep2wking.oedldoedlcore.init.OedldoedlCoreItems;
import net.thep2wking.oedldoedlcore.util.ModTooltips;

public class ModItemBlockBase extends ItemBlock {
    public final EnumRarity rarity;
    public final boolean hasEffect;
    public final int tooltipLines;
    public final int annotationLines;

    public ModItemBlockBase(Block block, EnumRarity rarity, boolean hasEffect, int tooltipLines,
            int annotationLines) {
        super(block);
        this.rarity = rarity;
        this.hasEffect = hasEffect;
        this.tooltipLines = tooltipLines;
        this.annotationLines = annotationLines;
        setUnlocalizedName(block.getUnlocalizedName());
        setRegistryName(block.getRegistryName());
        setCreativeTab(block.getCreativeTabToDisplayOn());
        OedldoedlCoreItems.ITEMS.add(this);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(ItemStack stack) {
        if (!stack.isItemEnchanted()) {
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
        return this.hasEffect || stack.isItemEnchanted();
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