package com.RMGYantra.test;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class CreateProjectUsingHashmap {
	
	@Test
	public void createProjectTest() {
		
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("projectId", "Ty_01");
		map.put("createdBy", "Allen");
		map.put("projectName", "Flipkart");
		map.put("status", "OnGoing");
		map.put("teamSize", 10);
		
		given()
			.contentType(ContentType.JSON)
			.body(map)
		.when()
			.post("http://localhost:8084/addProject")
		.then()
			.assertThat().contentType(ContentType.JSON)
			.and()
			.log().all();
	}

}
