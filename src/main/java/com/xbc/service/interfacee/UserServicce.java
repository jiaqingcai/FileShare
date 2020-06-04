package com.xbc.service.interfacee;

import com.xbc.entity.TbUser;

import java.util.List;

public interface UserServicce {
    public int insertUser(TbUser tbUser);
    public List<TbUser> Userlist();
    public  List<TbUser> findById();
    public int upadteinfo(TbUser tbUser);
}
