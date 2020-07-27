package com.runbardese.system.domain.voucher;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ufinterface")
public class UfinterfaceCTB {
    @XmlAttribute
    private String roottag = "basdoc";
    @XmlAttribute
    private String billtype = "bscubas";
    @XmlAttribute
    private String replace = "Y";
    @XmlAttribute
    private String receiver ="A01";
    @XmlAttribute
    private String sender = "BDS_U8c";
    @XmlAttribute
    private String isexchange = "Y";
    @XmlAttribute
    private String filename = "客商档案样本数据文件.xml";
    @XmlAttribute
    private String proc = "add";

    private Basdoc basdoc;

    public UfinterfaceCTB(Basdoc basdoc) {
        this.basdoc = basdoc;
    }

    public UfinterfaceCTB() {
    }

    public Basdoc getBasdoc() {
        return basdoc;
    }

    public void setBasdoc(Basdoc basdoc) {
        this.basdoc = basdoc;
    }
}
