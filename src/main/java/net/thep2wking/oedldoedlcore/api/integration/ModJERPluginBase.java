package net.thep2wking.oedldoedlcore.api.integration;

import jeresources.api.conditionals.LightLevel;
import jeresources.api.distributions.DistributionSquare;
import jeresources.api.distributions.DistributionTriangular;
import jeresources.api.drop.LootDrop;
import jeresources.api.restrictions.Restriction;
import jeresources.compatibility.CompatBase;
import jeresources.compatibility.JERAPI;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Loader;
import net.thep2wking.oedldoedlcore.util.ModLogger;
import net.thep2wking.oedldoedlcore.util.integration.IJERPlugin;

public abstract class ModJERPluginBase extends CompatBase implements IJERPlugin {
	@Override
	public final void init(boolean worldGen) {
		if (Loader.isModLoaded("jeresources")) {
			ModLogger.registeredIntegration("JER", getModId());
		}
		register();
	}

	public abstract String getModId();

	public abstract void register();

	public void addMob(EntityLivingBase entity, LightLevel lightLevel, int experience,
			ResourceLocation lootTable) {
		JERAPI.getInstance().getMobRegistry().register(entity, lightLevel, experience, lootTable);
	}

	public void addDungeonLoot(String name, ResourceLocation chest) {
		JERAPI.getInstance().getDungeonRegistry().registerChest("chest." + getModId() + "." + name + ".jer", chest);
	}

	public void addOreGen(Block block, int veinSize, int chance, int minY, int maxY) {
		JERAPI.getInstance().getWorldGenRegistry().register(new ItemStack(block),
				new DistributionSquare((int) ((chance - 1) / 2), veinSize, minY, maxY), new LootDrop[0]);
	}

	public void addOreGen(Block block, int veinSize, int chance, int minY, int maxY, Restriction restriction) {
		JERAPI.getInstance().getWorldGenRegistry().register(new ItemStack(block),
				new DistributionSquare((int) ((chance - 1) / 2), veinSize, minY, maxY), restriction, new LootDrop[0]);
	}

	public void addOreGen(Block block, int veinSize, int chance, int minY, int maxY, LootDrop[] drops) {
		JERAPI.getInstance().getWorldGenRegistry().register(new ItemStack(block),
				new DistributionSquare((int) ((chance - 1) / 2), veinSize, minY, maxY), true, drops);
	}

	public void addOreGen(Block block, int veinSize, int chance, int minY, int maxY, Restriction restriction,
			LootDrop[] drops) {
		JERAPI.getInstance().getWorldGenRegistry().register(new ItemStack(block),
				new DistributionSquare((int) ((chance - 1) / 2), veinSize, minY, maxY), restriction, true, drops);
	}

	public void addSpikeOreGen(Block block, int midY, int range, float maxChance) {
		JERAPI.getInstance().getWorldGenRegistry().register(new ItemStack(block),
				new DistributionTriangular(midY, range, maxChance), new LootDrop[0]);
	}

	public void addSpikeOreGen(Block block, int midY, int range, float maxChance, Restriction restriction) {
		JERAPI.getInstance().getWorldGenRegistry().register(new ItemStack(block),
				new DistributionTriangular(midY, range, maxChance), restriction, new LootDrop[0]);
	}

	public void addSpikeOreGen(Block block, int midY, int range, float maxChance, LootDrop[] drops) {
		JERAPI.getInstance().getWorldGenRegistry().register(new ItemStack(block),
				new DistributionTriangular(midY, range, maxChance), true, drops);
	}

	public void addSpikeOreGen(Block block, int midY, int range, float maxChance, Restriction restriction,
			LootDrop[] drops) {
		JERAPI.getInstance().getWorldGenRegistry().register(new ItemStack(block),
				new DistributionTriangular(midY, range, maxChance), restriction, true, drops);
	}
}