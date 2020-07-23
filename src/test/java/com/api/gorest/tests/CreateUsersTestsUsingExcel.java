package com.api.gorest.tests;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.api.gorest.pojo.User;
import com.api.gorest.restclient.RestClient;
import com.api.gorest.utils.Excelutil;

import io.restassured.response.Response;


public class CreateUsersTestsUsingExcel {
	
	String baseURI="https://gorest.co.in/";
	String basePath="public-api/users";
	String token="NDRAvceI5NzFUwVcJw03PCVZxfgvnkGjVjdg";
	String contentType="json";
	
	@DataProvider
	public Object[][] getUserExcelData() {
		Object userData[][]= Excelutil.getPayload("UserData");
		return userData;
		
	}
	
	@Test(priority=1,dataProvider="getUserExcelData")
	public void createUserExcelTest(String firstname,String lastname,String gender,String dob,String email,String phoneNumber,String website,String address,String status) {
		User user= new User(firstname,lastname,gender,dob,email,phoneNumber,website,address,status);
		Response response=RestClient.postCalls(contentType, baseURI, basePath, token, null, true, user);
		System.out.println("The Status Code for createUserTest() is : ====> "+ response.getStatusCode());
		response.prettyPrint();
		System.out.println("=======================================================================================>");
	}
	
}
