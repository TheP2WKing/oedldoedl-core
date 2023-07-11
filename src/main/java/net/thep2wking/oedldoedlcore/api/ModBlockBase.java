package net.thep2wking.oedldoedlcore.api;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.thep2wking.oedldoedlcore.util.ModToolTypes;

/**
 * @author TheP2WKing
 */
public class ModBlockBase extends Block {
    public final String modid;
    public final String name;
    public final CreativeTabs tab;
    public final SoundType sound;
    public final int harvestLevel;
    public final ModToolTypes toolType;
    public final float hardness;
    public final float resistance;
    public final float lightLevel;

    public ModBlockBase(String modid, String name, CreativeTabs tab, Material material, SoundType sound,
            int harvestLevel, ModToolTypes toolType, float hardness, float resistance, float lightLevel) {
        super(material);
        this.modid = modid;
        this.name = name;
        this.tab = tab;
        this.sound = sound;
        this.harvestLevel = harvestLevel;
        this.toolType = toolType;
        this.hardness = hardness;
        this.resistance = resistance;
        this.lightLevel = lightLevel;
        setUnlocalizedName(this.modid + "." + this.name);
        setRegistryName(this.modid + ":" + this.name);
        setSoundType(this.sound);
        setHarvestLevel(this.toolType.getToolType(), this.harvestLevel);
        setHardness(this.hardness);
        setResistance(this.resistance);
        setLightLevel(this.lightLevel);
        setCreativeTab(this.tab);
    }
}