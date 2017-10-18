package cn.myoa.mapper;

import cn.myoa.dao.UserDao;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by zhangbolun on 17/10/17.
 */
public interface UserMapper {

    @Insert("<script>" +
            " insert into users (phone, username, name, password, create_time, status " +
            " <if test='email != null'>, email</if> ) " +
            " values(#{phone}, #{username}, #{name}, #{password}, now(), #{status} " +
            "<if test='email != null'> ,#{email} </if> ) " +
            "</script>")
    @Options(useGeneratedKeys=true)
    int addUser(UserDao user);

    @Update("<script>" +
            " update users set " +
            "<if test='phone != null'> phone=#{phone}, </if>" +
            "<if test='status != null'> status=#{status} </if>" +
            "where id=#{id}" +
            "</script>")
    int updateUser(UserDao user);

    @Select(" select * from users order by id desc limit 20")
    List<UserDao> list();
}