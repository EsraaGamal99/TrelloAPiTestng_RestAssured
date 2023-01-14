package PostRequests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class createList {
    public static void main(String[] args) {

        RestAssured.baseURI= "https://api.trello.com";
        RequestSpecification request = RestAssured.given();
        request.basePath("/1/lists");
        request.queryParam("key","9a827ddc8b5e97d7f7ff2b1a9684e060");
        request.queryParam("token","ATTAabb42e2603c6f3ee6e15a071f93cb12551075678d093d6dcde76ca77d0ba2d7d13FEA226");

        request.queryParam("name","Listname");
        request.queryParam("idBoard","63bdfae51a020e00fd18c22f");

        request.header("Content-Type","application/json");
        request.body("{    \"name\": \"Name for the list\",    \"pos\": \"top\"}");

        Response response = request.post();
        response.prettyPrint();

        JsonPath path =response.jsonPath();
        String listID = path.getString("id");
        System.out.println(listID);

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200);;

        //ListID=63bdfb3301007701ab0ec4f1
    }
}
