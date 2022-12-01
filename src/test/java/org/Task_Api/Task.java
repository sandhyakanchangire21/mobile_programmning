package org.Task_Api;

import org.testng.annotations.Test;


import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
//import static org.hamcrest.Matches;



public class Task {

	@Test(priority=1)
	public void TC_GetRestFullBooker() {
		given().
		when().
		get("https://restful-booker.herokuapp.com/booking").
		then().statusCode(200);
	}
	@Test(priority=2)
	public void TC_PostRestFullBooker() {


		given().contentType("application/json").
		body("  -H 'Content-Type: application/json' \\\r\n"
				+ "  -d '{\r\n"
				+ "    \"firstname\" : \"Jim\",\r\n"
				+ "    \"lastname\" : \"Brown\",\r\n"
				+ "    \"totalprice\" : 111,\r\n"
				+ "    \"depositpaid\" : true,\r\n"
				+ "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2018-01-01\",\r\n"
				+ "        \"checkout\" : \"2019-01-01\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
				+ "}").when().post("https://restful-booker.herokuapp.com/booking").
		then();

	}
	@Test(priority=3)
	public void TC_verifyGetRestFullBooker() {
		given().
		when().
		get("https://restful-booker.herokuapp.com/booking/Jim");

	}
	@Test(priority=4)
	public void TC_updateRestFullBooker() {


		given().contentType("application/json").
		body("  -H 'Content-Type: application/json' \\\r\n"
				+ "  -d '{\r\n"
				+ "    \"firstname\" : \"sandhya\",\r\n"
				+ "    \"lastname\" : \"Kanchangire\",\r\n"
				+ "    \"totalprice\" : 111,\r\n"
				+ "    \"depositpaid\" : true,\r\n"
				+ "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2018-01-01\",\r\n"
				+ "        \"checkout\" : \"2019-01-01\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
				+ "}").when().put("https://restful-booker.herokuapp.com/booking/111").
		then().log().all();


	}
	@Test(priority=5)
	public void TC_deleteRestFullBooker() {
		given().
		when().
		delete("https://restful-booker.herokuapp.com/booking/111").
		then().statusCode(403);
	}
}
