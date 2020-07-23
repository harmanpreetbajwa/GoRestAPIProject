package com.api.gorest.restclient;

import java.util.Map;

import com.api.gorest.utils.TestUtil;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestClient {
	//1.
/**
 * This Class will be having all the http methods that will call the api's and having Generic methods
 * Map for path and query parameter
 */
	//2. - only this method is public
	public static Response getCalls(String contentType,String baseURI,String basePath,
			String token,Map<String,String> params,boolean log) {
		
		//4. Calling setBaseURI Method
		setBaseURI(baseURI);
		//9. Calling createRequest
		RequestSpecification request=createRequest(contentType,token,params,log);
		//12.
		Response response = getResponse("GET",request,basePath);
		return response;
	}
	
	//3. - to set BaseURI of API
	private static void setBaseURI(String baseURI) {
		RestAssured.baseURI=baseURI;
	}
	
	//5. create a Request
	private static RequestSpecification createRequest(String contentType,String token,Map<String,String> params,boolean log) {
		
		RequestSpecification request ;
		//LOG: --> If value is passed as true, then it will generate logs
		if(log) {
			 request = RestAssured.given().log().all();
		}
		else {
			// Not Generating Logs
			request = RestAssured.given();
		}
		
		//6. Passing Token --- > it can be null if has no token
		if(token!=null) {
			request.header("Authorization","Bearer "+token);
		}
		
		//7. Passing ParamsMAP
		
		if(!(params==null)) {
			request.queryParams(params);
		}
		
		//8. ContentType : ---> JSON,XML,TEXT
		if(contentType.equalsIgnoreCase("JSON")) {
			request.contentType(ContentType.JSON);
		}
		
		else if(contentType.equalsIgnoreCase("XML")) {
			request.contentType(ContentType.XML);
		}
		
		else if(contentType.equalsIgnoreCase("TEXT")) {
			request.contentType(ContentType.TEXT);
		}
		
		else {
			
		}
		return request; // everything is returning request
		
	}
	
	// 10. Hitting an API
	
	private static Response getResponse(String httpMethod,RequestSpecification request,String basePath) {
		return executeAPI(httpMethod,request,basePath);
		
		
	}
	
	//11. Executing API
	
	private static Response executeAPI(String httpMethod,RequestSpecification request,String basePath) {
		
		Response response = null;
	switch(httpMethod) {
	case "GET":
		response=request.get(basePath);
		break;
	case "POST":
		response=request.post(basePath);
		break;	
	case "PUT":
		response=request.put(basePath);
		break;	
	case "DELETE":
		response=request.delete(basePath);
		break;
		default:
			System.out.println("Please Enter a Valid HTTP Method");
	}
	return response;
			
	}
	
	public static Response postCalls(String contentType,String baseURI,String basePath,String token,Map<String,String> params,boolean log,Object obj) {
	
		setBaseURI(baseURI);
		RequestSpecification request = createRequest(contentType, token,params ,log);
		String payload = TestUtil.getSerialization(obj);
		request.body(payload);
		Response response = getResponse("POST",request,basePath);
		return response;
	}
	
	
}
