package com.runbardese.system.mapper;

import com.runbardese.common.annotation.DataSource;
import com.runbardese.common.enums.DataSourceType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;


/**
 * 上托盘主表Mapper
 *
 * @Author RunJ
 */
public interface TblBarMapper {
    /**
     * 新增上托盘主表
     */
    @DataSource(value = DataSourceType.SLAVE4)
    @Insert("insert into tblBarRelation" +
            "(evidence_number,fdate,stock_id,palletCode,desPalletCode,type,summary,fmaker,createDate,verified,verifier,verifyDate,DesStock_ID) " +
            "values(#{evidence_Number},#{fdate},#{stock_ID},#{palletCode},#{desPalletCode},#{type},#{summary},#{fmaker}" +
            ",#{createDate},#{verified},#{verifier},#{verifyDate},#{DesStock_ID})")
    public int insertTblBarRelation(@Param("evidence_Number") String evidence_Number,
                                    @Param("fdate") Date fdate,
                                    @Param("stock_ID") String stock_ID,
                                    @Param("palletCode") String palletCode,
                                    @Param("desPalletCode") String desPalletCode,
                                    @Param("type") int type,
                                    @Param("summary") String summary,
                                    @Param("fmaker") String fmaker,
                                    @Param("createDate") Date createDate,
                                    @Param("verified") int verified,
                                    @Param("verifier") String verifier,
                                    @Param("verifyDate") Date verifyDate,
                                    @Param("DesStock_ID") String DesStock_ID);

    /**
     * 新增上托盘明细表
     */
    @DataSource(value = DataSourceType.SLAVE4)
    @Insert("insert into tblBarRelationDetail(evidence_Number,noid,parentBarCode,barCode," +
            "inventory_ID,unit_weight,jarmodelID,boxCode,nbox,projectBatch,binventory_ID,invProjectBatch) " +
            "values(#{evidence_Number},#{noid},#{parentBarCode},#{barCode},#{inventory_ID},#{unit_weight}" +
            ",#{jarmodelID},#{boxCode},#{nbox},#{projectBatch},#{binventory_ID},#{invProjectBatch})")
    public int insertTblBarRelationDetail(@Param("evidence_Number") String evidence_Number,
                                          @Param("noid") int noid,
                                          @Param("parentBarCode") String parentBarCode,
                                          @Param("barCode") String barCode,
                                          @Param("inventory_ID") String inventory_ID,
                                          @Param("unit_weight") float unit_weight,
                                          @Param("jarmodelID") String jarmodelID,
                                          @Param("boxCode") String boxCode,
                                          @Param("nbox") int nbox,
                                          @Param("projectBatch") String projectBatch,
                                          @Param("binventory_ID") String binventory_ID,
                                          @Param("invProjectBatch") String invProjectBatch);

    @DataSource(value = DataSourceType.SLAVE4)
    @Select("select evidence_Number from tblBarRelation where evidence_Number = #{evidence_Number}")
    public String selectTblBarByEvidenceNum(@Param("evidence_Number") String evidence_Number);

    @DataSource(value = DataSourceType.SLAVE4)
    @Select("select evidence_Number from tblBarRelationDetail where evidence_Number = #{evidence_Number} and noid=#{noid}")
    public String selectTblBarDetailByEvidenceNum(@Param("evidence_Number") String evidence_Number, @Param("noid") int noid);
}
