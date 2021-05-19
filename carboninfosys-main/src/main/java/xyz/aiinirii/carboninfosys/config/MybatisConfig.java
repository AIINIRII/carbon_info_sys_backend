package xyz.aiinirii.carboninfosys.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Mybatis配置
 *
 * @author AIINIRII
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"xyz.aiinirii.carboninfosys.mapper", "xyz.aiinirii.carboninfosys.dao"})
public class MybatisConfig {
}