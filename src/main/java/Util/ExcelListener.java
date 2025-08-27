package Util;

import DTO.ShopExcelDTO;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.exception.ExcelDataConvertException;
import com.alibaba.excel.read.listener.ReadListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.ArrayList;
import java.util.List;



public class ExcelListener implements ReadListener<ShopExcelDTO>{

    private static final Logger log = LogManager.getLogger(ExcelListener.class);
    private List<ShopExcelDTO> dataList = new ArrayList<>();
    public         int count =0;

    public void invoke(ShopExcelDTO data, AnalysisContext context) {

        count++;
        log.info("解析到一条数据");
        dataList.add(data);
    }


    public void doAfterAllAnalysed(AnalysisContext context) {
        log.info("所有数据解析完成，共{}条",dataList.size());
    }

    public void onException(Exception exception, AnalysisContext context) throws Exception {
        System.out.println("OnException 被调用了！异常类型：" + exception.getClass().getSimpleName());
        if (exception instanceof ExcelDataConvertException){
            ExcelDataConvertException e =  (ExcelDataConvertException) exception;
            log.error("第 {} 行，第 {} 列格式错误： {}",e.getRowIndex(),e.getColumnIndex(),e.getMessage());
            System.out.println("ERROR :第 " + e.getRowIndex()+ " 行，第 "+e.getColumnIndex()+" 列格式错误： "+ e.getMessage());
            throw new RuntimeException("第 "+ e.getRowIndex() +" 行，第 "+(e.getColumnIndex())+" 列数据格式错误");
        }
    }
    public List<ShopExcelDTO> getDataList(){
        return dataList;
    }

}


