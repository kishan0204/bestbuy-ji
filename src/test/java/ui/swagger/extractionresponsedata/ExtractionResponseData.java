package ui.swagger.extractionresponsedata;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;
import ui.swagger.testbase.TestBase;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ExtractionResponseData extends TestBase {
    static ValidatableResponse response;


    @BeforeClass

    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        RestAssured.basePath = "/stores";
        response = given()
                .when()
                .get()
                .then().statusCode(200);

    }

    @Test
    public void test001() {
        int limit = response.extract().path("limit");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The limit of data is : " + limit);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test002() {
        int total = response.extract().path("total");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The total of data is : " + total);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test003() {
        String storename = response.extract().path("data[4].name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The total of data is : " + storename);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test004() {
        List<String> allname = response.extract().path("data.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The total of data is : " + allname);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test005() {
        List<HashMap<String, ?>> storeid = response.extract().path("data.services.storeservices.findAll{it.storeId}");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The productsName of storeId is : " + storeid);
        System.out.println("------------------End of Test---------------------------");

    }

    @Test
    public void test006() {
        int size = response.extract().path("data.size");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The size of data is : " + size);
        System.out.println("------------------End of Test---------------------------");
    }
    @Test
    public void test007() {
        List<HashMap<String, ?>> name = response.extract().path("data.findAll{it.name=='St Cloud'}");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("the value of the store where store name = St Cloud : " + name);
        System.out.println("------------------End of Test---------------------------");

    }
    @Test
    public void test008() {
        List<HashMap<String, ?>> address = response.extract().path("data.findAll{it.name=='Rochester'}.address");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The address is : " + address);
        System.out.println("------------------End of Test---------------------------");

    }
    @Test
    public void test009() {
        List<String> address = response.extract().path("data[7].services");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The name is : " + address);
        System.out.println("------------------End of Test---------------------------");

    }
    @Test
    public void test0010() {
        List<HashMap<String, ?>> storeService = response.extract().path("data.findAll{it.services}.findAll{it.name=='Windows Store'}.findAll{it.storeservices}.storeservices");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Get storeservices of the store where service name = Windows Store : " + storeService);
        System.out.println("------------------End of Test---------------------------");

    }
    @Test

    public void test0011() {
        List<?> storeId = response.extract().path("data.services.storeservices.findAll{it.storeId}.storeId");
        Iterator<?> itr =  storeId.iterator();
        while(itr.hasNext()) {
            // System.out.println(itr.next());
            List<?> check = (List<?>) itr.next();
            System.out.println("List of name of all stores id are : "+check.get(0));
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The productsName of storeId is : " + storeId);
        System.out.println("------------------End of Test---------------------------");
    }
    }
        @Test

    public void test0012() {
        List<Integer> storeid = response.extract().path("data.services.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The   storeId is : " + storeid);
        System.out.println("------------------End of Test---------------------------");
    }
    @Test
   public void test0013() {
        List<String> name = response.extract().path("data.findAll{it.state=='ND'}.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The name of  is : " + name);
        System.out.println("------------------End of Test---------------------------");
    }
    @Test
   public void test0014() {
        List<HashMap<String, ?>> address = response.extract().path("data.findAll{it.name=='Rochester'}.services.find{it.name}");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The address  is : " + address);
        System.out.println("------------------End of Test---------------------------");

    }
    @Test
   public void test0015() {
        List<String> storename = response.extract().path("data.find{it.services}.services.findAll{it.name=='Windows Store'}.storeservices.createdAt");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The services of store is : " + storename);
        System.out.println("------------------End of Test---------------------------");

    }
    @Test
   public void test0016() {
        List<String> allServicesWhereStoreNameIsFargo = response.extract().path("data.find{it.name = 'Fargo'}.services.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The all Services  Where Store Name  Is Fargo  : " + allServicesWhereStoreNameIsFargo);
        System.out.println("------------------End of Test---------------------------");

    }@Test
   public void test0017() {
        List<String> zip = response.extract().path("data.zip");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The all zip  : " + zip);
        System.out.println("------------------End of Test---------------------------");

    }
    @Test
   public void test0018() {
        List<Integer> zipList = response.extract().path("data.findAll{it.name=='Roseville'}.zip");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The all zipList  : " + zipList);
        System.out.println("------------------End of Test---------------------------");

    }
    @Test
   public void test0019() {
        List<String> storeservices = response.extract().path("data.services.faidAll{it.name=='Magnolia Home Theater'}.storeservices");
        System.out.println("------------------StartingTest--------------+-------------");
        System.out.println("The all storeservices  : " + storeservices);
        System.out.println("------------------End of Test---------------------------");

    }
    @Test
    public void test0020() {
        List<String> lat = response.extract().path("data.lat");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The all lat  : " + lat);
        System.out.println("------------------End of Test---------------------------");

    }
}
