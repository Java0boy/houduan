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

    private List<String> interest=new ArrayList<String>() ;
    private List<String> interested=new ArrayList<String>();
    private long guanzhucount;
    private long guanzhuedcount;
    private String url;
    private List<Resource> resources=new ArrayList<>();


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
    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }
    public void addResource(Resource resource){
        resources.add(resource);
    }
    public void removeResource(Resource resource){
        resources.remove(resource);
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
    public long getGuanzhucount() {
        return guanzhucount;
    }

    public void setGuanzhucount(long guanzhucount) {
        this.guanzhucount = guanzhucount;
    }
    public long getGuanzhuedcount() {
        return guanzhuedcount;
    }

    public void setGuanzhuedcount(long guanzhuedcount) {
        this.guanzhuedcount = guanzhuedcount;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
