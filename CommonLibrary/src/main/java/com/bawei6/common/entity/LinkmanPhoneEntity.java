package com.bawei6.common.entity;

public class LinkmanPhoneEntity {
    String name;
    String number;
    String initial;
    int type;

    public LinkmanPhoneEntity(String name, String number, String initial, int type) {
        this.name = name;
        this.number = number;
        this.initial = initial;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getInitial() {
        return initial;
    }

    public void setInitial(String initial) {
        this.initial = initial;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
