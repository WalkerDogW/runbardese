//package com.runbardese.web.controller.system;
//
//import com.runbardese.system.domain.CodeMsg;
//import com.runbardese.system.domain.PrintCode;
//import com.runbardese.system.domain.SysUser;
//import com.runbardese.system.mapper.PrintCodeMapper;
//import com.runbardese.system.service.BdsCodeService;
//import com.runbardese.system.service.ISysUserService;
//import com.runbardese.system.service.UpdatePrintCodeService;
//import com.runbardese.system.service.WsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * 防伪码获取
// */
//@RestController
//@RequestMapping("/bds/api")
//public class BdsCodeController {
//
//    @Autowired
//    private BdsCodeService codeService;
//
//    @Autowired
//    private WsService wsService;
//
//    @Autowired
//    private UpdatePrintCodeService updatePrintCodeService;
//
//    @Autowired
//    private PrintCodeMapper printCodeMapper;
//
//    @Autowired
//    private HttpServletRequest request;
//
//    private SysUser user;
//
//    @Autowired
//    private ISysUserService iSysUserService;
//
//
//    @Produces({MediaType.APPLICATION_JSON + "charset='utf-8'"})
//    @GetMapping(value = "/wslist")
//    public List<PrintCode> selectWSCode(@RequestParam("orderId") String orderId) {
//        return wsService.getSelectAll(orderId);
//    }
//
//    @Produces({MediaType.APPLICATION_JSON + "charset='utf-8'"})
//    @RequestMapping(value = "/update", method = RequestMethod.POST)
//    public CodeMsg updateCode(@RequestParam("orderId") String orderId) {
//        return wsService.updateCode(orderId);
//    }
//
//    /**
//     * 根据订单编号修改标签打印状态
//     *
//     * @param orderId
//     * @param username
//     * @return
//     * @throws Exception
//     */
//    @RequestMapping(value = "/updateCode/{orderId}", method = RequestMethod.POST)
//    public CodeMsg updateCodeApi(@PathVariable("orderId") String orderId, @RequestParam("username") String username) {
//        CodeMsg codeMsg = new CodeMsg();
//        String name = request.getParameter("username");
//
//        List list = new ArrayList();
//        try {
//            user = iSysUserService.selectUserByLoginName(name);
//            System.out.println("name=" + user.getLoginName());
//            String uname = user.getUserName();
//
//        }catch (Exception e) {
//            codeMsg.setCode(5);
//            codeMsg.setMsg("用户不存在！请联系管理员分配用户");
//            return codeMsg;
//        }
//
//            list = printCodeMapper.selectCode(orderId);
//            if ((list.isEmpty())) {
//                codeMsg.setCode(2);
//                codeMsg.setMsg("订单不存在");
//                return codeMsg;
//
//            } else if (printCodeMapper.selectOrderId(orderId).isEmpty()) {
//                codeMsg.setCode(3);
//                codeMsg.setMsg("该订单已打印回传");
//                return codeMsg;
//            }
//
//         return updatePrintCodeService.updateCode(orderId);
//    }
//
//}
