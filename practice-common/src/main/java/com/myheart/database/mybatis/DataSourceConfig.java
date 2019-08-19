package com.myheart.database.mybatis;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @author yangxin
 * @date 2019/8/6
 */
@Slf4j
@Configuration
@MapperScan(basePackages = "com.myheart.caiwu.mappers", sqlSessionFactoryRef = DataSourceConfig.SQL_SESSION_FACTORY_NAME)
public class DataSourceConfig {

    public static final String SQL_SESSION_FACTORY_NAME = "sessionFactoryCaiwu";


    @Primary
    @Bean(name = "dataSourcePropertiesCaiwu")
    @ConfigurationProperties(prefix = "spring.datasource.caiwu")
    public DataSourceProperties dataSourcePropertiesCaiwu() {
        return new DataSourceProperties();
    }

    @Bean(name = "datasourceCaiwu")
    @Primary
    public DataSource dataSourceCaiwu() {
        return dataSourcePropertiesCaiwu().initializeDataSourceBuilder().build();
    }


    @Bean(name = DataSourceConfig.SQL_SESSION_FACTORY_NAME)
    @Primary
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSourceCaiwu());
        return sqlSessionFactoryBean.getObject();
    }
}
