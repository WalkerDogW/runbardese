package com.runbardese.system.domain.voucher;

import lombok.Data;

import java.util.Date;

/**
 * 凭证对接成功实体
 */
@Data
public class U8CSuccessCode {

    private String evidence_number;
    private String voucder_id;
    private Date date;

}
