package com.GitApi.test;

import org.hamcrest.Matcher;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class GetTocken {
	@Test
	public void getTockenTest() {
		
		Response res = given()
			.formParam("client_id", "GetAllTockenTest")
			.formParam("client_secret", "e4323e73b0d4aa54bee0b4ff67334fba")
			.formParam("grant_type", "client_credentials")
		.when()
			.post("http://coop.apps.symfonycasts.com/token");
		
		System.out.println(res.timeIn(TimeUnit.MILLISECONDS));
		String token=res.jsonPath().get("access_token");
		System.out.println(token);
		
		
		given()
			.baseUri("http://coop.apps.symfonycasts.com")
			.auth()
				.oauth2(token)
			.pathParam("USER_ID", "1301")
		.when()
			.post("/api/{USER_ID}/eggs-count")
		.then()
			.assertThat().contentType(ContentType.JSON)
			.and()
			.assertThat().statusCode(200)
			.assertThat().statusLine("HTTP/1.1 200 OK")
			.log().all();
		
	}

}
