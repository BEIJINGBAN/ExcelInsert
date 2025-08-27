package Util;

import DTO.ShopExcelDTO;
import Domain.Shop;
import Domain.ShopExtend;
import Mapper.IShopExtendMapper;
import Mapper.IShopMapper;
import Mapper.ShopImportMapper;
import com.alibaba.excel.EasyExcel;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mapstruct.factory.Mappers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Update {
        //        try {
//            EasyExcel.write(testPath, ShopExcelDTO.class)
//                    .sheet("测试数据")
//                    .doWrite(Collections.emptyList());
//            log.info("导出成功，地址为 ：{}",testPath);
//        }catch (Exception e) {
//            log.error("导出失败 :",e);
//        }
        private static Logger log = LogManager.getLogger(Util.Update.class);

        public static void update(String localUrl) {
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

        int i = 0;

//            Map<String, List<ShopExcelDTO>> middleMap = middleList.stream()
//                    .filter(dto -> dto.getShopCode() != null && !dto.getShopCode().isEmpty())
//                    .collect(Collectors.groupingBy(ShopExcelDTO::getShopCode));
            List<ShopExcelDTO> finalList = new ArrayList<>();
            List<ShopExcelDTO> abandonList = new ArrayList<>();

            finalList = middleList.stream()
                    .limit(5)
                    .collect(Collectors.toList());
      //      finalList.addAll(middleList);


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
            int k = 0;
            try(SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
                IShopMapper shopMapper = sqlSession.getMapper(IShopMapper.class);
                IShopExtendMapper shopExtendMapper = sqlSession.getMapper(IShopExtendMapper.class);
                for (Shop shop : shopList) {
                    shopMapper.updateShop(shop);
                    sqlSession.commit();
                    log.info("成功更新 Shop_info，店铺代码为 [{}] ,店铺名为 {}", shop.getShopCode(),shop.getShopName());
                    j++;
                }
                for (ShopExtend shopExtend : shopExtendList) {
                    shopExtendMapper.updateShopExtend(shopExtend);
                    sqlSession.commit();
                    k++;
                    log.info("成功更新shop_info_extend，店铺代码为 [{}] ", shopExtend.getShopCode());
                }
            log.info("成功更新 Shop_info表 "+j+" 条数据");
                log.info("成功更新 Shop_info表 "+k+" 条数据");
            }catch (Exception e){
                log.error(e.getMessage());
            }
    }
}
