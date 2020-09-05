package com.runbardese.system.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**发套料单明细表
 * @author Tao
 * @Date 2020/7/25
 * @Time 14:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryEvidenceDetail {
    //计划编号
    private String Evidence_Number;
    //物料编码
    private String Inventory_ID;
    //序号
    private Integer NOID;
    //计划量
    private Double Qty;

//    //短缺量
//    private Double Shortage_Qty;

    //实发量
    private Double Actual_Qty;
    //物料批号
    private String ProjectBatch;

}
