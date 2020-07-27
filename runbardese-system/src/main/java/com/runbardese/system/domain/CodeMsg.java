package com.runbardese.system.domain;
import io.swagger.annotations.ApiModel;

import javax.xml.bind.annotation.XmlRootElement;

//@ApiModel("返回码实体")
@XmlRootElement(name = "CodeMsg")
public class CodeMsg {

    private int code;
    private String msg;
    //private int update;

    public CodeMsg() {
    }

    public CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

//    public CodeMsg(int code, String msg, int update) {
//        this.code = code;
//        this.msg = msg;
//        this.update = update;
//    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

//    public int getUpdate() {
//        return update;
//    }
//
//    public void setUpdate(int update) {
//        this.update = update;
//    }

    @Override
    public String toString() {
        return "CodeMsg{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
