package com.runbardese.system.domain.voucher;


import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 凭证头
 */
@XmlRootElement
@XmlType(propOrder = {"company","voucher_type","fiscal_year","accounting_period","voucher_id",
        "attachment_number","date","enter","voucher_making_system","pk_sourcepk","evidence_number"})
public class Voucher_head {
    //公司目录 不能为空
    @NotNull
    private String company ;
    //凭证类别 不能为空
    @NotNull
    private String voucher_type ;
    //会计期间应与下面的制单日期一致(年)  不能为空
    @NotNull
    private int fiscal_year ;
    //期间(月)  不能为空
    @NotNull
    private String accounting_period;
    //凭证号 不能为空
    @NotNull
    private String voucher_id;
    //附件数 不能为空
    @NotNull
    private int attachment_number = 0;
    //制单日期 不能为空
    @NotNull
    private String date ;
    //制单人 不能为空
    @NotNull
    private String enter ;
    //来源系统 不能为空
    @NotNull
    private String voucher_making_system ;
    //折算来源凭证 不能为空
    @NotNull
    private String pk_sourcepk ;

    //单据编号
    private String evidence_number;

    public Voucher_head(@NotNull String company, @NotNull String voucher_type, @NotNull int fiscal_year, @NotNull String accounting_period, @NotNull String voucher_id, @NotNull int attachment_number, @NotNull String date, @NotNull String enter, @NotNull String voucher_making_system, @NotNull String pk_sourcepk, String evidence_number) {
        this.company = company;
        this.voucher_type = voucher_type;
        this.fiscal_year = fiscal_year;
        this.accounting_period = accounting_period;
        this.voucher_id = voucher_id;
        this.attachment_number = attachment_number;
        this.date = date;
        this.enter = enter;
        this.voucher_making_system = voucher_making_system;
        this.pk_sourcepk = pk_sourcepk;
        this.evidence_number = evidence_number;
    }

    @Override
    public String toString() {
        return "Voucher_head{" +
                "company='" + company + '\'' +
                ", voucher_type='" + voucher_type + '\'' +
                ", fiscal_year=" + fiscal_year +
                ", accounting_period=" + accounting_period +
                ", voucher_id='" + voucher_id + '\'' +
                ", attachment_number=" + attachment_number +
                ", date='" + date + '\'' +
                ", enter='" + enter + '\'' +
                ", voucher_making_system='" + voucher_making_system + '\'' +
                ", pk_sourcepk='" + pk_sourcepk + '\'' +
                ", evidence_number='" + evidence_number + '\'' +
                '}';
    }

    public String getEvidence_number() {
        return evidence_number;
    }

    public void setEvidence_number(String evidence_number) {
        this.evidence_number = evidence_number;
    }

    public Voucher_head() {
    }

    public Voucher_head(String company, String voucher_type, int fiscal_year, String accounting_period, String voucher_id, int attachment_number, String date, String enter, String voucher_making_system, String pk_sourcepk) {
        this.company = company;
        this.voucher_type = voucher_type;
        this.fiscal_year = fiscal_year;
        this.accounting_period = accounting_period;
        this.voucher_id = voucher_id;
        this.attachment_number = attachment_number;
        this.date = date;
        this.enter = enter;
        this.voucher_making_system = voucher_making_system;
        this.pk_sourcepk = pk_sourcepk;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getVoucher_type() {
        return voucher_type;
    }

    public void setVoucher_type(String voucher_type) {
        this.voucher_type = voucher_type;
    }

    public int getFiscal_year() {
        return fiscal_year;
    }

    public void setFiscal_year(int fiscal_year) {
        this.fiscal_year = fiscal_year;
    }

    public String getAccounting_period() {
        return accounting_period;
    }

    public void setAccounting_period(String accounting_period) {
        this.accounting_period = accounting_period;
    }

    public String getVoucher_id() {
        return voucher_id;
    }

    public void setVoucher_id(String voucher_id) {
        this.voucher_id = voucher_id;
    }

    public int getAttachment_number() {
        return attachment_number;
    }

    public void setAttachment_number(int attachment_number) {
        this.attachment_number = attachment_number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEnter() {
        return enter;
    }

    public void setEnter(String enter) {
        this.enter = enter;
    }

    public String getVoucher_making_system() {
        return voucher_making_system;
    }

    public void setVoucher_making_system(String voucher_making_system) {
        this.voucher_making_system = voucher_making_system;
    }

    public String getPk_sourcepk() {
        return pk_sourcepk;
    }

    public void setPk_sourcepk(String pk_sourcepk) {
        this.pk_sourcepk = pk_sourcepk;
    }

}
