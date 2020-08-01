package com.runbardese.system.service.impl;

import com.runbardese.system.domain.TblBarRelation;
import com.runbardese.system.domain.TblBarRelationDetail;
import com.runbardese.system.mapper.TblBarMapper;
import com.runbardese.system.service.TblBarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class TblBarServiceImpl implements TblBarService {

    @Autowired
    private TblBarMapper tblBarMapper;

    /**
     * 新增上托盘主表信息
     * @param tblBarRelation
     * @return
     */
    @Override
    public int insertTblBarRelation(TblBarRelation tblBarRelation) {
        return  tblBarMapper.insertTblBarRelation(tblBarRelation.getEvidence_Number(),
                tblBarRelation.getFdate(),
                tblBarRelation.getStock_ID(),
                tblBarRelation.getPalletCode(),
                tblBarRelation.getDesPalletCode(),
                tblBarRelation.getType(),
                tblBarRelation.getSummary(),
                tblBarRelation.getFmaker(),
                tblBarRelation.getCreateDate(),
                tblBarRelation.getVerified(),
                tblBarRelation.getVerifier(),
                tblBarRelation.getVerifyDate(),
                tblBarRelation.getDesPalletCode());
    }

    /**
     * 新增上托盘子表信息
     * @Param tblBarRelationDetail
     * @return
     */
    @Override
    public int insertTblBarRelationDetail(TblBarRelationDetail tblBarRelationDetail) {
        return tblBarMapper.insertTblBarRelationDetail(tblBarRelationDetail.getEvidence_Number(),
                tblBarRelationDetail.getNoid(),
                tblBarRelationDetail.getParentBarCode(),
                tblBarRelationDetail.getBarCode(),
                tblBarRelationDetail.getInventory_ID(),
                tblBarRelationDetail.getUnit_weight(),
                tblBarRelationDetail.getJarmodelID(),
                tblBarRelationDetail.getBoxCode(),
                tblBarRelationDetail.getNbox(),
                tblBarRelationDetail.getProjectBatch(),
                tblBarRelationDetail.getBinventory_ID(),
                tblBarRelationDetail.getInvProjectBatch());
    }


}
