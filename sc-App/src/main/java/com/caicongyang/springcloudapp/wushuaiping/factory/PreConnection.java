package com.caicongyang.springcloudapp.wushuaiping.factory;

/**
 *  连接预发环境数据库
 * @author wushuaiping
 * @date 2018/3/11 下午2:39
 */
public class PreConnection implements DatabaseConnection {
    public void connection() {
        // 连接预发环境数据库的逻辑代码
        System.out.println("预发环境连接成功...");
    }
}
