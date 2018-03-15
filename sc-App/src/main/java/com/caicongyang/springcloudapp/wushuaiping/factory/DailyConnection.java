package com.caicongyang.springcloudapp.wushuaiping.factory;

/**
 *  这是连接日常数据库的接口
 * @author wushuaiping
 * @date 2018/3/11 下午2:34
 */
public class DailyConnection implements DatabaseConnection {
    public void connection() {
        // 这里是连接日常数据库的相关逻辑
        System.out.println("日常环境连接成功....");
    }
}
