package com.holmes.hoo.blackwatch.utils;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.support.ExcelTypeEnum;

import java.io.InputStream;

/**
 * easyexcel 工具类
 */
@SuppressWarnings("rawtypes")
public class EasyExcelUtils {

    /**
     * 一个excel文件，只有一个sheet读取
     *
     * @param ins           文件输入流
     * @param head          解析实体类
     * @param headRowNumber 从第几行开始解析
     * @param readListener  监听器
     */
    public static void readSignalSheet(InputStream ins, Class head, Integer headRowNumber, ReadListener readListener) {
        EasyExcelFactory.read(ins, head, readListener).excelType(ExcelTypeEnum.XLSX).sheet(0).headRowNumber(headRowNumber).doRead();
    }

    /**
     * 指定sheet索引读取数据
     *
     * @param ins           文件输入流
     * @param head          解析实体类
     * @param index         sheet索引
     * @param headRowNumber 从第几行开始解析
     * @param readListener  监听器
     */
    public static void readSignalSheetByIndex(InputStream ins, Class head, Integer index, Integer headRowNumber, ReadListener readListener) {
        EasyExcelFactory.read(ins, head, readListener).excelType(ExcelTypeEnum.XLSX).sheet(index).headRowNumber(headRowNumber).doRead();
    }

    /**
     * 指定sheet名称读取数据
     *
     * @param ins           文件输入流
     * @param head          解析实体类
     * @param sheetName     sheet名称
     * @param headRowNumber 从第几行开始解析
     * @param readListener  监听器
     */
    public static void readSignalSheetByName(InputStream ins, Class head, String sheetName, Integer headRowNumber, ReadListener readListener) {
        EasyExcelFactory.read(ins, head, readListener).excelType(ExcelTypeEnum.XLSX).sheet(sheetName).headRowNumber(headRowNumber).doRead();
    }

    /**
     * 读取所有sheet页
     *
     * @param ins           文件输入流
     * @param head          解析实体类
     * @param headRowNumber 从第几行开始解析
     * @param readListener  监听器
     */
    public static void readAllSheet(InputStream ins, Class head, Integer headRowNumber, ReadListener readListener) {
        EasyExcelFactory.read(ins, head, readListener).excelType(ExcelTypeEnum.XLSX).headRowNumber(headRowNumber).doReadAll();
    }
}
