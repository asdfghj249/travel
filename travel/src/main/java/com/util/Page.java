package com.util;

import java.util.ArrayList;
import java.util.List;

public class Page {

    private int start;
    private int count;
    private int total;

    private static final int defaultCount = 5;

    public Page(){count = defaultCount;}

    public Page(int start,int count){
        this();
        this.start = start;
        this.count = count;
    }



    public int getStart() {
        return start;
    }
    public void setStart(int start) {
        this.start = start;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }

    public boolean isHasPreviouse(){
        if (start==0){
            return false;
        }
        return true;
    }

    public boolean isHasNext(){
        if (start == getLast()){
            return false;
        }
        return true;
    }

    public int getTotalPage(){
        int totalPage;
        if(total % count ==0){
            totalPage = total / count;
        }else {
            totalPage = total / count + 1;
        }
        if(totalPage == 0)
            totalPage = 1;

        return totalPage;
    }

    public int getLast(){
        int last;
        if(total % count ==0){
            last = total - count;
        }else {
            last = total - total % count;
        }
        return last<0?0:last;
    }

    //获取当前页码
    public int getCurrentPage(){
        int currentPage;
        currentPage = start / count + 1;
        return currentPage;
    }
}
