package com.spring.boot.enums;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2020/1/4 10:47
 * @Version 1.0
 */

public enum SexEnum {

    MAN(1, "男"), FEMALE(0, "女");

    private int code;
    private String name;

    SexEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getNameByCode(int code) {
        for (SexEnum sex : SexEnum.values()) {
            if (code == sex.getCode()) {
                return sex.getName();
            }
        }
        return null;
    }


    public static Integer getCodeByName(String name) {
        for (SexEnum sex : SexEnum.values()) {
            if (name == sex.getName()) {
                return sex.getCode();
            }
        }
        return null;
    }
}
