package com.runbardese.system.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Tao
 * @Date 2020/7/30
 * @Time 15:37
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ERPProdMsg {
    private CodeMsg codeMsg;
    private ERPProd erpProd;
    private List<ERPProdBom> erpProdBoms;
}
