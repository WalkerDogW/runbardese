package com.runbardese.system.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel("上托盘子表")
public class TblBarRelationDetail {
    //单据编号
    @NotNull
    @ApiModelProperty(value = "单据编号")
    private String evidence_Number;
    //序号
    @NotNull
    @ApiModelProperty(value = "序号")
    private int noid;
    //父条码
    @NotNull
    @ApiModelProperty(value = "父条码")
    private String parentBarCode;
    //子条码
    @NotNull
    @ApiModelProperty(value = "子条码")
    private String barCode;
    //产品编码
    @NotNull
    @ApiModelProperty(value = "产品编码")
    private String inventory_ID;
    //净重
    @ApiModelProperty(value = "净重")
    private float unit_weight;
    //罐型
    @ApiModelProperty(value = "罐型")
    private String jarmodelID;
    //箱型
    @ApiModelProperty(value = "箱型")
    private String boxCode;
    //件规格
    @NotNull
    @ApiModelProperty(value = "件规格")
    private int nbox;
    //批号
    @ApiModelProperty(value = "批号")
    private String projectBatch;
    //半成品编码
    @ApiModelProperty(value = "半成品编码")
    private String binventory_ID;
    //半成品批次
    @NotNull
    @ApiModelProperty(value = "半成品批次")
    private String invProjectBatch;
}
