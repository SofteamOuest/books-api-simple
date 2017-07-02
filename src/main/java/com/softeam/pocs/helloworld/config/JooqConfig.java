package com.softeam.pocs.helloworld.config;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * Created by elkouhen on 08/11/16.
 */
@Configuration
public class JooqConfig {

    @Value("${spring.datasource.driverClassName:org.postgresql.Driver}")
    private String driverClassName;

    @Value("${spring.datasource.url:jdbc:postgresql://postgres/postgres}")
    private String url;

    @Value("${spring.datasource.username:postgres}")
    private String user;

    @Value("${spring.datasource.password:mysecretpassword}")
    private String password;

    @Bean
    public DataSourceConnectionProvider dataSourceConnectionProvider() {
        return new DataSourceConnectionProvider(dataSource());
    }

    private DataSource dataSource() {

        DriverManagerDataSource driver = new DriverManagerDataSource();

        driver.setDriverClassName(driverClassName);
        driver.setUrl(url);
        driver.setUsername(user);
        driver.setPassword(password);

        return driver;
    }

    @Bean
    public DefaultConfiguration defaultConfiguration() {
        DefaultConfiguration defaultConfiguration = new DefaultConfiguration();
        defaultConfiguration.setConnectionProvider(dataSourceConnectionProvider());
        defaultConfiguration.setSQLDialect(SQLDialect.POSTGRES);
        return defaultConfiguration;
    }

    @Bean
    public DSLContext dslContext() {
        return new DefaultDSLContext(defaultConfiguration());
    }
}