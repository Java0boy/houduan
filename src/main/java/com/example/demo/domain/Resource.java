package com.example.demo.domain;

public class Resource {
    private String username;
    private String resourcename;
    private String url;
    public String getResourcename() {
        return resourcename;
    }

    public void setResourcename(String resourcename) {
        this.resourcename= resourcename;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url= url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username= username;
    }
}
