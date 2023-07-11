package net.thep2wking.oedldoedlcore.util;

/**
 * @author TheP2WKing
 */
public enum ModToolTypes {
    PICKAXE("pickaxe"),
    AXE("axe"),
    SHOVEL("shovel"),
    HOE("hoe"),
    ;

    private String toolType;

    ModToolTypes(String toolType) {
        this.toolType = toolType;
    }

    public String getToolType() {
        return toolType;
    }
}