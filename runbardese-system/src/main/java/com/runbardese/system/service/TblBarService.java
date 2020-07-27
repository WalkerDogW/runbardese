package com.runbardese.system.service;


import com.runbardese.system.domain.TblBarRelation;
import com.runbardese.system.domain.TblBarRelationDetail;

public interface TblBarService {

    /**
     * 新增上托盘主表
     * @param tblBarRelation
     * @return
     */
    public int insertTblBarRelation(TblBarRelation tblBarRelation);


    /**
     * 新增上托盘子表
     * @param tblBarRelationDetail
     * @return
     */
    public int insertTblBarRelationDetail(TblBarRelationDetail tblBarRelationDetail);
}
