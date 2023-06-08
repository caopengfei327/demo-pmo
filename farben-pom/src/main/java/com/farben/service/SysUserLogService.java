package com.farben.service;

import com.farben.entity.SysUserLog;
import com.farben.mapper.SysUserLogMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysUserLogService {

    @Resource
    SysUserLogMapper sysUserLogMapper;

    public void insertSysUserLog (SysUserLog sysUserLog) {
        sysUserLogMapper.saveSysUser(sysUserLog);
    }

}
