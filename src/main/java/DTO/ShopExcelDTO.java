package DTO;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import java.io.Serializable;

/**
 * 猫人-店铺信息扩展表
 */
public class ShopExcelDTO implements Serializable {


    /**
     * 主键
     */
//    @ExcelProperty("主键")
    @ExcelIgnore
    private Long id;

    /**
     * 企业编码
     */
//    @ExcelProperty("企业编码")
    @ExcelIgnore
    private String tenantCode;

    /**
     * 易企收组织编码，预留扩展字段，目前为店铺代码，对应organization.org_code
     */
//    @ExcelProperty("易企收组织编码")
    @ExcelIgnore
    private String yqsOrgCode;

    /**
     * 店铺代码，E3取：代码，唯一键
     */
    @ExcelProperty("店铺编码")
    private String shopCode;

    /**
     * 店铺名称，E3取：名称
     */
    @ExcelProperty("店铺名称")
    private String shopName;

    /**
     * 类别，TODO-
     */
    @ExcelProperty("类别")
    private String categoryCode;

    /**
     * 店铺类型，TODO-
     */
    @ExcelProperty("店铺类型")
    private String typeCode;

    /**
     * 战区code，E3取：营销区域代码
     */
    @ExcelProperty("战区编码")
    private String regionCode;

    /**
     * 战区名称
     */
    @ExcelProperty("战区名称")
    private String regionName;

    /**
     * 省份code，E3取：省，省市区
     */
    @ExcelProperty("省份编码")
    private String provinceCode;

    /**
     * 省份名称
     */
    @ExcelProperty("省份名称")
    private String provinceName;

    /**
     * 城市code，E3取：市
     */
    @ExcelProperty("城市编码")
    private String cityCode;

    /**
     * 城市名称
     */
    @ExcelProperty("城市名称")
    private String cityName;

    /**
     * 易企收系统内配置，管理模式，对应企业个性字典-ManageModeEnum，该字段用于区分是否需要出往来款凭证
     */
    // TODO 管理员？
    @ExcelProperty("管理方")
    private String manageMode;

    /**
     * 易企收系统内配置，门店渠道类型，对应企业个性字典-ShopChannelTypeEnum，该字段用于区分这个门店使用哪一类对账模式
     */
    @ExcelProperty("门店渠道类型")
    private String shopChannelType;

    /**
     * 缴款模式，对应企业个性字典-PaymentModeEnum，联营用于区分全额、半额
     */
    @ExcelProperty("缴款模式")
    private String paymentMode;

    /**
     * 缴款周期，对应企业个性字典-PaymentCycleEnum，每日、每10日、每月，联营缴款单管理、罚单管理等场景使用
     */
    @ExcelProperty("缴款周期")
    private String paymentCycle;

    /**
     * 分利比例，保留2位小数。联营计算分利数据时使用
     */
//    @ExcelProperty("分利比例")
    @ExcelIgnore
    private BigDecimal profitSplitRate;

    /**
     * 易企收系统内配置，json格式扩展字段
     */
//    @ExcelProperty("扩展字段")
    @ExcelIgnore
    private String extendJsonField;

    /**
     * 备注
     */
//    @ExcelProperty("备注")
    @ExcelIgnore
    private String remark;

    /**
     * 有效状态(1-有效; 0-无效)
     */
    // TODO 状态？
    @ExcelProperty("状态")
    private String isActive;

    /**
     * 数据版本号
     */
//    @ExcelProperty("数据版本号")
    @ExcelIgnore
    private Integer version;

    /**
     * 创建者
     */
//    @ExcelProperty("创建者")
    @ExcelIgnore
    private Long creator;

    /**
     * 创建时间
     */
//    @ExcelProperty("创建时间")
    @ExcelIgnore
    @DateTimeFormat("yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 更新者
     */
//    @ExcelProperty("更新者")
    @ExcelIgnore
    private Long updater;

    /**
     * 更新时间
     */
//    @ExcelProperty("更新时间")
    @ExcelIgnore
    @DateTimeFormat("yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;





    /**
     * 品牌（字典：BrandTypeEnum）
     */
    @ExcelProperty("品牌")
    private String brandType;

    /**
     * 账套（字典：LedgerTypeEnum）
     */
    @ExcelProperty("账套")
    private String ledgerType;

    /**
     * 租赁类型（字典：LeaseTypeEnum）
     */
    @ExcelProperty("租赁类型")
    private String leaseType;

    /**
     * 渠道定位（字典：ChannelSalesPositionTypeEnum）
     */
    @ExcelProperty("渠道定位")
    private String channelSalesPositionType;

    /**
     * 商场体系（字典：MallTypeEnum）
     */
    @ExcelProperty("商场体系")
    private String mallType;

    /**
     * 一级大区（字典：FirstLevelRegionTypeEnum）
     */
    @ExcelProperty("一级大区")
    private String firstLevelRegionType;

    /**
     * 二级大区（字典：SecondLevelRegionTypeEnum）
     */
    @ExcelProperty("二级大区")
    private String secondLevelRegionType;

    /**
     * 城市级别（字典：CityLevelEnum）
     */
    @ExcelProperty("城市级别")
    private String cityLevel;

    /**
     * 大区负责人
     */
    @ExcelProperty("大区负责人")
    private String regionLeader;

    /**
     * 运营负责人
     */
    @ExcelProperty("运营负责人")
    private String operationLeader;

    /**
     * 运营负责人工号，推送易快报需要
     */
    //TODO 没有
//    @ExcelProperty("运营负责人工号")
    @ExcelIgnore
    private String operationLeaderEmployeeId;

    /**
     * 商品负责人
     */
    @ExcelProperty("商品负责人")
    private String productLeader;

    /**
     * 证件号码，统一社会信用代码/身份证号，推送蓝凌合同系统需要传到相对方ID
     */
    //TODO 没有
//    @ExcelProperty("证件号码")
    @ExcelIgnore
    private String certNum;

    /**
     * 店铺形象（字典：ShopImageTypeEnum）
     */
    @ExcelProperty("店铺形象")
    private String shopImageType;

    /**
     * 店铺等级
     */
    @ExcelProperty("店铺等级")
    private String shopGrade;

    /**
     * 开业时间
     */
    @ExcelProperty("开业时间")
    @DateTimeFormat("yyyy-MM-dd HH:mm:ss")
    private LocalDateTime openTime;

    /**
     * 关闭时间
     */
    @ExcelProperty("关闭时间")
    @DateTimeFormat("yyyy-MM-dd HH:mm:ss")
    private LocalDateTime closeTime;

    /**
     * 拓展类型（字典：ShopExtensionTypeEnum）
     */
    @ExcelProperty("拓展类型")
    private String shopExtensionType;

    /**
     * 楼层
     */
    @ExcelProperty("楼层")
    private String floor;

    /**
     * 店铺位置
     */
    @ExcelProperty("店铺位置")
    private String position;

    /**
     * 总面积（㎡）
     */
    @ExcelProperty("总面积")
    private BigDecimal totalArea;

    /**
     * 卖场面积（㎡）
     */
    @ExcelProperty("卖场面积")
    private BigDecimal salesArea;

    /**
     * 仓库面积（㎡）
     */
    @ExcelProperty("仓库面积")
    private BigDecimal warehouseArea;

    /**
     * 员工人数
     */
    @ExcelProperty("员工人数")
    private Integer staffNum;

    /**
     * 增值税税率（%），只允许输入＞0的整数
     */
    @ExcelProperty("增值税税率")
    private Integer vatRate;

    /**
     * 月租金（元）
     */
    @ExcelProperty("月租金")
    private BigDecimal monthlyRentAmount;

    /**
     * 月物业费（元）
     */
    @ExcelProperty("月物业费")
    private BigDecimal monthlyPropertyAmount;

    /**
     * 合同扣率（%），保留2位小数
     */
    @ExcelProperty("合同扣率")
    private BigDecimal contractDeductionRate;

    /**
     * 加盟商分利比（%），保留2位小数
     */
    @ExcelProperty("加盟商分利比")
    private BigDecimal franchiseeProfitSplitRate;

    /**
     * O2O技术服务费承担比，单位：％，只允许输入【0,100】的整数。联营专用，渠道为联营必填
     */
//    @ExcelProperty("O2O技术服务费承担比（%）")
    @ExcelIgnore
    private Integer o2oTechnicalServiceFeeRate;

    /**
     * O2O代运营服务费承担比，单位：％，只允许输入【0,100】的整数。联营专用，渠道为联营必填
     */
//    @ExcelProperty("O2O代运营服务费承担比（%）")
    @ExcelIgnore
    private Integer o2oOperationServiceFeeRate;

    /**
     * 水电费（元）
     */
    @ExcelProperty("水电费")
    private BigDecimal waterElectricityAmount;

    /**
     * 商场固定费用（元）
     */
    @ExcelProperty("商场固定费用")
    private BigDecimal mallFixedCostAmount;

    /**
     * 其他固定费用（元）
     */
    @ExcelProperty("其他固定费用")
    private BigDecimal otherFixedCostAmount;

    /**
     * 商场浮动费用（元）
     */
    @ExcelProperty("商场浮动费用")
    private BigDecimal mallFloatCostAmount;

    /**
     * 保底销售流水（元）
     */
    @ExcelProperty("保底销售流水")
    private BigDecimal guaranteeSalesAmount;

    /**
     * 保底期间要求（字典：GuaranteePeriodEnum）
     */
    @ExcelProperty("保底期间要求")
    private String guaranteePeriod;

    /**
     * 报店第一年目标（元）
     */
    @ExcelProperty("报店第一年目标")
    private BigDecimal guaranteeFirstYearSalesAmount;

    /**
     * 改造类型
     */
    @ExcelProperty("改造类型")
    private String transformType;

    /**
     * 上次改造时间
     */
    @ExcelProperty("上次改造时间")
    @DateTimeFormat("yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastTransformTime;

    /**
     * 改造开始时间
     */
    @ExcelProperty("改造开始时间")
    @DateTimeFormat("yyyy-MM-dd HH:mm:ss")
    private LocalDateTime transformStartTime;

    /**
     * 改造结束时间
     */
    @ExcelProperty("改造结束时间")
    @DateTimeFormat("yyyy-MM-dd HH:mm:ss")
    private LocalDateTime transformEndTime;

    /**
     * 改造周期
     */
    @ExcelProperty("改造周期")
    private String transformPeriod;

    /**
     * 改造后总面积（㎡）
     */
    @ExcelProperty("改造后总面积")
    private BigDecimal transformTotalArea;

    /**
     * 改造后卖场面积（㎡）
     */
    @ExcelProperty("改造后卖场面积")
    private BigDecimal transformSalesArea;

    /**
     * 改造后仓库面积（㎡）
     */
    @ExcelProperty("改造后仓库面积")
    private BigDecimal transformWarehouseArea;

    /**
     * 新店基装摊销（元）
     */
    @ExcelProperty("新店基装摊销")
    private BigDecimal newStoreBaseInstallmentAmount;

    /**
     * 新店道具摊销（元）
     */
    @ExcelProperty("新店道具摊销")
    private BigDecimal newStorePropInstallmentAmount;

    /**
     * 新店市场拓展费（元）
     */
    @ExcelProperty("新店市场拓展费")
    private BigDecimal newStoreMarketExpansionAmount;

    /**
     * 新店刷卡手续费（元）
     */
    @ExcelProperty("新店刷卡手续费")
    private BigDecimal newStoreCardFeeAmount;

    /**
     * 新店物流费（元）
     */
    @ExcelProperty("新店物流费")
    private BigDecimal newStoreLogisticsAmount;

    /**
     * 新店其他费用（元）
     */
    @ExcelProperty("新店其他费用")
    private BigDecimal newStoreOtherAmount;

    /**
     * 加盟商名称
     */
    @ExcelProperty("加盟商名称")
    private String franchiseeName;

    /**
     * 加盟商账户，推送易快报需要
     */
    //TODO 没有
//    @ExcelProperty("加盟商账户")
    @ExcelIgnore
    private String franchiseeAccountNo;

    /**
     * 主合同编号
     */
    //TODO 没有
//    @ExcelProperty("主合同编号")
    @ExcelIgnore
    private String fdMainContractId;

    /**
     * 降扣比例（%），只允许输入＞0的整数
     */
    @ExcelProperty("降扣比例")
    private Integer franchiseeDeductionRate;

    /**
     * 合同开始时间
     */
    //TODO  没用到
    @ExcelProperty("合同开始时间")
    @DateTimeFormat("yyyy-MM-dd HH:mm:ss")
    private LocalDateTime contractStartTime;

    /**
     * 合同结束时间
     */
    // TODO 没用到
    @ExcelProperty("合同结束时间")
    @DateTimeFormat("yyyy-MM-dd HH:mm:ss")
    private LocalDateTime contractEndTime;

    /**
     * 合同周期月
     */
    @ExcelProperty("合同周期月")
    private String contractPeriodMonth;

    /**
     * 收银方式（字典：CheckoutMethodEnum）
     */
    @ExcelProperty("收银方式")
    private String checkoutMethod;

    /**
     * 用友部门代码
     */
    @ExcelProperty("用友部门代码")
    private String yonyouDepartmentCode;

    /**
     * 用友部门名称
     */
    @ExcelProperty("用友部门名称")
    private String yonyouDepartmentName;

    /**
     * 用友商场代码
     */
    @ExcelProperty("用友商场代码")
    private String yonyouMallCode;

    /**
     * 用友商场名称
     */
    @ExcelProperty("用友商场名称")
    private String yonyouMallName;

    /**
     * 用友加盟商代码
     */
    @ExcelProperty("用友加盟商代码")
    private String yonyouFranchiseeCode;

    /**
     * 用友加盟商名称
     */
    @ExcelProperty("用友加盟商名称")
    private String yonyouFranchiseeName;

    /**
     * 用友公司代码
     */
    @ExcelProperty("用友公司代码")
    private String yonyouCompanyCode;

    /**
     * 用友公司名称
     */
    @ExcelProperty("用友公司名称")
    private String yonyouCompanyName;

    /**
     * 用友直播业务/店铺类型代码
     */
    @ExcelProperty("用友直播业务/店铺类型代码")
    private String yonyouLiveBusinessShopTypeCode;

    /**
     * 用友直播业务/店铺类型名称
     */
    @ExcelProperty("用友直播业务/店铺类型名称")
    private String yonyouLiveBusinessShopTypeName;

    /**
     * 用友财务负责人手机号
     */
    @ExcelProperty("用友财务负责人手机号")
    private String yonyouFinancialLeaderMobile;

    /**
     * 用友总公司
     */
    @ExcelProperty("用友总公司")
    private String yonyouHeadCompanyCode;

    /**
     * 用友分公司
     */
    @ExcelProperty("用友分公司")
    private String yonyouBranchCompanyCode;

    /**
     * 用友制单人
     */
    @ExcelProperty("用友制单人")
    private String yonyouPreparer;






















    public String getBrandType() {
        return brandType;
    }

    public void setBrandType(String brandType) {
        this.brandType = brandType;
    }

    public String getLedgerType() {
        return ledgerType;
    }

    public void setLedgerType(String ledgerType) {
        this.ledgerType = ledgerType;
    }

    public String getLeaseType() {
        return leaseType;
    }

    public void setLeaseType(String leaseType) {
        this.leaseType = leaseType;
    }

    public String getChannelSalesPositionType() {
        return channelSalesPositionType;
    }

    public void setChannelSalesPositionType(String channelSalesPositionType) {
        this.channelSalesPositionType = channelSalesPositionType;
    }

    public String getMallType() {
        return mallType;
    }

    public void setMallType(String mallType) {
        this.mallType = mallType;
    }

    public String getFirstLevelRegionType() {
        return firstLevelRegionType;
    }

    public void setFirstLevelRegionType(String firstLevelRegionType) {
        this.firstLevelRegionType = firstLevelRegionType;
    }

    public String getSecondLevelRegionType() {
        return secondLevelRegionType;
    }

    public void setSecondLevelRegionType(String secondLevelRegionType) {
        this.secondLevelRegionType = secondLevelRegionType;
    }

    public String getCityLevel() {
        return cityLevel;
    }

    public void setCityLevel(String cityLevel) {
        this.cityLevel = cityLevel;
    }

    public String getRegionLeader() {
        return regionLeader;
    }

    public void setRegionLeader(String regionLeader) {
        this.regionLeader = regionLeader;
    }

    public String getOperationLeader() {
        return operationLeader;
    }

    public void setOperationLeader(String operationLeader) {
        this.operationLeader = operationLeader;
    }

    public String getOperationLeaderEmployeeId() {
        return operationLeaderEmployeeId;
    }

    public void setOperationLeaderEmployeeId(String operationLeaderEmployeeId) {
        this.operationLeaderEmployeeId = operationLeaderEmployeeId;
    }

    public String getProductLeader() {
        return productLeader;
    }

    public void setProductLeader(String productLeader) {
        this.productLeader = productLeader;
    }

    public String getCertNum() {
        return certNum;
    }

    public void setCertNum(String certNum) {
        this.certNum = certNum;
    }

    public String getShopImageType() {
        return shopImageType;
    }

    public void setShopImageType(String shopImageType) {
        this.shopImageType = shopImageType;
    }

    public String getShopGrade() {
        return shopGrade;
    }

    public void setShopGrade(String shopGrade) {
        this.shopGrade = shopGrade;
    }

    public LocalDateTime getOpenTime() {
        return openTime;
    }

    public void setOpenTime(LocalDateTime openTime) {
        this.openTime = openTime;
    }

    public LocalDateTime getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(LocalDateTime closeTime) {
        this.closeTime = closeTime;
    }

    public String getShopExtensionType() {
        return shopExtensionType;
    }

    public void setShopExtensionType(String shopExtensionType) {
        this.shopExtensionType = shopExtensionType;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public BigDecimal getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(BigDecimal totalArea) {
        this.totalArea = totalArea;
    }

    public BigDecimal getSalesArea() {
        return salesArea;
    }

    public void setSalesArea(BigDecimal salesArea) {
        this.salesArea = salesArea;
    }

    public BigDecimal getWarehouseArea() {
        return warehouseArea;
    }

    public void setWarehouseArea(BigDecimal warehouseArea) {
        this.warehouseArea = warehouseArea;
    }

    public Integer getStaffNum() {
        return staffNum;
    }

    public void setStaffNum(Integer staffNum) {
        this.staffNum = staffNum;
    }


    public BigDecimal getMonthlyRentAmount() {
        return monthlyRentAmount;
    }

    public void setMonthlyRentAmount(BigDecimal monthlyRentAmount) {
        this.monthlyRentAmount = monthlyRentAmount;
    }

    public BigDecimal getMonthlyPropertyAmount() {
        return monthlyPropertyAmount;
    }

    public void setMonthlyPropertyAmount(BigDecimal monthlyPropertyAmount) {
        this.monthlyPropertyAmount = monthlyPropertyAmount;
    }

    public BigDecimal getContractDeductionRate() {
        return contractDeductionRate;
    }

    public void setContractDeductionRate(BigDecimal contractDeductionRate) {
        this.contractDeductionRate = contractDeductionRate;
    }

    public BigDecimal getFranchiseeProfitSplitRate() {
        return franchiseeProfitSplitRate;
    }

    public void setFranchiseeProfitSplitRate(BigDecimal franchiseeProfitSplitRate) {
        this.franchiseeProfitSplitRate = franchiseeProfitSplitRate;
    }



    public BigDecimal getWaterElectricityAmount() {
        return waterElectricityAmount;
    }

    public void setWaterElectricityAmount(BigDecimal waterElectricityAmount) {
        this.waterElectricityAmount = waterElectricityAmount;
    }

    public BigDecimal getMallFixedCostAmount() {
        return mallFixedCostAmount;
    }

    public void setMallFixedCostAmount(BigDecimal mallFixedCostAmount) {
        this.mallFixedCostAmount = mallFixedCostAmount;
    }

    public BigDecimal getOtherFixedCostAmount() {
        return otherFixedCostAmount;
    }

    public void setOtherFixedCostAmount(BigDecimal otherFixedCostAmount) {
        this.otherFixedCostAmount = otherFixedCostAmount;
    }

    public BigDecimal getMallFloatCostAmount() {
        return mallFloatCostAmount;
    }

    public void setMallFloatCostAmount(BigDecimal mallFloatCostAmount) {
        this.mallFloatCostAmount = mallFloatCostAmount;
    }

    public BigDecimal getGuaranteeSalesAmount() {
        return guaranteeSalesAmount;
    }

    public void setGuaranteeSalesAmount(BigDecimal guaranteeSalesAmount) {
        this.guaranteeSalesAmount = guaranteeSalesAmount;
    }

    public String getGuaranteePeriod() {
        return guaranteePeriod;
    }

    public void setGuaranteePeriod(String guaranteePeriod) {
        this.guaranteePeriod = guaranteePeriod;
    }

    public BigDecimal getGuaranteeFirstYearSalesAmount() {
        return guaranteeFirstYearSalesAmount;
    }

    public void setGuaranteeFirstYearSalesAmount(BigDecimal guaranteeFirstYearSalesAmount) {
        this.guaranteeFirstYearSalesAmount = guaranteeFirstYearSalesAmount;
    }

    public String getTransformType() {
        return transformType;
    }

    public void setTransformType(String transformType) {
        this.transformType = transformType;
    }

    public LocalDateTime getLastTransformTime() {
        return lastTransformTime;
    }

    public void setLastTransformTime(LocalDateTime lastTransformTime) {
        this.lastTransformTime = lastTransformTime;
    }

    public LocalDateTime getTransformStartTime() {
        return transformStartTime;
    }

    public void setTransformStartTime(LocalDateTime transformStartTime) {
        this.transformStartTime = transformStartTime;
    }

    public LocalDateTime getTransformEndTime() {
        return transformEndTime;
    }

    public void setTransformEndTime(LocalDateTime transformEndTime) {
        this.transformEndTime = transformEndTime;
    }

    public String getTransformPeriod() {
        return transformPeriod;
    }

    public void setTransformPeriod(String transformPeriod) {
        this.transformPeriod = transformPeriod;
    }

    public BigDecimal getTransformTotalArea() {
        return transformTotalArea;
    }

    public void setTransformTotalArea(BigDecimal transformTotalArea) {
        this.transformTotalArea = transformTotalArea;
    }

    public BigDecimal getTransformSalesArea() {
        return transformSalesArea;
    }

    public void setTransformSalesArea(BigDecimal transformSalesArea) {
        this.transformSalesArea = transformSalesArea;
    }

    public BigDecimal getTransformWarehouseArea() {
        return transformWarehouseArea;
    }

    public void setTransformWarehouseArea(BigDecimal transformWarehouseArea) {
        this.transformWarehouseArea = transformWarehouseArea;
    }

    public BigDecimal getNewStoreBaseInstallmentAmount() {
        return newStoreBaseInstallmentAmount;
    }

    public void setNewStoreBaseInstallmentAmount(BigDecimal newStoreBaseInstallmentAmount) {
        this.newStoreBaseInstallmentAmount = newStoreBaseInstallmentAmount;
    }

    public BigDecimal getNewStorePropInstallmentAmount() {
        return newStorePropInstallmentAmount;
    }

    public void setNewStorePropInstallmentAmount(BigDecimal newStorePropInstallmentAmount) {
        this.newStorePropInstallmentAmount = newStorePropInstallmentAmount;
    }

    public BigDecimal getNewStoreMarketExpansionAmount() {
        return newStoreMarketExpansionAmount;
    }

    public void setNewStoreMarketExpansionAmount(BigDecimal newStoreMarketExpansionAmount) {
        this.newStoreMarketExpansionAmount = newStoreMarketExpansionAmount;
    }

    public BigDecimal getNewStoreCardFeeAmount() {
        return newStoreCardFeeAmount;
    }

    public void setNewStoreCardFeeAmount(BigDecimal newStoreCardFeeAmount) {
        this.newStoreCardFeeAmount = newStoreCardFeeAmount;
    }

    public BigDecimal getNewStoreLogisticsAmount() {
        return newStoreLogisticsAmount;
    }

    public void setNewStoreLogisticsAmount(BigDecimal newStoreLogisticsAmount) {
        this.newStoreLogisticsAmount = newStoreLogisticsAmount;
    }

    public BigDecimal getNewStoreOtherAmount() {
        return newStoreOtherAmount;
    }

    public void setNewStoreOtherAmount(BigDecimal newStoreOtherAmount) {
        this.newStoreOtherAmount = newStoreOtherAmount;
    }

    public String getFranchiseeName() {
        return franchiseeName;
    }

    public void setFranchiseeName(String franchiseeName) {
        this.franchiseeName = franchiseeName;
    }

    public String getFranchiseeAccountNo() {
        return franchiseeAccountNo;
    }

    public void setFranchiseeAccountNo(String franchiseeAccountNo) {
        this.franchiseeAccountNo = franchiseeAccountNo;
    }



    public LocalDateTime getContractStartTime() {
        return contractStartTime;
    }

    public void setContractStartTime(LocalDateTime contractStartTime) {
        this.contractStartTime = contractStartTime;
    }

    public LocalDateTime getContractEndTime() {
        return contractEndTime;
    }

    public void setContractEndTime(LocalDateTime contractEndTime) {
        this.contractEndTime = contractEndTime;
    }



    public String getCheckoutMethod() {
        return checkoutMethod;
    }

    public void setCheckoutMethod(String checkoutMethod) {
        this.checkoutMethod = checkoutMethod;
    }

    public String getYonyouDepartmentCode() {
        return yonyouDepartmentCode;
    }

    public void setYonyouDepartmentCode(String yonyouDepartmentCode) {
        this.yonyouDepartmentCode = yonyouDepartmentCode;
    }

    public String getYonyouDepartmentName() {
        return yonyouDepartmentName;
    }

    public void setYonyouDepartmentName(String yonyouDepartmentName) {
        this.yonyouDepartmentName = yonyouDepartmentName;
    }

    public String getYonyouMallCode() {
        return yonyouMallCode;
    }

    public void setYonyouMallCode(String yonyouMallCode) {
        this.yonyouMallCode = yonyouMallCode;
    }

    public String getYonyouMallName() {
        return yonyouMallName;
    }

    public void setYonyouMallName(String yonyouMallName) {
        this.yonyouMallName = yonyouMallName;
    }

    public String getYonyouFranchiseeCode() {
        return yonyouFranchiseeCode;
    }

    public void setYonyouFranchiseeCode(String yonyouFranchiseeCode) {
        this.yonyouFranchiseeCode = yonyouFranchiseeCode;
    }

    public String getYonyouFranchiseeName() {
        return yonyouFranchiseeName;
    }

    public void setYonyouFranchiseeName(String yonyouFranchiseeName) {
        this.yonyouFranchiseeName = yonyouFranchiseeName;
    }

    public String getYonyouCompanyCode() {
        return yonyouCompanyCode;
    }

    public void setYonyouCompanyCode(String yonyouCompanyCode) {
        this.yonyouCompanyCode = yonyouCompanyCode;
    }

    public String getYonyouCompanyName() {
        return yonyouCompanyName;
    }

    public void setYonyouCompanyName(String yonyouCompanyName) {
        this.yonyouCompanyName = yonyouCompanyName;
    }

    public String getYonyouLiveBusinessShopTypeCode() {
        return yonyouLiveBusinessShopTypeCode;
    }

    public void setYonyouLiveBusinessShopTypeCode(String yonyouLiveBusinessShopTypeCode) {
        this.yonyouLiveBusinessShopTypeCode = yonyouLiveBusinessShopTypeCode;
    }

    public String getYonyouLiveBusinessShopTypeName() {
        return yonyouLiveBusinessShopTypeName;
    }

    public void setYonyouLiveBusinessShopTypeName(String yonyouLiveBusinessShopTypeName) {
        this.yonyouLiveBusinessShopTypeName = yonyouLiveBusinessShopTypeName;
    }

    public String getYonyouFinancialLeaderMobile() {
        return yonyouFinancialLeaderMobile;
    }

    public void setYonyouFinancialLeaderMobile(String yonyouFinancialLeaderMobile) {
        this.yonyouFinancialLeaderMobile = yonyouFinancialLeaderMobile;
    }

    public String getYonyouHeadCompanyCode() {
        return yonyouHeadCompanyCode;
    }

    public void setYonyouHeadCompanyCode(String yonyouHeadCompanyCode) {
        this.yonyouHeadCompanyCode = yonyouHeadCompanyCode;
    }

    public String getYonyouBranchCompanyCode() {
        return yonyouBranchCompanyCode;
    }

    public void setYonyouBranchCompanyCode(String yonyouBranchCompanyCode) {
        this.yonyouBranchCompanyCode = yonyouBranchCompanyCode;
    }

    public String getYonyouPreparer() {
        return yonyouPreparer;
    }

    public void setYonyouPreparer(String yonyouPreparer) {
        this.yonyouPreparer = yonyouPreparer;
    }



    public Integer getVatRate() {
        return vatRate;
    }

    public void setVatRate(Integer vatRate) {
        this.vatRate = vatRate;
    }

    public Integer getO2oTechnicalServiceFeeRate() {
        return o2oTechnicalServiceFeeRate;
    }

    public void setO2oTechnicalServiceFeeRate(Integer o2oTechnicalServiceFeeRate) {
        this.o2oTechnicalServiceFeeRate = o2oTechnicalServiceFeeRate;
    }

    public Integer getO2oOperationServiceFeeRate() {
        return o2oOperationServiceFeeRate;
    }

    public void setO2oOperationServiceFeeRate(Integer o2oOperationServiceFeeRate) {
        this.o2oOperationServiceFeeRate = o2oOperationServiceFeeRate;
    }

    public String getFdMainContractId() {
        return fdMainContractId;
    }

    public void setFdMainContractId(String fdMainContractId) {
        this.fdMainContractId = fdMainContractId;
    }

    public Integer getFranchiseeDeductionRate() {
        return franchiseeDeductionRate;
    }

    public void setFranchiseeDeductionRate(Integer franchiseeDeductionRate) {
        this.franchiseeDeductionRate = franchiseeDeductionRate;
    }

    public String getContractPeriodMonth() {
        return contractPeriodMonth;
    }

    public void setContractPeriodMonth(String contractPeriodMonth) {
        this.contractPeriodMonth = contractPeriodMonth;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }

    public String getYqsOrgCode() {
        return yqsOrgCode;
    }

    public void setYqsOrgCode(String yqsOrgCode) {
        this.yqsOrgCode = yqsOrgCode;
    }

    public String getShopCode() {
        return shopCode;
    }

    public void setShopCode(String shopCode) {
        this.shopCode = shopCode;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getManageMode() {
        return manageMode;
    }

    public void setManageMode(String manageMode) {
        this.manageMode = manageMode;
    }

    public String getShopChannelType() {
        return shopChannelType;
    }

    public void setShopChannelType(String shopChannelType) {
        this.shopChannelType = shopChannelType;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getPaymentCycle() {
        return paymentCycle;
    }

    public void setPaymentCycle(String paymentCycle) {
        this.paymentCycle = paymentCycle;
    }

    public java.math.BigDecimal getProfitSplitRate() {
        return profitSplitRate;
    }

    public void setProfitSplitRate(java.math.BigDecimal profitSplitRate) {
        this.profitSplitRate = profitSplitRate;
    }

    public String getExtendJsonField() {
        return extendJsonField;
    }

    public void setExtendJsonField(String extendJsonField) {
        this.extendJsonField = extendJsonField;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public Long getUpdater() {
        return updater;
    }

    public void setUpdater(Long updater) {
        this.updater = updater;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "ShopExcelDTO{" +
                "id=" + id +
                ", tenantCode='" + tenantCode + '\'' +
                ", yqsOrgCode='" + yqsOrgCode + '\'' +
                ", shopCode='" + shopCode + '\'' +
                ", shopName='" + shopName + '\'' +
                ", categoryCode='" + categoryCode + '\'' +
                ", typeCode='" + typeCode + '\'' +
                ", regionCode='" + regionCode + '\'' +
                ", regionName='" + regionName + '\'' +
                ", provinceCode='" + provinceCode + '\'' +
                ", provinceName='" + provinceName + '\'' +
                ", cityCode='" + cityCode + '\'' +
                ", cityName='" + cityName + '\'' +
                ", manageMode='" + manageMode + '\'' +
                ", shopChannelType='" + shopChannelType + '\'' +
                ", paymentMode='" + paymentMode + '\'' +
                ", paymentCycle='" + paymentCycle + '\'' +
                ", profitSplitRate=" + profitSplitRate +
                ", extendJsonField='" + extendJsonField + '\'' +
                ", remark='" + remark + '\'' +
                ", isActive='" + isActive + '\'' +
                ", version=" + version +
                ", creator=" + creator +
                ", createTime=" + createTime +
                ", updater=" + updater +
                ", updateTime=" + updateTime +
                ", brandType='" + brandType + '\'' +
                ", ledgerType='" + ledgerType + '\'' +
                ", leaseType='" + leaseType + '\'' +
                ", channelSalesPositionType='" + channelSalesPositionType + '\'' +
                ", mallType='" + mallType + '\'' +
                ", firstLevelRegionType='" + firstLevelRegionType + '\'' +
                ", secondLevelRegionType='" + secondLevelRegionType + '\'' +
                ", cityLevel='" + cityLevel + '\'' +
                ", regionLeader='" + regionLeader + '\'' +
                ", operationLeader='" + operationLeader + '\'' +
                ", operationLeaderEmployeeId='" + operationLeaderEmployeeId + '\'' +
                ", productLeader='" + productLeader + '\'' +
                ", certNum='" + certNum + '\'' +
                ", shopImageType='" + shopImageType + '\'' +
                ", shopGrade='" + shopGrade + '\'' +
                ", openTime=" + openTime +
                ", closeTime=" + closeTime +
                ", shopExtensionType='" + shopExtensionType + '\'' +
                ", floor='" + floor + '\'' +
                ", position='" + position + '\'' +
                ", totalArea=" + totalArea +
                ", salesArea=" + salesArea +
                ", warehouseArea=" + warehouseArea +
                ", staffNum=" + staffNum +
                ", vatRate=" + vatRate +
                ", monthlyRentAmount=" + monthlyRentAmount +
                ", monthlyPropertyAmount=" + monthlyPropertyAmount +
                ", contractDeductionRate=" + contractDeductionRate +
                ", franchiseeProfitSplitRate=" + franchiseeProfitSplitRate +
                ", o2oTechnicalServiceFeeRate=" + o2oTechnicalServiceFeeRate +
                ", o2oOperationServiceFeeRate=" + o2oOperationServiceFeeRate +
                ", waterElectricityAmount=" + waterElectricityAmount +
                ", mallFixedCostAmount=" + mallFixedCostAmount +
                ", otherFixedCostAmount=" + otherFixedCostAmount +
                ", mallFloatCostAmount=" + mallFloatCostAmount +
                ", guaranteeSalesAmount=" + guaranteeSalesAmount +
                ", guaranteePeriod='" + guaranteePeriod + '\'' +
                ", guaranteeFirstYearSalesAmount=" + guaranteeFirstYearSalesAmount +
                ", transformType='" + transformType + '\'' +
                ", lastTransformTime=" + lastTransformTime +
                ", transformStartTime=" + transformStartTime +
                ", transformEndTime=" + transformEndTime +
                ", transformPeriod='" + transformPeriod + '\'' +
                ", transformTotalArea=" + transformTotalArea +
                ", transformSalesArea=" + transformSalesArea +
                ", transformWarehouseArea=" + transformWarehouseArea +
                ", newStoreBaseInstallmentAmount=" + newStoreBaseInstallmentAmount +
                ", newStorePropInstallmentAmount=" + newStorePropInstallmentAmount +
                ", newStoreMarketExpansionAmount=" + newStoreMarketExpansionAmount +
                ", newStoreCardFeeAmount=" + newStoreCardFeeAmount +
                ", newStoreLogisticsAmount=" + newStoreLogisticsAmount +
                ", newStoreOtherAmount=" + newStoreOtherAmount +
                ", franchiseeName='" + franchiseeName + '\'' +
                ", franchiseeAccountNo='" + franchiseeAccountNo + '\'' +
                ", fdMainContractId='" + fdMainContractId + '\'' +
                ", franchiseeDeductionRate=" + franchiseeDeductionRate +
                ", contractStartTime=" + contractStartTime +
                ", contractEndTime=" + contractEndTime +
                ", contractPeriodMonth='" + contractPeriodMonth + '\'' +
                ", checkoutMethod='" + checkoutMethod + '\'' +
                ", yonyouDepartmentCode='" + yonyouDepartmentCode + '\'' +
                ", yonyouDepartmentName='" + yonyouDepartmentName + '\'' +
                ", yonyouMallCode='" + yonyouMallCode + '\'' +
                ", yonyouMallName='" + yonyouMallName + '\'' +
                ", yonyouFranchiseeCode='" + yonyouFranchiseeCode + '\'' +
                ", yonyouFranchiseeName='" + yonyouFranchiseeName + '\'' +
                ", yonyouCompanyCode='" + yonyouCompanyCode + '\'' +
                ", yonyouCompanyName='" + yonyouCompanyName + '\'' +
                ", yonyouLiveBusinessShopTypeCode='" + yonyouLiveBusinessShopTypeCode + '\'' +
                ", yonyouLiveBusinessShopTypeName='" + yonyouLiveBusinessShopTypeName + '\'' +
                ", yonyouFinancialLeaderMobile='" + yonyouFinancialLeaderMobile + '\'' +
                ", yonyouHeadCompanyCode='" + yonyouHeadCompanyCode + '\'' +
                ", yonyouBranchCompanyCode='" + yonyouBranchCompanyCode + '\'' +
                ", yonyouPreparer='" + yonyouPreparer + '\'' +
                '}';
    }
}

