package net.thep2wking.oedldoedlcore.api;

import java.util.List;
import java.util.function.Supplier;

import javax.annotation.Nullable;

import net.minecraft.block.DispenserBlock;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.Rarity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.fluids.capability.wrappers.FluidBucketWrapper;
import net.thep2wking.oedldoedlcore.config.CoreConfig;
import net.thep2wking.oedldoedlcore.util.ModRarities;
import net.thep2wking.oedldoedlcore.util.ModTooltips;

public class ModBucketItemBase extends BucketItem {
	public Rarity rarity = ModRarities.WHITE;
	public boolean hasEffect;
	public boolean fireImmunity;
	public int tooltipLines;
	public int annotationLines;

	/**
	 * @author TheP2WKing
	 * @param supplier        {@link Supplier}
	 * @param rarity          {@link Rarity}
	 * @param hasEffect       boolean
	 * @param fireImmunity    boolean
	 * @param tooltipLines    int
	 * @param annotationLines int
	 * @param properties      {@link Properties}
	 */
	public ModBucketItemBase(Supplier<? extends Fluid> supplier, Rarity rarity, boolean hasEffect, boolean fireImmunity,
			int tooltipLines, int annotationLines, Properties properties) {
		super(supplier, properties.maxStackSize(1));
		this.rarity = rarity;
		this.hasEffect = hasEffect;
		this.fireImmunity = fireImmunity;
		this.tooltipLines = tooltipLines;
		this.annotationLines = annotationLines;

		DispenserBlock.registerDispenseBehavior(this.getItem(), new DefaultDispenseItemBehavior() {
			public final DefaultDispenseItemBehavior instance = new DefaultDispenseItemBehavior();

			@Override
			public ItemStack dispenseStack(IBlockSource source, ItemStack stack) {
				BucketItem bucketitem = (BucketItem) stack.getItem();
				BlockPos blockpos = source.getBlockPos().offset(source.getBlockState().get(DispenserBlock.FACING));
				World world = source.getWorld();
				if (bucketitem.tryPlaceContainedLiquid(null, world, blockpos, null)) {
					bucketitem.onLiquidPlaced(world, stack, blockpos);
					return new ItemStack(Items.BUCKET);
				} else {
					return this.instance.dispense(source, stack);
				}
			}
		});
	}

	@Override
	public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundNBT nbt) {
		if (this.getClass() == ModBucketItemBase.class)
			return new FluidBucketWrapper(stack);
		else
			return super.initCapabilities(stack, nbt);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public Rarity getRarity(ItemStack stack) {
		if (!stack.isEnchanted() && CoreConfig.item_rarities.get()) {
			return this.rarity;
		} else if (stack.isEnchanted()) {
			switch (this.rarity) {
			case COMMON:
			case UNCOMMON:
				return Rarity.RARE;
			case RARE:
				return Rarity.EPIC;
			case EPIC:
			default:
				return rarity;
			}
		}
		return ModRarities.WHITE;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean hasEffect(ItemStack stack) {
		if (CoreConfig.enchantment_effects.get()) {
			return hasEffect || stack.isEnchanted();
		}
		return stack.isEnchanted();
	}

	@Override
	public boolean isImmuneToFire() {
		if (CoreConfig.fire_immunity.get()) {
			return fireImmunity;
		}
		return false;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		if (ModTooltips.showAnnotationTip()) {
			for (int i = 1; i <= annotationLines; ++i) {
				ModTooltips.addAnnotation(tooltip, this.getTranslationKey(), i);
			}
		}
		if (ModTooltips.showInfoTip()) {
			for (int i = 1; i <= tooltipLines; ++i) {
				ModTooltips.addInformation(tooltip, this.getTranslationKey(), i);
			}
		} else if (ModTooltips.showInfoTipKey() && !(tooltipLines == 0)) {
			ModTooltips.addKey(tooltip, ModTooltips.KEY_INFO);
		}
	}
}