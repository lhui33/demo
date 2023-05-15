package com.kunke.logic.hall.config;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * <b>类名：</b><br>
 * <br>
 *
 * @author Charles
 * @version 2019/10/15
 */

@Configuration
@EnableTransactionManagement
@MapperScan("com.kunke.sanguo.dao")
public class MybatisPlusConfig {
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor page = new PaginationInterceptor();
        page.setDialectType("mysql");
        page.setCountSqlParser(new JsqlParserCountOptimize(true));

        return page;
    }

    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        // 开启乐观锁控制
        return new OptimisticLockerInterceptor();
    }
}
