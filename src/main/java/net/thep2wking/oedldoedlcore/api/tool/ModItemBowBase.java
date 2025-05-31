package net.thep2wking.oedldoedlcore.api.tool;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thep2wking.oedldoedlcore.config.CoreConfig;
import net.thep2wking.oedldoedlcore.util.ModTooltips;

/**
 * @author TheP2WKing
 */
public class ModItemBowBase extends ItemBow {
	public final String modid;
	public final String name;
	public final CreativeTabs tab;
	public final ToolMaterial material;
	public final float drawTime;
	public final double extraDamage;
	public final EnumRarity rarity;
	public final boolean hasEffect;
	public final int tooltipLines;
	public final int annotationLines;

	/**
	 * @author TheP2WKing
	 * @param modid           String
	 * @param name            String
	 * @param tab             {@link CreativeTabs}
	 * @param material        {@link ToolMaterial}
	 * @param rarity          {@link EnumRarity}
	 * @param hasEffect       boolean
	 * @param tooltipLines    int
	 * @param annotationLines int
	 */
	public ModItemBowBase(String modid, String name, CreativeTabs tab, ToolMaterial material, EnumRarity rarity,
			boolean hasEffect, int tooltipLines, int annotationLines) {
		this.modid = modid;
		this.name = name;
		this.tab = tab;
		this.material = material;
		this.drawTime = 20.0f;
		this.extraDamage = 0.0D;
		this.rarity = rarity;
		this.hasEffect = hasEffect;
		this.tooltipLines = tooltipLines;
		this.annotationLines = annotationLines;
		setUnlocalizedName(this.modid + "." + this.name);
		setRegistryName(this.modid + ":" + this.name);
		setCreativeTab(this.tab);
		setMaxStackSize(1);
		setMaxDamage(this.material.getMaxUses() + 325);
		this.addPropertyOverride(new ResourceLocation("pull"), new IItemPropertyGetter() {
			@Override
			@SideOnly(Side.CLIENT)
			public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {
				if (entityIn == null) {
					return 0.0F;
				} else {
					return !(entityIn.getActiveItemStack().getItem() instanceof ItemBow) ? 0.0F
							: (float) (stack.getMaxItemUseDuration() - entityIn.getItemInUseCount()) / drawTime;
				}
			}
		});
		this.addPropertyOverride(new ResourceLocation("pulling"), new IItemPropertyGetter() {
			@Override
			@SideOnly(Side.CLIENT)
			public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {
				return entityIn != null && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F
						: 0.0F;
			}
		});
	}

	/**
	 * @author TheP2WKing
	 * @param modid           String
	 * @param name            String
	 * @param tab             {@link CreativeTabs}
	 * @param material        {@link ToolMaterial}
	 * @param drawTime        float
	 * @param extraDamage     double
	 * @param rarity          {@link EnumRarity}
	 * @param hasEffect       boolean
	 * @param tooltipLines    int
	 * @param annotationLines int
	 */
	public ModItemBowBase(String modid, String name, CreativeTabs tab, ToolMaterial material, float drawTime,
			double extraDamage, EnumRarity rarity, boolean hasEffect, int tooltipLines, int annotationLines) {
		this.modid = modid;
		this.name = name;
		this.tab = tab;
		this.material = material;
		this.drawTime = drawTime;
		this.extraDamage = extraDamage;
		this.rarity = rarity;
		this.hasEffect = hasEffect;
		this.tooltipLines = tooltipLines;
		this.annotationLines = annotationLines;
		setUnlocalizedName(this.modid + "." + this.name);
		setRegistryName(this.modid + ":" + this.name);
		setCreativeTab(this.tab);
		setMaxStackSize(1);
		setMaxDamage(this.material.getMaxUses() + 325);
		this.addPropertyOverride(new ResourceLocation("pull"), new IItemPropertyGetter() {
			@Override
			@SideOnly(Side.CLIENT)
			public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {
				if (entityIn == null) {
					return 0.0F;
				} else if (CoreConfig.PROPERTIES.BOWS.MODIFIED_DRAW_TIME) {
					return !(entityIn.getActiveItemStack().getItem() instanceof ItemBow) ? 0.0F
							: (float) (stack.getMaxItemUseDuration() - entityIn.getItemInUseCount()) / drawTime;
				} else {
					return !(entityIn.getActiveItemStack().getItem() instanceof ItemBow) ? 0.0F
							: (float) (stack.getMaxItemUseDuration() - entityIn.getItemInUseCount()) / 20.0f;
				}
			}
		});
		this.addPropertyOverride(new ResourceLocation("pulling"), new IItemPropertyGetter() {
			@Override
			@SideOnly(Side.CLIENT)
			public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {
				return entityIn != null && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F
						: 0.0F;
			}
		});
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
		return enchantment.type.canEnchantItem(stack.getItem()) || enchantment.canApply(new ItemStack(Items.BOW));
	}

	private boolean hasRGBBar;
	private int colorRGB;

	public ItemBow setRGBBarColor(int color) {
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

	@Override
	public boolean isArrow(ItemStack stack) {
		return stack.getItem() instanceof ItemArrow;
	}

	@Override
	public int getItemEnchantability() {
		return this.material.getEnchantability();
	}

	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityLivingBase entityLiving, int timeLeft) {
		if (entityLiving instanceof EntityPlayer) {
			EntityPlayer entityplayer = (EntityPlayer) entityLiving;
			boolean flag = entityplayer.capabilities.isCreativeMode
					|| EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, stack) > 0;
			ItemStack itemstack = this.findAmmo(entityplayer);
			int i = this.getMaxItemUseDuration(stack) - timeLeft;
			i = ForgeEventFactory.onArrowLoose(stack, worldIn, entityplayer, i,
					!itemstack.isEmpty() || flag);
			if (i < 0)
				return;
			if (!itemstack.isEmpty() || flag) {
				if (itemstack.isEmpty()) {
					itemstack = new ItemStack(Items.ARROW);
				}
				float f = getArrowVelocity(i);
				if ((double) f >= 0.1D) {
					boolean flag1 = entityplayer.capabilities.isCreativeMode
							|| (itemstack.getItem() instanceof ItemArrow
									&& ((ItemArrow) itemstack.getItem()).isInfinite(itemstack, stack, entityplayer));
					if (!worldIn.isRemote) {
						ItemArrow itemarrow = (ItemArrow) (itemstack.getItem() instanceof ItemArrow
								? itemstack.getItem()
								: Items.ARROW);
						EntityArrow entityarrow = itemarrow.createArrow(worldIn, itemstack, entityplayer);
						entityarrow = this.customizeArrow(entityarrow);
						if (CoreConfig.PROPERTIES.BOWS.EXTRA_ARROW_DAMAGE) {
							entityarrow.setDamage(entityarrow.getDamage() + this.extraDamage);
						}
						entityarrow.shoot(entityplayer, entityplayer.rotationPitch, entityplayer.rotationYaw, 0.0F,
								f * 3.0F, 1.0F);
						if (f == 1.0F) {
							entityarrow.setIsCritical(true);
						}
						int j = EnchantmentHelper.getEnchantmentLevel(Enchantments.POWER, stack);
						if (j > 0) {
							entityarrow.setDamage(entityarrow.getDamage() + (double) j * 0.5D + 0.5D);
						}
						int k = EnchantmentHelper.getEnchantmentLevel(Enchantments.PUNCH, stack);
						if (k > 0) {
							entityarrow.setKnockbackStrength(k);
						}
						if (EnchantmentHelper.getEnchantmentLevel(Enchantments.FLAME, stack) > 0) {
							entityarrow.setFire(100);
						}
						stack.damageItem(1, entityplayer);
						if (flag1 || entityplayer.capabilities.isCreativeMode
								&& (itemstack.getItem() == Items.SPECTRAL_ARROW
										|| itemstack.getItem() == Items.TIPPED_ARROW)) {
							entityarrow.pickupStatus = EntityArrow.PickupStatus.CREATIVE_ONLY;
						}
						worldIn.spawnEntity(entityarrow);
					}
					worldIn.playSound((EntityPlayer) null, entityplayer.posX, entityplayer.posY, entityplayer.posZ,
							SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1.0F,
							1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
					if (!flag1 && !entityplayer.capabilities.isCreativeMode) {
						itemstack.shrink(1);
						if (itemstack.isEmpty()) {
							entityplayer.inventory.deleteStack(itemstack);
						}
					}
					entityplayer.addStat(StatList.getObjectUseStats(this));
				}
			}
		}
	}

	@Override
	public boolean isRepairable() {
		return true;
	}

	public ItemStack getRepairStackFromMaterial() {
		return this.material.getRepairItemStack();
	}

	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		if (getRepairStackFromMaterial() != null) {
			if (getRepairStackFromMaterial() instanceof ItemStack) {
				return repair.isItemEqual((ItemStack) getRepairStackFromMaterial());
			}
		}
		return super.getIsRepairable(toRepair, repair);
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