package com.example.demo.controller;

//<<<<<<< HEAD
import com.example.demo.domain.*;
import com.mongodb.client.result.UpdateResult;
//=======
import com.example.demo.domain.Blog;
import com.example.demo.domain.Interest;
//>>>>>>> fc137d305823a94c100f9411807a8bbdab21aa60
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import org.springframework.data.mongodb.core.query.Update;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.SignUp;

import com.example.demo.domain.Interest;
@RestController
@RequestMapping("/rest")
public class InterestController {
    @Autowired
    private MongoTemplate mongoTemplate;
    @RequestMapping(value = "/interest", method = RequestMethod.POST)
    public Boolean Interest(@RequestBody SignUp signup) {
        Query query = new Query(Criteria.where("userName").is(signup.getUserName()));
        SignUp signUp = mongoTemplate.findOne(query, SignUp.class);
        for(int i=0;i<signUp.getInterested().size();i++){
            if(signUp.getInterested().get(i)==signup.getUserName()){
                return false;
            }
        }
        return true;
    }
    @RequestMapping(value = "/guanzhu", method = RequestMethod.POST)
    public boolean addInterest(@RequestBody Interest interest){
        Query query1 = new Query(Criteria.where("userName").is(interest.getInterest()));
        SignUp signUp1=mongoTemplate.findOne(query1, SignUp.class);
        signUp1.addInterest(interest.getInterested());
        System.out.println(signUp1.getInterest());
        Update update1=Update.update("interest",signUp1.getInterest());
        mongoTemplate.updateFirst(query1,update1,SignUp.class);
        Query query2 = new Query(Criteria.where("userName").is(interest.getInterested()));
        SignUp signUp2=mongoTemplate.findOne(query2, SignUp.class);
        signUp2.addInterested(interest.getInterest());
        System.out.println(signUp2.getInterested());
        Update update2=Update.update("interested",signUp2.getInterested());
        mongoTemplate.updateFirst(query2,update2,SignUp.class);
        return true;
    }
    @RequestMapping(value = "/quxiaoguanzhu", method = RequestMethod.POST)

    public boolean removeInterested(@RequestBody Interest interest){

        Query query3 = new Query(Criteria.where("userName").is(interest.getInterest()));
        SignUp signUp3=mongoTemplate.findOne(query3, SignUp.class);
        signUp3.removeInterest(interest.getInterested());
        Update update1=Update.update("interest",signUp3.getInterest());
        mongoTemplate.updateFirst(query3,update1,SignUp.class);
        Query query4 = new Query(Criteria.where("userName").is(interest.getInterested()));
        SignUp signUp4=mongoTemplate.findOne(query4, SignUp.class);
        signUp4.removeInterested(interest.getInterest());
        System.out.println(signUp4.getInterested());
        Update update2=Update.update("interested",signUp4.getInterested());
        mongoTemplate.updateFirst(query4,update2,SignUp.class);
        return true;

    }

}
