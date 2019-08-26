package com.example.demo.controller;

import com.example.demo.dao.Encryption;
import com.example.demo.domain.Blog;
import com.example.demo.domain.SignUp;
import com.example.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import com.example.demo.domain.SignUp;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/rest")
public class SearchUser {
    @Autowired
    private MongoTemplate mongoTemplate;
    @RequestMapping(value = "/getUserMessage", method = RequestMethod.POST)
    public String getmessage(@RequestBody User _user) {
      /*  System.out.println(_user.getUserName());
        Encryption e2 = new Encryption();
        Query query = new Query(Criteria.where("userName").is(_user.getUserName()));
        SignUp signUp = mongoTemplate.findOne(query, SignUp.class);
        if (signUp == null) {
            return null;
        }
        else{
            return signUp;
        }*/
        return _user.getUserName();
    }

    @RequestMapping(value = "/getUserInfo", method = RequestMethod.POST)
    public SignUp getmessage2(@RequestBody User _user) {
        Encryption e2 = new Encryption();
        Query query = new Query(Criteria.where("userName").regex(_user.getUserName()));
        SignUp signUp = mongoTemplate.findOne(query, SignUp.class);
        if (signUp == null) {
            return null;
        }
        else{
            return signUp;
        }

    }
}
