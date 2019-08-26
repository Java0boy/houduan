package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.domain.Comment;
public class CommentController {
    @RestController
    @RequestMapping("/rest")
    public class BlogController {
        @Autowired
        private MongoTemplate mongoTemplate;

        @RequestMapping(value = "/postComment", method = RequestMethod.POST)
        public Boolean PostBlog(@RequestBody Comment comment) {
            mongoTemplate.save(comment);
            return Boolean.TRUE;
       /* System.out.printf(blog.getTitle());
        System.out.printf(blog.getUsername());
        System.out.printf(blog.getDate());
        System.out.printf(blog.getBlogHtml());
        System.out.printf(blog.getBlogMd());
        System.out.printf(blog.getId());*/
            // TODO: 永久保存此博客至数据库，我认为Id可以作为key
        }
    }
}

