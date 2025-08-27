package Util;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.data.ReadCellData;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import com.alibaba.excel.metadata.GlobalConfiguration;
import org.apache.commons.lang3.StringUtils;
import java.math.BigDecimal;

public class BigDecimalConverter implements Converter<BigDecimal> {

    @Override
    public Class<BigDecimal> supportJavaTypeKey() {
        return BigDecimal.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    @Override
    public BigDecimal convertToJavaData(ReadCellData<?> cellData,
                                        ExcelContentProperty contentProperty,
                                        GlobalConfiguration globalConfiguration) throws Exception {

        String stringValue = cellData.getStringValue();

        if (StringUtils.isBlank(stringValue)) {
            return null;
        }

        stringValue = stringValue.trim()
                .replace(",", "")
                .replace("，", "")
                .replace(" ", "");

        if (StringUtils.isBlank(stringValue) || "null".equalsIgnoreCase(stringValue)) {
            return null;
        }

        try {
            return new BigDecimal(stringValue);
        } catch (NumberFormatException e) {
            System.err.println("无法解析 BigDecimal: " + stringValue);
            return null; // 或 throw new IllegalArgumentException(e);
        }
    }
}