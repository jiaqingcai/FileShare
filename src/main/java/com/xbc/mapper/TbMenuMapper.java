package com.xbc.mapper;

import com.xbc.entity.TbMenu;
import com.xbc.entity.TbRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbMenuMapper {
//    List<TbMenu> findAllByIdResult(int roleid);
 List<TbRole> findAllByIdResult(@Param("roleId") Integer roleId);
     List<TbMenu> findSecondMenu(@Param("upidlist") List<Integer> list);
}
