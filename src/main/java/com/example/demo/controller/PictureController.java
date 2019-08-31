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
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class PictureController {
    @Autowired
    private MongoTemplate mongoTemplate;

    @RequestMapping(value = "/uploadPicture", method = RequestMethod.POST)
    public Boolean UploadPic(@RequestBody Resource resource)
    {
        System.out.println("p");
        System.out.println("receive: " + resource.getUrl());
        Query query = new Query(Criteria.where("userName").is(resource.getUsername()));
        SignUp signUp=mongoTemplate.findOne(query,SignUp.class);
        signUp.setUrl(resource.getUrl());
        Update update=Update.update("url",signUp.getUrl());
        mongoTemplate.updateFirst(query,update,SignUp.class);
        return Boolean.TRUE;
    }
    @RequestMapping(value = "/getPicture", method = RequestMethod.POST)
    public String getPicture(@RequestBody User user)
    {
        System.out.println("get");
        System.out.println(user.getUserName());
        Query query = new Query(Criteria.where("userName").is(user.getUserName()));
        SignUp signUp=mongoTemplate.findOne(query,SignUp.class);
        System.out.println("give:" + signUp.getUrl());
        return signUp.getUrl();
    }
}
