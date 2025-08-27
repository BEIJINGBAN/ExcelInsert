package Util;
import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.exception.ExcelDataConvertException;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.data.ReadCellData;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import com.alibaba.excel.metadata.property.ExcelHeadProperty;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class FixDateConverter implements Converter<LocalDateTime>{
        private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        @Override
        public Class<LocalDateTime> supportJavaTypeKey() {
            return LocalDateTime.class;
        }

        @Override
        public CellDataTypeEnum supportExcelTypeKey() {
            return CellDataTypeEnum.STRING;
        }

        @Override
        public LocalDateTime convertToJavaData(ReadCellData<?> cellData,
                                               ExcelContentProperty contentProperty,
                                               GlobalConfiguration globalConfiguration) {

            String value = cellData.getStringValue();
            if (value == null || value.trim().isEmpty()) {
                return null;
            }
            String fixed = value.trim().replace('/', '-');
            LocalDate localDate = LocalDate.parse(fixed, FORMATTER);
            return localDate.atStartOfDay();
    }
}
