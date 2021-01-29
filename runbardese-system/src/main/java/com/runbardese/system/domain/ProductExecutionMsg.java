package com.runbardese.system.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductExecutionMsg {
    private CodeMsg codeMsg;
    private Tblproductexecution productexecution;

    private List<Tblproductexecution_detail> productexecution_detail;

}
