package com.example.demo.domain;

import java.util.ArrayList;
import java.util.List;
public class SignUp {
    //用户名
    private String userName;
    //密码
    private String password;
    private String sex;
    private String age;
    private String mail;
    private List<String> interest=new ArrayList<>() ;
    private List<String> interested= new ArrayList<>();

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public List<String> getInterest() {
        return interest;
    }
    public void addInterest(String username){
        interest.add(username);
    }
    public void removeInterest(String username){
        interest.remove(username);
    }
    public void setInterest(List<String> interest) {
        this.interest = interest;
    }
    public List<String> getInterested() {
        return interested;
    }

    public void setInterested(List<String> interested) {
        this.interested = interested;
    }
    public void addInterested(String username){
        interested.add(username);
    }
    public void removeInterested(String username){
        interested.remove(username);
    }
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
