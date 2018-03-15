package com.caicongyang.springcloudapp.wushuaiping.factory;

/**
 * 数据库环境选择工厂类
 * @author wushuaiping
 * @date 2018/3/11 下午2:43
 */
public class ConnectionFactory {

    public static final String ENV = "env";

    public static final String PRE = "pre";

    public static final String PRO = "pro";

    /**
     * 选择连接数据库
     * @param env
     * @return true: 连接成功
     *         false: 连接未成功
     */
    public boolean connection(String env){
        DatabaseConnection databaseConnection;
        try {
            if (ENV.equals(env)){
                databaseConnection = new DailyConnection();
                databaseConnection.connection();
            }else if (PRE.equals(env)){
                databaseConnection = new PreConnection();
                databaseConnection.connection();
            }else if (PRO.equals(env)){
                databaseConnection = new ProConnection();
                databaseConnection.connection();
            }
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
