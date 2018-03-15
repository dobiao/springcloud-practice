package com.caicongyang.springcloudapp.wushuaiping.singleton;

/**
 *  保证lazy load并且保证线程安全还兼顾了效率的单例模式，懒汉式单例
 * @author wushuaiping
 * @date 2018/3/10 上午9:17
 */
public class Singleton {

    private static Singleton singleton = null;

    private Singleton(){}

    public static Singleton getSingleton(){
        if (singleton == null){
            synchronized(Singleton.class){
                if (singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
