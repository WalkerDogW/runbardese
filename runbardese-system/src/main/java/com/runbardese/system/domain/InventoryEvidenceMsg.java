package com.runbardese.system.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Tao
 * @Date 2020/7/25
 * @Time 14:53
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryEvidenceMsg {
    private String username;
    private InventoryEvidence inventoryEvidence;
    private List<InventoryEvidenceDetail> inventoryEvidenceDetails;
}
