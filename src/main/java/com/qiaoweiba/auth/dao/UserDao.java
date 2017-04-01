package com.qiaoweiba.auth.dao;

import com.qiaoweiba.auth.common.Basedao;
import com.qiaoweiba.auth.entity.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;


/**
 * @author Administrator
 * @data 四月 01 2017 21:58.
 */
@Repository
public class UserDao extends Basedao{

    private class UserMapper implements RowMapper<User> {

        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            User user = new User();
            user.setId(resultSet.getLong("id"));
            user.setName(resultSet.getString("name"));
            user.setPwd(resultSet.getString("pwd"));
            return user;
        }
    }

    /**
     *根据用户名密码查询用户，用于登录
     * @param name
     * @param pwd
     * @return
     */
    public User getUser(String name, String pwd){
        String sql = "select * from auth_user where name = ? and pwd = ?";
        try {
            List<User> userList = jdbcTemplate.query(sql,new Object[]{name,pwd},new UserMapper());
            if (userList.isEmpty()){
                return null;
            }else if (userList.size()==1) {
                return userList.get(0);
            }else {
                return userList.get(0);
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 保存用户
     * @param user
     */
    public void save(User user) {
        String sql = "insert into auth_user(id,name,pwd) values (?,?,?)";
        jdbcTemplate.update(sql, user.getId(), user.getName(), user.getPwd());
    }

    public void deleteById(Long id){
        String sql = "delete from auth_usr where id=?";
        jdbcTemplate.update(sql,id);
    }

    public void udate(User user) {
        String sql = "update auth_user set name=? ,pwd =? where id = ?";
        jdbcTemplate.update(sql, user.getName(), user.getPwd(), user.getId());
    }

    public User findById(String id){
        String sql = "select * from auth_user where id =?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{id}, new UserMapper());
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public Collection<User> findByIds(Collection<Long> ids) {
        StringBuilder sqlStr = new StringBuilder("select * from auth_user where id in (");
        ids.forEach(id-> sqlStr.append(id).append(","));
        sqlStr.deleteCharAt(sqlStr.length() - 1);
        String sql = sqlStr.append(")").toString();
        System.out.println(sql);
        try {
            return jdbcTemplate.query(sql, new UserMapper());
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    public Collection<User> findPage(int page,int size){
        if (page<1){
            page = 1;
        }
        if (size<0){
            size = 20;
        }
        String sql = "select * from auth_user limit ?,?";
        int skip = (page-1)*size;
        return jdbcTemplate.query(sql, new Object[]{skip, size}, new UserMapper());
    }
}
