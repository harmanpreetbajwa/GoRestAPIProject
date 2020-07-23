package com.api.gorest.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.api.gorest.pojo.User;
import com.api.gorest.restclient.RestClient;

import io.restassured.response.Response;


public class CreateUsersTests {
	
	String baseURI="https://gorest.co.in/";
	String basePath="public-api/users";
	String token="NDRAvceI5NzFUwVcJw03PCVZxfgvnkGjVjdg";
	String contentType="json";
	Map<String, String> params = new HashMap<String,String>();
	


	@Test(priority=1)
	public void createUserTest() {
		User user= new User("rest","api","female","1872-8-13","api.rest1872@gmail.com","8976543210","https://google.com","123 Rue New Boulevard /n Toronto","active");
		Response response=RestClient.postCalls(contentType, baseURI, basePath, token, params, true, user);
		System.out.println("The Status Code for createUserTest() is : ----> "+ response.getStatusCode());
		response.prettyPrint();
	}
	
}
