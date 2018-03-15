package com.caicongyang.springcloudapp.wushuaiping.proxy.jdk;

/**
 *  真实主题
 * @author wushuaiping
 * @date 2018/3/13 下午10:21
 */
public class RealSubject implements ISubject {

    public void enableCheck() {
        System.out.println("我开启了某项校验~~");
    }
}
