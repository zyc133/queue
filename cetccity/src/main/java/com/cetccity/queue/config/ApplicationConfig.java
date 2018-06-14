//package com.cetccity.queue.config;
//
//import javax.sql.DataSource;
//
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//
//import com.alibaba.druid.pool.DruidDataSource;
//
//@ComponentScan
//@Configuration
//@ConfigurationProperties(prefix="spring.datasource")
//public class ApplicationConfig {
//
//    private String url;
//    private String username;
//    private String password;
//
//    @Bean
//    public DataSource getDataSource() {
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setUrl(url);
//        dataSource.setUsername(username);// 用户名
//        dataSource.setPassword(password);// 密码
//        return dataSource;
//    }
//}
