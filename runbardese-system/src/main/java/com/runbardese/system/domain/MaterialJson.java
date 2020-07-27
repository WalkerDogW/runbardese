package com.runbardese.system.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author Tao
 * @Date 2020/7/18
 * @Time 14:24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaterialJson {
    @NotNull
    private String BatchNo;
    @NotNull
    private String Name;
    @NotNull
    private String Version;
    @NotNull
    private String NetWeight;
    @NotNull
    private Date ProductionDate;
    @NotNull
    private String ExecutiveStandard1;
    @NotNull
    private String ExecutiveStandard2;
    @NotNull
    private String CCCMark;
    @NotNull
    private String CCCMarkCode;
    @NotNull
    private String MainMaterial;
    @NotNull
    private String MaterialRatio;
    @NotNull
    private String Certificate;
    @NotNull
    private String ShelfLife;
    @NotNull
    private String Level;
    @NotNull
    private String Logo;
    @NotNull
    private String QRCode;
    @NotNull
    private String AdmCode;
    @NotNull
    private String QRId;
    @NotNull
    private String PackId;
    @NotNull
    private String CanCode;
    @NotNull
    private String BoxCode;
    @NotNull
    private String StockCode;
    @NotNull
    private String Code;
    @NotNull
    private String CustomerCode;

    private String binventory_ID;
}
