package com.bawei.linkmanmodule.network.entity;

public class FriendListEntity {

    /**
     * id : 78
     * usercode : b3481cf9c4eb4174a070f9c701575df4
     * username : 171746201
     * pwd : null
     * sex : 1
     * birthday : 1999/06/17
     * headerimg : https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1577767407696&di=8cd3833713ec3b4226a1a44a65efbfbe&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201807%2F26%2F20180726134412_mkdnl.thumb.700_0.jpeg
     * nick : 叽里咕噜
     * utype : 0
     * imuseraccount : 171746201
     * signdesc : 一小段签名信息
     * openlocation : 0
     * openmsgalert : 3
     */

    private int id;
    private String usercode;
    private String username;
    private Object pwd;
    private String sex;
    private String birthday;
    private String headerimg;
    private String nick;
    private int utype;
    private String imuseraccount;
    private String signdesc;
    private int openlocation;
    private int openmsgalert;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Object getPwd() {
        return pwd;
    }

    public void setPwd(Object pwd) {
        this.pwd = pwd;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getHeaderimg() {
        return headerimg;
    }

    public void setHeaderimg(String headerimg) {
        this.headerimg = headerimg;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public int getUtype() {
        return utype;
    }

    public void setUtype(int utype) {
        this.utype = utype;
    }

    public String getImuseraccount() {
        return imuseraccount;
    }

    public void setImuseraccount(String imuseraccount) {
        this.imuseraccount = imuseraccount;
    }

    public String getSigndesc() {
        return signdesc;
    }

    public void setSigndesc(String signdesc) {
        this.signdesc = signdesc;
    }

    public int getOpenlocation() {
        return openlocation;
    }

    public void setOpenlocation(int openlocation) {
        this.openlocation = openlocation;
    }

    public int getOpenmsgalert() {
        return openmsgalert;
    }

    public void setOpenmsgalert(int openmsgalert) {
        this.openmsgalert = openmsgalert;
    }
}
