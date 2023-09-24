package com.mcs.logoengine.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class DatabaseConfig {
    private static final DataSource LogoengineConfig = DataSourceBuilder.create()
            .url("jdbc:mysql://localhost:3306/logoengine")
            .username("root")
            .password("root")
            .driverClassName("com.mysql.cj.jdbc.Driver")
            .build();

    public static JdbcTemplate NewJdbcTemplate(){
        return new JdbcTemplate(LogoengineConfig);
    }
}
