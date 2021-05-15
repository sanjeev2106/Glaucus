package com.example.number.enums;

/**
 * Enum for status message
 *
 * @author Sanjeev
 */
public enum StatusMsg {
    SUCCESS("Success"), ERROR("Error");

    private String value;

    StatusMsg(String msg) {
        value = msg;
    }

    public String getValue() {
        return value;
    }
}
