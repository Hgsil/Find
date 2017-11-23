package com.hgsil.find.data;

import org.litepal.crud.DataSupport;

/**
 * Created by Administrator on 2017/11/21 0021.
 */

public class Information extends DataSupport{
    private String who;
    private String information;
    private String phone;
    private String number;

    public Information(String who, String information, String phone,String number) {
        this.who = who;
        this.information = information;
        this.phone = phone;
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Information() {
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
