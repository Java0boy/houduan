package com.example.demo.controller;

import com.example.demo.domain.SignUp;
import com.example.demo.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rest", produces = "application/json;charset=utf-8")
public class LoginController {

    private final Logger logger = (Logger)
            LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MongoTemplate mongoTemplate;


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String Login(@RequestBody User user) {
        Query query = new Query(Criteria.where("userName").is(user.getUserName()));
        SignUp signUp = mongoTemplate.findOne(query, SignUp.class);
        if(signUp==null){
            return "11111111111";//用户名不存在
        }
        else{
            if (signUp.getPassword().equals(user.getPassword())) {
               return signUp.getUserName();//登录成功
            } else {
                return "22222222222";//密码错误
            }
        }

    }

}
