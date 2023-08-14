package net.thep2wking.oedldoedlcore.api.tool;

import java.util.HashSet;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thep2wking.oedldoedlcore.config.CoreConfig;
import net.thep2wking.oedldoedlcore.init.ModSounds;
import net.thep2wking.oedldoedlcore.util.ModHitSound;

/**
 * @author TheP2WKing
 */
public class ModItemSmashbatBase extends ModItemToolBase {
	public final double verticalMotion;
	public final double horizontalMotion;
	public final ModHitSound hitSound;

	/**
	 * @author TheP2WKing
	 * @param modid            String
	 * @param name             String
	 * @param tab              {@link CreativeTabs}
	 * @param material         {@link ToolMaterial}
	 * @param attackDamage     float
	 * @param attackSpeed      float
	 * @param horizontalMotion double
	 * @param verticalMotion   double
	 * @param hitSound         {@link HitSound}
	 * @param rarity           {@link EnumRarity}
	 * @param hasEffect        boolean
	 * @param tooltipLines     int
	 * @param annotationLines  int
	 */
	public ModItemSmashbatBase(String modid, String name, CreativeTabs tab, ToolMaterial material, float attackDamage,
			float attackSpeed, double horizontalMotion, double verticalMotion, ModHitSound hitSound, EnumRarity rarity,
			boolean hasEffect, int tooltipLines, int annotationLines) {
		super(modid, name, tab, material, attackDamage, attackSpeed, new HashSet<>(), rarity, hasEffect, tooltipLines,
				annotationLines);
		this.verticalMotion = verticalMotion;
		this.horizontalMotion = horizontalMotion;
		this.hitSound = hitSound;
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
		return true;
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

	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
		stack.damageItem(-1, attacker);
		target.motionX *= horizontalMotion;
		target.motionY *= verticalMotion;
		target.motionZ *= horizontalMotion;
		return super.hitEntity(stack, target, attacker);
	}

	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
		if (hitSound == ModHitSound.WOOD && entity instanceof EntityLiving) {
			entity.world.playSound(player, player.getPosition(), ModSounds.SMASH_WOOD, SoundCategory.AMBIENT,
					1.0f, 1.0f);
		}
		if (hitSound == ModHitSound.METAL && entity instanceof EntityLiving) {
			entity.world.playSound(player, player.getPosition(), ModSounds.SMASH_METAL, SoundCategory.AMBIENT,
					1.0f, 1.0f);
		}
		if (hitSound == ModHitSound.GEM && entity instanceof EntityLiving) {
			entity.world.playSound(player, player.getPosition(), ModSounds.SMASH_GEM, SoundCategory.AMBIENT,
					1.0f, 1.0f);
		}
		return super.onLeftClickEntity(stack, player, entity);
	}
}