package com.runbardese.system.mapper;

import com.runbardese.common.annotation.DataSource;
import com.runbardese.common.enums.DataSourceType;
import com.runbardese.system.domain.PrintCode;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface PrintCodeMapper {

    @Select("select * from PrintCode where PrintS=#{PrintS}")
    public List<PrintCode> selectAllCode(@Param("PrintS") int PrintS);


    @Select("select * from PrintCode where OrderId=#{orderId}")
    @DataSource(value = DataSourceType.SLAVE)
    public List<PrintCode> selectCode(@Param("orderId") String orderId);

    @Select("select * from PrintCode where OrderId=#{orderId} and PrintS=0")
    @DataSource(value = DataSourceType.SLAVE)
    public List<PrintCode> selectOrderId(@Param("orderId") String orderId);

    @Update("update PrintCode set PrintS = 1 where OrderId = #{OrderId} and PrintS=0")
    @DataSource(value=DataSourceType.SLAVE)
    public int updateCode(@Param("OrderId") String OrderId);


    @Insert("insert into PrintCode values(#{OrderId},#{AdmCode},#{ProjectBatch},#{Inventory_ID},#{InventoryName},#{PrintS},#{QRcode})")
    @DataSource(value = DataSourceType.SLAVE)
    public int insertCode(@Param("OrderId") String OrderId,
                          @Param("AdmCode") String AdmCode,
                          @Param("ProjectBatch") String ProjectBatch,
                          @Param("Inventory_ID") String Inventory_ID,
                          @Param("InventoryName") String InventoryName,
                          @Param("PrintS") int PrintS,
                          @Param("QRcode") String QRcode);
}
