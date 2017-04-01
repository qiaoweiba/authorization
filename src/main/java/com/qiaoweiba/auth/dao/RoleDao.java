package com.qiaoweiba.auth.dao;

import com.qiaoweiba.auth.common.Basedao;
import com.qiaoweiba.auth.entity.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.*;
import java.util.Collection;
import java.util.List;


/**
 * @author Administrator
 * @data 四月 01 2017 23:00.
 */
public class RoleDao extends Basedao {

    private Logger logger = LoggerFactory.getLogger(RoleDao.class);

    private class RoleMapper implements RowMapper<Role> {
        @Override
        public Role mapRow(ResultSet resultSet, int i) throws SQLException {
            Role role = new Role();
            role.setId(resultSet.getLong("id"));
            role.setName(resultSet.getString("name"));
            return role;
        }
    }

    public Role findRoleById(Long id) {
        String sql = "select * from auth_role where id =?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{id}, new RoleMapper());
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 保存角色 目的可以将主键带出来。
     * @param role
     */
    public void save(Role role) {
        String sql = "insert into auth_role (name) values(?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1,role.getName());
                return ps;
            }
        },keyHolder);
        //获取id
        role.setId(keyHolder.getKey().longValue());
    }

    public void deleteRoleById(Long roleId) {
        String sql = "delete from auth_role where id = ?";
        jdbcTemplate.update(sql, roleId);
    }

    public void updateRole(Role role) {
        String sql = "update auth_role set name = ? where id = ?";
        jdbcTemplate.update(sql, role.getName(),role.getId());
    }

    public List<Role> findRoleByIds(Collection<Long> ids) {
        StringBuffer sqlStr = new StringBuffer("select * from auth_role where id in (");
        ids.forEach(id -> sqlStr.append(id).append(","));
        sqlStr.deleteCharAt(sqlStr.length() - 1);
        sqlStr.append(")");
        try {
            return jdbcTemplate.query(sqlStr.toString(), new RoleMapper());
        }catch (DataAccessException e){
            e.printStackTrace();;
            return null;
        }
    }

    /**
     * 根据分页查询Roles
     * @param page
     * @param size
     * @return
     */
    public List<Role> findRolesByPages(int page,int size) {
        if (page<1){
            page = 1;
        }
        if (size<0){
            size = 20;
        }
        String sql = "select * from auth_role limit ?,?";
        try {
            return jdbcTemplate.query(sql, new Object[]{(page-1)*size, size}, new RoleMapper());
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
