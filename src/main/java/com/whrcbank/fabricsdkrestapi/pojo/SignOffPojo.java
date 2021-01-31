package com.whrcbank.fabricsdkrestapi.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignOffPojo {
//    public  String   ContractID      ;//string  `json:"contract_id"`        //协议编号
//    public  String   CustID          ;//string  `json:"cust_id"`            //客户编号
//    public  String   SignStat        ;//string  `json:"sign_stat"`          //签约状态
//    public  String   SignStatDesc    ;//string  `json:"sign_stat_desc"`     //签约状态描述
//    public  String   SignOffDate     ;//string  `json:"sign_off_date"`      //解约日期
//    public  String   ExpiredDate     ;//string  `json:"expired_date"`       //失效日期
//    public  String   LastUpdateSys   ;//string  `json:"last_update_sys"`    //最后更新渠道
//    public  String   LastUpdateUser  ;//string  `json:"last_update_user"`   //最后更新人
//    public  String   LastUpdateTime  ;//string  `json:"last_update_time"`   //最后更新时间
    private String signOffJson;
}
