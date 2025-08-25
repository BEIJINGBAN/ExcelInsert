package Domain;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;

import java.time.LocalDateTime;

/*
组织
* */
public class Organization {

        /**
         * 主键
         */
        @ExcelProperty("主键")
        private Long id;

        /**
         * 企业号
         */
        @ExcelProperty("企业号")
        private String tenantCode;

        /**
         * 组织编码
         */
        @ExcelProperty("组织编码")
        private String orgCode;

        /**
         * 组织名称
         */
        @ExcelProperty("组织名称")
        private String orgName;

        /**
         * 上级组织code
         */
        @ExcelProperty("上级组织code")
        private String parentOrgCode;

        /**
         * 组织简称
         */
        @ExcelProperty("组织简称")
        private String shortOrgName;

        /**
         * 组织类型，1-企业,2-普通
         */
        @ExcelProperty("组织类型")
        private String orgType;

        /**
         * 组织级别，从1级开始
         */
        @ExcelProperty("组织级别")
        private Integer orgLevel;

        /**
         * 组织索引
         */
        @ExcelProperty("组织索引")
        private String orgPath;

        /**
         * 数据来源。1-内部维护，2-外部系统
         */
        @ExcelProperty("数据来源")
        private String dataSource;

        /**
         * 状态（1-正常；2-禁用；）
         */
        @ExcelProperty("状态")
        private String status;

        /**
         * 备注
         */
        @ExcelProperty("备注")
        private String remark;

        /**
         * 版本号
         */
        @ExcelProperty("版本号")
        private Short version;

        /**
         * 创建者
         */
        @ExcelProperty("创建者")
        private Long creator;

        /**
         * 更新者
         */
        @ExcelProperty("更新者")
        private Long updater;

        /**
         * 创建时间
         */
        @ExcelProperty("创建时间")
        @DateTimeFormat("yyyy-MM-dd HH:mm:ss")
        private LocalDateTime createTime;

        /**
         * 最后修改时间
         */
        @ExcelProperty("最后修改时间")
        @DateTimeFormat("yyyy-MM-dd HH:mm:ss")
        private LocalDateTime updateTime;

        /**
         * 逻辑删除标识，0未删除，不为0则已删除
         */
        @ExcelProperty("逻辑删除标识")
        private Long isDelete;

        /**
         * 扩展信息，JSON结构
         */
        @ExcelProperty("扩展信息")
        private String extend;
    }
