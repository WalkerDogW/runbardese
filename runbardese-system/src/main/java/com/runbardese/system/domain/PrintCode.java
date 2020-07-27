package com.runbardese.system.domain;


import javax.xml.bind.annotation.XmlRootElement;

/**
 * 标签码
 */

@XmlRootElement(name = "PrintCode")
public class PrintCode {

    private String orderId;
    private String admCode;
    private String projectBatch;
    private String inventory_ID;
    private String inventoryName;
    private int printS;
    private String qRcode;
    private String username;

    public PrintCode(String orderId, String admCode, String projectBatch, String inventory_ID, String inventoryName, int printS, String qRcode, String username) {
        this.orderId = orderId;
        this.admCode = admCode;
        this.projectBatch = projectBatch;
        this.inventory_ID = inventory_ID;
        this.inventoryName = inventoryName;
        this.printS = printS;
        this.qRcode = qRcode;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public PrintCode() {
    }

    public PrintCode(String orderId, String admCode, String projectBatch, String inventory_ID, String inventoryName, int printS, String qRcode) {
        this.orderId = orderId;
        this.admCode = admCode;
        this.projectBatch = projectBatch;
        this.inventory_ID = inventory_ID;
        this.inventoryName = inventoryName;
        this.printS = printS;
        this.qRcode = qRcode;
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

    public String getqRcode() {
        return qRcode;
    }

    public void setqRcode(String qRcode) {
        this.qRcode = qRcode;
    }

    @Override
    public String toString() {
        return "PrintCode{" +
                "orderId='" + orderId + '\'' +
                ", admCode='" + admCode + '\'' +
                ", projectBatch='" + projectBatch + '\'' +
                ", inventory_ID='" + inventory_ID + '\'' +
                ", inventoryName='" + inventoryName + '\'' +
                ", printS=" + printS +
                ", qRcode='" + qRcode + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
