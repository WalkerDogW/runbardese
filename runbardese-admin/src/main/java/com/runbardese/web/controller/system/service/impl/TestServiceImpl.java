package com.runbardese.web.controller.system.service.impl;

import com.runbardese.system.domain.TblLabelPrintReportData;
import com.runbardese.web.controller.system.mapper.TestMapper;
import com.runbardese.web.controller.system.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl  implements TestService {

    @Autowired
    TestMapper mapper;




    @Override
    public List<TblLabelPrintReportData> findByDuDate(String s) {
        return mapper.findByDuDate(s);


    }
}
