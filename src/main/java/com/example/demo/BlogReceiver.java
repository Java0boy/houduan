package com.example.demo;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class BlogReceiver {
    @RequestMapping(value = "/postBlog", method = RequestMethod.POST)
    public Boolean PostBlog(@RequestBody Blog blog)
    {
        System.out.printf(blog.getTitle());
        System.out.printf(blog.getBlogHtml());
        System.out.printf(blog.getBlogMd());
        System.out.printf(blog.getId());
        // 永久保存此博客


        return Boolean.TRUE;
    };

    @RequestMapping(value = "/getBlog", method = RequestMethod.POST)
    public String GetBlog(@RequestBody Blog blogId)
    {
        return "";
    }
}
