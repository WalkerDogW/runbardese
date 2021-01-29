package com.runbardese.system.mapper;

import com.runbardese.common.annotation.DataSource;
import com.runbardese.common.enums.DataSourceType;
import com.runbardese.system.domain.FixedCapital;
import com.runbardese.system.domain.MaterialIssue;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author Tao
 * @Date 2020/12/22
 * @Time 10:45
 */
@Mapper
public interface FixedCapitalMapper {
    @DataSource(value = DataSourceType.SLAVE6)
    @Select("select * from ")
    public FixedCapital getFixedCapital(@Param("id") String id);
}
