package com.runbardese.system.domain.voucher;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = {"pk_cubasdoc","pk_corp","pk_areacl","pk_corp1","custcode","custname","custshortname","engname",
        "mnecode","trade","freecustflag","drpnodeflag","isconnflag","pk_cubasdoc1","custprop","custtype","taxpayerid",
        "legalbody","creditmny","ecotype","saleaddr","conaddr","zipcode","phone1","phone2","phone3","fax1","fax2","linkman1",
         "linkman2","linkman3","bp1","bp2","bp3","mobilephone1","mobilephone2","mobilephone3","email","url","registerfund","memo"})
public class Basdoc_head {
    //客商基本档案主键,20位，可为空，由外系统指定或U8 cloud系统自动生成,要保证唯一
    private String pk_cubasdoc="";
    //公司，不能为空，需要对照基础数据（公司目录），集团填写A01
    private String pk_corp = "A01";
    //地区分类,不能为空，需要对照基础数据（地区分类）
    private String pk_areacl = "中山建涂技术中心";
    //对应公司编码,可以为空，需要对照基础数据（公司目录）
    private String pk_corp1 = "A01";
    //客商编号，不能为空,不能重复
    private String custcode = "11423";
    //客商名称，不能为空,不能重复
    private String custname = "梁永添";
    //客商简称，不能为空,必须输入
    private String custshortname = "梁";
    //外文名称，可以为空
    private String engname;
    //助记码,可以为空
    private String mnecode;
    //所属行业,可以为空，需要对照基础数据（经济行业）
    private String trade;
    //是否散户(不能为空,必须填写Y/N)，默认N
    private String freecustflag = "N";
    //是否DRP结点(不能为空，必须填写Y/N），默认N
    private String drpnodeflag = "N";
    //是否渠道成员(不能为空，必须填写,Y/N），默认N
    private String isconnflag = "N";
    //客商总公司编码,可以为空，需要对照基础数据（客商基本档案）
    private String pk_cubasdoc1;
    //客商类型(不能为空，缺省为0, 0：外部单位 1：内部核算单位 2：内部法人单位 3：内部渠道成员)
    private String custprop = "0";
    //客商属性（只有“新增”时有效。不能为空，缺省为2，0：客户 1：供应商 2：客商）
    private String custtype = "2";
    //纳税人登记号，可以为空
    private String taxpayerid = "";
    //法人，可以为空
    private String legalbody = "";
    //信用额度, 可以为空
    private String creditmny = "";
    //经济类型，可以为空，需要对照基础数据（经济类型）
    private String ecotype = "";
    //营业地址，可以为空
    private String saleaddr = "";
    //通信地址，可以为空
    private String conaddr = "";
    //邮政编码，可以为空
    private String zipcode = "";
    //三个电话，可以为空
    private String phone1 = "";
    private String phone2 = "";
    private String phone3 = "";
    //两个传真，可以为空
    private String fax1 = "";
    private String fax2 = "";
    //三个联系人，可以为空
    private String linkman1 = "";
    private String linkman2 = "";
    private String linkman3 = "";
    //三个呼机，可以为空
    private String bp1 = "";
    private String bp2 = "";
    private String bp3 = "";
    //三个手机，可以为空
    private String mobilephone1 = "";
    private String mobilephone2 = "";
    private String mobilephone3 = "";
    //E-mail地址，可以为空
    private String email = "";
    //Web网址，可以为空
    private String url = "";
    //注册资金，可以为空
    private String registerfund = "";
    //备注，可以为空
    private String memo = "";

    public Basdoc_head() {
    }

    public Basdoc_head(String pk_cubasdoc, String pk_corp, String pk_areacl, String pk_corp1, String custcode, String custname, String custshortname, String engname, String mnecode, String trade, String freecustflag, String drpnodeflag, String isconnflag, String pk_cubasdoc1, String custprop, String custtype, String taxpayerid, String legalbody, String creditmny, String ecotype, String saleaddr, String conaddr, String zipcode, String phone1, String phone2, String phone3, String fax1, String fax2, String linkman1, String linkman2, String linkman3, String bp1, String bp2, String bp3, String mobilephone1, String mobilephone2, String mobilephone3, String email, String url, String registerfund, String memo) {
        this.pk_cubasdoc = pk_cubasdoc;
        this.pk_corp = pk_corp;
        this.pk_areacl = pk_areacl;
        this.pk_corp1 = pk_corp1;
        this.custcode = custcode;
        this.custname = custname;
        this.custshortname = custshortname;
        this.engname = engname;
        this.mnecode = mnecode;
        this.trade = trade;
        this.freecustflag = freecustflag;
        this.drpnodeflag = drpnodeflag;
        this.isconnflag = isconnflag;
        this.pk_cubasdoc1 = pk_cubasdoc1;
        this.custprop = custprop;
        this.custtype = custtype;
        this.taxpayerid = taxpayerid;
        this.legalbody = legalbody;
        this.creditmny = creditmny;
        this.ecotype = ecotype;
        this.saleaddr = saleaddr;
        this.conaddr = conaddr;
        this.zipcode = zipcode;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.phone3 = phone3;
        this.fax1 = fax1;
        this.fax2 = fax2;
        this.linkman1 = linkman1;
        this.linkman2 = linkman2;
        this.linkman3 = linkman3;
        this.bp1 = bp1;
        this.bp2 = bp2;
        this.bp3 = bp3;
        this.mobilephone1 = mobilephone1;
        this.mobilephone2 = mobilephone2;
        this.mobilephone3 = mobilephone3;
        this.email = email;
        this.url = url;
        this.registerfund = registerfund;
        this.memo = memo;
    }

    public String getPk_cubasdoc() {
        return pk_cubasdoc;
    }

    public void setPk_cubasdoc(String pk_cubasdoc) {
        this.pk_cubasdoc = pk_cubasdoc;
    }

    public String getPk_corp() {
        return pk_corp;
    }

    public void setPk_corp(String pk_corp) {
        this.pk_corp = pk_corp;
    }

    public String getPk_areacl() {
        return pk_areacl;
    }

    public void setPk_areacl(String pk_areacl) {
        this.pk_areacl = pk_areacl;
    }

    public String getPk_corp1() {
        return pk_corp1;
    }

    public void setPk_corp1(String pk_corp1) {
        this.pk_corp1 = pk_corp1;
    }

    public String getCustcode() {
        return custcode;
    }

    public void setCustcode(String custcode) {
        this.custcode = custcode;
    }

    public String getCustname() {
        return custname;
    }

    public void setCustname(String custname) {
        this.custname = custname;
    }

    public String getCustshortname() {
        return custshortname;
    }

    public void setCustshortname(String custshortname) {
        this.custshortname = custshortname;
    }

    public String getEngname() {
        return engname;
    }

    public void setEngname(String engname) {
        this.engname = engname;
    }

    public String getMnecode() {
        return mnecode;
    }

    public void setMnecode(String mnecode) {
        this.mnecode = mnecode;
    }

    public String getTrade() {
        return trade;
    }

    public void setTrade(String trade) {
        this.trade = trade;
    }

    public String getFreecustflag() {
        return freecustflag;
    }

    public void setFreecustflag(String freecustflag) {
        this.freecustflag = freecustflag;
    }

    public String getDrpnodeflag() {
        return drpnodeflag;
    }

    public void setDrpnodeflag(String drpnodeflag) {
        this.drpnodeflag = drpnodeflag;
    }

    public String getIsconnflag() {
        return isconnflag;
    }

    public void setIsconnflag(String isconnflag) {
        this.isconnflag = isconnflag;
    }

    public String getPk_cubasdoc1() {
        return pk_cubasdoc1;
    }

    public void setPk_cubasdoc1(String pk_cubasdoc1) {
        this.pk_cubasdoc1 = pk_cubasdoc1;
    }

    public String getCustprop() {
        return custprop;
    }

    public void setCustprop(String custprop) {
        this.custprop = custprop;
    }

    public String getCusttype() {
        return custtype;
    }

    public void setCusttype(String custtype) {
        this.custtype = custtype;
    }

    public String getTaxpayerid() {
        return taxpayerid;
    }

    public void setTaxpayerid(String taxpayerid) {
        this.taxpayerid = taxpayerid;
    }

    public String getLegalbody() {
        return legalbody;
    }

    public void setLegalbody(String legalbody) {
        this.legalbody = legalbody;
    }

    public String getCreditmny() {
        return creditmny;
    }

    public void setCreditmny(String creditmny) {
        this.creditmny = creditmny;
    }

    public String getEcotype() {
        return ecotype;
    }

    public void setEcotype(String ecotype) {
        this.ecotype = ecotype;
    }

    public String getSaleaddr() {
        return saleaddr;
    }

    public void setSaleaddr(String saleaddr) {
        this.saleaddr = saleaddr;
    }

    public String getConaddr() {
        return conaddr;
    }

    public void setConaddr(String conaddr) {
        this.conaddr = conaddr;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getPhone3() {
        return phone3;
    }

    public void setPhone3(String phone3) {
        this.phone3 = phone3;
    }

    public String getFax1() {
        return fax1;
    }

    public void setFax1(String fax1) {
        this.fax1 = fax1;
    }

    public String getFax2() {
        return fax2;
    }

    public void setFax2(String fax2) {
        this.fax2 = fax2;
    }

    public String getLinkman1() {
        return linkman1;
    }

    public void setLinkman1(String linkman1) {
        this.linkman1 = linkman1;
    }

    public String getLinkman2() {
        return linkman2;
    }

    public void setLinkman2(String linkman2) {
        this.linkman2 = linkman2;
    }

    public String getLinkman3() {
        return linkman3;
    }

    public void setLinkman3(String linkman3) {
        this.linkman3 = linkman3;
    }

    public String getBp1() {
        return bp1;
    }

    public void setBp1(String bp1) {
        this.bp1 = bp1;
    }

    public String getBp2() {
        return bp2;
    }

    public void setBp2(String bp2) {
        this.bp2 = bp2;
    }

    public String getBp3() {
        return bp3;
    }

    public void setBp3(String bp3) {
        this.bp3 = bp3;
    }

    public String getMobilephone1() {
        return mobilephone1;
    }

    public void setMobilephone1(String mobilephone1) {
        this.mobilephone1 = mobilephone1;
    }

    public String getMobilephone2() {
        return mobilephone2;
    }

    public void setMobilephone2(String mobilephone2) {
        this.mobilephone2 = mobilephone2;
    }

    public String getMobilephone3() {
        return mobilephone3;
    }

    public void setMobilephone3(String mobilephone3) {
        this.mobilephone3 = mobilephone3;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRegisterfund() {
        return registerfund;
    }

    public void setRegisterfund(String registerfund) {
        this.registerfund = registerfund;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    @Override
    public String toString() {
        return "Basdoc_head{" +
                "pk_cubasdoc='" + pk_cubasdoc + '\'' +
                ", pk_corp='" + pk_corp + '\'' +
                ", pk_areacl='" + pk_areacl + '\'' +
                ", pk_corp1='" + pk_corp1 + '\'' +
                ", custcode='" + custcode + '\'' +
                ", custname='" + custname + '\'' +
                ", custshortname='" + custshortname + '\'' +
                ", engname='" + engname + '\'' +
                ", mnecode='" + mnecode + '\'' +
                ", trade='" + trade + '\'' +
                ", freecustflag='" + freecustflag + '\'' +
                ", drpnodeflag='" + drpnodeflag + '\'' +
                ", isconnflag='" + isconnflag + '\'' +
                ", pk_cubasdoc1='" + pk_cubasdoc1 + '\'' +
                ", custprop='" + custprop + '\'' +
                ", custtype='" + custtype + '\'' +
                ", taxpayerid='" + taxpayerid + '\'' +
                ", legalbody='" + legalbody + '\'' +
                ", creditmny='" + creditmny + '\'' +
                ", ecotype='" + ecotype + '\'' +
                ", saleaddr='" + saleaddr + '\'' +
                ", conaddr='" + conaddr + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", phone1='" + phone1 + '\'' +
                ", phone2='" + phone2 + '\'' +
                ", phone3='" + phone3 + '\'' +
                ", fax1='" + fax1 + '\'' +
                ", fax2='" + fax2 + '\'' +
                ", linkman1='" + linkman1 + '\'' +
                ", linkman2='" + linkman2 + '\'' +
                ", linkman3='" + linkman3 + '\'' +
                ", bp1='" + bp1 + '\'' +
                ", bp2='" + bp2 + '\'' +
                ", bp3='" + bp3 + '\'' +
                ", mobilephone1='" + mobilephone1 + '\'' +
                ", mobilephone2='" + mobilephone2 + '\'' +
                ", mobilephone3='" + mobilephone3 + '\'' +
                ", email='" + email + '\'' +
                ", url='" + url + '\'' +
                ", registerfund='" + registerfund + '\'' +
                ", memo='" + memo + '\'' +
                '}';
    }
}
