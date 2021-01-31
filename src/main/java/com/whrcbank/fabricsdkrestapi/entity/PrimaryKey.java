package com.whrcbank.fabricsdkrestapi.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class PrimaryKey implements Serializable {
    private String customId;
    private String contractId;
}
