//package com.xbc.servlet;
//
//import com.xbc.entity.MenuNode;
//import com.xbc.entity.TbMenu;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class tt {
//    public static void main(String[] args) {
//        List<TbMenu> menuList = new ArrayList<>();
//        menuList.add(new TbMenu(1, 0, "1", 1));
//        menuList.add(new TbMenu(2, 0, "2", 1));
//        menuList.add(new TbMenu(3, 1, "11", 2));
//        menuList.add(new TbMenu(4, 1, "12", 2));
//        menuList.add(new TbMenu(5, 3, "111", 3));
//        menuList.add(new TbMenu(6, 2, "21", 2));
//
//        List<Integer> ids = new ArrayList<>();
//        ids.add(1);
//
//        menuList.stream()
//                .filter(m -> m.getMenuLevel() == 1)
//                .map(m -> {
//                    MenuNode node = new MenuNode();
//                    node.setId(m.getId());
//                    node.setName(m.getMenuName());
//                    if (ids.contains(m.getId())) {
//                        node.setChecked(true);
//                    }
//                    setChildren(node, menuList, ids);
//                    return node;
//                }).forEach(System.out::println);
////                .forEach(System.out::println);
//    }
//
//
//    /**
//     * 设置子节点
//     *
//     * @param n        当前节点
//     * @param menuList 所有资源
//     * @param ids      拥有权限节点id数组
//     */
//    private static void setChildren(MenuNode n, List<TbMenu> menuList, List<Integer> ids) {
//        boolean parentChecked = false;
//        List<TbMenu> c = menuList.stream()
//                .filter(m -> n.getId() == m.getUpid()).collect(Collectors.toList());
//        if (c.isEmpty()) {
//            return;
//        }
//        List<MenuNode> nodes = new ArrayList<>();
//        for (TbMenu m : c) {
//            MenuNode node = new MenuNode();
//            node.setName(m.getMenuName());
//            node.setId(m.getId());
//            if (ids.contains(m.getId()) || n.isChecked()) {
//                parentChecked = true;
//                node.setChecked(true);
//            }
//            setChildren(node, menuList, ids);
//            nodes.add(node);
//        }
//        n.setChildren(nodes);
//        n.setChecked(parentChecked);
//    }
//}
