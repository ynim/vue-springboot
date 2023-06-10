package com.example.carbon.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Xmwh {
    private int id;
    private String name;
    private String header;
    private Date start;
    private Date end;
    private String status;
    private String duction;
}
