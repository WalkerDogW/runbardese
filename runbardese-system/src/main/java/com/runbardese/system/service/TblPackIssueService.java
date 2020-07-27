package com.runbardese.system.service;

import com.runbardese.system.domain.TblPreSplit;

import java.util.List;

/**
 * @author Tao
 * @Date 2020/7/21
 * @Time 9:51
 */
public interface TblPackIssueService {
    /**
     *  预分垛数据接口
     * @return
     */
    public List<TblPreSplit> getEvidenceByJarNo(String jarNo);
}
