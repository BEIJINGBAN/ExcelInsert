package Util;

import DTO.ShopExcelDTO;
import Domain.Shop;
import Domain.ShopExtend;
import Mapper.IShopExtendMapper;
import Mapper.IShopMapper;
import Mapper.ShopImportMapper;
import com.alibaba.excel.EasyExcel;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mapstruct.factory.Mappers;

public class Inseart {
    //        try {
//            EasyExcel.write(testPath, ShopExcelDTO.class)
//                    .sheet("测试数据")
//                    .doWrite(Collections.emptyList());
//            log.info("导出成功，地址为 ：{}",testPath);
//        }catch (Exception e) {
//            log.error("导出失败 :",e);
//        }
    private static Logger log = LogManager.getLogger(Inseart.class);

    public static void inseart(String localUrl) {
        ShopImportMapper shopImportMapper = Mappers.getMapper(ShopImportMapper.class);

        File file = new File(localUrl);

        ExcelListener excelListener = new ExcelListener();

//        EasyExcel.read(file, ShopExcelDTO.class, excelListener)
//                .registerConverter(new FixDateConverter())
//                .registerConverter(new BigDecimalConverter())
//                .sheet("直营门店")
//                .doRead();

        EasyExcel.read(file, ShopExcelDTO.class, excelListener)
                .registerConverter(new FixDateConverter())
                .registerConverter(new BigDecimalConverter())
                .sheet()
                .doRead();

        List<ShopExcelDTO> middleList = excelListener.getDataList();
        log.info("接收成功，共接收 {} 条数据", middleList.size());
//          测试数据库中是否存在数据
//        List<Shop> shopList = new ArrayList<>();
//        List<ShopExtend> shopExtendList = new ArrayList<>();
//
//        int i = 0;
//        for (ShopExcelDTO dto : middleList) {
//            shopList.add(shopImportMapper.toShop(dto));
//            shopExtendList.add(shopImportMapper.toShopExtend(dto));
//        }
//        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
//            IShopMapper shopMapper = sqlSession.getMapper(IShopMapper.class);
//
//            List<Shop> toInsertList = new ArrayList<>();
//            for (Shop shop : shopList) {
//                boolean exists = shopMapper.existsByYqsOrgCodeAndTenant(
//                        shop.getYqsOrgCode(), shop.getTenantCode());
//                if (!exists) {
//                    log.info("可以插入数据");
//                } else {
//                    i++;
//                    log.warn(" 跳过已存在的门店: yqsOrgCode={}, shopName={}",
//                            shop.getYqsOrgCode(), shop.getShopName());
//                }
//            }
//            log.info("数据库中已存在 "+i +" 条数据");
//        }

        Map<String, List<ShopExcelDTO>> middleMap = middleList.stream()
                .filter(dto -> dto.getShopCode() != null && !dto.getShopCode().isEmpty())
                .collect(Collectors.groupingBy(ShopExcelDTO::getShopCode));
        List<ShopExcelDTO> finalList = new ArrayList<>();
        List<ShopExcelDTO> abandonList = new ArrayList<>();

        finalList.addAll(middleList);
//        for (Map.Entry<String,List<ShopExcelDTO>> entry: middleMap.entrySet()) {
//            String shopCode = entry.getKey();
//            List<ShopExcelDTO> noFilterList = entry.getValue();
//
//            Optional<ShopExcelDTO> abandon = noFilterList.stream()
//                    .filter(dto -> "未启用".equals(dto.getIsActive()))
//                    .findFirst();
//            if (abandon.isPresent()) {
//                finalList.add(abandon.get());
//
//                noFilterList.stream()
//                        .filter(dto -> !dto.equals(abandon.get()))
//                        .forEach(dto -> {
//                            abandonList.add(dto);
//                            log.warn("数据被丢弃（ 启用 ）");
//                        });
//            }else{
//                abandonList.addAll(noFilterList);
//            }
//        }
//
//
//
        List<Shop> shopList = new ArrayList<>();
        List<ShopExtend> shopExtendList = new ArrayList<>();

        for(ShopExcelDTO dto : finalList){
            shopList.add(shopImportMapper.toShop(dto));
            shopExtendList.add(shopImportMapper.toShopExtend(dto));
        }
        int j = 0;
        try(SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            IShopMapper shopMapper = sqlSession.getMapper(IShopMapper.class);
            IShopExtendMapper shopExtendMapper = sqlSession.getMapper(IShopExtendMapper.class);
//              shopMapper.increaseShop(shopList);
            shopExtendMapper.increaseShopExtend(shopExtendList);
            sqlSession.commit();

            log.info("成功插入 ");
            //            for (Shop shop : shopList) {
//                shopMapper.updateShop(shop);
//                sqlSession.commit();
//                log.info("更新成功，店铺代码为 [{}] ,店铺名为 {}", shop.getShopCode(),shop.getShopName());
//                j++;
//
//            }
//            log.info("成功更新 "+j+" 条数据");
        }catch (Exception e){
            log.error(e.getMessage());
        }
        log.warn("导入 {},共丢弃 {} 条数数据 ，剩余 {} 条数据", middleList.size(),abandonList.size(),finalList.size());
        for (ShopExcelDTO dto : abandonList) {
            log.warn("丢弃 商店编号为 [{}] 商店名 {} 启用状态： ({})",dto.getShopCode(),dto.getShopName(),dto.getIsActive());
        }
    }
}
