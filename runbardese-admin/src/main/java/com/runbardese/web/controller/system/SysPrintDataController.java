package com.runbardese.web.controller.system;

import com.runbardese.system.domain.*;
import com.runbardese.system.mapper.TblBarMapper;
import com.runbardese.system.service.ISysUserService;
import com.runbardese.system.service.PrintDataService;
import com.runbardese.system.service.TblBarService;
import com.runbardese.system.service.TblPackIssueService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 打印标签接口
 *
 * @Author RunJ
 */
@RestController
@RequestMapping("/bds/api")
public class SysPrintDataController {

    private static final Logger log = LoggerFactory.getLogger(SysPrintDataController.class);

    //注入标签服务
    @Autowired
    PrintDataService printDataServiceImpl;

    //注入request
    @Autowired
    HttpServletRequest request;

    @Autowired
    TblBarService tblBarService;

    //注入用户服务
    @Autowired
    private ISysUserService iSysUserService;

    //创建返回结果接受集合
    List<PrintData> list = new ArrayList<>();


    @Autowired
    TblBarMapper tblBarMapper;

    //包装单服务
    @Autowired
    private TblPackIssueService tblPackIssueService;

    @ApiOperation("新增托盘信息")
    @PostMapping(value = {"/insertTblBar", "/trace/insertTblBar"})
    public CodeMsg insertTblBar(@RequestBody TblBar tblBar) {
        log.info("********************\n" + request.getRequestURL() + "?" + request.getQueryString() + "\n" + tblBar + "\n********************");

        //创建返回消息实体
        CodeMsg codeMsg = new CodeMsg();
        //获取托盘主表
        TblBarRelation tblBarRelation = tblBar.getTblBarRelation();
        //根据evidence_Number查询托盘主表数据
        String s = null;
        s = tblBarMapper.selectTblBarByEvidenceNum(tblBarRelation.getEvidence_Number());
        //判断该evidence_Number是否存在托盘主表数据库 不存在则插入数据
        if (StringUtils.isEmpty(s)) {
            //新增托盘主表
            System.out.println(tblBarRelation);
            int n = tblBarService.insertTblBarRelation(tblBarRelation);
            //获取托盘细表列表
            List<TblBarRelationDetail> tblBarRelationDetailList = tblBar.getTblBarRelationDetailList();
            //遍历托盘细表
            for (TblBarRelationDetail tblBarRelationDetail : tblBarRelationDetailList) {
                //根据evidence_Number查询托盘细表数据
                String s1 = null;
                s1 = tblBarMapper.selectTblBarDetailByEvidenceNum(tblBarRelationDetail.getEvidence_Number(), tblBarRelationDetail.getNoid());
                //判断该evidence_Number是否存在托盘细表数据库 不存在则插入数据
                if (StringUtils.isEmpty(s1)) {
                    //新增托盘细表
                    int m = tblBarService.insertTblBarRelationDetail(tblBarRelationDetail);
                } else {
                    //细表失败信息
                    codeMsg.setCode(2);
                    codeMsg.setMsg("托盘细表编号已存在：" + tblBarRelationDetail.getEvidence_Number() + "\tNoid：" + tblBarRelationDetail.getNoid());
                    return codeMsg;
                }
            }
        } else {
            //主表失败信息
            codeMsg.setCode(1);
            codeMsg.setMsg("托盘主表编号已存在：" + tblBarRelation.getEvidence_Number());
            return codeMsg;
        }

        //成功信息
        codeMsg.setCode(0);
        codeMsg.setMsg("成功");
        return codeMsg;
    }

    /**
     * 根据批号查询打印标签信息
     *
     * @param jarNo
     * @param username
     * @return
     */
    @ApiOperation("获取打印标签明细")
    @ApiImplicitParams({@ApiImplicitParam(name = "jarNo", value = "标签批号", required = true, dataType = "string", paramType = "path"),
            @ApiImplicitParam(name = "username", value = "请求姓名", required = true, dataType = "string", paramType = "query")})
    @GetMapping(value = {"/findByJarNo/{jarNo}", "/trace/findByJarNo/{jarNo}"})
    public PrintDataMsg selectPrintDataByJarNo(@PathVariable("jarNo") String jarNo, @RequestParam("username") String username) {
        log.info("********************\n" + request.getRequestURL() + "?" + request.getQueryString() + "\n********************");

        //新增返回码实体类
        CodeMsg codeMsg = new CodeMsg();
        //获取URL上用户姓名
        String name = request.getParameter("username");
        PrintDataMsg printDataMsg = new PrintDataMsg();
        System.out.println(request.getRequestURL() + "?" + request.getQueryString());
        try {
            //根据用户名获取用户信息
            SysUser user = iSysUserService.selectUserByLoginName(name);
            String uname = user.getLoginName();
        } catch (RuntimeException re) {
            codeMsg.setCode(2);
            codeMsg.setMsg("用户名不存在请联系管理员！");
            printDataMsg.setCodeMsg(codeMsg);
            return printDataMsg;
        }
        //根据批号获取打印标签信息
        list = printDataServiceImpl.selectPrintDataByJarNo(jarNo);
        //判断批号是否存在
        if (list.isEmpty()) {
            codeMsg.setCode(1);
            codeMsg.setMsg("批号不存在");
            printDataMsg.setCodeMsg(codeMsg);
            return printDataMsg;
        } else {
            //返回标签信息
            codeMsg.setCode(0);
            codeMsg.setMsg("成功");
            printDataMsg.setCodeMsg(codeMsg);
            printDataMsg.setPrintData(printDataServiceImpl.selectPrintDataByJarNo(jarNo));
            return printDataMsg;
        }
    }

    /**
     * 根据标签二维码更新已打印标签的数量
     *
     * @param lastUpMan 操作着
     * @param qRCode    二维码
     * @param username
     * @return
     */
    @ApiOperation("更新已打印标签")
    @ApiImplicitParams({@ApiImplicitParam(name = "lastUpMan", value = "操作员", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "qRCode", value = "标签二维码", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "username", value = "请求姓名", required = true, dataType = "string", paramType = "query")})
    @PutMapping(value = {"/updateByQRCode", "/trace/updateByQRCode"})
    public Object updatePrintDataByQRCode(@RequestParam("lastUpMan") String lastUpMan, @RequestParam(required = false, value = "qRCode") String qRCode,
                                          @RequestParam("username") String username) {
//        ,@RequestParam(required = false,value = "AdmCode") String AdmCode
        log.info("********************\n" + request.getRequestURL() + "?" + request.getQueryString() + "\n********************");

        //新增返回码实体类
        UpdateCodeMsg updateCodeMsg = new UpdateCodeMsg();
        CodeMsg codeMsg = new CodeMsg();
        //获取URL上用户姓名
        String name = request.getParameter("username");
        System.out.println(request.getRequestURL() + "?" + request.getQueryString());


        try {
            //根据用户名获取用户信息
            SysUser user = iSysUserService.selectUserByLoginName(name);
            String uname = user.getLoginName();
        } catch (RuntimeException re) {
            codeMsg.setCode(2);
            codeMsg.setMsg("用户名不存在请联系管理员！");
            return codeMsg;
        }
//        if(AdmCode == null) {
//            System.out.println("AdmCode not ");
//        }else{
//            qRCode = qRCode+"&AdmCode="+AdmCode;
//        }

        //根据批号获取打印标签信息
        int num = printDataServiceImpl.updatePrintDataByQRCode(lastUpMan, new Date(System.currentTimeMillis()), qRCode, username);
        list = printDataServiceImpl.selectPrintDataByQRCode(qRCode);
        //判断二维码是否存在
        if (list.isEmpty()) {
            updateCodeMsg.setqRCode(qRCode);
            updateCodeMsg.setCode(1);
            updateCodeMsg.setMsg("二维码不存在！");
            return updateCodeMsg;
        } else if (num < 0) {
            //返回标签信息
            updateCodeMsg.setCode(3);
            updateCodeMsg.setMsg("更新失败，请联系管理员！");
            updateCodeMsg.setqRCode(qRCode);
            return updateCodeMsg;
        } else {
            updateCodeMsg.setqRCode(qRCode);
            updateCodeMsg.setCode(0);
            updateCodeMsg.setMsg("成功");
            updateCodeMsg.setUpdate(num);
            return updateCodeMsg;
        }
    }


    @GetMapping(value = {"/materialsNotTrace", "/trace/materialsNotTrace"})
    public PrintDataMsg selectMaterialsNotTrace(@RequestParam("username") String username) {
        log.info("********************\n" + request.getRequestURL() + "?" + request.getQueryString() + "\n********************");

        LocalDate today = LocalDate.now();
        //新增返回码实体类
        CodeMsg codeMsg = new CodeMsg();
        //获取URL上用户姓名
        String name = request.getParameter("username");
        PrintDataMsg printDataMsg = new PrintDataMsg();
        System.out.println(request.getRequestURL() + "?" + request.getQueryString());

        try {
            //根据用户名获取用户信息
            SysUser user = iSysUserService.selectUserByLoginName(name);
            String uname = user.getLoginName();
            System.out.println("**************操作用户：" + uname);
        } catch (RuntimeException re) {
            codeMsg.setCode(2);
            codeMsg.setMsg("用户名不存在请联系管理员！");
            printDataMsg.setCodeMsg(codeMsg);
            return printDataMsg;
        }
        //获取未传输到追溯系统的数据
        List<PrintData> list = printDataServiceImpl.selectMaterialsNotTrace(username, today);
        if (list.isEmpty()) {
            codeMsg.setCode(1);
            codeMsg.setMsg("已无未同步数据");
            printDataMsg.setCodeMsg(codeMsg);
            return printDataMsg;
        } else {
            //返回标签信息
            codeMsg.setCode(0);
            codeMsg.setMsg("成功");
            printDataMsg.setCodeMsg(codeMsg);
            printDataMsg.setPrintData(list);
            return printDataMsg;
        }
    }


    @GetMapping("/testapi")
    public TblBar testapi() {
        TblBar tblBar = new TblBar();
        tblBar.setTblBarRelation(new TblBarRelation());
        tblBar.setTblBarRelationDetailList(new ArrayList<>());
        return tblBar;
    }


    /**
     * 更新打印数据传输到追溯系统的状态
     *
     * @param tblTraceMsg 二维码列表
     * @return
     */
    @PostMapping(value = {"/updateTraceByQRCode", "/trace/updateTraceByQRCode"})
    public CodeMsg updateTraceByQRCode(@RequestBody TblTraceMsg tblTraceMsg) {
        log.info("********************\n" + request.getRequestURL() + "?" + request.getQueryString() + "\n" + tblTraceMsg + "\n********************");

        //新增返回码实体类
        CodeMsg codeMsg = new CodeMsg();
        List<String> qRCodes = tblTraceMsg.getQRCodes();
        for (int i = 0; i < qRCodes.size(); i++) {
            //根据已传输的二维码更新传输状态
            String qRCode = qRCodes.get(i);
            int num = printDataServiceImpl.updateTraceByQRCode(qRCode);
        }

        codeMsg.setCode(0);
        codeMsg.setMsg("成功");
        return codeMsg;

    }


    /**
     * 预分垛数据接口
     *
     * @param jarNo
     * @param username
     * @return
     */
    @GetMapping(value = {"/GetEvidenceByJarNo/{jarNo}", "/trace/GetEvidenceByJarNo/{jarNo}"})
    public TblPreSplitMsg getEvidenceByJarNo(@PathVariable("jarNo") String jarNo, @RequestParam("username") String username) {
        log.info("********************\n" + request.getRequestURL() + "?" + request.getQueryString() + "\n********************");

        TblPreSplitMsg tblPreSplitMsg = new TblPreSplitMsg();
        CodeMsg codeMsg = new CodeMsg();
        //获取URL上用户姓名
        String name = request.getParameter("username");
        System.out.println("****************" + request.getRequestURL() + "?" + request.getQueryString());
        try {
            //根据用户名获取用户信息
            SysUser user = iSysUserService.selectUserByLoginName(name);
            String uname = user.getLoginName();
        } catch (RuntimeException re) {
            codeMsg.setCode(1);
            codeMsg.setMsg("用户名不存在请联系管理员！");
            tblPreSplitMsg.setCodeMsg(codeMsg);
            return tblPreSplitMsg;
        }

        List<TblPreSplit> evidenceByJarNo = tblPackIssueService.getEvidenceByJarNo(jarNo);
        tblPreSplitMsg.setTblPreSplit(evidenceByJarNo);
        if (evidenceByJarNo.isEmpty()) {
            codeMsg.setCode(1);
            codeMsg.setMsg("此批号无相关信息！");
            tblPreSplitMsg.setCodeMsg(codeMsg);
        } else {
            codeMsg.setCode(0);
            codeMsg.setMsg("成功");
            tblPreSplitMsg.setCodeMsg(codeMsg);
        }
        return tblPreSplitMsg;
    }


}
