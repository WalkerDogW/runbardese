package com.runbardese.web.controller.system.service;

import com.runbardese.system.domain.TblLabelPrintReportData;

import java.util.List;

public interface TestService {

    List<TblLabelPrintReportData>findByDuDate(String s);
}
