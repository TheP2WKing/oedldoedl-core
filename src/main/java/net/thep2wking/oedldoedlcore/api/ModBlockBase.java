package net.thep2wking.oedldoedlcore.api;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.thep2wking.oedldoedlcore.OedldoedlCore;
import net.thep2wking.oedldoedlcore.init.OedldoedlCoreBlocks;
import net.thep2wking.oedldoedlcore.util.IHasModel;
import net.thep2wking.oedldoedlcore.util.ModToolType;

public class ModBlockBase extends Block implements IHasModel {
        public final String modid;
    public final String name;
    public final CreativeTabs tab;
    public final SoundType sound;
    public final int harvestLevel;
    public final ModToolType toolType;
    public final float hardness;
    public final float resistance;
    public final float lightLevel;

    public ModBlockBase(String modid, String name, CreativeTabs tab, Material material, SoundType sound,
            int harvestLevel, ModToolType toolType, float hardness, float resistance, float lightLevel) {
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
        OedldoedlCoreBlocks.BLOCKS.add(this);
    }

    @Override
    public void registerModels() {
        OedldoedlCore.PROXY.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}