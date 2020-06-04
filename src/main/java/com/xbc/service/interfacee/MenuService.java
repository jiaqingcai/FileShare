package com.xbc.service.interfacee;

import com.xbc.entity.TbMenu;
import com.xbc.entity.TbRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuService {

    List<TbRole>  findAllByIdResult(@Param("roleId") Integer roleId);
    List<TbMenu> findSecondMenu(@Param("upidlist") List<Integer> list);
}
