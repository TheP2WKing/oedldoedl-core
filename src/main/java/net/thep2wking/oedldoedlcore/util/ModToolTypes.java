package net.thep2wking.oedldoedlcore.util;

/**
 * @author TheP2WKing
 */
public enum ModToolTypes {
    PICKAXE("pickaxe"),
    AXE("axe"),
    SHOVEL("shovel"),
    HOE("hoe"),
    SWORD("sword"),
    SHEARS("shears"),
    NO_TOOL("no tool"),
    ;

    private String toolType;

    ModToolTypes(String toolType) {
        this.toolType = toolType;
    }

    public String getToolType() {
        return toolType;
    }
}