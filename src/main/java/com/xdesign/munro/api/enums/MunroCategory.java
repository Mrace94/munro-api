package com.xdesign.munro.api.enums;

public enum MunroCategory {
    MUNRO( "MUN" ),
    TOP( "TOP" ),
    EITHER( "EITHER" );

    private final String value;

    MunroCategory( String value ) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
