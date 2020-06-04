package com.xbc.test;

import com.xbc.entity.MenuNode;
import com.xbc.entity.TbMenu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestJava8 {
    public static void main(String[] args) {
        List<TbMenu> menuList=new ArrayList<TbMenu>();
        menuList.add(new TbMenu(1,0,"1级",1));
        menuList.add(new TbMenu(2,0,"1级",1));
        menuList.add(new TbMenu(3,1,"2级",2));
        menuList.add(new TbMenu(4,2,"2级",2));
        menuList.add(new TbMenu(5,3,"1-2-3级",3));

        List<Integer> transactionsIds =
                menuList.stream().filter(b -> b.getMenuLevel() == 1).map(TbMenu::getId).collect(Collectors.toList());

        transactionsIds.forEach(item->{
            System.out.println(item);
        });

    }
}
