package com.runbardese.system.mapper;

import com.runbardese.common.annotation.DataSource;
import com.runbardese.common.enums.DataSourceType;
import com.runbardese.system.domain.PrintData;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * 打印标签mapper
 * @Author RunJ
 */
public interface PrintDataMapper {

    /**
     * 根据批号查询标签信息,打印状态为0
     * @param jarNo 批号
     * @return
     */

    @DataSource(value = DataSourceType.SLAVE)
    @Select("select t1.*,t2.jarReportName " +
            "from bds_PrintData as t1 " +
            "inner join tblLabelPrintReportData as t2 on t1.AdmCode=t2.AdmCode AND Printed=0 "+
            "where t1.jarNo = #{jarNo} and t1.printStatus = 0")
    public List<PrintData> selectPrintDataByJarNo(@Param("jarNo")String jarNo);


    /**
     * 根据上托盘子表批号查询子表信息，打印状态为1
     * @param projectBatch 批号
     * @return
     */
    @DataSource(value = DataSourceType.SLAVE)
    @Select("select * from bds_PrintData where jarNo = #{jarNo} and printStatus = 1")
    public List<PrintData> selectPrintDataByprojectBatch(String projectBatch);

    /**
     * 根据二维码信息查询打印标签
     * @param qRCode 二维码
     * @return
     */
    @DataSource(value = DataSourceType.SLAVE)
    @Select("select * from bds_PrintData where qRCode = #{qRCode}")
    public List<PrintData> selectPrintDataByQRCode(String qRCode);

    /**
     * 根据已打印二维码更新相应的打印数量
     * @param lastUpMan 操作者
     * @param lastUpDate 更新时间
     * @param qRCode 二维码信息
     * @return
     */
    @DataSource(value = DataSourceType.SLAVE)
    @Update("update bds_PrintData set lastUpMan = #{lastUpMan},printQty = printQty+1,printStatus = 1,lastUpDate = #{lastUpDate},PrintSystem=#{username}  where qRCode = #{qRCode}")
    public int updatePrintDataByQRCode(@Param("lastUpMan") String lastUpMan , @Param("lastUpDate") Date lastUpDate, @Param("qRCode") String qRCode,@Param("username") String username);

    /**
     * 根据已传输的二维码更新传输状态
     * @param lastUpMan
     * @param lastUpDate
     * @param qRCode
     * @return
     */
    @DataSource(value = DataSourceType.SLAVE)
    @Update("update bds_PrintData set TraceStatus = 1 where qRCode = #{qRCode}")
    public int updateTraceByQRCode(@Param("qRCode") String qRCode);



    /**
     * 查找未传给追溯系统的打印信息
     * @param username
     * @return
     */
    @DataSource(value = DataSourceType.SLAVE)
    @Select("select top 1000 t1.* " +
            "from bds_PrintData as t1 " +
            "where TraceStatus=0 and PrintSystem!=#{username} and  LastUpdate>=#{today}")
    List<PrintData> selectMaterialsNotTrace(@Param("username") String username,@Param("today") LocalDate today);
}
