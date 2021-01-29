package com.runbardese.system.mapper;

import com.runbardese.common.annotation.DataSource;
import com.runbardese.common.enums.DataSourceType;
import com.runbardese.system.domain.ERPProd;
import com.runbardese.system.domain.ERPProdBom;
import com.runbardese.system.domain.Tblproductexecution;
import com.runbardese.system.domain.Tblproductexecution_detail;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Tao
 * @Date 2020/7/30
 * @Time 15:35
 */
@Mapper
public interface MesMapper {
    @DataSource(value = DataSourceType.SLAVE5)
    @Select("select * from ERPProdTable where ProdId = #{ProdId}")
    public ERPProd selectERPProd(@Param("ProdId") String ProdId);

    @DataSource(value = DataSourceType.SLAVE5)
    @Select("select * from  ERPProdBom where ProdId = #{ProdId}")
    public List<ERPProdBom> selectERPProdBom(@Param("ProdId") String ProdId);


    @DataSource(value = DataSourceType.SLAVE5)
    @Insert("insert into ERPProdTable (BomId,ProdCode,ProdName,Version,PlanCreater,PlanCreateDate, " +
            "RequiedFinishDate,TotalQty,Remark,CompanyId,ProdId,InventBatchId,WrkCtrId,BeginTime, " +
            "FinishedTime,Color,RealQty,InterfaceStatus,Reason) " +
            "Values (#{BomId},#{ProdCode},#{ProdName},#{Version},#{PlanCreater},#{planCreateDate },\n" +
            "#{requiedFinishDate},#{TotalQty},#{Remark},#{CompanyId},#{ProdId},#{InventBatchId},#{WrkCtrId},#{beginTime},\n" +
            "#{finishedTime},#{Color},#{RealQty},#{InterfaceStatus},#{Reason})")
    public int insertERPProd(ERPProd erpProd);

    @DataSource(value = DataSourceType.SLAVE5)
    @Insert("insert into ERPProdBOM (LineNum,MatCode,MatName,TargetQty,FuncCode,Param1,Param2,Position,Remark,ProdId) " +
            "Values (#{LineNum},#{MatCode},#{MatName},#{TargetQty},#{FuncCode},#{Param1},#{Param2},#{Position},#{Remark},#{ProdId})")
    public int insertERPProdBOM(ERPProdBom erpProdBOM);

    @DataSource(value = DataSourceType.SLAVE)
    @Select(" select \n" +
            " t1.*,t3.DuDate,t2.Description\n" +
            "from Tblproductexecution as t1\n" +
            " left join stock as t2 on t1.WipID = t2.Stock_ID\n" +
            " left join Material_Issue_Plan as t3 on t3.No = t1.BatchNo where BatchNo= #{BatchNo}")
    public Tblproductexecution selectTblproductexecution(@Param("BatchNo") String BatchNo);


    @DataSource(value = DataSourceType.SLAVE)
    @Select("select * from Tblproductexecution_detail where BatchNo= #{BatchNo}")
    public List<Tblproductexecution_detail> selectTblproductexecution_detail(@Param("BatchNo") String BatchNo);



}
