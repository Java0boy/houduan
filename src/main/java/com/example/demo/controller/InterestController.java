package com.example.demo.controller;



import com.example.demo.domain.Interest;
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
public class InterestController {
    @Autowired
    private MongoTemplate mongoTemplate;
    @RequestMapping(value = "/chaguanzhu", method = RequestMethod.POST)
    public Boolean Interest(@RequestBody Interest interest ) {
        Query query = new Query(Criteria.where("userName").is(interest.getInterest()));
        SignUp signUp = mongoTemplate.findOne(query, SignUp.class);
        for(int i=0;i<signUp.getInterest().size();i++){
            if(signUp.getInterest().get(i).equals(interest.getInterested())){
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
        Update update1=Update.update("interest",signUp1.getInterest());
        Update update2=Update.update("guanzhucount",signUp1.getGuanzhucount()+1L);
        mongoTemplate.updateFirst(query1,update1, SignUp.class);
        mongoTemplate.updateFirst(query1,update2, SignUp.class);
        Query query2 = new Query(Criteria.where("userName").is(interest.getInterested()));
        SignUp signUp2=mongoTemplate.findOne(query2, SignUp.class);
        signUp2.addInterested(interest.getInterest());
        Update update3=Update.update("interested",signUp2.getInterested());
        Update update4=Update.update("guanzhuedcount",signUp2.getGuanzhuedcount()+1L);
        mongoTemplate.updateFirst(query2,update3, SignUp.class);
        mongoTemplate.updateFirst(query2,update4, SignUp.class);
        return true;
    }
    @RequestMapping(value = "/quxiaoguanzhu", method = RequestMethod.POST)

    public boolean removeInterested(@RequestBody Interest interest){

        Query query3 = new Query(Criteria.where("userName").is(interest.getInterest()));
        SignUp signUp3=mongoTemplate.findOne(query3, SignUp.class);
        signUp3.removeInterest(interest.getInterested());
        Update update1=Update.update("interest",signUp3.getInterest());
        Update update2=Update.update("guanzhucount",signUp3.getGuanzhucount()-1L);
        mongoTemplate.updateFirst(query3,update1, SignUp.class);
        mongoTemplate.updateFirst(query3,update2, SignUp.class);
        Query query4 = new Query(Criteria.where("userName").is(interest.getInterested()));
        SignUp signUp4=mongoTemplate.findOne(query4, SignUp.class);
        signUp4.removeInterested(interest.getInterest());
        Update update3=Update.update("interested",signUp4.getInterested());
        Update update4=Update.update("guanzhuedcount",signUp4.getGuanzhuedcount()-1L);
        mongoTemplate.updateFirst(query4,update3, SignUp.class);
        mongoTemplate.updateFirst(query4,update4, SignUp.class);
        return true;

    }

}
