package com.example.skye.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * MyBatisPlus配置类
 */
@MapperScan("com.example.skye.mapper")
@Configuration
@EnableTransactionManagement
public class MyBatisPlusConfig {


    /**
     * 乐观锁插件（新版）
     * @return OptimisticLockerInnerInterceptor
     */
    @Bean
    public MybatisPlusInterceptor OptimisticLocker() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        return interceptor;
    }
    //这个是旧版
/*    @Bean
    public OptimisticLockerInnerInterceptor optimisticLockerInnerInterceptor(){
        return new OptimisticLockerInnerInterceptor();
    }*/

    /**
     * 分页插件
     * @return PaginationInnerInterceptor
     */
    @Bean
    public MybatisPlusInterceptor Pagination() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        //设置数据库类型
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));//如果配置多个插件,切记分页最后添加
        //interceptor.addInnerInterceptor(new PaginationInnerInterceptor()); 如果有多数据源可以不配具体类型 否则都建议配上具体的DbType
        return interceptor;
    }

    @Bean
    @Profile({"dev","test"})//配置dev开发，test测试环境开启
    public PerformanceInterceptor performanceInterceptor() {
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        performanceInterceptor.setMaxTime(100);//设置sql最大执行时间*ms，如果超过了则不执行
        performanceInterceptor.setFormat(true);//开启sql格式化
        return performanceInterceptor;
    }



}
