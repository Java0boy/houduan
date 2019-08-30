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
@RequestMapping("/rest")
public class LoginController {

    private final Logger logger = (Logger)
            LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MongoTemplate mongoTemplate;


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String Login(@RequestBody User user) {




           /* SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("xiaoxueqi9@163.com");
            message.setTo("xhc19888@126.com");
            message.setSubject("验证码");
            message.setText("336012");

            try {
                mailSender.send(message);
                logger.info("简单邮件已经发送。");
            }catch (Exception e) {
                logger.error("发送简单邮件时发生异常！", e);
            }*/


        //Encryption e2=new Encryption();
        Query query = new Query(Criteria.where("userName").is(user.getUserName()));
        SignUp signUp = mongoTemplate.findOne(query, SignUp.class);
        if(signUp==null){
            return "11111111111";//用户名不存在
        }
        else{
            //signUp.setPassword(e2.decrypt(signUp.getPassword()));
            //System.out.println(signUp.getPassword());
          //  System.out.println(user.getPassword());
            if (signUp.getPassword().equals(user.getPassword())) {
               return signUp.getUserName();//登录成功
            } else {
                return "22222222222";//密码错误
            }
        }

    }

}
