package Data;


import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ShopExtend implements Serializable {

        private static final long serialVersionUID = 1L;

        /**
         * 主键ID
         */
        private Long id;

        /**
         * 租户编码
         */
        private String tenantCode;

        /**
         * 门店编码
         */
        private String shopCode;

        /**
         * 品牌类型
         */
        private String brandType;

        /**
         * 账本类型
         */
        private String ledgerType;

        /**
         * 租赁类型
         */
        private String leaseType;

        /**
         * 渠道销售位置类型
         */
        private String channelSalesPositionType;

        /**
         * 商场类型
         */
        private String mallType;

        /**
         * 一级区域类型
         */
        private String firstLevelRegionType;

        /**
         * 二级区域类型
         */
        private String secondLevelRegionType;

        /**
         * 城市等级
         */
        private String cityLevel;

        /**
         * 区域负责人
         */
        private String regionLeader;

        /**
         * 运营负责人
         */
        private String operationLeader;

        /**
         * 运营负责人员工ID
         */
        private String operationLeaderEmployeeId;

        /**
         * 商品负责人
         */
        private String productLeader;

        /**
         * 证件号码
         */
        private String certNum;

        /**
         * 门店形象类型
         */
        private String shopImageType;

        /**
         * 门店等级
         */
        private String shopGrade;

        /**
         * 开业时间
         */
        private LocalDateTime openTime;

        /**
         * 关店时间
         */
        private LocalDateTime closeTime;

        /**
         * 门店扩展类型
         */
        private String shopExtensionType;

        /**
         * 楼层
         */
        private String floor;

        /**
         * 位置
         */
        private String position;

        /**
         * 总面积
         */
        private BigDecimal totalArea;

        /**
         * 销售面积
         */
        private BigDecimal salesArea;

        /**
         * 仓库面积
         */
        private BigDecimal warehouseArea;

        /**
         * 员工人数
         */
        private Integer staffNum;

        /**
         * 增值税率
         */
        private BigDecimal vatRate;

        /**
         * 月租金金额
         */
        private BigDecimal monthlyRentAmount;

        /**
         * 月物业费金额
         */
        private BigDecimal monthlyPropertyAmount;

        /**
         * 合同扣点率
         */
        private BigDecimal contractDeductionRate;

        /**
         * 加盟商利润分成率
         */
        private BigDecimal franchiseeProfitSplitRate;

        /**
         * O2O技术服务费率
         */
        private BigDecimal o2oTechnicalServiceFeeRate;

        /**
         * O2O运营服务费率
         */
        private BigDecimal o2oOperationServiceFeeRate;

        /**
         * 水电费金额
         */
        private BigDecimal waterElectricityAmount;

        /**
         * 商场固定成本金额
         */
        private BigDecimal mallFixedCostAmount;

        /**
         * 其他固定成本金额
         */
        private BigDecimal otherFixedCostAmount;

        /**
         * 商场浮动成本金额
         */
        private BigDecimal mallFloatCostAmount;

        /**
         * 保底销售额
         */
        private BigDecimal guaranteeSalesAmount;

        /**
         * 保底周期
         */
        private String guaranteePeriod;

        /**
         * 首年保底销售额
         */
        private BigDecimal guaranteeFirstYearSalesAmount;

        /**
         * 改造类型
         */
        private String transformType;

        /**
         * 上次改造时间
         */
        private LocalDateTime lastTransformTime;

        /**
         * 改造开始时间
         */
        private LocalDateTime transformStartTime;

        /**
         * 改造结束时间
         */
        private LocalDateTime transformEndTime;

        /**
         * 改造周期
         */
        private String transformPeriod;

        /**
         * 改造总面积
         */
        private BigDecimal transformTotalArea;

        /**
         * 改造销售面积
         */
        private BigDecimal transformSalesArea;

        /**
         * 改造仓库面积
         */
        private BigDecimal transformWarehouseArea;

        /**
         * 新店基础分摊金额
         */
        private BigDecimal newStoreBaseInstallmentAmount;

        /**
         * 新店物业分摊金额
         */
        private BigDecimal newStorePropInstallmentAmount;

        /**
         * 新店市场拓展金额
         */
        private BigDecimal newStoreMarketExpansionAmount;

        /**
         * 新店卡费金额
         */
        private BigDecimal newStoreCardFeeAmount;

        /**
         * 新店物流金额
         */
        private BigDecimal newStoreLogisticsAmount;

        /**
         * 新店其他金额
         */
        private BigDecimal newStoreOtherAmount;

        /**
         * 加盟商名称
         */
        private String franchiseeName;

        /**
         * 加盟商账号
         */
        private String franchiseeAccountNo;

        /**
         * 加盟主合同ID
         */
        private Long fdMainContractId;

        /**
         * 加盟商扣点率
         */
        private BigDecimal franchiseeDeductionRate;

        /**
         * 合同开始时间
         */
        private LocalDateTime contractStartTime;

        /**
         * 合同结束时间
         */
        private LocalDateTime contractEndTime;

        /**
         * 合同期限(月)
         */
        private Integer contractPeriodMonth;

        /**
         * 结算方式
         */
        private String checkoutMethod;

        /**
         * 用友部门编码
         */
        private String yonyouDepartmentCode;

        /**
         * 用友部门名称
         */
        private String yonyouDepartmentName;

        /**
         * 用友商场编码
         */
        private String yonyouMallCode;

        /**
         * 用友商场名称
         */
        private String yonyouMallName;

        /**
         * 用友加盟商编码
         */
        private String yonyouFranchiseeCode;

        /**
         * 用友加盟商名称
         */
        private String yonyouFranchiseeName;

        /**
         * 用友公司编码
         */
        private String yonyouCompanyCode;

        /**
         * 用友公司名称
         */
        private String yonyouCompanyName;

        /**
         * 用友直播业务门店类型编码
         */
        private String yonyouLiveBusinessShopTypeCode;

        /**
         * 用友直播业务门店类型名称
         */
        private String yonyouLiveBusinessShopTypeName;

        /**
         * 用友财务负责人手机号
         */
        private String yonyouFinancialLeaderMobile;

        /**
         * 用友总部公司编码
         */
        private String yonyouHeadCompanyCode;

        /**
         * 用友分支机构公司编码
         */
        private String yonyouBranchCompanyCode;

        /**
         * 用友制单人
         */
        private String yonyouPreparer;

        /**
         * 备注
         */
        private String remark;

        /**
         * 是否激活 (1: 是, 0: 否)
         */
        private Integer isActive;

        /**
         * 版本号
         */
        private Integer version;

        /**
         * 创建人
         */
        private String creator;

        /**
         * 创建时间
         */
        private LocalDateTime createTime;

        /**
         * 更新人
         */
        private String updater;

        /**
         * 更新时间
         */
        private LocalDateTime updateTime;


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

        public String getShopCode() {
            return shopCode;
        }

        public void setShopCode(String shopCode) {
            this.shopCode = shopCode;
        }

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

        public BigDecimal getVatRate() {
            return vatRate;
        }

        public void setVatRate(BigDecimal vatRate) {
            this.vatRate = vatRate;
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

        public BigDecimal getO2oTechnicalServiceFeeRate() {
            return o2oTechnicalServiceFeeRate;
        }

        public void setO2oTechnicalServiceFeeRate(BigDecimal o2oTechnicalServiceFeeRate) {
            this.o2oTechnicalServiceFeeRate = o2oTechnicalServiceFeeRate;
        }

        public BigDecimal getO2oOperationServiceFeeRate() {
            return o2oOperationServiceFeeRate;
        }

        public void setO2oOperationServiceFeeRate(BigDecimal o2oOperationServiceFeeRate) {
            this.o2oOperationServiceFeeRate = o2oOperationServiceFeeRate;
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

        public Long getFdMainContractId() {
            return fdMainContractId;
        }

        public void setFdMainContractId(Long fdMainContractId) {
            this.fdMainContractId = fdMainContractId;
        }

        public BigDecimal getFranchiseeDeductionRate() {
            return franchiseeDeductionRate;
        }

        public void setFranchiseeDeductionRate(BigDecimal franchiseeDeductionRate) {
            this.franchiseeDeductionRate = franchiseeDeductionRate;
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

        public Integer getContractPeriodMonth() {
            return contractPeriodMonth;
        }

        public void setContractPeriodMonth(Integer contractPeriodMonth) {
            this.contractPeriodMonth = contractPeriodMonth;
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

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public Integer getIsActive() {
            return isActive;
        }

        public void setIsActive(Integer isActive) {
            this.isActive = isActive;
        }

        public Integer getVersion() {
            return version;
        }

        public void setVersion(Integer version) {
            this.version = version;
        }

        public String getCreator() {
            return creator;
        }

        public void setCreator(String creator) {
            this.creator = creator;
        }

        public LocalDateTime getCreateTime() {
            return createTime;
        }

        public void setCreateTime(LocalDateTime createTime) {
            this.createTime = createTime;
        }

        public String getUpdater() {
            return updater;
        }

        public void setUpdater(String updater) {
            this.updater = updater;
        }

        public LocalDateTime getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(LocalDateTime updateTime) {
            this.updateTime = updateTime;
        }
}
