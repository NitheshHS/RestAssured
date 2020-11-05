package com.RMG.genericLib;

import io.restassured.response.Response;

public class JsonUtils {
	
	public Object getJSONValue(Response res,String jsonPath) {
		
		Object value = res.jsonPath().get(jsonPath);
		return value;
	}

}
