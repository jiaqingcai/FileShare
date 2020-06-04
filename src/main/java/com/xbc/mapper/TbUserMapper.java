package com.xbc.mapper;

import com.xbc.entity.TbUser;

import java.util.List;

public interface TbUserMapper {
    public int insertUser(TbUser tbUser);
    public List<TbUser> Userlist();
    public  List<TbUser> findById();
    public int upadteinfo(TbUser tbUser);
}
