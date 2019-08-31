package com.example.demo.controller;
import com.example.demo.domain.SignUp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rest", produces = "application/json;charset=utf-8")
public class UpdateUser {
    @Autowired
    private MongoTemplate mongoTemplate;
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public Boolean updateuser(@RequestBody SignUp signUp) {
        Query query = new Query(Criteria.where("userName").is(signUp.getUserName()));
        SignUp signUp1 = mongoTemplate.findOne(query,SignUp.class);
        Update update1=Update.update("age",signUp.getAge());
        Update update2=Update.update("sex",signUp.getSex());
        mongoTemplate.updateFirst(query,update1,SignUp.class);
        mongoTemplate.updateFirst(query,update2,SignUp.class);
        return true;
    }
}
