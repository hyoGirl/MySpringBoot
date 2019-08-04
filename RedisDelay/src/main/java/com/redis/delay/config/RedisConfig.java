package com.redis.delay.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @Auther: xulei
 * @Date: 2019/7/19 0019 16:55
 * @Description:
 */
@Configuration
public class RedisConfig {


    @Value("${spring.redis.host: 127.0.0.1}")
    private String host;
    @Value("${spring.redis.port: 6379}")
    private int port;
    @Value("${spring.redis.timeout: 300}")
    private int timeout;
    @Value("${spring.redis.database: 0}")
    private int database;


    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setHostName(host);
        factory.setPort(port);
        factory.setTimeout(timeout);
        factory.setDatabase(database);

        return factory;
    }



    /**
     *
     * 说明：序列化
     */
	@Bean
	public RedisTemplate<String, Object> redisTemplate() {

		RedisTemplate<String, Object> template = new RedisTemplate<>();
		StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
		  //设置序列化Key的实例化对象
		template.setKeySerializer(stringRedisSerializer);

		template.setHashKeySerializer(stringRedisSerializer);


		Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(Object.class);

		ObjectMapper objectMapper = new ObjectMapper();

		objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);

		objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);

		jackson2JsonRedisSerializer.setObjectMapper(objectMapper);

		template.setDefaultSerializer(jackson2JsonRedisSerializer);

		template.setConnectionFactory(jedisConnectionFactory());

		template.afterPropertiesSet();

		return template;
	}




}
