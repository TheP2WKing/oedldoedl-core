package net.thep2wking.oedldoedlcore.util;

public enum ModToolType {
    PICKAXE("pickaxe"),
    AXE("axe"),
    SHOVEL("shovel"),
    HOE("hoe"),
    ;

    private String toolType;

    ModToolType(String toolType) {
        this.toolType = toolType;
    }

    public String getToolType() {
        return toolType;
    }
}