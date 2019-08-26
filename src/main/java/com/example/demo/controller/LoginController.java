package com.example.demo.controller;

import com.example.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import com.example.demo.domain.SignUp;
import com.example.demo.dao.Encryption;
@RestController
@RequestMapping("/rest")
public class LoginController {
    @Autowired
    private MongoTemplate mongoTemplate;
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String Login(@RequestBody User user) {
        Encryption e2=new Encryption();
        Query query = new Query(Criteria.where("userName").regex(user.getUserName()));
        SignUp signUp = mongoTemplate.findOne(query, SignUp.class);
        if(signUp==null){
            System.out.println("x");
            return "11111111111";//用户名不存在
        }
        else{
            signUp.setPassword(e2.decrypt(signUp.getPassword()));
            //System.out.println(signUp.getPassword());
          //  System.out.println(user.getPassword());
            if (signUp.getPassword().equals(user.getPassword())) {
               return signUp.getUserName();//登录成功
            } else {
                System.out.println("y");
                return "22222222222";//密码错误
            }
        }
    }

}
