package com.kuang.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName User
 * @Description TODO
 * @Author Lambert
 * @Date 2021/4/26 11:29
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    //对应数据库的主键（uuid、自增id、雪花算法、redis、zookepper）
    private Long id;

    private String name;

    private Integer age;

    private String email;

    //字段添加填充内容
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @Version//代表这是一个乐观锁
    private Integer version;

    @TableLogic//逻辑删除
    private Integer deleted;
}
