package net.thep2wking.oedldoedlcore.api.tab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thep2wking.oedldoedlcore.util.ModEntityUtil;
import net.thep2wking.oedldoedlcore.util.ModFluidUtil;
import net.thep2wking.oedldoedlcore.util.ModPotionUtil;

/**
 * @author TheP2WKing
 */
public class ModCreativeTabBase extends CreativeTabs {
	public final String modid;
	public final ResourceLocation background;
	public final boolean hasSearchBar;
	public final boolean displaySpecialItems;

	/**
	 * @author TheP2WKing
	 * @param modid             String
	 * @param background        {@link ResourceLocation}
	 * @param hasSearchBar      boolean
	 * @param displayOtherItems boolean
	 */
	public ModCreativeTabBase(String modid, ResourceLocation background, boolean hasSearchBar,
			boolean displayOtherItems) {
		super(modid + ".name");
		this.modid = modid;
		this.background = background;
		this.hasSearchBar = hasSearchBar;
		this.displaySpecialItems = displayOtherItems;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ItemStack getIconItemStack() {
		return getTabIconItem();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ItemStack getTabIconItem() {
		return ItemStack.EMPTY;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ResourceLocation getBackgroundImage() {
		return this.background;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasSearchBar() {
		return this.hasSearchBar;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void displayAllRelevantItems(NonNullList<ItemStack> list) {
		super.displayAllRelevantItems(list);
		if (this.displaySpecialItems) {
			ModFluidUtil.displayForgeBuckets(list, this.modid);
			ModEntityUtil.displaySpawnEggs(list, this.modid);
			ModPotionUtil.displayPotions(list, this.modid);
		}
	}
}