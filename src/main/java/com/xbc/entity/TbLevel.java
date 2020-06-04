package com.xbc.entity;


public class TbLevel {

  private int id;
  private String lName;
  private String lUploadscale;
  private String lDownloadscale;


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getLName() {
    return lName;
  }

  public void setLName(String lName) {
    this.lName = lName;
  }


  public String getLUploadscale() {
    return lUploadscale;
  }

  public void setLUploadscale(String lUploadscale) {
    this.lUploadscale = lUploadscale;
  }


  public String getLDownloadscale() {
    return lDownloadscale;
  }

  public void setLDownloadscale(String lDownloadscale) {
    this.lDownloadscale = lDownloadscale;
  }

  @Override
  public String toString() {
    return "TbLevel{" +
            "id=" + id +
            ", lName='" + lName + '\'' +
            ", lUploadscale='" + lUploadscale + '\'' +
            ", lDownloadscale='" + lDownloadscale + '\'' +
            '}';
  }
}
