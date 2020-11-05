package com.RMG.test;
/**
 * 
 * @author Nitheesha
 *
 */

import static io.restassured.RestAssured.given;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.RMG.genericLib.BaseAPIClass;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetAllProject extends BaseAPIClass{

	@Test
	public void getAllProjectTest() throws Throwable {
		test=reports.createTest("getAllProjectTest");
		Response res = given()
			.contentType(ContentType.JSON)
		.when()
			.get("/projects");
		res.then()
			.log().all();
		
		ArrayList<String> list = res.jsonPath().get("projectName");
		
		ArrayList<String> dBlist = dLIb.exceuteQuery("select * from project;", 4);
		
		Assert.assertEquals(list, dBlist);
		
		
	}
}
