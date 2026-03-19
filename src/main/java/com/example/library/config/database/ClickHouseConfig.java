package com.example.library.config.database;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class ClickHouseConfig {

    @Value("${clickhouse.url}")
    private String url;

    @Value("${clickhouse.user}")
    private String username;

    @Value("${clickhouse.password}")
    private String password;

    @Bean(name = "clickhouseDataSource")
    public DataSource clickhouseDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.clickhouse.jdbc.ClickHouseDriver");
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "clickhouseJdbcTemplate")
    public JdbcTemplate clickhouseJdbcTemplate(
            @Qualifier("clickhouseDataSource") DataSource ds) {
        return new JdbcTemplate(ds);
    }
}

