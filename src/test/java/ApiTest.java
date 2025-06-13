import com.example.*;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ApiTest {
    @Test(groups="smoke")
    @Description("Test to validate JSONPlaceholder API response")
    @Severity(SeverityLevel.CRITICAL)
    @Step("Sending GET request to fetch a post")
  
    public void testGetRequest() {
        given().baseUri("https://jsonplaceholder.typicode.com")
        .when().get("/posts/1")
        .then()
            .statusCode(200)
            .body("id", equalTo(1))
            .body("userId", equalTo(1));
    }
}
