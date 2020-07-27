package com.runbardese.system.service.impl;

import com.runbardese.common.annotation.DataSource;
import com.runbardese.common.enums.DataSourceType;
import com.runbardese.system.domain.CodeData;
import com.runbardese.system.mapper.BdsCodeMapper;
import com.runbardese.system.service.BdsCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@DataSource(value = DataSourceType.SLAVE)
public class BdsServiceImpl implements BdsCodeService {

    @Autowired
    private BdsCodeMapper bdsCodeMapper;

    @Override
    public List<CodeData> selectBDSAll(String printCode) {
        return bdsCodeMapper.selectBDSAll(printCode);
    }
}
