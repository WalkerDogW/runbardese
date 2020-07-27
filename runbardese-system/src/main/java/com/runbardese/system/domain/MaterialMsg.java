package com.runbardese.system.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Tao
 * @Date 2020/7/18
 * @Time 14:31
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaterialMsg {
    private String state;
    private String message;
    private String data;
}
