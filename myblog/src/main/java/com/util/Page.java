package com.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页工具类
 */
public class Page {

    private int start;
    private int count;
    private int total;

    private static final int defaultCount = 5;

    public Page(){
        count = defaultCount;
    }

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

    //是否有前一页
    public boolean isHasPrevious(){
        if(start == 0){
            return false;
        }
        return true;
    }

    //是否有后一页
    public boolean isHasNext(){
        if(start == getLast()){
            return false;
        }
        return true;
    }

    //获得总页数
    public int getTotalPage(){
        int totalPage;
        if(total % count == 0){
            totalPage = total / count;
        }else {
            totalPage = total / count + 1;
        }

        if (totalPage == 0){
            totalPage = 1;
        }
        return totalPage;
    }

    public int getLast(){
        int last;
        if(total % count == 0){
            last = total - count;
        }else {
            last = total - total % count;
        }
        return last < 0 ? 0:last;
    }

    public int getCurrentPage(){
        int currentPage;
        currentPage = start / count + 1;
        return currentPage;
    }

    public List<Integer> getBeginandEnd(Page page){
        int begin,end;
        List<Integer> list = new ArrayList<>();
        if(page.getTotalPage()<10){
            begin = 1;
            end = page.getTotalPage();
        }else {
            begin = page.getCurrentPage() - 5;
            end = page.getCurrentPage() + 4;

            if(begin<1){
                begin = 1;
                end = begin + 9;
            }
            if(end>page.getTotalPage()){
                end = page.getTotalPage();
                begin = end - 9;
            }
        }
        list.add(begin);
        list.add(end);
        return list;
    }

}
