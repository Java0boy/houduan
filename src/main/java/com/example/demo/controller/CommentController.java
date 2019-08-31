package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.domain.Comment;
import com.example.demo.domain.Blog;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "/rest", produces = "application/json;charset=utf-8")
public class CommentController {

        @Autowired
        private MongoTemplate mongoTemplate;

        @RequestMapping(value = "/postComment", method = RequestMethod.POST)
        public Boolean PostBlog(@RequestBody Comment comment) {

            mongoTemplate.save(comment);
            return Boolean.TRUE;
        }

        @RequestMapping(value = "/getComment", method = RequestMethod.POST)
        public List<Comment> GetComment(@RequestBody Blog blog)
        {
            Query query = new Query(Criteria.where("blogId").is(blog.getId()));
            List<Comment> comment1 = mongoTemplate.find(query, Comment.class);
            Collections.sort(comment1);
            return comment1;
        }
}

