package Domain;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Shop implements Serializable {


    /**
     * 猫人-店铺信息表
     */

        /**
         * 主键
         */
        @ExcelProperty("主键")
        private Long id;

        /**
         * 企业编码
         */
        @ExcelProperty("企业编码")
        private String tenantCode;

        /**
         * 易企收组织编码，预留扩展字段，目前为店铺代码，对应organization.org_code
         */
        @ExcelProperty("易企收组织编码")
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
        @ExcelProperty("管理模式")
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
        @ExcelProperty("分利比例")
        private BigDecimal profitSplitRate;

        /**
         * 易企收系统内配置，json格式扩展字段
         */
        @ExcelProperty("扩展字段")
        private String extendJsonField;

        /**
         * 备注
         */
        @ExcelProperty("备注")
        private String remark;

        /**
         * 有效状态(1-有效; 0-无效)
         */
        // TODO 状态？
        @ExcelProperty("有效状态")
        private String isActive;

        /**
         * 数据版本号
         */
        @ExcelProperty("数据版本号")
        private Integer version;

        /**
         * 创建者
         */
        @ExcelProperty("创建者")
        private Long creator;

        /**
         * 创建时间
         */
        @ExcelProperty("创建时间")
        @DateTimeFormat("yyyy-MM-dd HH:mm:ss")
        private LocalDateTime createTime;

        /**
         * 更新者
         */
        @ExcelProperty("更新者")
        private Long updater;

        /**
         * 更新时间
         */
        @ExcelProperty("更新时间")
        @DateTimeFormat("yyyy-MM-dd HH:mm:ss")
        private LocalDateTime updateTime;


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
}
