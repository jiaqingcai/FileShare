package com.xbc.entity;


public class TbUser {

  private int id;
  private String account;
  private String password;
  private String name;
  private String state;
  private String sex;
  private String phone;
  private String uemail;
  private String regtimr;
  private long integral;
  private int level;

  private TbLevel tbLevel;



  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public String getAccount() {
    return account;
  }

  public void setAccount(String account) {
    this.account = account;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }


  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }


  public String getUemail() {
    return uemail;
  }

  public void setUemail(String uemail) {
    this.uemail = uemail;
  }


  public String getRegtimr() {
    return regtimr;
  }

  public void setRegtimr(String regtimr) {
    this.regtimr = regtimr;
  }

  public long getIntegral() {
    return integral;
  }

  public void setIntegral(long integral) {
    this.integral = integral;
  }


  public int getLevel() {
    return level;
  }

  public void setLevel(int level) {
    this.level = level;
  }

  public TbLevel getTbLevel() {
    return tbLevel;
  }

  public void setTbLevel(TbLevel tbLevel) {
    this.tbLevel = tbLevel;
  }

  @Override
  public String toString() {
    return "TbUser{" +
            "id=" + id +
            ", account='" + account + '\'' +
            ", password='" + password + '\'' +
            ", name='" + name + '\'' +
            ", state='" + state + '\'' +
            ", sex='" + sex + '\'' +
            ", phone='" + phone + '\'' +
            ", uemail='" + uemail + '\'' +
            ", regtimr='" + regtimr + '\'' +
            ", integral=" + integral +
            ", level=" + level +
            ", tbLevel=" + tbLevel +
            '}';
  }
}
