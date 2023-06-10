package com.example.carbon.domain;

import java.io.Serializable;

public class Ptjt implements Serializable {
    private String icon;
    private String DynamicTitle;
    private String Releasetime;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDynamicTitle() {
        return DynamicTitle;
    }

    public void setDynamicTitle(String dynamicTitle) {
        DynamicTitle = dynamicTitle;
    }

    public String getReleasetime() {
        return Releasetime;
    }

    public void setReleasetime(String releasetime) {
        Releasetime = releasetime;
    }

    @Override
    public String toString() {
        return "Nxyj{" +
                "icon='" + icon + '\'' +
                ", DynamicTitle='" + DynamicTitle + '\'' +
                ", Releasetime='" + Releasetime + '\'' +
                '}';
    }
}
