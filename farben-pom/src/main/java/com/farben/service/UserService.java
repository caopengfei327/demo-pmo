package com.farben.service;

import com.alibaba.fastjson.JSONObject;
import com.farben.entity.UserInfo;
import com.farben.exception.CommonException;
import com.farben.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class UserService {

    private static final String ACCOUNTLEVEL = "3";

    @Resource
    private UserMapper userMapper;

    public JSONObject loginIn (String requestJson) {
        //解析请求报文
        JSONObject requestParam = JSONObject.parseObject(requestJson);
        //查询度智能云⽬录列表唯一标识
        String name = (String) requestParam.get("name");
        //交易流水号
        String password = (String) requestParam.get("password");

        UserInfo info = userMapper.getInfo(name, password);
        JSONObject rsp = new JSONObject();

        if (null == info) {
            log.error("用户[{}]信息不存在！",name);
            throw new CommonException("用户信息不存在!");
        }

        log.info("用户[{}]登录成功！",name);
        rsp.put("userName",name);
        rsp.put("accountLevel",info.getAccountLevel());
        rsp.put("department",info.getDepartment());
        return rsp;
    }

    public void Insert(String name,String password){
        userMapper.saveInfo(name, password);
    }
}