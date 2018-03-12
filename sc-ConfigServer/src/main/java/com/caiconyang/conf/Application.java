package com.caiconyang.conf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Spring could conf程序主入口
 * @author Administrator
 *
 */
@SpringBootApplication
@EnableConfigServer
public class Application {
	public static void main(String[] args) {   
        SpringApplication.run(Application.class,args);   
    }   
}
