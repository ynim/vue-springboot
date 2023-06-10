package com.example.carbon.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Invitegg implements Serializable {
    private int id;
    private String icon;
    private String title;
    private Date time;

}
