package com.runbardese.system.mapper;

import com.runbardese.common.annotation.DataSource;
import com.runbardese.common.enums.DataSourceType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author Tao
 * @Date 2020/7/20
 * @Time 9:13
 */
@Mapper
public interface tblLabelDataMapper {
    @DataSource(value = DataSourceType.SLAVE)
    @Select("select JarReportName  from tblLabelPrintReportData where AdmCode=#{AdmCode}")
    public String selectJarReportNameByAdmCode();
}
