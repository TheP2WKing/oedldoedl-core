package net.thep2wking.oedldoedlcore.content.item.misc;

import java.util.Collection;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.Rarity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.Property;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlcore.api.ModItemBase;
import net.thep2wking.oedldoedlcore.config.CoreConfig;

public class DebugWrenchItem extends ModItemBase {
	public DebugWrenchItem(Rarity rarity, boolean hasEffect, boolean fireImmunity, int tooltipLines,
			int annotationLines, Properties properties) {
		super(rarity, hasEffect, fireImmunity, tooltipLines, annotationLines, properties.maxStackSize(1));
	}

	@Override
	public boolean isDamageable() {
		return false;
	}

	public boolean canPlayerBreakBlockWhileHolding(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
		if (!worldIn.isRemote) {
			this.handleClick(player, state, worldIn, pos, false, player.getHeldItem(Hand.MAIN_HAND));
		}
		return false;
	}

	public ActionResultType onItemUse(ItemUseContext context) {
		if (CoreConfig.debug_wrench_useable_in_survival.get() || context.getPlayer().isCreative()) {
			PlayerEntity playerentity = context.getPlayer();
			World world = context.getWorld();
			if (!world.isRemote && playerentity != null) {
				BlockPos blockpos = context.getPos();
				this.handleClick(playerentity, world.getBlockState(blockpos), world, blockpos, true, context.getItem());
			}
			return ActionResultType.func_233537_a_(world.isRemote);
		}
		return ActionResultType.PASS;
	}

	public void handleClick(PlayerEntity player, BlockState state, IWorld worldIn, BlockPos pos, boolean rightClick,
			ItemStack stack) {
		if (CoreConfig.debug_wrench_useable_in_survival.get() || player.isCreative()) {
			Block block = state.getBlock();
			StateContainer<Block, BlockState> statecontainer = block.getStateContainer();
			Collection<Property<?>> collection = statecontainer.getProperties();
			@SuppressWarnings("deprecation")
			String s = Registry.BLOCK.getKey(block).toString();
			if (collection.isEmpty()) {
				sendMessage(player, new TranslationTextComponent("item.minecraft.debug_stick" + ".empty", s));
			} else {
				CompoundNBT compoundnbt = stack.getOrCreateChildTag("DebugProperty");
				String s1 = compoundnbt.getString(s);
				Property<?> property = statecontainer.getProperty(s1);
				if (rightClick) {
					if (property == null) {
						property = collection.iterator().next();
					}
					BlockState blockstate = cycleProperty(state, property, player.isSecondaryUseActive());
					worldIn.setBlockState(pos, blockstate, 18);
					sendMessage(player, new TranslationTextComponent("item.minecraft.debug_stick" + ".update",
							property.getName(), func_195957_a(blockstate, property)));
				} else {
					property = getAdjacentValue(collection, property, player.isSecondaryUseActive());
					String s2 = property.getName();
					compoundnbt.putString(s, s2);
					sendMessage(player, new TranslationTextComponent("item.minecraft.debug_stick" + ".select", s2,
							func_195957_a(state, property)));
				}
			}
		}
	}

	public static <T extends Comparable<T>> BlockState cycleProperty(BlockState state, Property<T> propertyIn,
			boolean backwards) {
		return state.with(propertyIn,
				getAdjacentValue(propertyIn.getAllowedValues(), state.get(propertyIn), backwards));
	}

	public static <T> T getAdjacentValue(Iterable<T> allowedValues, @Nullable T currentValue, boolean backwards) {
		return (T) (backwards ? Util.getElementBefore(allowedValues, currentValue)
				: Util.getElementAfter(allowedValues, currentValue));
	}

	public static void sendMessage(PlayerEntity player, ITextComponent text) {
		((ServerPlayerEntity) player).func_241151_a_(text, ChatType.GAME_INFO, Util.DUMMY_UUID);
	}

	public static <T extends Comparable<T>> String func_195957_a(BlockState state, Property<T> propertyIn) {
		return propertyIn.getName(state.get(propertyIn));
	}
}