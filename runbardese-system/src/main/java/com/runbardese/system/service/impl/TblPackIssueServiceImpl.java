package com.runbardese.system.service.impl;

import com.runbardese.system.domain.TblPreSplit;
import com.runbardese.system.mapper.TblPackIssueMapper;
import com.runbardese.system.service.TblPackIssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Tao
 * @Date 2020/7/21
 * @Time 9:52
 */
@Service
public class TblPackIssueServiceImpl implements TblPackIssueService {

    @Autowired
    private TblPackIssueMapper tblPackIssueMapper;

    @Override
    public List<TblPreSplit> getEvidenceByJarNo(String jarNo) {
        return tblPackIssueMapper.getEvidenceByJarNo(jarNo);
    }
}
