package com.spring.boot.shrio.config;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShrioConfig {
	
	//开启shrio的配置过滤器
	@Bean
	public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager){
		
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		
		
		//拦截器.
		Map<String,String> filterChainDefinitionMap = new LinkedHashMap<String,String>();
		
		//配置不需要授权认证的链接
		filterChainDefinitionMap.put("/static/**", "anon");
		
		//配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
		filterChainDefinitionMap.put("/logout", "logout");
		
		//配置所有的页面都需要认证登陆才可以使用，默认情况下，如果都匹配不了，就走这个登陆认证，然后就去login页面
		filterChainDefinitionMap.put("/**", "authc");
		
		//配置登陆页面
		shiroFilterFactoryBean.setLoginUrl("/login");
		
		//配置登陆成功跳转页面
		shiroFilterFactoryBean.setSuccessUrl("/index");
		
		
		//未授权界面;
		shiroFilterFactoryBean.setUnauthorizedUrl("/403");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return shiroFilterFactoryBean;
		
	}
	
	
	/**
	 * 说明：配置安全数据连接器
	 * @return
	 * @author 徐磊
	 * @time：2018年5月6日 下午5:05:28
	 */
	@Bean
	public MyShrioRealm getRealm(){
		return new MyShrioRealm();
	}
	
	
	/**
	 * 说明：配置shrio的安全管理器
	 * @return
	 * @author 徐磊
	 * @time：2018年5月6日 下午5:07:52
	 */
	@Bean
	public SecurityManager securityManager(){
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		
		securityManager.setRealm(getRealm());
		
		return securityManager;
	}
	
	 //加入注解的使用，不加入这个注解不生效
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
}
