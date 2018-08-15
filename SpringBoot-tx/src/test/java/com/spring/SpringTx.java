package com.spring;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class SpringTx {
	
	public static void main(String[] args) {
		
		
		RestTemplate restTemplate=new RestTemplate();
		
		
	    //headers
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("Content-Type", "application/octet-stream");
        requestHeaders.add("Authorization", "kwoKJtiVmW7IO2ak%2B6ckX0mWc2U%3D");
        
//        kwoKJtiVmW7IO2ak%2B6ckX0mWc2U%3D
        
        
        //body
        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
        requestBody.add("roundid", "1");
        //HttpEntity
        HttpEntity<MultiValueMap> requestEntity = new HttpEntity<MultiValueMap>(requestBody, requestHeaders);
        //post
        ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://xxx", requestEntity, String.class);
        System.out.println(responseEntity.getBody());

		
		
		
	}

}
