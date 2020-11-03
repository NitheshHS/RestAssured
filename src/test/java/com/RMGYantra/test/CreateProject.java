package com.RMGYantra.test;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProject {
	@Test
	public void createProjectTest() {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("projectId", "Ty_01");
		jsonObj.put("createdBy", "Nithesh");
		jsonObj.put("projectName", "MS Azure");
		jsonObj.put("status", "OnGoing");
		jsonObj.put("teamSize", 10);

		given()
			.contentType(ContentType.JSON)
			.body(jsonObj.toJSONString())
		.when()
			.post("http://localhost:8084/addProject")
		.then()
			.assertThat().contentType(ContentType.JSON)
			.and()
			.assertThat().statusCode(201)
			.and()
			.log().all();
			
		
		

	}

}
