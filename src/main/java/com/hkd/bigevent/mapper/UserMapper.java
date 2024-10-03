package com.hkd.bigevent.mapper;

import com.hkd.bigevent.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {
    @Select("select * from user where username=#{username}")
    public User findUserByName(String username);
    @Insert("insert into user(username,password,create_time,update_time)  " +
            "values(#{username},#{password},now(),now())")
    public Integer register(String username,String password);
    @Update("update user set nickname=#{nickname},email=#{email},update_time=#{update_time} where id=#{id}")
    public Integer update(User user);
}
