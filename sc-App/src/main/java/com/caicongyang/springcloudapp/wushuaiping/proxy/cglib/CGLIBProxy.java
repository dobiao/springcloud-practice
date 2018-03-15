package com.caicongyang.springcloudapp.wushuaiping.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 *  CGLIB动态代理
 * @author wushuaiping
 * @date 2018/3/14 下午10:50
 */
public class CGLIBProxy implements MethodInterceptor{

    private Object target;

    public Object newInstance(Object object){
        this.target = object;
        // 增强器
        Enhancer enhancer = new Enhancer();
        /* 生成被代理业务类(EmployeeServiceImpl)的子类;
         * 就是因为这里继承的关系，被代理业务类就不能使用final修饰。
         */
        enhancer.setSuperclass(this.target.getClass());
        // 被代理业务类所有方法都会通过这里来调用
        enhancer.setCallback(this);
        // 创建代理对象 这个是创建无参构造器代理对象的方式
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        // 去调用父类中的方法
        methodProxy.invokeSuper(o, objects);
        after();
        return null;
    }

    private void before(){
        System.out.println("操作前的日志记录~~");
    }

    private void after(){
        System.out.println("操作后的日志记录~~");
    }
}
