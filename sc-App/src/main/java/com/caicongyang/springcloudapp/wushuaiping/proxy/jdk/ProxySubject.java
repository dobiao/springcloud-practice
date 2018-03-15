package com.caicongyang.springcloudapp.wushuaiping.proxy.jdk;

/**
 *  代理类
 * @author wushuaiping
 * @date 2018/3/13 下午10:23
 */
public class ProxySubject implements ISubject{

    private ISubject subject;

    public ProxySubject(ISubject subject){
        super();
        this.subject = subject;
    }

    // 对被代理对象的方法进行增强
    public void enableCheck() {
        after();
        subject.enableCheck();
        before();
    }

    private void before(){
        System.out.println("我记录一下启动校验前的相关日志。");
    }

    private void after(){
        System.out.println("我记录一下启动校验后的相关日志");
    }
}
