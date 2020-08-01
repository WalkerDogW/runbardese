package com.runbardese.system.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel("上托盘主表")
public class TblBarRelation {

    //单据编号
    @NotNull
    @ApiModelProperty(value = "单据编号")
    private String evidence_Number;
    //单据日期
    @NotNull
    @ApiModelProperty(value = "单据日期")
    private Date fdate;
    //库位编码
    @NotNull
    @ApiModelProperty(value = "库位编码")
    private String stock_ID;
    //托盘编码
    @ApiModelProperty(value = "托盘编码")
    private String palletCode;
    //新托盘编码
    @ApiModelProperty(value = "新托盘编码")
    private String desPalletCode;
    //单据类型
    @ApiModelProperty(value = "单据类型")
    private int type;
    //备注
    @ApiModelProperty(value = "备注")
    private String summary;
    //制单人
    @NotNull
    @ApiModelProperty(value = "制单人")
    private String fmaker;
    //建立时间
    @NotNull
    @ApiModelProperty(value = "建立时间")
    private Date createDate;
    //审核状态
    @NotNull
    @ApiModelProperty(value = "审核状态")
    private int verified;
    //审核人
    @ApiModelProperty(value = "审核人")
    private String verifier;
    //审核时间
    @ApiModelProperty(value = "审核时间")
    private Date verifyDate;

    private String DesPalletCode;

    //上托盘子表
//    private List<TblBarRelationDetail> tblBarRelationDetailList;


}
