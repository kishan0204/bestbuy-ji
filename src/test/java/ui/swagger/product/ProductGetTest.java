package ui.swagger.product;

import io.restassured.response.Response;
import org.junit.Test;
import ui.swagger.testbase.TestBase;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class ProductGetTest extends TestBase {

    @Test
    public void getAllProductsInformation() {
        Response response = given()
                .header("Accept", "application/json")
                .header("Authorization", "8bc13c20a8ab19fdf152065554a0e38e1545013fd1c3feb811568f9a151005f7")
                .when()
                .get("/products");
        response.then().statusCode(200);
        response.then().time(lessThan(5000L));
        response.prettyPrint();
    }

    @Test
    public void getSingleProductInfo() {
        Response response = given()
                .pathParam("id",43900)
                .when()
                .get("/products/{id}");
        response.then().statusCode(200);
        response.then().time(lessThan(5000L));
        response.prettyPrint();
    }
}