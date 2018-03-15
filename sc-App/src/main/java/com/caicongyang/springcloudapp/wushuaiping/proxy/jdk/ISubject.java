package com.caicongyang.springcloudapp.wushuaiping.proxy.jdk;

/**
 * 抽象主题。
 * @author wushuaiping
 * @date 2018/3/13 下午10:13
 */
public interface ISubject {

    /**
     *  比如现在有个业务功能，需要开启某项校验。
     */
    void enableCheck();
}
