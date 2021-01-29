package com.runbardese.web.controller.system.mapper;

import com.runbardese.common.annotation.DataSource;
import com.runbardese.common.enums.DataSourceType;
import com.runbardese.system.domain.TblLabelPrintReportData;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TestMapper {



    @Select("SELECT DuDate,No,Inventory_ID,unit_weight,BInventory_ID ,PrintQty, PrintedQty,ID FROM tblLabelPrintReportData WHERE FromEviNum is null and Printed=0 and DuDate=#{s}")
    @DataSource(value = DataSourceType.SLAVE)
    List<TblLabelPrintReportData>findByDuDate(@Param("s") String s);

}
