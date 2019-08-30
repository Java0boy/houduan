package com.example.demo.domain;

public class Comment {
    private String username;
    // 更新时间
    private String date;

    private String comment;

    private String id;

    private Blog blog;

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
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

    public String getcomment() {
        return comment;
    }

    public void setcomment(String comment) {
        this.comment= comment;
    }
}
