package com.spring.session.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.CookieHttpSessionStrategy;
import org.springframework.session.web.http.DefaultCookieSerializer;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionStrategy;

@Configuration  
@EnableRedisHttpSession  
public class RedisSessionConfig {
	
	@Bean
    public HttpSessionStrategy httpSessionStrategy() {
        return new HeaderHttpSessionStrategy();
    }
	
	
	@Value("${spring.redis.host}")
	private String host;
	@Value("${spring.redis.port}")
	private int port;
	@Value("${spring.redis.timeout}")
	private int timeout;
	@Value("${spring.redis.database}")
	private int database;
//	@Value("${spring.redis.password}")
//	private String password;

	/**
	 * 连接redis的工厂类
	 * @return
	 */
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
//	@Bean
//	public RedisTemplate<String, Object> redisTemplate() {
//
//		RedisTemplate<String, Object> template = new RedisTemplate<>();
//
//		StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
//		  //设置序列化Key的实例化对象
//		template.setKeySerializer(stringRedisSerializer);
//
//		template.setHashKeySerializer(stringRedisSerializer);
//
//
//
//		Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(Object.class);
//
//		ObjectMapper objectMapper = new ObjectMapper();
//
//		objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//
//		objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//
//		jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
//
//		template.setDefaultSerializer(jackson2JsonRedisSerializer);
//
//		template.setConnectionFactory(jedisConnectionFactory());
//
//		template.afterPropertiesSet();
//
//		return template;
//	}

	@Bean(name="redisTemplate")
	public RedisTemplate<Object, Object> redisTemplate(JedisConnectionFactory factory) {
		RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(factory);

		// 使用Jackson2JsonRedisSerialize 替换默认序列化
		Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);

		jackson2JsonRedisSerializer.setObjectMapper(objectMapper);

		// 设置value的序列化规则和 key的序列化规则
		redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
		redisTemplate.setKeySerializer(new StringRedisSerializer());

		redisTemplate.setHashKeySerializer(new StringRedisSerializer());
		redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);

		redisTemplate.afterPropertiesSet();
		return redisTemplate;
	}

	@Bean(name="stringRedisTemplate")
	public StringRedisTemplate stringRedisTemplate(JedisConnectionFactory factory) {
		StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
		stringRedisTemplate.setConnectionFactory(factory);

		// 使用Jackson2JsonRedisSerialize 替换默认序列化
		Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);

		jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
		stringRedisTemplate.setKeySerializer(jackson2JsonRedisSerializer);
		stringRedisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
		return stringRedisTemplate;
	}



	
	 /**
     * 采用RedisCacheManager作为缓存管理器
     * @param redisTemplate
     * @return
     */
    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate) {
        RedisCacheManager rcm = new RedisCacheManager(redisTemplate);
        // 多个缓存的名称,目前只定义了一个
        //rcm.setCacheNames(Arrays.asList("test"));
        //设置缓存过期时间(秒)
        rcm.setDefaultExpiration(600);
        
        return rcm;
        
    }
    
    //设置cookie
    @Bean
    public CookieHttpSessionStrategy cookieHttpSessionStrategy(){
        CookieHttpSessionStrategy strategy=new CookieHttpSessionStrategy();
        DefaultCookieSerializer cookieSerializer=new DefaultCookieSerializer();
        cookieSerializer.setCookieName("MYSESSIONID");//cookies名称
        cookieSerializer.setCookieMaxAge(1800);//过期时间(秒)
        strategy.setCookieSerializer(cookieSerializer);
        return strategy;
    }

}
