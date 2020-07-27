package com.runbardese.system.mapper;

import com.runbardese.system.domain.CodeData;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 查询防伪码
 */
public interface BdsCodeMapper {

    @Select("select * from PrintCode where printCode = #{printCode}" )
    public List<CodeData> selectBDSAll(String printCode);
}
