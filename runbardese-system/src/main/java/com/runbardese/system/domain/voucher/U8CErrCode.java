package com.runbardese.system.domain.voucher;

import java.util.Date;

/**
 * 凭证对接错误类
 */
public class U8CErrCode {

    private String id;
    private String voucher_code;
    private String result_code;
    private String resultdes;
    private Date current_date;

    public U8CErrCode() {
    }

    public U8CErrCode(String id, String voucher_code, String result_code, String resultdes, Date current_date) {
        this.id = id;
        this.voucher_code = voucher_code;
        this.result_code = result_code;
        this.resultdes = resultdes;
        this.current_date = current_date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVoucher_code() {
        return voucher_code;
    }

    public void setVoucher_code(String voucher_code) {
        this.voucher_code = voucher_code;
    }

    public String getResult_code() {
        return result_code;
    }

    public void setResult_code(String result_code) {
        this.result_code = result_code;
    }

    public String getResultdes() {
        return resultdes;
    }

    public void setResultdes(String resultdes) {
        this.resultdes = resultdes;
    }

    public Date getCurrent_date() {
        return current_date;
    }

    public void setCurrent_date(Date current_date) {
        this.current_date = current_date;
    }

    @Override
    public String toString() {
        return "U8CErrCode{" +
                "id='" + id + '\'' +
                ", voucher_code='" + voucher_code + '\'' +
                ", result_code='" + result_code + '\'' +
                ", resultdes='" + resultdes + '\'' +
                ", current_date=" + current_date +
                '}';
    }
}
