package com.caicongyang.springcloudapp.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *
 * @author caicongyang1
 * @version id: SwaggerConfig, v 0.1 16/4/22 下午4:12 caicongyang1 Exp $$
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${swagger.ui.enable}") //该配置项在配置中心管理
    private boolean environmentSpecificBooleanFlag;

    @Bean
    public Docket docketFactory() {
        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(new ApiInfo("接口文档", "SpingCloud web接口列表", "1.0", "", "", "", ""))
            .enable(Boolean.valueOf(environmentSpecificBooleanFlag));
    }
}
