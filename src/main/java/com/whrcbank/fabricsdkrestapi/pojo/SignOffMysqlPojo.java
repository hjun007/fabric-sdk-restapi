package com.whrcbank.fabricsdkrestapi.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignOffMysqlPojo {
    public  String   contractID      ;//string  `json:"contract_id"`        //协议编号
    public  String   customID          ;//string  `json:"cust_id"`            //客户编号
    public  String   signStat        ;//string  `json:"sign_stat"`          //签约状态
    public  String   signStatDesc    ;//string  `json:"sign_stat_desc"`     //签约状态描述
    public  String   signOffDate     ;//string  `json:"sign_off_date"`      //解约日期
    public  String   expiredDate     ;//string  `json:"expired_date"`       //失效日期
    public  String   lastUpdateSys   ;//string  `json:"last_update_sys"`    //最后更新渠道
    public  String   lastUpdateUser  ;//string  `json:"last_update_user"`   //最后更新人
    public  String   lastUpdateTime  ;//string  `json:"last_update_time"`   //最后更新时间
}
