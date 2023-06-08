package com.farben.utils;


import com.farben.exception.CommonException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ImportUtil<T>{

    private static final Logger LOGGER = LoggerFactory.getLogger(ImportUtil.class);

    //========================================================excel
    private Workbook workbook;

    private int startRowIndex;

    private int startSheetIndex;

    private int totalSheets;

    //========================================================csv
    private CSVParser csvParser;

    private Class<T> importClass;

    private Method cacheMethods[];

    private Class type[];

    public ImportUtil(Class<T> importClass) throws NoSuchMethodException {
        if(importClass == null){
            throw new NullPointerException("");
        }

        this.importClass = importClass;
        this.init(importClass);
    }

    //.xlsx
    public ImportHelper<T> readExcel(InputStream is) throws IOException {
        this.workbook = new XSSFWorkbook(is);
        this.totalSheets = this.workbook.getNumberOfSheets();
        return new ExcelIterator();
    }

    //.xls
    public ImportHelper<T> readExcel2003(InputStream is) throws IOException {
        this.workbook = new HSSFWorkbook(is);
        this.totalSheets = this.workbook.getNumberOfSheets();
        return new ExcelIterator();
    }

    public ImportHelper<T> readCSV(InputStream is,Charset charset,CSVFormat format)throws IOException{
        csvParser = CSVParser.parse(is, charset, format);
        return new CSVIterator();
    }

    public ImportHelper<T> readCSV(InputStream is)throws IOException{
        return readCSV(is, Charset.defaultCharset(), CSVFormat.EXCEL);

    }

    private void init(Class<?> importClass) throws NoSuchMethodException {
        ImportAnnotation annotation = importClass.getDeclaredAnnotation(ImportAnnotation.class);
        {
            this.cacheMethods = new Method[annotation.length()];
            this.type = new Class[annotation.length()];
            this.startRowIndex = annotation.rowIndex();
            this.startSheetIndex = annotation.sheetIndex();
        }
        Field[] fields = importClass.getDeclaredFields();
        for(Field field : fields){
            annotation = field.getAnnotation(ImportAnnotation.class);
            this.type[annotation.cellIndex()] = annotation.type();
            this.cacheMethods[annotation.cellIndex()] = importClass.getMethod(annotation.method(),annotation.type());

        }
    }

    private void closeWorkBook(){
        try {
            this.workbook.close();
        } catch (IOException e) {
            LOGGER.error("close workBook error",e);
        }
    }

    private void closeCsv(){
        try {
            csvParser.close();
        } catch (IOException e) {
            LOGGER.error("close csvParse error",e);
        }
    }

    private class ExcelIterator extends ImportHelper<T>{
        private int sheetIndex;

        private int rowIndex;

        private int cellIndex;

        private ExcelIterator(){
            this.sheetIndex = startSheetIndex;
            this.rowIndex = startRowIndex;
        }

        @Override
        public boolean hasNext() {
            if(workbook == null){
                return false;
            }
            if(this.sheetIndex <= workbook.getNumberOfSheets() - 1){
//                只有一个sheet 或者最后一个sheet
                if(workbook.getNumberOfSheets() == 1 || workbook.getNumberOfSheets() - 1 == this.sheetIndex){
                    int lastRow = workbook.getSheetAt(this.sheetIndex).getPhysicalNumberOfRows();
                    return this.rowIndex < lastRow;
                }
                return true;
            }

            return false;
        }

        @Override
        public T next() {
            Sheet sheet = workbook.getSheetAt(this.sheetIndex);
            Row row = sheet.getRow(this.rowIndex);
            try {
                if(row != null) {
                    T obj = importClass.newInstance();
                    for (int i = 0; i < cacheMethods.length; i++) {
                        this.cellIndex = i;
                        Cell cell = row.getCell(i);
                        if (cell != null) {
                            cacheMethods[i].invoke(obj, getCellValue(cell, type[i]));
                        }
                    }
                    return obj;
                }
            } catch (Exception e) {
                LOGGER.error("第:{} 个sheet 第:{} 个 row 第:{} 个 cell 解析成类:{} 方法:{} 类型:{} 失败"
                        ,this.sheetIndex +1
                        ,this.rowIndex + 1
                        ,this.cellIndex + 1
                        ,importClass.getName()
                        ,cacheMethods[this.cellIndex].getName()
                        ,type[this.cellIndex].getName()
                        ,e.getMessage());

                String error = "导入第:["+(this.sheetIndex +1)+"]个sheet ,第:["+(this.rowIndex + 1)+"]个row ,第:["+(this.cellIndex + 1)+"]列,数据格式不对";
                throw new CommonException(error);
            }finally {
                //最后增加index
                if (this.rowIndex >= sheet.getPhysicalNumberOfRows() - 1) {    //sheet 的最后一个row
                    this.sheetIndex++;
                    this.rowIndex = startRowIndex;                        //重置为temp
                } else {
                    this.rowIndex++;
                }
            }
            return  null;
        }

        @Override
        public int getTotalRowsNum() {
            int total = 0;
            if(workbook != null) {
                for (int i = 0; i < totalSheets; i++) {
                    total += workbook.getSheetAt(i).getPhysicalNumberOfRows() - startRowIndex;
                }
            }
            return total;
        }

        @Override
        public List<T> getRows() {
            this.sheetIndex = startSheetIndex;
            this.rowIndex = startRowIndex;
            List<T> eList = new ArrayList<>();
            while (hasNext()){
                eList.add(next());
            }
            return eList;
        }

        @Override
        public void close() {
            closeWorkBook();
        }

        private Object getCellValue(Cell cell, Class type){

            int cellType = cell.getCellType();
            if(cellType == 0){   //数字
                if(type == Date.class || DateUtil.isCellDateFormatted(cell)){   //日期特殊处理
                    SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
                    return sdf.format(cell.getDateCellValue());
                }
                return getJavaValue(type,cell.getNumericCellValue() + "");

            }else if(cellType == 4){
                return getJavaValue(type,cell.getBooleanCellValue() + "");
            }

            return cell.getStringCellValue();
        }

        private Object getJavaValue(Class type, String s) {
            if(type == Byte.class){
                return (byte)Double.parseDouble(s);
            }else if(type == Short.class){
                return (short) Double.parseDouble(s);
            }else if(type == Integer.class){
                return (int)Double.parseDouble(s);
            }else if(type == Long.class){
                return (long)Double.parseDouble(s);
            }else if(type == Float.class){
                return (float)Double.parseDouble(s);
            }else if(type == Double.class){    //数值类型
                return Double.parseDouble(s);
            }else if(type == Boolean.class){
                return Boolean.parseBoolean(s);
            }else{
                if (s.indexOf(".0")>0 && StringUtils.isBlank(s.substring(s.indexOf(".0")+2))) {
                    s = s.replace(".0","");
                }
                return s.trim();
            }
        }


    }


    private class CSVIterator extends ImportHelper<T>{

        private int rowIndex = startRowIndex;

        private int cellIndex;

        private Iterator<CSVRecord> iterator = csvParser.iterator();

        @Override
        public void close() {
            closeCsv();
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public T next() {
            CSVRecord csvRecord = iterator.next();
            if(csvParser.getCurrentLineNumber() <= startRowIndex){   //第一行
                if(hasNext()){
                    csvRecord = iterator.next();
                }else{
                    return null;
                }
            }
            try {
                T t = importClass.newInstance();
                for (int i = 0; i < cacheMethods.length; i++) {
                    this.cellIndex = i;
                    cacheMethods[i].invoke(t,getJavaValue(type[i],csvRecord.get(i)));
                }
                return t;
            }catch (Exception e){
                LOGGER.error("第:{} 个 row 第:{} 个 cell 解析成类:{} 方法:{} 类型:{} 失败"
                        ,this.rowIndex + 1
                        ,this.cellIndex + 1
                        ,importClass.getName()
                        ,cacheMethods[this.cellIndex].getName()
                        ,type[this.cellIndex].getName()
                        ,e.getMessage());
            }finally {
                this.rowIndex++;
            }
            return null;
        }

        private Object getJavaValue(Class type, String s) {
            if(type == Byte.class){
                return Byte.parseByte(s);
            }else if(type == Short.class){
                return Short.parseShort(s);
            }else if(type == Integer.class){
                return Integer.parseInt(s);
            }else if(type == Long.class){
                return Long.parseLong(s);
            }else if(type == Float.class){
                return Float.parseFloat(s);
            }else if(type == Double.class){    //数值类型
                return Double.parseDouble(s);
            }else if(type == Boolean.class){
                return Boolean.valueOf(s);
            }else{
                return s;
            }
        }

        @Override
        public int getTotalRowsNum() {
            return (int)csvParser.getRecordNumber();
        }

        @Override
        public List<T> getRows() {
            iterator = csvParser.iterator();
            List<T> tList = new ArrayList<>();
            while (hasNext()){
                tList.add(next());
            }
            return tList;
        }

    }

}
