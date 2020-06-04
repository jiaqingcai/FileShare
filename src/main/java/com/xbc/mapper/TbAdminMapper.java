package com.xbc.mapper;

import com.xbc.entity.TbAdmin;

public interface TbAdminMapper {
    public  TbAdmin logincheck(TbAdmin  tbAdmin);
     int insertAdmin(TbAdmin  tbAdmin);
}
