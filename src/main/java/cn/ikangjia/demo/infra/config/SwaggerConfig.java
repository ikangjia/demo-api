package cn.ikangjia.demo.infra.config;

import cn.ikangjia.demo.infra.entity.DemoParam;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2022/6/1 17:39
 */
@EnableOpenApi
@Configuration
public class SwaggerConfig {
    private final DemoParam demoParam;

    public SwaggerConfig(DemoParam demoParam) {
        this.demoParam = demoParam;
    }

    @Bean
    public Docket api() {
        System.out.println("Swagger 访问地址： http://localhost:12001/swagger-ui/index.html#/");
        return new Docket(DocumentationType.OAS_30)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                demoParam.getTitle(),
                demoParam.getDescription(),
                demoParam.getVersion(),
                "林深时觉寒的个人工作室",
                new Contact(demoParam.getNetName(), demoParam.getHomepage(), demoParam.getEmail()),
                "License",
                "/",
                Collections.emptyList());
    }

}
