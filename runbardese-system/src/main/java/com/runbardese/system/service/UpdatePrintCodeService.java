package com.runbardese.system.service;

import com.runbardese.system.domain.CodeMsg;
import org.springframework.stereotype.Service;

@Service
public interface UpdatePrintCodeService {

    public CodeMsg updateCode(String orderId);
}
