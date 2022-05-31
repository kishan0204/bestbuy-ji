package ui.swagger.store;

import io.restassured.response.Response;
import org.junit.Test;
import ui.swagger.testbase.TestBase;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class TestGetStore extends TestBase {

    @Test
    public void getAllStoreInfo() {

        Response response = given()
                .header("Accept", "application/json")
                .header("Authorization", "Bearer 676752f1aff4d3454a6b5d48d8a061e510d5f9b0be7a732425eb747bfddcd826")
                .when()
                .get("/stores");
        response.then().statusCode(200);
        response.then().time(lessThan(3000l));
        response.prettyPrint();

    }
}