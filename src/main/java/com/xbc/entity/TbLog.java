package com.xbc.entity;


public class TbLog {

  private int id;
  private String logOperator;
  private String logLogevent;
  private String logTime;


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public String getLogOperator() {
    return logOperator;
  }

  public void setLogOperator(String logOperator) {
    this.logOperator = logOperator;
  }


  public String getLogLogevent() {
    return logLogevent;
  }

  public void setLogLogevent(String logLogevent) {
    this.logLogevent = logLogevent;
  }


  public String getLogTime() {
    return logTime;
  }

  public void setLogTime(String logTime) {
    this.logTime = logTime;
  }

}
