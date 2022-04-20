package net.thep2wking.oedldoedlcore.api;

import java.util.HashSet;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.SoundCategory;
import net.thep2wking.oedldoedlcore.init.ModSounds;

public class ModSmashbatItemBase extends ModToolItemBase {
	public double verticalMotion;
	public double horizontalMotion;

	public enum HitSound {
		WOOD(), METAL(), GEM();
	}

	public HitSound hitSound = HitSound.WOOD;

	/**
	 * @author TheP2WKing
	 * @param itemTier         {@link IItemTier}
	 * @param attackDamage     float
	 * @param attackSpeed      float
	 * @param horizontalMotion double
	 * @param verticalMotion   double
	 * @param hitSound         {@link HitSound}
	 * @param effectiveBlocks  {@link HashSet}
	 * @param rarity           {@link Rarity}
	 * @param hasEffect        boolean
	 * @param fireImmunity     boolean
	 * @param annotationLines  int
	 * @param tooltipLines     int
	 * @param properties       {@link Properties}
	 */
	public ModSmashbatItemBase(IItemTier itemTier, float attackDamage, float attackSpeed, double horizontalMotion,
			double verticalMotion, HitSound hitSound, Set<Block> effectiveBlocks, Rarity rarity, boolean hasEffect,
			boolean fireImmunity, int tooltipLines, int annotationLines, Properties properties) {
		super(itemTier, attackDamage, attackSpeed, effectiveBlocks, rarity, hasEffect, fireImmunity, tooltipLines,
				annotationLines, properties);
		this.verticalMotion = verticalMotion;
		this.horizontalMotion = horizontalMotion;
		this.hitSound = hitSound;
	}

	@Override
	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		stack.damageItem(-1, attacker, null);
		target.setMotion(target.getMotion().x * horizontalMotion, target.getMotion().y * verticalMotion,
				target.getMotion().z * horizontalMotion);
		return super.hitEntity(stack, target, attacker);
	}

	@Override
	public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity) {
		if (hitSound == HitSound.WOOD) {
			entity.world.playSound(player, player.getPosition(), ModSounds.SMASH_WOOD.get(), SoundCategory.AMBIENT,
					10.0f, 1.0f);
		}
		if (hitSound == HitSound.METAL) {
			entity.world.playSound(player, player.getPosition(), ModSounds.SMASH_METAL.get(), SoundCategory.AMBIENT,
					10.0f, 1.0f);
		}
		if (hitSound == HitSound.GEM) {
			entity.world.playSound(player, player.getPosition(), ModSounds.SMASH_GEM.get(), SoundCategory.AMBIENT,
					10.0f, 1.0f);
		}
		return super.onLeftClickEntity(stack, player, entity);
	}
}