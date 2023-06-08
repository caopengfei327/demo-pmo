package com.farben.mapper;

import com.farben.entity.SysUserLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserLogMapper {

//    @Insert("insert into SYS_USER_LOG(account,channel,functionName,userName,action,url,ip,params,err_msg,log_time)values(#{name},#{password})")
//    void saveInfo(@Param("name") String name, @Param("password") String password);

    void saveSysUser(SysUserLog sysUserLog);
}
