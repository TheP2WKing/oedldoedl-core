package net.thep2wking.oedldoedlcore.api;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Maps;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CampfireBlock;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.Rarity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import net.thep2wking.oedldoedlcore.config.CoreConfig;

public class ModPaxelItemBase extends ModToolItemBase {
	public static final Map<Block, BlockState> SHOVEL_LOOKUP = Maps
			.newHashMap(ImmutableMap.of(Blocks.GRASS_BLOCK, Blocks.GRASS_PATH.getDefaultState()));
	public static final Map<Block, Block> BLOCK_STRIPPING_MAP = (new Builder<Block, Block>())
			.put(Blocks.OAK_WOOD, Blocks.STRIPPED_OAK_WOOD).put(Blocks.OAK_LOG, Blocks.STRIPPED_OAK_LOG)
			.put(Blocks.DARK_OAK_WOOD, Blocks.STRIPPED_DARK_OAK_WOOD)
			.put(Blocks.DARK_OAK_LOG, Blocks.STRIPPED_DARK_OAK_LOG).put(Blocks.ACACIA_WOOD, Blocks.STRIPPED_ACACIA_WOOD)
			.put(Blocks.ACACIA_LOG, Blocks.STRIPPED_ACACIA_LOG).put(Blocks.BIRCH_WOOD, Blocks.STRIPPED_BIRCH_WOOD)
			.put(Blocks.BIRCH_LOG, Blocks.STRIPPED_BIRCH_LOG).put(Blocks.JUNGLE_WOOD, Blocks.STRIPPED_JUNGLE_WOOD)
			.put(Blocks.JUNGLE_LOG, Blocks.STRIPPED_JUNGLE_LOG).put(Blocks.SPRUCE_WOOD, Blocks.STRIPPED_SPRUCE_WOOD)
			.put(Blocks.SPRUCE_LOG, Blocks.STRIPPED_SPRUCE_LOG).put(Blocks.WARPED_STEM, Blocks.STRIPPED_WARPED_STEM)
			.put(Blocks.WARPED_HYPHAE, Blocks.STRIPPED_WARPED_HYPHAE)
			.put(Blocks.CRIMSON_STEM, Blocks.STRIPPED_CRIMSON_STEM)
			.put(Blocks.CRIMSON_HYPHAE, Blocks.STRIPPED_CRIMSON_HYPHAE).build();

	/**
	 * @author TheP2WKing
	 * @param itemTier        {@link IItemTier}
	 * @param attackDamage    float
	 * @param attackSpeed     float
	 * @param effectiveBlocks {@link HashSet}
	 * @param rarity          {@link Rarity}
	 * @param hasEffect       boolean
	 * @param fireImmunity    boolean
	 * @param tooltipLines    int
	 * @param annotationLines int
	 * @param properties      {@link Properties}
	 */
	public ModPaxelItemBase(IItemTier itemTier, float attackDamage, float attackSpeed, Set<Block> effectiveBlocks,
			Rarity rarity, boolean hasEffect, boolean fireImmunity, int tooltipLines, int annotationLines,
			Properties properties) {
		super(itemTier, attackDamage, attackSpeed, effectiveBlocks, rarity, hasEffect, fireImmunity, tooltipLines,
				annotationLines,
				properties.maxStackSize(1).addToolType(ToolType.AXE, itemTier.getHarvestLevel())
						.addToolType(ToolType.PICKAXE, itemTier.getHarvestLevel())
						.addToolType(ToolType.SHOVEL, itemTier.getHarvestLevel()));
	}

	@Override
	public int getMaxDamage(ItemStack stack) {
		return (int) (this.getTier().getMaxUses() * CoreConfig.paxel_durability_multiplier.get());
	}

	@Override
	public int getHarvestLevel(@Nonnull ItemStack stack, @Nonnull ToolType tool, @Nullable PlayerEntity player,
			@Nullable BlockState blockState) {
		if (tool == ToolType.AXE || tool == ToolType.PICKAXE || tool == ToolType.SHOVEL) {
			return this.getTier().getHarvestLevel();
		}
		return super.getHarvestLevel(stack, tool, player, blockState);
	}

	@Override
	public float getDestroySpeed(ItemStack stack, BlockState state) {
		if (state.matchesBlock(Blocks.COBWEB)) {
			return (float) (this.getTier().getEfficiency() * 1.25 * 2);
		}
		return (float) (this.getTier().getEfficiency() * 1.25);
	}

	@Override
	public boolean canHarvestBlock(BlockState blockIn) {
		int i = this.getTier().getHarvestLevel();
		if (blockIn.getHarvestTool() == ToolType.PICKAXE) {
			return i >= blockIn.getHarvestLevel();
		} else if (blockIn.matchesBlock(Blocks.COBWEB) || blockIn.matchesBlock(Blocks.SNOW)
				|| blockIn.matchesBlock(Blocks.SNOW_BLOCK) || blockIn.matchesBlock(Blocks.GLASS)
				|| blockIn.matchesBlock(Blocks.GLASS_PANE)) {
			return i >= blockIn.getHarvestLevel();
		}
		Material material = blockIn.getMaterial();
		return material == Material.ROCK || material == Material.IRON || material == Material.ANVIL;
	}

	public ActionResultType onItemUse(ItemUseContext context) {
		World world = context.getWorld();
		BlockPos blockpos = context.getPos();
		BlockState blockstate = world.getBlockState(blockpos);
		PlayerEntity playerentity = context.getPlayer();
		BlockState blockstate1 = blockstate.getToolModifiedState(world, blockpos, playerentity, context.getItem(),
				ToolType.SHOVEL);
		BlockState blockstate2 = null;
		if (blockstate1 != null && world.isAirBlock(blockpos.up())) {
			world.playSound(playerentity, blockpos, SoundEvents.ITEM_SHOVEL_FLATTEN, SoundCategory.BLOCKS, 1.0F, 1.0F);
			blockstate2 = blockstate1;
		} else if (blockstate.getBlock() instanceof CampfireBlock && blockstate.get(CampfireBlock.LIT)) {
			if (!world.isRemote()) {
				world.playEvent((PlayerEntity) null, 1009, blockpos, 0);
			}
			CampfireBlock.extinguish(world, blockpos, blockstate);
			blockstate2 = blockstate.with(CampfireBlock.LIT, Boolean.valueOf(false));
		}

		if (blockstate2 != null) {
			if (!world.isRemote) {
				world.setBlockState(blockpos, blockstate2, 11);
				if (playerentity != null) {
					context.getItem().damageItem(1, playerentity, (player) -> {
						player.sendBreakAnimation(context.getHand());
					});
				}
			}
			return ActionResultType.func_233537_a_(world.isRemote);
		}

		World worldAxe = context.getWorld();
		BlockPos blockposAxe = context.getPos();
		BlockState blockstateAxe = worldAxe.getBlockState(blockposAxe);
		BlockState blockAxe = blockstateAxe.getToolModifiedState(worldAxe, blockposAxe, context.getPlayer(),
				context.getItem(), ToolType.AXE);
		if (blockAxe != null) {
			PlayerEntity playerentityAxe = context.getPlayer();
			worldAxe.playSound(playerentityAxe, blockposAxe, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0F,
					1.0F);
			if (!worldAxe.isRemote) {
				worldAxe.setBlockState(blockposAxe, blockAxe, 11);
				if (playerentityAxe != null) {
					context.getItem().damageItem(1, playerentityAxe, (playerAxe) -> {
						playerAxe.sendBreakAnimation(context.getHand());
					});
				}
			}
			return ActionResultType.func_233537_a_(worldAxe.isRemote);
		} else {
			return ActionResultType.PASS;
		}
	}

	@Nullable
	public static BlockState getShovelPathingState(BlockState originalState) {
		return SHOVEL_LOOKUP.get(originalState.getBlock());
	}

	@Nullable
	public static BlockState getAxeStrippingState(BlockState originalState) {
		Block block = BLOCK_STRIPPING_MAP.get(originalState.getBlock());
		return block != null
				? block.getDefaultState().with(RotatedPillarBlock.AXIS, originalState.get(RotatedPillarBlock.AXIS))
				: null;
	}
}