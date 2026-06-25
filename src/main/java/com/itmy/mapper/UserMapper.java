package com.itmy.mapper;

import com.itmy.pojo.dto.UserLoginDto;
import com.itmy.pojo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


@Mapper
public interface UserMapper {
    //根据账号密码查询用户
    @Select("select * from user where account=#{account} and password=#{password}")
    User selectBy(UserLoginDto userLoginDto);

    //根据id查询用户
    @Select("select * from user where id=#{id}")
    User selectById(Integer id);

    //插入用户
    void insert(User user);

    //根据id更新用户
    @Update("update user set username=#{username},password=#{password} where id=#{id}")
    void updateById(User user);
}
