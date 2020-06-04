package com.xbc.service.interfacee;

import com.xbc.entity.TbAdmin;

public interface AdminService {
    public TbAdmin logincheck(TbAdmin  tbAdmin);
    public int insertAdmin(TbAdmin  tbAdmin);
}
