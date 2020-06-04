package com.xbc.service.impl;

import com.xbc.entity.TbAdmin;

import com.xbc.mapper.TbAdminMapper;
import com.xbc.service.interfacee.AdminService;
import com.xbc.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
    @Autowired
    public TbAdminMapper TbAdminMapper;
    @Override
    public TbAdmin logincheck(TbAdmin tbAdmin) {
//        SqlSession SqlSession=SqlSessionFactoryUtils.getSqlSession();
//       TbAdminMapper TbAdminMapper= SqlSession.getMapper(TbAdminMapper.class);
        TbAdmin loginAdmin=TbAdminMapper.logincheck(tbAdmin);
        return loginAdmin;
    }

    @Override
    @Transactional
    public int insertAdmin(TbAdmin tbAdmin)
    {
        System.out.println("123");
        return 0;
    }
}
