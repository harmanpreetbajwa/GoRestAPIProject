package com.api.gorest.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.api.gorest.restclient.RestClient;


import io.restassured.response.Response;

public class GetUsersTests extends RestClient {
	String baseURI="https://gorest.co.in/";
	String basePath="public-api/users";
	String token="NDRAvceI5NzFUwVcJw03PCVZxfgvnkGjVjdg";
	String contentType="json";
	String httpVerb="GET";
	Map<String, String> params = new HashMap<String,String>();
	
	/**
	 * String contentType,String baseURI,String basePath,
			String token,Map<String,String> params,boolean log
	 */

	@Test(priority=1,enabled=true)
	public void getCallTest() {
		Response response = getCalls(contentType,baseURI,basePath,token,params, true);
		System.out.println("The status code is : "+response.getStatusCode());
		response.body().prettyPrint();
		System.out.println("The status line is : ===> "+response.getStatusLine());
		System.out.println("The headers are: : ===> "+response.getHeaders());
		System.out.println("The header is : : ===> "+response.getHeader("Content-Type"));
		System.out.println("The success Value is : "+response.jsonPath().get("_meta.success"));
		
	}
//	@Test(priority=2)
//	public void getCallWithQueryParamsTest() {
//		params.put("first_name", "Woodrow");
//		params.put("gender", "male");
//		Response response = getCalls(contentType,baseURI, basePath, token, params, true);
//		System.out.println("The status code is : "+response.getStatusCode());
//		response.body().prettyPrint();
//		
//	}
	
}
