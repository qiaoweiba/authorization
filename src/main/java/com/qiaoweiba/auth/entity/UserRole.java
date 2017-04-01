package com.qiaoweiba.auth.entity;

import com.qiaoweiba.auth.common.BaseEntity;

/**
 * @author Administrator
 * @data ËÄÔÂ 01 2017 22:19.
 */
public class UserRole extends BaseEntity{

    private Long id;
    private Long userId;
    private Long roleId;

    public UserRole(Long id, Long roleId, Long userId) {
        this.id = id;
        this.roleId = roleId;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
