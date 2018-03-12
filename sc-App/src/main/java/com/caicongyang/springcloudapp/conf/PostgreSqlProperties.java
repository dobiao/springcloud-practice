/**
 * caicongyang.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.caicongyang.springcloudapp.conf;

import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 *
 * pg数据库链接属性
 * @author caicongyang1
 * @version id: PostgreSQLProperties, v 0.1 17/5/10 下午7:26 caicongyang1 Exp $$
 */
@Configuration
@ConfigurationProperties(prefix = "db.pg")
public class PostgreSqlProperties {
    //据库连接
    @NotNull
    private String  pgJdbcUrl;
    @NotNull
    private String  username;
    @NotNull
    private String  password;

    //数据库公共配置
    @NotNull
    private String  driverClassName;
    @NotNull
    private String  connectionTestQuery;
    @NotNull
    private Long    connectionTimeoutMs;
    @NotNull
    private Long    idleTimeoutMs;
    @NotNull
    private Long    maxLifetimeMs;
    @NotNull
    private Integer maxPoolSize;
    @NotNull
    private Integer minIdle;

    //事务超时
    @NotNull
    private Integer transactionTimeoutS;

    public String getPgJdbcUrl() {
        return pgJdbcUrl;
    }

    public void setPgJdbcUrl(String pgJdbcUrl) {
        this.pgJdbcUrl = pgJdbcUrl;
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
