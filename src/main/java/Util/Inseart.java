package Util;

import DTO.ShopExcelDTO;
import Domain.Shop;
import Domain.ShopExtend;
import Mapper.IShopExtendMapper;
import Mapper.IShopMapper;
import Mapper.ShopImportMapper;
import com.alibaba.excel.EasyExcel;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

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

    public static void inseart() {
        ShopImportMapper shopImportMapper = Mappers.getMapper(ShopImportMapper.class);

        String testPath = "D:/anyCode/java/Audit_Once/src/main/test/直营门店资料 - 副本.xlsx";
        File file = new File(testPath);

        ExcelListener excelListener = new ExcelListener();

        EasyExcel.read(file, ShopExcelDTO.class, excelListener)
                .sheet()
                .doRead();

        List<ShopExcelDTO> dataList = excelListener.getDataList();
        log.info("导入成功，共导入 {} 条数据", dataList.size());

//        int limit = 10;
//        List<ShopExcelDTO> limitedList = dataList.size() > limit ? dataList.subList(5, limit) : dataList;

        List<Shop> shopList = new ArrayList<>();
        List<ShopExtend> shopExtendList = new ArrayList<>();

        int i = 0;
        for (ShopExcelDTO dto : dataList) {
            shopList.add(shopImportMapper.toShop(dto));
            shopExtendList.add(shopImportMapper.toShopExtend(dto));
        }
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            IShopMapper shopMapper = sqlSession.getMapper(IShopMapper.class);

            List<Shop> toInsertList = new ArrayList<>();
            for (Shop shop : shopList) {
                boolean exists = shopMapper.existsByYqsOrgCodeAndTenant(
                        shop.getYqsOrgCode(), shop.getTenantCode());
                if (!exists) {
                    log.info("可以插入数据");
                } else {
                    i++;
                    log.warn(" 跳过已存在的门店: yqsOrgCode={}, shopName={}",
                            shop.getYqsOrgCode(), shop.getShopName());
                }
            }
            log.info("数据库中已存在 "+i +" 条数据");

            // 5. 如果没有要插入的数据，直接返回
//            if (toInsertList.isEmpty()) {
//                log.info("所有目标数据均已存在，无需插入。测试通过！");
//                return true;
//            }
//
//            log.info("正在插入 {} 条新数据", toInsertList.size());
//            shopMapper.increaseShop(toInsertList);
//            sqlSession.commit();
//
//            log.info("测试插入成功！共插入 {} 条新门店数据", toInsertList.size());
//            return true;
//
//        } catch (Exception e) {
//            log.error("插入过程中发生异常：", e);
//            return false;
//        }
        }
//        List<Shop> shopList = new ArrayList<>();
//        List<ShopExtend> shopExtendList = new ArrayList<>();
//
//        for(ShopExcelDTO dto : dataList){
//            shopList.add(shopImportMapper.toShop(dto));
//            shopExtendList.add(shopImportMapper.toShopExtend(dto));
//        }
//        try(SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
//            IShopMapper shopMapper = sqlSession.getMapper(IShopMapper.class);
//            IShopExtendMapper shopExtendMapper = sqlSession.getMapper(IShopExtendMapper.class);
//              shopMapper.increaseShop(shopList);
//  //          shopExtendMapper.increaseShopExtend(shopExtendList);
//            sqlSession.commit();
//            log.info("成功插入 ");
//            return true;
//        }catch (Exception e){
//            log.error(e.getMessage());
//            return false;
//        }
//    }
    }
}
