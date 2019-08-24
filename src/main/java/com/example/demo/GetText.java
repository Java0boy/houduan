package com.example.demo;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class GetText {

    @RequestMapping(value = "/testPost", method = RequestMethod.POST)
    public Boolean PostBlog(@RequestBody InputText text)
    {
        System.out.println("内容所有者： " + text.getUsername());
        System.out.println("博文标题: " + text.getBlogTitle());
        System.out.println("内容： " + text.getContent());
        // 永久保存此博客


        return Boolean.TRUE;
    }

}
