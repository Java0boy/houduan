package com.example.demo.controller;

import com.example.demo.dao.Encryption;
import com.example.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rest", produces = "application/json;charset=utf-8")
public class Searchpwd {
    @Autowired
    private MongoTemplate mongoTemplate;
    Encryption e3=new Encryption();
    @RequestMapping(value = "/searchpwd", method = RequestMethod.POST)
    public String searchpwd(String username){
        Query query = new Query(Criteria.where("userName").is(username));
        User user = mongoTemplate.findOne(query,User.class);
        if(user==null){
            return "用户名不存在";
        }
        else {
            user.setPassword(e3.decrypt(user.getPassword()));
            return user.getPassword();
        }
    }

}
