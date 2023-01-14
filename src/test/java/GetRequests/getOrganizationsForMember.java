package GetRequests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class getOrganizationsForMember {

    public static void main(String[] args) {
        RestAssured.baseURI= "https://api.trello.com";
        RequestSpecification request = RestAssured.given();
        request.basePath("/1/members/625c2b41f1540034ce4d28b1/organizations");
        request.queryParam("key","9a827ddc8b5e97d7f7ff2b1a9684e060");
        request.queryParam("token","ATTAabb42e2603c6f3ee6e15a071f93cb12551075678d093d6dcde76ca77d0ba2d7d13FEA226");

        Response response = request.get();
        response.prettyPrint();

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200);

    }
}
