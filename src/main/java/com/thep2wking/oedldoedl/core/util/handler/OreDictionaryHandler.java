package com.thep2wking.oedldoedl.core.util.handler;

import net.minecraft.init.Blocks;
import net.minecraftforge.oredict.OreDictionary;

public class OreDictionaryHandler
{
	public static void registerOreDictionary()
	{
  		OreDictionary.registerOre("bookshelf", Blocks.BOOKSHELF);
  		OreDictionary.registerOre("blockIce", Blocks.ICE);
  		OreDictionary.registerOre("ice", Blocks.ICE);
  		OreDictionary.registerOre("cobblestone", Blocks.MOSSY_COBBLESTONE);
  	}
}