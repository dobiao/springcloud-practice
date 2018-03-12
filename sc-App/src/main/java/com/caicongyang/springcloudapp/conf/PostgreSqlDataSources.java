/**
 * caicongyang.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.caicongyang.springcloudapp.conf;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import com.zaxxer.hikari.HikariDataSource;

/**
 *
 * @author caicongyang1
 * @version id: PostgreSQLDataSources, v 0.1 17/8/10 下午7:21 caicongyang1 Exp $$
 */
@Configuration
@MapperScan(basePackages = "com.caicongyang.springcloudapp.dao.pg", sqlSessionFactoryRef = "pgSqlSessionFactory")
public class PostgreSqlDataSources {

    @Autowired
    private PostgreSqlProperties properties;

    @Bean(name = "pgDataSource")
    public DataSource getPgDataSource() {
        final HikariDataSource ds = new HikariDataSource();
        ds.setDriverClassName(properties.getDriverClassName());
        ds.setConnectionTestQuery(properties.getConnectionTestQuery());
        ds.setConnectionTimeout(properties.getConnectionTimeoutMs());
        ds.setIdleTimeout(properties.getIdleTimeoutMs());
        ds.setMaxLifetime(properties.getMaxLifetimeMs());
        ds.setMaximumPoolSize(properties.getMaxPoolSize());
        ds.setMinimumIdle(properties.getMinIdle());
        ds.setJdbcUrl(properties.getPgJdbcUrl());
        ds.setUsername(properties.getUsername());
        ds.setPassword(properties.getPassword());
        return ds;
    }

    /**
     * 数据源事务管理器
     *
     * @return
     */
    @Bean(name = "pgDataSourceTransactionManager")
    public DataSourceTransactionManager getTransactionManager(@Qualifier("pgDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * 编程式事务
     *
     * @return
     */
    @Bean(name = "pgTransactionTemplate")
    public TransactionTemplate getTransactionTemplate(@Qualifier("pgDataSourceTransactionManager") DataSourceTransactionManager pgDataSourceTransactionManager) {
        TransactionTemplate transactionTemplate = new TransactionTemplate();
        transactionTemplate.setTimeout(properties.getTransactionTimeoutS());
        transactionTemplate.setTransactionManager(pgDataSourceTransactionManager);
        return transactionTemplate;
    }

    /**
     * mybatis 的sessionFactory
     *
     * @return
     * @throws Exception
     */
    @Bean(name = "pgSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean(@Qualifier("pgDataSource") DataSource dataSource) throws Exception {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        //扫描mapper.xml
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:pg/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "pgSqlSessionTemplate")
    public SqlSessionTemplate getSqlSessionTemplate(@Qualifier("pgSqlSessionFactory") SqlSessionFactory factory) {
        return new SqlSessionTemplate(factory);
    }
}
