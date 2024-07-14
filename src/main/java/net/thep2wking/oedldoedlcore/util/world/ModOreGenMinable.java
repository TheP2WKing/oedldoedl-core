package net.thep2wking.oedldoedlcore.util.world;

import net.minecraft.block.Block;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.world.gen.feature.WorldGenMinable;

/**
 * @author TheP2WKing
 */
public class ModOreGenMinable extends WorldGenMinable {
	public final Block oreBlock;
	public final int veinSize;
	public final int chance;
	public final Block blockToReplace;
	public final int dimension;

	/**
	 * @author TheP2WKing
	 * @param oreBlock       {@link Block}
	 * @param veinSize       int
	 * @param chance         int
	 * @param blockToReplace {@link Block}
	 * @param dimension      int
	 */
	public ModOreGenMinable(Block oreBlock, int veinSize, int chance, Block blockToReplace, int dimension) {
		super(oreBlock.getDefaultState(), veinSize, BlockMatcher.forBlock(blockToReplace));
		this.oreBlock = oreBlock;
		this.veinSize = veinSize;
		this.chance = chance;
		this.blockToReplace = blockToReplace;
		this.dimension = dimension;
	}
}