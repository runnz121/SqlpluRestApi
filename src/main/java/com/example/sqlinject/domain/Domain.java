package com.example.sqlinject.domain;

public class Domain { //VO(DTO) 컬럼관해 주고받을 객체


    static String MSGID;
    String REQDT;
    String RESDT;
    String PATCHTNUM;
    String WORKID;
    String WORKCATEGORY;
    String REQID;
    String REQIP;




    public String getMSGID() {
        return MSGID;
    }

    public void setMSGID(String MSGID) {
        this.MSGID = MSGID;
    }

    public String getREQDT() {
        return REQDT;
    }

    public void setREQDT(String REQDT) {
        this.REQDT = REQDT;
    }

    public String getRESDT() {
        return RESDT;
    }

    public void setRESDT(String RESDT) {this.RESDT = RESDT;
    }

    public String getPATCHTNUM() {
        return PATCHTNUM;
    }

    public void setPATCHTNUM(String PATCHTNUM) {
        this.PATCHTNUM = PATCHTNUM;
    }

    public String getWORKID() {
        return WORKID;
    }

    public void setWORKID(String WORKID) {
        this.WORKID = WORKID;
    }

    public String getWORKCATEGORY() {
        return WORKCATEGORY;
    }

    public void setWORKCATEGORY(String WORKCATEGORY) {
        this.WORKCATEGORY = WORKCATEGORY;
    }

    public String getREQID() {
        return REQID;
    }

    public void setREQID(String REQID) {
        this.REQID = REQID;
    }

    public String getREQIP() {
        return REQIP;
    }

    public void setREQIP(String REQIP) {
        this.REQIP = REQIP;
    }

}
