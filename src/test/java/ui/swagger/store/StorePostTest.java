package ui.swagger.store;

import io.restassured.response.Response;
import org.junit.Test;
import ui.swagger.model.StorePojo;
import ui.swagger.testbase.TestBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class StorePostTest extends TestBase {
    @Test
    public void createANewStore() {
        HashMap<Object,Object> services = new HashMap<>();
        services.put("id","9");
        services.put("name","Geek Squad Services");
        services.put("createdAt","2016-11-17T17:56:35.881Z");
        services.put("updatedAt","2016-11-17T17:56:35.881Z");

        StorePojo storePojo = new StorePojo();
        storePojo.setName("Ramesh");
        storePojo.setType("xyz");
        storePojo.setAddress("bunny");
        storePojo.setAddress2("123");
        storePojo.setCity("hgj");
        storePojo.setState("asd");
        storePojo.setZip("1234");
        storePojo.setLat(25.233);
        storePojo.setLng(25.2565);
        storePojo.setHours("Mon: 10-9; Tue: 10-9; Wed: 10-9; Thurs: 10-9; Fri: 10-9; Sat: 10-9; Sun: 10-8");
        storePojo.setServicess1(services);


        Response response = given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer 676752f1aff4d3454a6b5d48d8a061e510d5f9b0be7a732425eb747bfddcd826")
                .body(storePojo)
                .when()
                .post("/stores");
        response.then().statusCode(201);
        response.prettyPrint();


    }
}