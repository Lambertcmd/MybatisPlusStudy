package com.kuang;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;

/**
 * @ClassName KuangCode
 * @Description TODO
 * @Author Lambert
 * @Date 2021/4/28 8:57
 * @Version 1.0
 **/
public class KuangCode {
    public static void main(String[] args) {
        //需要构建一个代码生成器对象
        AutoGenerator mpg = new AutoGenerator();

        //配置策略

        //1、全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath+"/src/main/java");//获取目录
        gc.setAuthor("lzb");//作者
        gc.setOpen(false);//打开文件
        gc.setFileOverride(false);//是否覆盖
        gc.setServiceName("%sService");//去掉Service的I前缀
        gc.setIdType(IdType.ID_WORKER);



    }
}
