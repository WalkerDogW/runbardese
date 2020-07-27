package com.runbardese.system.domain.voucher;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 凭证生成XML类
 */
@XmlRootElement(name = "ufinterface")
@XmlType(propOrder = {"account","billtype","codeexchanged","isexchange","operation","proc","receiver","replace","roottag","sender","voucher"})
public class Ufinterface {

    //指定导入NC系统的账套
    private String account;
    //指定xml文件的单据类型
    private String billtype="gl";
    private String codeexchanged="y";
    private String isexchange="Y";
    private String operation="demo1";
    //对xml内容要做的操作（add新增 ，update更新，delete删除 ，query查询）
    private String proc="add";
    //定制数据的接收方
    private String receiver="A1202";
    private String replace="Y";
    private String roottag="voucher";
    //设置外系统编码
    private String sender="BDS_U8c";

    @XmlAttribute(name = "billtype")
    public String getBilltype() {
        return billtype;
    }

    public void setBilltype(String billtype) {
        this.billtype = billtype;
    }

    @XmlAttribute(name = "codeexchanged")
    public String getCodeexchanged() {
        return codeexchanged;
    }

    public void setCodeexchanged(String codeexchanged) {
        this.codeexchanged = codeexchanged;
    }

    @XmlAttribute(name = "isexchange")
    public String getIsexchange() {
        return isexchange;
    }

    public void setIsexchange(String isexchange) {
        this.isexchange = isexchange;
    }

    @XmlAttribute(name = "operation")
    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @XmlAttribute(name = "proc")
    public String getProc() {
        return proc;
    }

    public void setProc(String proc) {
        this.proc = proc;
    }

    @XmlAttribute(name = "receiver")
    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    @XmlAttribute(name = "replace")
    public String getReplace() {
        return replace;
    }

    public void setReplace(String replace) {
        this.replace = replace;
    }

    @XmlAttribute(name = "roottag")
    public String getRoottag() {
        return roottag;
    }

    public void setRoottag(String roottag) {
        this.roottag = roottag;
    }

    @XmlAttribute(name = "sender")
    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    //@XmlElement(name = "Voucher")
    private Voucher voucher;

    public Ufinterface() {
    }

    public Ufinterface(String account, Voucher voucher) {
        this.account = account;
        this.voucher = voucher;
    }

    @XmlAttribute(name = "account")
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Voucher getVoucher() {
        return voucher;
    }

    public void setVoucher(Voucher voucher) {
        this.voucher = voucher;
    }

    @Override
    public String toString() {
        return "UfinterfaceTwo{" +
                "account='" + account + '\'' +
                ", voucher=" + voucher +
                '}';
    }
}
