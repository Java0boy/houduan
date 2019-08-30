package com.example.demo.dao;

import com.example.demo.domain.User;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import com.example.demo.domain.Blog;
@Component      //标记UserImp为一个bean，后面可以用@Autowired直接创建对象
public class UserImp implements UserDao {
    @Autowired
    private MongoTemplate mongoTemplate;
    public void saveBlog(Blog blog) {
        System.out.println(mongoTemplate.toString());
        mongoTemplate.save(blog);
    }
   public void saveUser(User user) {
        mongoTemplate.save(user);
    }

    public void removeUser(Long id) {
        Query query = new Query(Criteria.where("id").is(id));//查找其id字段的值与传入参数id相等的数据
        mongoTemplate.remove(query,User.class);
    }

    public User findUserByName(String name) {
        Query query = new Query(Criteria.where("name").is(name));
        User user = mongoTemplate.findOne(query,User.class);
        return user;
    }
    public Blog Blogbytitle(String title) {
        Query query = new Query(Criteria.where("title").is(title));
        Blog blog = mongoTemplate.findOne(query,Blog.class);
        return blog;
    }
    public int updateUser(User user) {
       // Query query = new Query(Criteria.where("userN果集
        //UpdateResult all_result = mongoTemplate.uame").is(user.getUserName()));
        //        Update update = new Update().set("name",user.getUserName()).set("password",user.getPassword());
        //        //更新查询返回的结果集的第一条数据
        //       UpdateResult result = mongoTemplate.updateFirst(query,update,User.class);
        //       //更新查询到的所有结pdateMulti(query,update,User.class);
       ///  else
            return 0;
    }
}