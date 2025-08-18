import Config.Constants;
import Data.BillData;
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

public class Audit327 {
    public static void Audit327(int excelSize) throws FileNotFoundException, IOException, NoSuchAlgorithmException {
        //3.2.7对账单
        //日期格式
        SimpleDateFormat sdt = new SimpleDateFormat("yyyyMMdd");
        //一个Excel包含的文件数量
        //命名数据
        String billName = "收账单对账数据";//文件类型 Tran\Alloc\BankFlow\TranAuditResult
        String tranTime = sdt.format(new Date());//当前时间

        //文件地址
        String zipPath = "./src/";
        String ExcelPath = "./src/main/audit327/";

        //通知信息
        String interfaceVersion = "1.0";
        String transSeqNo = "NoABC";
        String type = "2";

        //应收上传
        String filePath = "";
        String excelName = billName + "_" + tranTime;
        String zipName = billName + "_" + tranTime;
        String soleId = "";
        //生成的Excel
        List<BillData> info = new ArrayList<BillData>();

        //工具类的创建
        ExcelUtil excel = new ExcelUtil();
        ZipUtil zip = new ZipUtil();
        SftpUtil sftp = new SftpUtil();
        NoticeUtil notice = new NoticeUtil();
        FtpUtil ftp = new FtpUtil();

        //测试数据
        BillData test1 = new BillData();
        test1.setOrgCode("ORG001");
        test1.setMerchantNo("MCH2023001");
        test1.setMerchantOrderNo("ORD20231116001");
        test1.setChannelSerialNo("CS20231116001");
        test1.setBaoRongSerialNo("BR20231116001");
        test1.setThirdPartySerialNo("20231116200000000001");
        test1.setChannelName("易企收");
        test1.setTradeDirection("收入");
        test1.setTradeDate("2023-11-16");
        test1.setSettleDate("2023-11-17");
        test1.setTradeAmount("100.00");
        test1.setFee("0.60");
        test1.setPayMethod("支付宝");
        test1.setTerminalId("T001");
        test1.setSplitFlag("不分账");
        test1.setMerchantDiscount("5.00");
        test1.setPlatformDiscount("2.00");
        test1.setChannelDiscount("1.00");
        test1.setCounterpartyAccountNew("alipay_user_123");
        test1.setCounterpartyNameNew("张三");
        test1.setCallbackUrl("http://localhost:9091/hello");

        BillData splitPayment = new BillData();
        splitPayment.setOrgCode("ORG002");
        splitPayment.setMerchantNo("MCH2023002");
        splitPayment.setMerchantOrderNo("ORD20231116002");
        splitPayment.setChannelSerialNo("CS20231116002");
        splitPayment.setBaoRongSerialNo("BR20231116002");
        splitPayment.setThirdPartySerialNo("UP2023111600001");
        splitPayment.setChannelName("微信");
        splitPayment.setTradeDirection("收入");
        splitPayment.setTradeDate("2023-11-16");
        splitPayment.setSettleDate("2023-11-17");
        splitPayment.setTradeAmount("200.00");
        splitPayment.setFee("1.20");
        splitPayment.setPayMethod("银联");
        splitPayment.setTerminalId("T002");
        splitPayment.setSplitFlag("支付时分账");
        splitPayment.setSplitOrgCode("ORG003");
        splitPayment.setSplitMerchantNo("MCH2023003");
        splitPayment.setSplitDetailSerialNo("SD20231116001");
        splitPayment.setSplitAmount("50.00");
        splitPayment.setSplitFee("0.30");
        splitPayment.setCounterpartyAccountNew("unionpay_acct_456");
        splitPayment.setCounterpartyNameNew("李四超市");
        splitPayment.setCallbackUrl("http://localhost:9091/hello");

        BillData refundPayment = new BillData();
        refundPayment.setOrgCode("ORG001");
        refundPayment.setMerchantNo("MCH2023001");
        refundPayment.setMerchantOrderNo("ORD20231116001");
        refundPayment.setChannelSerialNo("CS20231116003");
        refundPayment.setBaoRongSerialNo("BR20231116003");
        refundPayment.setOriginalBaoRongSerialNo("BR20231116001"); // 原支付流水
        refundPayment.setThirdPartySerialNo("20231116210000000001");
        refundPayment.setChannelName("支付宝");
        refundPayment.setTradeDirection("支出");
        refundPayment.setTradeDate("2023-11-18");
        refundPayment.setSettleDate("2023-11-19");
        refundPayment.setTradeAmount("100.00");
        refundPayment.setFee("0.00");
        refundPayment.setPayMethod("支付宝");
        refundPayment.setTerminalId("T001");
        refundPayment.setSplitFlag("不分账");
        refundPayment.setCounterpartyAccountNew("alipay_user_123");
        refundPayment.setCounterpartyNameNew("张三");
        refundPayment.setCallbackUrl("http://localhost:9091/hello");

        BillData wechatPayment = new BillData();
        wechatPayment.setOrgCode("ORG004");
        wechatPayment.setMerchantNo("MCH2023004");
        wechatPayment.setMerchantOrderNo("ORD20231116004");
        wechatPayment.setChannelSerialNo("CS20231116004");
        wechatPayment.setBaoRongSerialNo("BR20231116004");
        wechatPayment.setThirdPartySerialNo("wx1234567890abcdef");
        wechatPayment.setChannelName("易企收");
        wechatPayment.setTradeDirection("收入");
        wechatPayment.setTradeDate("2023-11-16");
        wechatPayment.setSettleDate("2023-11-17");
        wechatPayment.setTradeAmount("88.00");
        wechatPayment.setFee("0.53");
        wechatPayment.setPayMethod("支付宝");
        wechatPayment.setTerminalId("T004");
        wechatPayment.setSplitFlag("不分账");
        wechatPayment.setMerchantDiscount("5.00");
        wechatPayment.setPlatformDiscount("7.00"); // 平台大促优惠
        wechatPayment.setChannelDiscount("0.00");
        wechatPayment.setCounterpartyAccountNew("wx_user_789");
        wechatPayment.setCounterpartyNameNew("王五");
        wechatPayment.setCallbackUrl("http://localhost:9091/hello");

        // 添加到列表
        info.add(test1);
        info.add(splitPayment);
        info.add(wechatPayment);
        info.add(refundPayment);

        for (BillData data : info) {
            String recordId = data.getRecordId();
            data.setRecordId(recordId);
        }
        LinkedHashMap<String, List<BillData>> infoMap = excel.PartitionExcel(info, excelSize,excelName);
        if (infoMap == null) {
            return;
        }
        for (Map.Entry<String, List<BillData>> entry : infoMap.entrySet()) {
            filePath = ExcelPath + entry.getKey();
            List<BillData> data = entry.getValue();
            //渠道数量
            Set<String> channelSet = data.stream()
                    .map(BillData::getChannelName)
                    .filter(Objects::nonNull)
                    .collect(Collectors.toSet());

            //转为LIST
            List<String[]> channelName = channelSet.stream()
                    .map(name -> new String[]{name})
                    .collect(Collectors.toList());

            try {
                ExcelUtil.ExcelGenerator excelGenerator = ExcelUtil.ExcelGenerator.create()
                        //表一
                        .sheet("收单对账数据",
                                Arrays.asList(
                                        new String[]{
                                        "组织",
                                        "商户号",
                                        "商户订单号",
                                        "保融交易流水号",
                                        "渠道流水号",
                                        "第三方交易流水号",
                                        "原保融交易流水号",
                                        "渠道名称",
                                        "交易方向",
                                        "交易日期",
                                        "清算日期",
                                        "交易金额",
                                        "手续费",
                                        "支付方式",
                                        "终端号",
                                        "分账标记",
                                        "分账订单组织",
                                        "分账入账方商户号",
                                        "分账明细流水号",
                                        "分账金额",
                                        "分账子单手续费",
                                        "商家优惠金额",
                                        "平台优惠金额",
                                        "渠道优惠金额",
                                        "对方账号",
                                        "对方户名",
                                        "回调通知地址"
                                },
                                    new String[]{
                                        "必填，填写组织编号",
                                            "必填",
                                            "必填" ,
                                            "必填， 如果非保融渠道交易，填写收单渠道返回的流水号" ,
                                            "必填,指收单渠道返回的流水号" ,
                                            "非必填，指支付宝、微信的流水号" ,
                                            "退款时必填，指原收款保融交易流水号" ,
                                            "必填，详见<渠道名称>sheet",
                                            "必填，收入/支出" ,
                                            "必填，格式为yyyy-mm-dd，例如2023-11-16" ,
                                            "必填，格式为yyyy-mm-dd，例如2023-11-16" ,
                                            "必填，单位元，保留2位小数" ,
                                            "必填，单位元，保留2位小数" ,
                                            "必填，支付宝/微信/银联/数字人民币/网关支付/银行卡" ,
                                            "非必填" ,
                                            "必填，不分账/支付时分账/支付后分账" ,
                                            "支付时分账交易必填，填写组织编号" ,
                                            "支付时分账交易必填" ,
                                            "支付时分账交易必填" ,
                                            "支付时分账交易必填" ,
                                            "支付时分账交易必填" ,
                                            "非必填" ,
                                            "非必填" ,
                                            "非必填" ,
                                            "非必填" ,
                                            "非必填" ,
                                            "必填，如果不传，数据有问题时结果没法回传，数据消息会丢失。长度256"
                                    }
                                ),
                                data.stream()
                                        .map(b -> new String[]{
                                                b.getOrgCode(),
                                                b.getMerchantNo(),
                                                b.getMerchantOrderNo(),
                                                b.getBaoRongSerialNo(),
                                                b.getChannelSerialNo(),
                                                b.getThirdPartySerialNo(),
                                                b.getOriginalBaoRongSerialNo(),
                                                b.getChannelName(),
                                                b.getTradeDirection(),
                                                b.getTradeDate(),
                                                b.getSettleDate(),
                                                b.getTradeAmount(),
                                                b.getFee(),
                                                b.getPayMethod(),
                                                b.getTerminalId(),
                                                b.getSplitFlag(),
                                                b.getSplitOrgCode(),
                                                b.getSplitMerchantNo(),
                                                b.getSplitDetailSerialNo(),
                                                b.getSplitAmount(),
                                                b.getSplitFee(),
                                                b.getMerchantDiscount(),
                                                b.getPlatformDiscount(),
                                                b.getChannelDiscount(),
                                                b.getCounterpartyAccountNew(),
                                                b.getCounterpartyNameNew(),
                                                b.getCallbackUrl(),
                                                b.getRecordId()
                                        })
                                        .collect(Collectors.toList())
                        )
                        //表二
                        .sheet("渠道名称",
                                //标题
                                new String[]{
                                        "渠道名称"},
                                channelName
                        );
                soleId = excelGenerator.calcultateContentHash();
                excelGenerator.save(filePath);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
//        //取绝对路径
//        File excels = new File(ExcelPath);
//        String ExcelsPath = excels.getAbsolutePath();
//       压缩并加密               Tran_企业编号_业务系统标识_交易日期_唯一编号.zip
//        zipPath = zip.zipEncrypt(ExcelsPath, zipPath, Constants.ZIP_PASSWORD, zipName);

////             上传文件（FTP）
//        try (FileInputStream input = new FileInputStream(new File(zipPath))) {
//
//            String fileName = zipPath.substring(zipPath.lastIndexOf('/') + 1);
//            FtpUtil.upload(Constants.FTP_HOST, Constants.FTP_PORT, Constants.FTP_USER, Constants.FTP_PASS, Constants.FTP_PATH, fileName, input);
//            // 成功上传后-通知模块
//            notice.noticeAudit(Constants.BASE_PATH, Constants.API_PATH, interfaceVersion, transSeqNo, type, Constants.FTP_PATH, zipName);
//
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException("压缩文件找不到 " + zipPath, e);
//        } catch (IOException e) {
//            throw new RuntimeException("读取出问题 " + e.getMessage(), e);
//        } catch (Exception e) {
//            throw new RuntimeException("FTP出问题 " + e.getMessage(), e);
//        }
//        上传文件（SFTP）

        try (
                FileInputStream input = new FileInputStream(new File(filePath))){

            String fileName = filePath.substring(filePath.lastIndexOf('/') + 1);
            sftp.upload(Constants.SFTP_HOST, Constants.SFTP_PORT, Constants.SFTP_USER, Constants.SFTP_PASS, Constants.SFTP_PATH_327, fileName, input);
            //成功上传后-通知模块
            notice.noticeAudit(Constants.BASE_PATH,Constants.API_PATH,interfaceVersion,transSeqNo,type,Constants.SFTP_PATH_327,fileName);
        } catch (
                FileNotFoundException e) {
            throw new RuntimeException("压缩文件找不到 "+zipPath,e);
        } catch (
                IOException e) {
            throw new RuntimeException("读取出问题 "+e.getMessage(),e);
        } catch (Exception e) {
            throw new RuntimeException("SFTP出问题 "+e.getMessage());
        }
        }
    }
