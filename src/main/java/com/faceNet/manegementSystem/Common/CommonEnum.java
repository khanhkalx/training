package com.faceNet.manegementSystem.Common;

public enum CommonEnum {
    UNAUTHORIZED("unauthorized.server.error", "DT.002.0.000"),
    FILE_FORMAT_ERROR("file.format.error", "DT.002.0.001"),
    EXCEPTION_ERROR("internal.server.error", "DT.002.0.002"),
    INPUT_INVALID("input.valid", "DT.002.0.003"),
    FORBIDDEN("not.permission", "DT.002.0.005"),
    BAD_REQUEST("bad.request", "DT.002.0.006"),
    NOT_FOUND("not.found", "DT.002.0.007"),
    ;

    private final String key;
    private final String value;

    CommonEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public static CommonEnum getByCode(String code) {
        for (CommonEnum e : values()) {
            if (e.key.equals(code)) {
                return e;
            }
        }
        return null;
    }

    public String getValue() {
        return this.value;
    }

    public String getKey() {
        return this.key;
    }
}