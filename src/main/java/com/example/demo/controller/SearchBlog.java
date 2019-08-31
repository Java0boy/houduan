package com.example.demo.controller;

import com.example.demo.domain.Blog;
import com.example.demo.domain.SignUp;
import com.example.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.domain.Dianzan;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "/rest", produces = "application/json;charset=utf-8")
public class SearchBlog {
    @Autowired
    private MongoTemplate mongoTemplate;


    @RequestMapping(value = "/getBlog", method = RequestMethod.POST)
    public Blog GetBlog(@RequestBody Blog _blog)
    {
        // 根据传来的Id,去数据库里查找对应的博客，下面的方法也是一样,我就不写注释了
        Query query = new Query(Criteria.where("_id").is(_blog.getId()));
        Blog blog = mongoTemplate.findOne(query, Blog.class);
        return blog;
    }


    @RequestMapping(value = "/getBlogHtml", method = RequestMethod.POST)
    public String GetBlogHtml(@RequestBody Blog _blog)
    {
        // 根据传来的Id,去数据库里查找对应的博客，下面的方法也是一样,我就不写注释了
        Query query = new Query(Criteria.where("_id").is(_blog.getId()));
        Blog blog = mongoTemplate.findOne(query, Blog.class);
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
        Query query = new Query(Criteria.where("username").is(_user.getUserName()));
        List<Blog> blog = mongoTemplate.find(query, Blog.class);
        if(blog==null){
            return null;
        }
        else {
            return blog;
        }
    }
    @RequestMapping(value = "/getBlogByBlog", method = RequestMethod.POST)
    public List<Blog> GetBlogByBlog(@RequestBody Blog blog)
    {
        // 根据传来的Id,去数据库里查找对应的博客，下面的方法也是一样,我就不写注释了
        Query query = new Query(Criteria.where("title").regex(blog.getTitle(),"i"));
        List<Blog> blog1 = mongoTemplate.find(query, Blog.class);
        Collections.sort(blog1);
        if(blog1==null){
            return null;
        }
        else {
            return blog1;
        }
    }

    @RequestMapping(value = "/getBlogMd", method = RequestMethod.POST)
    public String GetBlogMd(@RequestBody Blog _blog)
    {
        Query query = new Query(Criteria.where("_id").is(_blog.getId()));
        Blog blog = mongoTemplate.findOne(query, Blog.class);
        return blog.getBlogMd();
    }

    @RequestMapping(value = "/getBlogTitle", method = RequestMethod.POST)
    public String GetBlogTitle(@RequestBody Blog _blog)
    {
        Query query = new Query(Criteria.where("_id").is(_blog.getId()));
        Blog blog = mongoTemplate.findOne(query, Blog.class);
        return blog.getTitle();
    }

    @RequestMapping(value = "/getBlogAuthor", method = RequestMethod.POST)
    public String GetBlogAuthor(@RequestBody Blog _blog)
    {
        Query query = new Query(Criteria.where("_id").is(_blog.getId()));
        Blog blog = mongoTemplate.findOne(query, Blog.class);
        return blog.getUsername();
    }

    @RequestMapping(value = "/getBlogDate", method = RequestMethod.POST)
    public String GetBlogDate(@RequestBody Blog _blog)
    {
        Query query = new Query(Criteria.where("_id").is(_blog.getId()));
        Blog blog = mongoTemplate.findOne(query, Blog.class);
        return blog.getDate();
    }
    @RequestMapping(value = "/dianzan", method = RequestMethod.POST)
    public boolean dianzan(@RequestBody Dianzan dianzan)
    {
        Query query = new Query(Criteria.where("_id").is(dianzan.getDianzaned()));
        Blog blog = mongoTemplate.findOne(query, Blog.class);
        blog.addDianzaned(dianzan.getDianzan());
        Update update1=Update.update("dianzaned",blog.getDianzaned());
        Update update2=Update.update("dianzancount",blog.getDianzancount()+1L);
        mongoTemplate.updateFirst(query,update1, Blog.class);
        mongoTemplate.updateFirst(query,update2, Blog.class);
        return true;
    }
    @RequestMapping(value = "/quxiaodianzan", method = RequestMethod.POST)
    public boolean quxiaodianzan(@RequestBody Dianzan dianzan)
    {
        Query query = new Query(Criteria.where("_id").is(dianzan.getDianzaned()));
        Blog blog = mongoTemplate.findOne(query, Blog.class);
        blog.removeDianzaned(dianzan.getDianzan());
        Update update1=Update.update("dianzaned",blog.getDianzaned());
        Update update2=Update.update("dianzancount",blog.getDianzancount()-1L);
        mongoTemplate.updateFirst(query,update1, Blog.class);
        mongoTemplate.updateFirst(query,update2, Blog.class);
        return true;
    }
    @RequestMapping(value = "/chadianzan", method = RequestMethod.POST)
    public boolean chadianzan(@RequestBody Dianzan dianzan)
    {
        Query query = new Query(Criteria.where("_id").is(dianzan.getDianzaned()));
        Blog blog = mongoTemplate.findOne(query, Blog.class);
        blog.setLiulancount(blog.getLiulancount()+1);
        Update update=Update.update("liulancount",blog.getLiulancount());
        mongoTemplate.updateFirst(query,update, Blog.class);
        for(int i=0;i<blog.getDianzaned().size();i++){
            if(blog.getDianzaned().get(i).equals(dianzan.getDianzan())){
                return false;
            }
        }
        return true;
    }
    @RequestMapping(value = "/getallBlog", method = RequestMethod.POST)
    public List<Blog> GetAllBlog()
    {
        System.out.println("here");
        long time1 = System.currentTimeMillis()-259200000L;//和当前时间相差三天
        String time=String.valueOf(time1);
        Query query = new Query(Criteria.where("timestamp").gte(time));
        List<Blog> blogs=mongoTemplate.find(query,Blog.class);
        for(int i=0;i<blogs.size();i++){
            for(int j=i+1;j<blogs.size();j++){
                if(blogs.get(i).getDianzancount()*0.9+blogs.get(i).getLiulancount()*0.1<blogs.get(j).getDianzancount()*0.9+blogs.get(j).getLiulancount()*0.1){
                    Collections.swap(blogs,i,j);
                }
            }
        }
        return blogs;
    }

}
