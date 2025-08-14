import Data.Data;
import Util.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Audit321 {
public static void Audit321() throws IOException, NoSuchAlgorithmException {

            //日期格式
            SimpleDateFormat sdt = new SimpleDateFormat("yyyyMMdd");
            //一个Excel包含的文件数量
            int partitionSzie = 3;

            //压缩密码
            String passWord = "123456";

            String soleID = "";

            //命名数据
            String fileType = "Tran";//文件类型 Tran\Alloc\BankFlow\TranAuditResult
            String entCode = "001"; //企业编号
            String tranTime = sdt.format(new Date());//当前时间
            String tranType = "微信";//企业收银方式
            String opCode = "ADD";//操作码 ADD UPDATE DEL NOTICE
            String businessTag = "CRM";//业务类型

        //文件地址
            String zipPath = "./src/";
            String ExcelPath = "./src/main/resources/";
            String BASE_PATH = "http://localhost:8081";
            String API_PATH = "/hello";

            //通知信息
            String interfaceVersion = "1.0";
            String transSeqNo = "NoABC";
            String type = "1";

         //SFTP信息
            String SFTP_HOST = "10.60.45.65";
            int SFTP_PORT = 22;
            String SFTP_USER = "forftp";
            String SFTP_PASS = "123456";
            String SFTP_PATH = "/zyy/audit321/upload";

            //应收上传
            String excelName = fileType + "_" + entCode + "_" + tranTime + "_" + tranType + "_" + opCode;
            String zipName = fileType + "_" + entCode + "_" + businessTag + "_" + tranTime;
            //生成的Excel
            List<Data> info = new ArrayList<Data>();

            //工具类的创建
            ExcelUtil excel = new ExcelUtil();
            ZipUtil zip = new ZipUtil();
            SftpUtil sftp = new SftpUtil();
            NoticeUtil notice = new NoticeUtil();
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
            test1.setTradeTime(java.sql.Date.valueOf("2025-04-01"));
            test1.setOriginalTradeTime(null); // 可选，非现金上缴可为空
            test1.setEnterpriseCashieType("WECHAT_SCAN");
            test1.setRemark("门店扫码支付");
            test1.setCounterpartyName(""); // 非转账可留空
            test1.setCounterpartyAccount("");
            test1.setCounterpartyBank("");
            test1.setPurpose("日常收款");
            test1.setAuditNotifyUrl("https://api.company.com/notify");
            test1.setDeliveryOrderFlag("1"); // 是发货订单
            test1.setConfirmReceiveTime(java.sql.Date.valueOf("2025-04-01")); // 假设已收货
            test1.setExtendInfo("{\"extend1\":\"手机\",\"extend2\":\"1\",\"extend3\":\"0.5\",\"extend5\":\"李四\"}");

            test2.setOrderOrgCode("ORG002");
            test2.setAcquiringMerchantNo("MCH123456789");
            test2.setBizSystemCode("POS");
            test2.setReceivableOrderNo("SO20250405002");
            test2.setMerchantOrderNo("PAY20250405002");
            test2.setChannelSerialNo("ALI202504050002");
            test2.setIncomeExpenseFlag("2"); // 收入
            test2.setAmount("111100"); // 111100分 = 1111.00元
            test2.setTradeTime(java.sql.Date.valueOf("2025-04-01"));
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
            test3.setTradeTime(java.sql.Date.valueOf("2025-04-01"));
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
            //生成唯一ID
            for (Data data : info){
                String recordId = data.getRecordId();
                data.setRecordId(recordId);
            }
            LinkedHashMap<String, List<Data>> infoMap = excel.PartitionExcel(info,partitionSzie);
            if (infoMap == null) {
                return;
            }
            for (Map.Entry<String, List<Data>> entry : infoMap.entrySet()) {
                String filePath = ExcelPath + excelName + "_" + entry.getKey();
                List<Data> data = entry.getValue();
                int total = data.size();
                //总金额
                int amount = data.stream()
                        .mapToInt(d -> Integer.parseInt(d.getAmount()))
                        .sum();

                ExcelUtil.ExcelGenerator excelGenerator = ExcelUtil.ExcelGenerator.create()
                        //表一
                        .sheet("总览表", new String[]{"总笔数", "总金额"},
                                Arrays.<String[]>asList(
                                        new String[]{String.valueOf(total), String.valueOf(amount)}
                                )
                        )
                        //表二
                        .sheet("明细表", new String[]{
                                        "订单组织代码", "收单商户号",
                                        "业务系统标识",
                                        "应收单号",
                                        "商户订单号",
                                        "渠道流水号",
                                        "收支方向",
                                        "金额",
                                        "交易时间",
                                        "原交易日期",
                                        "企业收银方式",
                                        "备注",
                                        "对方户名",
                                        "对方账号",
                                        "对方银行",
                                        "用途",
                                        "结果通知地址",
                                        "发货类订单标识",
                                        "确认收货时间",
                                        "扩展信息"},
                                data.stream()
                                        .map(d -> new String[]{
                                                d.getOrderOrgCode(),
                                                d.getAcquiringMerchantNo(),
                                                d.getBizSystemCode(),
                                                d.getReceivableOrderNo(),
                                                d.getMerchantOrderNo(),
                                                d.getChannelSerialNo(),
                                                d.getIncomeExpenseFlag(),
                                                d.getAmount(),
                                                (d.getTradeTime() != null ? d.getTradeTime().toString() : null),
                                                (d.getOriginalTradeTime() != null ? d.getOriginalTradeTime().toString() : null),
                                                d.getEnterpriseCashieType(),
                                                d.getRemark(),
                                                d.getCounterpartyName(),
                                                d.getCounterpartyAccount(),
                                                d.getCounterpartyBank(),
                                                d.getPurpose(),
                                                d.getAuditNotifyUrl(),
                                                d.getDeliveryOrderFlag(),
                                                (d.getConfirmReceiveTime() != null ? d.getConfirmReceiveTime().toString() : null),
                                                d.getExtendInfo(),
                                                d.getRecordId()})
                                        .collect(Collectors.toList())
                        );
                try {
                    soleID = excelGenerator.calcultateContentHash();
                    excelGenerator.save(filePath);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (NoSuchAlgorithmException e) {
                    throw new RuntimeException(e);
                }
            }
            //取绝对路径
            File excels = new File(ExcelPath);
            String ExcelsPath = excels.getAbsolutePath();
//       压缩并加密               Tran_企业编号_业务系统标识_交易日期_唯一编号.zip
            zipPath = zip.zipEncrypt(ExcelsPath, zipPath, passWord, zipName,soleID);

//    // 上传文件（FTP）
//    try (FileInputStream input = new FileInputStream(new File(zipPath))) {
//
//        String fileName = zipPath.substring(zipPath.lastIndexOf('/') + 1);
//        FtpUtil.upload(SFTP_HOST, SFTP_PORT, SFTP_USER, SFTP_PASS, SFTP_PATH, fileName, input);
//        // 成功上传后-通知模块
//        notice.noticeAudit(BASE_PATH, API_PATH, interfaceVersion, transSeqNo, type, SFTP_PATH, zipName);
//
//    } catch (FileNotFoundException e) {
//        throw new RuntimeException("压缩文件找不到 " + zipPath, e);
//    } catch (IOException e) {
//        throw new RuntimeException("读取出问题 " + e.getMessage(), e);
//    } catch (Exception e) {
//        throw new RuntimeException("FTP出问题 " + e.getMessage(), e);
//    }

//            //上传文件（SFTP/FTP）
//            try (FileInputStream input = new FileInputStream(new File(zipPath))){
//
//                String fileName = zipPath.substring(zipPath.lastIndexOf('/') + 1);
//                sftp.upload(SFTP_HOST, SFTP_PORT, SFTP_USER, SFTP_PASS, SFTP_PATH, fileName, input);
//                //成功上传后-通知模块
//                notice.noticeAudit(BASE_PATH,API_PATH,interfaceVersion,transSeqNo,type,SFTP_PATH,zipName);
//            } catch (FileNotFoundException e) {
//                throw new RuntimeException("压缩文件找不到 "+zipPath,e);
//            } catch (IOException e) {
//                throw new RuntimeException("读取出问题 "+e.getMessage(),e);
//            } catch (Exception e) {
//                throw new RuntimeException("SFTP出问题 "+e.getMessage());
//            }
        }
}
