package com.RMGYantra.test;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.mapper.ObjectMapperType;

public class CreateProjectUsingPojoClass {
	
	@Test
	public void createProjectTest() {
		
		Project proj=new Project("Larry Page", "03/10/1998", "TY_500", "Google", "Completed", 2);
		given()
			.body(proj,ObjectMapperType.JACKSON_1)
		.when()
			.post("http://localhost:8084/addProject")
		.then()
			.log().all();
			
	}

}
