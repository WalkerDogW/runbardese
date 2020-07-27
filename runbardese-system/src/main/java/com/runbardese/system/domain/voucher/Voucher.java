package com.runbardese.system.domain.voucher;

import com.runbardese.common.utils.StringUtils;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.UUID;

/**
 * 凭证类
 */
@XmlRootElement
@XmlType(propOrder = {"id","voucher_head","voucher_body"})
public class Voucher {

    //唯一标记
    private String id ;
    //凭证头
    private Voucher_head voucher_head;
    //凭证体
    private Voucher_body voucher_body;


    public Voucher() {
    }

    public Voucher(String id, Voucher_head voucher_head, Voucher_body voucher_body) {
        this.id = id;
        this.voucher_head = voucher_head;
        this.voucher_body = voucher_body;
    }

    @XmlAttribute(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Voucher_head getVoucher_head() {
        return voucher_head;
    }

    public void setVoucher_head(Voucher_head voucher_head) {
        this.voucher_head = voucher_head;
    }

    public Voucher_body getVoucher_body() {
        return voucher_body;
    }

    public void setVoucher_body(Voucher_body voucher_body) {
        this.voucher_body = voucher_body;
    }

    @Override
    public String toString() {
        return "Voucher{" +
                "id='" + id + '\'' +
                ", voucher_head=" + voucher_head +
                ", voucher_body=" + voucher_body +
                '}';
    }
}
