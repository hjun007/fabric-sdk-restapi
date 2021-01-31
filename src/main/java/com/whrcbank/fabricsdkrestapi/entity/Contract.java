package com.whrcbank.fabricsdkrestapi.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Contract {
//    @GeneratedValue(strategy= GenerationType.AUTO)
//    private  Long     id;
    @Id
    private  String   contractID      ;//string  `json:"contract_id"`        //协议编号, primary key
    private  String   customID          ;//string  `json:"cust_id"`            //客户编号
    private  String   signBranchNO    ;//string  `json:"sign_branch_no"`     //签约机构
    private  String   signTellerNo    ;//string  `json:"sign_teller_no"`     //签约柜员
    private  String   signAccNo       ;//string  `json:"sign_acc_no"`        //签约账号
    private  String   signCardNo      ;//string  `json:"sign_card_no"`       //签约卡号
    private  String   signType        ;//string  `json:"sign_type"`          //签约类型/产品
    private  String   signKind        ;//string  `json:"sign_kind"`          //签约渠道
    private  String   signKindDesc    ;//string  `json:"sign_kind_desc"`     //签约渠道描述
    private  String   signDesc        ;//string  `json:"sign_desc"`          //签约描述
    private  String   signStat        ;//string  `json:"sign_stat"`          //签约状态
    private  String   signStatDesc    ;//string  `json:"sign_stat_desc"`     //签约状态描述
    private  String   signDate        ;//string  `json:"sign_date"`          //签约日期
    private  String   signOffDate     ;//string  `json:"sign_off_date"`      //解约日期
    private  String   effectiveDate   ;//string  `json:"effective_date"`     //生效日期
    private  String   expiredDate     ;//string  `json:"expired_date"`       //失效日期
    private  String   signEbankAcct   ;//string  `json:"sign_ebank_acct"`    //签约网银账号
    private  String   lastUpdateSys   ;//string  `json:"last_update_sys"`    //最后更新渠道
    private  String   lastUpdateUser  ;//string  `json:"last_update_user"`   //最后更新人
    private  String   lastUpdateTime  ;//string  `json:"last_update_time"`   //最后更新时间
    private  String   txSeqNo         ;//string  `json:"tx_seq_no"`          //交易流水号
    private  String   iD1             ;//string  `json:"id_1"`               //用户识别码1
    private  String   iD2             ;//string  `json:"id_2"`               //用户识别码2
    private  String   iD3             ;//string  `json:"id_3"`               //用户识别码3
    private  String   iD4             ;//string  `json:"id_4"`               //用户识别码4
    private  String   iD5             ;//string  `json:"id_5"`               //用户识别码5
}
