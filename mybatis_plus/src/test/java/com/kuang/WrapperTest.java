package com.kuang;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kuang.mapper.UserMapper;
import com.kuang.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * @ClassName WrapperTest
 * @Description TODO
 * @Author Lambert
 * @Date 2021/4/27 18:25
 * @Version 1.0
 **/
@SpringBootTest
public class WrapperTest {
    @Autowired
    private UserMapper userMapper;


    @Test
    void contextLoads() {
        //查询name和邮箱不为空的用户，年龄大于等于12岁
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper
                .isNotNull("name")
                .isNotNull("email")
                .ge("age", 12);
        userMapper.selectList(wrapper).forEach(System.out::println);//
    }

    @Test
    void test2(){
      //查询name为Tom的数据
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.
                eq("name", "Tom");
        User user = userMapper.selectOne(wrapper);
        System.out.println(user);
    }

    @Test
    void test3(){
        //查询年龄在20~30岁之间的用户数量
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.between("age", 20, 30);
        System.out.println(userMapper.selectCount(wrapper));
    }

    @Test
    void test4(){
        //模糊查询
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //likeLeft/Right  %e  e%
        wrapper
                .notLike("name", "e")
                .likeRight("email", "t");

        List<Map<String, Object>> maps = userMapper.selectMaps(wrapper);
        maps.forEach(System.out::println);
    }

    @Test
    void test5(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //id在子查询中查出来
        wrapper.inSql("id", "select id from user where id<5");
        List<User> userList = userMapper.selectList(wrapper);
        userList.forEach(System.out::println);
    }

    @Test
    void test6(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //通过id进行排序  Desc降序 Asc升序
        wrapper.orderByDesc("id");
        List<User> userList = userMapper.selectList(wrapper);
        userList.forEach(System.out::println);
    }



}
