package com.xbc.entity;


import java.util.List;

public class TbRole {

  private int id;
  private String roleName;
  private List<TbMenu> menuList;


  public long getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  public List<TbMenu> getMenuList() {
    return menuList;
  }

  public void setMenuList(List<TbMenu> menuList) {
    this.menuList = menuList;
  }

  @Override
  public String toString() {
    return "TbRole{" +
            "id=" + id +
            ", roleName='" + roleName + '\'' +
            '}';
  }
}
