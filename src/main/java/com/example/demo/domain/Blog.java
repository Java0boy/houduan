package com.example.demo.domain;


import java.util.ArrayList;
import java.util.List;


public class Blog implements Comparable<Blog>{
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

    private String id;

    private String timestamp;

    private long liulancount=0;

    private long dianzancount=0;

    private List<String> dianzaned= new ArrayList<>();

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

    public long getLiulancount() {
        return liulancount;
    }

    public void setLiulancount(long liulancount) {
        this.liulancount = liulancount;
    }

    public long getDianzancount() {
        return dianzancount;
    }

    public void setDianzancount(long dianzancount) {
        this.dianzancount = dianzancount;
    }

    public String getId() {
        return id;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getTimestamp() {
        return timestamp;
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

    public List<String> getDianzaned() {
        return dianzaned;
    }

    public void setDianzaned(List<String> dianzaned) {
        this.dianzaned = dianzaned;
    }
    public void addDianzaned(String username){
        dianzaned.add(username);
    }
    public void removeDianzaned(String username){
        dianzaned.remove(username);
    }
    @Override
    public int compareTo(Blog blog){
        if(this.getTimestamp().compareTo(blog.getTimestamp())>=0)
            return -1;
        else
            return 1;
    }

}
