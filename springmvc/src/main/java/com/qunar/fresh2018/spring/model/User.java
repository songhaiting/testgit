package com.qunar.fresh2018.spring.model;

import java.util.Date;


/**
 * @author sht
 */
public class User {
    private int age;
    private int user_id;
    private boolean is_useable;
    private String sex;
    private String user_name;
    private String remarks;
    private Date create_time;
    private Date last_edit_time;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public boolean getIs_useable() {
        return is_useable;
    }

    public void setIs_useable(boolean is_useable) {
        this.is_useable = is_useable;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getLast_edit_time() {
        return last_edit_time;
    }

    public void setLast_edit_time(Date last_edit_time) {
        this.last_edit_time = last_edit_time;
    }

    public boolean isIs_useable() {
        return is_useable;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
