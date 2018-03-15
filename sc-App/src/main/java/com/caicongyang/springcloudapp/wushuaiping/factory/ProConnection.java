package com.caicongyang.springcloudapp.wushuaiping.factory;

/**
 * 连接线上环境数据库
 * @author wushuaiping
 * @date 2018/3/11 下午2:42
 */
public class ProConnection implements DatabaseConnection {
    public void connection() {
        // 连接线上环境数据库的逻辑
        System.out.println("线上环境连接成功...");
    }
}
