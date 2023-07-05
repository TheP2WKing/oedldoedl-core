package net.thep2wking.oedldoedlcore.api;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thep2wking.oedldoedlcore.OedldoedlCore;
import net.thep2wking.oedldoedlcore.init.OedldoedlCoreItems;
import net.thep2wking.oedldoedlcore.util.IHasModel;
import net.thep2wking.oedldoedlcore.util.ModTooltips;

public class ModItemBase extends Item implements IHasModel {
    public final String modid;
    public final String name;
    public final CreativeTabs tab;
    public final EnumRarity rarity;
    public final boolean hasEffect;
    public final int tooltipLines;
    public final int annotationLines;

    public ModItemBase(String modid, String name, CreativeTabs tab, EnumRarity rarity, boolean hasEffect,
            int tooltipLines, int annotationLines) {
        this.modid = modid;
        this.name = name;
        this.tab = tab;
        this.rarity = rarity;
        this.hasEffect = hasEffect;
        this.tooltipLines = tooltipLines;
        this.annotationLines = annotationLines;
        setUnlocalizedName(this.modid + "." + this.name);
        setRegistryName(this.modid + ":" + this.name);
        setCreativeTab(this.tab);
        OedldoedlCoreItems.ITEMS.add(this);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerModels() {
        OedldoedlCore.PROXY.registerItemRenderer(this, 0, "inventory");
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