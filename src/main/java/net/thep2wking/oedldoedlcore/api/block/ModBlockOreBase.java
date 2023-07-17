package net.thep2wking.oedldoedlcore.api.block;

import java.util.Random;

import net.minecraft.block.BlockOre;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlcore.config.CoreConfig;
import net.thep2wking.oedldoedlcore.util.ModToolTypes;

/**
 * @author TheP2WKing
 */
public class ModBlockOreBase extends BlockOre {
	public final String modid;
	public final String name;
	public final CreativeTabs tab;
	public final SoundType sound;
	public final int harvestLevel;
	public final ModToolTypes toolType;
	public final float hardness;
	public final float resistance;
	public final float lightLevel;
	public final int minXp;
	public final int maxXp;

	/**
	 * @author TheP2WKing
	 * @param modid        String
	 * @param name         String
	 * @param tab          {@link CreativeTabs}
	 * @param minXp        int
	 * @param maxXp        int
	 * @param material     {@link Material}
	 * @param sound        {@link SoundType}
	 * @param mapColor     {@link MapColor}
	 * @param harvestLevel int
	 * @param toolType     {@link ModToolTypes}
	 * @param hardness     float
	 * @param resistance   float
	 * @param lightLevel   float
	 */
	public ModBlockOreBase(String modid, String name, CreativeTabs tab, int minXp, int maxXp, Material material, SoundType sound,
			MapColor mapColor, int harvestLevel, ModToolTypes toolType, float hardness, float resistance,
			float lightLevel) {
		super();
		this.modid = modid;
		this.name = name;
		this.tab = tab;
		this.sound = sound;
		this.harvestLevel = harvestLevel;
		this.toolType = toolType;
		this.hardness = hardness;
		this.resistance = resistance;
		this.lightLevel = lightLevel;
		this.minXp = minXp;
		this.maxXp = maxXp;
		setUnlocalizedName(this.modid + "." + this.name);
		setRegistryName(this.modid + ":" + this.name);
		setCreativeTab(this.tab);
		setSoundType(this.sound);
		setHarvestLevel(this.toolType.getToolType(), this.harvestLevel);
		setHardness(this.hardness);
		setResistance(this.resistance);
		setLightLevel(this.lightLevel);
	}

	public int getExperience(Random rand) {
		if (CoreConfig.PROPERTIES.ORES_DROP_EXPERIENCE) {
			return MathHelper.getInt(rand, minXp, maxXp);
		}
		return 0;
	}

	@Override
	public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune) {

		Random rand = world instanceof World ? ((World) world).rand : new Random();
		if (this.getItemDropped(state, rand, fortune) != Item.getItemFromBlock(this)) {
			return getExperience(RANDOM);
		}
		return 0;
	}
}