//package com.runbardese.system.domain.voucher;
//
//import javax.xml.bind.annotation.XmlAttribute;
//import javax.xml.bind.annotation.XmlRootElement;
//
///**
// * 辅助核算类
// */
//@XmlRootElement
//public class Auxiliary_accounting {
//    //部门档案号
//    private Item item;
//
//    //客商管理档案
//    @XmlAttribute(name = "item")
//    private ItemCTB itemCTB;
//
//    public ItemCTB getItemCTB() {
//        return itemCTB;
//    }
//
//    public Auxiliary_accounting(Item item, ItemCTB itemCTB) {
//        this.item = item;
//        this.itemCTB = itemCTB;
//    }
//
//    public void setItemCTB(ItemCTB itemCTB) {
//        this.itemCTB = itemCTB;
//    }
//
//    public Auxiliary_accounting() {
//    }
//
//    public Auxiliary_accounting(Item item) {
//        this.item = item;
//    }
//
//    public Item getItem() {
//        return item;
//    }
//
//    public void setItem(Item item) {
//        this.item = item;
//    }
//
//    @Override
//    public String toString() {
//        return "Auxiliary_accounting{" +
//                "item=" + item +
//                ", itemCTB=" + itemCTB +
//                '}';
//    }
//}
