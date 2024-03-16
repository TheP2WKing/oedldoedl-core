package net.thep2wking.oedldoedlcore.content.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.thep2wking.oedldoedlcore.api.item.ModItemBase;
import net.thep2wking.oedldoedlcore.config.CoreConfig;
import net.thep2wking.oedldoedlcore.util.ModTooltips;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

import javax.annotation.Nullable;

import com.google.common.collect.ImmutableList;

public class ItemDebugStick extends ModItemBase {
	public ItemDebugStick(String modid, String name, CreativeTabs tab, EnumRarity rarity, boolean hasEffect,
			int tooltipLines, int annotationLines) {
		super(modid, name, tab, rarity, hasEffect, tooltipLines, annotationLines);
		setMaxStackSize(1);
	}

	@Override
	public int getItemBurnTime(ItemStack itemStack) {
		return 100;
	}

	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing,
			float hitX, float hitY, float hitZ) {
		Block block = world.getBlockState(pos).getBlock();
		if (CoreConfig.CONTENT.DEBUG_STICK_USEABLE_IN_SURVIVAL ||
				player.capabilities.isCreativeMode) {
			if (block.getBlockState().getValidStates().size() > 0) {
				if (!world.isRemote) {
					IBlockState currentState = world.getBlockState(pos);
					ImmutableList<IBlockState> validStates = block.getBlockState().getValidStates();
					int currentIndex = validStates.indexOf(currentState);
					int nextIndex = (currentIndex + 1) % validStates.size();
					IBlockState nextState = validStates.get(nextIndex);
					if (currentIndex != nextIndex) {
						world.setBlockState(pos, nextState);
					}
					return EnumActionResult.FAIL;
				}
				return EnumActionResult.SUCCESS;
			}
		}
		return super.onItemUse(player, world, pos, hand, facing, hitX, hitY, hitZ);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		if (ModTooltips.showAnnotationTip()) {
			tooltip.add(CoreConfig.TOOLTIPS.COLORS.INFORMATION_ANNOTATION_FORMATTING.getColor()
					+ I18n.format(this.getUnlocalizedName() + ".annotation1") + " " + TextFormatting.YELLOW
					+ (CoreConfig.CONTENT.DEBUG_STICK_USEABLE_IN_SURVIVAL
							? I18n.format(this.getUnlocalizedName() + ".annotation2")
							: I18n.format(this.getUnlocalizedName() + ".annotation3")));
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