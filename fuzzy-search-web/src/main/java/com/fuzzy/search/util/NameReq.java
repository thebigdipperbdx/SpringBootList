package com.fuzzy.search.util;

/**
 * @author yanyugang
 * @description 实体类
 * @date 2019-08-15 16:27
 */
public class NameReq {
    private String mailNo; //运单号
    private String orgCode; //机构代码

    public String getMailNo(){
        return mailNo;
    }

    public void setMailNo(String mailNo){
        this.mailNo=mailNo;
    }

    public String getOrgCode(){
        return orgCode;
    }

    public void setOrgCode(String orgCode){
        this.orgCode=orgCode;
    }
}
