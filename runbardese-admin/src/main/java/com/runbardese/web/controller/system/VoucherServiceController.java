package com.runbardese.web.controller.system;

import com.runbardese.system.mapper.U8CMapper;
import com.runbardese.system.service.U8CMessageService;
import com.runbardese.system.service.impl.U8CJaxRsServiceImpl;
import com.runbardese.web.controller.U8C.HttpClient;
import com.runbardese.web.controller.U8C.SendXmlToNc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;

@RestController
@RequestMapping("/bds")
public class VoucherServiceController {

    @Autowired
    private U8CMessageService u8CMessageServiceImpl ;

    @Autowired
    private U8CMapper u8CMapper;


   // @Scheduled(cron = "0/5 *  *  * * ?" )
    public void addVoucher() {
        //通过http请求获取xml内容
        String str = new HttpClient().getHttpData("http://localhost:8080/api/u8c/getNcXml");
        //解析出evidenceNum
        String evidenceNum = str.substring(str.indexOf("<evidence_number>") + 17, str.indexOf("</evidence_number>"));
        //打印http获取字符串
        System.out.println(str);
        //去除获取字符串的xml头以及evidence标签体里的内容
        if (str.startsWith("<?xml ")) {
            str = str.substring(str.indexOf("?>") + 2);
            str = str.substring(0, str.indexOf("<evidence_number>")) + str.substring(str.indexOf("</evidence_number>") + 18);
            //打印截取后的字符串
            System.out.println(str);
        }
        //打印evidence内容
        System.out.println(evidenceNum);

        int startVoucher = str.indexOf("<voucher_id>");
        int endVoucher = str.indexOf("</voucher_id>");
        //获取voucherId
        String voucherId = str.substring(startVoucher + 12, endVoucher);

        int startYear = str.indexOf("<fiscal_year>");
        int endYear = str.indexOf("</fiscal_year>");
        int year = Integer.valueOf(str.substring(startYear + 13,endYear));

        int startMonth = str.indexOf("<accounting_period>");
        int endMonth = str.indexOf("</accounting_period>");
        int month = Integer.valueOf(str.substring(startMonth + 19,endMonth));

        //调用u8c系统接口，传输凭证
        String s = null;
        try {
            s = new SendXmlToNc().sendXMLToNC("http://192.168.100.185:8088/service/XChangeServlet?operator=0001A110000000000U3D", str);
        } catch (Exception e) {
            System.out.println("调用接口异常");
        }

        System.out.println(s);

        int startBdo = s.indexOf("<bdocid>");
        int endBdo = s.indexOf("</bdocid>");
        int startCode = s.indexOf("<resultcode>");
        int endCode = s.indexOf("</resultcode>");
        int startDes = s.indexOf("<resultdescription>");
        int endDes = s.indexOf("</resultdescription>");
        int startCont = s.indexOf("<content>");
        int endCont = s.indexOf("</content>");

        String bdocid = s.substring(startBdo + 8, endBdo);
        String resultcode = s.substring(startCode + 12, endCode);
        String resultdescription = s.substring(startDes + 19, endDes);
        String content = s.substring(startCont + 9, endCont);

        System.out.println("bdocid====" + bdocid);
        System.out.println("voucherId===="+voucherId);
        System.out.println("resultcode====" + resultcode);
        System.out.println("resultdescription====" + resultdescription);
        System.out.println("content====" + content);

        //查询该错误凭证是否存在
        if (!("1".equals(resultcode)) ) {
            String errFlag = u8CMessageServiceImpl.selectVoucherErroCodeById(bdocid);
            //反写错误凭证
            int upFlag = u8CMapper.updateUpErroStatus(U8CJaxRsServiceImpl.pzh,year,month,new Date(System.currentTimeMillis()));
            System.out.println("update===="+upFlag + "==========反写成功");
            if(errFlag !=null){
                System.out.println("error凭证已存在");
            }else{
                int flag = u8CMessageServiceImpl.insertVoucherErroMes(bdocid, voucherId, resultcode, resultdescription, new Date(System.currentTimeMillis()));
                System.out.println(flag + "===新增错误凭证成功");
            }
        } else if("1".equals(resultcode)){
            int succNum = u8CMapper.updateUpSuccStatus(U8CJaxRsServiceImpl.pzh,year,month,new Date(System.currentTimeMillis()));
            //int sucNum = u8CMessageServiceImpl.insertVoucherSucMes(evidenceNum,voucherId,new Date(System.currentTimeMillis()));
            System.out.println(succNum+"===新增成功凭证");
        }
    }
}
