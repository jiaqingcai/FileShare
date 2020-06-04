package com.xbc.service.impl;

import com.xbc.entity.TbUser;
import com.xbc.mapper.TbUserMapper;
import com.xbc.service.interfacee.UserServicce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("userService")
public class UserServiceImpl implements UserServicce {
@Autowired
public TbUserMapper TbUserMapper;
    @Override
    public int insertUser(TbUser tbUser) {
        return 0;
    }

    @Override
    public List<TbUser> Userlist() {
        return null;
    }

    @Override
    public List<TbUser> findById() {

        return TbUserMapper.findById();
    }

    @Override
    public int upadteinfo(TbUser tbUser) {
        return 0;
    }
}
