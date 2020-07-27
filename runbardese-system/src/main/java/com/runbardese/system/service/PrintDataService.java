package com.runbardese.system.service;

import com.runbardese.system.domain.PrintData;
import org.apache.tomcat.jni.Local;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * 标签打印信息
 * @Author RunJ
 */
public interface PrintDataService {

    //根据批号查询打印标签
    public List<PrintData> selectPrintDataByJarNo(String jarNo);

    //更新已打印标签数量
    public int updatePrintDataByQRCode(String lastUpMan ,Date lastUpDate,String qRCode,String username);

    //根据二维码查询打印标签
    public List<PrintData> selectPrintDataByQRCode(String qRCode);

    //传打印数据给追溯系统
    public List<PrintData> selectMaterialsNotTrace(String username, LocalDate today);

    //更新打印数据传输到追溯系统的状态
    int updateTraceByQRCode( String qRCode);
}
