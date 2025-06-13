package com.example;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.Assert;

public class PracticeApiTest {

    @Test
    public void testGetRequest() {
        // Define base URI and credentials
        String baseUrl = "https://your.api.url"; // replace with real base URL
        String path = "/your-endpoint";          // replace with actual path

        Response response = given()
                .baseUri(baseUrl)
                .auth().basic("username", "password")
                .header("Authorization", "Bearer your_token_here") // fixed typo in "Authorization"
                .when()
                .get(path)
                .then()
                .log().ifValidationFails()
                .extract()
                .response();

        int statusCode = response.getStatusCode();
        System.out.println("Status Code: " + statusCode);

        if (statusCode == 200) {
            String responseBody = response.getBody().asString();
            System.out.println("✅ Response Body:\n" + responseBody);

            // More detailed assertions using TestNG
            Assert.assertTrue(responseBody.contains("\"id\""), "Response should contain 'id'");
            Assert.assertTrue(responseBody.contains("\"name\""), "Response should contain 'name'");

            // Assertions using JSONPath (if applicable)
            Assert.assertEquals(response.jsonPath().getInt("id"), 1, "ID should be 1");
            Assert.assertNotNull(response.jsonPath().getString("name"), "Name should not be null");
            Assert.assertTrue(response.jsonPath().getString("name").length() > 0, "Name should not be empty");

        } else {
            System.err.println("❌ Failed with status code: " + statusCode);
            Assert.fail("API response returned non-200 status: " + statusCode);
        }
    }
}
