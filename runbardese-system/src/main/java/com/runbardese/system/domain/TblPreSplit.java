package com.runbardese.system.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.core.env.Profiles;

/**
 * @author Tao
 * @Date 2020/7/21
 * @Time 9:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TblPreSplit {
    private String JarNO;
    private String productID;
    private String description;
    private String Inventory_ID;
    private Integer nbox;
    private Integer JarQty;
    private String ContactName;
}
