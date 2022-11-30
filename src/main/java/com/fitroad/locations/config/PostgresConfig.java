package com.fitroad.locations.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class PostgresConfig {

    @Value("${datasource.postgres.driver}")
    private String driverClassName;
    @Value("${datasource.postgres.url}")
    private String url;
    @Value("${datasource.postgres.username}")
    private String username;
    @Value("${datasource.postgres.password}")
    private String password;
    @Value("${datasource.postgres.liquibase.changelog}")
    private String changelog;
    @Value("${datasource.postgres.hikari.connectionTimeout}")
    private Long connectionTimeout;
    @Value("${datasource.postgres.hikari.initFailTimeout}")
    private Long initFailTimeout;
    @Value("${datasource.postgres.hikari.maximumPoolSize}")
    private Integer maximumPoolSize;

    @Bean
    public SpringLiquibase liquibase() {
        SpringLiquibase springLiquibase = new SpringLiquibase();
        springLiquibase.setChangeLog(changelog);
        springLiquibase.setDataSource(dataSource());
        return springLiquibase;
    }

    @Bean(name = "postgres")
    public DataSource dataSource() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName(driverClassName);
        hikariConfig.setJdbcUrl(url);
        hikariConfig.setUsername(username);
        hikariConfig.setPassword(password);
        hikariConfig.setConnectionTimeout(connectionTimeout * 1_000);
        hikariConfig.setInitializationFailTimeout(initFailTimeout * 1_000);
        hikariConfig.setMaximumPoolSize(maximumPoolSize);
        return new HikariDataSource(hikariConfig);
    }
}
