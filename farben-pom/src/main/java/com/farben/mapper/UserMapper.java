package com.farben.mapper;

import com.farben.entity.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    //查询，可以实现登录功能
//    @Select("SELECT * FROM userBean WHERE username = #{name} AND password = #{password}")
    UserInfo getInfo(@Param("name") String name, @Param("password") String password);

    //多个参数要加@Param修饰
    //增加，可以实现注册功能
    @Insert("insert into userBean(username,password)values(#{name},#{password})")
    void saveInfo(@Param("name") String name, @Param("password") String password);
}