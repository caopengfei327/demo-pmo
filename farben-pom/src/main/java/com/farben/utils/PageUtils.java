package com.farben.utils;

public class PageUtils {

    /**
     * 计算总页数
     *
     */
    public static int currentTotalpages (int totalNum,int pageSize) {

        //totalNum数据总量
        //pageSize一页显示条数
        int totalPages;//总页数
        totalPages = totalNum / pageSize;
        if (totalNum % pageSize != 0){
            totalPages ++;
        }
        return totalPages;
    }

    /**
     * 计算开始页码
     *
     */
    public static Integer startPage (int start,int pageSize) {

        int startPage = 0;
        if (start > 0) {
            return start * pageSize;
        }
        return startPage;

    }

}
