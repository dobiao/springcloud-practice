package com.caicongyang.springcloudapp.wushuaiping;

import com.caicongyang.springcloudapp.wushuaiping.proxy.cglib.CGLIBProxy;
import com.caicongyang.springcloudapp.wushuaiping.proxy.cglib.EmployeeServiceImpl;
import com.caicongyang.springcloudapp.wushuaiping.proxy.cglib.dto.Employee;

public class Main {
    public static void main(String[] args) {
        CGLIBProxy proxy = new CGLIBProxy();
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        EmployeeServiceImpl proxySer = (EmployeeServiceImpl)proxy.newInstance(employeeService);
        proxySer.insert(new Employee());
    }
}
