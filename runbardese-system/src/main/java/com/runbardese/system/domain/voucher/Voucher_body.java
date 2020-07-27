package com.runbardese.system.domain.voucher;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * 凭证体
 */
@XmlRootElement
public class Voucher_body {
    //凭证细表
    private List<Entry> entry;

    public Voucher_body() {
    }

    public Voucher_body(List<Entry> entry) {
        this.entry = entry;
    }

    public List<Entry> getEntry() {
        return entry;
    }

    public void setEntry(List<Entry> entry) {
        this.entry = entry;
    }

    @Override
    public String toString() {
        return "Voucher_body{" +
                "entry=" + entry +
                '}';
    }
}
