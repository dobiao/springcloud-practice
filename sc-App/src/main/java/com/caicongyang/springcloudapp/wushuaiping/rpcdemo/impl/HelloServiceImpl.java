package com.caicongyang.springcloudapp.wushuaiping.rpcdemo.impl;

import com.caicongyang.springcloudapp.wushuaiping.rpcdemo.api.HelloService;

import java.io.Serializable;

/**
 * 
 * @author wb-yejiadong
 *
 */
public class HelloServiceImpl implements Serializable, HelloService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 203100359025257718L;

	/**
	 * 
	 */
	public String sayHello(String str) {
		System.out.println("执行方法体,入参=" + str);
		return str;
	}

}
