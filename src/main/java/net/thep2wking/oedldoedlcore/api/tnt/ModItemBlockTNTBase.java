package net.thep2wking.oedldoedlcore.api.tnt;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDispenser;
import net.minecraft.dispenser.IBehaviorDispenseItem;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlcore.api.item.ModItemBlockBase;

/**
 * @author TheP2WKing
 */
public class ModItemBlockTNTBase extends ModItemBlockBase {
	/**
	 * @author TheP2WKing
	 * @param block           {@link Block}
	 * @param rarity          {@link EnumRarity}
	 * @param hasEffect       boolean
	 * @param tooltipLines    int
	 * @param annotationLines int
	 */
	public ModItemBlockTNTBase(Block block, EnumRarity rarity, boolean hasEffect, int tooltipLines,
			int annotationLines) {
		super(block, rarity, hasEffect, tooltipLines, annotationLines);
		BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(this, new IBehaviorDispenseItem() {
			@Override
			public ItemStack dispense(IBlockSource source, ItemStack stack) {
				World world = source.getWorld();
				EnumFacing enumfacing = (EnumFacing) source.getBlockState().getValue(BlockDispenser.FACING);
				double x = source.getX() + (double) enumfacing.getFrontOffsetX();
				double y = (double) ((float) source.getBlockPos().getY() + 0.2F);
				double z = source.getZ() + (double) enumfacing.getFrontOffsetZ();
				ModBlockTNTBase tntBlock = (ModBlockTNTBase) ModItemBlockTNTBase.this.block;
				ModEntityTNTBase entitytntprimed = tntBlock.createTNTEntity(world, x, y, z, null);
				world.spawnEntity(entitytntprimed);
				world.playSound(null, entitytntprimed.posX, entitytntprimed.posY, entitytntprimed.posZ,
						SoundEvents.ENTITY_TNT_PRIMED, SoundCategory.BLOCKS, 1.0F, 1.0F);
				stack.shrink(1);
				return stack;
			}
		});
	}
}