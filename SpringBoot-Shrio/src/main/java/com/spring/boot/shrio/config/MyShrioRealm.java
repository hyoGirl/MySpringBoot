package com.spring.boot.shrio.config;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring.boot.shrio.mapper.UserMapper;
import com.spring.boot.shrio.pojo.User;
import com.spring.boot.shrio.service.UserService;

/**
 * 说明：自定义shrio的安全数据连接器，来实现shrio自己的权限验证
 * @author 徐磊
 * @time：2018年5月6日 下午4:59:34
 */
public class MyShrioRealm extends AuthorizingRealm{
	
	@Autowired
	private UserService userService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		
		return null;
	}

	/**
	 * 认证方法,认证服务器会把认证令牌在这里进行校验，
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		
		UsernamePasswordToken usernamePasswordToken=((UsernamePasswordToken)token);
		
		User user = userService.getUser(usernamePasswordToken.getUsername());
		
		if(null!=user){
			//参数1：用户对象，将来要放入session,数据库查询出来的用户
			//参数2：凭证（密码）：密码校验：校验的动作交给shiro
			//参数3:当前使用的Realm在Spring容器中的名字(bean的名字，自动在spring容器中寻找)

			SimpleAuthenticationInfo  authenticationInfo =new SimpleAuthenticationInfo(user, user.getPwd(), super.getName());
			//会自动抛出异常
			return authenticationInfo;
		}
		
		return null;
	}

}
