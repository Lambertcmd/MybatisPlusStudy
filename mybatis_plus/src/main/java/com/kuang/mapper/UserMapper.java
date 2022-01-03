package com.kuang.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kuang.pojo.User;
import org.springframework.stereotype.Repository;

/**
 *
 * MybatisPlus能在Mapper上面实现基本的接口
 * Mapper继承BaseMapper
 *
 *
 * @ClassName UserMapper
 * @Description TODO
 * @Author Lambert
 * @Date 2021/4/26 11:32
 * @Version 1.0
 **/
@Repository //持久层
public interface UserMapper extends BaseMapper<User> {
    //所有的CRUD操作已经编写完成了
}
