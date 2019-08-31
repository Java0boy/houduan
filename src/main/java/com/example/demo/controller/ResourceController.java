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

public class ResourceController {
    @Autowired
    private MongoTemplate mongoTemplate;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public Boolean PostBlog(@RequestBody Resource resource)
    {
        Query query = new Query(Criteria.where("userName").is(resource.getUsername()));
        SignUp signUp=mongoTemplate.findOne(query,SignUp.class);
        signUp.addResource(resource);
        Update update=Update.update("resources",signUp.getResources());
        mongoTemplate.updateFirst(query,update,SignUp.class);
        return Boolean.TRUE;
    }
}
