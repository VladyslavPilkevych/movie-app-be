package org.example.movieapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.Objects;

@Configuration
public class DataSourceConfiguration {
    @Autowired
    Environment env;

    @Bean
    public DataSource dataSource(){
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(Objects.requireNonNull(env.getProperty("driverClassName")));
        dataSource.setUrl(Objects.requireNonNull(env.getProperty("url")));
        return dataSource;
    }
//    @Bean
//    public DataSource dataSource(){
//        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        try {
//            dataSource.setDriverClassName("org.sqlite.JDBC");
//            dataSource.setUrl("jdbc:sqlite:MovieApp.db");
//            return dataSource;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
}