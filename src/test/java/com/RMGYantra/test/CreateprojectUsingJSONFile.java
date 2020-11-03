package com.RMGYantra.test;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateprojectUsingJSONFile {
	
	@Test
	public void createProjectTest() throws IOException {
		
		File jsonFile=new File(".\\project.json");
		
		given()
			.contentType(ContentType.JSON)
			.body(jsonFile)
			 
			.when()
			.post("http://localhost:8084/addProject")
		.then()
			.log().all();
	}

}
