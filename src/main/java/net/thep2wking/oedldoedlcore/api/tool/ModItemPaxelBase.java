package net.thep2wking.oedldoedlcore.api.tool;

import java.util.HashSet;
import java.util.Set;

import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thep2wking.oedldoedlcore.config.CoreConfig;
import net.thep2wking.oedldoedlcore.util.ModToolTypes;

public class ModItemPaxelBase extends ModItemToolBase {
	/**
	 * @author TheP2WKing
	 * @param modid           String
	 * @param name            String
	 * @param tab             {@link CreativeTabs}
	 * @param material        {@link ToolMaterial}
	 * @param attackDamage    float
	 * @param attackSpeed     float
	 * @param rarity          {@link EnumRarity}
	 * @param hasEffect       boolean
	 * @param tooltipLines    int
	 * @param annotationLines int
	 */
	public ModItemPaxelBase(String modid, String name, CreativeTabs tab, ToolMaterial material, float attackDamage,
			float attackSpeed, EnumRarity rarity, boolean hasEffect, int tooltipLines,
			int annotationLines) {
		super(modid, name, tab, material, attackDamage, attackSpeed, new HashSet<>(), rarity, hasEffect, tooltipLines,
				annotationLines);
		setMaxDamage((int) (material.getMaxUses() * CoreConfig.PROPERTIES.PAXEL_DURABILITY_MULTIPLIER));
		setHarvestLevel(ModToolTypes.AXE.getToolType(), material.getHarvestLevel());
		setHarvestLevel(ModToolTypes.PICKAXE.getToolType(), material.getHarvestLevel());
		setHarvestLevel(ModToolTypes.SHOVEL.getToolType(), material.getHarvestLevel());
		setHarvestLevel(ModToolTypes.HOE.getToolType(), material.getHarvestLevel());
	}

	private boolean hasRGBBar;
	private int colorRGB;

	public ItemTool setRGBBarColor(int color) {
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

	@SuppressWarnings("null")
	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
		return enchantment.type.canEnchantItem(stack.getItem()) || enchantment.canApply(new ItemStack(Items.IRON_AXE))
				|| enchantment.canApply(new ItemStack(Items.IRON_SHOVEL))
				|| enchantment.canApply(new ItemStack(Items.IRON_PICKAXE))
				|| enchantment.canApply(new ItemStack(Items.IRON_HOE));
	}

	@Override
	public boolean canDisableShield(ItemStack stack, ItemStack shield, EntityLivingBase entity,
			EntityLivingBase attacker) {
		return true;
	}

	@Override
	public Set<String> getToolClasses(ItemStack stack) {
		return Sets.newHashSet(ModToolTypes.AXE.getToolType(), ModToolTypes.PICKAXE.getToolType(),
				ModToolTypes.SHOVEL.getToolType());
	}

	@Override
	public float getDestroySpeed(ItemStack stack, IBlockState state) {
		return this.toolMaterial.getEfficiency() * 1.5f;
	}

	@Override
	public boolean canHarvestBlock(IBlockState blockIn) {
		Block block = blockIn.getBlock();
		if (block == Blocks.SNOW_LAYER || block == Blocks.SNOW) {
			return true;
		}
		if (block == Blocks.OBSIDIAN) {
			return this.toolMaterial.getHarvestLevel() >= 3;
		} else if (block == Blocks.DIAMOND_BLOCK || block == Blocks.DIAMOND_ORE) {
			return this.toolMaterial.getHarvestLevel() >= 2;
		} else if (block == Blocks.EMERALD_ORE || block == Blocks.EMERALD_BLOCK) {
			return this.toolMaterial.getHarvestLevel() >= 2;
		} else if (block == Blocks.GOLD_BLOCK || block == Blocks.GOLD_ORE) {
			return this.toolMaterial.getHarvestLevel() >= 2;
		} else if (block == Blocks.IRON_BLOCK || block == Blocks.IRON_ORE) {
			return this.toolMaterial.getHarvestLevel() >= 1;
		} else if (block == Blocks.LAPIS_BLOCK || block == Blocks.LAPIS_ORE) {
			return this.toolMaterial.getHarvestLevel() >= 1;
		} else if (block == Blocks.REDSTONE_ORE || block == Blocks.LIT_REDSTONE_ORE) {
			return this.toolMaterial.getHarvestLevel() >= 2;
		}
		Material material = blockIn.getMaterial();
		if (material == Material.ROCK) {
			return true;
		} else if (material == Material.IRON) {
			return true;
		} else if (material == Material.LEAVES) {
			return true;
		} else if (material == Material.WEB) {
			return true;
		}
		return material == Material.ANVIL;
	}

	@Override
	public EnumActionResult onItemUse(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand,
			EnumFacing side, float hitX, float hitY, float hitZ) {
		if (!playerIn.isSneaking()) {
			return Items.DIAMOND_HOE.onItemUse(playerIn, worldIn, pos, hand, side, hitX, hitY, hitZ);
		}
		return Items.DIAMOND_SHOVEL.onItemUse(playerIn, worldIn, pos, hand, side, hitX, hitY, hitZ);
	}
}