package com.runbardese.system.service.impl;

import com.runbardese.system.domain.PrintData;
import com.runbardese.system.mapper.PrintDataMapper;
import com.runbardese.system.service.PrintDataService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * 标签打印信息
 *
 * @Author RunJ
 */
@Service
public class PrintDataServiceImpl implements PrintDataService {

    //注入mapper
    @Autowired
    PrintDataMapper printDataMapper;

    /**
     * 根据批号查询打印数据
     * @param jarNo 批号
     * @return
     */
    @Override
    public List<PrintData> selectPrintDataByJarNo(String jarNo) {

        return printDataMapper.selectPrintDataByJarNo(jarNo);
    }

    /**
     * 根据二维码信息查询打印标签
     * @param qRCode 二维码信息
     * @return
     */
    @Override
    public List<PrintData> selectPrintDataByQRCode(String qRCode) {
        return printDataMapper.selectPrintDataByQRCode(qRCode);
    }

    /**
     * 查找未发送给追溯系统的打印信息
     * @param username
     * @return
     */
    @Override
    public List<PrintData> selectMaterialsNotTrace(String username, LocalDate today) {
        return printDataMapper.selectMaterialsNotTrace(username,today);
    }

    /**
     * 根据二维码信息更新已打印标签数量
     * @param lastUpMan 操作者
     * @param lastUpDate 更新时间
     * @param qRCode 二维码信息
     * @return
     */
    @Override
    public int updatePrintDataByQRCode(String lastUpMan, Date lastUpDate,String qRCode,String username) {

        return printDataMapper.updatePrintDataByQRCode(lastUpMan,lastUpDate,qRCode,username);
    }


    /**
     * 更新打印数据传输到追溯系统的状态
     * @param lastUpMan
     * @param lastUpDate
     * @param qRCode
     * @return
     */
    @Override
    public int updateTraceByQRCode(String qRCode) {

        return printDataMapper.updateTraceByQRCode(qRCode);
    }

}
