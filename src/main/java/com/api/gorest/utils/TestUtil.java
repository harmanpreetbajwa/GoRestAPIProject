package com.api.gorest.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestUtil {

	public static String getSerialization(Object obj) {
		ObjectMapper mapper = new ObjectMapper();
		String jsonString=null;
		try {
			jsonString=mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonString;
		
	}
}
