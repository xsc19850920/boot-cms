package com.vigekoo.config;

import javax.sql.DataSource;

//import com.vigekoo.common.datasource.DataSourceNames;
//import com.vigekoo.common.datasource.DynamicDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;

/**
 * @author sxia
 * @Description: TODO(配置多数据源)
 * @date 2017-6-23 15:07
 */
@Configuration
public class DynamicDataSourceConfig {

    @Bean
//    @ConfigurationProperties("spring.datasource.druid.first")
    @ConfigurationProperties("spring.datasource.druid")
    public DataSource firstDataSource(){
        return DruidDataSourceBuilder.create().build();
    }

//    @Bean
//    @Primary
//    public DynamicDataSource dataSource(DataSource firstDataSource) {
//        Map<String, DataSource> targetDataSources = new HashMap<>();
//        targetDataSources.put(DataSourceNames.FIRST, firstDataSource);
//        return new DynamicDataSource(firstDataSource, targetDataSources);
//    }

}
