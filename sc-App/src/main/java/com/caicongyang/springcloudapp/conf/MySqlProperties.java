/**
 * caicongyang.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.caicongyang.springcloudapp.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 *
 * mysql数据库链接属性
 * @author caicongyang1
 * @version id: MySqlProperties, v 0.1 17/5/10 下午7:26 caicongyang1 Exp $$
 */
@Configuration
public class MySqlProperties {
    //主数据库连接
    @Value("${db.mysql.jdbcUrl}")
    private String  jdbcUrl;
    @Value("${db.mysql.username}")
    private String  username;
    @Value("${db.mysql.password}")
    private String  password;

    //数据库公共配置
    @Value("${db.mysql.driverClassName}")
    private String  driverClassName;
    @Value("${db.mysql.connectionTestQuery}")
    private String  connectionTestQuery;
    @Value("${db.mysql.connectionTimeoutMs}")
    private Long    connectionTimeoutMs;
    @Value("${db.mysql.idleTimeoutMs}")
    private Long    idleTimeoutMs;
    @Value("${db.mysql.maxLifetimeMs}")
    private Long    maxLifetimeMs;
    @Value("${db.mysql.maxPoolSize}")
    private Integer maxPoolSize;
    @Value("${db.mysql.minIdle}")
    private Integer minIdle;

    //事务超时
    @Value("${db.mysql.transactionTimeoutS}")
    private Integer transactionTimeoutS;

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getConnectionTestQuery() {
        return connectionTestQuery;
    }

    public void setConnectionTestQuery(String connectionTestQuery) {
        this.connectionTestQuery = connectionTestQuery;
    }

    public Long getConnectionTimeoutMs() {
        return connectionTimeoutMs;
    }

    public void setConnectionTimeoutMs(Long connectionTimeoutMs) {
        this.connectionTimeoutMs = connectionTimeoutMs;
    }

    public Long getIdleTimeoutMs() {
        return idleTimeoutMs;
    }

    public void setIdleTimeoutMs(Long idleTimeoutMs) {
        this.idleTimeoutMs = idleTimeoutMs;
    }

    public Long getMaxLifetimeMs() {
        return maxLifetimeMs;
    }

    public void setMaxLifetimeMs(Long maxLifetimeMs) {
        this.maxLifetimeMs = maxLifetimeMs;
    }

    public Integer getMaxPoolSize() {
        return maxPoolSize;
    }

    public void setMaxPoolSize(Integer maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
    }

    public Integer getMinIdle() {
        return minIdle;
    }

    public void setMinIdle(Integer minIdle) {
        this.minIdle = minIdle;
    }

    public Integer getTransactionTimeoutS() {
        return transactionTimeoutS;
    }

    public void setTransactionTimeoutS(Integer transactionTimeoutS) {
        this.transactionTimeoutS = transactionTimeoutS;
    }
}
