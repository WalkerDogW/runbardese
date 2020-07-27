package com.runbardese.system.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Tao
 * @Date 2020/7/21
 * @Time 15:11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TblTraceMsg {
    private List<String> qRCodes;
}
