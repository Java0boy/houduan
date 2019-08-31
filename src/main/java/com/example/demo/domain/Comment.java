package com.example.demo.domain;

public class Comment implements Comparable<Comment>{
    private String username;
    // 更新时间
    private String date;

    private String comment;

    private String id;

    private String blogId;

    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }

    public String getBlogId() {
        return blogId;
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
    @Override
    public int compareTo(Comment comment){
        if(this.getId().compareTo(comment.getId())>=0)
            return -1;
        else
            return 1;
    }
}
