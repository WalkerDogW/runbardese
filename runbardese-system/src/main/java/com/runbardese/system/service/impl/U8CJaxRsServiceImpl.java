package com.runbardese.system.service.impl;

import com.runbardese.system.domain.voucher.*;
import com.runbardese.system.mapper.U8CMapper;
import com.runbardese.system.service.U8CJaxRsService;
import org.springframework.beans.factory.annotation.Autowired;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;


@Path("/")
public class U8CJaxRsServiceImpl implements U8CJaxRsService {
    @Autowired
    private U8CMapper u8CMapper;

    public static String pzh;

    private Integer maxCode = 1;
    /**
     * 获取凭证号
     *
     * @return
     */
    @Override
    @GET
    @Path("/getNcXml")
    @Produces({MediaType.APPLICATION_XML})
    public Ufinterface selectUfinterface() {

        //创建ufinterface实体类
        Ufinterface ufinterface = new Ufinterface();
        //获取voucher头实体
        Voucher_head voucherhead = u8CMapper.selectHead();

        //赋值凭证号
        pzh=voucherhead.getVoucher_id();

        //创建voucher实体类
        Voucher voucher = new Voucher();
        //创建voucher身体实体类
        Voucher_body voucher_body = new Voucher_body();
        //创建entry集合
        List<Entry> entryList = new ArrayList<>();

        System.out.println(voucherhead.getVoucher_type());

        //设置公司编码
        voucherhead.setCompany("A1202");
        //转换凭证月份
        if(voucherhead.getAccounting_period().length()<2) {
            voucherhead.setAccounting_period("0"+voucherhead.getAccounting_period());
        }
        //设置附件初始值
        voucherhead.setAttachment_number(0);
        //设置系统来源
        voucherhead.setVoucher_making_system("U8GL");

        //转化凭证类别
        if("AP".equals(voucherhead.getVoucher_type()) || "ARR".equals(voucherhead.getVoucher_type())) {
            voucherhead.setVoucher_type("银付凭证");
        }else if("AR".equals(voucherhead.getVoucher_type())){
            voucherhead.setVoucher_type("银收凭证");
        }else{
            voucherhead.setVoucher_type("转账凭证");
        }


        //设值折算来源凭证
        voucherhead.setPk_sourcepk(voucherhead.getCompany()+"-" + voucherhead.getFiscal_year() +voucherhead.getAccounting_period() + voucherhead.getVoucher_type() +
                "-" + voucherhead.getVoucher_id());

        //设置操作账号
        voucherhead.setEnter("demo1");

        //打印evidence_number
        System.out.println(voucherhead.getEvidence_number() + "==============================");

        int id = 1;
        //获取entry数据集
        entryList = u8CMapper.selectEntryList(voucherhead.getVoucher_id(),voucherhead.getFiscal_year(),Integer.valueOf(voucherhead.getAccounting_period()));
        //遍历
        for (Entry entry : entryList) {
            entry.setEntry_id(id);
            //entry.setAccount_code("1131");
            System.out.println(entry.getFdc() + "============" + entry.getEntry_id());
            entry.setPrimary_credit_amount("0");
            entry.setPrimary_debit_amount("0.0000");
            entry.setNatural_credit_currency("0");
            entry.setCurrency("人民币");
            if (entry.getFdc() == - 1) {
                entry.setNatural_credit_currency(entry.getNatural_debit_currency());
                entry.setNatural_debit_currency("0.0000");
            }

            //U8C获取会计科目主键
            String accCode = u8CMapper.selectVoucherPrimary(entry.getAccount_code());
            //U8C获取会计科目所需的辅助核算名称列表
            List<String> list = u8CMapper.selectVoucherSubjass(accCode);

            //定义辅助项目集合
            List<Item> items = new ArrayList<>();
            //遍历
            for (String name:list) {
                //创建部门档案实体类
                Item item = new Item();
                if ("部门档案".equals(name)) {
                    //插入部门档案
                    item.setName("部门档案");
                    //item.setValue(entry.getDeptId());
                    item.setValue("A120206");
                    items.add(item);
                }else if("客商辅助核算".equals(name)) {
                    if (!(entry.getFdwdm().isEmpty())) {
                        Item item2 = new Item();
                        item2.setName("客商辅助核算");
                        item2.setValue(entry.getFdwdm());
                        items.add(item2);
                    }
                }else if("现金流量项目".equals(name)) {
                    //插入现金流项目
                    CashItem cashItem = u8CMapper.selectCashCode(voucherhead.getFiscal_year(), Integer.valueOf(voucherhead.getAccounting_period()), voucherhead.getVoucher_id(), entry.getAccount_code());
                    if (!(cashItem.getCashCode().isEmpty())) {
                        Item item3 = new Item();
                        item3.setName("现金流量项目");
                        item3.setValue(cashItem.getCashCode());
                        items.add(item3);
                    }
                }
            }

            //添加辅助项目至凭证分录体
            entry.setItem(items);
            id++;
        }

        //获取U8C最大凭证号
        if((u8CMapper.selectVoucherMaxCode(voucherhead.getFiscal_year(),Integer.valueOf(voucherhead.getAccounting_period()),voucherhead.getVoucher_type())) !=null) {
            maxCode = u8CMapper.selectVoucherMaxCode(voucherhead.getFiscal_year(),Integer.valueOf(voucherhead.getAccounting_period()),voucherhead.getVoucher_type());
            maxCode = maxCode + 1;
        }
        //重新赋值凭证号
        voucherhead.setVoucher_id(maxCode+"");

        voucher_body.setEntry(entryList);
        voucher.setId(voucherhead.getFiscal_year()+"-"+voucherhead.getAccounting_period()+"-"+voucherhead.getCompany()+voucherhead.getVoucher_type()+"-"+voucherhead.getVoucher_id());
        voucher.setVoucher_body(voucher_body);
        voucher.setVoucher_head(voucherhead);
        ufinterface.setAccount("U8cloud");
        ufinterface.setVoucher(voucher);

        return ufinterface;
    }


    /**
     * 获取客商档案
     *
     * @return
     */
    @Override
    @GET
    @Path("/getU8CTBXml")
    @Produces({MediaType.APPLICATION_XML})
    public UfinterfaceCTB selectUfinterfaceCTB() {

        UfinterfaceCTB ufinterfaceCTB = new UfinterfaceCTB();
        Basdoc basdoc = new Basdoc();
        Basdoc_head basdoc_head = new Basdoc_head();

        basdoc.setBasdoc_head(basdoc_head);
        ufinterfaceCTB.setBasdoc(basdoc);
        return ufinterfaceCTB;
    }


}
