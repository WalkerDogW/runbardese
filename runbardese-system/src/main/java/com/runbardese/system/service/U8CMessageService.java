package com.runbardese.system.service;

import com.runbardese.system.domain.voucher.U8CErrCode;
import com.runbardese.system.domain.voucher.U8CSuccessCode;
import java.util.Date;
import java.util.List;

public interface U8CMessageService {

    //获取对接错误凭证
    public List<U8CErrCode> selectVoucherErroCode();

    public String selectVoucherErroCodeById(String evidenceNum);

    //插入对接错误凭证
    public int insertVoucherErroMes(String id, String voucherCode, String resultCode, String resultDes, Date currentDate);

    //插入对接成功凭证
    public int insertVoucherSucMes(String evdence_number, String voucher_id, Date date);

    //查询对接成功凭证
    public List<U8CSuccessCode> selectVoucherSuccCode();
}
