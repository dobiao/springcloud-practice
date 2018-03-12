/**
 * caicongyang.com Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package com.caicongyang.springcloudapp.conf;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import com.zaxxer.hikari.HikariDataSource;

/**
 * mysql数据源
 *
 * @author caicongyang1
 * @version $Id: DataSources.java, v 0.1 2015年9月9日 下午8:38:33 caicongyang1 Exp $
 */
@Configuration
@MapperScan(basePackages = "com.caicongyang.springcloudapp.dao.mysql", sqlSessionFactoryRef = "mysqlSessionFactory")
public class MysqlDataSources {

    @Autowired
    private MySqlProperties properties;

    /**
     * mysql库数据源
     *
     * @return
     */
    @Primary
    @Bean(name = "mysqlDataSource")
    public DataSource getMysqlDataSource() {
        final HikariDataSource ds = new HikariDataSource();
        ds.setDriverClassName(properties.getDriverClassName());
        ds.setConnectionTestQuery(properties.getConnectionTestQuery());
        ds.setConnectionTimeout(properties.getConnectionTimeoutMs());
        ds.setIdleTimeout(properties.getIdleTimeoutMs());
        ds.setMaxLifetime(properties.getMaxLifetimeMs());
        ds.setMaximumPoolSize(properties.getMaxPoolSize());
        ds.setMinimumIdle(properties.getMinIdle());
        ds.setJdbcUrl(properties.getJdbcUrl());
        ds.setUsername(properties.getUsername());
        ds.setPassword(properties.getPassword());
        return ds;
    }

    /**
     * 数据源事务管理器
     */
    @Bean(name = "mysqlDataSourceTransactionManager")
    public DataSourceTransactionManager getTransactionManager(@Qualifier("mysqlDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * 编程式事务
     */
    @Bean(name = "mysqlTransactionTemplate")
    public TransactionTemplate getTransactionTemplate(@Qualifier("mysqlDataSourceTransactionManager") DataSourceTransactionManager manager) {
        TransactionTemplate transactionTemplate = new TransactionTemplate();
        transactionTemplate.setTimeout(properties.getTransactionTimeoutS());
        transactionTemplate.setTransactionManager(manager);
        return transactionTemplate;
    }

    /**
     * mybatis 的sessionFactory
     */
    @Bean(name = "mysqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean(@Qualifier("mysqlDataSource") DataSource dataSource) throws Exception {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        //扫描mapper.xml
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:mysql/*.xml"));

        return sqlSessionFactoryBean.getObject();
    }

}
