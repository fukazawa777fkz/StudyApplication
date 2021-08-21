package com.example.demo.form;

public class UserData {
    public int user_no;
    public int level;
    public String user_id;
    public String password;
    public String last_name;
    public String first_name;
    public String title_img_path;

    public int getUser_no() {
        return this.user_no;
    }

    public void setUser_no(int user_no) {
        this.user_no = user_no;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getUser_id() {
        return this.user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLast_name() {
        return this.last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return this.first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getTitle_img_path() {
        return this.title_img_path;
    }

    public void setTitle_img_path(String title_img_path) {
        this.title_img_path = title_img_path;
    }
}
