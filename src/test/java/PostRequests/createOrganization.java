package PostRequests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class createOrganization {

    public static void main(String[] args) {

        RestAssured.baseURI= "https://api.trello.com";
        RequestSpecification request = RestAssured.given();
        request.basePath("/1/organizations");
        request.queryParam("key","9a827ddc8b5e97d7f7ff2b1a9684e060");
        request.queryParam("token","ATTAabb42e2603c6f3ee6e15a071f93cb12551075678d093d6dcde76ca77d0ba2d7d13FEA226");

        request.header("Content-Type","application/json");
        request.body("{    \"displayName\": \"The name to display for the Organization\"," +
                "    \"desc\": \"The description for the organizations\", " +
                "   \"name\": \"Organization\",    \"website\": \"https://test.com\"}");
        Response response = request.post();
        response.prettyPrint();

        JsonPath path =response.jsonPath();
        String organizationID = path.getString("id");
        System.out.println(organizationID);

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200);;
    }
    createOrganization id = new createOrganization();
}
