package com.example.demo.controller;

import com.example.demo.domain.Blog;
import com.example.demo.domain.Interest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
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
    public void addInterest(@RequestBody Interest interest){
        Query query1 = new Query(Criteria.where("userName").is(interest.getInterest()));
        mongoTemplate.findOne(query1, SignUp.class).addInterest(interest.getInterest());
        Query query2 = new Query(Criteria.where("userName").is(interest.getInterested()));
        mongoTemplate.findOne(query2, SignUp.class).addInterested(interest.getInterested());
    }
    @RequestMapping(value = "/quxiaoguanzhu", method = RequestMethod.POST)
    public void removeInterest(@RequestBody Interest interest){
        Query query1 = new Query(Criteria.where("userName").is(interest.getInterest()));
        mongoTemplate.findOne(query1, SignUp.class).removeInterest(interest.getInterest());
        Query query2 = new Query(Criteria.where("userName").is(interest.getInterested()));
        mongoTemplate.findOne(query2, SignUp.class).removeInterested(interest.getInterested());
    }

}
