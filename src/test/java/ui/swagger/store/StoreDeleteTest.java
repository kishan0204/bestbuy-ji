package ui.swagger.store;

import io.restassured.response.Response;
import org.junit.Test;
import ui.swagger.testbase.TestBase;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class StoreDeleteTest extends TestBase {


    @Test
    public void deleteSingleStoreInfo() {
        Response response = given()
                .pathParam("id", "7")
                .when()
                .delete("/stores/{id}");
        response.then().statusCode(200);
        response.then().time(lessThan(5000L));
        response.prettyPrint();
    }
}