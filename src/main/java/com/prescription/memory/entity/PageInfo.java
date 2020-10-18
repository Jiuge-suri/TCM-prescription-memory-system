package com.prescription.memory.entity;

import com.github.pagehelper.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Created by Yinjie on 2020/5/10
 */
@SuppressWarnings({"rawtypes", "unchecked"})
@Data
@ApiModel("分页查询")
public class PageInfo<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "当前页")
    private int current;
    @ApiModelProperty(value = "每页的数量")
    private int size;
    @ApiModelProperty(value = "总条数")
    private long total;
    @ApiModelProperty(value = "总页数")
    private int pages;
    @ApiModelProperty(value = "结果集")
    private List<T> records;
    @ApiModelProperty(value = "是否为第一页")
    private boolean isFirstPage = false;
    @ApiModelProperty(value = "是否为最后一页")
    private boolean isLastPage = false;


    public PageInfo() {
    }

    /**
     * 包装Page对象
     *
     * @param records
     */
    public PageInfo(List<T> records) {
        if (records instanceof Page) {
            Page page = (Page) records;
            this.current = page.getPageNum();
            this.size = page.getPageSize();

            this.pages = page.getPages();
            this.records = page;
            this.total = page.getTotal();
        } else if (records instanceof Collection) {
            this.current = 1;
            this.size = records.size();

            this.pages = 1;
            this.records = records;
            this.total = records.size();
        }
        if (records instanceof Collection) {
            //判断页面边界
            judgePageBoudary();
        }
    }

    private void judgePageBoudary() {
        isFirstPage = current == 1;
        isLastPage = current == pages;
    }
}
