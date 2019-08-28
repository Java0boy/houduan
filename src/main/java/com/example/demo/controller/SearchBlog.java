package com.example.demo.controller;

import com.example.demo.domain.Blog;
import com.example.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class SearchBlog {
    @Autowired
    private MongoTemplate mongoTemplate;


    @RequestMapping(value = "/getBlog", method = RequestMethod.POST)
    public Blog GetBlog(@RequestBody Blog _blog)
    {
        // 根据传来的Id,去数据库里查找对应的博客，下面的方法也是一样,我就不写注释了
        Query query = new Query(Criteria.where("_id").is(_blog.getId()));
        Blog blog = mongoTemplate.findOne(query,Blog.class);
        return blog;
    }

    @RequestMapping(value = "/getBlogHtml", method = RequestMethod.POST)
    public String GetBlogHtml(@RequestBody Blog _blog)
    {
        // 根据传来的Id,去数据库里查找对应的博客，下面的方法也是一样,我就不写注释了
        Query query = new Query(Criteria.where("_id").is(_blog.getId()));
        Blog blog = mongoTemplate.findOne(query,Blog.class);
        if(blog==null){
            return "1";
        }
        else
            return blog.getBlogHtml();
    }
    @RequestMapping(value = "/getBlogByUser", method = RequestMethod.POST)
    public List<Blog> GetBlogByUser(@RequestBody User _user)
    {
        // 根据传来的Id,去数据库里查找对应的博客，下面的方法也是一样,我就不写注释了
        Query query = new Query(Criteria.where("username").regex(_user.getUserName()));
        List<Blog> blog = mongoTemplate.find(query,Blog.class);
        if(blog==null){
            return null;
        }
        else {
            return blog;
        }
    }

    @RequestMapping(value = "/getBlogMd", method = RequestMethod.POST)
    public String GetBlogMd(@RequestBody Blog _blog)
    {
        Query query = new Query(Criteria.where("_id").is(_blog.getId()));
        Blog blog = mongoTemplate.findOne(query,Blog.class);
        return blog.getBlogMd();
    }

    @RequestMapping(value = "/getBlogTitle", method = RequestMethod.POST)
    public String GetBlogTitle(@RequestBody Blog _blog)
    {
        Query query = new Query(Criteria.where("_id").is(_blog.getId()));
        Blog blog = mongoTemplate.findOne(query,Blog.class);
        return blog.getTitle();
    }

    @RequestMapping(value = "/getBlogAuthor", method = RequestMethod.POST)
    public String GetBlogAuthor(@RequestBody Blog _blog)
    {
        Query query = new Query(Criteria.where("_id").is(_blog.getId()));
        Blog blog = mongoTemplate.findOne(query,Blog.class);
        return blog.getUsername();
    }

    @RequestMapping(value = "/getBlogDate", method = RequestMethod.POST)
    public String GetBlogDate(@RequestBody Blog _blog)
    {
        Query query = new Query(Criteria.where("_id").is(_blog.getId()));
        Blog blog = mongoTemplate.findOne(query,Blog.class);
        return blog.getDate();
    }
}
