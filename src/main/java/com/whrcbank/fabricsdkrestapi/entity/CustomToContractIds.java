package com.whrcbank.fabricsdkrestapi.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@IdClass(PrimaryKey.class)
public class CustomToContractIds {
    @Id
    private String customId;
    @Id
    private String contractId;
}
