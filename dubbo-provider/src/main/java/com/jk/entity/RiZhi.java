package com.jk.entity;

import java.io.Serializable;

public class RiZhi implements Serializable{

    private static final long serialVersionUID = 7351778147941080552L;

    private Integer rid;

    private String rtype;

    private String rname;

    private String rtime;


    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRtype() {
        return rtype;
    }

    public void setRtype(String rtype) {
        this.rtype = rtype;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getRtime() {
        return rtime;
    }

    public void setRtime(String rtime) {
        this.rtime = rtime;
    }
}
