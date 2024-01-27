package net.thep2wking.oedldoedlcore.api.tool;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

/**
 * @author TheP2WKing
 */
public class ModToolMaterialBase {
	/**
	 * @author TheP2WKing
	 * @param modid          String
	 * @param name           String
	 * @param durability     int
	 * @param harvestLevel   int
	 * @param efficiency     float
	 * @param attackDamage   float
	 * @param enchantability int
	 * @param repairItem     {@link Item}
	 * @param meta           int
	 */
	public static ToolMaterial addToolMaterial(String modid, String name, int durability, int harvestLevel,
			float efficiency, float attackDamage, int enchantability, Item repairItem, int meta) {
		return EnumHelper.addToolMaterial(modid + ":tool_material_" + name, harvestLevel, durability, efficiency,
				attackDamage, enchantability).setRepairItem(new ItemStack(repairItem, 1, meta));
	}

	/**
	 * @author TheP2WKing
	 * @param modid          String
	 * @param name           String
	 * @param durability     int
	 * @param harvestLevel   int
	 * @param efficiency     float
	 * @param attackDamage   float
	 * @param enchantability int
	 * @param repairBlock    {@link Block}
	 * @param meta           int
	 */
	public static ToolMaterial addToolMaterial(String modid, String name, int durability, int harvestLevel,
			float efficiency, float attackDamage, int enchantability, Block repairBlock, int meta) {
		return EnumHelper.addToolMaterial(modid + ":tool_material_" + name, harvestLevel, durability, efficiency,
				attackDamage, enchantability).setRepairItem(new ItemStack(repairBlock, 1, meta));
	}

	/**
	 * @author TheP2WKing
	 * @param modid          String
	 * @param name           String
	 * @param durability     int
	 * @param harvestLevel   int
	 * @param efficiency     float
	 * @param attackDamage   float
	 * @param enchantability int
	 * @param repairStack    {@link ItemStack}
	 * @param meta           int
	 */
	public static ToolMaterial addToolMaterial(String modid, String name, int durability, int harvestLevel,
			float efficiency, float attackDamage, int enchantability, ItemStack repairStack, int meta) {
		return EnumHelper.addToolMaterial(modid + ":tool_material_" + name, harvestLevel, durability, efficiency,
				attackDamage, enchantability).setRepairItem(repairStack);
	}
}