package com.caicongyang.springcloudapp.wushuaiping.proxy.cglib;

import com.caicongyang.springcloudapp.wushuaiping.proxy.cglib.dto.Employee;

/**
 * 人员信息服务
 * @author wushuaiping
 * @date 2018/3/14 下午10:44
 */
public class EmployeeServiceImpl {
    public void insert(Employee employee){
        System.out.println("我调用了业务方法往数据库插入了一条数据~");
    }
}
