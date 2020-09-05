package com.runbardese.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**发套料单主表
 * @author Tao
 * @Date 2020/7/25
 * @Time 14:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryEvidence {
    //计划编号
    private String Evidence_Number;
    //计划时间
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDate date;
    //原库位
    private Integer Type;
    private String Stock_ID;
    //目的库位
    private String DesStock_ID;
    //套料计划号
    private String MFG_Inventory_ID;
    //发料次数
    private Integer cLast;

//    //仓管员
//    private String WarehouseMan;
//    //经办人
//    private String DutyMan;

    //方式（3 按套料计划）
    private Integer IssueType;

//    //制单人
//    private String Maker;
//    //记帐人
//    private String Poster;

    //备注
    private String remark;
}
