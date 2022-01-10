package com.holmes.hoo.blackwatch.utils;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * excel数据解析监听类基类
 */
@Slf4j
public class ExcelListener<T> extends AnalysisEventListener<T> {

    private List<T> dataList = new ArrayList<T>();

    public void clearData() {
        dataList.clear();
    }

    /**
     * 执行类
     */
    @Override
    public void invoke(T data, AnalysisContext context) {
        dataList.add(data);
    }

    /**
     * 数据读取完成操作
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        log.info("excel data parsing complete ! parse row nums ： {}", dataList.size());
    }


    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    //ExcelListener<AwardExcelVO> awardExcelVOExcelListener = new ExcelListener<>();
    //EasyExcelUtils.readSignalSheetByIndex(request.getLotteryExcel().getInputStream(), AwardExcelVO.class, 0, 1, awardExcelVOExcelListener);
}
