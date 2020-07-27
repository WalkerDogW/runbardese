package com.runbardese.system.service.impl;

import com.runbardese.common.annotation.DataSource;
import com.runbardese.common.enums.DataSourceType;
import com.runbardese.system.domain.voucher.U8CErrCode;
import com.runbardese.system.domain.voucher.U8CSuccessCode;
import com.runbardese.system.mapper.U8CMapper;
import com.runbardese.system.service.U8CMessageService;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class U8CMessageServiceImpl implements U8CMessageService {

    @Autowired
    private U8CMapper u8CMapper;

    /**
     * 获取对接错误凭证
     * @return
     */
    @Override
    public List<U8CErrCode> selectVoucherErroCode() {
        return u8CMapper.selectVoucherErroCode();
    }

    @Override
    public String selectVoucherErroCodeById(String evidenceNum) {
        return u8CMapper.selectVoucherErroCodeById(evidenceNum);
    }

    /**
     * 插入对接错误凭证
     * @param id
     * @param voucherCode
     * @param resultCode
     * @param resultDes
     * @param currentDate
     * @return
     */
    @Override
    @DataSource(value = DataSourceType.MASTER)
    @Insert("insert into sys_u8c_error values(#{id},#{voucher_code},#{result_code},#{resultdes},#{current_date})")
    public int insertVoucherErroMes(String id, String voucherCode, String resultCode, String resultDes, Date currentDate) {
        return u8CMapper.insertVoucherErroMes(id,voucherCode,resultCode,resultDes,currentDate);
    }

    /**
     * 插入对接成功凭证
     * @param evdence_number
     * @param voucher_id
     * @param date
     * @return
     */
    @Override
    public int insertVoucherSucMes(String evdence_number, String voucher_id, Date date) {
        return u8CMapper.insertVoucherSucMes(evdence_number,voucher_id,date);
    }

    /**
     * 查询对接成功凭证
     * @return
     */
    @Override
    public List<U8CSuccessCode> selectVoucherSuccCode() {
        return u8CMapper.selectVoucherSuccCode();
    }
}
