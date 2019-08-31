package com.example.demo.controller;
import com.example.demo.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import com.example.demo.domain.SignUp;

import java.util.Random;

@RestController
@RequestMapping(value = "/rest", produces = "application/json;charset=utf-8")
public class SignupController {
    @Autowired
    private MongoTemplate mongoTemplate;
    private final Logger logger = (Logger)
            LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JavaMailSender mailSender;
    @RequestMapping(value = "/mail", method = RequestMethod.POST)
    public String mail(@RequestBody SignUp signup) {
        Random random=new Random();
        int a= (int) ((Math.random() * 9 + 1) * 100000);
        String yzm=String.valueOf(a);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("xhc19888@126.com");
        message.setTo(signup.getMail());
        message.setSubject("验证码");
        message.setText(yzm);
        try {
            mailSender.send(message);
            logger.info("简单邮件已经发送。");
        }catch (Exception e) {
            logger.error("发送简单邮件时发生异常！", e);
        }
        return yzm;
    }
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public Boolean Register(@RequestBody SignUp signUp) {
        Query query = new Query(Criteria.where("userName").is(signUp.getUserName()));
        SignUp signUp1 = mongoTemplate.findOne(query,SignUp.class);
        if(signUp1!=null){
            return false;
        }
        else {

            mongoTemplate.save(signUp);


            return Boolean.TRUE;
        }
    }

}