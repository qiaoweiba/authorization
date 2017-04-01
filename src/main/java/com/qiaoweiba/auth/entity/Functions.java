package com.qiaoweiba.auth.entity;

import com.qiaoweiba.auth.common.BaseEntity;

/**
 * @author Administrator
 * @data ËÄÔÂ 01 2017 22:15.
 */
public class Functions extends BaseEntity {

    private Long id;
    private String name;
    private String url;
    private Long parentId;
    private Integer serialNum;
    private Integer accordion;

    public Integer getAccordion() {
        return accordion;
    }

    public void setAccordion(Integer accordion) {
        this.accordion = accordion;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(Integer serialNum) {
        this.serialNum = serialNum;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
