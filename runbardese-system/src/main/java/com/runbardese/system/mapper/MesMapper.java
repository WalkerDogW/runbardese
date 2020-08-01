package com.runbardese.system.mapper;

import com.runbardese.common.annotation.DataSource;
import com.runbardese.common.enums.DataSourceType;
import com.runbardese.system.domain.ERPProd;
import com.runbardese.system.domain.ERPProdBom;
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

}
