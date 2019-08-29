package com.example.demo.controller;

import com.example.demo.domain.*;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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
        System.out.println(interest.getInterest());
        System.out.println(interest.getInterested());
        Query query1 = new Query(Criteria.where("userName").is(interest.getInterest()));
        SignUp signUp1=mongoTemplate.findOne(query1, SignUp.class);
        signUp1.addInterest(interest.getInterested());
        System.out.println(signUp1.getInterest());
        Update update1=new Update().set("interested",signUp1.getInterest());
        Query query2 = new Query(Criteria.where("userName").is(interest.getInterested()));
        SignUp signUp2=mongoTemplate.findOne(query2, SignUp.class);
        signUp2.addInterested(interest.getInterest());
        System.out.println(signUp2.getInterested());
        Update update2=new Update().set("interested",signUp2.getInterested());
        return true;
    }
    @RequestMapping(value = "/quxiaoguanzhu", method = RequestMethod.POST)
    public boolean removeInterest(@RequestBody Interest interest){
        Query query1 = new Query(Criteria.where("userName").is(interest.getInterest()));
        mongoTemplate.findOne(query1, SignUp.class).removeInterest(interest.getInterest());
        Query query2 = new Query(Criteria.where("userName").is(interest.getInterested()));
        mongoTemplate.findOne(query2, SignUp.class).removeInterested(interest.getInterested());
        return true;
    }

}
