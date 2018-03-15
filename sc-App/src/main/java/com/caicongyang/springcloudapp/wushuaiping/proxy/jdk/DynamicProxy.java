package com.caicongyang.springcloudapp.wushuaiping.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *  使用Java的动态代理实现
 * @author wushuaiping
 * @date 2018/3/13 下午10:43
 */
public class DynamicProxy implements InvocationHandler {

    private Object target;

    public Object getProxyInstance(Object target){
        this.target = target;
        // 使用Java的获取代理实例方法来获取代理实例。。好绕啊。。反正就是获取代理实例-_-
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(), this);

    }
    // 增强, 调用目标方法
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        // 因为我们需要被增强的方法enableCheck是没有返回参数的，所以不需要返回值。
        // 如果有返回值 Object res = method.invoke(proxy, args); return res;就可以了
        method.invoke(target, args);
        after();
        return null;
    }

    private void before(){
        System.out.println("操作之前的日志记录~~");
    }

    private void after(){
        System.out.println("操作之后的日志记录~~");
    }
}
