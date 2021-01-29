package com.runbardese.system.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * 防伪码库
 *
 */
@Data
@Component
@XmlRootElement(name = "CodeData")
public class CodeData {
    //二维码
    private String  QRCode;
    //随机串
    private String RandCode;
    //工厂码
    private String BacthID;
    //加密码
    private String Code;
    //日期
    private Date CreateDate;
    //打印状态 0/1激活状态
    private int IsSend;
    //管理码
    private String AdmCode;

}
