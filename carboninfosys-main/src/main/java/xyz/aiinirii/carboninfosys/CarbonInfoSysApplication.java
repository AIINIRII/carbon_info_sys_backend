package xyz.aiinirii.carboninfosys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "xyz.aiinirii.carboninfosys")
public class CarbonInfoSysApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarbonInfoSysApplication.class, args);
    }

}
