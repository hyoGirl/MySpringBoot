
package com.spring.boot.dataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.TypeHandler;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.spring.boot.mapper.book", sqlSessionTemplateRef  = "bookSqlSessionTemplate")
public class BookDataSourceConfigurer
{
	@Bean(name = "bookDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.book")
    @Primary
    public DataSource testDataSource() {

        return DataSourceBuilder.create().build();

    }

    @Bean(name = "bookSqlSessionFactory")
    @Primary
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("bookDataSource") DataSource dataSource) throws Exception {
    	//获取session工厂
    	SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
    	//设置数据源
        bean.setDataSource(dataSource);

        // 设置配置路径
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));


        //获取具体的session
        return bean.getObject();
    }

    @Bean(name = "bookTransactionManager")
    @Primary
    public DataSourceTransactionManager testTransactionManager(@Qualifier("bookDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "bookSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("bookSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
