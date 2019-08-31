package com.example.demo.controller;

import com.example.demo.domain.Resource;
import com.example.demo.domain.SignUp;
import com.example.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collections;
import java.util.List;

public class PictureController {
    @Autowired
    private MongoTemplate mongoTemplate;

    @RequestMapping(value = "/uploadpicture", method = RequestMethod.POST)
    public Boolean PostBlog(@RequestBody Resource resource)
    {
        Query query = new Query(Criteria.where("userName").is(resource.getUsername()));
        SignUp signUp=mongoTemplate.findOne(query,SignUp.class);
        signUp.setUrl(resource.getUrl());
        Update update=Update.update("resources",signUp.getUrl());
        mongoTemplate.updateFirst(query,update,SignUp.class);
        return Boolean.TRUE;
    }
    @RequestMapping(value = "/getPicture", method = RequestMethod.POST)
    public String getPicture(@RequestBody User user)
    {
        Query query = new Query(Criteria.where("userName").is(user.getUserName()));
        SignUp signUp=mongoTemplate.findOne(query,SignUp.class);
        return signUp.getUrl();
    }
}
