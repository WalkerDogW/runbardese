package com.runbardese.web.controller.system;

import com.runbardese.system.domain.*;
import com.runbardese.system.mapper.PLCMapper;
import com.runbardese.system.service.ISysUserService;
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
public class PLCController {
    @Autowired
    private PLCMapper plcMapper;


    //注入用户服务
    @Autowired
    private ISysUserService iSysUserService;

    //注入request
    @Autowired
    HttpServletRequest request;

    @GetMapping(value = {"/selectMaterialIssue/{NO}","/plc/selectMaterialIssue/{NO}"})
    public MaterialIssueMsg selectMaterialIssue(@PathVariable("NO") String NO,@RequestParam("username") String username){
        MaterialIssueMsg materialIssueMsg = new MaterialIssueMsg();
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
            materialIssueMsg.setCodeMsg(codeMsg);
            return materialIssueMsg;
        }



        MaterialIssue materialIssue = plcMapper.selectMaterialIssue(NO);
        if(materialIssue == null){
            codeMsg.setMsg("计划编号不存在");
            codeMsg.setCode(1);
            materialIssueMsg.setCodeMsg(codeMsg);
            return materialIssueMsg;
        }else {
            codeMsg.setMsg("成功");
            codeMsg.setCode(0);
        }

        List<MaterialIssueDetail> materialIssueDetail = plcMapper.selectMaterialIssueDetail(NO);
        materialIssueMsg.setCodeMsg(codeMsg);
        materialIssueMsg.setMaterialIssue(materialIssue);
        materialIssueMsg.setMaterialIssueDetails(materialIssueDetail);
        return materialIssueMsg;
    }






    @PostMapping(value = {"/insertProject","/plc/insertProject"})
    public CodeMsg  insertTblBar(@RequestBody InventoryEvidenceMsg inventoryEvidenceMsg){
        CodeMsg codeMsg = new CodeMsg();

        String name = inventoryEvidenceMsg.getUsername();
        SysUser user = iSysUserService.selectUserByLoginName(name);
        if(user == null){
            codeMsg.setCode(2);
            codeMsg.setMsg("用户不存在");
            return codeMsg;
        }

        String inventoryEvidenceNumber = inventoryEvidenceMsg.getInventoryEvidence().getEvidence_Number();
        InventoryEvidence inventoryEvidence = plcMapper.selectInventoryEvidence(inventoryEvidenceNumber);
        if(inventoryEvidence != null){
            codeMsg.setCode(1);
            codeMsg.setMsg("单号已存在: "+inventoryEvidenceNumber);
            return codeMsg;
        }else{
            int ins = plcMapper.insertInventoryEvidence(inventoryEvidenceMsg.getInventoryEvidence());
            for(InventoryEvidenceDetail inventoryEvidenceDetail : inventoryEvidenceMsg.getInventoryEvidenceDetails()){
            int insDetail =   plcMapper.insertInventoryEvidenceDetail(inventoryEvidenceDetail);
            }
            codeMsg.setCode(0);
            codeMsg.setMsg("成功");
            return codeMsg;
        }

    }





    @GetMapping(value = {"/selectInventoryEvidence/{NO}","/plc/selectInventoryEvidence/{NO}"})
    public InventoryEvidenceMsg selectMaterialIssue(@PathVariable("NO") String NO){
        InventoryEvidenceMsg inventoryEvidenceMsg = new InventoryEvidenceMsg();
        inventoryEvidenceMsg.setInventoryEvidence(plcMapper.selectInventoryEvidence(NO));
        inventoryEvidenceMsg.setInventoryEvidenceDetails(plcMapper.selectInventoryEvidenceDetail(NO));
        return inventoryEvidenceMsg;
    }


}
