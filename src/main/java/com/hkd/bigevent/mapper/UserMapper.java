package com.hkd.bigevent.mapper;

import com.hkd.bigevent.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from user where username=#{username}")
    public User findUserByName(String username);
    @Insert("insert into user(username,password,create_time,update_time)  " +
            "values(#{username},#{password},now(),now())")
    public Integer register(String username,String password);
}
