package com.runbardese.system.mapper;

import com.runbardese.common.annotation.DataSource;
import com.runbardese.common.enums.DataSourceType;
import com.runbardese.system.domain.InventoryEvidence;
import com.runbardese.system.domain.InventoryEvidenceDetail;
import com.runbardese.system.domain.MaterialIssue;
import com.runbardese.system.domain.MaterialIssueDetail;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Tao
 * @Date 2020/7/25
 * @Time 14:56
 */
@Mapper

public interface PLCMapper {
    @DataSource(value = DataSourceType.SLAVE)
    @Select("select *  from ProjectMaterial_Issue_Plan where No=#{No}")
    public MaterialIssue selectMaterialIssue(@Param("No") String No);

    @DataSource(value = DataSourceType.SLAVE)
    @Select("select *  from ProjectMaterial_Issue_Plan_Detail where No=#{No}")
    public List<MaterialIssueDetail> selectMaterialIssueDetail(@Param("No") String No);

    @DataSource(value = DataSourceType.SLAVE)
    @Select("select *  from inventory_evidence where Evidence_Number=#{Evidence_Number}")
    public InventoryEvidence selectInventoryEvidence(@Param("Evidence_Number") String No);


    @DataSource(value = DataSourceType.SLAVE)
    @Select("select *  from Inventory_Evidence_Detail where Evidence_Number=#{Evidence_Number}")
    public List<InventoryEvidenceDetail> selectInventoryEvidenceDetail(@Param("Evidence_Number") String No);

    @DataSource(value = DataSourceType.SLAVE)
    @Insert("insert into inventory_evidence (Evidence_Number,Date,Stock_ID,DesStock_ID,MFG_Inventory_ID," +
            "   cLast,WarehouseMan,DutyMan,IssueType,Maker,Poster,remark) " +
            "VALUES (#{Evidence_Number},#{date},#{Stock_ID},#{DesStock_ID},#{MFG_Inventory_ID}," +
            "   #{cLast},#{WarehouseMan},#{DutyMan},#{IssueType},#{Maker},#{Poster},#{remark})")
    public int insertInventoryEvidence( InventoryEvidence inventoryEvidence);

    @DataSource(value = DataSourceType.SLAVE)
    @Insert("insert into Inventory_Evidence_Detail(Evidence_Number,Inventory_ID,NOID,Qty,Shortage_Qty,Actual_Qty,ProjectBatch) " +
            "VALUES (#{Evidence_Number},#{Inventory_ID},#{NOID},#{Qty},#{Shortage_Qty},#{Actual_Qty},#{ProjectBatch})")
    public int insertInventoryEvidenceDetail( InventoryEvidenceDetail inventoryEvidenceDetail);
}
