package com.caicongyang.springcloudapp.wushuaiping.factory;

/**
 *  定义一个连接数据库的接口。
 * @author wushuaiping
 * @date 2018/3/11 下午2:09
 */
public interface DatabaseConnection {
    /**
     *  传入需要链接的数据库环境。
     */
    void connection();
}
