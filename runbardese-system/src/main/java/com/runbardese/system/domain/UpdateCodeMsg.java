package com.runbardese.system.domain;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;

import javax.xml.bind.annotation.XmlRootElement;

//@ApiModel("更新返回实体")
@XmlRootElement(name = "UpdateCodeMsg")
public class UpdateCodeMsg {

    private String qRCode;
    private int code;
    private String msg;
    private int update;

    public UpdateCodeMsg() {
    }

    public UpdateCodeMsg(int code, String msg, int update) {
        this.code = code;
        this.msg = msg;
        this.update = update;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getUpdate() {
        return update;
    }

    public void setUpdate(int update) {
        this.update = update;
    }

    public UpdateCodeMsg(String qRCode, int code, String msg, int update) {
        this.qRCode = qRCode;
        this.code = code;
        this.msg = msg;
        this.update = update;
    }

    public String getqRCode() {
        return qRCode;
    }

    public void setqRCode(String qRCode) {
        this.qRCode = qRCode;
    }

    @Override
    public String toString() {
        return "UpdateCodeMsg{" +
                "qRCode='" + qRCode + '\'' +
                ", code=" + code +
                ", msg='" + msg + '\'' +
                ", update=" + update +
                '}';
    }
}
