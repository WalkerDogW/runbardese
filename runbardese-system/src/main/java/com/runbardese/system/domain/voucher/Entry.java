package com.runbardese.system.domain.voucher;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * 凭证表明细实体类
 */
@XmlRootElement
@XmlType(propOrder = {"entry_id","account_code","abstract1","currency","exchange_rate1","exchange_rate2","primary_debit_amount"
        ,"natural_debit_currency","primary_credit_amount","natural_credit_currency","unit_price","bill_type","bill_id","bill_date",
        "settlement","document_id","document_date","item"})
public class Entry {

    //分录号
    @NotNull
    private int entry_id;

    //科目
    @NotNull
    private String account_code;

    //摘要
    @NotNull
    private  String abstract1 ;

    //币种
    @NotNull
    private String currency;

    //汇率1
    @NotNull
    private String exchange_rate1;

    //汇率2
    @NotNull
    private String exchange_rate2;

    //原币借方发生额，不能为空
    @NotNull
    private String primary_debit_amount ;

    //本币借方发生额，不能为空
    @NotNull
    private String natural_debit_currency ;

    //原币贷方发生额，不能为空
    @NotNull
    private String primary_credit_amount;

    //本币贷方发生额，不能为空
    @NotNull
    private String natural_credit_currency ;

    //单价
    @Null
    private String unit_price;

    //原始单据类型
    @Null
    private String bill_type;

    //原始单据编号
    @Null
    private String bill_id;

    //原始单据日期
    @Null
    private String bill_date;

    //结算方式
    @Null
    private String settlement;

    //票据号
    @Null
    private String document_id;

    //票据日期
    @Null
    private String document_date;

    private int Fdc;

    private String Fdwdm;

    @XmlTransient
    public String getFdwdm() {
        return Fdwdm;
    }

    public void setFdwdm(String fdwdm) {
        Fdwdm = fdwdm;
    }

    public Entry(@NotNull int entry_id, @NotNull String account_code, @NotNull String abstract1, @NotNull String currency, @NotNull String exchange_rate1, @NotNull String exchange_rate2, @NotNull String primary_debit_amount, @NotNull String natural_debit_currency, @NotNull String primary_credit_amount, @NotNull String natural_credit_currency, @Null String unit_price, @Null String bill_type, @Null String bill_id, @Null String bill_date, @Null String settlement, @Null String document_id, @Null String document_date, int fdc, String fdwdm, String deptId, List<Item> item) {
        this.entry_id = entry_id;
        this.account_code = account_code;
        this.abstract1 = abstract1;
        this.currency = currency;
        this.exchange_rate1 = exchange_rate1;
        this.exchange_rate2 = exchange_rate2;
        this.primary_debit_amount = primary_debit_amount;
        this.natural_debit_currency = natural_debit_currency;
        this.primary_credit_amount = primary_credit_amount;
        this.natural_credit_currency = natural_credit_currency;
        this.unit_price = unit_price;
        this.bill_type = bill_type;
        this.bill_id = bill_id;
        this.bill_date = bill_date;
        this.settlement = settlement;
        this.document_id = document_id;
        this.document_date = document_date;
        Fdc = fdc;
        Fdwdm = fdwdm;
        DeptId = deptId;
        this.item = item;
    }

    private String DeptId;

    @XmlTransient
    public String getDeptId() {
        return DeptId;
    }

    public void setDeptId(String deptId) {
        DeptId = deptId;
    }



    @XmlTransient
    public int getFdc() {
        return Fdc;
    }

    public void setFdc(int fdc) {
        Fdc = fdc;
    }

    //辅料核算
    //private Auxiliary_accounting auxiliary_accounting;



    private List<Item> item;

    @XmlElementWrapper(name = "auxiliary_accounting")
    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }



    @Override
    public String toString() {
        return "Entry{" +
                "entry_id=" + entry_id +
                ", account_code='" + account_code + '\'' +
                ", abstract1='" + abstract1 + '\'' +
                ", currency='" + currency + '\'' +
                ", exchange_rate1='" + exchange_rate1 + '\'' +
                ", exchange_rate2='" + exchange_rate2 + '\'' +
                ", primary_debit_amount='" + primary_debit_amount + '\'' +
                ", natural_debit_currency='" + natural_debit_currency + '\'' +
                ", primary_credit_amount='" + primary_credit_amount + '\'' +
                ", natural_credit_currency='" + natural_credit_currency + '\'' +
                ", unit_price='" + unit_price + '\'' +
                ", bill_type='" + bill_type + '\'' +
                ", bill_id='" + bill_id + '\'' +
                ", bill_date='" + bill_date + '\'' +
                ", settlement='" + settlement + '\'' +
                ", document_id='" + document_id + '\'' +
                ", document_date='" + document_date + '\'' +
                ", Fdc=" + Fdc +
                ", DeptId='" + DeptId + '\'' +
                '}';
    }

    public Entry() {
    }

    public String getBill_type() {
        return bill_type;
    }

    public void setBill_type(String bill_type) {
        this.bill_type = bill_type;
    }

    public String getBill_id() {
        return bill_id;
    }

    public void setBill_id(String bill_id) {
        this.bill_id = bill_id;
    }

    public String getBill_date() {
        return bill_date;
    }

    public void setBill_date(String bill_date) {
        this.bill_date = bill_date;
    }

    public String getSettlement() {
        return settlement;
    }

    public void setSettlement(String settlement) {
        this.settlement = settlement;
    }

    public String getDocument_id() {
        return document_id;
    }

    public void setDocument_id(String document_id) {
        this.document_id = document_id;
    }

    public String getDocument_date() {
        return document_date;
    }

    public void setDocument_date(String document_date) {
        this.document_date = document_date;
    }

    public int getEntry_id() {
        return entry_id;
    }

    public void setEntry_id(int entry_id) {
        this.entry_id = entry_id;
    }

    public String getAccount_code() {
        return account_code;
    }

    public void setAccount_code(String account_code) {
        this.account_code = account_code;
    }

    @XmlElement(name = "abstract")
    public String getAbstract1() {
        return abstract1;
    }

    public void setAbstract1(String abstract1) {
        this.abstract1 = abstract1;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getExchange_rate1() {
        return exchange_rate1;
    }

    public void setExchange_rate1(String exchange_rate1) {
        this.exchange_rate1 = exchange_rate1;
    }

    public String getExchange_rate2() {
        return exchange_rate2;
    }

    public void setExchange_rate2(String exchange_rate2) {
        this.exchange_rate2 = exchange_rate2;
    }

    public String getPrimary_debit_amount() {
        return primary_debit_amount;
    }

    public void setPrimary_debit_amount(String primary_debit_amount) {
        this.primary_debit_amount = primary_debit_amount;
    }

    public String getNatural_debit_currency() {
        return natural_debit_currency;
    }

    public void setNatural_debit_currency(String natural_debit_currency) {
        this.natural_debit_currency = natural_debit_currency;
    }

    public String getPrimary_credit_amount() {
        return primary_credit_amount;
    }

    public void setPrimary_credit_amount(String primary_credit_amount) {
        this.primary_credit_amount = primary_credit_amount;
    }

    public String getNatural_credit_currency() {
        return natural_credit_currency;
    }

    public void setNatural_credit_currency(String natural_credit_currency) {
        this.natural_credit_currency = natural_credit_currency;
    }

    public String getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(String unit_price) {
        this.unit_price = unit_price;
    }

}
