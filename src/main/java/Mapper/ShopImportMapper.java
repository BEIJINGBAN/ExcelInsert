package Mapper;

import DTO.ShopExcelDTO;
import Domain.Shop;
import Domain.ShopExtend;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;

import java.math.BigDecimal;


@Mapper
public interface ShopImportMapper {
    ShopImportMapper INSTANCE = Mappers.getMapper(ShopImportMapper.class);
    @Named("mapChannelType")
    @ValueMappings({
            @ValueMapping(source = "直营", target = "01"),
            @ValueMapping(source = "商超", target = "02"),
            @ValueMapping(source = "联营", target = "03"),
            @ValueMapping(source = "加盟", target = "04")
    })
    String mapChannelType(String source);

    @Named("mapCategoryCode")
    default String mapCategoryCode(String source) {
        if (source == null) {
            return "000";
        }
        // 预处理字符串：移除首尾空格，以确保精确匹配
        String trimmedSource = source.trim();

        switch (trimmedSource) {
            case "超市":
                return "01";
            case "联营":
                return "02";
            case "生活馆":
                return "03";
            case "线上平台":
                return "04";
            case "直营专卖":
                return "05";
            case "专柜":
                return "06";
            case "授权":
                return "07";
            case "经销":
                return "08";
            case "未定义":
                return "000";
            default:
                // 如果所有 case 都不匹配，返回默认值
                return "000";
        }
    }

    @Named("mapTypeCode")
    default String mapTypeCode(String source) {
        if (source == null) {
            return "000";
        }
        // 预处理字符串：移除首尾空格，以确保精确匹配
        String trimmedSource = source.trim();

        switch (trimmedSource) {
            case "经销商":
                return "1";
            case "超市":
                return "2";
            case "办事处":
                return "3";
            case "百货店":
                return "4";
            case "猫人经销商终端":
                return "5";
            case "街边店": // 注意：原始代码中这里多了一个空格，已移除
                return "6";
            case "云商批发商":
                return "7";
            case "授权商":
                return "8";
            case "电商客户":
                return "9";
            case "微盟客户":
                return "10";
            case "临时特卖":
                return "11";
            case "奥莱店":
                return "14";
            case "购物中心": // 注意：原始代码中这里多了一个空格，已移除
                return "21";
            case "租旺客户":
                return "22";
            case "未定义":
                return "000";
            default:
                // 如果所有 case 都不匹配，返回默认值
                return "000";
        }
    }
    @Named("mapLeaseType")
    default String mapLeaseType(String source) {
        if (source == null) {
            return "00";
        }
        String trimmedSource = source.trim();

        switch (trimmedSource) {
            case "浮动租金店":
                return "01";
            case "固定租金店":
                return "02";
            case "扣点店":
                return "03";
            case "联营店":
                return "04";
            case "其他":
                return "05";
            case "特卖及其他":
                return "06";
            default:
                // 如果所有 case 都不匹配，返回默认值
                return "00";
        }
    }
    @Named("mapChannelSalesPositionType")
    default String mapChannelSalesPositionType(String source) {
        if (source == null) {
            return "Er_00";
        }
        // 预处理字符串：移除首尾空格，以确保精确匹配
        String trimmedSource = source.trim();

        switch (trimmedSource) {
            case "正价店":
                return "01";
            case "特卖店":
                return "02";
            case "快闪店":
                return "03";
            case "奥莱店":
                return "04";
            default:
                // 如果所有 case 都不匹配，返回默认值
                return "00";
        }
    }
    @Named("mapFirstLevelRegionType")
    default String mapFirstLevelRegionType(String source) {
        if (source == null) {
            return "06"; // 默认返回“其他”
        }
        // 预处理字符串：移除首尾空格，以确保精确匹配
        String trimmedSource = source.trim();

        switch (trimmedSource) {
            case "华东大区":
                return "01";
            case "华南大区":
                return "02";
            case "华西大区":
                return "03";
            case "华北地区":
                return "04";
            case "华中大区":
                return "05";
            case "其他":
                return "06";
            default:
                // 如果所有 case 都不匹配，返回默认值
                return "00";
        }
    }
    @Named("mapSecondLevelRegionType")
    default String mapSecondLevelRegionType(String source) {
        if (source == null) {
            return "00"; // 默认返回“00”
        }
        // 预处理字符串：移除首尾空格，以确保精确匹配
        String trimmedSource = source.trim();

        switch (trimmedSource) {
            case "安徽大区":
                return "01";
            case "川渝大区":
                return "02";
            case "河南大区":
                return "03";
            case "后台":
                return "04";
            case "湖北大区":
                return "05";
            case "华北地区":
                return "06";
            case "华东大区":
                return "07";
            case "华南大区":
                return "08";
            case "零售安徽区":
                return "09";
            case "零售河北区":
                return "10";
            case "零售河南区":
                return "11";
            case "零售湖北区":
                return "12";
            case "零售华北大区":
                return "13";
            case "零售华南区":
                return "14";
            case "零售华西区":
                return "15";
            case "武汉大区":
                return "16";
            case "小程序":
                return "17";
            case "新零售":
                return "18";
            case "云贵大区":
                return "19";
            default:
                // 如果所有 case 都不匹配，返回默认值
                return "00";
        }
    }
    @Named("mapCityLevel")
    default String mapCityLevel(String source) {
        if (source == null) {
            return "00"; // 默认返回“00”
        }
        // 预处理字符串：移除首尾空格，以确保精确匹配
        String trimmedSource = source.trim();

        switch (trimmedSource) {
            case "一类城市":
                return "01";
            case "二类城市":
                return "02";
            case "三类城市":
                return "03";
            case "四类城市":
                return "04";
            default:
                // 如果所有 case 都不匹配，返回默认值
                return "00";
        }
    }
    @Named("mapShopImageType")
    default String mapShopImageType(String source) {
        if (source == null) {
            return "00"; // 默认返回“00”
        }
        // 预处理字符串：移除首尾空格，以确保精确匹配
        String trimmedSource = source.trim();

        switch (trimmedSource) {
            case "不变店":
                return "01";
            case "改造店":
                return "02";
            case "关闭店":
                return "03";
            case "新开店":
                return "04";
            default:
                // 如果所有 case 都不匹配，返回默认值
                return "00";
        }
    }
    @Named("mapBrandType")
    default String mapBrandType(String source) {
        if (source == null) {
            return "00"; // 默认返回“00”
        }
        String trimmedSource = source.trim();

        switch (trimmedSource) {
            case "猫人":
                return "01";
            default:
                // 如果所有 case 都不匹配，返回默认值
                return "00";
        }
    }
        @Named("mapShopImageTypeEnum")
        default String mapShopImageTypeEnum(String source) {
            if (source == null) {
                return "00"; // 默认返回“00”
            }
            // 预处理字符串：移除首尾空格，以确保精确匹配
            String trimmedSource = source.trim();

            switch (trimmedSource) {
                case "其他":
                    return "01";
                case "奥莱":
                    return "02";
                case "白秘密":
                    return "03";
                case "白生活馆":
                    return "04";
                case "白生活馆中岛":
                    return "05";
                case "白优品":
                    return "06";
                case "改造店":
                    return "07";
                case "黑秘密":
                    return "08";
                case "红色秘密":
                    return "09";
                case "季节柜":
                    return "10";
                case "科技馆":
                    return "11";
                case "快闪":
                    return "12";
                case "猫人":
                    return "13";
                case "升级科技馆":
                    return "14";
                case "生活馆":
                    return "15";
                case "特卖":
                    return "16";
                case "线上店铺":
                    return "17";
                case "小程序":
                    return "18";
                case "优品":
                    return "19";
                case "运动":
                    return "20";
                default:
                    // 如果所有 case 都不匹配，返回默认值
                    return "00";
            }
        }
    @Named("mapShopExtensionType")
    default String mapShopExtensionType(String source) {
        if (source == null) {
            return "00"; // 默认返回“00”
        }
        // 预处理字符串：移除首尾空格，以确保精确匹配
        String trimmedSource = source.trim();

        switch (trimmedSource) {
            case "不变店":
                return "01";
            case "改造店":
                return "02";
            case "关闭店":
                return "03";
            case "新开店":
                return "04";
            default:
                // 如果所有 case 都不匹配，返回默认值
                return "00";
        }
    }
    @Named("mapCheckoutMethod")
    default String mapCheckoutMethod(String source) {
        if (source == null) {
            return "00"; // 默认返回“00”
        }
        // 预处理字符串：移除首尾空格，以确保精确匹配
        String trimmedSource = source.trim();

        switch (trimmedSource) {
            case "统一收银":
                return "01";
            case "自收银":
                return "02";
            case "商场收银":
                return "03";
            default:
                // 如果所有 case 都不匹配，返回默认值
                return "00";
        }
    }
    @Named("mapLedgerType")
    default String mapLedgerType(String source) {
        if (source == null) {
            return "00"; // 默认返回“00”
        }
        // 预处理字符串：移除首尾空格，以确保精确匹配
        String trimmedSource = source.trim();

        switch (trimmedSource) {
            case "微盟":
                return "01";
            case "云商":
                return "02";
            case "猫人":
                return "03";
            case "电商":
                return "04";
            default:
                // 如果所有 case 都不匹配，返回默认值
                return "00";
        }
    }
    @Named("mapVatRate")
    default String mapVatRate(BigDecimal source) {
        // 处理 null 情况
        if (source == null) {
            return "00";
        }

        // 将 BigDecimal 转为 百分比整数（如 0.03 -> 3）
        int rate = source.multiply(BigDecimal.valueOf(100)).intValue();

        // 格式化为两位字符串，不足两位前面补0
        return String.format("%02d", rate);
    }
    @Named("mapMallType")
    default String mapMallType(String source) {
        if (source == null) {
            return "00"; // 默认返回“00”
        }
        // 预处理字符串：移除首尾空格，以确保精确匹配
        String trimmedSource = source.trim();

        switch (trimmedSource) {
            case "IFC":
                return "01";
            case "百盛":
                return "02";
            case "保利":
                return "03";
            case "大洋":
                return "04";
            case "丹尼斯":
                return "05";
            case "国贸":
                return "06";
            case "汉商":
                return "07";
            case "华润":
                return "08";
            case "环球港":
                return "09";
            case "荟聚":
                return "10";
            case "金鹰":
                return "11";
            case "凯德":
                return "12";
            case "龙湖":
                return "13";
            case "摩尔城":
                return "14";
            case "其他":
                return "15";
            case "杉杉奥莱":
                return "16";
            case "苏宁":
                return "17";
            case "天虹":
                return "18";
            case "万达":
                return "19";
            case "万象":
                return "20";
            case "万象城":
                return "21";
            case "万象汇":
                return "22";
            case "王府井":
                return "23";
            case "微信":
                return "24";
            case "微信小程序":
                return "25";
            case "吾悦":
                return "26";
            case "武商":
                return "27";
            case "武商奥莱":
                return "28";
            case "银泰":
                return "29";
            case "永旺":
                return "30";
            case "中百":
                return "31";
            case "中商":
                return "32";
            default:
                // 如果所有 case 都不匹配，返回默认值
                return "00";
        }
    }
    @Mappings({
            @Mapping(target = "id", expression = "java(com.baomidou.mybatisplus.core.toolkit.IdWorker.getId())"),
            @Mapping(source = "shopCode", target = "shopCode"),
            @Mapping(source = "shopName", target = "shopName"),
            @Mapping(source = "categoryCode", target = "categoryCode",qualifiedByName = "mapCategoryCode"),
            @Mapping(source = "typeCode", target = "typeCode",qualifiedByName = "mapTypeCode"),
            @Mapping(source = "regionCode", target = "regionCode"),
            @Mapping(source = "regionName", target = "regionName"),
            @Mapping(source = "provinceCode", target = "provinceCode"),
            @Mapping(source = "provinceName", target = "provinceName"),
            @Mapping(source = "cityCode", target = "cityCode"),
            @Mapping(source = "cityName", target = "cityName"),


            @Mapping(target = "manageMode", expression = "java(dto.getManageMode() != null && dto.getManageMode().equals(\"分公司\") ? \"01\" : \"02\")"),

            @Mapping(target = "shopChannelType", constant = "0"),

            @Mapping(source = "paymentMode", target = "paymentMode"),

            @Mapping(source = "paymentCycle", target = "paymentCycle"),

            @Mapping(source = "profitSplitRate", target = "profitSplitRate"),


            @Mapping(source = "extendJsonField", target = "extendJsonField"),

            @Mapping(source = "remark", target = "remark"),

            @Mapping(source = "isActive", target = "isActive"),

            @Mapping(target = "tenantCode", constant = "MR184301"),
            @Mapping(target = "yqsOrgCode", source = "shopCode"),

            @Mapping(target = "version", constant = "1"),

            @Mapping(target = "createTime", expression = "java(java.time.LocalDateTime.now())"),
            @Mapping(target = "updateTime", expression = "java(java.time.LocalDateTime.now())"),

            @Mapping(target = "creator", constant = "111L"),
            @Mapping(target = "updater", constant = "111L")
    })
    Shop toShop(ShopExcelDTO dto);


    @Mappings({


            @Mapping(target = "id", expression = "java(com.baomidou.mybatisplus.core.toolkit.IdWorker.getId())"),
            @Mapping(source = "shopCode", target = "shopCode"),
            @Mapping(target = "tenantCode", constant = "MR184301"),
            // 品牌
            @Mapping(source = "brandType", target = "brandType",qualifiedByName = "mapBrandType"),
            // 账套
            @Mapping(source = "ledgerType", target = "ledgerType",qualifiedByName = "mapLedgerType"),
            // 租赁类型
            @Mapping(source = "leaseType", target = "leaseType",qualifiedByName = "mapLeaseType"),
            // 渠道定位
            @Mapping(source = "channelSalesPositionType", target = "channelSalesPositionType",qualifiedByName = "mapChannelSalesPositionType"),
            // 商场体系
            @Mapping(source = "mallType", target = "mallType",qualifiedByName = "mapMallType"),


            @Mapping(source = "firstLevelRegionType", target = "firstLevelRegionType",qualifiedByName = "mapFirstLevelRegionType"),

            @Mapping(source = "secondLevelRegionType", target = "secondLevelRegionType",qualifiedByName = "mapSecondLevelRegionType"),
            // 城市级别
            @Mapping(source = "cityLevel", target = "cityLevel",qualifiedByName = "mapCityLevel"),

            // 负责人信息
            @Mapping(source = "regionLeader", target = "regionLeader"),
            @Mapping(source = "operationLeader", target = "operationLeader"),
            @Mapping(source = "productLeader", target = "productLeader"),

            // 店铺形象
            @Mapping(source = "shopImageType", target = "shopImageType",qualifiedByName = "mapShopImageTypeEnum"),
            // 店铺等级0
            @Mapping(source = "shopGrade", target = "shopGrade"),

            // 开业时间
            @Mapping(source = "openTime", target = "openTime"),
            // 关闭时间
            @Mapping(source = "closeTime", target = "closeTime"),

            // 拓展类型
            @Mapping(source = "shopExtensionType", target = "shopExtensionType",qualifiedByName = "mapShopExtensionType"),
            // 楼层
            @Mapping(source = "floor", target = "floor"),
            // 店铺位置
            @Mapping(source = "position", target = "position"),

            // 面积信息
            @Mapping(source = "totalArea", target = "totalArea"),
            @Mapping(source = "salesArea", target = "salesArea"),
            @Mapping(source = "warehouseArea", target = "warehouseArea"),

            // 员工人数
            @Mapping(source = "staffNum", target = "staffNum"),
            // 增值税税率
//            @Mapping(source = "vatRate", target = "vatRate",qualifiedByName = "mapVatRate"),

            // 费用信息
            @Mapping(source = "monthlyRentAmount", target = "monthlyRentAmount"),
            @Mapping(source = "monthlyPropertyAmount", target = "monthlyPropertyAmount"),
            @Mapping(source = "waterElectricityAmount", target = "waterElectricityAmount"),
            @Mapping(source = "mallFixedCostAmount", target = "mallFixedCostAmount"),
            @Mapping(source = "otherFixedCostAmount", target = "otherFixedCostAmount"),
            @Mapping(source = "mallFloatCostAmount", target = "mallFloatCostAmount"),

            // 合同与分利
            @Mapping(source = "contractDeductionRate", target = "contractDeductionRate"),
            @Mapping(source = "franchiseeProfitSplitRate", target = "franchiseeProfitSplitRate"),
            // 降扣比例
            @Mapping(source = "franchiseeDeductionRate", target = "franchiseeDeductionRate"),

            // 保底销售
            @Mapping(source = "guaranteeSalesAmount", target = "guaranteeSalesAmount"),
            @Mapping(source = "guaranteePeriod", target = "guaranteePeriod"),
            @Mapping(source = "guaranteeFirstYearSalesAmount", target = "guaranteeFirstYearSalesAmount"),

            // 改造相关
            @Mapping(source = "transformType", target = "transformType"),
            @Mapping(source = "lastTransformTime", target = "lastTransformTime"),
            @Mapping(source = "transformStartTime", target = "transformStartTime"),
            @Mapping(source = "transformEndTime", target = "transformEndTime"),
            @Mapping(source = "transformPeriod", target = "transformPeriod"),
            @Mapping(source = "transformTotalArea", target = "transformTotalArea"),
            @Mapping(source = "transformSalesArea", target = "transformSalesArea"),
            @Mapping(source = "transformWarehouseArea", target = "transformWarehouseArea"),

            // 新店费用摊销
            @Mapping(source = "newStoreBaseInstallmentAmount", target = "newStoreBaseInstallmentAmount"),
            @Mapping(source = "newStorePropInstallmentAmount", target = "newStorePropInstallmentAmount"),
            @Mapping(source = "newStoreMarketExpansionAmount", target = "newStoreMarketExpansionAmount"),
            @Mapping(source = "newStoreCardFeeAmount", target = "newStoreCardFeeAmount"),
            @Mapping(source = "newStoreLogisticsAmount", target = "newStoreLogisticsAmount"),
            @Mapping(source = "newStoreOtherAmount", target = "newStoreOtherAmount"),

            // 加盟商信息
            @Mapping(source = "franchiseeName", target = "franchiseeName"),

            // 合同时间
            @Mapping(source = "contractStartTime", target = "contractStartTime"),
            @Mapping(source = "contractEndTime", target = "contractEndTime"),
            // 合同周期月
            @Mapping(source = "contractPeriodMonth", target = "contractPeriodMonth"),

            // 收银方式
            @Mapping(source = "checkoutMethod", target = "checkoutMethod",qualifiedByName = "mapCheckoutMethod"),

            // 用友系统字段（大量）
            @Mapping(source = "yonyouDepartmentCode", target = "yonyouDepartmentCode"),
            @Mapping(source = "yonyouDepartmentName", target = "yonyouDepartmentName"),
            @Mapping(source = "yonyouMallCode", target = "yonyouMallCode"),
            @Mapping(source = "yonyouMallName", target = "yonyouMallName"),
            @Mapping(source = "yonyouFranchiseeCode", target = "yonyouFranchiseeCode"),
            @Mapping(source = "yonyouFranchiseeName", target = "yonyouFranchiseeName"),
            @Mapping(source = "yonyouCompanyCode", target = "yonyouCompanyCode"),
            @Mapping(source = "yonyouCompanyName", target = "yonyouCompanyName"),
            @Mapping(source = "yonyouLiveBusinessShopTypeCode", target = "yonyouLiveBusinessShopTypeCode"),
            @Mapping(source = "yonyouLiveBusinessShopTypeName", target = "yonyouLiveBusinessShopTypeName"),
            @Mapping(source = "yonyouFinancialLeaderMobile", target = "yonyouFinancialLeaderMobile"),
            @Mapping(source = "yonyouHeadCompanyCode", target = "yonyouHeadCompanyCode"),
            @Mapping(source = "yonyouBranchCompanyCode", target = "yonyouBranchCompanyCode"),
            @Mapping(source = "yonyouPreparer", target = "yonyouPreparer"),

            // =========================
            // 特殊字段处理（DTO 中被 @ExcelIgnore）
            // =========================

            // 运营负责人工号：DTO 中被 @ExcelIgnore，但字段存在
            @Mapping(source = "operationLeaderEmployeeId", target = "operationLeaderEmployeeId"),
            // 证件号码
            @Mapping(source = "certNum", target = "certNum"),
            // 加盟商账户
            @Mapping(source = "franchiseeAccountNo", target = "franchiseeAccountNo"),
            // 主合同编号
            @Mapping(source = "fdMainContractId", target = "fdMainContractId"),

            // =========================
            // 自动填充字段（非来自 Excel）
            // =========================

            // 有效状态：假设与 Shop 一致
            @Mapping(target = "isActive", expression = "java(dto.getIsActive() != null ? dto.getIsActive() : \"1\")"),
            // 版本号
            @Mapping(target = "version", constant = "1"),
            // 创建者
            @Mapping(target = "creator", constant = "111L"),
            // 创建时间
            @Mapping(target = "createTime", expression = "java(java.time.LocalDateTime.now())"),
            // 更新者
            @Mapping(target = "updater", constant = "111L"),
            // 更新时间
            @Mapping(target = "updateTime", expression = "java(java.time.LocalDateTime.now())"),

            // 备注（虽然 DTO 中被 @ExcelIgnore，但字段存在）
            @Mapping(source = "remark", target = "remark")
    })
    ShopExtend toShopExtend(ShopExcelDTO dto);
}
