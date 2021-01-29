package com.runbardese.web.controller.system;

import com.runbardese.system.domain.*;
import com.runbardese.system.mapper.MesMapper;
import com.runbardese.system.mapper.PLCMapper;
import com.runbardese.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Tao
 * @Date 2020/7/30
 * @Time 15:35
 */
@RestController
@RequestMapping("/bds/api/mes")
public class MesController {
    @Autowired
    private MesMapper mesMapper;


    //注入用户服务
    @Autowired
    private ISysUserService iSysUserService;

    //注入request
    @Autowired
    HttpServletRequest request;
/*

    */
/**
     * 根据日期去查 TblLabelPrintReportData
     * @param DuDate
     * @return
     *//*

    @GetMapping("/selectTblLabelPrintReportData{DuDate}")
    public List findByDate(@PathVariable("DuDate") String DuDate ){

      return new list  =   TblLabelPrintReportDataService.findByDuDate(DuDate);

    }
*/


    @GetMapping("/selectProductExecution/{BatchNo}")
    public ProductExecutionMsg selectProductExecution(@PathVariable("BatchNo")String BatchNo) {
        ProductExecutionMsg productExecutionMsg = new ProductExecutionMsg();
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
            productExecutionMsg.setCodeMsg(codeMsg);
            return productExecutionMsg;
        }

        //Tblproductexecution productExecutionList = mesMapper.selectTblproductexecution(BatchNo);
        Tblproductexecution tblproductexecution = mesMapper.selectTblproductexecution(BatchNo);

        if(tblproductexecution==null){
            codeMsg.setMsg("编号不存在");
            codeMsg.setCode(1);
            productExecutionMsg.setCodeMsg(codeMsg);
        }
        else {
            codeMsg.setMsg("成功");
            codeMsg.setCode(0);
            productExecutionMsg.setCodeMsg(codeMsg);

            List<Tblproductexecution_detail> tblproductexecution_detailList = mesMapper.selectTblproductexecution_detail(BatchNo);

            productExecutionMsg.setProductexecution(tblproductexecution);
            productExecutionMsg.setProductexecution_detail(tblproductexecution_detailList);
        }
        return productExecutionMsg;
    }






    @GetMapping("/selectERPProd/{ProdId}")
    public ERPProdMsg selectERPProd(@PathVariable("ProdId")String ProdId){
        ERPProdMsg erpProdMsg = new ERPProdMsg();
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
            erpProdMsg.setCodeMsg(codeMsg);
            return erpProdMsg;
        }

        ERPProd erpProd = mesMapper.selectERPProd(ProdId);
        if(erpProd == null){
            codeMsg.setMsg("计划编号不存在");
            codeMsg.setCode(1);
            erpProdMsg.setCodeMsg(codeMsg);
            return erpProdMsg;
        }else {
            codeMsg.setMsg("成功");
            codeMsg.setCode(0);
            erpProdMsg.setCodeMsg(codeMsg);
        }

        List<ERPProdBom> erpProdBoms = mesMapper.selectERPProdBom(ProdId);
        erpProdMsg.setErpProd(erpProd);
        erpProdMsg.setErpProdBoms(erpProdBoms);
        return erpProdMsg;
    }


    @PostMapping("/insertErpProd")
    public CodeMsg  insertTblBar(@RequestBody ERPProdMsgIn erpProdMsgIn){
        CodeMsg codeMsg = new CodeMsg();

        String name = erpProdMsgIn.getUsername();
        SysUser user = iSysUserService.selectUserByLoginName(name);
        if(user == null){
            codeMsg.setCode(2);
            codeMsg.setMsg("用户不存在");
            return codeMsg;
        }

        String ErpProdId = erpProdMsgIn.getErpProd().getProdId();
        ERPProd erpProd = mesMapper.selectERPProd(ErpProdId);
        if(erpProd != null){
            codeMsg.setCode(1);
            codeMsg.setMsg("单号已存在: "+ErpProdId);
            return codeMsg;
        }else{
            int ins = mesMapper.insertERPProd(erpProdMsgIn.getErpProd());
            for(ERPProdBom erpProdBom : erpProdMsgIn.getErpProdBoms()){
                int insDetail = mesMapper.insertERPProdBOM(erpProdBom);
            }
            codeMsg.setCode(0);
            codeMsg.setMsg("成功");
            return codeMsg;
        }

    }

}
