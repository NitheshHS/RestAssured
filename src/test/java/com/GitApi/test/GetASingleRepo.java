package com.GitApi.test;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;
import io.restassured.response.Response;

public class GetASingleRepo {
	
	@Test
	public void getSingleReposTest() {
		
		Response res = given()
			.baseUri("https://api.github.com")
			.pathParam("owner", "NitheshHS")
			.pathParam("repo", "RestFull")
			.auth()	
				.basic("NitheshHS", "nithesh@1998")
		.when()
			.get("/repos/{owner}/{repo}");
		res.then()
			.assertThat().body("owner.login",equalTo("NitheshHS"))
			.assertThat().body("owner.url",containsString("https://api.github.com"))
			.log().all()
			;
		
		String username = res.jsonPath().get("owner.login");
		System.out.println(username);
	}

}
