package net.thep2wking.oedldoedlcore.util;

import java.util.function.Supplier;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraftforge.common.Tags;

public enum ModItemTier implements IItemTier
{
	DEBUG_WRENCH(0, 0, 0f, 0f, 10, () -> Ingredient.fromTag(Tags.Items.INGOTS_IRON)),
	;
	
	private final int harvestLevel;
	private final int maxUses;
	private final float efficiency;
	private final float attackDamage;
	private final int enchantability;
	private final LazyValue<Ingredient> repairMaterial;

	private ModItemTier(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn, int enchantabilityIn, Supplier<Ingredient> repairMaterialIn) 
	{
		this.harvestLevel = harvestLevelIn;
		this.maxUses = maxUsesIn;
		this.efficiency = efficiencyIn;
		this.attackDamage = attackDamageIn;
		this.enchantability = enchantabilityIn;
		this.repairMaterial = new LazyValue<>(repairMaterialIn);
	}

	@Override  
	public int getMaxUses() 
	{
		return maxUses;
	}

	@Override
	public float getEfficiency() 
	{
		return efficiency;
	}

	@Override
	public float getAttackDamage() 
	{
		return attackDamage;
	}

	@Override
	public int getHarvestLevel() 
	{
		return harvestLevel;
	}

	@Override
	public int getEnchantability() 
	{
		return enchantability;
	}

	@Override
	public Ingredient getRepairMaterial() 
	{
		return repairMaterial.getValue();
	}
}