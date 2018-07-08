
package com.spring.boot.dataSource;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
@MapperScan(basePackages = "com.spring.boot.mapper.user", sqlSessionTemplateRef  = "userSqlSessionTemplate")
public class UserDataSourceConfigurer
{
	@Bean(name = "userDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.user")
    //@Primary 这个必须注释掉 more than one 'primary' bean found among candidates: [bookDataSource, userDataSource]
    public DataSource testDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "userSqlSessionFactory")
    //@Primary
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("userDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }

    @Bean(name = "userTransactionManager")
    //@Primary
    public DataSourceTransactionManager testTransactionManager(@Qualifier("userDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "userSqlSessionTemplate")
    //@Primary
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("userSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
