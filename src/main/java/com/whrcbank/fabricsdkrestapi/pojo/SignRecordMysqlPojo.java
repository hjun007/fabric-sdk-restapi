package com.whrcbank.fabricsdkrestapi.pojo;

public class SignRecordMysqlPojo {
    public  String   ContractID      ;//string  `json:"contract_id"`        //协议编号, primary key
    public  String   CustID          ;//string  `json:"cust_id"`            //客户编号
    public  String   SignBranchNO    ;//string  `json:"sign_branch_no"`     //签约机构
    public  String   SignTellerNo    ;//string  `json:"sign_teller_no"`     //签约柜员
    public  String   SignAccNo       ;//string  `json:"sign_acc_no"`        //签约账号
    public  String   SignCardNo      ;//string  `json:"sign_card_no"`       //签约卡号
    public  String   SignType        ;//string  `json:"sign_type"`          //签约类型/产品
    public  String   SignKind        ;//string  `json:"sign_kind"`          //签约渠道
    public  String   SignKindDesc    ;//string  `json:"sign_kind_desc"`     //签约渠道描述
    public  String   SignDesc        ;//string  `json:"sign_desc"`          //签约描述
    public  String   SignStat        ;//string  `json:"sign_stat"`          //签约状态
    public  String   SignStatDesc    ;//string  `json:"sign_stat_desc"`     //签约状态描述
    public  String   SignDate        ;//string  `json:"sign_date"`          //签约日期
    public  String   SignOffDate     ;//string  `json:"sign_off_date"`      //解约日期
    public  String   EffectiveDate   ;//string  `json:"effective_date"`     //生效日期
    public  String   ExpiredDate     ;//string  `json:"expired_date"`       //失效日期
    public  String   SignEbankAcct   ;//string  `json:"sign_ebank_acct"`    //签约网银账号
    public  String   LastUpdateSys   ;//string  `json:"last_update_sys"`    //最后更新渠道
    public  String   LastUpdateUser  ;//string  `json:"last_update_user"`   //最后更新人
    public  String   LastUpdateTime  ;//string  `json:"last_update_time"`   //最后更新时间
    public  String   TxSeqNo         ;//string  `json:"tx_seq_no"`          //交易流水号
    public  String   ID1             ;//string  `json:"id_1"`               //用户识别码1
    public  String   ID2             ;//string  `json:"id_2"`               //用户识别码2
    public  String   ID3             ;//string  `json:"id_3"`               //用户识别码3
    public  String   ID4             ;//string  `json:"id_4"`               //用户识别码4
    public  String   ID5             ;//string  `json:"id_5"`               //用户识别码5
}
