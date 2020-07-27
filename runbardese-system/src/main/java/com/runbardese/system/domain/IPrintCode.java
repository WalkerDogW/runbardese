package com.runbardese.system.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "IPrintCode")
public class IPrintCode {
    private String orderId;
    private String admCode;
    private String projectBatch;
    private String inventory_ID;
    private String inventoryName;
    private int printS;
    private String qrcode;
    private String username;

    public IPrintCode(String orderId, String admCode, String projectBatch, String inventory_ID, String inventoryName, int printS, String qrcode, String username) {
        this.orderId = orderId;
        this.admCode = admCode;
        this.projectBatch = projectBatch;
        this.inventory_ID = inventory_ID;
        this.inventoryName = inventoryName;
        this.printS = printS;
        this.qrcode = qrcode;
        this.username = username;
    }

    public IPrintCode() {
    }

    public IPrintCode(String orderId, String admCode, String projectBatch, String inventory_ID, String inventoryName, int printS, String qrcode) {
        this.orderId = orderId;
        this.admCode = admCode;
        this.projectBatch = projectBatch;
        this.inventory_ID = inventory_ID;
        this.inventoryName = inventoryName;
        this.printS = printS;
        this.qrcode = qrcode;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getAdmCode() {
        return admCode;
    }

    public void setAdmCode(String admCode) {
        this.admCode = admCode;
    }

    public String getProjectBatch() {
        return projectBatch;
    }

    public void setProjectBatch(String projectBatch) {
        this.projectBatch = projectBatch;
    }

    public String getInventory_ID() {
        return inventory_ID;
    }

    public void setInventory_ID(String inventory_ID) {
        this.inventory_ID = inventory_ID;
    }

    public String getInventoryName() {
        return inventoryName;
    }

    public void setInventoryName(String inventoryName) {
        this.inventoryName = inventoryName;
    }

    public int getPrintS() {
        return printS;
    }

    public void setPrintS(int printS) {
        this.printS = printS;
    }

    public String getqrcode() {
        return qrcode;
    }

    public void setQRcode(String qrcode) {
        this.qrcode = qrcode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "IPrintCode{" +
                "orderId='" + orderId + '\'' +
                ", admCode='" + admCode + '\'' +
                ", projectBatch='" + projectBatch + '\'' +
                ", inventory_ID='" + inventory_ID + '\'' +
                ", inventoryName='" + inventoryName + '\'' +
                ", printS=" + printS +
                ", QRcode='" + qrcode + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
