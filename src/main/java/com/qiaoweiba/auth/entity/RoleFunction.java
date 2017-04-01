package com.qiaoweiba.auth.entity;

import com.qiaoweiba.auth.common.BaseEntity;

/**
 * @author Administrator
 * @data ËÄÔÂ 01 2017 22:20.
 */
public class RoleFunction extends BaseEntity {

    private Long id;
    private Long roleId;
    private Long functionId;
    private int status;

    public RoleFunction(){

    }

    public RoleFunction(Long functionId, Long id, Long roleId, int status) {
        this.functionId = functionId;
        this.id = id;
        this.roleId = roleId;
        this.status = status;
    }

    public Long getFunctionId() {
        return functionId;
    }

    public void setFunctionId(Long functionId) {
        this.functionId = functionId;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
