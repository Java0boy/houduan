package com.example.demo.controller;

import com.example.demo.domain.Blog;
import com.example.demo.domain.SignUp;
import com.example.demo.domain.User;
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
public class BlogController {
    @Autowired
    private MongoTemplate mongoTemplate;

    @RequestMapping(value = "/postBlog", method = RequestMethod.POST)
    public Boolean PostBlog(@RequestBody Blog blog)
    {
        mongoTemplate.save(blog);
        return Boolean.TRUE;
    }




}
