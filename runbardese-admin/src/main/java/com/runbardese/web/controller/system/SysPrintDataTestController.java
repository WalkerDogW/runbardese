package com.runbardese.web.controller.system;

import com.runbardese.system.domain.*;
import com.runbardese.system.mapper.PrintDataTestMapper;
import com.runbardese.system.mapper.TblBarMapper;
import com.runbardese.system.service.ISysUserService;
import com.runbardese.system.service.PrintDataService;
import com.runbardese.system.service.TblBarService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/bds/api")
public class SysPrintDataTestController {
    //注入标签服务
    @Autowired
    PrintDataTestMapper printDataTestMapper;

    //注入request
    @Autowired
    HttpServletRequest request;

    //注入托盘服务
    @Autowired
    TblBarService tblBarService;

    @Autowired
    TblBarMapper tblBarMapper;

    //注入用户服务
    @Autowired
    private ISysUserService iSysUserService;

    //创建返回结果接受集合
    List<PrintData> list = new ArrayList<>();



    @ApiOperation("新增托盘信息")
    @PostMapping("/insertTblBarTest")
    public CodeMsg  insertTblBar(@RequestBody TblBar tblBar){
        //创建返回消息实体
        CodeMsg codeMsg = new CodeMsg();
        //获取托盘主表
        TblBarRelation tblBarRelation = tblBar.getTblBarRelation();

        //根据evidence_Number查询托盘主表数据
        String s = null;
        s = tblBarMapper.selectTblBarByEvidenceNum(tblBarRelation.getEvidence_Number());
        //判断该evidence_Number是否存在托盘主表数据库 不存在则插入数据
        if(StringUtils.isEmpty(s)){
            //新增托盘主表
            int n = tblBarService.insertTblBarRelation(tblBarRelation);
            //获取托盘细表列表
            List<TblBarRelationDetail> tblBarRelationDetailList = tblBar.getTblBarRelationDetailList();
            //遍历托盘细表
            for (TblBarRelationDetail tblBarRelationDetail: tblBarRelationDetailList) {
                //根据evidence_Number查询托盘细表数据
                String s1 = null;
                s1 = tblBarMapper.selectTblBarDetailByEvidenceNum(tblBarRelationDetail.getEvidence_Number(),tblBarRelationDetail.getNoid());
                //判断该evidence_Number是否存在托盘细表数据库 不存在则插入数据
                if(StringUtils.isEmpty(s1)) {
                    //新增托盘细表
                   int m = tblBarService.insertTblBarRelationDetail(tblBarRelationDetail);
                }else{
                    //细表失败信息
                    codeMsg.setCode(2);
                    codeMsg.setMsg("托盘细表编号已存在："+tblBarRelationDetail.getEvidence_Number());
                    return codeMsg;
                }
            }
        }else {
            //主表失败信息
            codeMsg.setCode(1);
            codeMsg.setMsg("托盘主表编号已存在："+tblBarRelation.getEvidence_Number());
            return codeMsg;
        }

        //成功信息
        codeMsg.setCode(0);
        codeMsg.setMsg("成功");
        return codeMsg;
    }

    /**
     * 根据批号查询打印标签信息
     * @param jarNo
     * @param username
     * @return
     */
    @ApiOperation("获取打印标签明细")
    @ApiImplicitParams({@ApiImplicitParam(name = "jarNo", value = "标签批号", required = true, dataType = "string", paramType = "path"),
            @ApiImplicitParam(name = "username", value = "请求姓名", required = true, dataType = "string", paramType = "query")})
    @GetMapping("/findByJarNoTest/{jarNo}")
    public PrintDataMsg selectPrintDataByJarNo(@PathVariable("jarNo") String jarNo, @RequestParam("username") String username){
        //新增返回码实体类
        CodeMsg codeMsg= new CodeMsg();
        //获取URL上用户姓名
        String name = request.getParameter("username");
        PrintDataMsg printDataMsg = new PrintDataMsg();
        System.out.println(request.getRequestURL()+"?"+request.getQueryString());
        try {
            //根据用户名获取用户信息
            SysUser user = iSysUserService.selectUserByLoginName(name);
            String uname = user.getLoginName();
        }catch (RuntimeException re){
            codeMsg.setCode(2);
            codeMsg.setMsg("用户名不存在请联系管理员！");
            printDataMsg.setCodeMsg(codeMsg);
            return printDataMsg;
        }
        //根据批号获取打印标签信息
        list = printDataTestMapper.selectPrintDataByJarNo(jarNo);
        //判断批号是否存在
        if(list.isEmpty()){
            codeMsg.setCode(1);
            codeMsg.setMsg("批号不存在");
            printDataMsg.setCodeMsg(codeMsg);
            return printDataMsg;
        }else {
            //返回标签信息
            codeMsg.setCode(0);
            codeMsg.setMsg("成功");
            printDataMsg.setCodeMsg(codeMsg);
            printDataMsg.setPrintData(printDataTestMapper.selectPrintDataByJarNo(jarNo));
            return printDataMsg;
        }
    }

    /**
     * 根据标签二维码更新已打印标签的数量
     * @param lastUpMan 操作着
     * @param qRCode 二维码
     * @param username
     * @return
     */
    @ApiOperation("更新已打印标签")
    @ApiImplicitParams({@ApiImplicitParam(name = "lastUpMan", value = "操作员", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "qRCode", value = "标签二维码", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "username", value = "请求姓名", required = true, dataType = "string", paramType = "query")})
    @PutMapping("/updateByQRCodeTest")
    public Object updatePrintDataByQRCode(@RequestParam("lastUpMan") String lastUpMan,@RequestParam("qRCode") String qRCode,@RequestParam("username") String username){
        //新增返回码实体类
        UpdateCodeMsg updateCodeMsg= new UpdateCodeMsg();
        CodeMsg codeMsg = new CodeMsg();
        //获取URL上用户姓名
        String name = request.getParameter("username");
        System.out.println(request.getRequestURL()+"?"+request.getQueryString());
        try {
            //根据用户名获取用户信息
            SysUser user = iSysUserService.selectUserByLoginName(name);
            String uname = user.getLoginName();
        }catch (RuntimeException re){
            codeMsg.setCode(2);
            codeMsg.setMsg("用户名不存在请联系管理员！");
            return codeMsg;
        }
        //根据批号获取打印标签信息
        int num = printDataTestMapper.updatePrintDataByQRCode(lastUpMan,new Date(System.currentTimeMillis()),qRCode);
        list = printDataTestMapper.selectPrintDataByQRCode(qRCode);
        //判断二维码是否存在
        if(list.isEmpty()){
            updateCodeMsg.setqRCode(qRCode);
            updateCodeMsg.setCode(1);
            updateCodeMsg.setMsg("二维码不存在！");
            return updateCodeMsg;
        }else if (num<0){
            //返回标签信息
            updateCodeMsg.setCode(3);
            updateCodeMsg.setMsg("更新失败，请联系管理员！");
            updateCodeMsg.setqRCode(qRCode);
            return updateCodeMsg;
        }else{
            updateCodeMsg.setqRCode(qRCode);
            updateCodeMsg.setCode(0);
            updateCodeMsg.setMsg("成功");
            updateCodeMsg.setUpdate(num);
            return updateCodeMsg;
        }
    }



}
