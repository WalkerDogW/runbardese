package com.runbardese.system.mapper;

import com.runbardese.common.annotation.DataSource;
import com.runbardese.common.enums.DataSourceType;
import com.runbardese.system.domain.voucher.*;
import org.apache.ibatis.annotations.*;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;

import java.util.Date;
import java.util.List;

public interface U8CMapper {

    //获取凭证主表
    @DataSource(value = DataSourceType.SLAVE2)
    public Voucher_head selectHead();

    //获取凭证细表
    @DataSource(value = DataSourceType.SLAVE2)
    public List<Entry> selectEntryList(@Param("Fpzh") String Fpzh,@Param("FYear") int FYear,@Param("Fmonth") int Fmonth);

    //反写错误凭证
    @DataSource(value = DataSourceType.SLAVE2)
    @Update("update tblVoucherMain set UpStatus = 2 ,UpDtTime=#{UpDtTime} where Fpzh = #{Fpzh} and FYear=#{FYear} and Fmonth = #{Fmonth}")
    public int updateUpErroStatus(@Param("Fpzh") String Fpzh,@Param("FYear") int FYear,@Param("Fmonth") int Fmonth ,@Param("UpDtTime") Date UpDtTime);

    //反写成功凭证
    @DataSource(value = DataSourceType.SLAVE2)
    @Update("update tblVoucherMain set UpStatus = 1 ,UpDtTime=#{UpDtTime} where Fpzh = #{Fpzh} and FYear=#{FYear} and Fmonth = #{Fmonth}")
    public int updateUpSuccStatus(@Param("Fpzh") String Fpzh,@Param("FYear") int FYear,@Param("Fmonth") int Fmonth ,@Param("UpDtTime") Date UpDtTime);

    //查询现金流量项目
    @DataSource(value = DataSourceType.SLAVE2)
    @Select("select t1.FYear,t1.Fmonth,t1.Fpzh,t1.Evidence_Number as EvidenceNumber,t2.Fkmbh,t2.Fzy,t2.fje,t2.Fdc,t2.fbmdm,t2.Fdwdm,t2.DeptID, case \n" +
            "when t1.FTranType='AP' then '银付凭证'\n" +
            " when t1.FTranType='APJ' then '转账凭证'\n" +
            "  when t1.FTranType='AR' then '银收凭证'\n" +
            "   when t1.FTranType='ARJ' then '转账凭证'\n" +
            "    when t1.FTranType='ARR' then '银付凭证'\n" +
            "     when t1.FTranType='FGO' then '转账凭证'\n" +
            "      when t1.FTranType='FGR' then '转账凭证'\n" +
            "       when t1.FTranType='HYAP' then '转账凭证'\n" +
            "        when t1.FTranType='HYAR' then '转账凭证'\n" +
            "         when t1.FTranType='MRI' then '转账凭证'\n" +
            "          when t1.FTranType='MFI' then '转账凭证'\n" +
            "           when t1.FTranType='42' then '转账凭证'\n" +
            "            when t1.FTranType='MFR' then '转账凭证'\n" +
            "             when t1.FTranType='MRR' then '转账凭证'\n" +
            "     end U8Code,\n" +
            "          case\n" +
            "when t1.FTranType='AP' and t3.FBank='1' then '1124'\n" +
            " when t1.FTranType='APJ' and t3.FBank='1' then '1124'\n" +
            "  when t1.FTranType='AR' and t3.FBank='1' then '1111'\n" +
            "   when t1.FTranType='ARR' and t3.FBank='1' then '1111'\n" +
            "    else '' end cashCode\n" +
            "   from dbo.tblVoucherMain t1 \n" +
            "inner join dbo.tblVoucherDetail t2 on t1.Fpzh=t2.Fpzh\n" +
            "inner join tblSubject t3 on t2.Fkmbh=t3.Fkmbh and t1.FYear = t2.FYear and t1.Fmonth = t2.Fmonth\n" +
            "where t1.FYear= #{FYear} and t1.Fstatus=1 and t1.UpStatus is null\n" +
            "and t2.Fpzh= #{Fpzh} and t1.Fmonth= #{Fmonth} and t2.Fkmbh = #{Fkmbh}")
    public CashItem selectCashCode(@Param("FYear") int FYear,@Param("Fmonth") int Fmonth,@Param("Fpzh") String Fpzh,@Param("Fkmbh") String Fkmbh);


    //插入对接错误凭证
    @DataSource(value = DataSourceType.MASTER)
    @Insert("insert into sys_u8c_error values(#{id},#{voucher_code},#{result_code},#{resultdes},#{current_date})")
    public int insertVoucherErroMes(@Param("id") String id,
                                    @Param("voucher_code") String voucherCode,
                                    @Param("result_code") String resultCode,
                                    @Param("resultdes") String resultDes,
                                    @Param("current_date") Date currentDate);

    //获取对接错误凭证
    @DataSource(value = DataSourceType.MASTER)
    @Select(" select id,voucher_code,result_code,resultdes,current_date from sys_u8c_error")
    public List<U8CErrCode> selectVoucherErroCode();

    //获取对接错误凭证
    @DataSource(value = DataSourceType.MASTER)
    @Select(" select id from sys_u8c_error where id = #{evidenceNum}")
    public String selectVoucherErroCodeById(String evidenceNum);

    //插入对接成功凭证
    @DataSource(value = DataSourceType.MASTER)
    @Insert("insert into sys_u8c_success values(#{evidence_number},#{voucher_id},#{date})")
    public int insertVoucherSucMes(@Param("evidence_number") String evdence_number,
                                   @Param("voucher_id") String voucher_id,
                                   @Param("date") Date date);

    //查询对接成功凭证
    @DataSource(value = DataSourceType.MASTER)
    @Select("select evidence_number,voucher_id,date from sys_u8c_success")
    public List<U8CSuccessCode> selectVoucherSuccCode();


    //查询U8C最大凭证号
    @DataSource(value = DataSourceType.SLAVE3)
    @Select("SELECT MAX(NO) from gl_voucher v1 , bd_vouchertype v2 where v1.PK_VOUCHERTYPE = v2.PK_VOUCHERTYPE and v1.YEAR=#{Year} and v1.PERIOD = #{Fmonth} and v2.VOUCHTYPENAME = #{VoucherType}")
    public Integer selectVoucherMaxCode(@Param("Year") int Year,@Param("Fmonth") int Fmonth,@Param("VoucherType") String VoucherType);

    //查询会计科目对应的主键
    @DataSource(value = DataSourceType.SLAVE3)
    @Select("select PK_ACCSUBJ from (select PK_ACCSUBJ from  BD_ACCSUBJ where SUBJCODE = #{voucherId} and  pk_glorgbook='0001' order by TS desc) where rownum = 1")
    public String  selectVoucherPrimary(@Param("voucherId")String voucherId);

    //查询U8C对应会计科目的辅助核算项目
    @DataSource(value = DataSourceType.SLAVE3)
    @Select("select BDNAME from \n" +
            "(\n" +
            "SELECT v1.pk_accsubj,v1.PK_BDINFO,v1.PK_SUBJASS,v3.SUBJCODE,v3.SUBJNAME,v2.BDNAME \n" +
            "FROM bd_subjass v1,bd_bdinfo v2,bd_accsubj v3 \n" +
            "where v1.PK_BDINFO = v2.PK_BDINFO \n" +
            "and v1.PK_ACCSUBJ = v3.PK_ACCSUBJ\n" +
            ")  \n" +
            "where PK_ACCSUBJ = #{pkAccsubj}")
    public List<String> selectVoucherSubjass(@Param("pkAccsubj") String pkAccsubj);
}
