package com.runbardese.system.domain.voucher;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.UUID;

@XmlRootElement
public class Basdoc {


    private String id = UUID.randomUUID().toString();
    private Basdoc_head basdoc_head;

    public Basdoc() {
    }

    public Basdoc(String id, Basdoc_head basdoc_head) {
        this.id = id;
        this.basdoc_head = basdoc_head;
    }

    @XmlAttribute
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Basdoc_head getBasdoc_head() {
        return basdoc_head;
    }

    public void setBasdoc_head(Basdoc_head basdoc_head) {
        this.basdoc_head = basdoc_head;
    }
}
