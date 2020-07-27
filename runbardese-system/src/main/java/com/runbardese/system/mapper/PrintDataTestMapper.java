package com.runbardese.system.mapper;

import com.runbardese.common.annotation.DataSource;
import com.runbardese.common.enums.DataSourceType;
import com.runbardese.system.domain.PrintCode;
import com.runbardese.system.domain.PrintData;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;
import java.util.List;

public interface PrintDataTestMapper {
    /**
     * 根据批号查询标签信息,打印状态为0
     * @param jarNo 批号
     * @return
     */
    @DataSource(value = DataSourceType.SLAVE4)
    @Select("select * from bds_PrintData where jarNo = #{jarNo} and printStatus = 0")
    public List<PrintData> selectPrintDataByJarNo(String jarNo);


    /**
     * 根据上托盘子表批号查询子表信息，打印状态为1
     * @param projectBatch 批号
     * @return
     */
    @DataSource(value = DataSourceType.SLAVE4)
    @Select("select * from bds_PrintData where jarNo = #{jarNo} and printStatus = 1")
    public List<PrintData> selectPrintDataByprojectBatch(String projectBatch);

    /**
     * 根据二维码信息查询打印标签
     * @param qRCode 二维码
     * @return
     */
    @DataSource(value = DataSourceType.SLAVE4)
    @Select("select * from bds_PrintData where qRCode = #{qRCode}")
    public List<PrintData> selectPrintDataByQRCode(String qRCode);

    /**
     * 根据已打印二维码更新相应的打印数量
     * @param lastUpMan 操作者
     * @param lastUpDate 更新时间
     * @param qRCode 二维码信息
     * @return
     */
    @DataSource(value = DataSourceType.SLAVE4)
    @Update("update bds_PrintData set lastUpMan = #{lastUpMan},printQty = printQty+1,printStatus = 1,lastUpDate = #{lastUpDate} where qRCode = #{qRCode}")
    public int updatePrintDataByQRCode(@Param("lastUpMan") String lastUpMan , @Param("lastUpDate") Date lastUpDate, @Param("qRCode") String qRCode);
}
