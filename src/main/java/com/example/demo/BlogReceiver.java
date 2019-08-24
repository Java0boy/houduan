package com.example.demo;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class BlogReceiver {
    private Blog tmpBlog;

    @RequestMapping(value = "/postBlog", method = RequestMethod.POST)
    public Boolean PostBlog(@RequestBody Blog blog)
    {
        System.out.printf(blog.getTitle());
        System.out.printf(blog.getBlogHtml());
        System.out.printf(blog.getBlogMd());
        System.out.printf(blog.getId());
        // TODO: 永久保存此博客至数据库，我认为Id可以作为key
        // 目前我就暂存一下，应付一下目前的调试
        this.tmpBlog = blog;

        return Boolean.TRUE;
    };

    @RequestMapping(value = "/getBlogHtml", method = RequestMethod.POST)
    public String GetBlogHtml(@RequestBody String blogId)
    {
        // TODO: 根据传来的Id,去数据库里查找对应的博客，下面的方法也是一样,我就不写注释了
        // 目前我就暂时用这个暂存的来应付测试
        return this.tmpBlog.getBlogHtml();
    }

    @RequestMapping(value = "/getBlogMd", method = RequestMethod.POST)
    public String GetBlogMd(@RequestBody String blogId)
    {
        return this.tmpBlog.getBlogMd();
    }
}
