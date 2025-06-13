package com.example;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.*;


public class ExtendedReport extends BaseTestForExtentReport {

    @BeforeClass
    public static void setup(){
        setupReport();
    }

      @Test
      public void testApiWithExtentReports() {
        startTest("API Test - Validate Response");

        given()
            .log().all()
            .baseUri("https://jsonplaceholder.typicode.com")
        .when()
            .get("/posts/1")
        .then()
            .log().all()
            .statusCode(200)
            .body("userId", equalTo(1));

        test.pass("API Response is valid.");
    }

    @AfterClass
    public void tearDown(){
        extent.flush();
    }

    
}
