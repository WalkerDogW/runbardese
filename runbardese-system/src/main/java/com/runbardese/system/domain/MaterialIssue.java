package com.runbardese.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**套料计划主表
 * @author Tao
 * @Date 2020/7/25
 * @Time 14:15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaterialIssue {
    //计划编号（输入参数）
    private String No;
    //计划时间
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDate date;
    //车间编码
    private String Des_StockID;

//    //发料次数
//    private Integer cLast;
//    //领料方式 (4  PLC配料)
//    private Integer GtMType;
//    //备注
//    private String Summary;
//    //关闭状态(0 未关闭 1 已关闭)
//    private Integer Closed;
//    //状态（0 未读取 1 已读取）
//    private Integer FStatus;

    private String Inventory_ID;

    private String BOM;

    private Double DircQty;
}
