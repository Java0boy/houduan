package com.example.demo.domain;

public class Resource implements Comparable<Resource>{
    private String username;
    private String resourcename;
    private String url;
    private String timestamp;
    public String getResourcename() {
        return resourcename;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp= timestamp;
    }

    public String getTimestamp() {
        return timestamp;
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
    @Override
    public int compareTo(Resource resource){
        if(this.getTimestamp().compareTo(resource.getTimestamp())>=0)
            return -1;
        else
            return 1;
    }
}
