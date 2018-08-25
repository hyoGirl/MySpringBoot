package com.spring.token.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

public class JwtUtil {
	
	//过期时间为一天
	private static final long EXPIRE_TIME=60*60*24*1000;
	
	
	private static final String SECRET="xulei  test";
	
	/**
	 * jwt由三部分构成：头部（header)、载荷（payload, )、签证（signature).
	 */
	//1:根据用户名和密码来生成token
	public static String createJwt(String name,String password) {
		
		//1:指定签名的时候使用的签名算法，也就是header那部分，jjwt已经将这部分内容封装好了。
		 SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		 Date date=new Date(System.currentTimeMillis()+EXPIRE_TIME);
		 long nowMillis = System.currentTimeMillis();//生成JWT的时间
		 
		 
		 /**
		  * 创建属于自己的私有声明
		  * //创建payload的私有声明（根据特定的业务需要添加，如果要拿这个做验证，一般是需要和jwt的接收方提前沟通好验证方式的）
		  */
		 Map<String,Object> claims = new HashMap<String,Object>();
	        claims.put("uid", "DSSFAWDWADAS...");
	        claims.put("user_name", "admin");
	        claims.put("nick_name","DASDA121");
		 
		 
//		 Jwts.builder()
		//如果有私有声明，一定要先设置这个自己创建的私有的声明，这个是给builder的claim赋值，
		 //一旦写在标准的声明赋值之后，就是覆盖了那些标准的声明的
//		 .claim(name, value)
		String compact = Jwts.builder()
		//.claim(name, value)
		/**
		 * 设置jti(JWT ID)：是JWT的唯一标识，根据业务需要，这个可以设置为一个不重复的值，
		 * 主要用来作为一次性token,从而回避重放攻击。
		 */
		.setClaims(claims)
		.setId(UUID.randomUUID().toString()) 
		.setIssuedAt(new Date(System.currentTimeMillis())) //签发时间
		/**
		 *sub(Subject)：代表这个JWT的主体，即它的所有人，这个是一个json格式的字符串，
		 * 可以存放什么userid，roldid之类的，作为什么用户的唯一标志。
		 */
		.setSubject(name)      
		.setIssuer("XULEI")    // 签发者
		.setAudience("xulei")  // 接受者
		.signWith(signatureAlgorithm, generateKey())  //设置签名使用的签名算法和签名使用的秘钥
		.setExpiration(date).compact();
		  
		return compact;
		
	}
	
	
	
	//2:由字符串生成加密key
	
	public static SecretKey generateKey() {
		/**
		 * 采用base64加密
		 */
		try {
			//对秘钥进行AES加密
//			String encodeToString = Base64.getEncoder().encodeToString(SECRET.getBytes("UTF-8"));
			SecretKey key = new SecretKeySpec(SECRET.getBytes(), 0, SECRET.length(), "AES");
			return key;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	//3:进行解析Jwt
	public  static Claims  parseJWT(String jwt) {
		Claims body=null;
		try {
			Jws<Claims> jws = Jwts.parser().setSigningKey(generateKey()).parseClaimsJws(jwt);
			body = jws.getBody();
			return body;
		} catch (ExpiredJwtException e) {
			//过期了
			e.printStackTrace();
		} catch (UnsupportedJwtException e) {
			e.printStackTrace();
		} catch (MalformedJwtException e) {
			e.printStackTrace();
		} catch (SignatureException e) {
			//签名失败了
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	//4:进行校验Jwt
	public  static boolean validateJWT(String jwt) {
		Claims claims = parseJWT(jwt);
		if(claims!=null) {
			return true;
		}
		return false;
	}
	
	
	
	
	
}
