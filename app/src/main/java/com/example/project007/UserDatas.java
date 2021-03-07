package com.example.project007;

public class UserDatas {

   String  uname,uphone,uemail,upassword;

    public UserDatas() {

    }

    public UserDatas(String uname, String uphone, String uemail, String upassword) {
        this.uname = uname;
        this.uphone = uphone;
        this.uemail = uemail;
        this.upassword = upassword;
    }

    public String getName() {
        return uname;
    }

    public void setName(String uname) {
        this.uname = uname;
    }

    public String getPhone() {
        return uphone;
    }

    public void setPhone(String uphone) {
        this.uphone = uphone;
    }

    public String getEmail() {
        return uemail;
    }

    public void setEmail(String uemail) {
        this.uemail = uemail;
    }

    public String getPassword() {
        return upassword;
    }

    public void setPassword(String upassword) {
        this.upassword = upassword;
    }
}
