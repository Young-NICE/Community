package com.young.community.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 包裹的是一个页面所承载的元素
 */
@Data
public class PaginationDTO {
    private List<QuestionDTO> questions;
    //上一页
    private boolean showPrevious;
    //下一页
    private boolean showNext;
    //回到第一页
    private boolean showFirstPage;
    //跳到最后一页
    private boolean showEndPage;
    //当前页数
    private Integer page;
    //能看到的页码
    private List<Integer> pages = new ArrayList<>();
    //所有的页数
    private Integer totalPage;

    public void setPagination(Integer totalPage, Integer page) {
        this.totalPage = totalPage;
        this.page = page;
        pages.add(page);
        for (int i=1;i<=3;i++){
            if (page-i>0){
                pages.add(0,page-i);
            }
            if (page+i<=totalPage){
                pages.add(page+i);
            }
        }

        //是否展示上一页
        if (page ==1){
            showPrevious = false;
        } else {
            showPrevious = true;
        }

        //是否展示下一页
        if (page == totalPage){
            showNext = false;
        } else {
            showNext = true;
        }

        //是否展示第一页
        if (pages.contains(1)){
            showFirstPage = false;
        } else {
            showFirstPage = true;
        }

        //是否展示最后一页
        if (pages.contains(totalPage)){
            showEndPage = false;
        } else {
            showEndPage = true;
        }

    }
}
