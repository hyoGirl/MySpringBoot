package com.xulei.spring.model;

import lombok.Data;

@Data
public class DangDangModel {


    private static final long serialVersionUID = -9081259429719031051L;


    private String watchID;
    private String watchName;
    private double watchPrice;


    @Override
    public String toString() {
        return "DangDangModel{" +
                "watchID='" + watchID + '\'' +
                ", watchName='" + watchName + '\'' +
                ", watchPrice=" + watchPrice +
                '}';
    }
}
