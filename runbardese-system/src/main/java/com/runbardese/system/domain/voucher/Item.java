package com.runbardese.system.domain.voucher;

import lombok.Data;

import javax.xml.bind.annotation.*;

/**
 * 档案类
 */
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Item {
    @XmlAttribute
    private String name;

    @XmlValue
    private String value;

}
