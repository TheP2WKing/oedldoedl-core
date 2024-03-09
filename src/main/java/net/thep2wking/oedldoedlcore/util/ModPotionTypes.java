package net.thep2wking.oedldoedlcore.util;

/**
 * @author TheP2WKing
 */
public enum ModPotionTypes {
    NORMAL(""),
    LONG("long"),
    STRONG("strong"),
    ;

    private String potionType;

    ModPotionTypes(String potionType) {
        this.potionType = potionType;
    }

    public String getPotionType() {
        return potionType;
    }
}