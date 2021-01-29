package com.runbardese.web.controller.system;

import com.runbardese.common.annotation.Log;
import com.runbardese.common.core.domain.AjaxResult;
import com.runbardese.common.enums.BusinessType;
import com.runbardese.framework.util.ShiroUtils;
import com.runbardese.system.domain.*;
import com.runbardese.system.mapper.PLCMapper;
import com.runbardese.system.service.ISysUserService;
import com.runbardese.web.controller.system.service.TestService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * @author Tao
 * @Date 2020/7/25
 * @Time 15:04
 */
@RequestMapping("/bds/api/")
@RestController
public class TestController {
    private static final Logger log = LoggerFactory.getLogger(SysPrintDataController.class);

    //不要问我为什么取这个名字
    @Autowired
    TestService testService;




    /**
     * 根据日期(DuDate)获取标签信息  【ERP提供】
     * @param duDate
     * @return
     */
    @GetMapping("/findByDuDate/{duDate}")
    @ResponseBody
    public AjaxResult findByDuDate(@PathVariable("duDate") String duDate )
    {
        List<TblLabelPrintReportData> tblLabelPrintReportDataList =  testService.findByDuDate(duDate);

        return  new AjaxResult(AjaxResult.Type.SUCCESS,"成功" ,tblLabelPrintReportDataList);


    }
}
