package com.kuang;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kuang.mapper.UserMapper;
import com.kuang.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class MybatisPlusApplicationTests {

    /**
     * 继承了BaseMapper，所有的方法都来自父类
     * 同时可以编写自己的扩展方法
     */
    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        /**
         * 查询全部用户
         * 参数是一个Wrapper，条件构造器
         */
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);

    }

    //测试插入功能
    @Test
    public void testInsert(){
        User user = new User();
//        user.setId(6l);//手动插入
        user.setName("java");
        user.setAge(18);
        user.setEmail("2473758409");
        int result = userMapper.insert(user);//能自动生成id（雪花算法）
        System.out.println(result);
        System.out.println(user);

    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(6L);
        user.setEmail("2473758409@qq.com");
        user.setAge(30);
        //updateById参数是一个对象
        userMapper.updateById(user);
    }

    /**
     * 测试乐观锁成功
     */
    @Test
    public void testOptimisticLocker(){
        //1、查询用户信息
        User user = userMapper.selectById(1L);
        //2、修改用户信息
        user.setName("kuangshen");
        user.setEmail("2473758409@qq.com");
        //3、执行更新操作
        userMapper.updateById(user);
    }

    /**
     * 测试乐观锁失败!多线程下
     */
    @Test
    public void testOptimisticLocker2(){
        //线程一
        User user = userMapper.selectById(1L);
        user.setName("kuangshen111");
        user.setEmail("2473758409@qq.com");

        //线程二 模拟另一个线程插队操作
        User user2 = userMapper.selectById(1L);
        user2.setName("kuangshen222");
        user2.setEmail("2473758409@qq.com");

        userMapper.updateById(user2);

        userMapper.updateById(user);//如果没有乐观锁就会覆盖插队线程的值

    }


    /**
     * 测试查询
     */
    @Test
    public void testSelectById(){
        User user = userMapper.selectById(3l);
        System.out.println(user);
    }

    /**
     * 测试批量查询
     */
    @Test
    public void testSelectBatchIds(){
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        users.forEach(System.out::println);
    }

    /**
     * 条件查询 map
     */
    @Test
    public void testSelectByMap(){
        HashMap<String, Object> map = new HashMap<>();
        //自定义查询的条件
        map.put("name", "java");
        map.put("age", 30);
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }

    /**
     * 测试分页查询
     */
    @Test
    public void testPage(){
        //参数一 当前页
        //参数二 页面大小
        Page<User> page = new Page<>(4,2);
        userMapper.selectPage(page,null);

        page.getRecords().forEach(System.out::println);
    }

    /**
     * 根据id删除记录
     */
    @Test
    public void testDeleteById(){
        userMapper.deleteById(1);
    }

    /**
     * 通过id批量删除
     */
    @Test
    public void testDeleteBatchIds(){
        userMapper.deleteBatchIds(Arrays.asList(1386535476197949442l,1386555943751286786l,1386560421682511874l));
    }

    /**
     * 通过map删除
     */
    @Test
    public void testDeleteByMap(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "Jack");
        userMapper.deleteByMap(map);
    }

}
