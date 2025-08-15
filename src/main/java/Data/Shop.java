package Data;
import java.io.Serializable;
import java.time.LocalDateTime;

public class Shop implements Serializable {

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
         * 企业组织编码
         */
        private String yqsOrgCode;

        /**
         * 门店编码
         */
        private String shopCode;

        /**
         * 门店名称
         */
        private String shopName;

        /**
         * 分类编码
         */
        private String categoryCode;

        /**
         * 类型编码
         */
        private String typeCode;

        /**
         * 区域编码
         */
        private String regionCode;

        /**
         * 区域名称
         */
        private String regionName;

        /**
         * 省份编码
         */
        private String provinceCode;

        /**
         * 省份名称
         */
        private String provinceName;

        /**
         * 城市编码
         */
        private String cityCode;

        /**
         * 城市名称
         */
        private String cityName;

        /**
         * 经营模式
         */
        private String manageMode;

        /**
         * 门店渠道类型
         */
        private String shopChannelType;

        /**
         * 付款方式
         */
        private String paymentMode;

        /**
         * 付款周期
         */
        private String paymentCycle;

        /**
         * 利润分成比例
         */
        private java.math.BigDecimal profitSplitRate;

        /**
         * 扩展JSON字段
         */
        private String extendJsonField;

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
         * 更新人
         */
        private String updater;

        /**
         * 创建时间
         */
        private LocalDateTime createTime;

        /**
         * 更新时间
         */
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

        public String getUpdater() {
            return updater;
        }

        public void setUpdater(String updater) {
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
