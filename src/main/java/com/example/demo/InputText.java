package com.example.demo;
import javax.persistence.Entity;

@Entity
public class InputText {

    // 提交用户的用户名（假设用户名唯一
    private String username;
    // 题目
    private String blogTitle;
    // 先就一段话吧，字符串存
    // TODO: 改成用editor.md
    private String content;

    public String getUsername() {
        return username;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public String getContent() {
        return content;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }
}
