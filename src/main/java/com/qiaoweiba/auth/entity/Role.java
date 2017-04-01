package com.qiaoweiba.auth.entity;

import com.qiaoweiba.auth.common.BaseEntity;

/**
 * @author Administrator
 * @data ËÄÔÂ 01 2017 22:12.
 */
public class Role extends BaseEntity {

    private Long id;
    private String name;
//    private String fincitonIds;


    public Role(){

    }

    public Role(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
