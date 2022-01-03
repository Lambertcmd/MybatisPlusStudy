package com.kuang.handle;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @ClassName MyMetObjectHandler
 * @Description TODO
 * @Author Lambert
 * @Date 2021/4/26 13:51
 * @Version 1.0
 **/
@Component//一定要将处理器加到IOC容器中
@Slf4j
public class MyMetObjectHandler implements MetaObjectHandler {

    //插入时的填充策略
    @Override
    public void insertFill(MetaObject metaObject) {
        //default MetaObjectHandler setFieldValByName(String fieldName, Object fieldVal, MetaObject metaObject)
        log.info("start insert fill....");

        this.setFieldValByName("createTime",new Date(),metaObject);
        this.setFieldValByName("updateTime",new Date(),metaObject);

    }

    //更新时的填充策略
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update  fill....");
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }
}
