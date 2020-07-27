package com.runbardese.system.mapper;

import com.runbardese.common.annotation.DataSource;
import com.runbardese.common.enums.DataSourceType;
import com.runbardese.system.domain.PrintData;
import com.runbardese.system.domain.TblPreSplit;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Tao
 * @Date 2020/7/21
 * @Time 9:58
 */

@Mapper
public interface TblPackIssueMapper {
    @DataSource(value = DataSourceType.SLAVE)
    @Select("select t1.JarNO,t1.productID,t2.description,t1.Inventory_ID,t1.nbox,t1.JarQty,t4.ContactName \n" +
            "from tblPackIssuePlan_Detail as t1\n" +
            "left join inventory as t2 on t2.Inventory_ID=t1.productID\n" +
            "left join tblPackIssuePlan as t3 on t3.NO=t1.NO\n" +
            "left join mis_Customer as t4 on t4.ContactNum=t3.ContactNum\n" +
            " where t1.JarNo=#{jarNo}   ")
    public List<TblPreSplit>  getEvidenceByJarNo(@Param("jarNo")String jarNo);
}
