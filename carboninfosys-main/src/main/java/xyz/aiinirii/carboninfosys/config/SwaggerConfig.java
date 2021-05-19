package xyz.aiinirii.carboninfosys.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import xyz.aiinirii.carboninfosys.common.config.BaseSwaggerConfig;
import xyz.aiinirii.carboninfosys.common.domain.SwaggerProperties;

/**
 * @author AIINIRII
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig {

    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("xyz.aiinirii.carboninfosys.controller")
                .title("carbon information system backend")
                .description("carbon information system 后端系统相关API文档")
                .version("1.0")
                .contactName("AIINIRII")
                .contactEmail("aiinirii@163.com")
                .contactUrl("https://www.aiinirii.xyz")
                .enableSecurity(true)
                .build();
    }
}