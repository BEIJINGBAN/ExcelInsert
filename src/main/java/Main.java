import Data.Data;
import Util.ExcelUtil;
import Util.SftpUtil;
import Util.ZipUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //工具类的创建
        ExcelUtil excel = new ExcelUtil();
        ZipUtil zip = new ZipUtil();
        SftpUtil sftp = new SftpUtil();

        //一个Excel包含的文件数量
        int partitionSzie = 1;
        //生成的Excel文件的路径-准备未来Zip
        String excelPash = "";
        //文件地址
        String zipPath = "./src/";
        String ExcelPath = "./src/main/resources/";
        //解压密码
        String passWord = "123456";
        //日期格式
        SimpleDateFormat sdt = new SimpleDateFormat("yyyyMMdd");


        //命名数据
        String fileType = "Tran";//文件类型 Tran\Alloc\BankFlow\TranAuditResult
        String entCode = "001"; //企业编号
        String tranTime = sdt.format(new Date());//当前时间
        String tranType = "微信";//企业收银方式
        String opCode = "ADD";//操作码 ADD UPDATE DEL NOTICE
        String businessTag = "CRM";//业务类型


        //生成的Excel
        List<Data> info = new ArrayList<Data>();

        //测试数据
        Data test1 = new Data();
        Data test2 = new Data();
        Data test3 = new Data();

        test1.setOrderOrgCode("ORG001");
        test1.setAcquiringMerchantNo("MCH123456789");
        test1.setBizSystemCode("POS");
        test1.setReceivableOrderNo("SO20250405001");
        test1.setMerchantOrderNo("PAY20250405001");
        test1.setChannelSerialNo("WX202504050001");
        test1.setIncomeExpenseFlag("2"); // 收入
        test1.setAmount("100"); // 100分 = 1元
        test1.setTradeTime(new Date());
        test1.setOriginalTradeTime(null); // 可选，非现金上缴可为空
        test1.setEnterpriseCashieType("WECHAT_SCAN");
        test1.setRemark("门店扫码支付");
        test1.setCounterpartyName(""); // 非转账可留空
        test1.setCounterpartyAccount("");
        test1.setCounterpartyBank("");
        test1.setPurpose("日常收款");
        test1.setAuditNotifyUrl("https://api.company.com/notify");
        test1.setDeliveryOrderFlag("1"); // 是发货订单
        test1.setConfirmReceiveTime(new Date()); // 假设已收货
        test1.setExtendInfo("{\"extend1\":\"手机\",\"extend2\":\"1\",\"extend3\":\"0.5\",\"extend5\":\"李四\"}");

        test2.setOrderOrgCode("ORG002");
        test2.setAcquiringMerchantNo("MCH123456789");
        test2.setBizSystemCode("POS");
        test2.setReceivableOrderNo("SO20250405002");
        test2.setMerchantOrderNo("PAY20250405002");
        test2.setChannelSerialNo("ALI202504050002");
        test2.setIncomeExpenseFlag("2"); // 收入
        test2.setAmount("111100"); // 111100分 = 1111.00元
        test2.setTradeTime(new Date());
        test2.setOriginalTradeTime(null);
        test2.setEnterpriseCashieType("ALIPAY_SCAN");
        test2.setRemark("支付宝门店收款");
        test2.setCounterpartyName("");
        test2.setCounterpartyAccount("");
        test2.setCounterpartyBank("");
        test2.setPurpose("日常收款");
        test2.setAuditNotifyUrl("https://api.company.com/notify");
        test2.setDeliveryOrderFlag("0"); // 不是发货订单（如服务费）
        test2.setConfirmReceiveTime(null); // 非发货订单可为空
        test2.setExtendInfo("{\"extend1\":\"会员充值\",\"extend2\":\"1\",\"extend3\":\"11.11\",\"extend5\":\"王五\"}");

        test3.setOrderOrgCode("ORG003");
        test3.setAcquiringMerchantNo("MCH987654321");
        test3.setBizSystemCode("ERP");
        test3.setReceivableOrderNo("SO20250405003");
        test3.setMerchantOrderNo("REF20250405003");
        test3.setChannelSerialNo("BANK20250405");
        test3.setIncomeExpenseFlag("1"); // 支出（退款）
        test3.setAmount("5000"); // 5000分 = 50元
        test3.setTradeTime(new Date());
        test3.setOriginalTradeTime(java.sql.Date.valueOf("2025-04-01")); // 原交易日期
        test3.setEnterpriseCashieType("BANK_TRANSFER");
        test3.setRemark("客户退货退款");
        test3.setCounterpartyName("张三");
        test3.setCounterpartyAccount("6222080200123456789");
        test3.setCounterpartyBank("中国工商银行");
        test3.setPurpose("退款");
        test3.setAuditNotifyUrl("https://api.company.com/notify");
        test3.setDeliveryOrderFlag("0"); // 退款非发货订单
        test3.setConfirmReceiveTime(null);
        test3.setExtendInfo("{\"extend1\":\"退货订单\",\"extend2\":\"1\",\"extend5\":\"VIP客户\"}");

        // 添加到列表
        info.add(test1);
        info.add(test2);
        info.add(test3);

        //生成Excel，并给出返回地址  Tran_QT330001_20231025_微信_ADD_001.xlsx
        excelPash = excel.easyExcel(ExcelPath,fileType,entCode,tranTime,tranType,opCode,info,partitionSzie);

        //压缩并加密               Tran_企业编号_业务系统标识_交易日期_唯一编号.zip
        zipPath = zip.zipEncrypt(excelPash,zipPath,passWord,fileType,entCode,businessTag,tranTime);

        //上传文件（SFTP/FTP）
        try (FileInputStream input = new FileInputStream(new File(zipPath))){

            String fileName = zipPath.substring(zipPath.lastIndexOf(File.separator)+1);
            sftp.upload("122.224.83.69", 10022, "zyy-sftp", "zyy-sftp/DFeVQf3#6vu8", "/zyy/jh/upload", fileName, input);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("压缩文件找不到 "+zipPath,e);
        } catch (IOException e) {
            throw new RuntimeException("读取出问题 "+e.getMessage(),e);
        } catch (Exception e) {
            throw new RuntimeException("SFTP出问题 "+e.getMessage());
        }
    }
}