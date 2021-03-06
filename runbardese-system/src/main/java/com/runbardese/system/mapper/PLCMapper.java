package com.runbardese.system.mapper;

import com.runbardese.common.annotation.DataSource;
import com.runbardese.common.enums.DataSourceType;
import com.runbardese.system.domain.InventoryEvidence;
import com.runbardese.system.domain.InventoryEvidenceDetail;
import com.runbardese.system.domain.MaterialIssue;
import com.runbardese.system.domain.MaterialIssueDetail;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Tao
 * @Date 2020/7/25
 * @Time 14:56
 */
@Mapper

public interface PLCMapper {
    @DataSource(value = DataSourceType.SLAVE)
//    @Select("select *  from ProjectMaterial_Issue_Plan where No=#{No}")
    @Select("select t1.*,t2.Description as Des_StockName  " +
            "from Material_Issue_Plan as t1 " +
            "left join Stock as t2 on t1.Des_StockId = t2.Stock_Id " +
            "where No=#{No}")
    public MaterialIssue selectMaterialIssue(@Param("No") String No);

    @DataSource(value = DataSourceType.SLAVE)
//    @Select("select *  from ProjectMaterial_Issue_Plan_Detail where No=#{No}")
    @Select("select t1.*,t2.description from Material_Issue_Plan_Detail t1\n" +
            "left join inventory t2 on t1.inventory_id=t2.inventory_id where No=#{No} ")
    public List<MaterialIssueDetail> selectMaterialIssueDetail(@Param("No") String No);

    @DataSource(value = DataSourceType.SLAVE)
    @Select("select *  from inventory_evidence where Evidence_Number=#{Evidence_Number}")
    public InventoryEvidence selectInventoryEvidence(@Param("Evidence_Number") String No);


    @DataSource(value = DataSourceType.SLAVE)
    @Select("select *  from Inventory_Evidence_Detail where Evidence_Number=#{Evidence_Number}")
    public List<InventoryEvidenceDetail> selectInventoryEvidenceDetail(@Param("Evidence_Number") String No);

    @DataSource(value = DataSourceType.SLAVE)
    @Insert("insert into inventory_evidence (Evidence_Number,Date,Stock_ID,Type,DesStock_ID," +
            "MFG_Inventory_ID, cLast,IssueType ,remark) " +
            "VALUES (#{Evidence_Number},#{date},#{Stock_ID},#{Type},#{DesStock_ID}," +
            "#{MFG_Inventory_ID}, #{cLast},#{IssueType},#{remark})")
    public int insertInventoryEvidence( InventoryEvidence inventoryEvidence);

    @DataSource(value = DataSourceType.SLAVE)
    @Insert("insert into Inventory_Evidence_Detail(Evidence_Number,Inventory_ID,NOID,Qty,Actual_Qty,ProjectBatch) " +
            "VALUES (#{Evidence_Number},#{Inventory_ID},#{NOID},#{Qty},#{Actual_Qty},#{ProjectBatch})")
    public int insertInventoryEvidenceDetail( InventoryEvidenceDetail inventoryEvidenceDetail);


    @DataSource(value = DataSourceType.SLAVE)
    @Update("update Material_Issue_Plan_Detail " +
            "set Q1=#{Q1},Q2=#{Q2},Q3=#{Q3},ActUsedQty=#{ActUsedQty} " +
            "where No=#{No} and Inventory_ID=#{Inventory_ID} and NOID=#{NOID}")
    public int updateMaterialIssueDetail(MaterialIssueDetail materialIssueDetail);
}
