package com.runbardese.system.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author Tao
 * @Date 2020/7/18
 * @Time 14:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Materials {
    @NotNull
    private String signcode;
    @NotNull
    private List<MaterialJson> MaterialJson;
}
