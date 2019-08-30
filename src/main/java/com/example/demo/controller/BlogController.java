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
@RequestMapping("/rest")
public class BlogController {
    @Autowired
    private MongoTemplate mongoTemplate;

    @RequestMapping(value = "/postBlog", method = RequestMethod.POST)
    public Boolean PostBlog(@RequestBody Blog blog)
    {
       // Query query = new Query(Criteria.where("_id").is(blog.getId()));
       // mongoTemplate.remove(query, Blog.class);
        mongoTemplate.save(blog);
        return Boolean.TRUE;
       /* System.out.printf(blog.getTitle());
        System.out.printf(blog.getUsername());
        System.out.printf(blog.getDate());
        System.out.printf(blog.getBlogHtml());
        System.out.printf(blog.getBlogMd());
        System.out.printf(blog.getId());*/

    };




}
