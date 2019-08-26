package com.example.demo.controller;

import com.example.demo.domain.SignUp;
import com.example.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.mongodb.core.MongoTemplate;
import com.example.demo.dao.Encryption;
@RestController
@RequestMapping("/rest")
public class SignupController {
    @Autowired
    private MongoTemplate mongoTemplate;
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public Boolean Register(@RequestBody SignUp signUp) {
        Query query = new Query(Criteria.where("userName").is(signUp.getUserName()));
        SignUp signUp1 = mongoTemplate.findOne(query,SignUp.class);
        if(signUp1!=null){
            return false;
        }
        else {
            Encryption e1 = new Encryption();
            signUp.setPassword(e1.encrypt(signUp.getPassword()));
            mongoTemplate.save(signUp);
        /*System.out.printf("用户名" + Signupuser.getUserName());
        System.out.printf("用户密码" + Signupuser.getPassword());
        System.out.printf("用户性别" + Signupuser.getSex());
        System.out.printf("用户年龄" + Signupuser.getAge());*/

            return Boolean.TRUE;
        }
    }

}