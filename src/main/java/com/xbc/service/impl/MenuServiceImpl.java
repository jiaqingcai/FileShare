package com.xbc.service.impl;

import com.xbc.entity.TbMenu;
import com.xbc.entity.TbRole;
import com.xbc.mapper.TbMenuMapper;
import com.xbc.service.interfacee.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("menuService")
public class MenuServiceImpl  implements MenuService {
    @Autowired
    public TbMenuMapper TbMenuMapper;
    @Override
    public List<TbRole> findAllByIdResult(Integer roleId) {

        return TbMenuMapper.findAllByIdResult(roleId);
    }

    @Override
    public List<TbMenu> findSecondMenu(List<Integer> list) {
        return TbMenuMapper.findSecondMenu(list);
    }
}
