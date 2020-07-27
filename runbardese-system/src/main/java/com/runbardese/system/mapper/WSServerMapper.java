package com.runbardese.system.mapper;


import com.runbardese.system.domain.CodeData;
import com.runbardese.system.domain.PrintCode;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import javax.ws.rs.PathParam;
import java.util.List;

public interface WSServerMapper {

    @Select("select * from printCode where orderId=#{orderId}")
    public List<PrintCode> selectWSAll(@Param("orderId") String orderId);

    @Update("update PrintCode set PrintS = 1 where OrderId = #{orderId}")
    public int updateCode(@Param("orderId") String orderId);

//    @Select("select * from sys_user where  ")
//    public String findUsername(@PathParam("username") String username);
}
