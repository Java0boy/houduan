package com.example.demo;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/rest")
public class SignupController {

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public Boolean Login(@RequestBody SignUp Signupuser) {
        /*System.out.printf("用户名" + Signupuser.getUserName());
        System.out.printf("用户密码" + Signupuser.getPassword());
        System.out.printf("用户性别" + Signupuser.getSex());
        System.out.printf("用户年龄" + Signupuser.getAge());*/
        
        return Boolean.TRUE;
    }

}