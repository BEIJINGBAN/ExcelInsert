package Util;

import Data.Data;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;


public class ExcelUtil {



    //创建Excel
    public static String createExcel(String filePath, List<Data> info) {
        //总金额
        int nums = info.stream()
                .mapToInt(data-> Integer.parseInt(data.getAmount()))
                .sum();
        //第一页标题
        String[] title1 = {
                "总笔数",
                "总金额"
        };
        //第二页标题
        String[] title2 = {
                "订单组织代码",
                "收单商户号" ,
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
                "发货类订单标识" ,
                "确认收货时间",
                "扩展信息"
        };
        String[] title3 ={
                "交易分账标记",
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
                "回调通知地址",
                "必填",
                "不分账/支付时分账/支付后分账",
                "支付时分账交易必填" ,
                "填写组织编号",
                "t支付时分账交易必填",
                "支付时分账交易必填",
                "支付时分账交易必填",
                "支付时分账交易必填",
                "非必填",
                "非必填,",
                "非必填",
                "t非必填",
                "非必填",
                "必填，如果不传，数据有问题时结果没法回传，数据消息会丢失。长度256"
        };

        String[] title4 ={
                "渠道名称"
        };
        //创建一个Excel
        XSSFWorkbook workbook = new XSSFWorkbook();

        //创建工作表
        XSSFSheet sheet1 = workbook.createSheet("总览表");
        XSSFSheet sheet2 = workbook.createSheet("详细表");

        //创建第一行
        XSSFRow row1 = sheet1.createRow(0);

        XSSFRow row2 = sheet2.createRow(0);

        //创建第一个格
        XSSFCell cell1 = null;
        XSSFCell cell2 = null;

        //写入标题
        //另一种版本实现
//        for (int i = 0; i < title1.length; i++) {
//            cell1 = row1.createCell(i);
//            cell1.setCellValue(title1[i]);
//        }
        row1.createCell(0).setCellValue(title1[0]);
        row1.createCell(1).setCellValue(title1[1]);
        sheet1.setColumnWidth(0, 20*256);//设置格子宽度
        sheet1.setColumnWidth(1, 20*256);
        //第二个工作表标题
        for (int i = 0; i < title2.length; i++) {
            cell2 = row2.createCell(i);
            sheet2.setColumnWidth(i, 20*256);
            cell2.setCellValue(title2[i]);
        }

        //写入第一张表数据
        XSSFRow nrow = sheet1.createRow(1);
        nrow.createCell(0).setCellValue("共 "+info.size()+" 笔交易");
        nrow .createCell(1).setCellValue("金额总共 "+nums+" 元");

        //写入第二张表数据
        for (int j = 0; j < info.size(); j++) {//创建第j行
            XSSFRow row = sheet2.createRow(j+1);//行
            Data infoData = info.get(j);
            row.createCell(0).setCellValue(infoData.getOrderOrgCode());
            row.createCell(1).setCellValue(infoData.getAcquiringMerchantNo());
            row.createCell(2).setCellValue(infoData.getBizSystemCode());
            row.createCell(3).setCellValue(infoData.getReceivableOrderNo());
            row.createCell(4).setCellValue(infoData.getMerchantOrderNo());
            row.createCell(5).setCellValue(infoData.getChannelSerialNo());
            row.createCell(6).setCellValue(infoData.getIncomeExpenseFlag());
            row.createCell(7).setCellValue(infoData.getAmount());

            // 日期类型需要格式化或直接写字符串
            if (infoData.getTradeTime() != null) {
                row.createCell(8).setCellValue(infoData.getTradeTime().toString());
            } else {
                row.createCell(8).setCellValue("");
            }

            if (infoData.getOriginalTradeTime() != null) {
                row.createCell(9).setCellValue(infoData.getOriginalTradeTime().toString());
            } else {
                row.createCell(9).setCellValue("");
            }

            row.createCell(10).setCellValue(infoData.getEnterpriseCashieType());
            row.createCell(11).setCellValue(infoData.getRemark());
            row.createCell(12).setCellValue(infoData.getCounterpartyName());
            row.createCell(13).setCellValue(infoData.getCounterpartyAccount());
            row.createCell(14).setCellValue(infoData.getCounterpartyBank());
            row.createCell(15).setCellValue(infoData.getPurpose());
            row.createCell(16).setCellValue(infoData.getAuditNotifyUrl());
            row.createCell(17).setCellValue(infoData.getDeliveryOrderFlag());

            if (infoData.getConfirmReceiveTime() != null) {
                row.createCell(18).setCellValue(infoData.getConfirmReceiveTime().toString());
            } else {
                row.createCell(18).setCellValue("");
            }

            row.createCell(19).setCellValue(infoData.getExtendInfo());
            row.createCell(20).setCellValue(infoData.getRecordId());
        }
        //隐藏一ID列
        sheet2.setColumnHidden(20,true);
        //给定Excel路径
        File file = new File(filePath);
        File parentFile = file.getParentFile();
        String thisFilePath = parentFile.getAbsolutePath();
        try {
            file.createNewFile();//创建
            FileOutputStream fox = FileUtils.openOutputStream(file);//打开输入模式
            workbook.write(fox);//将workbook写入
            fox.close();//保存并关闭
            System.out.println("成功创建了Excel");
            System.out.println("Excel文件的地址为: "+file.getCanonicalFile());
            return thisFilePath;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    //分割Excel
    public LinkedHashMap PartitionExcel(List<Data> info,int maxSize){
        if (info == null || info.size() == 0) {
            System.out.println("没有数据需要分割");
            return null;
        }

        LinkedHashMap<String,List<Data>> InfoMap = new LinkedHashMap<>();

        //文件从1开始
        int ExcelIndex = 1;
        int j = 0;


        while(j < info.size()) {
            List<Data> list = new ArrayList<Data>();

            int end = Math.min(info.size(),j+maxSize);
            for(; j<end; j++){
                list.add(info.get(j));
            }
            //取名
            String ExcelName = String.format("%03d.xlsx",ExcelIndex);

            InfoMap.put(ExcelName,list);

            j = end;

            ExcelIndex++;
        }
        return InfoMap;
    }

    //分割后创建Excel
    public String easyExcel(String filePath, String fileType, String entCode, String tranTime, String tranType, String opCode, List<Data> info, int maxSize){
        LinkedHashMap<String ,List<Data>> InfoMap = PartitionExcel(info,maxSize);
        if(InfoMap == null){
            return null;
        }
        Set<String> allFilePath = new HashSet<>();
        for (Map.Entry<String,List<Data>> entry : InfoMap.entrySet()) {
            String ExcelPath = filePath + fileType+"_"+entCode+"_"+tranTime+"_"+tranType+"_"+opCode+"_"+entry.getKey();
            allFilePath.add(createExcel(ExcelPath,entry.getValue()));
        }
        File file = new File(filePath);
        try {
            return file.getCanonicalFile().toString();
        } catch (Exception e) {
            return file.getAbsolutePath();
        }
    }

    public static void createExcel2(String filePath, List<Data> info) {
//        //总金额
//        String[] title3 ={
//                "交易分账标记",
//                "分账订单组织",
//                "分账入账方商户号",
//                "分账明细流水号",
//                "分账金额",
//                "分账子单手续费",
//                "商家优惠金额",
//                "平台优惠金额",
//                "渠道优惠金额",
//                "对方账号",
//                "对方户名",
//                "回调通知地址",
//                "必填",
//                "不分账/支付时分账/支付后分账",
//                "支付时分账交易必填" ,
//                "填写组织编号",
//                "t支付时分账交易必填",
//                "支付时分账交易必填",
//                "支付时分账交易必填",
//                "支付时分账交易必填",
//                "非必填",
//                "非必填,",
//                "非必填",
//                "t非必填",
//                "非必填",
//                "必填，如果不传，数据有问题时结果没法回传，数据消息会丢失。长度256"
//        };
//
//        String[] title4 ={
//                "渠道名称"
//        };
//        //创建一个Excel
//        XSSFWorkbook workbook = new XSSFWorkbook();
//
//        //创建工作表
//        XSSFSheet sheet1 = workbook.createSheet("收单对账数据");
//        XSSFSheet sheet2 = workbook.createSheet("渠道表");
//
//        //创建行
//        XSSFRow row1 = sheet1.createRow(0);
//        XSSFRow row2 = sheet2.createRow(0);
//
//        //创建第一个格
//        XSSFCell cell1 = null;
//        XSSFCell cell2 = null;
//
//        //第一个工作表标题
//        for (int i = 0; i < title3.length; i++) {
//            sheet1.setColumnWidth(i, 20 * 256);
//            if (i < title3.length/2) {
//                //第一行标题
//                sheet1.createRow(0).createCell(i).setCellValue(title3[i]);
//            }
//            else {
//                //第二行标题
//                sheet1.createRow(1).createCell(i- title3.length/2).setCellValue(title3[i]);
//            }
//        }
//
//        //第二个工作表标题
//        row2.createCell(0).setCellValue(title4[0]);
//        sheet1.setColumnWidth(0, 20*256);//设置格子宽度
//
//        //写入第一张表数据
//        for (int j = 0; j < info.size(); j++) {//创建第j行
//            XSSFRow row = sheet2.createRow(j+2);//行
//            Data infoData = info.get(j);
//            row.createCell(0).setCellValue(infoData.getOrderOrgCode());
//            row.createCell(1).setCellValue(infoData.getAcquiringMerchantNo());
//            row.createCell(2).setCellValue(infoData.getBizSystemCode());
//            row.createCell(3).setCellValue(infoData.getReceivableOrderNo());
//            row.createCell(4).setCellValue(infoData.getMerchantOrderNo());
//            row.createCell(5).setCellValue(infoData.getChannelSerialNo());
//            row.createCell(6).setCellValue(infoData.getIncomeExpenseFlag());
//            row.createCell(7).setCellValue(infoData.getAmount());
//
//            // 日期类型需要格式化或直接写字符串
//            if (infoData.getTradeTime() != null) {
//                row.createCell(8).setCellValue(infoData.getTradeTime().toString());
//            } else {
//                row.createCell(8).setCellValue("");
//            }
//
//            if (infoData.getOriginalTradeTime() != null) {
//                row.createCell(9).setCellValue(infoData.getOriginalTradeTime().toString());
//            } else {
//                row.createCell(9).setCellValue("");
//            }
//
//            row.createCell(10).setCellValue(infoData.getEnterpriseCashieType());
//            row.createCell(11).setCellValue(infoData.getRemark());
//            row.createCell(12).setCellValue(infoData.getCounterpartyName());
//            row.createCell(13).setCellValue(infoData.getCounterpartyAccount());
//            row.createCell(14).setCellValue(infoData.getCounterpartyBank());
//            row.createCell(15).setCellValue(infoData.getPurpose());
//            row.createCell(16).setCellValue(infoData.getAuditNotifyUrl());
//            row.createCell(17).setCellValue(infoData.getDeliveryOrderFlag());
//
//            if (infoData.getConfirmReceiveTime() != null) {
//                row.createCell(18).setCellValue(infoData.getConfirmReceiveTime().toString());
//            } else {
//                row.createCell(18).setCellValue("");
//            }
//
//            row.createCell(19).setCellValue(infoData.getExtendInfo());
//
//        }
//        //写入第二张表数据
//        XSSFRow nrow = sheet1.createRow(1);
//        nrow.createCell(0).setCellValue("共 "+info.size()+" 笔交易");
//        nrow .createCell(1).setCellValue("金额总共 "+nums+" 元");
//        //给定Excel路径
//        File file = new File(filePath);
//        try {
//            file.createNewFile();//创建
//            FileOutputStream fox = FileUtils.openOutputStream(file);//打开输入模式
//            workbook.write(fox);//将workbook写入
//            fox.close();//关闭保存
//            System.out.println("成功创建了Excel");
//            System.out.println("Excel文件的地址为: "+file.getCanonicalFile());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}

