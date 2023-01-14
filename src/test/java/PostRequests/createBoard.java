package PostRequests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class createBoard {
    public static void main(String[] args) {

       RestAssured.baseURI= "https://api.trello.com";
        RequestSpecification request = RestAssured.given();
        request.basePath("/1/boards");
        request.queryParam("key","9a827ddc8b5e97d7f7ff2b1a9684e060");
        request.queryParam("token","ATTAabb42e2603c6f3ee6e15a071f93cb12551075678d093d6dcde76ca77d0ba2d7d13FEA226");

        request.queryParam("name","name");
        request.queryParam("id","63bdef947022810037ec3eb7");

        request.header("Content-Type","application/json");
        request.body("{ \"defaultLabels\": \"true\"," +
                "    \"defaultLists\": \"true\",    " +
                "\"desc\": \"A new description for the board\"," +
                "    \"keepFromSource\": \"cards\"," +
                "    \"powerUps\": \"calendar\"," +
                "    \"prefs_permissionLevel\": \"public\"," +
                "\"prefs_voting\": \"disabled\",    " +
                "\"prefs_comments\": \"disabled\",    " +
                "\"prefs_invitations\": \"members\",    " +
                "\"prefs_selfJoin\": \"true\",    " +
                "\"prefs_cardCovers\": \"true\",    " +
                "\"prefs_background\": \"blue\",    " +
                "\"prefs_cardAging\": \"regular\"}");
        Response response = request.post();
        response.prettyPrint();

        JsonPath path =response.jsonPath();
        String bordID = path.getString("id");
        System.out.println(bordID);

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200);;
    }
}
