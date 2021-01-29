package com.runbardese.web.controller.system;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Tao
 * @Date 2020/12/22
 * @Time 8:04
 */
@Controller
@RequestMapping("/bds/api/qrcode")
public class QRCodeController {
    @GetMapping(value = {"/fixed/{id}"})
    public String getFixedCapital(@PathVariable("id") String id, Model model){
        model.addAttribute("MSG","hello Thymeleaf！");
        return "qrcode/fixedCapital";
    }

}
