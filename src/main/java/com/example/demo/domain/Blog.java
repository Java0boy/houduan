package com.example.demo.domain;


import java.util.Date;


public class Blog {
    // TODO: 还有很多属性，比如最新更新时间、所属用户等没有加上
    // 标题
    private String title;
    // 作者
    private String username;
    // 更新时间
    private String date;
    // md格式的存储，先用string吧（用于编辑博文
    private String blogMd;
    // html格式的存储，先用string吧（用于显示博文
    private String blogHtml;
    // ID (前端用username+timestamp生成的
    private String blogid;

    private String id;

    public String getBlogHtml() {
        return blogHtml;
    }

    public String getTitle() {
        return title;
    }

    public String getBlogMd() {
        return blogMd;
    }

    public void setBlogHtml(String blogHtml) {
        this.blogHtml = blogHtml;
    }

    public void setBlogMd(String blogMd) {
        this.blogMd = blogMd;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getblogId() {
        return blogid;
    }

    public void setblogId(String blogid) {
        this.blogid = blogid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
