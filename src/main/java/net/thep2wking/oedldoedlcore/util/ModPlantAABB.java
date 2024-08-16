package net.thep2wking.oedldoedlcore.util;

import net.minecraft.util.math.AxisAlignedBB;

/**
 * @author TheP2WKing
 */
public enum ModPlantAABB {
	// side, bottom, side, side, top, side
    FULL("full_block", new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D)),
	HALF("half_block", new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.5D, 1.0D)),
    FLOWER("flower", new AxisAlignedBB(0.30000001192092896D, 0.0D, 0.30000001192092896D, 0.699999988079071D, 0.6000000238418579D, 0.699999988079071D)),
    BUSH("bush", new AxisAlignedBB(0.09999999403953552D, 0.0D, 0.09999999403953552D, 0.8999999761581421D, 0.800000011920929D, 0.8999999761581421D)),
    MUSHROOM("mushroom", new AxisAlignedBB(0.30000001192092896D, 0.0D, 0.30000001192092896D, 0.699999988079071D, 0.4000000059604645D, 0.699999988079071D)),
    CUT("cut", new AxisAlignedBB(0.09999999403953552D, 0.0D, 0.09999999403953552D, 0.8999999761581421D, 0.1875f, 0.8999999761581421D)),
    ;

    private String aabbType;
	private AxisAlignedBB aabb;
	
    ModPlantAABB(String aabbType, AxisAlignedBB aabb) {
        this.aabbType = aabbType;
		this.aabb = aabb;
    }

    public String getAabbType() {
        return aabbType;
    }

	public AxisAlignedBB getAabb() {
		return aabb;
	}
}