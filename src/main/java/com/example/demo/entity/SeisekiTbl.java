package com.example.demo.entity;

public class SeisekiTbl {

    int user_no;
    int mondai_id;
    int user_id;
    int NG_count;
    int OK_count;

    public int getUser_no() {
        return this.user_no;
    }

    public void setUser_no(int user_no) {
        this.user_no = user_no;
    }

    public int getMondai_id() {
        return this.mondai_id;
    }

    public void setMondai_id(int mondai_id) {
        this.mondai_id = mondai_id;
    }

    public int getUser_id() {
        return this.user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getNG_count() {
        return this.NG_count;
    }

    public void setNG_count(int NG_count) {
        this.NG_count = NG_count;
    }

    public int getOK_count() {
        return this.OK_count;
    }

    public void setOK_count(int OK_count) {
        this.OK_count = OK_count;
    }

}
