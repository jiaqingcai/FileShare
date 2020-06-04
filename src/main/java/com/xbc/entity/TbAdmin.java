package com.xbc.entity;


import java.util.List;

public class TbAdmin {

  private int id;
  private String adminAccount;
  private String adminName;
  private String adminPwd;
  private int roleId;
  private List<Object> List;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public String getAdminAccount() {
    return adminAccount;
  }

  public void setAdminAccount(String adminAccount) {
    this.adminAccount = adminAccount;
  }


  public String getAdminName() {
    return adminName;
  }

  public void setAdminName(String adminName) {
    this.adminName = adminName;
  }


  public String getAdminPwd() {
    return adminPwd;
  }

  public void setAdminPwd(String adminPwd) {
    this.adminPwd = adminPwd;
  }


  public int getRoleId() {
    return roleId;
  }

  public void setRoleId(int roleId) {
    this.roleId = roleId;
  }

  @Override
  public String toString() {
    return "TbAdmin{" +
            "id=" + id +
            ", adminAccount='" + adminAccount + '\'' +
            ", adminName='" + adminName + '\'' +
            ", adminPwd='" + adminPwd + '\'' +
            ", roleId=" + roleId +
            '}';
  }
}
