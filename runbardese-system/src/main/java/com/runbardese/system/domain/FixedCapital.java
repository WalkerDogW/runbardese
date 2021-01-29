package com.runbardese.system.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Tao
 * @Date 2020/12/22
 * @Time 10:41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FixedCapital {
    private String 	ItemCode;
    private String 	ItemName;
    private String Styles;
    private String 	Unit;
    private Integer 	Qty;
    private String 	Dept;
    private String 	EmpId;
    private Date Dates;
}
