package com.runbardese.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author Tao
 * @Date 2020/7/30
 * @Time 15:43
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ERPProdBom {
    private Integer LineNum;
    private String MatCode;
    private String MatName;
    private Double TargetQty;
    private String FuncCode;
    private Double Param1;
    private Double Param2;
    private Integer Position;
    private String Remark = "";
    private String ProdId;
}
