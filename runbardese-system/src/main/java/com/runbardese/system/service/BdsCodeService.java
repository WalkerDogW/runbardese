package com.runbardese.system.service;

import com.runbardese.system.domain.CodeData;

import java.util.List;

public interface BdsCodeService {
    //查询所有防伪码
    public List<CodeData> selectBDSAll(String printCode);
}
