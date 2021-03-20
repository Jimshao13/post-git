package com.post.db.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;//导入springfox里的Contact
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author 邵鹏泽
 * @create 2021-03-11:26
 */
@Configuration
@EnableSwagger2//开启Swagger配置扫描
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {//创建Docket文档
        return new Docket(DocumentationType.SWAGGER_2)//采用SWAGGER_2规范
                .pathMapping("/")
                .select()
                //扫描那个接口的包
                .apis(RequestHandlerSelectors.basePackage("com.post.db.controller"))
                .paths(PathSelectors.any())
                .build().apiInfo(new ApiInfoBuilder()
                        //接口文档的标题
                        .title("post项目接口文档")
                        //接口文档的描述
                        .description("post后台接口文档，采用SpringBoot整合Swagger")
                        //版本信息
                        .version("2.0")
                        //联系人，联系方式
                        .contact(new Contact("邵鹏泽","www.baizhiedu.xin","18805196853@163.com"))
                        .license("The Baizhi License")//规范，没有可以不写
                        .licenseUrl("http://www.baizhiedu.com")
                        .build());
    }
}