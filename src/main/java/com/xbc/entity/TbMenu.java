package com.xbc.entity;


public class TbMenu {

  private int id;
  private int upid;
  private String menuName;
  private String menuPath;
  private int menuLevel;


  public TbMenu(int id, int upid, String menuName, String menuPath, int menuLevel) {
    this.id = id;
    this.upid = upid;
    this.menuName = menuName;
    this.menuPath = menuPath;
    this.menuLevel = menuLevel;
  }

  public TbMenu(int id, int upid, String menuName, int menuLevel) {
    this.id = id;
    this.upid = upid;
    this.menuName = menuName;
//    this.menuPath = menuPath;
    this.menuLevel = menuLevel;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public long getUpid() {
    return upid;
  }

  public void setUpid(int upid) {
    this.upid = upid;
  }


  public String getMenuName() {
    return menuName;
  }

  public void setMenuName(String menuName) {
    this.menuName = menuName;
  }


  public String getMenuPath() {
    return menuPath;
  }

  public void setMenuPath(String menuPath) {
    this.menuPath = menuPath;
  }

  public int getMenuLevel() {
    return menuLevel;
  }

  public void setMenuLevel(int menuLevel) {
    this.menuLevel = menuLevel;
  }

  @Override
  public String toString() {
    return "TbMenu{" +
            "id=" + id +
            ", upid=" + upid +
            ", menuName='" + menuName + '\'' +
            ", menuPath='" + menuPath + '\'' +
            '}';
  }
}
