package net.thep2wking.oedldoedlcore.api.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.thep2wking.oedldoedlcore.config.CoreConfig;
import net.thep2wking.oedldoedlcore.util.ModToolTypes;

/**
 * @author TheP2WKing
 */
public class ModBlockBase extends Block {
    public final String modid;
    public final String name;
    public final CreativeTabs tab;
    public final SoundType sound;
    public final MapColor mapColor;
    public final int harvestLevel;
    public final ModToolTypes toolType;
    public final float hardness;
    public final float resistance;
    public final int lightLevel;

    /**
     * @author TheP2WKing
     * @param modid        String
     * @param name         String
     * @param tab          {@link CreativeTabs}
     * @param material     {@link Material}
     * @param sound        {@link SoundType}
     * @param mapColor     {@link MapColor}
     * @param harvestLevel int
     * @param toolType     {@link ModToolTypes}
     * @param hardness     float
     * @param resistance   float
     * @param lightLevel   int
     */
    public ModBlockBase(String modid, String name, CreativeTabs tab, Material material, SoundType sound,
            MapColor mapColor, int harvestLevel, ModToolTypes toolType, float hardness, float resistance,
            int lightLevel) {
        super(material);
        this.modid = modid;
        this.name = name;
        this.tab = tab;
        this.sound = sound;
        this.mapColor = mapColor;
        this.harvestLevel = harvestLevel;
        this.toolType = toolType;
        this.hardness = hardness;
        this.resistance = resistance;
        this.lightLevel = lightLevel;
        setUnlocalizedName(this.modid + "." + this.name);
        setRegistryName(this.modid + ":" + this.name);
        setCreativeTab(this.tab);
        setSoundType(this.sound);
        setHarvestLevel(this.toolType.getToolType(), this.harvestLevel);
        setHardness(this.hardness);
        setResistance(this.resistance);
    }

    @Override
    public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
        return mapColor;
    }

    @Override
    public int getLightValue(IBlockState state, IBlockAccess world, BlockPos pos) {
        if (CoreConfig.PROPERTIES.BLOCKS_EMIT_LIGHT) {
            return lightLevel;
        }
        return 0;
    }

    private boolean isBeaconBase;

    public Block setBeaconBase() {
        isBeaconBase = CoreConfig.PROPERTIES.BEACONS.BEACON_BASES;
        return this;
    }

    @Override
    public boolean isBeaconBase(IBlockAccess worldObj, BlockPos pos, BlockPos beacon) {
        return isBeaconBase;
    }
}