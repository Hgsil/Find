package com.hgsil.find.data;

import org.litepal.crud.DataSupport;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/11/22 0022.
 */

public class User extends DataSupport implements Serializable{
    private String number;
    private String name;
    private String password;

    public User() {
    }

    public User(String number, String name, String password) {
        this.number = number;
        this.name = name;
        this.password = password;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
