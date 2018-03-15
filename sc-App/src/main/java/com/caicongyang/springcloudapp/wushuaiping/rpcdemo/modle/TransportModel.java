package com.caicongyang.springcloudapp.wushuaiping.rpcdemo.modle;

import java.io.Serializable;

/**
 *  数据传输模型
 * @author wushuaiping
 * @date 2018/3/15 下午12:25
 */
public class TransportModel implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = -6338270997494457923L;

    //返回结果
    private Object result;
    //对象
    private Object object;
    //方法名
    private String methodName;
    //参数
    private Class<?>[] parameterTypes;

    private Object[] parameters;

    public void setParameterTypes(Class<?>[] parameterTypes) {
        this.parameterTypes = parameterTypes;
    }

    public Class<?>[] getParameterTypes() {
        return parameterTypes;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public Object getResult() {
        return result;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }
}
