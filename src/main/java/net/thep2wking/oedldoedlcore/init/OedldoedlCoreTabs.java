package net.thep2wking.oedldoedlcore.init;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thep2wking.oedldoedlcore.OedldoedlCore;
import net.thep2wking.oedldoedlcore.util.ModReferences;

public class OedldoedlCoreTabs {
    public static final CreativeTabs OELDOEDLCORE_TAB = new CreativeTabs(OedldoedlCore.MODID + ".name") {
        @Override
        @SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem() {
            return new ItemStack(OedldoedlCoreItems.CORE_ICON, 1, 0);
        }

        @Override
        public boolean hasSearchBar() {
            return true;
        }

        @Override
        @SideOnly(Side.CLIENT)
        public ResourceLocation getBackgroundImage() {
            return ModReferences.CREATIVE_TAB_LIGHT;
        }
    };
}