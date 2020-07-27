package com.runbardese.system.domain;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel("托盘表")
public class TblBar {
    private TblBarRelation tblBarRelation;
    private List<TblBarRelationDetail> tblBarRelationDetailList;
}
